/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `reader` (
	`rid` varchar (90),
	`rName` varchar (90),
	`lendNum` int (5),
	`rAddress` varchar (180)
); 
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('01','张飞','1','马家庄');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('02','如歌','2','光谷');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('03','明明','1','司门口');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('04','夜华','2','');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('05','东东','1','虎泉');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('06','张梦梦','1','鲁巷');
insert into `reader` (`rid`, `rName`, `lendNum`, `rAddress`) values('07','小丽','3','汉正街');
