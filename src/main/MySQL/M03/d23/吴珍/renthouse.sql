#按区县制作房屋出租清单
#需求：根据户型和房屋所在区县、街道为至少有2个街道有房屋出租的区县制作出租房屋清单
#户型（htid），姓名(uname)，区县(dname)，街道(sname)

SELECT htname,uname,sname,dname FROM hos_type ty RIGHT JOIN hos_house hh ON ty.htid=hh.htid LEFT JOIN sys_user su ON hh.uid=su.uid LEFT JOIN hos_street hs ON hh.sid=hs.sid 
LEFT JOIN hos_district hd ON hd.`DID`=hs.`SDID`

#使用子查询，连接查询统计各区县，街道当年各季度的房屋出售数量，使用联合查询输出各季度总量
#需求：季度，区县，街道，户型，房屋数量

SELECT QUARTER(hh.htime) AS 季度,dname AS 区县,sname AS 街道,htname AS 户型 FROM hos_district hd RIGHT JOIN hos_street hs ON hd.did=hs.sdid RIGHT JOIN hos_house hh ON hs.`SID`=hh.sid LEFT JOIN hos_type ht ON hh.htid=ht.htid ORDER BY QUARTER(htime),dname;
