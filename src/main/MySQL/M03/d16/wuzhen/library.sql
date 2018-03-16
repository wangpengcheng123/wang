CREATE DATABASE library;
CREATE TABLE `book` (
  `bid` VARCHAR(20) NOT NULL COMMENT '图书编号',
  `bname` VARCHAR(20) NOT NULL COMMENT '图书书名',
  `author` VARCHAR(20) DEFAULT NULL COMMENT '作者姓名',
  `pubComp` VARCHAR(100) DEFAULT NULL COMMENT '出版社',
  `pubDate` DATE DEFAULT NULL COMMENT '出版日期',
  `bCount` INT(100) DEFAULT NULL COMMENT '现存数量',
  `price` FLOAT(10,1) DEFAULT NULL COMMENT '单价'
)
SELECT * FROM book;
CREATE TABLE reader(#读者信息表
rid VARCHAR(10) PRIMARY KEY NOT NULL COMMENT '读者编号',
rName VARCHAR(10) COMMENT '读者姓名',
lendNum INT(5) COMMENT '已借书数量',
rAddress VARCHAR(20) COMMENT '联系地址'
)
SELECT * FROM reader;

CREATE TABLE IF NOT EXISTS borrow(#图书借阅表
rid VARCHAR(10) NOT NULL COMMENT '读者编号',
nif VARCHAR(10) NOT NULL COMMENT '图书编号',
lendDate TIMESTAMP COMMENT'借阅日期',
willDate DATE COMMENT '应归还日期',
returnDate DATE COMMENT '实际归还日期',
PRIMARY KEY(rid,nif,lendDate)
)
SELECT * FROM borrow;
CREATE TABLE penalty(#罚款记录表
rid VARCHAR(10) NOT NULL COMMENT '读者编号',
bid VARCHAR(20) NOT NULL COMMENT '图书编号',
pDate DATE NOT NULL COMMENT '罚款日期',
pType INT(1) COMMENT '罚款类型,1-延期，2-损坏，3-丢失',
amount FLOAT(10) COMMENT '罚款金额',
 PRIMARY KEY(rid,bid,pDate)
)