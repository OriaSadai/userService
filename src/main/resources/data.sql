DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    age int(2),
    address varchar(300) NOT NULL DEFAULT 'Israel',
    joining_date date NOT NULL,
    is_registered boolean NOT NULL DEFAULT 'false'
);