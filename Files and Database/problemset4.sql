-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set IV
-- ProblemSet4.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet4.log

.print   
.print *****************************
.print        Problem I
.print *****************************
.print   

select sno, sname from s
	where sno not in (
		select sno from sp
		group by sno
		having count(pno) > 0
		);
		
.print   
.print *****************************
.print        Problem II
.print *****************************
.print   

select pno,	cast( cost * 100 as integer ) pennies
		from p
			where weight > (cost * 50);
.print   
.print *****************************
.print        Problem III
.print *****************************
.print   

select sno, pno, dueDate from sp
	where 	julianDay(dueDate) > julianDay('1990-05-01') and 
			julianDay(dueDate) < julianDay('1990-05-31')
	order by sno desc, dueDate desc;

.print   
.print *****************************
.print        Problem IV
.print *****************************
.print   

select qty, sname from s
	inner join sp on (s.sno = sp.sno)
	inner join p on (p.pno = sp.pno)
		where 	julianDay(dueDate) > julianDay('1990-10-01') and 
				julianDay(dueDate) < julianDay('1990-12-31')  and
				qty > 100;

.print   
.print *****************************
.print        Problem V
.print *****************************
.print   

select city from s
	where city not in (select city from p)
union
select city from p
	where city not in (select city from s);