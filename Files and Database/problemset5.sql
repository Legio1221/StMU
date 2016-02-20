-------------------------------------------------------
-- Oscar Guillermo Castro
-- Problem Set V
-- ProblemSet5.sql
-------------------------------------------------------

.open SP.db
.headers ON
.mode column
.output ProblemSet5.log

.print   
.print *****************************
.print        Problem I
.print *****************************
.print   

select distinct sp.pno, pname, sname from s, sp, p
	where exists 
		(
			select * from sp t1
				where 
					t1.sno <> sp.sno and
					t1.pno = p.pno and
					sp.pno = p.pno and
					sp.sno = s.sno
		)
	order by sp.pno, pname, sname;
	
.print   
.print *****************************
.print        Problem II
.print *****************************
.print   

select pname from p
	where color not in
		(
			select color from p 
			where
				(
					color = "red" or
					color = "white" or
					color = "blue"
				)
		)
	order by pname desc;
	
.print   
.print *****************************
.print        Problem III
.print *****************************
.print   

select pno, pname, cost/weight as costPerWeight from p
	where cost/weight >= 
		(
			select cost/weight from p as t1
				where p.pno <> t1.pno
		);
		
.print   
.print *****************************
.print        Problem IV
.print *****************************
.print   

select sno, sname from s
	where city = "Paris" and exists 
		(
			select city from s
				where city = "paris"
		);
.print   
.print *****************************
.print        Problem V
.print *****************************
.print   

select sno, sname from s
	where not exists
		(
			select sno from sp
				where s.sno = sp.sno
		)
	order by sname desc;