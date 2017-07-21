drop table if exists User
create table User (id varchar(255) not null, name varchar(255), password varchar(255), createTime date, expireTime date, primary key (id))
