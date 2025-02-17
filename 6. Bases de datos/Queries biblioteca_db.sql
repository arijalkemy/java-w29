-- 1. Listar los datos de los autores.
SELECT a.id_autor,a.nombre,n.nombre AS nacionalidad FROM autores a
INNER JOIN nacionalidades n
ON a.nacionalidad = n.id_nacionalidad;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre,apellido,edad FROM estudiantes;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre,apellido,carrera FROM estudiantes WHERE carrera = 'Informatica';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre,n.nombre AS nacionalidad FROM autores a
INNER JOIN nacionalidades n
ON a.nacionalidad = n.id_nacionalidad
WHERE n.nombre='Francesa' OR n.nombre='Italiana'; 

-- 5. ¿Qué libros no son del área de internet?
SELECT id_libro, titulo, editorial, area FROM libros WHERE NOT area='Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT id_libro, titulo, editorial, area FROM libros WHERE editorial='Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, edad FROM estudiantes WHERE edad > (SELECT AVG(edad) FROM estudiantes);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre,apellido FROM estudiantes WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autores a
INNER JOIN autor_libro al ON a.id_autor = al.id_autor
INNER JOIN libros l ON al.id_libro = l.id_libro
WHERE l.titulo = 'El universo: Guia de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM libros l
INNER JOIN prestamos p ON l.id_libro=p.id_libro
INNER JOIN estudiantes e ON p.id_lector=e.id_lector
WHERE e.nombre = 'Filippo' AND e.apellido='Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido, edad 
FROM estudiantes 
WHERE edad = (SELECT MIN(edad) FROM estudiantes);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre,e.apellido FROM estudiantes e
INNER JOIN prestamos p ON e.id_lector=p.id_lector
INNER JOIN libros l ON l.id_libro=p.id_libro
WHERE l.area='Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libros l
INNER JOIN autor_libro al ON l.id_libro=al.id_libro
INNER JOIN  autores a ON al.id_autor=a.id_autor
WHERE a.nombre='J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo FROM libros l
INNER JOIN prestamos p 
ON l.id_libro=p.id_libro
WHERE p.fecha_devolucion = '2021/07/16';