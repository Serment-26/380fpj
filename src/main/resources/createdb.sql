--function 1
CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(50) NOT NULL;
    phone CHAR(8) NOT NULL;
    address VARCHAR(255) NOT NULL;
    PRIMARY KEY (username)
);
--function 2
CREATE TABLE food (
    itemid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    itemname VARCHAR(50) NOT NULL,
    photo BLOB,
    price VARCHAR(255) NOT NULL,
    selling BOOLEAN NOT NULL,
    PRIMARY KEY (itemid)
);
--additional feature 1
CREATE TABLE user_roles (
    order_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (username) REFERENCES users(username)
);
--still thinking useabe or not
CREATE TABLE user_roles (
    user_role_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_role_id),
    FOREIGN KEY (username) REFERENCES users(username)
);
/*
INSERT INTO users VALUES ('keith', '{noop}keithpw');
INSERT INTO user_roles(username, role) VALUES ('keith', 'ROLE_USER');
INSERT INTO user_roles(username, role) VALUES ('keith', 'ROLE_ADMIN');

INSERT INTO users VALUES ('vanessa', '{noop}vanessapw');
INSERT INTO user_roles(username, role) VALUES ('vanessa', 'ROLE_ADMIN');

INSERT INTO users VALUES ('kevin', '{noop}kevinpw');
INSERT INTO user_roles(username, role) VALUES ('kevin', 'ROLE_USER');
*/