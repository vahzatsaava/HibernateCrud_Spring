create table if not exists users
(
    id         int auto_increment primary key,
    user_name  varchar (250)          not null unique,
    email      varchar(250)           not null unique,
    first_name varchar(250)           not null,
    last_name  varchar(250)           not null,
    password   varchar(250)           not null,
    status     varchar (20)           not null default 'ACTIVE'

    );

     create table if not exists roles(
     id int auto_increment primary key,
     name varchar(100) not null

     );
create table if not exists user_roles(
    user_id int not null ,
    roles_id int not null,
    foreign key (user_id) references users(id),
    foreign key (roles_id) references roles(id)
)


create table if not exists files
(
    id       int auto_increment primary key,
    fileName varchar(250)           not null,
    location varchar(250)           not null,
    status     varchar (20)           not null default 'ACTIVE'

    );

create table if not exists  events
(
    id      serial  not null primary key,
    file_id int not null,
    users_id int not null,
    status     varchar (20)   not null default 'ACTIVE',
    created    data not null ,
    updated    data not null ,
    foreign key (users_id) references users(id),
    foreign key (file_id) references files (id),
    unique (users_id,file_id)
    );