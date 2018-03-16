CREATE DATABASE library;
#图书信息表
CREATE TABLE book(
	bid VARCHAR(50) NOT NULL PRIMARY KEY,#图书编号，主键，非空
	bName VARCHAR(200) NOT NULL COMMENT '图书书名',
	author VARCHAR(200) COMMENT '作者姓名',
	pubComp VARCHAR(200) COMMENT '出版社', 
	pubDate DATE COMMENT '出版日期',
	bCount INT COMMENT '现存数量',
	price FLOAT(5) COMMENT '单价'
)
#读者信息表
CREATE TABLE reader(
	rid VARCHAR(50) NOT NULL COMMENT '读者编号' PRIMARY KEY,
	rName VARCHAR(100) COMMENT '读者姓名' NOT NULL,
	lendNum INT COMMENT '已借书数量',
	rAddress VARCHAR(255) COMMENT '联系地址'	
)
`borrow`
#罚款记录表
CREATE TABLE penalty(
	rid VARCHAR(50) COMMENT '读者编号' NOT NULL,
	bid VARCHAR(50) COMMENT '图书编号' NOT NULL,
	pDate DATE COMMENT '罚款日期' NOT NULL,
	pType INT COMMENT '罚款类型，1-延期，2-损坏，3-丢失',
	amount FLOAT COMMENT '罚款金额',
	PRIMARY KEY(rid,bid,pDate)
)
