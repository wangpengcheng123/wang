CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT(100,2),#单价
	saDate DATETIME
)
SELECT * FROM sales
INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');

#按月统计每种货物的单价(empid,proid,num,月份)
SELECT empid,proid,SUM(CASE WHEN MONTH(sadate)=9 THEN num ELSE 0 END) AS 九月,SUM(CASE WHEN MONTH(sadate)=10 THEN num ELSE 0 END) AS 十月,
SUM(CASE WHEN MONTH(sadate)=11 THEN num ELSE 0 END) AS 十一月,SUM(CASE WHEN MONTH(sadate)=12 THEN num ELSE 0 END) AS 十二月 FROM sales GROUP BY empid,proid