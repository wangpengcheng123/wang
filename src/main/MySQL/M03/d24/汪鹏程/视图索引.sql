SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM penalty;
SELECT * FROM reader;
INSERT INTO reader SET rname='张无忌', lennum=2,raddress='横须贺';
DELETE FROM reader WHERE rname='张无忌'
DELETE FROM borrow WHERE nif='0006' AND rid='0009';
INSERT INTO reader SET rid='0009', rname='张无忌', lennum=2,raddress='横须贺';
INSERT INTO borrow SET 

START TRANSACTION;
INSERT INTO reader SET rid='0009', rname='张无忌',lennum=2,raddress='横须贺';
INSERT INTO borrow SET rid='0009',nif='0006',lenddate=NOW(),willdate=ADDDATE(NOW(),30),returndate=NULL;
UPDATE book SET bcount=bcount-1 WHERE bid='0006';
COMMIT;
START TRANSACTION;
INSERT INTO 

#张无忌借了一本书，是西游记，
BEGIN;
INSERT INTO borrow SET rid='0010',nif='0006',lenddate=NOW(),willdate='2018-11-09 17:27:35',returndate=NULL;
UPDATE book SET bcount=bcount-1 WHERE bid='0001';
INSERT INTO reader SET rid='0010',rname='张无忌',lennum=1,raddress='来自金庸小说';
COMMIT;


SELECT*FROM borrow
#刘冰冰还书了
BEGIN;
INSERT INTO penalty SET rid='0008',bid='0007',pdate=NOW(),ptype=1,amount=4.6;
UPDATE borrow SET returndate=NOW()  WHERE rid='0008';
UPDATE reader SET lennum=lennum-1  WHERE rid='0008';
UPDATE book SET bcount=bcount+1  WHERE bid='0008';
COMMIT;



#建图书名称创建索引
CREATE INDEX index_bname ON book(bname);
#管理员
CREATE VIEW vw_guanliyuan
AS
SELECT
(SELECT willdate FROM borrow WHERE b.`bid`=nif) AS 到期日期,
(SELECT rname FROM reader WHERE rid IN (SELECT rid FROM borrow WHERE willdate<NOW() AND returndate IS NULL)) AS 读者姓名,
 bname AS 书名 FROM book b WHERE bid IN (
SELECT nif FROM borrow WHERE willdate<NOW() AND returndate IS NULL
)

#管理员查看师视图
SELECT *FROM vw_guanliyuan;

#读者
CREATE VIEW vw_reader 
AS
SELECT  bname AS 书名,bcount AS 馆存量 ,
(SELECT bcount-COUNT(*)FROM borrow WHERE nif=b.bid )AS 可借阅本书
FROM book b 
#读者查看师视图
SELECT *FROM vw_reader;




