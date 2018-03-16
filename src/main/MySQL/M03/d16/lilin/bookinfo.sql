CREATE DATABASE Library;

#创建图书信息表book
CREATE TABLE book
(
    bid VARCHAR(200) PRIMARY KEY NOT NULL COMMENT '图书编号',
    bName VARCHAR(200) NOT NULL COMMENT '图书书名',
    author VARCHAR(200) COMMENT '作者姓名',
    pubComp VARCHAR(200) COMMENT '出版社',
    pubDate DATETIME COMMENT '出版日期',
    bCount INT COMMENT '现存数量',
    price DOUBLE COMMENT '单价'
)
DROP TABLE book;
INSERT INTO book VALUES('001','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('002','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('003','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('004','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('005','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('006','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('007','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('008','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('009','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);
INSERT INTO book VALUES('010','斗破苍穹','天蚕土豆','中国第一出版社','2016-03-16',36,36.5);


#创建读者信息表reader
CREATE TABLE reader
(
    rid VARCHAR(200) PRIMARY KEY NOT NULL COMMENT '读者编号',
    rName VARCHAR(200) NOT NULL COMMENT '读者姓名',
    lendNum INT COMMENT '已借书数量',
    rAddress VARCHAR(200) COMMENT '联系地址'
)
DROP TABLE reader;
INSERT INTO reader VALUES('1501','李林',15,'湖北仙桃');



#创建图书借阅表borrow
CREATE TABLE borrow
(
    rid VARCHAR(200) NOT NULL COMMENT '读者编号',
    nif VARCHAR(200) NOT NULL COMMENT '图书编号',
    lendDate TIMESTAMP COMMENT '借阅日期',
    PRIMARY KEY(rid,nif,lendDate),
    willDate DATETIME COMMENT '应归还日期',
    returnDate DATETIME COMMENT '实际归还日期'
)
DROP TABLE borrow;




#惩罚记录表penalty
CREATE TABLE penalty
(
  rid VARCHAR(200) NOT NULL COMMENT '读者编号',
  bid VARCHAR(200) NOT NULL COMMENT '图书编号',
  pDate DATETIME NOT NULL COMMENT '罚款日期',
  PRIMARY KEY(rid,bid,pDate),
  pType INT COMMENT '罚款类型:1-延期，2-损坏，3-丢失',
  amount DOUBLE COMMENT '罚款金额'
)



#分页显示
SELECT * FROM book LIMIT 3;
SELECT * FROM book LIMIT 4,3;
SELECT * FROM book LIMIT 7,3;
SELECT * FROM book LIMIT 9,3;