#3.查询所有到今天为止应还书但还未还书的读者姓名，所借书的书名，应归还日期
SELECT 
(SELECT rname FROM reader WHERE b.`rid`=rid ) AS 读者姓名, 
(SELECT bname FROM book WHERE b.`nif`=bid ) AS 图书编号,
b.`willdate` AS 应归还日期
FROM borrow b 
WHERE b.`willdate`<NOW()
AND b.`returndate` IS NULL;

#4.查询各种图书未借出的本数,显示查询书名和本数
SELECT
(SELECT bname FROM book WHERE b.`nif`=bid ) AS 书名,
(SELECT bcount-COUNT(b.`nif`) FROM book WHERE b.`nif`=bid) AS 本数 
FROM borrow b GROUP BY b.`nif`;

#5.从已完成借阅的记录（即图书归还日期不为空）中，
#统计每位读者的借书次数，显示读者姓名和借书次数
SELECT r.`rname` AS 读者姓名,
COUNT(b.`rid`) AS 借书次数
 FROM borrow b INNER JOIN reader r ON b.`rid`=r.`rid`
 WHERE b.`returndate` IS NOT NULL
 GROUP BY b.`rid`;
 
 #6.查询总罚款金额大于5元的读者姓名和总罚款金额
 SELECT r.`rname` AS 读者姓名,
 SUM(p.amount) AS 总金额
 FROM penalty p INNER JOIN reader r ON p.`rid`=r.`rid`
 GROUP BY p.`rid`;
 
 #7.统计已完成借阅的记录（即图书归还日期不为空）中每本书的借阅次数，
 #显示借阅次数排名在前5位的图书名称和借阅次数
 SELECT 
 bo.`bname` AS 图书名称,
 COUNT(*) AS 借阅次数
  FROM borrow b INNER JOIN book bo ON b.`nif`=bo.`bid`
  WHERE b.`returndate` IS NOT NULL
 GROUP BY b.`nif`
 ORDER BY COUNT(*) DESC;