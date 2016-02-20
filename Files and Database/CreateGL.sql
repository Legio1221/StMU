

.open GL.db
.headers on
.mode column

BEGIN TRANSACTION;
CREATE TABLE `People` (
	`SSN`	INTEGER NOT NULL,
	`dateOfBirth`	TEXT NOT NULL,
	`name`	TEXT NOT NULL,
	PRIMARY KEY(SSN)
);
INSERT INTO `People` VALUES (100204000,'06-15-1988','John Smith');
INSERT INTO `People` VALUES (111223333,'','');
INSERT INTO `People` VALUES (123456789,'','');
INSERT INTO `People` VALUES (888995555,'','');
INSERT INTO `People` VALUES (999301111,'','');
CREATE TABLE `Company` (
	`foundDate`	TEXT NOT NULL,
	`ein`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL,
	PRIMARY KEY(ein)
);
INSERT INTO `Company` VALUES ('01-11-1991',1,'Light Industries');
INSERT INTO `Company` VALUES ('02-22-1982',2,'Rock Company');
INSERT INTO `Company` VALUES ('03-30-1973',3,'Spurs Fans United');
INSERT INTO `Company` VALUES ('04-24-1944',4,'Smith Enterprises');
INSERT INTO `Company` VALUES ('05-15-1955',5,'Herr''s Chip Company');
CREATE TABLE `Check` (
	`cid`	INTEGER NOT NULL,
	`checkNum`	INTEGER NOT NULL,
	`date`	TEXT NOT NULL,
	`name`	TEXT NOT NULL,
	`amt`	REAL NOT NULL,
	PRIMARY KEY(cid)
);
INSERT INTO `Check` VALUES (1,1024,'01-10-2015','John Smith',400.0);
INSERT INTO `Check` VALUES (2,2134,'02-28-2014','Noor Alabdulmohsin',3000.0);
INSERT INTO `Check` VALUES (3,3764,'03-30-2015','Oscar Castro',2015.0);
INSERT INTO `Check` VALUES (4,4987,'04-15-2014','Matt Jones',131.0);
INSERT INTO `Check` VALUES (5,5294,'05-23-2015','Justin Alexander',67.89);
COMMIT;
