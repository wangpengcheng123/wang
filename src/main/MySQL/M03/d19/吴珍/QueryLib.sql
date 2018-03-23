#查询没有借阅信息的读者编号和读者姓名，要求：使用not exists; 
SELECT r.rid,r.rname FROM reader r WHERE NOT EXISTS (
  SELECT bw.rid FROM borrow bw WHERE bw.rid=r.rid
)

#查询所有到今天为止应还书但还未还书的读者姓名，所借书的书名，应归还日期，要求：用select子查询，from子查询;
#需求：到今天为止应还书的时间:willdate<=今天的日期，但未还书，则:同时满足returnDate is null;

 SELECT 
    rname AS 读者姓名,bname AS 所借书名,willdate AS 应归还日期 
  FROM
    reader r INNER JOIN borrow bw ON r.rid=bw.rid INNER JOIN book b ON bw.nif=b.bid
  WHERE r.rid IN 
    (SELECT 
      bw.rid 
    FROM
      borrow b
    WHERE DATEDIFF(NOW(), bw.willdate) >= 0 
      AND bw.returndate IS NULL);
      

#从已完成借阅的记录（即图书归还日期不为空）中，统计每位读者的借书次数，显示读者姓名和借书次数。
#需求：已完成借阅：returndate不为空，再在其中找到读者的编号
#借书次数，分组表示 group by rid; 
SELECT rname AS 读者姓名,COUNT(*) AS 借书次数 FROM reader r INNER JOIN borrow bw ON r.rid=bw.rid WHERE bw.`returnDate` IS NOT NULL GROUP BY r.rid ; 

#查询总罚款金额大于5元的读者姓名和总罚款金额；
SELECT rname AS 读者姓名,SUM(amount) AS 罚款金额 FROM penalty p INNER JOIN reader r ON p.rid=r.rid GROUP BY r.rid HAVING SUM(amount)>5;

#统计已完成借阅的记录（即图书归还日期不为空）中每本书的借阅次数，显示借阅次数排名在前5位的图书名称和借阅次数；
SELECT rname AS 读者姓名,COUNT(*) AS 借书次数 FROM reader r INNER JOIN borrow bw ON r.rid=bw.rid WHERE bw.`returnDate` IS NOT NULL GROUP BY r.rid ORDER BY COUNT(*) DESC LIMIT 5; 
