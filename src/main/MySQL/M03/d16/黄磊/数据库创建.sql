
#创建LIbrary数据库
CREATE DATABASE Library;
#创建BOOK表
CREATE TABLE book(
       bid INT(10) COMMENT '图书编号' PRIMARY KEY AUTO_INCREMENT,
       bName VARCHAR(200) COMMENT '书名',
       aurter VARCHAR(200) COMMENT '坐着姓名',
       PubComp VARCHAR(200)COMMENT '出版社',
       pubDate DATE COMMENT '出版日期',
       cCount INT(10) COMMENT '现存数量',
       price FLOAT(200,6) COMMENT '单价'
);

SELECT * FROM book;
#添加信息
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('1','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('2','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('3','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('4','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('5','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('6','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('7','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('8','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('9','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);
INSERT INTO book(bid,bName,aurter,PubComp,PubDate,cCount,price) VALUES ('10','追风筝的人','黄磊','不知道','2012-12-21',2,2.111);



#创建READER表
CREATE TABLE reader(
       rid INT(10) COMMENT '读者编号' PRIMARY KEY,
       rName VARCHAR(200) COMMENT '读者姓名',
       lendName INT(10) COMMENT '借书数量',
       rAddress VARCHAR(200) COMMENT '联系地址'
);

#添加信息
INSERT INTO reader(rid,rName,lendName,rAddress) VALUES (1,'黄磊',2,'湖北武汉市');
SELECT * FROM reader;



#创建borrow表
CREATE TABLE borrow(
       rid VARCHAR(200) COMMENT '读者编号',
       nif VARCHAR(200) COMMENT '图书编号',
       lendDate DATE COMMENT '借阅日期',
       willDate DATE COMMENT '应归还日期',
        returnDate DATE COMMENT '实际归还日期',
        PRIMARY KEY (rid,nif,lendDate)
);

#添加信息
INSERT INTO borrow(rid,nif,lendDate,willDate,returnDate) VALUES ('1','001','2012-3-5','2013-3-7','2013-5-4');
SELECT * FROM borrow;



#创建penalty表
CREATE TABLE penalty(
       rid VARCHAR(200) COMMENT '读者编号',
       bid VARCHAR(200) COMMENT '图书编号',
       pDate DATE COMMENT '罚款日期',
       pType INT(10) COMMENT '罚款类型',
       amount FLOAT(10.3) COMMENT '罚款金额',
        PRIMARY KEY (rid,bid,pDate)
);

#添加信息
INSERT INTO penalty(rid,bid,pDate,pType,amount) VALUES ('1','001','2012-3-5',10,9.3);
SELECT * FROM penalty;


#分页查询
SELECT bid,bName,aurter,PubComp,PubDate,cCount,price
FROM book
ORDER BY bid
LIMIT 3;