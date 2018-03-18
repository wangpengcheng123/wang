SELECT*FROM book;
SELECT*FROM borrow;
SELECT*FROM penalty;
SELECT*FROM reader;
INSERT INTO reader(rid,rName,lendNum,rAddress) VALUES(4,'李玲',2,NULL)
INSERT INTO borrow(rid,nif,lendDate,willDate,returnDate) VALUES(4,'003','2023-12-23','2012-2-4','2011-2-2')



#子查阅没有被借出的信息
SELECT  a.`bid` AS 图书编号,a.`aurter`AS 作者姓名,a.`PubComp`AS 出版社,a.`price`AS 单价  FROM book a WHERE bid NOT IN(
         SELECT nif FROM borrow
         )
         


#子查询罚款读者清单

  SELECT r.rName AS 读者姓名, b.bName AS  图书书名,p.pDate  AS 罚款日期,p.amount AS 罚款金额 FROM book b,reader r,penalty p 
  
  
 #使用子查询获得地址为空的所有读者没归还的书籍清单，按读者编号从高到低排序，借书日期又近到远排序输出读者姓名，读者姓名，图书名称，结束日期和应归还日期
     SELECT r.rid AS 读者编号,rName AS 读者姓名,bName,b.lendDate AS 借书日期 ,b.willDate AS 应归还日期  FROM reader r,borrow b,book WHERE  r.rid IN(
                        SELECT rid FROM borrow  WHERE returnDate>willDate 
     )AND bid IN(
                      SELECT nif FROM borrow  WHERE returnDate>willDate 
     )AND lendDate IN (
                       SELECT lendDate FROM borrow  WHERE returnDate>willDate 
     )
   
   