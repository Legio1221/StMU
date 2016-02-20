------------------------------------------------------------
-- Dr. Art Hanna
-- SQL create SP data base
-- CreateSPDB.sql
------------------------------------------------------------


CREATE TABLE s
(
   sno    TEXT     PRIMARY KEY COLLATE NOCASE,
   sname  TEXT     NOT NULL    COLLATE NOCASE,
   status INTEGER  NOT NULL,
   city   TEXT     NOT NULL    COLLATE NOCASE
);

INSERT INTO s VALUES ('S01', 'Smith',  20,'London'  );
INSERT INTO s VALUES ('S02', 'Jones',  10,'Paris'   );
INSERT INTO s VALUES ('S03', 'Blake',  30,'Paris'   );
INSERT INTO s VALUES ('S04', 'Clark',  20,'London'  );
INSERT INTO s VALUES ('S05', 'Adams',  30,'Athens'  );
INSERT INTO s VALUES ('S06', 'Garcia', 50,'Austin'  );
INSERT INTO s VALUES ('S07', 'Thomas', 10,'El Paso' );
INSERT INTO s VALUES ('S08', 'Jonas',  40,'New York');
INSERT INTO s VALUES ('S09', 'Zeeman', 10,'LONDON'  );

CREATE TABLE p
(
   pno    TEXT      NOT NULL COLLATE NOCASE,
   pname  TEXT      NOT NULL COLLATE NOCASE,
   color  TEXT      NOT NULL COLLATE NOCASE,
   weight INTEGER   NOT NULL,
   cost   REAL      NOT NULL,
   city   TEXT      NOT NULL COLLATE NOCASE,

   PRIMARY KEY (pno)
);

INSERT INTO p VALUES ('P01', 'Nut',    'Red',    12.1, 0.13, 'London' );
INSERT INTO p VALUES ('P02', 'Bolt',   'Green',  17.3, 0.25, 'Paris'  );
INSERT INTO p VALUES ('P03', 'Screw',  'Blue',   17.4, 0.09, 'Rome'   );
INSERT INTO p VALUES ('P04', 'Screw',  'Red',    14.0, 0.10, 'London' );
INSERT INTO p VALUES ('P05', 'Cam',    'Blue',   12.9, 5.26, 'Paris'  );
INSERT INTO p VALUES ('P06', 'Cog',    'Red',    19.7, 3.75, 'London' );
INSERT INTO p VALUES ('P07', 'Washer', 'Silver', 10.1, 0.11, 'El Paso');
INSERT INTO p VALUES ('P08', 'Nut',    'Gold',   15.3, 0.13, 'Austin' );
INSERT INTO p VALUES ('P09', 'Nail',   'Silver', 16.5, 0.01, 'Rome'   );
INSERT INTO p VALUES ('P10', 'Gear',   'Blue',   35.7, 9.99, 'Houston');
INSERT INTO p VALUES ('P11', 'Tack',   'White',   5.6, 0.01, 'Dallas' );
INSERT INTO p VALUES ('P12', 'Wheel',  'Black',  97.8, 2.30, 'Paris'  );

CREATE TABLE sp
(
   sno     TEXT     NOT NULL REFERENCES s(sno) COLLATE NOCASE,
   pno     TEXT     NOT NULL COLLATE NOCASE,
   qty     INTEGER  NOT NULL,
   dueDate TEXT     NOT NULL COLLATE NOCASE,

   FOREIGN KEY (pno) REFERENCES p(pno)
);

INSERT INTO sp VALUES ('S01', 'P01', 300, '1990-01-01');
INSERT INTO sp VALUES ('S01', 'P02', 200, '1990-10-19');
INSERT INTO sp VALUES ('S01', 'P03', 400, '1990-08-07');
INSERT INTO sp VALUES ('S01', 'P04', 200, '1990-11-11');
INSERT INTO sp VALUES ('S01', 'P05', 100, '1990-07-11');
INSERT INTO sp VALUES ('S01', 'P06', 100, '1990-02-10');
INSERT INTO sp VALUES ('S01', 'P12',  50, '1990-12-29');
INSERT INTO sp VALUES ('S02', 'P01', 300, '1990-06-20');
INSERT INTO sp VALUES ('S02', 'P02', 400, '1990-03-23');
INSERT INTO sp VALUES ('S03', 'P02', 200, '1990-12-07');
INSERT INTO sp VALUES ('S04', 'P02', 200, '1990-05-03');
INSERT INTO sp VALUES ('S04', 'P04', 300, '1990-04-05');
INSERT INTO sp VALUES ('S04', 'P05', 400, '1990-11-18');
INSERT INTO sp VALUES ('S05', 'P01',  50, '1990-03-03');
INSERT INTO sp VALUES ('S05', 'P09', 150, '1990-04-30');
INSERT INTO sp VALUES ('S05', 'P11', 320, '1990-05-17');
INSERT INTO sp VALUES ('S06', 'P02', 150, '1990-10-05');
INSERT INTO sp VALUES ('S06', 'P12', 825, '1990-06-07');
INSERT INTO sp VALUES ('S08', 'P08', 180, '1990-09-26');
INSERT INTO sp VALUES ('S08', 'P11', 250, '1990-07-28');
INSERT INTO sp VALUES ('S09', 'P01', 100, '1990-02-10');
INSERT INTO sp VALUES ('S09', 'P03', 200, '1990-08-01');
INSERT INTO sp VALUES ('S09', 'P04', 100, '1990-01-09');
INSERT INTO sp VALUES ('S09', 'P07', 300, '1990-08-20');
INSERT INTO sp VALUES ('S09', 'P10', 100, '1990-12-22');
INSERT INTO sp VALUES ('S09', 'P12', 200, '1990-09-14');
