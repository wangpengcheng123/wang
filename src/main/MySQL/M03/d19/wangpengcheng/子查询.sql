SELECT * FROM student;
SELECT sex,COUNT(*) AS 人数,gradeId FROM student GROUP BY gradeId,sex HAVING COUNT(*)>1 ORDER BY COUNT(*) DESC;


/*
查询没有借阅信息的读者编号和读者姓名
*/
USE library;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT r.`rid` AS 读者编号,r.`rname` AS 读者姓名 FROM reader r WHERE NOT EXISTS (
SELECT r.`rid` AS 读者编号,r.`rname` AS 读者姓名 FROM reader r WHERE 1=2
) AND  rid NOT IN(SELECT rid FROM borrow) 

/*
查询到今天为止应还书但还未还书的读者姓名，所借的书，应归还的日期
*/
SELECT * FROM borrow;
SELECT * FROM reader;
SELECT * FROM book;

/*SELECT (SELECT rname FROM reader WHERE reader.`rid` IN (borrow.`rid`)) AS 读者姓名,
(SELECT bName FROM book WHERE book.`bid`=borrow.`nif`) AS 图书名字,
borrow.`willdate` AS 应归还的日期
 FROM borrow 
WHERE willdate<returndate OR returndate IS NULL;*/

SELECT 
  r.`rname` AS 读者姓名,
  book.`bname` AS 图书名字,
  b.`willdate` AS 应归还的日期 
FROM
  reader r 
  INNER JOIN borrow b 
    ON r.rid = b.rid 
  INNER JOIN book 
    ON b.nif = book.`bid` 
WHERE b.willdate < b.returndate 
  OR returndate IS NULL ;

/*
查询各种图书未借出的本数
*/
#左连接
SELECT book.`bname` AS 书名,book.`bcount`-COUNT(borrow.`nif`) AS 未借出的书的数量,COUNT(borrow.`nif`) AS 借出的数量
 FROM book LEFT JOIN borrow ON book.`bid`=borrow.`nif` GROUP BY borrow.`nif`;

#子查询
SELECT 

/*
从已完成借阅的记录中，统计每位读者的借书次数
*/
#子查询
SELECT (SELECT reader.rname FROM reader WHERE reader.`rid`=borrow.`rid`) AS 读者姓名,COUNT(rid) AS 借书次数 FROM borrow
WHERE returndate IS NOT NULL GROUP BY rid ;

#内连接 
SELECT reader.`rname` AS 读者姓名,COUNT(borrow.`rid`) AS 借书次数 FROM reader INNER JOIN borrow ON reader.`rid`=borrow.`rid`
WHERE borrow.`returndate` IS NOT NULL 
GROUP BY borrow.`rid`;

#查询罚款总金额大于5元的读者姓名和总罚款金额
SELECT * FROM penalty;
SELECT * FROM reader;
#内连接
SELECT reader.`rname` AS 读者姓名,SUM(penalty.`amount`) AS 罚款总钱数 FROM penalty INNER JOIN reader ON penalty.`rid`=reader.`rid`
GROUP BY penalty.`rid` HAVING SUM(penalty.amount)>5;

#子查询
SELECT (SELECT reader.`rname` FROM reader WHERE reader.`rid`=penalty.`rid`) AS 读者姓名,
SUM(penalty.`amount`) AS 罚款总钱数
FROM penalty GROUP BY penalty.`rid` HAVING SUM(penalty.amount)>5;

#统计以完成借阅的记录中的每本书的借阅次数

SELECT * FROM borrow;
SELECT * FROM book;

#内连接
SELECT book.`bname` AS 图书名称,COUNT(borrow.`nif`) AS 借阅次数 FROM book 
LEFT JOIN borrow ON book.`bid`=borrow.`nif`
WHERE borrow.returndate IS NOT NULL
 GROUP BY borrow.`nif` ORDER BY 借阅次数 DESC LIMIT 0,5;

#子查询
SELECT (SELECT book.`bname` FROM book WHERE book.bid=borrow.`nif`) AS 图书名称,
COUNT(borrow.`nif`) AS 借阅次数 
FROM borrow WHERE returndate IS NOT NULL
 GROUP BY borrow.`nif` ORDER BY 借阅次数 DESC LIMIT 0,5;
 
 


