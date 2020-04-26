update mysql.user set host = '%' where user='root';

CREATE TABLE users (
    id int PRIMARY KEY,
    name varchar(100),
    email varchar(100),
    password varchar(100)
);
