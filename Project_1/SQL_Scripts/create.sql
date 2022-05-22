CREATE TABLE reimbursements (
	reimbursements_id serial PRIMARY KEY,
  author INT NOT NULL REFERENCES employees (employee_id),
  resolver INT REFERENCES employees (employee_id),
  description TEXT NOT NULL,
  type VARCHAR(250),
  status VARCHAR(250),
  amount FLOAT NOT NULL
);

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
  username VARCHAR(250),
  password VARCHAR(250),
	role VARCHAR(250)
);

INSERT INTO employees (username, password, role)
VALUES ('default', 'guest', 'employee'),
	   ('cjenkins', 'cjenkins101', 'manager'),
	   ('codytaylor', 'codytaylorjenkins', 'employee'
     );


SELECT * FROM reimbursements;


SELECT * FROM employees;
