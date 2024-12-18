create table topics (
    id bigint not null auto_increment,
    title varchar(255) not null,
    message varchar(255) not null,
    creationDate datetime not null,
    status tinyint not null,
    autor varchar(255) not null,
    curse varchar(255) not null,
    primary key (id)
);