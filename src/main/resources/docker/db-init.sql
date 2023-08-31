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
--Esquema refactorsistemasenac
--**********************************

create tablespace refactorsistemasenac datafile '/u01/app/oracle/oradata/XE/refactorsistemasenac01.dbf' size 4196M online;
create tablespace idx_refactorsistemasenac datafile '/u01/app/oracle/oradata/XE/idx_refactorsistemasenac01.dbf' size 1024M;
create user refactorsistemasenac identified by refactorsistemasenac default tablespace refactorsistemasenac temporary tablespace temp;
grant resource to refactorsistemasenac;
grant connect to refactorsistemasenac;
grant create view to refactorsistemasenac;
grant create procedure to refactorsistemasenac;
grant create materialized view to refactorsistemasenac;
alter user refactorsistemasenac default role connect, resource;

exit;
