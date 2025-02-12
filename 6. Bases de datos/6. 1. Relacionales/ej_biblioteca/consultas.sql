-- 1. Listar los datos de los autores.
SELECT a.nombre AS nombre, n.nombre AS nacionalidad
FROM autores a
    JOIN nacionalidades n ON n.id_nacionalidad = a.nacionalidad;

-- 2. Listar nombre y edad de los estudiantes.
SELECT nombre, apellido, edad FROM estudiantes;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM estudiantes WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre AS nombre, n.nombre AS nacionalidad
FROM autores a
    JOIN nacionalidades n ON n.id_nacionalidad = a.nacionalidad
WHERE n.nombre = 'Francesa' OR n.nombre = 'Italiana';

-- 5. ¿Qué libros no son del área de internet?
SELECT id_libro, titulo, editorial, area FROM libros WHERE area NOT LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT id_libro, titulo, area FROM libros WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, edad FROM estudiantes WHERE edad > (SELECT AVG(edad) FROM estudiantes);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiantes WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autores a
    JOIN autor_libro al ON al.id_autor = a.id_autor
    JOIN libros l ON l.id_libro = al.id_libro
WHERE l.Titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM libros l
    JOIN prestamos p ON p.id_libro = l.id_libro
    JOIN estudiantes e ON e.id_lector = p.id_lector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido, edad FROM estudiantes WHERE edad = (SELECT MIN(edad) FROM estudiantes);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM estudiantes e
    JOIN prestamos p ON p.id_lector = e.id_lector
    JOIN libros l ON l.id_libro = p.id_libro
WHERE l.Area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.id_libro, l.titulo, l.editorial, l.area
FROM libros l
    JOIN autor_libro la ON la.id_libro = l.id_libro
    JOIN autores a ON a.id_autor = la.id_autor
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libros l
    JOIN prestamos p ON p.id_libro = l.id_libro
WHERE p.fecha_devolucion = '2021-07-16';
