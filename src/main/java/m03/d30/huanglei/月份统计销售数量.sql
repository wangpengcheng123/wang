
#按月分统计出货量
SELECT empid AS NO,proid AS No2
   ,SUM(CASE WHEN MONTH(saDate)=9 THEN num ELSE  num=0 END ) AS 九月
   ,SUM(CASE WHEN MONTH(saDate)=10 THEN num ELSE num=0 END ) AS 十月
   ,SUM(CASE WHEN MONTH(saDate)=11 THEN num ELSE num=0 END ) AS 十一月
   ,SUM(CASE WHEN MONTH(saDate)=12 THEN num ELSE num=0 END ) AS 十二月
FROM sales 
GROUP BY empid,proid
ORDER BY empid 

#java模糊穿存储过程
DELIMITER ;;
CREATE PROCEDURE mohu(IN a VARCHAR(200))
BEGIN
      SELECT*FROM questioninfo WHERE question LIKE '%a%';
END
;;
DELIMITER ;
CALL mohu('中');

#java调用存储过程
DELIMITER ;;
CREATE PROCEDURE showquestion()
BEGIN
     SELECT*FROM questioninfo;
END
;;
DELIMITER ;
CALL showquestion;