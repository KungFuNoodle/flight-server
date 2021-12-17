/*Create Databse*/

drop database if exists flight_app;
create database flight_app;
use flight_app;

/*Create Tables*/
Create table userAccounts
(
id int primary key auto_increment,
username varchar(255) not null unique,
email varchar(255) not null unique,
password varchar(255) not null
);


/*Seed Tables*/
Insert into userAccounts(username,email,password)
values("Admin","adminEmail@something.com","12345")