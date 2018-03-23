SELECT * FROM hos_house;
SELECT * FROM hos_district;
SELECT * FROM hos_street;
SELECT * FROM sys_user;
SELECT * FROM hos_type;

/*SELECT t.`HTName` AS 户型,
u.`UName` AS 姓名,d.`DName` AS 区县,
s.`SName` AS 街道
 FROM hos_house h left JOIN sys_user u
ON h.`UID`=u.`UID` 
left JOIN hos_type t ON h.`HMID`=t.`HTID`
left JOIN hos_street s ON h.`SID`=s.`SID`
left JOIN hos_district d ON s.`SDID`=d.`DID`
GROUP BY s.`SDID` HAVING COUNT(*)>1;
SELECT * FROM hos_street s GROUP BY s.`SDID` HAVING COUNT(*)>1;


SELECT t.`HTName` FROM hos_house h RIGHT JOIN hos_type t ON h.`HTID`=t.`HTID`;
SELECT u.`UName` FROM hos_house h LEFT JOIN sys_user u ON h.`UID`=u.`UID`;*/





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



