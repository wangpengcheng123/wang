#查询所有到今天为止应还书但还未还数的读者姓名，所借书的书名，应归还日期
#要求：使用select子查询，from子查询
#显示:读者姓名，所借书名，应归还日期
#select * from book;#去书名bName
#select * from borrow;#取应归还日期willdate
#select * from reader;#取读者姓名rName
SELECT 
  reader.`rName` AS 读者,
  borrow.`willDate` 应该归还日期,
  book.`bName` 书名
FROM
  borrow 
  INNER JOIN reader 
    ON reader.`rid` = borrow.`rid`
  INNER JOIN book 
    ON book.`bid` = borrow.`nif` 
WHERE willDate<returnDate OR returnDate = NULL;

#查询各种图书未借出的本数，显示查询书名和本数。
#要求：使用SELECT 子查询，FROM 子查询
#select bName from book;
#select bCount from book;#书的本数
#SELECT * FROM reader WHERE lendNum# 借出的本数
SELECT 
  book.bName AS 书名,
  book.`bCount` AS 本数,
  book.`bCount` - COUNT(borrow.`nif`) AS 未借出的本数 
FROM
  book 
  LEFT JOIN borrow 
    ON book.`bid` = borrow.`nif` 
GROUP BY borrow.`nif`;

#从已完成借阅的记录中（图书归还日期不为空），统计每位读者的借书次数，显示读者姓名和借书次数
#select * from reader;
#select * from borrow;
SELECT reader.`rName` AS 读者姓名,
COUNT(borrow.`rid`) AS 借书次数
FROM reader
INNER JOIN borrow ON reader.`rid`=borrow.`rid`
WHERE borrow.`returnDate` IS NOT NULL
GROUP BY borrow.`rid`;


#查询总罚款金额大于5元的读者姓名和总罚款金额
#select * from reader;
#select * from penalty;
SELECT 
  reader.`rName` AS 读者姓名,
  SUM(penalty.`amount`) AS 总罚款金额
FROM
  penalty 
  INNER JOIN reader 
    ON penalty.`rid` = reader.`rid` 
GROUP BY penalty.`rid` 
HAVING SUM(penalty.`amount`) > 5 ;

#统计已完成借阅的记录（即图书归还日期不为空）中每本书的借阅次数，显示借阅次数排名在前
#5位的图书名称和借阅次数
SELECT book.`bName` AS 书名,COUNT(borrow.`nif`) AS 借阅次数
FROM book
LEFT JOIN borrow ON book.`bid`=borrow.`nif`
WHERE borrow.`returnDate` IS NOT NULL
GROUP BY borrow.`nif`
ORDER BY 借阅次数 DESC LIMIT 5;
