/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `book` (
	`bid` varchar (180),
	`bname` varchar (180),
	`author` varchar (180),
	`pubComp` varchar (900),
	`pubDate` date ,
	`bCount` int (100),
	`price` float 
); 
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('001','烈火如歌','明晓溪','上海','2016-09-21','50','20');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('002','泡沫之夏','明晓溪','上海','2015-02-03','100','15');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('003','西游记','吴承恩','武汉','2017-05-06','120','15');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('004','三生三世十里桃花','唐七公子','安徽','2012-08-09','150','20');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('005','罗密欧和朱丽叶','莎士比亚','广州','2014-10-12','200','12');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('006','红楼梦','曹雪芹','深圳','2014-05-08','180','17');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('007','安徒生童话','安徒生','武汉','2015-08-06','200','16');
insert into `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) values('008','烈火如歌','明晓溪','上海','2016-09-21','50','20');
