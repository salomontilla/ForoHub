create table users (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(300) not null,
    primary key (id)
);
insert into users (username, password)
values ('admin', '$2a$12$fBUZfFI/FV3ym814.nnQ3.KtOBkrSu450Wh0zmArzx9UAJ2td0psO');