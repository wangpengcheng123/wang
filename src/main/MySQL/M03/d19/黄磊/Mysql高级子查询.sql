
#查询没有借阅信息的读者编号和姓名
SELECT rid AS 读者编号,
       rname AS 读者姓名
       FROM reader WHERE NOT EXISTS(
        SELECT * FROM borrow WHERE lennum!=0

)


#3差尊所有到今天为止应还书但为还书的读者姓名，所借书的书名，应归还日期，

          SELECT 
          (SELECT rname FROM reader WHERE b.rid=rid)AS 读者姓名,
           (SELECT bname FROM book WHERE b.nif=bid)AS 所借书籍,
             (SELECT willdate FROM borrow  WHERE  returndate IS NULL AND NOW()>willdate)AS 应归还日期
            FROM  borrow b WHERE  returndate IS NULL AND NOW()>willdate
            
            
  #4查询各种图书未借出的本书，显示查询书名和本数，          
 SELECT 
   (SELECT bname FROM book WHERE bid=b.nif),
   (SELECT bcount-COUNT(nif) FROM book WHERE bid=b.nif)
   
 FROM borrow b GROUP BY nif   
 
 
 #5统计已完成的借阅记录，既图书归还日期不为空中，统计每位读者的借书次数，显示读者姓名和借书次数
 SELECT 
 (SELECT rname FROM reader WHERE b.rid=rid)AS 读者姓名,
 (SELECT COUNT(b.rid))AS 借书次数
 FROM borrow b WHERE returndate IS NOT NULL
 GROUP BY rid
 
#6查阅总罚款金额大于5的读者姓名和罚款金额
  SELECT 
 r.`rname` AS 读者姓名,
 SUM(p.amount) AS 总金额
 FROM penalty p INNER JOIN reader r ON p.`rid`=r.`rid`
 GROUP BY p.`rid`;
 HAVING SUM(p.amount)>5;
 
#7统计已完成的借阅记录，既图书归还日期不为空中的每本书的借阅次数，显示无数名称和借阅次数
SELECT 
(SELECT bname FROM book WHERE b.nif=bid),
SUM(nif)
FROM borrow b WHERE returndate IS NOT NULL GROUP BY nif  DESC
 
 
 
 
 
 
 
 
            
  