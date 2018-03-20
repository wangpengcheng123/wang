/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `penalty` (
	`rid` varchar (90),
	`bid` varchar (180),
	`pDate` date ,
	`pType` int (1),
	`amount` float 
); 
insert into `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) values('01','001','2018-01-02','1','9');
insert into `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) values('02','002','2018-03-16','3','30');
insert into `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) values('03','003','2018-03-17','1','7');
insert into `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) values('02','003','2018-03-17','1','10');
insert into `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) values('07','003','2018-03-16','2','5');
