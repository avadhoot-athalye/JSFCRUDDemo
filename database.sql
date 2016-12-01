Create table query

CREATE TABLE EMPLOYEE (
id IDENTITY,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
salary number(10,2) NOT NULL,
working boolean DEFAULT 'TRUE',
CONSTRAINT pk_employee_id PRIMARY KEY(id)
);

To drop all objects and constraints
DROP ALL OBJECTS;

To insert values
INSERT INTO EMPLOYEE (first_name, last_name, salary, working) 
VALUES ('Avadhoot','Athalye',15000.00, true);

or

INSERT INTO EMPLOYEE (first_name, last_name, salary) 
VALUES ('Avadhoot','Athalye',15000.00, );