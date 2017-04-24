--SIMPLE EMPLOYEE DATABASE
--Drop existing tables
drop table employee;
drop table department;
--Create tables
create table department (deptno number primary key, name varchar(20));
create table employee (empno number primary key, name varchar(20), age number, sal number, deptno number references department(deptno));
--Insert data
insert into department values (1,'Physics');
insert into department values (2,'Maths');
insert into department values (3,'Chemistry');
insert into employee values (1,'Ramesh',22,10000,1);
insert into employee values (2,'Suresh',25,20000,1);
insert into employee values (3,'Mahesh',24,25000,2);
insert into employee values (4,'Naresh',55,20000,2);
insert into employee values (5,'Rajesh',20,30000,3);
insert into employee values (6,'Lokesh',40,28000,3);

--Retrieve data
select * from employee;
select * from department;