-- Incorporate 10 records in the customer table and 5 in the internet plans table
INSERT INTO plan VALUES (1, 10, 200, 0); 
INSERT INTO plan VALUES (2, 50, 450, 5);
INSERT INTO plan VALUES (3, 100, 800, 10);
INSERT INTO plan VALUES (4, 500, 1500, 20);
INSERT INTO plan VALUES (5, 30, 300, 15); 

-- Make the corresponding associations/relationships between these records.
INSERT INTO client VALUES (1, 112233, "Matias", "Leal", "1996-09-11", "Caba", "Buenos Aires", 1);
INSERT INTO client VALUES (2, 221133, "David", "Narvaez", "2000-12-04", "Bogota", "Bogota", 2);
INSERT INTO client VALUES (3, 332211, "Pablo", "Bernasconi", "1991-05-17", "Quilmes", "Buenos Aires", 3);
INSERT INTO client VALUES (4, 331122, "Catalina", "Morales", "1998-11-24", "Bogota", "Bogota", 4);
INSERT INTO client VALUES (5, 445566, "Andrés", "Gomez", "1985-05-10", "Medellin", "Antioquia", 5);
INSERT INTO client VALUES (6, 778899, "Sofia", "Rodriguez", "1968-09-15", "Cali", "Valle del Cauca", 1);
INSERT INTO client VALUES (7, 112233, "Juan", "Perez-Garcia", "1992-03-22", "Barranquilla", "Atlantico", 2);
INSERT INTO client VALUES (8, 990011, "Maria Fernanda", "Lopez", "2001-07-04", "Cartagena", "Bolivar", 3);
INSERT INTO client VALUES (9, 223344, "Luisa", "Fernández", "1977-12-18", "Bucaramanga", "Santander", 4);
INSERT INTO client VALUES (10, 556677, "Santiago", "Castro", "2004-01-01", "Pereira", "Risaralda", 5);

-- Pose 10 SQL queries that could be made to the database. Express the sentences.
-- 1. List all clients:
SELECT * FROM client;

-- 2. List clients and their chosen plan:
SELECT c.name, c.lastname, p.velocity
FROM client c
JOIN plan p ON c.id_plan = p.id_plan;

-- 3. Find clients in a specific city:
SELECT name 
FROM client
WHERE city = 'Bogota';

-- 4. Find clients with a specific plan:
SELECT c.name, c.lastname
FROM client c
JOIN plan p ON c.id_plan = p.id_plan
WHERE p.velocity = 50;

-- 5. List plans ordered by price:
SELECT id_plan, velocity
FROM plan
ORDER BY price ASC;

-- 6. Find the average price of all plans:
SELECT AVG(price) FROM plan;

-- 7. Count the number of clients for each plan:
SELECT p.id_plan, COUNT(*) AS number_of_clients
FROM client c
JOIN plan p ON c.id_plan = p.id_plan
GROUP BY p.id_plan;

-- 8. Find clients born between a specific dates:
SELECT name, lastname
FROM client
WHERE birth_date BETWEEN '1998-01-01' AND '2000-12-31';

-- 9. Find the client with the highest ID:
SELECT name, lastnames
FROM client
ORDER BY id_client DESC
LIMIT 1; 

-- 10. Find the client with the oldest birth date:
SELECT * FROM client ORDER BY birth_date ASC LIMIT 1;
