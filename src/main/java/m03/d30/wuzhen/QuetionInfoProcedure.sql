SELECT * FROM question_info;

DELIMITER ;;
CREATE PROCEDURE queryall()
BEGIN
 SELECT * FROM question_info;
END
;;
DELIMITER ;
CALL queryall();

DELIMITER ;;
CREATE PROCEDURE querybyquestion()
BEGIN
 SELECT * FROM question_info WHERE question LIKE '%变量名%';
END
;;
DELIMITER ;
CALL querybyquestion();