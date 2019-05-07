run "ai.bat" to install LMS with parental controls

requirements:-

java 8 or above

database:-
mysql  
user - root
password- mysql

*****database - "id" with table "id_table"

command
-------

create database id;

use id;

create table id_table(
email varchar(50) Primary key,
password varchar(20) Not null
);

*****database - "login"  **no tables**

command
-------

create database login;