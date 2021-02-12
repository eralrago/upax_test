CREATE SCHEMA upax;

USE upax;

CREATE TABLE jobs (
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    salary FLOAT(9,2),
    PRIMARY KEY (id)
);

CREATE TABLE genders (
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

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

CREATE TABLE employees_worked_hours (
	id INT NOT NULL AUTO_INCREMENT,
    employee_id INT NOT NULL,
    worked_hours INT,
    worked_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);
