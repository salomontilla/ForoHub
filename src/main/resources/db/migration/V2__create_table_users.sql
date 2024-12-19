create table users (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(300) not null,
    primary key (id)
);