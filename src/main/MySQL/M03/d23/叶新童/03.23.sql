SELECT ht.htname AS 房屋类型,su.uname AS 客户姓名,hd.dname AS 区县,hs.`SName`AS 街道
FROM hos_house ho
INNER JOIN sys_user su ON ho.`UID`=su.`UID`
INNER JOIN hos_street hs ON ho.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON ho.`HTID`=ht.`HTID` 
WHERE hd.`DID` IN(
	SELECT hd.`DID` FROM hos_house ho
		INNER JOIN hos_street hs ON ho.`SID`=hs.`SID`
		INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
		GROUP BY hd.`DID` HAVING COUNT(*)>1
)
ORDER BY ht.`HTName`