USE library
SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM penalty;
SELECT * FROM reader;
#查询所有到今天为止应还书但还未还书的读者姓名、所借书的书名，应归还日期
#要求：使用select子查询 from子查询
SELECT 
  (SELECT 
    rname 
  FROM
    reader 
  WHERE b.`rid` = rid) AS 读者姓名,
  (SELECT 
    bname 
  FROM
    book 
  WHERE b.`nif` = bid) AS 图书书名,
  b.`willdate` AS 应归还日期 
FROM
  borrow b WHERE b.`willdate`<=NOW()AND b.`returndate`IS NULL;


#查询各种图书未借出的本数，显示查询书名和本数。
#要求：使用select子查询 from子查询
SELECT * FROM book;
SELECT * FROM reader;
SELECT b.`bname` AS 书名,(SELECT b.`bcount`-COUNT(nif) FROM borrow WHERE b.`bid`=nif)AS 剩余本数 FROM book b;

#从以完成借阅的记录（即图书归还日期不为空）中，统计每位读者的借书次数，显示读者姓名和借书次数
SELECT * FROM borrow;
SELECT * FROM reader;
SELECT rname AS 读者姓名,(SELECT COUNT(rid) FROM borrow WHERE r.`rid`=rid)AS 借书次数 FROM reader r;
SELECT 
  r.`rname` AS 读者姓名,
  COUNT(b.`rid`) AS 借书次数 
FROM
  borrow b 
  INNER JOIN reader r 
    ON b.`rid` = r.`rid` 
WHERE b.`returndate` IS NOT NULL 
GROUP BY b.`rid` ;

#查询总罚款金额大于5元的读者姓名和总罚款金额
SELECT * FROM penalty;
SELECT * FROM reader;

SELECT (SELECT rname FROM reader WHERE p.`rid`=rid)AS 读者姓名,(SELECT SUM(p.`amount`) FROM reader WHERE p.`rid`=rid ) FROM penalty p;

SELECT 
  r.`rname` AS 读者姓名,
  SUM(p.amount) AS 总金额 
FROM
  penalty p 
  INNER JOIN reader r 
    ON p.`rid` = r.`rid` 
GROUP BY p.`rid` ;

#统计以完成借阅的记录（即图书归还日期不为空）中每本书的借阅次数，显示借阅次数排名在前五位的图书名称和借阅次数

SELECT 
  bo.`bname` AS 图书名称,
  COUNT(*) AS 借阅次数 
FROM
  borrow b 
  INNER JOIN book bo 
    ON b.`nif` = bo.`bid` 
WHERE b.`returndate` IS NOT NULL 
GROUP BY b.`nif` 
ORDER BY COUNT(*) DESC ;


