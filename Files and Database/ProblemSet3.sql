-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set 3
-- ProblemSet3.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet3.log

.print   
.print *****************************
.print        Problem I
.print *****************************
.print   

select city from s
	union
select city from p
	order by city asc;

.print   
.print *****************************
.print        Problem II
.print *****************************
.print   

select sno, pno from sp
	order by sno asc, pno desc;

.print   
.print *****************************
.print        Problem III
.print *****************************
.print   

select city from s
	where city like 'a%'
		union
select city from p
	where city like 'a%';

.print   
.print *****************************
.print        Problem IV
.print *****************************
.print   

select 	avg(status) as StatusAverage, 
		max(status) as StatusMax, 
		min(status) as StatusMinimum 
			from s;

.print   
.print *****************************
.print        Problem V
.print *****************************
.print   

select distinct sum(qty) from sp;

.print   
.print *****************************
.print        Problem VI
.print *****************************
.print   

select count(status) as statusCount
	from s
		where status > 15;
		
.print   
.print *****************************
.print        Problem VII
.print *****************************
.print   

select distinct color, count(color) from p
	group by color;

.print   
.print *****************************
.print        Problem VIII
.print *****************************
.print   

select 	distinct pno, 
		count(distinct qty), 
		sum(distinct qty)
			from sp
		group by pno
		order by pno desc;

.print   
.print *****************************
.print        Problem IX
.print *****************************
.print   

select 	distinct pno,
		count(distinct qty),
		sum(distinct qty) from sp
			where qty > 500
		group by pno
		order by pno desc;

.print   
.print *****************************
.print        Problem X
.print *****************************
.print   

select sno, sname from s
	where sno in 
	(	select sno from sp
		group by sno
		having count(pno) > 0 
	);	