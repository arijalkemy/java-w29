CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE AUTOR
(
    idAutor      INT PRIMARY KEY AUTO_INCREMENT,
    nombre       VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50)
);

CREATE TABLE LIBRO
(
    idLibro   INT PRIMARY KEY AUTO_INCREMENT,
    título    VARCHAR(200) NOT NULL,
    editorial VARCHAR(100),
    area      VARCHAR(100)
);

CREATE TABLE LIBROAUTOR
(
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR (idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO (idLibro) ON DELETE CASCADE
);

CREATE TABLE ESTUDIANTE
(
    idLector  INT PRIMARY KEY AUTO_INCREMENT,
    nombre    VARCHAR(100) NOT NULL,
    apellido  VARCHAR(100) NOT NULL,
    dirección VARCHAR(200),
    carrera   VARCHAR(100),
    edad      INT
);

CREATE TABLE PRESTAMO
(
    idLector        INT,
    idLibro         INT,
    fechaPrestamo   DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto        BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, fechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE (idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO (idLibro) ON DELETE CASCADE
);


INSERT INTO AUTOR (nombre, nacionalidad)
VALUES ('Gabriel García Márquez', 'Colombiano'),
       ('Julio Verne', 'Francés'),
       ('J.K. Rowling', 'Británica'),
       ('Miguel de Cervantes', 'Español'),
       ('George Orwell', 'Británico');


INSERT INTO LIBRO (título, editorial, area)
VALUES ('Cien años de soledad', 'Sudamericana', 'Literatura'),
       ('1984', 'Secker & Warburg', 'Ficción'),
       ('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
       ('Don Quijote de la Mancha', 'Francisco de Robles', 'Clásicos'),
       ('Viaje al centro de la Tierra', 'Pierre-Jules Hetzel', 'Ciencia ficción');


INSERT INTO LIBROAUTOR (idAutor, idLibro)
VALUES (1, 1),
       (2, 5),
       (3, 3),
       (4, 4),
       (5, 2);


INSERT INTO ESTUDIANTE (nombre, apellido, dirección, carrera, edad)
VALUES ('Juan', 'Pérez', 'Calle 123', 'Ingeniería', 21),
       ('María', 'Gómez', 'Avenida 45', 'Literatura', 23),
       ('Carlos', 'López', 'Carrera 12', 'Historia', 22),
       ('Ana', 'Martínez', 'Calle 78', 'Filosofía', 24),
       ('Pedro', 'Ramírez', 'Diagonal 90', 'Computación', 20);


INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (1, 1, '2025-01-10', '2025-01-20', TRUE),
       (2, 2, '2025-01-15', '2025-01-25', FALSE),
       (3, 3, '2025-01-18', '2025-01-28', TRUE),
       (4, 4, '2025-01-22', '2025-02-01', FALSE),
       (5, 5, '2025-01-25', '2025-02-05', TRUE);


-- Consultas
-- 1. Listar los datos de los autores.
SELECT *
FROM AUTOR;
-- 2.Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM ESTUDIANTE;
-- 3.¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM ESTUDIANTE
WHERE carrera = 'Computación';
-- 4.¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM AUTOR
WHERE nacionalidad in ('Francés', 'Colombiano');
# ¿Qué libros no son del área de internet?
SELECT *
FROM LIBRO
WHERE area = 'Fantasía';
# Listar los libros de la editorial Salamandra.

SELECT *
FROM LIBRO
WHERE editorial = 'Sudamericana';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM ESTUDIANTE
WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);
# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT *
FROM ESTUDIANTE
WHERE apellido LIKE 'M%';
# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM AUTOR a
         JOIN LIBROAUTOR la ON a.idAutor = la.idAutor
         JOIN LIBRO l ON l.idLibro = la.idLibro
WHERE l.título = 'Cien años de soledad';
# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.título
FROM LIBRO l
         JOIN PRESTAMO p on l.idLibro = p.idLibro
         JOIN ESTUDIANTE e on p.idLector = e.idLector
WHERE e.nombre = 'María'
  AND e.apellido = 'Gómez';
# Listar el nombre del estudiante de menor edad.
SELECT nombre, edad
FROM ESTUDIANTE
ORDER BY edad
limit 1;
# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM ESTUDIANTE e
         JOIN PRESTAMO p on p.idLector = e.idLector
         JOIN LIBRO l on p.idLibro = l.idLibro
WHERE l.area = 'Literatura';
# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.título
FROM LIBRO l
         JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
         JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE a.nombre = 'Gabriel García Márquez';
# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.título, p.fechaDevolucion
FROM LIBRO l
         JOIN PRESTAMO p on l.idLibro = p.idLibro
WHERE p.fechaDevolucion > '2021-07-16'
  AND p.devuelto = false;

