--**********************************
--Ajuste do NLS_CHARACTERSET
--**********************************
connect sys/oracle as sysdba;
shutdown;
startup restrict;
Alter database character set INTERNAL_USE WE8ISO8859P1;
shutdown immediate;
startup;
connect system/oracle

--**********************************
--Tuning OracleXE
--**********************************
alter system set filesystemio_options=directio scope=spfile;
alter system set disk_asynch_io=false scope=spfile;

--**********************************
--Esquema stox
--**********************************

create tablespace stox datafile '/u01/app/oracle/oradata/XE/stox01.dbf' size 4196M online;
create tablespace idx_stox datafile '/u01/app/oracle/oradata/XE/idx_stox01.dbf' size 1024M;
create user stox identified by stox default tablespace stox temporary tablespace temp;
grant resource to stox;
grant connect to stox;
grant create view to stox;
grant create procedure to stox;
grant create materialized view to stox;
alter user stox default role connect, resource;

exit;
