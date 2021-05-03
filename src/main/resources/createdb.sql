DROP TABLE users;
DROP TABLE food;
DROP TABLE orderhistory;
DROP TABLE user_roles;

--function 1
CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    phone CHAR(8) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
--function 2
CREATE TABLE food (
    itemid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    itemname VARCHAR(50) NOT NULL,
--addition feature 2
    photo BLOB,
    price VARCHAR(255) NOT NULL,
    selling BOOLEAN NOT NULL,
    PRIMARY KEY (itemid)
);
--additional feature 1
CREATE TABLE orderhistory (
    order_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    totalprice INTEGER NOT NULL,
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
CREATE TABLE comment(
    username VARCHAR(50) NOT NULL,
    itemid INTEGER NOT NULL,
    content VARCHAR(255) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (itemid) REFERENCES food(itemid)
);

--food data
INSERT INTO food (itemname, price, selling)
VALUES ('cheeseburger', '30', true);
INSERT INTO food (itemname, price, selling)
VALUES ('fried fries', '10', true);
INSERT INTO food (itemname, price, selling)
VALUES ('keith burger', '100', true);

--user data
INSERT INTO users VALUES ('admin', '{noop}admin','test','88888888','addressdllm265');
INSERT INTO user_roles(username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles(username, role) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO users VALUES ('root', '{noop}root','test','88888888','addressdllm265');
INSERT INTO user_roles(username, role) VALUES ('root', 'ROLE_ADMIN');

INSERT INTO users VALUES ('user', '{noop}user','test','88888888','addressdllm265');
INSERT INTO user_roles(username, role) VALUES ('user', 'ROLE_USER');
