CREATE SCHEMA upax;

USE upax;

CREATE TABLE jobs (
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    salary FLOAT(9,2),
    PRIMARY KEY (id)
);

INSERT INTO jobs (name, salary) VALUES ('Director', 100000.00);
INSERT INTO jobs (name, salary) VALUES ('Subdirector', 80000.00);
INSERT INTO jobs (name, salary) VALUES ('Gerente', 60000.00);
INSERT INTO jobs (name, salary) VALUES ('Subgerenteerente', 50000.00);
INSERT INTO jobs (name, salary) VALUES ('Jefe de piso', 40000.00);
INSERT INTO jobs (name, salary) VALUES ('Lider de piso', 30000.00);

CREATE TABLE genders (
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO genders (name) VALUES ('Masculino');
INSERT INTO genders (name) VALUES ('Femenino');

CREATE TABLE employees (
	id INT NOT NULL AUTO_INCREMENT,
    gender_id INT NOT NULL,
    job_id INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birthdate DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (gender_id) REFERENCES genders(id),
    FOREIGN KEY (job_id) REFERENCES jobs(id)
);

INSERT INTO employees (`gender_id`, `job_id`, `name`, `last_name`, `birthdate`) VALUES (1, 1, 'Ernesto Alejandro', 'Ramirez Gomez', '1988-10-11');
INSERT INTO employees (`gender_id`, `job_id`, `name`, `last_name`, `birthdate`) VALUES (2, 2, 'Iris Abril', 'Ramirez Mijangos', '1986-02-26');


CREATE TABLE employees_worked_hours (
	id INT NOT NULL AUTO_INCREMENT,
    employee_id INT NOT NULL,
    worked_hours INT,
    worked_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

INSERT INTO employees_worked_hours (employee_id, worked_hours, worked_date) VALUES (1, 8, '2021-02-12'); 
INSERT INTO employees_worked_hours (employee_id, worked_hours, worked_date) VALUES (2, 8, '2021-02-12'); 

