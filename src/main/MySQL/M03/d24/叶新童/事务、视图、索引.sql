SELECT * FROM reader;
INSERT INTO reader SET rid='0010',rname='张无忌',lennum=0,raddress='张湾';
/*
为读者张无忌办理借阅《红楼梦》书籍的手续
要求:在图书借阅表 borrow 中增加一条图书借阅记录的同时，将图书信息表 book 中此书的当前数量减1，在读者信息表 reader 中为张无忌记录已借书数量加1
*/
SELECT * FROM borrow;
BEGIN;
  INSERT INTO borrow SET rid='0010',nif='0006',lenddate='2018-3-24',willdate='2018-3-30',returndate=NULL;
  UPDATE reader SET lennum=lennum+1 WHERE rid=0010;
  UPDATE book SET bcount=bcount-1 WHERE bid=0006;
COMMIT;

/*
编码实现读者刘冰冰缴纳罚金归还图书的手续，要求一次完成
要求：在罚款记录表中增加一条记录，记录刘冰冰因延期归还《西游记》一书而缴纳金4.6元
在图书借阅表中修改归还日期为当前日期
将读者信息表中已借书数量减1
将图书信息表中现存数量加1
*/
BEGIN;
INSERT INTO penalty SET rid='0008',bid='0007',pdate=NOW(),amount=4.6;
UPDATE borrow SET returndate=NOW() WHERE rid=0008;
UPDATE reader SET lennum=lennum-1 WHERE rid=0008;
UPDATE book SET bcount=bcount+1 WHERE bid=0007;
COMMIT;

/*
为图书管理员创建的索引和查询视图
要求：图书管理员希望及时得到最新的到期图书清单，包括图书名称、到期日期和读者姓名等信息
在图书名称字段添加索引
*/
CREATE INDEX index_book_bname ON book(bname)
DROP VIEW view_book_boss
CREATE VIEW view_book_boss
AS
SELECT c.bname,b.rname,a.returndate FROM borrow a
INNER JOIN reader b ON b.rid=a.rid
INNER JOIN book c ON c.bid=a.nif
WHERE DATEDIFF(NOW(),a.returndate)<1

SELECT * FROM view_book_boss
 
SHOW INDEX FROM index_book_bname