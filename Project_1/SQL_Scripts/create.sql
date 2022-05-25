CREATE TABLE reimbursements (
	reimbursements_id serial PRIMARY KEY,
  author INT NOT NULL REFERENCES users (user_id),
  resolver INT REFERENCES users (user_id),
  description TEXT NOT NULL,
  type VARCHAR(250),
  status VARCHAR(250),
  amount DOUBLE NOT NULL
);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
  username VARCHAR(250),
  password VARCHAR(250),
	role VARCHAR(250)
);

INSERT INTO users (username, password, role)
VALUES ('default', 'guest', 'EMPLOYEE'),
	   ('cjenkins', 'cjenkins101', 'MANAGER'),
	   ('codytaylor', 'codytaylorjenkins', 'EMPLOYEE'
     );


SELECT * FROM reimbursements;


SELECT * FROM users;
