-------------------------------------------
-- Oscar Guillermo Castro				   |
-- Noor Alabdulmohsin 					   |
-- Justin Alexander						   |
-------------------------------------------

.open GL.db
.headers on
.mode column
.output glquery.log

.print
.print ********************************
.print *		   Problem #1 - checkNum from checks made payable to companies	  *
.print ********************************
.print
-- checkNum from check for companies
	
	select checkNum from checks, company
		where checks.ein = company.ein
			order by company.name ASC;

.print
.print ********************************
.print *		   Problem #2 - retrieve the total amount of money any person pays themselves through check	  *
.print ********************************
.
-- check.amt made to specific person.Name by themselves
select people.name, sum(checks.amt) from checks, people
	where checks.author = checks.recipient AND checks.author = people.ssn
		group by people.ssn
		order by people.name DESC;

.print
.print ********************************
.print *		   Problem #3 - Retreive total amount of Checks made payable to Spurs Fans United Company before May 1, 2013  *
.print ********************************
.print

select sum(amt) from checks, company
	where checks.ein = company.ein AND checks.ein = 3 AND julianDay(date) < julianDay("2013-05-01");