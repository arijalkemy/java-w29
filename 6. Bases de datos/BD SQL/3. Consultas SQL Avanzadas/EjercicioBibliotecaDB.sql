-- 1. Listar los datos de los autores.
SELECT * FROM Autores;

-- 2. Listar nombre y edad de los estudiantes.
SELECT
	nombre,
    edad
FROM Estudiantes;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM Estudiantes
WHERE carrera = 'Ingeniería Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM Autores
WHERE nacionalidad IN ('Francia', 'Italia');

-- 5. ¿Qué libros no son del área de internet?
SELECT *
FROM Libros
WHERE area NOT LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM Libros
WHERE editorial LIKE 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM Estudiantes
WHERE edad > (SELECT AVG(edad) FROM Estudiantes);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT 
	nombre
FROM Estudiantes
WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje” (se debe listar solamente los nombres).
SELECT 
	A.nombre
FROM Autores A
JOIN Libro_Autor LA ON A.autor_id = LA.autor_id
JOIN Libros L ON LA.libro_id = L.libro_id
WHERE L.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT
	L.titulo
FROM Libros L
JOIN Prestamos P ON L.libro_id = P.libro_id
JOIN Estudiantes E ON E.lector_id = P.lector_id
WHERE E.nombre = 'Filippo' AND E.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT 
	CONCAT(nombre, ' ', apellido) AS 'Nombre completo'
FROM Estudiantes
WHERE edad = (SELECT MIN(edad) FROM Estudiantes);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT 
	DISTINCT CONCAT(E.nombre, ' ', E.apellido) AS 'Nombre completo'
FROM Estudiantes E
JOIN Prestamos P ON E.lector_id = P.lector_id;

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
INSERT INTO Libro_Autor (libro_id, autor_id) 
	SELECT 
		libro_id, 
		13 
	FROM Libros 
	WHERE titulo LIKE 'Harry Potter%';
    
SELECT 
	L.titulo
FROM Autores A
JOIN Libro_Autor LA ON A.autor_id = LA.autor_id
JOIN Libros L ON LA.libro_id = L.libro_id
WHERE A.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT
	L.titulo
FROM Libros L
JOIN Prestamos P ON L.libro_id = P.libro_id
WHERE DATE(P.fecha_devolucion) = '2021-07-16';