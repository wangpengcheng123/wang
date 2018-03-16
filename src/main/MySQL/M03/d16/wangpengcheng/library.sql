#创建数据库
CREATE DATABASE library;
#创建图书信息表 Book
ALTER  DATABASE library CHARACTER SET utf8;
USE library;
DROP TABLE Book;
USE library;
CREATE TABLE Book(
BID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '图书编号',
BName VARCHAR(50) NOT NULL  COMMENT '图书书名',
author VARCHAR(10) COMMENT '作者姓名',
PubComp VARCHAR(50) COMMENT '出版社',
PubDate DATE COMMENT '出版日期',
BCount INT COMMENT '现存数量',
Price FLOAT COMMENT '单价'

);

#向Book中添加BTotal列
#语法 alter table 表名 add 要添加的数据和类型
ALTER TABLE Book ADD BTotal INT COMMENT '总藏量';
INSERT INTO Book SET BID=2,BName='龙族',
Author='江南', PubComp='不知' ,PubDate='2018-03-10',	
BCount=10000,Price=100;

#查询表中的数据 *查询所有 1=1永远为真，都会显示出来
SELECT * FROM Book WHERE 1=1;



#创建读者信息表
CREATE TABLE Reader(
RID INT NOT NULL PRIMARY KEY COMMENT '读者编号',
RName VARCHAR(10) NOT NULL COMMENT '读者姓名',
LendNum INT COMMENT '以借出的数量',
RAddress VARCHAR(100) COMMENT '联系地址'
);
#向表中插入数据，操作语句前面不能有空格
INSERT INTO Reader(RID,RName,LendNum,RAddress) VALUES(1,'汪鹏程',666,'北大青鸟');
INSERT INTO Reader(RID,RName,LendNum,RAddress) VALUES(2,'李四',999,'北大青鸟');
SELECT RID,RName FROM Reader WHERE 1=1;

#创建图书借阅表Borrow ruturnDate字段中的默认值为null
CREATE TABLE Borrow(
RID INT NOT NULL COMMENT '读者编号',
BID INT NOT NULL COMMENT '图书编号',
LendDate DATE DEFAULT '2018-03-10' NOT NULL COMMENT '借阅日期',
WillDate DATE COMMENT '应归还日期',
returnDate DATE DEFAULT NULL COMMENT '实际归还日期',
PRIMARY KEY(RID,BID,LendDate)

);


INSERT INTO Borrow(RID,BID,LendDate,WillDate,returnDate) VALUES(1,1,'2018-03-09','2019-06-06','2018-03-10');
INSERT INTO Borrow(RID,BID,LendDate,WillDate,returnDate) VALUES(2,2,'2018-03-06','2019-06-09','2018-03-11');
SELECT * FROM Borrow WHERE 1=1;




#创建罚款记录表Penalty
CREATE TABLE Penalty(
RID INT NOT NULL COMMENT '读者编号',
BID INT NOT NULL COMMENT '图书编号',
PDate DATE DEFAULT '2018-03-10' NOT NULL COMMENT '罚款日期',
PType INT(3) COMMENT '罚款类型，1-延期，2-损坏，3-丢失',
Amount FLOAT COMMENT '罚款金额' ,
PRIMARY KEY(RID,BID,PDate)

);
INSERT INTO Penalty SET RID=1,BID=1,PDate='2017-03-10',PType=1,Amount=100;
INSERT INTO Penalty SET RID=2,BID=2,PDate='2017-03-11',PType=1,Amount=200;
SELECT * FROM Penalty WHERE 1=1;


USE library;
SHOW TABLES;
SELECT * FROM borrow;
SELECT * FROM book;
SELECT * FROM reader;
#传统连接查循borrow中的数据 where中要是一个boolean 值
SELECT reader.`RName`,book.`BName` FROM reader,book WHERE reader.`RID`=1 AND book.`BID`=1
#union是一个连接符 用来连接查询的数据的
UNION
SELECT reader.`RName`,book.`BName` FROM reader,book WHERE reader.`RID`=2 AND book.`BID`=2;

#内连接
#选择要查询的数据，要查询的数据存在几个表中，找出和那几个表相关联的表 然后找出和关联的表的数据相等的值
SELECT rd.`RName`,bk.`BName` FROM reader rd INNER JOIN borrow bw ON rd.`RID`=bw.`RID`
INNER JOIN book bk ON bk.`BID`=bw.`BID`;

#分页

CREATE TABLE student(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '学生编号',
userName VARCHAR(20) NOT NULL COMMENT '学生姓名',
gender CHAR(2) DEFAULT '男' COMMENT '性别'
);
#追加学生
DELIMITER //
CREATE PROCEDURE addstudent(IN j INT)
BEGIN 
	DECLARE i INT;
	SET i=0;

	WHILE i<j   DO
	INSERT INTO student(userName,gender) VALUES('汪鹏程','男');
	SET i=i+1;
	END WHILE;
END//
DELIMITER ;
#调用存储过程
CALL addstudent(10);
SELECT * FROM student;
SELECT COUNT(id) FROM student;
DROP PROCEDURE limitDemo;
#创建存储过程
USE library;
DELIMITER //
CREATE PROCEDURE limitDemo(IN num1 INT ,IN num2 INT)
BEGIN
	DECLARE result INT;
	SET result=(SELECT COUNT(id) FROM student);
	WHILE num1<result DO
		SELECT * FROM student LIMIT num1,num2;
		SET num1=num1+num2;
	END WHILE;

END//
DELIMITER ;
 
CALL limitDemo(0,3); 
