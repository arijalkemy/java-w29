use biblioteca;

-- 1. Listar los datos de los autores.
SELECT *
FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera = 'informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE nacionalidad = 'Francesa'
   OR nacionalidad = 'Italiana';

-- 5. ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE Area NOT LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'g%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
         JOIN libroautor la ON a.idautor = la.idautor
         JOIN libro l ON l.idlibro = la.idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM libro l
         JOIN prestamo p ON l.idlibro = p.idLibro
         JOIN estudiante e ON e.idLector = p.idlector
WHERE e.nombre = 'Filippo'
  AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT e.nombre
FROM estudiante e
WHERE e.edad < 18;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.*
FROM estudiante e
         JOIN prestamo p ON p.idlector = e.idlector
         JOIN libro l ON l.idlibro = p.idlibro
WHERE l.titulo = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libro l
         JOIN libroautor la ON la.idlibro = l.idlibro
         JOIN autor a ON a.idautor = la.idautor
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/202
SELECT l.titulo
from libro l
         JOIN prestamo p ON p.idLibro = l.idLibro
WHERE date(fechadevolucion) = '2021-07-16'