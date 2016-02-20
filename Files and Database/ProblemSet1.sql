--------------------------------------------------------------------
-- Oscar Guillermo Castro
-- SQL Problem I
-- ProblemSet1.sql
--------------------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet1.log
--.output stdout

.print  
.print ******************
.print Problem I
.print ******************
.print  

select * from s;

.print  
.print ******************
.print Problem II
.print ******************
.print  

select sno, sname from s
	where city = 'London';

.print  
.print ******************
.print Problem III
.print ******************
.print  

select pno, city from p
	where pno = 'P07';

.print **P07 is manufactured in El Paso.**

.print  
.print ******************
.print Problem IV
.print ******************
.print  

select pno,pname from p
	where weight >=50 or color = 'Red';

.print  
.print ******************
.print Problem V
.print ******************
.print  

select distinct p.pno, p.color from p,sp
	where sp.pno = p.pno and sp.sno = 'S01';

.print  
.print ******************
.print Problem VI
.print ******************
.print  

select distinct city from p;

.print **They are not automatically deleted, distinct needs to be included in the statement.**

.print  
.print ******************
.print Problem VII
.print ******************
.print  

select pno,pname from p
	where color in ('red','white','blue');
	
.print  
.print ******************
.print Problem VIII
.print ******************
.print  

select distinct s.sno, sname from s
	inner join sp on (s.sno = sp.sno)
	inner join p on (p.pno = sp.pno)
		where sp.qty >= 100 and p.color = 'green' or s.status < 30;

.print  
.print ******************
.print Problem IX
.print ******************
.print  

select distinct sname from s
	inner join sp on (s.sno = sp.sno)
	inner join p on (p.pno = sp.pno)
		where sp.qty < 400 and p.pno = 'P02' and p.city = s.city;

.print  
.print ******************
.print Problem X
.print ******************
.print  

select pno from p
	where pname = 'Nut' or pname = 'Screw';