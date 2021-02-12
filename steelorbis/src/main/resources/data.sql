CREATE TABLE IF NOT EXISTS user_details
(
   id          INT            NOT NULL AUTO_INCREMENT,
   name       VARCHAR(255),
   password  VARCHAR(255),
   PRIMARY KEY (id)
);

INSERT INTO user_details(name,password) VALUES ('ridvan','admin');
