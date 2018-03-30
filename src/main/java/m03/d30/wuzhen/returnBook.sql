DROP PROCEDURE returnbook;
DELIMITER ;;
CREATE PROCEDURE returnbook(IN rname1 VARCHAR(30))
BEGIN 
INSERT INTO penalty VALUES('09','003','2018-03-20',1,4.6);
UPDATE borrow SET returndate=NOW() WHERE rid=(SELECT rid FROM reader WHERE rname=rname1);
UPDATE reader SET lendnum=lendnum-1 WHERE rname=rname1;
UPDATE book SET bcount=bcount+1 WHERE bid=(SELECT nif FROM borrow WHERE rid=(SELECT rid FROM reader WHERE rname=rname1));
END
;;
DELIMITER ;
CALL returnbook('刘冰冰');
