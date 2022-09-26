--1. Display the details of all employees 
select * from employees;

--2) Display the depart information from department table
describe departments;

--3) Display the name and job for all the employees 
select concat(first_name,last_name)"Employee Name", job_id from employees;

--4) Display the name and salary for all the employees 
select concat(first_name,last_name)"Employee Name", salary from employees;

--5) Display the employee no and total salary for all the employees
select employee_id,salary+nvl(commission_pct,0) "Total salary" from employees;

--6) Display the employee name and annual salary for all employees.
select concat(first_name,last_name)"Employee Name",12*(salary+nvl(commission_pct,0))"Annual salary" from employees;

--7) Display the names of all the employees who are working in depart number 10. 
select concat(first_name,last_name)"Employee Name" from employees where department_id=10;

--8) Display the names of all the employees who are working as clerks and drawing a salary more than 3000.
select first_name from employees where job_id in('PU_CLERK') and salary>3000;

--9) Display the employee number and name who are earning comm. 
select employee_id,first_name,last_name from employees where commission_pct is not null;

--10) Display the employee number and name who do not earn any comm. 
select employee_id,first_name,last_name from employees where commission_pct is null;

--11) Display the names of employees who are working as clerks, salesman or analyst and drawing a salary more than 3000.
select first_name,last_name from employees where job_id in('SH_CLERK','SA_MAN','ANALYST') and salary > 3000;

--12) Display the names of the employees who are working in the company for the past 5 years;
select first_name,last_name from employees where to_char(SYSDATE,'YYYY') - to_char(hire_date,'YYYY') >= 5;

--13) Display the list of employees who have joined the company before 30-JUN-90 or after 31-DEC-90.
select first_name,last_name from employees where hire_date < '30-06-1990' or hire_date > '31-12-1990';

--14) Display current Date.
select SYSDATE from dual;

--15) Display the list of all users in your database (use catalog table). 
select username from all_users;

--16) Display the names of all tables from current user; 
select table_name from user_tables;

--17) Display the name of the current user.
show user;

--18) Display the names of employees working in depart number 10 or 20 or 40 or employees working as CLERKS,SALESMAN or ANALYST.
select first_name,last_name from employees where department_id in(10,20,40) or job_id in('SH_CLERK','SA_MAN','ANALYST');

--19) Display the names of employees whose name starts with alaphabet S.
select first_name from employees where first_name like 'S%';

--20) Display the Employee names for employees whose name ends with alaphabet S. 
select first_name from employees where first_name like '%S';

--21) Display the names of employees whose names have second alphabet A in their names.
select first_name from employees where first_name like '_A%';

--22) select the names of the employee whose names is exactly five characters in length.
select first_name from employees where length(first_name)=5;


--23) Display the names of the employee who are not working as MANAGERS. 
select first_name, last_name from employees where job_id not in('ST_MAN');

--24) Display the names of the employee who are not working as SALESMAN OR CLERK OR ANALYST.
select first_name, last_name from employees where job_id not in('SH_CLERK','SA_MAN','ANALYST');

--25) Display all rows from emp table.The system should wait after every screen full of informaction. (Hint : Use SET PAUSE ON)
set pause off 2;
PAUSE press RETURN to view the employee name;
select first_name from employees;

--------------------------------------------------------------------------------------------------------------------------------------------------------
--Assignment 2
--26) Display the total number of employee working in the company. 
select count(first_name) from employees;

--27) Display the total salary being paid to all employees. 
select sum(salary) from employees;

--28) Display the maximum salary from emp table. 
select max(salary) from employees;

--29) Display the minimum salary from emp table. 
select min(salary) from employees;

--30) Display the average salary from emp table.
select avg(salary) from employees;

--31) Display the maximum salary being paid to CLERK. 
select max(salary) from employees where job_id in('ST_CLERK');

--32) Display the maximum salary being paid to depart number 20. 
select max(salary) from employees where department_id in(20);

--33) Display the minimum salary being paid to any SALESMAN. 
select min(salary) from employees where job_id in('ST_MAN');

--34) Display the average salary drawn by MANAGERS.
select avg(salary) from employees where job_id in('SA_MAN');

--35) Display the total salary drawn by ANALYST working in depart number 40. 
select sum(salary) from employees where department_id in(40);

--36) Display the names of the employee in order of salary i.e the name of the employee earning lowest salary should salary appear first.
select first_name,salary from employees order by salary ASC;

--37) Display the names of the employee in descending order of salary.
select first_name,salary from employees order by salary DESC;

--38) Display the names of the employee in order of employee name. 
select first_name from employees order by first_name;

--39) Display empno, ename, deptno, sal sort the output first base on name and within name by deptno and within deptno by sal.
select employee_id,first_name,department_id,salary from employees order by first_name,department_id, salary; 

--40) Display the name of the employee along with their annual salary(sal*12).The name of the employee earning highest annual salary should apper first.
select first_name,salary*12 from employees order by salary desc;

--41) Display name, salary, hra, pf, da, total salary for each employee. The output should be in the order of total salary,hra 15% of salary, da 10% of salary, pf 5% salary, total salary will be(salary+hra+da)-pf.
select first_name,salary,salary*0.15 "HRA",salary*0.10 "DA",salary*0.05 "PF",(salary+salary*0.15+salary*0.10)-(salary*0.05) "Total Salary" from employees;

--42) Display department numbers and total number of employees working in each department.
select department_id,count(department_id)"Employee working" from employees group by department_id;

--43) Display the various jobs and total number of employees within each job group.
select job_id,count(job_id)"Employee working" from employees group by job_id;

--44) Display the depart numbers and total salary for each department.
select department_id,sum(salary)"Total salary" from employees group by department_id;

--45) Display the depart numbers and max salary for each department.
select department_id,max(salary)"Maximum salary" from employees group by department_id;

--46) Display the various jobs and total salary for each job 
select job_id, sum(salary) from employees group by job_id;

--47) Display the various jobs and total salary for each job 
select job_id, sum(salary) from employees group by job_id;

--48) Display the depart numbers with more than three employees in each dept.
select department_id,count(department_id)"More than three employees" from employees group by department_id having count(*)>3; 

--49) Display the various jobs along with total salary for each of the jobs where total salary is greater than 40000.
select job_id,sum(salary) from employees group by job_id having sum(salary)>40000; 

--50) Display the various jobs along with total number of employees in each job. The output should contain only those jobs with more than three employees.
select job_id,count(first_name) from employees group by job_id having count(first_name)>3;

--51) Search for the employees with the pattern ‘A_B’ in their names.
select first_name from employees where first_name like '%A\_B%' ESCAPE '\';

--52. Find the First occurrence of character 'a' from the following string i.e 'Computer Maintenance Corporation'.
select instr('Computer Maintenance Corporation','a') from dual;

--53. Display the information from emp table. Where job manager is found it should be displayed as boss(Use replace function). 
select employee_id,first_name,last_name,replace('job manager','job manager','boss') "Job" from employees;

--54) Display the names of the employees in Uppercase.
select upper(first_name) from employees;

--55) Display the names of the employees in Lowercase. 
select lower(first_name) from employees;

--56) Display the names of the employees in Proper case. 
select initcap(first_name),initcap(last_name) from employees;

--57) Display the length of Your name using appropriate function. 
select length('Manish Kumar Mauriya') from dual;

--58) Display the length of all the employee names. 
select length(first_name) from employees;

--59) select name of the employee concatenate with employee number. 
select first_name||' '||last_name||'_'||employee_id "Name" from employees;

--60) User appropriate function and extract 3 characters starting from 2 characters from the following string 'Oracle'. i.e the output should be 'rac'.
select substr('Oracle',2,3) from dual;

--61) Display empno, ename, deptno from emp table. Instead of display department numbers display the related department name(Use decode function).
select employee_id,first_name,decode(department_id,10,'account',20,'sales','non-department') from employees;

--62) Display the current date as 15th August Friday Nineteen Ninety Seven. 
select to_char(sysdate,'ddth Month day year') "Current date" from dual;

--63) Display the following output for each row from emp table.For ex: 
--Scott has joined the company on Wednesday 13th August nineteen ninety.
--Sham has joined the company on Wednesday 13th August nineteen ninety.
select first_name,to_char(hire_date,'day ddth Month Year') from employees where first_name='Nancy';

--64) Find the date for nearest Saturday after current date. 
select next_day(sysdate,'saturday') from dual;

--65) Display the date three months before the current date.
select add_months(sysdate,-3) from dual;

----------------------------------------------------------------------------------------------------------------------------------
--Assignment 3
--66) Display the name of the employee who earns highest salary. 
select first_name from employees where salary=(select max(salary) from employees);

--67) Display the employee number and name for employee working as clerk and earning highest salary among clerks.
select employee_id,first_name from employees where job_id='ST_CLERK' and salary=(select max(salary) from employees where job_id='ST_CLERK');

--68) Display the names of salesman who earns a salary more than the highest salary of any clerk.
select first_name,salary from employees where job_id ='SA_MAN' and salary>=(select max(salary) from employees where job_id='ST_CLERK');

--69) Display the names of clerks who earn a salary more than the lowest salary of any salesman.
select first_name from employees where job_id='ST_CLERK' and salary>=(select min(salary) from employees where job_id='SA_MAN');

--70) Display the names of employees who earn a salary more than that of Jones or that of salary greater than that of Scott.
select first_name from employees where salary>=(select salary from employees where first_name='Jones');

--71) Display the employee’s salary who earns highest salary in their respective departments.
select employee_id,first_name,salary from employees where salary IN(select max(salary) from employees group by department_id);

--72) Display the employee’s salary who earns highest salaries in their respective job groups.
select first_name,salary from employees where salary IN (select max(salary) from employees group by job_id);

--73) Display the employee names who are working in Chicago.
select first_name from employees where location='Chicago';

--74) Display the Job groups having total salary greater than the maximum salary for managers.
select job_id from employees group by job_id having sum(salary)> (select max(salary) from employees where job_id='SA_MAN');  

--75) Display the names of employees from department number 10 with salary greater than that of any employee working in other department.
select first_name from employees where department_id=10 and salary > any(select salary from employees where department_id not in(10));

--76) Display the names of the employees from department number 10 with salary greater than that of all employees working in other departments.
select first_name from employees where department_id=10 and salary > any(select salary from employees where department_id not in(10));

--77) Display the common jobs from department number 10 and 20.
select job_id from employees where department_id=10 and job_id in (select job_id from employees where department_id=20);

--78) Display the jobs found in department 10 and 20 Eliminate duplicate jobs. 
select job_id from employees where department_id=10 or department_id=20;

--79) Display the jobs which are unique to department 10. 
select distinct job_id from employees where department_id=10;

--80) Display the details of those who do not have any person working under them.
select first_name from employees where manager_id is null;

--81) Display the details of those employees who are in sales department and grade is 3. 


--82) Update the salary of each employee by 10% increment who are not eligible for commission.
update employees set salary=salary*0.10 where commission_pct is null;

--83) SELECT those employee who joined the company before 31-dec-82 while their dept location is newyork or Chicago.
select first_name from employees where hire_date<'31-12-1882' and department_id in(select department_id from locations where city in('newyork','chicago'));

--84) DISPLAY EMPLOYEE NAME,JOB,DEPARTMENT,LOCATION FOR ALL WHO ARE WORKING AS MANAGER? 
select first_name,job_id,department_id from employees where job_id='SA_MAN';

--85) DISPLAY THOSE EMPLOYEES WHOSE MANAGER NAME IS JONES? [AND ALSO DISPLAY THEIR MANAGER NAME]?


--86) Display name and salary of ford if his salary is equal to hisal of his grade

--87) Display employee name,job,depart name ,manager name,his grade and make out an under department wise?

--88) List out all employees name,job,salary,grade and depart name for every one in the company except 'CLERK'. Sort on salary.
select first_name,job_id,salary,department_id from employees where job_id not in('ST_CLERK','SH_CLERK','PU_CLERK') order by salary ASC;

--89) Display the employee name,job and his manager.Display also employee who are without manager?
select first_name,job_id,manager_id from employees where manager_id is null;

--90) Display name of those employee who are getting the highest salary? 
select first_name from employees where salary IN (SELECT max(salary) FROM employees);

--91) Display those employee whose salary is equal to average of maximum and minimum?
select * from employees where salary = (select (max(salary)+min(salary))/2 from employees);

--92) Select count of employee in each department where count greater than 3? 
select count(first_name) from employees group by department_id having count(*)>3;

--93)Display those managers name whose salary is more than average salary of his employee?

--94) Display employee name,sal,comm and net pay for those employee whose net pay is greter than or equal to any other employee salary of the company?
select first_name,salary,commission_pct,salary+nvl(commission_pct,0)"Net pay" from employees where salary+nvl(commission_pct,0)>= any(select salary from employees); 

--95) Find out the number of employees whose salary is greater than their manager salary?

------------------------------------------------------------------------------------------------------------------------------------------------------------------
--Assignment 3
--96) Display those department where no employee working? 
select * from departments where department_id not in (select department_id from employees);

--97) Display those employee whose salary contains at least 3 digits? 
select * from employees where length(salary)>=3;

--98) Display those employee who joined in the company in the month of Dec? 
select * from employees where to_char(hire_date,'MM')=12;

--99) Display those employees whose name contains "A"? 
select * from employees where first_name like '%A%';

--100) Display those employee whose 10% of salary is equal to the year of joining?
select * from employees where to_char(hire_date,'YY')=salary*0.1;

--101) Display those employee who are working in sales or research? 
select e.first_name,e.last_name,d.department_id,e.department_id,d.department_name from employees e,departments d where e.department_id=d.department_id and d.department_name='Sales';

--102) Display those employees who joined the company before 15th of the month? 
select * from employees where to_char(hire_date,'DD')<15;

--103) Delete those records where no of employees in a particular department is less than 3.
delete from employees group by department_id having count(*)<3;

--104) Display the name of the department where no employee working.
select * from departments where department_id not in (select department_id from employees);

--105) Display those employees who are working as manager.


--106) Print the details of all the employees who are Subordinate to BLAKE?
select * from employees where first_name='BLAKE';

--107) Display the 10th record of emp table(without using rowid) 
select * from employees where rownum<11 minus select * from employees where rownum<10;

--108)Delete the 10th record of emp table. 
delete from employees where rownum<11 minus select * from employees where rownum<10;

--109) Create a copy of emp table.
create table employees_copy AS select * from employees;

--110) Select ename if ename exists more than once.


--111) Display all enames in reverse order?(SMITH:HTIMS). 
select first_name,reverse(first_name) from employees;

--112) Display those employee whose joining DATE is available in deptno. 
select * from employees where to_char(hire_date,'DD')IN department_id;

--113) Display those employees name as follows A ALLEN B BLAKE
select first_name from employees where first_name in('ALLEN','BLAKE');

--114) Delete the rows of employees who are working in the company for more than 2 year
delete from employees where floor(sysdate-hire_date)>2*365;

--115) Provide a commission(10% Comm Of Sal) to employees who are not earning any commission.
update employees set salary=salary+salary*0.1 where commission_pct is null;

--116) If any employee has commission his commission should be incremented by 10% of his salary.
update employees set commission_pct=commission_pct*0.1 where commission_pct is not null;

--117)Display employee number,name and location of the department in which he is working.
select e.first_name,e.employee_id,d.location_id from employees e, departments d where e.department_id=d.department_id;

--118) Display ename,dname even if there are no employees working in a particular department(use outer join).
select e.first_name,d.department_name from employees e full outer join departments d on e.department_id=d.department_id;

--119) Display employee name and his manager name. 


--120) Write a Query To Delete The Repeated Rows from emp table;
delete from employees where employee_id in(select employee_id from employees group by employee_id having count(*)>1);

--121) TO DISPLAY 5 TO 7 ROWS FROM A TABLE 
select * from employees where rownum<=8 minus select * from employees where rownum<=5;

--122) DISPLAY TOP 10 ROWS FROM TABLE.
select * from employees where rownum<=10;

--123) DISPLAY TOP 3 SALARIES FROM EMP; 
select * from (select * from employees order by salary desc) where rownum<=3;

--124) Display employee name and his salary is greater than highest average of department number
select first_name,salary from employees where salary > (select max(avg(salary)) from employees group by employee_id);
------------------------------------------------------------------------------------------------------------------------------------------
--Assignment 5
--125) Create table emp with only one column empno; 
create table emp(empno int);

--126) Add this column to emp table ename varchar2(20).
alter table emp add ename varchar2(20);

--127) Oops I forgot give the primary key constraint. Add in now. 
alter table emp add constraint emp_constrain primary key(empno);

--128) Now increase the length of ename column to 30 characters. 
alter table emp modify ename varchar(30);

--129) Add salary column to emp table. 
alter table emp add salary int;

--130) I want to give a validation saying that salary cannot be greater 10,000 (note: give a name to this constraint)
alter table emp add constraint salary check(salary<=10000);

--131) For the time being I have decided that I will not impose this validation. My boss has agreed to pay more than 10,000.
alter table emp modify constraint salary disable;

--132) My boss has changed his mind. Now he doesn't want to pay more than 10,000.so revoke that salary constraint.
alter table emp modify constraint salary enable;

--133) Add column called as mgr to your emp table.
alter table emp add mgr int; 

--134) Oh! This column should be related to empno. Give a command to add this constraint.
alter table emp add constraint mgr_deptno foreign key(mgr) references emp(empno);

--135) Add deptno column to your emp table.
alter table emp add deptno int;

--136) This deptno column should be related to deptno column of dept table;
alter table emp add constraint deptno_dept foreign key(deptno) references dept(empno);

--137) Give the command to add the constraint.
alter table emp add constraint constraint_name check(salary>0);

--138) Create table called as newemp. Using single command create this table as well as get data into this table (use create table as); 
create table newemp as select * from emp;

--139) Create table called as newemp. This table should contain only empno,ename,dname.
create table newemps as select empno,ename,deptno from emp;

--140) Create a simple view on Employees table on first_name, last_name, job_id, dept_id.
create view simple_view as select first_name,last_name,job_id,department_id from employees;
select * from simple_view;

--141) Apply any Add/Update/Delete operation on the simple view and verify the View and the base Table contents.
update simple_view set first_name='Steve' where first_name='Steven';

--142) Create a view on Department table with Check option for SALES department.
create view sales_dept as select department_id,department_name from departments where department_id=80 with check option;
select * from sales_dept;

--143) Create a READ ONLY view and verify whether it prevent any write operation.
create force view simple_view2 as select first_name,last_name from simple_view with read-only option;

--144) Create a Complex view on more than 1 base table on join condition and query the view.
create view complex_view
as
select e.employee_id, e.first_name, e.last_name, jb.job_title from employees e inner join jobs jb ON e.job_id=jb.job_id;

select * from complex_view;

--145) Create a Sequence for employee ID primary key column which will automatically generate ids for the employees.
create sequence emp_seq1
start with 1
increment by 1;

--146) Apply the sequence in any of DML query.
 insert into newemps("EMPNO","ENAME","DEPTNO") values(emp_seq1.nextval,'divya',3);
 
 --147) Create non unique indexes on the non primary key and non unique columns which you frequently access in your queries.
 create index Index_name on newemp (salary,mgr);
 
 --148) Create 2 new users and grant them 2 different roles which contain system and object privileges.
create user manish identified by manish;
create user newuser identified by newuser;

create  table newtable(id integer,name varchar2(20)) ;
grant select, insert, update, delete on newtable to newuser;

grant all privileges TO manish;

--149) Revoke the roles from respective users and verify the access privileges.
revoke select, insert, update, delete on newtable from newuser;
revoke all privileges from manish;

--150) Display all user defined objects from a data dictionary view
select * from dictionary;
