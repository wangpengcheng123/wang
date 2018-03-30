SELECT * FROM question_info;
DELIMITER //
CREATE PROCEDURE qu_result(IN i INT,OUT str VARCHAR(200))
BEGIN
	SET str=(SELECT question FROM question_info WHERE questionId=i);
END//
DELIMITER ;
CALL qu_result(2,@str);
SELECT @str;
#-------------------------------------------------------------------
CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT,
	saDate DATETIME
)
INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');
SELECT * FROM sales;
SELECT *,COUNT(proid)AS 个数 FROM sales GROUP BY proid;
SELECT * FROM sales WHERE SUBSTRING(saDate,6,2)=10;
SELECT * FROM sales;
#1.按月统计销售表中货物的销售量数
SELECT empid AS `NO`,proid AS NO2,
IFNULL( FORMAT((SELECT SUM(num)AS num FROM sales c WHERE 
SUBSTRING(saDate,7,1)=9 AND a.`proid`=c.proid),1),0)AS 9月 
,IFNULL(FORMAT((SELECT SUM(num)AS num FROM sales c WHERE 
SUBSTRING(saDate,6,2)=10 AND a.`proid`=c.proid),1),0)AS 10月,
 IFNULL(FORMAT((SELECT SUM(num)AS num FROM sales c WHERE 
SUBSTRING(saDate,6,2)=11 AND a.`proid`=c.proid),1),0)AS 11月,
 IFNULL(FORMAT((SELECT SUM(num)AS num FROM sales c WHERE 
SUBSTRING(saDate,6,2)=12 AND a.`proid`=c.proid),1),0)AS 12月
 FROM sales a GROUP BY proid ;

2.
SELECT empid,proid,
SUM((CASE MONTH(sadate) WHEN 9  THEN num ELSE 0 END))AS 九月,
SUM((CASE MONTH(sadate) WHEN 10 THEN num ELSE 0 END))AS 十月,
SUM((CASE MONTH(sadate) WHEN 11 THEN num ELSE 0 END))AS 十一月,
SUM((CASE MONTH(sadate) WHEN 12 THEN num ELSE 0 END))AS 十二月
FROM sales
GROUP BY empid,proid



#----------------------------------------------------------------------- 
CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');
SELECT * FROM ABC;

SELECT -B,c FROM ABC WHERE c='负';
1.
SELECT t1.a,SUM(t1.b) AS b,t1.d
FROM 
(SELECT  a,d,CASE WHEN c='正' THEN B ELSE -b END AS B
FROM abc ) t1
GROUP BY a,d
ORDER BY b DESC;

2.
SELECT A,SUM(CASE C WHEN '负' THEN -B ELSE B END)AS B,D FROM ABC
GROUP BY A,D 


#----------------------------------------------------
SELECT * FROM penalty;
SELECT * FROM reader;
SELECT * FROM book;
SELECT * FROM borrow;
DELIMITER //
CREATE PROCEDURE lir_liu()
BEGIN
	INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES
	((SELECT rid FROM reader WHERE rname='刘冰冰'),
	(SELECT bid FROM book WHERE bname='西游记' ),
	NOW(),1,4.6);
	UPDATE  borrow SET willdate=NOW() WHERE
	 rid=(SELECT rid FROM reader WHERE rname='刘冰冰')
	AND nif=(SELECT bid FROM book WHERE bname='西游记' );
	
	UPDATE  reader SET lennum=lennum-1 WHERE 
	rname='刘冰冰';
	
	UPDATE  book SET bcount=bcount+1 WHERE
	 bname='西游记' ;
	
END //
DELIMITER ;

CALL lir_liu;



