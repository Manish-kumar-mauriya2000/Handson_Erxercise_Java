--PL/SQL
SET SERVEROUTPUT ON;
declare
a int := &a;
b int := &b;
c int :=0;
begin
c:=a+b;
DBMS_OUTPUT.PUT_LINE('Sum of the two numbers : ' || c);
end;
/
---------------------------------------------------------------
declare
age int:= &age;
begin
if (age >= 18) then
dbms_output.put_line('Your eligible for voting');
else
dbms_output.put_line('Your not eligible for voting');
end if;
end;
/
------------------------------------------------------------------
declare
a int := 5;
begin
loop
dbms_output.put_line('a is ' || a);
a:=a+5;
exit when a >= 50;
end loop;
dbms_output.put_line('After exit of a is ' || a);
end;
/
----------------------------------------------------------------------
declare
x number(2);
begin
for x in 10..20 loop
dbms_output.put_line('x is ' || x);
end loop;
end;
/
-------------------------------------------------------------------------
declare
type namearray is varray(5) of varchar2(10);
type grades is varray(5) of int;
name namearray;
mark grades;
total int;
begin
name:=namearray('Manish','kumar','kavin');
mark:=grades(98,95,96);
total:=mark.count;
dbms_output.put_line('Total ' || total || 'student');
for i in 1..total loop
dbms_output.put_line('Name ' || name(i)  || 'and mark is ' || mark(i));
end loop;
end;
/
---------------------------------------------------------------------------
create or replace procedure simple_example as
begin
dbms_output.put_line('Hello this is my first procedure in pl/sql');
end;
/
------------------------------------------------------------------------------
declare
a number;
b number;
c number;
 procedure findMinMax(num1 IN number,num2 IN number,result OUT number) is
 begin
 if num1>num2 then
 result:=num1;
 else
 result:=num2;
 end if;
 end;
 begin
 a:=65;
 b:=2;
 findMinMax(a,b,c);
 dbms_output.put_line('The max num is ' || c);
 end;
 /
----------------------------------------------------------------------------
create or replace function employee_fun 
return int is
total int:=0;
begin
select count(*) into total from employees;
return total;
end;
/

set SERVEROUT on;
declare
total_emp int;
begin
total_emp:=employee_fun();
dbms_output.put_line('Total employees in employee table ' || total_emp);
end;
/
---------------------------------------------------------------------------
create or replace function max_sal(e_id IN number) 
return int is
sal int;
begin
select max(salary) into sal from employees where employee_id=e_id;
return sal;
end;
/

declare
e_sal int;
begin
e_sal:=max_sal(100);
dbms_output.put_line(e_sal);
end;
/

-----------------------------------------------------------------------------------
declare
cursor e_employee is select employee_id,first_name,last_name,salary from employees;
begin
for empInfo in e_employee loop
dbms_output.put_line(empInfo.employee_id || empInfo.first_name || empInfo.last_name || empInfo.salary );
end loop;
end;
/
---------------------------------------------------------------------------------
declare
emp_id int;
emp_res int;
begin
emp_id:=&emp_id;
select employee_id into emp_res from employees where employee_id=emp_id;
if(sql%found) then
dbms_output.put_line(sql%rowcount || 'employee Id is found ' || emp_res);
else
dbms_output.put_line('employee not found');
end if;
end;
/
-------------------------------------------------------------------------------
DECLARE 
   employee_rec employees%rowtype;
   emp_id int;
BEGIN
    emp_id:=&emp_id;
   select * into employee_rec from employees where employee_id = emp_id;  
   dbms_output.put_line('Employee ID: ' || employee_rec.employee_id); 
   dbms_output.put_line('Employee FirstName: ' || employee_rec.first_name); 
   dbms_output.put_line('Employee lastName: ' || employee_rec.last_name); 
   dbms_output.put_line('Employee Salary: ' || employee_rec.salary); 
END; 
/
--------------------------------------------------------------------------------
--Assignment 1
--1
set serveroutput on;
declare
 cursor emp_rec is select employee_id,first_name,job_id,salary,trunc(Months_between(sysdate,hire_date)/12) exprs from employees;
 incre_exp int:=0;
begin
    dbms_output.put_line('Ename  ' ||  ' Designation  '|| 'New salary '); 
    for emp_detail in emp_rec loop
    incre_exp:=
    case
    when emp_detail.exprs < 2 then
    15
    when emp_detail.exprs > 2 and emp_detail.exprs < 4 then
    25
    when emp_detail.exprs > 4 then
    35
    end;
    update employees set salary=salary+(salary*incre_exp)/100 where employee_id=emp_detail.employee_id;
    dbms_output.put_line(emp_detail.first_name||' ' || emp_detail.job_id || ' '|| emp_detail.salary);
    end loop;
end;
/
--------------------------------------------------------------------------------------------
--2. Write a PL/SQL code to accept an employee number from the user and display whether it is exists or not.

declare
emp_id int;
emp_res int;
begin
emp_id:=&emp_id;
select employee_id into emp_res from employees where employee_id=emp_id;
if(sql%found) then
dbms_output.put_line(sql%rowcount || 'employee Id is found ' || emp_res);
else
dbms_output.put_line('employee not found');
end if;
end;
/
------------------------------------------------------------------------------
--3. Write a PL/SQL code to display the name, salary and grade of the employee by accepting employee code. Grade is ‘A’ if salary >25000, ‘B’ if salary > 15000, ‘C’ for other salaries. (Use CASE statement)
declare
    cursor emp_grade is select first_name,salary from employees;
    grade varchar(3);
begin
    for emp_record in emp_grade loop
    grade:=
    case
    when emp_record.salary > 25000 then 
    'A'
    when emp_record.salary >15000 then 
    'B'
    else
    'C'
    end;
    dbms_output.put_line(emp_record.first_name||' '||emp_record.salary||' '||grade);
    end loop;
end;
/
-------------------------------------------------------------------------------
--4. Display the details of Account Holders whose credit limit exceeds Rs.1,00,000. 
declare
    bank_detail bank%rowtype;
begin
    select * into bank_detail from bank where limit_balance>100000;
    dbms_output.put_line(Ename||E_id||account_type);
end;
/
-----------------------------------------------------------------------------
--5. In a loop, use a cursor to retrieve the department number and department name from the DEPT table for those departments whose dept_no is less than 
--40. Use the same cursor to display the employee details for those employees working for HR Department
declare
   cursor dept_rec is select department_id,department_name from departments where department_id < 40;
begin
    for dept_res in dept_rec loop
    dbms_output.put_line(dept_res.department_id||'  '||dept_res.department_name);
    end loop;
end;
/
----------------------------------------------------------------------------------------------
--Assignment 2
--1. Retrieve the first 5 employees with a job history.
set serveroutput on;
declare

begin
    for em in (select first_name,job_id from employees where rownum<=5) loop
    dbms_output.put_line(em.first_name || ' ' ||em.job_id);
    end loop;
end;
/
--------------------------------------------------------------------------------
--2. Develop a PL/SQL block that determines the top employees with respect to salaries.
declare
begin
     for em in (select employee_id,first_name,last_name,salary from employees order by salary desc) loop
    dbms_output.put_line(em.employee_id||' '||em.first_name || ' ' ||em.last_name||' '||em.salary);
    end loop;
end;
/
-------------------------------------------------------------------------------------
--2a &b &c Accept a number n from the user where n represents the number of top n earners from the new_emp table.
declare
    n int;
    type emp_sal is table of int;
    EmpSal emp_sal;
begin
    n:=&n;
    for i in 1..n loop
    select distinct salary bulk collect into EmpSal from employees order by salary desc;
    dbms_output.put_line('Top Salary : '|| EmpSal(i));
    end loop;
end;
/
---------------------------------------------------------------------------------
--3. Develop a Procedure which will add an employee record into an Employee Database.
create or replace procedure add_employee(
eno in newemp.empno%type,
ename in newemp.ename%type,
sal in newemp.salary%type,
mgr_nam in newemp.mgr%type,
dept in newemp.deptno%type)
is
begin
    insert into newemp("EMPNO","ENAME","SALARY","MGR","DEPTNO") values(eno,ename,sal,mgr_nam,dept);
    COMMIT;
end;
/

begin
    add_employee(101,'Manish',50000,2001,1001);
end;
/
-------------------------------------------------------------------------------
--5a and c. Create a procedure called QUERY_EMP to query the NEW_EMP table, retrieving the salary and job ID for an employee when provided with the employee ID.
create or replace procedure query_emp(empId employees.employee_id%type) as
Ename employees.last_name%TYPE;
sal employees.salary%type;
jobId employees.job_id%type;
begin
    
    select first_name,salary,job_id  into Ename,sal,jobId from employees where employee_id=empId;
    dbms_output.put_line(Ename||' '||sal||' '||jobId);
    commit;
end;
/

begin
    query_emp(103);
end;
/
-----------------------------------------------------------------------------
--5b. Use bind variables for the two OUT parameters salary and job ID.
create or replace procedure bind_var(empId in employees.employee_id%type) as
sal employees.salary%type;
jobId employees.job_id%type;

begin
    sal:=6500;
    jobId:='SA_MAN';
    select salary,job_id  into sal,jobId from employees where employee_id=empId;
    dbms_output.put_line(sal||' '||jobId);
    commit;
end;
/

begin
    bind_var(104);
end;
/
----------------------------------------------------------------------------
--6. Develop a Function which will increase salary by 15% of all employees.

create or replace function inc_sal(
incrmnt in int,
salary in int)
return int as
begin
   return (salary*incrmnt)/100;
end;
/

select employee_id,first_name,salary,inc_sal(15,salary)Increment_salary_amount from employees;
---------------------------------------------------------------------------
--7. Create a procedure, NEW_EMP to insert a new employee into the EMPLOYEES table. The procedure should contain a call to the 
--VALID_DEPTID function to check whether the department ID specified for the new employee exists in the DEPARTMENTS table.
create or replace function valid_deptid
(dept_id IN departments.department_id%TYPE)
return boolean
is
  temp_dept departments.department_id%TYPE;
begin
  Select department_id into temp_dept from departments where department_id = dept_id;
  return true;
exception
  when no_data_found then
    return false;
end valid_deptid;
/

create or replace procedure new_emp(
eno in newemp.empno%type,
ename in newemp.ename%type,
sal in newemp.salary%type,
mgr_nam in newemp.mgr%type,
dept in newemp.deptno%type)
is
invalid_dept exception;
begin
    if(valid_deptid(dept)) then
    insert into newemp("EMPNO","ENAME","SALARY","MGR","DEPTNO") values(eno,ename,sal,mgr_nam,dept);
    else
    raise invalid_dept;
    end if;

end;
/

begin
new_emp(103,'Mauriya',60000,2002,80);
end;
/
------------------------------------------------------------------------------------
--Assignment 3
--Create a package called OVER_LOAD. Create two functions in this package,name each function PRINT_IT. The function accepts a date or a character 
--string and prints a date or a number, depending on how the function is invoked.
--Note:
--a. To print the date value, use DD-MON-YY as the input format, and FmMonth, dd yyyy as the output format .Make sure to handle invalid input.
--b. To print out the number, use 999,999.00 as the input format

create or replace package over_load is
procedure print_it(dt in varchar);
procedure print_it(mon in varchar,ddt in varchar,ye in varchar);
end over_load;
/

create or replace package body over_load is
procedure print_it(dt in varchar) 
is
begin
    dbms_output.put_line(dt);
end print_it;


procedure print_it(mon in varchar,ddt in varchar,ye in varchar)
is
begin
    dbms_output.put_line( mon||ddt||ye);
end print_it;

begin
    dbms_output.put_line('initializing');
end over_load;
/

set serveroutput on;
declare
    dttt varchar(15);
    mont varchar(5);
    ddt varchar(5);
    yer varchar(5);
begin
    dttt:='12-05-2005';
    mont:='JUN';
    ddt:='1';
    yer:='1998';
    over_load.print_it(dttt);
    over_load.print_it(mont,ddt,yer);
end;
/
----------------------------------------------------------------------------
--Assignment 4
--1. Modifications to data are allowed on tables only during normal office hours of 9:00 a.m. until 6:00 p.m., i.e. Monday through Friday.
--Create a stored procedure called RESTRICT_DML that prevents the DML statements from executing outside of normal office hours, returning an 
--alert message, “You may make changes only during normal business hours.
create or replace procedure restrict_dml is
begin
    if (to_char(sysdate,'h24:mi') not between '09:00' and '18:00' and to_char(sysdate,'day') not between 'MONDAY' and 'FRIDAY') then
    HTP.P('You may make changes only during normal business hours');
    end if;
end;
/
------------------------------------------------------------------------------------
--2 Create a statement trigger on the NEW_EMP table that calls the above procedure.
create or replace trigger restrict_trigger 
before insert or update or delete on newemp
begin
    restrict_dml();
end;
/
--------------------------------------------------------------------------------
-- 3. Employee should receive an automatic increase in salary if the minimum salary for a job is increased. Implement this requirement through a trigger on the JOBS table.  
--a. Create a stored procedure named UPD_EMP_SAL to update the salary amount. This procedure accepts two parameters: the job ID for which salary has to be updated and the new minimum salary for this 
--job ID. This procedure is executed from the trigger on the JOBS table.
create or replace procedure udp_emp_sal
(jobId jobs.job_id%rowtype,
minSal jobs.min_salary%rowtype)
is
begin
   update jobs set min_salary=minSal where job_id=jobId;
end;
/

--b. Create a row trigger named UPDATE_EMP_SALARY on the JOBS table that invokes the procedure UPD_EMP_SAL when the minimum salary in the JOBS table is updated for a specified job ID .
create or replace trigger update_emp_salary
before update on jobs
begin
    udp_emp_sal(9000,'PU_MAN');
end;
/


-- c. Query the EMPS table to see the current salary for employees who are programmers.

Select employee_id, job_id, salary from employees order by job_id, employee_id;

-- d. Increase the minimum salary for the Programmer job from 20,000 to 25,000.

update jobs set min_salary = 25000 Where job_id = 'IT_PROG';


-------------------------------------------------------------------------------------------
--4. Create a trigger for the DEPT table so that whatever a row is deleted from it, the corresponding rows of EMPS table are also deleted
create or replace trigger trig_name
After delete on employees
begin
    delete from employees e where exists (select d.department_id from departments d where e.department_id=d.department_id);
end;
/

delete from departments where department_id=70;
