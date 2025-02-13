-- Listar los datos de los autores.
SELECT *
FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera ingenieria?
SELECT nombre, apellido
FROM ESTUDIANTE
WHERE carrera = 'Ingeniería';

-- ¿Qué autores son de nacionalidad británica o japonesa?
SELECT nombre
FROM AUTOR
WHERE nacionalidad = 'Británica' OR nacionalidad = 'Japonesa';

-- ¿Qué libros no son del área de fantasía?
SELECT *
FROM LIBRO
WHERE NOT área = 'Fantasía';

-- Listar los libros de la editorial Sudamericana.
SELECT *
FROM LIBRO
WHERE editorial = 'Sudamericana';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM ESTUDIANTE
WHERE edad > (
	SELECT AVG(edad)
    FROM ESTUDIANTE
);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM ESTUDIANTE
WHERE apellido LIKE 'G%';

-- Listar los autores del libro 'Cien años de soledad'. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM AUTOR a 
INNER JOIN LIBROAUTOR la ON a.idAutor = la.idAutor
INNER JOIN LIBRO l ON la.idLibro = l.idLibro
WHERE l.título = 'Cien años de soledad';

-- ¿Qué libros se prestaron al lector “Elena Torres”?
SELECT e.nombre, e.apellido, l.título
FROM ESTUDIANTE e
INNER JOIN PRESTAMO p ON e.idLector = p.idLector
INNER JOIN LIBRO l ON p.idLibro = l.idLibro
WHERE e.nombre = 'Elena' AND e.apellido = 'Torres';

-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido
FROM ESTUDIANTE e
WHERE e.edad = (
	SELECT MIN(e2.edad)
    FROM ESTUDIANTE e2
);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM ESTUDIANTE e
INNER JOIN PRESTAMO p ON e.idLector = p.idLector;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM LIBRO l
INNER JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
INNER JOIN AUTOR a ON la.idAutor = a.idAutor
WHERE a.Nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse antes del 11/10/2023.
SELECT l.título
FROM LIBRO l
INNER JOIN PRESTAMO p ON l.idLibro = p.idLibro
WHERE p.FechaDevolucion <  '2023-10-11';