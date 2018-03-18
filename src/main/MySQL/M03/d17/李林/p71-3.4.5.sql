
#没被借阅图书信息
SELECT * FROM book WHERE bid NOT IN(
	SELECT nif FROM borrow WHERE returndate IS NULL 
);


#获取所有缴纳罚款读者清单
SELECT rname FROM reader WHERE rid IN(
	SELECT rid FROM penalty 
);
SELECT bname FROM book WHERE bid IN(
	SELECT bid FROM penalty
);
SELECT pdate,amount FROM penalty ;
 

 
#获取地址为空的所有读者尚未归还的图书清单 
SELECT b.`bname`,r.`rname`,o.`lenddate`,o.`returndate` 
FROM book b,reader r,borrow o 
WHERE r.`rid` = o.rid 
AND b.`bid` = o.nif 
AND r.`rid` IN(  
SELECT rid FROM reader WHERE raddress IS NULL )
AND o.`rid` IN(SELECT rid FROM borrow WHERE returndate IS NULL )
ORDER BY r.`rid` DESC,
o.`lenddate` ASC;



    