create table if not exists users
(
    id         int auto_increment primary key,
    email      varchar(250)           not null unique,
    first_name varchar(250)           not null,
    last_name  varchar(250)           not null,
    password   varchar(250)           not null,
    role       varchar(20)            not null default 'USER'

    );
create table if not exists files
(
    id       int auto_increment primary key,
    fileName varchar(250)           not null,
    location varchar(250)           not null,
    role     varchar(20)            not null default 'USER'
    );

create table if not exists  events
(
    id      serial  not null primary key,
    file_id int not null,
    users_id int not null,
    role varchar(20) not null default 'USER',
    foreign key (users_id) references users(id),
    foreign key (file_id) references files (id),
    unique (users_id,file_id)

    );