-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set 2
-- ProblemSet2.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet2.log

.print  
.print *****************************
.print       Problem I
.print *****************************
.print  

select distinct city from s 
		union 
select distinct city from p;

.print  
.print *****************************
.print       Problem II
.print *****************************
.print  

select city from s 
	intersect
select city from p;

.print  
.print *****************************
.print       Problem III
.print *****************************
.print  

select city from s
	where city not in(select city from p);

.print  
.print *****************************
.print       Problem IV
.print *****************************
.print  

select distinct s.sno, s.sname, p.pname, s.city from s
	inner join sp on (s.sno = sp.sno)
	inner join p on (p.pno = sp.pno)
	where s.city = p.city;

.print  
.print *****************************
.print       Problem V
.print *****************************
.print  

select x.pno,x.pname,x.color from p x, p y
	where x.pname = y.pname and x.color <> y.color;