CREATE TABLE student(
sid INT(2) NOT NULL PRIMARY KEY,
sname VARCHAR(10) NOT NULL,
sex CHAR(1),
grade INT(1)
)
INSERT INTO student(sid,sname,sex,grade) VALUES(1,'张三','男',1);
INSERT INTO student(sid,sname,sex,grade) VALUES(2,'pheonix','女',1);
INSERT INTO student(sid,sname,sex,grade) VALUES(3,'Tim','男',2);
INSERT INTO student(sid,sname,sex,grade) VALUES(4,'Nick','男',2);
INSERT INTO student(sid,sname,sex,grade) VALUES(5,'MiuMiu','女',1);
INSERT INTO student(sid,sname,sex,grade) VALUES(6,'李四','男',3);
SELECT * FROM student;
SELECT sid,sname,sex,grade FROM student WHERE grade=1;
SELECT * FROM student;
SELECT sid,sname FROM student LIMIT 4;