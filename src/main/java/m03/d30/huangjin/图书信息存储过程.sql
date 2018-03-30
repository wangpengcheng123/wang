DELIMITER //

CREATE PROCEDURE jia (
  IN rid VARCHAR (10),
  IN rname VARCHAR (10),
  IN lendnum INT,
  IN raddress VARCHAR(50)
)
BEGIN
	INSERT INTO reader SET rid=rid,rname=rname,lendnum=lendnum,raddress=raddress;
	UPDATE book SET bcount=bcount+1;
	UPDATE reader SET lendnum=lendnum-1;
	
END//
DELIMITER ;
CALL jia('006','刘冰冰',1,'中国馆');
