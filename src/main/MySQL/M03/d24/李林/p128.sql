INSERT INTO reader(rid,rname,lennum,raddress)
VALUES('0009','张无忌',3,'武汉');

SELECT * FROM reader;
SELECT * FROM book;
SELECT * FROM borrow;

SELECT COUNT(*) FROM borrow WHERE rid='0009' GROUP BY rid,nif;

#3.为读者“张无忌”办理借阅《西游记》书籍的手续
BEGIN;
#图书减少
UPDATE book SET bcount = bcount
-(SELECT COUNT(*) FROM borrow WHERE rid='0009' GROUP BY rid,nif)
WHERE bid=(SELECT nif FROM borrow WHERE rid='0009');
#读者借阅增加
UPDATE reader SET lennum = lennum
+(SELECT COUNT(*) FROM borrow WHERE rid='0009' GROUP BY rid,nif)
WHERE rid=(SELECT rid FROM borrow WHERE rid='0009');
COMMIT;



#4.编码实现读者“刘冰冰”缴纳罚金归还图书的手续，要求一次完成；
BEGIN;
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate)
VALUES('0008','0007','2017-08-22','2018-01-22','2018-02-22');
UPDATE borrow SET returndate=NOW() WHERE rid = '0008';
UPDATE reader SET lennum=lennum-1 WHERE rid='0008';
UPDATE book SET bcount=bcount+1 WHERE bid='0007';
COMMIT;


#5.
#创建索引
CREATE INDEX ix_bname ON book(bname);

DROP VIEW vw_manager_02;
#创建图书管理员视图
CREATE VIEW vw_manager_02
AS
	SELECT
	(SELECT bname FROM book WHERE b.nif=bid) AS 图书名称,
	MAX(willdate) AS 到期日期,
	(SELECT rname FROM reader WHERE b.rid=rid) AS 读者姓名
	FROM borrow b
	WHERE willdate<NOW()
	AND returndate IS NULL;

#获取图书管理员视图
SELECT * FROM vw_manager_02;

#创建读者视图
CREATE VIEW vw_reader_01
AS
	/*select
	(select bname from book where bid=b.nif) as 图书名称,
	(SELECT bcount FROM book WHERE bid=b.nif) as 馆存量,
	((SELECT bcount FROM book WHERE bid=b.nif)-count(*)) AS 可借阅数量
	from borrow b
	group by nif;*/
	
	SELECT
	bname AS 图书名称,
	bcount AS 馆存量,
	(bcount-(
	  SELECT COUNT(*) FROM borrow WHERE nif=b.`bid`
	   AND returndate IS NULL
	   GROUP BY nif	
	)) AS 可借阅数量
	FROM book b;

#获取读者视图
SELECT * FROM vw_reader_01;


