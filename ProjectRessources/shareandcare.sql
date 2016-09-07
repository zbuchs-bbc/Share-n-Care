create database SHAREANDCARE;

use SHAREANDCARE;

create table USER(
ID_USER INT not null auto_increment primary key,
Username varchar(45),
Firstname varchar(45),
Secondname varchar(45),
Email varchar(45),
Password varchar(45),
Password2 varchar(45)
);

create table ARTICLE(
ID_ARTICLE INT not null auto_increment primary key,
Input text(100),
Friend varchar(45),
Timestamp  timestamp,
User_ID int,
foreign key (User_ID) references USER (ID_User)
on delete set null on update no action
);

create table COMMENT(
ID_COMMENT INT not null auto_increment primary key,
Description text(100),
User_ID int,
foreign key (User_ID) references USER (ID_USer)
on delete set null on update no action,
Article_ID int,
foreign key (Article_ID) references ARTICLE (ID_Article)
);

insert into `USER`
(`ID_User`,`Username`,`Firstname`,`Secondname`, `Email`, `Password`, `Password2`)
values
(null, 'hanspeter', 'hans', 'peter', 'laura@hotmail.com', '123456', '123456');

insert into `ARTICLE`
(`ID_Article`,`Input`,`Friend`,`Timestamp`, `User_ID`)
values
(null, 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', '@hans, @lara', '2015-09-01 15:30', '1');

insert into `COMMENT`
(`ID_Comment`,`Description`,`User_ID`,`Article_ID`)
values
(null, 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.', '1', '1');

select * from USER;

select * from ARTICLE;

select * from COMMENT;