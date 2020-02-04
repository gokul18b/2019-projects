SELECT * 
FROM  `homework` AS hw
LEFT JOIN class AS u ON ( u.id = hw.cid ) 
WHERE cid =1