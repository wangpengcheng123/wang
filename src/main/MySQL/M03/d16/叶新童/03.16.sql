CREATE DATABASE Librarys;
#-----------------图书信息表book-------------------------
CREATE TABLE book
(	
	#图书编号
	bid VARCHAR(10) NOT NULL PRIMARY KEY COMMENT '图书编号',
	#图书书名
	bName VARCHAR(20) NOT NULL COMMENT '图书书名',
	#作者姓名 
	author VARCHAR(10) COMMENT '作者姓名',
	#出版社
	pubComp VARCHAR(50) COMMENT '出版社',
	#出版日期
	pubDate DATETIME COMMENT '出版日期',
	#现存数量
	bCount INT COMMENT '现存数量',
	#单价
	price DECIMAL(5,2) COMMENT '单价'
)
#添加
INSERT INTO book(bid,bName,author) VALUE('1','武动乾坤','天蚕土豆');
INSERT INTO book(bid,bName,author) VALUE('2','斗破苍穹','天蚕土豆');
INSERT INTO book(bid,bName,author) VALUE('3','大主宰','天蚕土豆');
#删除
DROP TABLE book;
#查看
SELECT 
  bid AS 图书编号,
  bName AS 图书书名,
  author AS 作者姓名,
  pubComp AS 出版社,
  pubDate 出版日期 ,
  bCount AS 现存数量,
  price AS 单价
FROM
  book ;

#-----------------读者信息表reader-------------------------
CREATE TABLE reader
(
	#读者编号
	rid VARCHAR(10) NOT NULL PRIMARY KEY COMMENT '读者编号',
	#读者姓名
	rName VARCHAR(20) NOT NULL COMMENT '读者姓名',
	#已借书数量
	lendNum INT COMMENT '已借书数量',
	#联系地址
	rAddress VARCHAR(50) COMMENT '联系地址'
	
)
#添加
INSERT INTO reader(rid,rName,lendNum,rAddress) VALUE ('1','林动','3','湖北省襄阳市襄州区二胡村');
INSERT INTO reader(rid,rName) VALUE ('2','萧炎');
INSERT INTO reader(rid,rName) VALUE ('3','牧尘');
#查看
SELECT 
  rid AS 读者编号,
  rName AS 读者姓名,
  lendNum AS 已借书数量,
  rAddress AS 联系地址 
FROM
  reader ;
# 删除
DROP TABLE reader;

#-----------------图书借阅表borrow-------------------------
CREATE TABLE borrow
(
	#读者编号
	rid VARCHAR(10) NOT NULL COMMENT '读者编号',
	#图书编号
	nif VARCHAR(10) NOT NULL COMMENT '图书编号',
	#借阅时间
	lendDate DATETIME COMMENT '借阅时间',
	#应归还日期
	willDate DATETIME COMMENT '应归还时间',
	#实际归还日期
	returnDate DATETIME COMMENT '实际归还时间',
	PRIMARY KEY(rid,nif,lendDate)
)
#添加
INSERT INTO borrow SET rid='1',nif='1',lendDate=(SELECT NOW());
INSERT INTO borrow SET rid='2',nif='2',lendDate=(SELECT NOW());
INSERT INTO borrow SET rid='3',nif='3',lendDate=(SELECT NOW());
#查看
SELECT 
  rid AS 读者编号,
  nif AS 图书编号,
  lendDate AS 借阅时间,
  willDate AS 应归还日期,
  returnDate AS 实际归还日期 
FROM
  borrow ;
#删除
DROP TABLE borrow;
#-----------------罚款记录表penaltey-------------------------
CREATE TABLE penalty
(
	rid VARCHAR(10) NOT NULL COMMENT '读者编号',
	bid VARCHAR(10) NOT NULL COMMENT '图书编号',
	pDate DATETIME NOT NULL COMMENT '罚款日期',
	pType INT COMMENT '罚款类型：1-延期，2-损坏，3-丢失',
	amount DECIMAL(5,2) COMMENT '罚款金额',
	PRIMARY KEY(rid,bid,pDate)
) 
#添加
INSERT INTO penalty SET rid='2',bid='2',pDate='2018-03-18';
#查看
SELECT 
  rid AS 读者编号,
  bid AS 图书编号,
  pDate AS 罚款日期,
  pType AS 罚款类型,
  amount AS 罚款金额 
FROM
  penalty ;

#删除
DROP TABLE penalty;
 
#-----------------分页-------------------------
USE librarys;
CREATE TABLE limitDemo
(
	id VARCHAR(20)
)
INSERT INTO limitDemo SET id='1';	
INSERT INTO limitDemo SET id='2';
INSERT INTO limitDemo SET id='3';
INSERT INTO limitDemo SET id='4';
INSERT INTO limitDemo SET id='5';
INSERT INTO limitDemo SET id='6';
INSERT INTO limitDemo SET id='7';
INSERT INTO limitDemo SET id='8';
INSERT INTO limitDemo SET id='9';
INSERT INTO limitDemo SET id='10';
DROP TABLE limitDemo;
SELECT * FROM limitDemo LIMIT 0,3;
SELECT * FROM limitDemo LIMIT 3,3;
SELECT * FROM limitDemo LIMIT 6,3;
SELECT * FROM limitDemo LIMIT 9,3;
 