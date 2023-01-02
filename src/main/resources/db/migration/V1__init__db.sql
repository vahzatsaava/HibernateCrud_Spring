create table if not exists users (
                       id bigint not null auto_increment,
                       email varchar(255),
                       first_name varchar(255),
                       last_name varchar(255),
                       password varchar(255),
                       status varchar(255),
                       username varchar(255),
                       primary key (id),
                       unique (email,username)
);
create table if not exists files (
                       id bigint not null auto_increment,
                       file_name varchar(255),
                       location varchar(255),
                       status varchar(255),
                       primary key (id)
);
create table if not exists events (
                        id bigint not null auto_increment,
                        created date,
                        status varchar(255),
                        updated date,
                        file_id bigint,
                        users_id bigint,
                        primary key (id),
                        foreign key (file_id) references files(id),
                        foreign key (users_id) references users(id)

);

create table if not exists roles (
                       id bigint not null auto_increment,
                       name varchar(255),
                       primary key (id)
);

create table if not exists user_roles (
                            user_id bigint not null,
                            roles_id bigint not null,
                            foreign key (user_id) references users(id),
                            foreign key (roles_id) references roles(id)
);
