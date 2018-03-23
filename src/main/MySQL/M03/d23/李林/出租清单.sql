SELECT
(SELECT htName FROM hos_type WHERE HTID = h.`HTID`) AS 户型,
(SELECT UName FROM sys_user WHERE UID = h.`UID`) AS 姓名,
(SELECT dname FROM hos_district WHERE DID IN
	(SELECT sdid FROM hos_street WHERE h.`SID`=SID)
) AS 区县,
h.`COPY` AS 街道
FROM hos_house h
WHERE h.`HTID` IN (SELECT COUNT(*) FROM hos_house GROUP BY HTID HAVING (COUNT(*)>1));