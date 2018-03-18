#使用子查询查询当前没有被读者借阅的图书信息
SELECT 
  bid,
  bname,
  author,
  pubComp,
  price 
FROM
  book 
WHERE bid NOT IN 
  (SELECT 
    nif 
  FROM
    borrow 
  WHERE returndate IS NULL) ;



#使用子查询获得今年的所有缴纳罚款的读者名单
SELECT 
  r.`rname`,
  b.`bname`,
  p.`pdate`,
  p.`amount` 
FROM
  reader r 
  INNER JOIN penalty p 
    ON r.`rid` = p.`rid` 
  INNER JOIN book b 
    ON b.`bid` = p.`bid` ;

#使用子查询获得地址为空的所有读者尚未归还的图书清单
SELECT 
  b.`rid`,
  reader.`rname`,
  book.`bname`,
  b.`lenddate`,
  b.`willdate` 
FROM
  borrow b 
  INNER JOIN reader 
    ON b.`rid` = reader.`rid` 
  INNER JOIN book 
    ON book.`bid` = b.`nif` 
WHERE b.`returndate` IS NULL 
  AND reader.`raddress` IS NULL 
ORDER BY b.`rid` DESC,
  b.`lenddate` ASC ;

 