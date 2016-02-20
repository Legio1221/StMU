-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set VI
-- ProblemSet6.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet6.log

.print   
.print *****************************
.print        Problem I
.print *****************************
.print   

select city, sname from s
	order by city desc, sname;
	
.print   
.print *****************************
.print        Problem II
.print *****************************
.print   

select distinct p.pno, pname, count(sp.pno), sum(qty) as TotalQuantity from p,sp
	where
		(
			p.pno = sp.pno and
			julianDay(dueDate) <= julianDay('1990-11-11')
		)
	group by p.pno
	order by TotalQuantity desc;

.print   
.print *****************************
.print        Problem III
.print *****************************
.print   

select p.pno, color, sum(weight*qty) as TotalWeightInGrams from p, sp
	where 
		(
			p.pno = sp.pno and
			exists
				(
					select * from sp
				)
		)
	group by p.pno;
	
.print   
.print *****************************
.print        Problem IV
.print *****************************
.print   

select avg(weight) as AverageWeight from p;
--Second Table begins
select pno, pname, weight, weight - (select avg(weight) from p) as GramsMoreThanAvg from p
	where 
	(
		weight > ( select avg(weight) from p)
	)
	group by weight;

.print   
.print *****************************
.print        Problem V
.print *****************************
.print   

select distinct s.sno, s.sname, sum(cost*qty) as TotalMoneyOwed from s
inner join sp on (sp.sno = s.sno)
inner join p on (sp.pno = p.pno)
	where
		(
			julianDay(dueDate) between julianDay('1990-01-01') and julianDay('1990-06-31')
		)
	group by s.sno
	order by TotalMoneyOwed desc;