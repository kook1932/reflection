CREATE TABLE TB_POST (
	ID 					INT(10)			NOT NULL 	AUTO_INCREMENT 	PRIMARY KEY,
	TITLE 				VARCHAR(100) 	NOT NULL,
	CONTENT 			VARCHAR(300) 	NOT NULL,
	CREATE_DATE_TIME 	DATETIME		NOT NULL,
	CREATOR_IP 			VARCHAR(15) 	NOT NULL,
	UPDATE_DATE_TIME 	DATETIME		NULL,
	UPDATER_IP 			VARCHAR(15) 	NULL
)
