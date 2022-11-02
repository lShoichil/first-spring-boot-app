CREATE TABLE users (
    id bigserial primary key,
    username varchar (255),
    password varchar (255)
);

insert into users (username, password) values ('dlening', 'password');