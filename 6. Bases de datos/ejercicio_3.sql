-- Listar los datos de los autores.
SELECT * 
FROM AUTOR;

-- Listar nombre y edad de los estudiantes.
SELECT Nombre, Edad 
FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * 
FROM ESTUDIANTE 
WHERE Carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * 
FROM AUTOR 
WHERE Nacionalidad IN ('Francesa', 'Italiana');

-- ¿Qué libros no son del área de internet?
SELECT * 
FROM LIBRO 
WHERE Area <> 'Internet';
		-- !=
-- Listar los libros de la editorial Salamandra.
SELECT * 
FROM LIBRO 
WHERE Editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM ESTUDIANTE 
WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre 
FROM ESTUDIANTE 
WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”.

SELECT a.nombre
FROM LIBROAUTOR la
JOIN LIBRO l ON l.idLibro = la.idLibro
JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE l.Titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli” ?
SELECT L.* 
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
JOIN ESTUDIANTE E ON P.idLector = E.idLector
WHERE CONCAT(E.Nombre, ' ', E.Apellido) = 'Filippo Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT Nombre 
FROM ESTUDIANTE 
ORDER BY Edad ASC 
LIMIT 1;

-- Listar el nombre del estudiante de menor edad. V2
SELECT e.Nombre 
FROM ESTUDIANTE e
WHERE e.edad = (SELECT MIN(e2.edad) FROM ESTUDIANTE e2)
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT E.Nombre 
FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.idLector = P.idLector
JOIN LIBRO L ON P.idLibro = L.idLibro
WHERE L.Area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT L.* 
FROM LIBRO L
JOIN LIBROAUTOR LA ON L.idLibro = LA.idLibro
JOIN AUTOR A ON LA.idAutor = A.idAutor
WHERE A.Nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT L.Titulo 
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
WHERE P.FechaDevolucion = '2021-07-16';