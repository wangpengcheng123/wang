#为读者‘张无忌’办理借阅《红楼梦》书籍的手续
SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM reader;
BEGIN;
INSERT INTO borrow VALUES('005','001','2018-3-24','2018-3-26',NULL);
INSERT INTO reader VALUES('005','张无忌','1','书里面');
UPDATE book SET bcount=bcount-1 WHERE bname='红楼梦';
UPDATE reader SET lendnum=lendnum+1 WHERE rName='张无忌';
COMMIT;

#实现读者“刘冰冰”缴纳罚金归还图书的手续，要求一次完成以下功能。
BEGIN;
INSERT INTO reader VALUES('006','刘冰冰',1,'中国');
INSERT INTO penalty VALUES('006','001','2018-03-16',1,5);
INSERT INTO borrow VALUES('006','001','2018-03-01','2018-03-15','2018-03-18');
UPDATE borrow SET returnDate='2018-3-25' WHERE rid='006';
UPDATE book SET bcount=bcount+1 WHERE bname='红楼梦';
UPDATE reader SET lendnum=lendnum-1 WHERE rname='刘冰冰';
COMMIT;
#为图书馆管理员和读者分别创建不同的查询视图，并利用所创建的索引和视图获得相关的数据
CREATE INDEX in_bname ON book(bname);
SHOW INDEX FROM book;
#创建图书馆管理员视图(图书名称，到期日期，读者姓名)
CREATE VIEW vw_manager AS 
SELECT 
  bname AS 图书名称,
  willdate AS 到期日期,
  rname AS 读者姓名 
FROM
  borrow bw 
  LEFT JOIN book bk 
    ON bw.nif = bk.bid 
  LEFT JOIN reader r 
    ON bw.rid = r.rid 
WHERE DATEDIFF(bw.willdate, NOW()) < 0 
ORDER BY bw.willdate DESC ;

#创建读者视图(图书名称，馆存量，可借阅数量)
CREATE VIEW vi_reader AS 
SELECT 
  bname AS 图书名称,
  bcount AS 馆存量,
  bcount - COUNT(*) AS 可借阅数量 
FROM
  book bk 
  INNER JOIN borrow bw 
    ON bk.bid = bw.nif 
  LEFT JOIN reader r 
    ON bw.rid = r.rid 
GROUP BY bw.nif 
UNION
SELECT 
  bname AS 图书名称,
  bcount AS 馆存量,
  bcount AS 可借阅数量 
FROM
  book bk 
WHERE NOT EXISTS 
  (SELECT 
    nif 
  FROM
    borrow bw 
  WHERE bk.bid = bw.nif) ;

