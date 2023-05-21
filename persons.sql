CREATE TABLE persons(
                      person_id integer primary key,
                      name varchar(30) NOT NULL,
                      surname varchar(30) NOT NULL,
                      email varchar(50) NOT NULL,
                      passwor varchar(50) NOT NULL
);

INSERT INTO persons
VALUES(1,'Ivan','Ivanov','ivan@gmail.com','12345'),
      (2,'Ola','Tkach','ola@gmail.com','23456'),
      (3,'Slava','Sidorov','slava@gmail.com','34567'),
      (4,'Lena','Polakova','lena@gmail.com','45678'),
      (5,'Dima','Popov','dima@gmail.com','56789'),
      (6,'Rostik','Alibov','rostika@gmail.com','67891'),
      (7,'Diana','Zubkova','diana@gmail.com','78912');

SELECT * FROM persons;


