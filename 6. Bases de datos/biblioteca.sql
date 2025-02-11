DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE autor (
                       id_autor INT PRIMARY KEY AUTO_INCREMENT,
                       nombre VARCHAR(100),
                       nacionalidad VARCHAR(50)
);

CREATE TABLE libro (
                       id_libro INT PRIMARY KEY AUTO_INCREMENT,
                       titulo VARCHAR(200),
                       editorial VARCHAR(100),
                       area VARCHAR(100)
);

CREATE TABLE libro_autor (
                             id_autor INT,
                             id_libro INT,
                             PRIMARY KEY (id_autor, id_libro),
                             FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
                             FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

CREATE TABLE estudiante (
                            id_lector INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(100),
                            apellido VARCHAR(100),
                            direccion VARCHAR(200),
                            carrera VARCHAR(100),
                            edad INT
);

CREATE TABLE prestamo (
                          id_lector INT,
                          id_libro INT,
                          fecha_prestamo DATE,
                          fecha_devolucion DATE,
                          devuelto BOOLEAN,
                          PRIMARY KEY (id_lector, id_libro),
                          FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
                          FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

INSERT INTO autor (nombre, nacionalidad) VALUES
                                             ('Gabriel García Márquez', 'Colombiano'),
                                             ('J.K. Rowling', 'Británica'),
                                             ('Haruki Murakami', 'Japonés'),
                                             ('Jane Austen', 'Británica'),
                                             ('Mark Twain', 'Americano'),
                                             ('Isabel Allende', 'Chilena'),
                                             ('George Orwell', 'Británico'),
                                             ('Mario Vargas Llosa', 'Peruano'),
                                             ('Marc Levy', 'Francés'),
                                             ('Italo Calvino', 'Italiano'),
                                             ('Gabrielle Zevin', 'Americana');



INSERT INTO libro (titulo, editorial, area) VALUES
                                                ('Cien años de soledad', 'Editorial Oveja Negra', 'Literatura'),
                                                ('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
                                                ('1Q84', 'Shinchosha', 'Ficción'),
                                                ('Orgullo y prejuicio', 'T. Egerton', 'Literatura'),
                                                ('Las aventuras de Tom Sawyer', 'Chatto & Windus', 'Aventura'),
                                                ('La casa de los espíritus', 'Sudamericana', 'Ficción'),
                                                ('1984', 'Penguin Classics', 'Distopía'),
                                                ('La ciudad y los perros', 'Editorial Seix Barral', 'Literatura'),
                                                ('El Universo: Guía de viaje', 'Guía Universal', 'Ciencia'),
                                                ('Inteligencia Artificial', 'Salamandra', 'Internet'),
                                                ('El misterioso viaje de İkigai', 'Salamandra', 'Ficción'),
                                                ('La trama de la vida', 'Editorial Universitaria', 'Internet');


INSERT INTO libro_autor (id_autor, id_libro) VALUES
                                                 (1, 1),  -- Gabriel García Márquez - Cien años de soledad
                                                 (2, 2),  -- J.K. Rowling - Harry Potter y la piedra filosofal
                                                 (3, 3),  -- Haruki Murakami - 1Q84
                                                 (4, 4),  -- Jane Austen - Orgullo y prejuicio
                                                 (5, 5),  -- Mark Twain - Las aventuras de Tom Sawyer
                                                 (1, 2),  -- Gabriel García Márquez - Harry Potter y la piedra filosofal (ejemplo ficticio)
                                                 (2, 3),
                                                 (3, 7),
                                                 (6, 6),
                                                 (7, 1),
                                                 (8, 8);


INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
                                                                        ('Juan', 'Pérez', 'Calle Falsa 123', 'Literatura', 20),
                                                                        ('Ana', 'Gómez', 'Calle Verdadera 456', 'Ingeniería', 22),
                                                                        ('Luis', 'Martínez', 'Avenida Siempre Viva 789', 'Historia', 21),
                                                                        ('María', 'Lopez', 'Boulevard de la Calle 10', 'Biología', 19),
                                                                        ('Pedro', 'Sánchez', 'Plaza Mayor 16', 'Matemáticas', 23),
                                                                        ('Ana', 'Pérez', 'Calle 123, Ciudad', 'Literatura', 22),
                                                                        ('Luis', 'González', 'Calle 456, Ciudad', 'Ingeniería Informática', 21),
                                                                        ('Sofía', 'Martínez', 'Calle 789, Ciudad', 'Derecho', 23),
                                                                        ('David', 'López', 'Calle 321, Ciudad', 'Historia', 24),
                                                                        ('Emma', 'Rodríguez', 'Calle 654, Ciudad', 'Biología', 20),
                                                                        ('Filippo', 'Galli', 'Calle 999, Ciudad', 'Ingeniería Informática', 19),
                                                                        ('Miguel', 'Suárez', 'Calle 000, Ciudad', 'Literatura', 26),
                                                                        ('Sandra', 'Fernández', 'Calle 888, Ciudad', 'Ingeniería Informática', 22);


INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
                                                                                           (1, 1, '2023-01-15', '2023-01-30', TRUE),
                                                                                           (2, 2, '2023-02-01', '2023-02-15', TRUE),
                                                                                           (3, 3, '2023-02-05', NULL, FALSE),
                                                                                           (4, 4, '2023-02-20', '2023-03-05', TRUE),
                                                                                           (5, 5, '2023-03-01', NULL, FALSE),
                                                                                           (1, 2, '2023-03-10', '2023-03-25', TRUE),
                                                                                           (1, 4, '2023-02-05', '2023-02-15', 1),
                                                                                           (4, 5, '2023-02-10', NULL, 0),
                                                                                           (5, 6, '2023-03-01', NULL, 0),
                                                                                           (6, 3, '2023-03-02', NULL, 0),
                                                                                           (2, 7, '2023-04-01', NULL, 0),
                                                                                           (7, 1, '2023-05-05', NULL, 0),
                                                                                           (1, 8, '2023-06-01', '2023-06-10', 1);

-- 1. Listar los datos de los autores.

select * from autor;

-- 2 Listar nombre y edad de los estudiantes

select nombre, edad from estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?

select nombre, edad from estudiante where carrera like '%Informática%';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?

select nombre from autor a where a.nacionalidad in ("Italiano", "Francés");

-- 5. ¿Qué libros no son del área de internet?

select titulo from libro where area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.

select * from libro l where l.editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

select
    *
from estudiante e
where e.edad >= (select avg(e2.edad) from estudiante e2)

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

select
    nombre, apellido
from estudiante e
where e.apellido like 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

select a.nombre
from autor a
         join libro_autor la on la.id_autor = a.id_autor
         join libro l on l.id_libro = la.id_libro
where l.titulo = 'El Universo: Guía de viaje'

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?

select * from libro l
                  join prestamo p on p.id_libro = l.id_libro
                  join estudiante e on e.id_lector = p.id_lector
where e.id_lector = 11; -- id 11 asignado a “Filippo Galli”

-- 11. Listar el nombre del estudiante de menor edad.

select nombre from estudiante order by edad limit 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

select e.nombre from libro l
                         join prestamo p on p.id_libro = l.id_libro
                         join estudiante e on e.id_lector = p.id_lector
where l.titulo = 'Bases de datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.

select l.titulo
from autor a
         join libro_autor la on la.id_autor = a.id_autor
         join libro l on l.id_libro = la.id_libro
where a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

select l.titulo  from prestamo p
                          join libro l on p.id_libro = l.id_libro
where p.fecha_devolucion = '2021-07-16'












