CREATE TABLE author (
	id int PRIMARY KEY AUTO_INCREMENT,
	username varchar(50),
	password varchar(50),
	email varchar(50),
	bio varchar(50)
);
INSERT INTO author (username, password, email, bio)
VALUES ("zhangsan", "123456", "123@126.com", "bbb");