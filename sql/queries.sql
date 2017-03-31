--Steps to create a user

alter session set container=universitypdb;

CREATE TABLESPACE tbs_perm_01
    DATAFILE 'tbs_perm_01.dat'
    SIZE 10M
    REUSE
    AUTOEXTEND ON NEXT 10M MAXSIZE 200M;

--Use the following command only if something is wrong above and want to delete tablespace
--DROP TABLESPACE tbs_perm_01
    --  INCLUDING CONTENTS
    --  CASCADE CONSTRAINTS;

CREATE TEMPORARY TABLESPACE tbs_temp_01
   TEMPFILE 'tbs_temp_01.dat'
   SIZE 5M AUTOEXTEND ON;


CREATE USER dheeraj
  IDENTIFIED BY dheeraj
  DEFAULT TABLESPACE tbs_perm_01
  TEMPORARY TABLESPACE tbs_temp_01
  QUOTA 20M on tbs_perm_01;

GRANT create session TO dheeraj;
GRANT create table TO dheeraj;
GRANT create view TO dheeraj;
GRANT create any trigger TO dheeraj;
GRANT create any procedure TO dheeraj;
GRANT create sequence TO dheeraj;
GRANT create synonym TO dheeraj;

--Command to open a pluggable database from command prompt (need to login as dba (sys as sysdba))
ALTER PLUGGABLE DATABASE universitypdb OPEN READ WRITE force;

--To check list of pluggable databases (pdb) in oracle
SELECT NAME, CON_ID, DBID, CON_UID, GUID FROM V$CONTAINERS ORDER BY CON_ID;
