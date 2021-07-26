DROP TABLE IF EXISTS person;

CREATE TABLE IF NOT EXISTS person (
	id INTEGER IDENTITY PRIMARY KEY,
	name VARCHAR ( 50 ) NOT NULL,
	last_name VARCHAR ( 50 ) NOT NULL,
	cellphone VARCHAR ( 50 ) NOT NULL,
	city_name VARCHAR ( 50 ) NOT NULL,
	created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	deleted_on TIMESTAMP,
	update_on TIMESTAMP
);

DROP TABLE IF EXISTS position;

CREATE TABLE IF NOT EXISTS position (
	id INTEGER IDENTITY PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_on TIMESTAMP,
	update_on TIMESTAMP  
);

DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee (
	id INTEGER IDENTITY PRIMARY KEY,
	person_id VARCHAR ( 50 ) NOT NULL,
	position_id INTEGER NOT NULL,
	salary DECIMAL NOT NULL,
	created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_on TIMESTAMP,
	update_on TIMESTAMP 
);

ALTER TABLE employee
    ADD FOREIGN KEY (person_id) 
    REFERENCES person(id);
    
 ALTER TABLE employee
    ADD FOREIGN KEY (position_id) 
    REFERENCES position(id);
    
INSERT INTO person(id, name, last_name, cellphone, city_name) values(1, 'sergio', 'alfonso', '313313', 'bogota');
INSERT INTO person(id, name, last_name, cellphone, city_name) values(2, 'andres', 'alfonso', '212212', 'medellin');
INSERT INTO person(id, name, last_name, cellphone, city_name) values(3, 'diego', 'alfonso',  '414414', 'manizales');
INSERT INTO person(id, name, last_name, cellphone, city_name) values(4, 'felipe', 'alfonso', '212212', 'cartagena');

INSERT INTO position(id, name) values(1, 'developer');
INSERT INTO position(id, name) values(2, 'tester');

INSERT INTO employee(id, person_id, position_id, salary) values(1, 1, 1, '100');
INSERT INTO employee(id, person_id, position_id, salary) values(2, 2, 2, '200');
INSERT INTO employee(id, person_id, position_id, salary) values(3, 3, 1, '400');
INSERT INTO employee(id, person_id, position_id, salary) values(4, 4, 2, '500');