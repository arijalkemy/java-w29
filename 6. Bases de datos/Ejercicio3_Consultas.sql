#Listar los datos de los autores.
SELECT nombre FROM autor;
#Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Literatura';
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';
#¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE Area NOT LIKE 'Internet';
#Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante 
WHERE edad >(SELECT AVG(edad) FROM estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'g%';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a
JOIN libroautor la ON a.idautor = la.idautor
JOIN libro l ON l.idlibro = la.idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';
#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* 
FROM libro l 
JOIN prestamo p ON l.idlibro = p.idLibro
JOIN estudiante e ON e.idLector = p.idlector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';
#Listar el nombre del estudiante de menor edad.
SELECT e.nombre FROM estudiante e WHERE e.edad < 18;
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.* 
FROM estudiante e
JOIN prestamo p ON p.idlector = e.idlector
JOIN libro l ON l.idlibro = p.idlibro
WHERE l.titulo = 'Base de Datos';
#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM libro l 
JOIN libroautor la ON la.idlibro = l.idlibro
JOIN autor a ON a.idautor = la.idautor
WHERE a.nombre = 'J.K. Rowling';
#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo from libro l 
JOIN prestamo p ON p.idLibro = l.idLibro
WHERE date(fechadevolucion) = '2021-07-16'
