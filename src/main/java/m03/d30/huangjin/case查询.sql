SELECT * FROM sales;
 # 按月统计销售表中货物的销售量数
 SELECT empid,proid,
 SUM(CASE WHEN MONTH(sadate)=9 THEN num ELSE num=0 END) AS 9月,
 SUM(CASE WHEN MONTH(sadate)=10 THEN num ELSE num=0 END) AS 10月,
 SUM(CASE WHEN MONTH(sadate)=11 THEN num ELSE num=0 END) AS 11月,
 SUM(CASE WHEN MONTH(sadate)=12 THEN num ELSE num=0 END) AS 12月
 FROM sales 
GROUP BY empid,proid;

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
INSERT INTO ABC VALUES('王小',5 ,'负','二班')
SELECT * FROM abc
#汇总时按字段D 和A分组,汇总字段B,C可以不显示,
#如果C为'负'则对应的B为负数.
SELECT a,
SUM(CASE WHEN c='负' THEN b ELSE -b END) AS b,
d
FROM abc
GROUP BY a,d;

