/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `borrow` (
	`rid` varchar (90),
	`nif` varchar (90),
	`lendDate` timestamp ,
	`willDate` date ,
	`returnDate` date 
); 
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('01','001','2017-12-01 20:08:58','2018-01-01','2018-03-15');
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('02','002','2018-03-04 17:55:43','2018-03-15',NULL);
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('03','003','2018-03-07 12:06:39','2018-03-16',NULL);
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('04','004','2018-03-03 10:00:50','2018-03-20','2018-03-20');
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('05','005','2018-03-04 09:44:12','2018-03-22',NULL);
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('02','003','2018-03-03 10:36:56','2018-03-16',NULL);
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('04','001','2018-03-19 09:57:16','2018-03-23',NULL);
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('07','003','2018-03-02 11:16:39','2018-03-15','2018-03-17');
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('07','004','2018-03-20 12:11:25','2018-03-23','2018-03-20');
insert into `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) values('07','001','2018-03-12 11:15:01','2018-03-29',NULL);
