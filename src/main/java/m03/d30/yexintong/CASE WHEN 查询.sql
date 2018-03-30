SELECT * FROM sales

SELECT empid AS NO,proid AS NO2,
SUM(CASE WHEN MONTH(saDate)=9 THEN num ELSE num=0 END) AS 九月,
SUM(CASE WHEN MONTH(saDate)=10 THEN num ELSE num=0 END) AS 十月,
SUM(CASE WHEN MONTH(saDate)=11 THEN num ELSE num=0 END) AS 十一月,
SUM(CASE WHEN MONTH(saDate)=12 THEN num ELSE num=0 END) AS 十二月
FROM sales
GROUP BY empid,proid
ORDER BY empid;

SELECT * FROM abc

SELECT A,
SUM(CASE WHEN C='负' THEN -B ELSE B END) AS B,
D
FROM abc
GROUP BY A,D
ORDER BY B DESC

/*使用存储过程添加刘冰冰的数据*/
DELIMITER ;;
CREATE PROCEDURE ups_text_01(IN rid VARCHAR(200),IN bid VARCHAR(200),IN pdate DATETIME,IN ptype INT,IN amount FLOAT)
BEGIN
	INSERT INTO penalty  SET rid=rid,bid=bid,pdate=pdate,ptype=ptype,amount=amount;
	UPDATE 	borrow a SET returndate=pdate WHERE a.rid=rid;
	UPDATE reader a SET lennum=lennum-1 WHERE a.rid=rid;
	UPDATE book a SET bcount=bcount+1 WHERE a.bid=bid;
END
;;
DELIMITER ;

CALL ups_text_01('0008','0007',NOW(),1,4.6);


DELIMITER ;;
CREATE PROCEDURE ups_text_01()
BEGIN
	SELECT * FROM question_info;
END
;;
DELIMITER ;

CALL ups_text_01();

DELIMITER ;;
CREATE PROCEDURE ups_text_02(IN num VARCHAR(50))
BEGIN
	SELECT * FROM question_info WHERE question LIKE '%"+mohuwenzi+"%'
END`ups_text_02`
;;
DELIMITER ;

CALL ups_text_02('J');