create database top_movies;

use top_movies;

create table user (
 
 userId int(11) NOT NULL AUTO_INCREMENT, 
 UserName varchar(45) NOT NULL,
 UserEmail varchar(200) NOT NULL,
 PRIMARY KEY ('userId')
 
) ENGINE=InnoDB AUTO INCREMENT=1 DEFAULT CHARSET=utf-8;

