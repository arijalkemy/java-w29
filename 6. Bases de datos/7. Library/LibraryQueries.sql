-- Create 5 registers in all tables
INSERT INTO author VALUES (1, 'Rafael Obligado', 'AR');
INSERT INTO author VALUES (2, 'Jorge Luis Borges', 'AR');
INSERT INTO author VALUES (3, 'Julio Cortázar', 'AR');
INSERT INTO author VALUES (4, 'Isabel Allende', 'CL');
INSERT INTO author VALUES (5, 'Gabriel García Márquez', 'CO');
INSERT INTO author VALUES (6, 'Albert Camus', 'FR');
INSERT INTO author VALUES (7, 'Umberto Eco', 'IT');
INSERT INTO author VALUES (8, 'Tim Berners-Lee', 'UK'); 
INSERT INTO author VALUES (9, 'Oliver Berry', 'UK');
INSERT INTO author VALUES (10, 'Mark A. Garlick', 'UK');
INSERT INTO author VALUES (11, 'Mark Mackenzie', 'UK');
INSERT INTO author VALUES (12, 'Valerie Stimac', 'US');

INSERT INTO book VALUES (1, 'El Gaucho Martín Fierro', 'Editorial Sudamericana', 'Poesía'); 
INSERT INTO book VALUES (2, 'Ficciones', 'Emecé Editores', 'Ficción'); 
INSERT INTO book VALUES (3, 'Rayuela', 'Alfaguara', 'Ficción'); 
INSERT INTO book VALUES (4, 'La casa de los espíritus', 'Plaza & Janés', 'Realismo mágico'); 
INSERT INTO book VALUES (5, 'Cien años de soledad', 'Sudamericana', 'Realismo mágico'); 
INSERT INTO book VALUES (6, 'The Stranger', 'Gallimard', 'Philosophical fiction'); 
INSERT INTO book VALUES (7, 'The Name of the Rose', 'Bompiani', 'Historical fiction');
INSERT INTO book VALUES (8, 'Weaving the Web', 'HarperSanFrancisco', 'Internet'); 
INSERT INTO book VALUES (9, 'El Universo: Guía de viaje', 'Lonely Planet', 'Astronomía'); 

INSERT INTO book_author VALUES (1, 1, 1);
INSERT INTO book_author VALUES (2, 2, 2);
INSERT INTO book_author VALUES (3, 3, 3);
INSERT INTO book_author VALUES (4, 4, 4);
INSERT INTO book_author VALUES (5, 5, 5);
INSERT INTO book_author VALUES (6, 6, 6);
INSERT INTO book_author VALUES (7, 7, 7);
INSERT INTO book_author VALUES (8, 8, 8);
INSERT INTO book_author VALUES (9, 9, 9);
INSERT INTO book_author VALUES (10, 9, 10);
INSERT INTO book_author VALUES (11, 9, 11);
INSERT INTO book_author VALUES (12, 9, 12);

INSERT INTO student VALUES (1, 'Juan', 'Pérez', 'Calle 123', 'Informática', 22);
INSERT INTO student VALUES (2, 'María', 'González', 'Carrera 456', 'Medicina', 25);
INSERT INTO student VALUES (3, 'Pedro', 'Rodríguez', 'Avenida 789', 'Derecho', 21);
INSERT INTO student VALUES (4, 'Ana', 'Martínez', 'Calle 10 # 20-30', 'Arquitectura', 23);
INSERT INTO student VALUES (5, 'Luis', 'Sánchez', 'Carrera 5 # 15-45', 'Economía', 24);

INSERT INTO loan VALUES (1, 1, 2, '2023-05-10', '2023-05-24', TRUE); -- Juan Pérez borrowed "Ficciones" 
INSERT INTO loan VALUES (2, 3, 3, '2023-06-15', '2023-07-01', FALSE); -- Pedro Rodríguez borrowed "Rayuela" and hasn't returned it
INSERT INTO loan VALUES (3, 2, 1, '2023-04-02', '2023-04-16', TRUE); -- María González borrowed "El Gaucho Martín Fierro"
INSERT INTO loan VALUES (4, 5, 5, '2023-07-20', '2023-08-03', TRUE); -- Luis Sánchez borrowed "Cien años de soledad"
INSERT INTO loan VALUES (5, 4, 4, '2023-08-12', NULL, FALSE); -- Ana Martínez borrowed "La casa de los espíritus" and hasn't returned it (no return date)
INSERT INTO loan VALUES (6, 5, 2, '2023-05-25', '2023-05-30', TRUE); -- Luis Sánchez borrowed "Ficciones"

-- 1. Listar los datos de los autores.
SELECT *
FROM author;

-- 2. Listar nombre y edad de los estudiantes
SELECT name, lastname, age
FROM student;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT name, lastname
FROM student
WHERE career = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT name, nationality
FROM author
WHERE nationality = 'FR' OR nationality = 'IT';

-- 5. ¿Qué libros no son del área de internet?
SELECT title, area
FROM book
WHERE area != 'Internet';

-- 6. Listar los libros de la editorial Bompiani.
SELECT *
FROM book
WHERE editorial = 'Bompiani';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM student
WHERE age > (SELECT AVG(age) FROM student);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT name, lastname
FROM student
WHERE lastname LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.name
FROM author AS a
JOIN book_author AS ba ON ba.id_author = a.id_author
JOIN book AS b ON ba.id_book1 = b.id_book
WHERE b.title = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Pedro Rodríguez”?
SELECT b.title
FROM book AS b
JOIN loan AS l ON l.id_book = b.id_book
JOIN student AS s ON l.id_reader = s.id_reader
WHERE s.name = 'Pedro' AND s.lastname = 'Rodríguez';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT name, lastname
FROM student
ORDER BY age
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Realismo Mágico.
SELECT s.name, s.lastname
FROM student AS s
JOIN loan AS l ON l.id_reader = s.id_reader
JOIN book AS b ON b.id_book = l.id_book
WHERE b.area = 'Realismo Mágico';

-- 13. Listar los libros que pertenecen a la autora Valerie Stimac.
SELECT b.title 
FROM book AS b
JOIN book_author AS ba ON ba.id_book1 = b.id_book
JOIN author AS a ON a.id_author = ba.id_author
WHERE a.name = 'Valerie Stimac';

-- 14. Listar títulos de los libros que debían devolverse el 30/05/2023.
SELECT b.title
FROM book AS b
JOIN loan AS l ON b.id_book = l.id_book
WHERE l.return_date = '2023-05-30';