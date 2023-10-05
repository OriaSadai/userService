DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300),
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    date_birth DATE NOT NULL DEFAULT '',
    address varchar(300) NOT NULL DEFAULT 'Israel',
    joined_date DATE NOT NULL DEFAULT CURDATE(),
    is_registered boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);