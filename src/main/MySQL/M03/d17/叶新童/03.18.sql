USE librarys;
#使用子查询获得当前没有被读者借阅的图书信息；
SELECT 
  a.`bid` AS 图书编号,
  a.`bName` AS 图书名称,
  a.`author` AS 作者姓名,
  a.`pubComp` AS 出版社,
  a.`price` AS 单价 
FROM
  book a 
WHERE bid NOT IN 
  (SELECT 
    nif 
  FROM
    borrow)
    
 #使用子查询获得今年的所有缴纳罚款的读者清单

SELECT 
  r.rName AS 读者姓名,
  b.bName AS 图书书名,
  p.pDate AS 罚款日期,
  p.amount AS 罚款金额 
FROM
  book b,
  reader r,
  penalty p 
WHERE r.rid = p.`rid` 
  AND b.bid = p.`bid` 
  AND p.`bid` IN 
  (SELECT 
    bid 
  FROM
    penalty 
  WHERE pdate IN 
    (SELECT 
      pdate 
    FROM
      penalty 
   ))
   
   #使用子查询获得地址为空的所有读者尚未归还的图书清单
SELECT 
  r.`rid`,
  r.`rname`,
  b.`bname`,
  br.lenddate,
  br.willdate 
FROM
  reader r,
  book b,
  borrow br 
WHERE r.`rid` = br.rid 
  AND b.`bid` = br.nif 
  AND r.`rid` IN 
  (SELECT 
    rid 
  FROM
    reader 
 ) 
  AND br.rid IN 
  (SELECT 
    rid 
  FROM
    borrow 
  WHERE returndate IS NULL) 
ORDER BY lenddate DESC 