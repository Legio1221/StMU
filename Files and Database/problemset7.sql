-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set VII
-- ProblemSet7.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet7.log

.print   
.print *****************************
.print        Problem I-A
.print *****************************
.print   

insert into s values ( 'S10','Darby',70,'San Antonio' );
select * from s
	where sno = 's10';
.print 

insert into p values ( 'P13','widget','pink',11.1,0.07,'San Antonio' );
select * from p
	where pno = 'P13';
.print 
	
insert into sp values ('S10','P13',150,'1990-11-11');
insert into sp values ('S10','P11',350,'1990-12-24');
select * from sp
where sno = 'S10';

.print   
.print *****************************
.print        Problem I-B
.print *****************************
.print   

delete from s
	where sno = 's10';
select * from s;
.print 

delete from p
	where pno = 'p13';
select * from p;
.print

delete from sp
	where  pno = 'p13' and sno = 's10';
delete from sp
	where pno = 'p11' and sno = 's10';
select * from sp;

.print   
.print *****************************
.print        Problem II
.print *****************************
.print   

insert into sp select sno, 'p07', 125, '1990-01-05' from s
	where not exists ( select sno from sp);
select * from sp;

.print   
.print *****************************
.print        Problem III-A
.print *****************************
.print   

update s set status = 59
	where sno = 's09';

select * from s
	where sno = 's09';

.print   
.print *****************************
.print        Problem III-B
.print *****************************
.print   

update s set status = 10
	where sno = 's09';

update s set city = 'London'
	where city = 'LONDON';

select * from s
	where city = 'London';

.print   
.print *****************************
.print        Problem IV
.print *****************************
.print   

select 	color,
		count(color) as CountOfParts,
		sum(qty) as TotalQuantity,
		date(min(julianDay(dueDate))) as earliestDueDay,
		date(max(julianDay(dueDate))) as lastDueDay 
	from p
inner join sp on (sp.pno = p.pno)
group by color;

.print   
.print *****************************
.print        Problem V
.print *****************************
.print   

drop table if exists tableproblem5;
create temporary table tableproblem5 as 
	select pname, pno, color from p
order by pname;

select * from tableproblem5 order by pname, color asc;