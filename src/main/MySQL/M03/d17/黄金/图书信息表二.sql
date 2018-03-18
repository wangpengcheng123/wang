USE library;#选择库
SELECT * FROM book;#查询表
#插入数据
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('001','烈火如歌','明晓溪','上海','2016-09-21','50','20.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('002','泡沫之夏','明晓溪','上海','2015-02-03','100','15.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('003','西游记','吴承恩','武汉','2017-05-06','120','15.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('004','三生三世十里桃花','唐七公子','安徽','2012-08-09','150','20.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('005','罗密欧和朱丽叶','莎士比亚','广州','2014-10-12','200','12.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('006','红楼梦','曹雪芹','深圳','2014-05-08','180','17.0');
INSERT INTO `book` (`bid`, `bname`, `author`, `pubComp`, `pubDate`, `bCount`, `price`) VALUES('007','安徒生童话','安徒生','武汉','2015-08-06','200','16.0');

SELECT * FROM borrow;
INSERT INTO `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) VALUES('01','001','2018-02-15 20:08:58','2018-03-06','2018-03-15');
INSERT INTO `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) VALUES('02','002','2018-02-22 20:09:11','2018-02-22','2018-03-23');
INSERT INTO `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) VALUES('03','003','2018-03-18 16:57:47','2018-03-23','2018-03-21');
INSERT INTO `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) VALUES('04','004','2018-03-06 17:06:26','2018-03-29','2018-03-18');
INSERT INTO `borrow` (`rid`, `nif`, `lendDate`, `willDate`, `returnDate`) VALUES('05','005','2018-03-02 15:54:35','2018-03-22','2018-03-29');
SELECT * FROM reader;
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('01','张飞','1','马家庄');
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('02','如歌','1','光谷');
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('03','明明','1','司门口');
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('04','夜华','1','');
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('05','东东','1','虎泉');
INSERT INTO `reader` (`rid`, `rName`, `lendNum`, `rAddress`) VALUES('06','张梦梦','1','鲁巷');

SELECT * FROM penalty;
INSERT INTO `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) VALUES('01','001','2018-03-07','1','9');
INSERT INTO `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) VALUES('02','002','2018-02-23','1','30');
INSERT INTO `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) VALUES('03','003','2018-03-23','1','7');
INSERT INTO `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) VALUES('04','004','2018-03-30','1','6');
INSERT INTO `penalty` (`rid`, `bid`, `pDate`, `pType`, `amount`) VALUES('05','005','2018-03-30','1','5');
#没被借阅图书信息
SELECT * FROM book WHERE bid NOT IN(
	SELECT nif FROM borrow WHERE returndate IS NULL 
);


#获取所有缴纳罚款读者清单
SELECT rname FROM reader WHERE rid IN(
	SELECT rid FROM penalty 
);
SELECT bname FROM book WHERE bid IN(
	SELECT bid FROM penalty
);
SELECT pdate,amount FROM penalty ;
 

 
#获取地址为空的所有读者尚未归还的图书清单 
SELECT b.`bname`,r.`rname`,o.`lenddate`,o.`returndate` 
FROM book b,reader r,borrow o 
WHERE r.`rid` = o.rid 
AND b.`bid` = o.nif 
AND r.`rid` IN(  
SELECT rid FROM reader WHERE raddress IS NULL )
AND o.`rid` IN(SELECT rid FROM borrow WHERE returndate IS NULL )
ORDER BY r.`rid` DESC,
o.`lenddate` ASC;
