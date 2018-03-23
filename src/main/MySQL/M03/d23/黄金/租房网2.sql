SELECT * FROM hos_district;
SELECT * FROM hos_house;
SELECT * FROM hos_street;
SELECT * FROM hos_type;
SELECT * FROM sys_user;
#根据户型和房屋所在区县和街道，为至少有两个街道有出租房屋的区县制作租房屋清单
#显示：户型，姓名，区县，街道
SELECT HTNAME AS 户型,UNAME AS 姓名,DNAME AS 区县, SNAME AS 街道    
FROM hos_type,sys_user,hos_district,hos_street,hos_house    
WHERE hos_house.sid=hos_street.sid    
AND hos_type.htid=hos_house.htid    
AND sys_user.uid=hos_house.uid    
AND hos_district.did=hos_street.sdid    
AND hos_house.SID IN    
(    
  SELECT hos_street.SID    
  FROM hos_street    
  WHERE sdid IN    
  (    
    SELECT sdid    
    FROM hos_street,(SELECT DISTINCT(SID) FROM hos_house) AS temp    
   WHERE hos_street.sid=temp.sid    
   GROUP BY sdid    
  HAVING COUNT(hos_street.SID)>=2    
  )    
)   ORDER  BY 户型 DESC