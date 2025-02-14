DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;

USE biblioteca;


CREATE TABLE AUTOR (
    idAutor INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(50),
    PRIMARY KEY (idAutor)
);


CREATE TABLE LIBRO (
    idLibro INT NOT NULL AUTO_INCREMENT,
    Titulo VARCHAR(255) NOT NULL,
    Editorial VARCHAR(100),
    Area VARCHAR(100),
    PRIMARY KEY (idLibro)
);


CREATE TABLE LIBROAUTOR (
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);


CREATE TABLE ESTUDIANTE (
    idLector INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Dirección VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT,
    PRIMARY KEY (idLector)
);


CREATE TABLE PRESTAMO (
    idLector INT NOT NULL,
    idLibro INT NOT NULL,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    Devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);


INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiano'),
('Jane Austen', 'frances'),
('William Shakespeare', 'italiano'),
('J.K. Rowling', 'inglesa');


INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Novela'),
('Orgullo y Prejuicio', 'T. Egerton', 'Internet'),
('El Universo: Guía de viaje', 'N/A', 'Foro'),
('Hamlet', 'Salamandra', 'Tragedia');


INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4);


INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Ana', 'Pérez', 'Calle Falsa 123', 'Literatura', 21),
('Luis', 'Gómez', 'Avenida Siempre Viva 742', 'Historia', 23),
('María', 'Rodríguez', 'Calle Luna 456', 'Filosofía', 22),
('Filippo', 'Galli', 'Calle 456', 'Industrial', 20),
('Juan', 'Alvarez', 'Calle Falsa 21', 'Informatica', 17);


INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-09-01', '2023-09-15', TRUE),
(2, 2, '2023-09-05', NULL, FALSE),
(3, 3, '2021-07-03', '2021-07-16', TRUE),
(4, 4, '2023-06-16', NULL, FALSE);


-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Apellido FROM ESTUDIANTE AS e
WHERE e.Carrera LIKE "%informatica%";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre FROM AUTOR AS a
WHERE a.Nacionalidad LIKE "%frances%" OR a.Nacionalidad LIKE "%italiano%";

-- ¿Qué libros no son del área de internet?
SELECT Titulo FROM LIBRO AS l
WHERE l.Area NOT LIKE "%internet%";

-- Listar los libros de la editorial Salamandra.
SELECT Titulo FROM LIBRO AS l
WHERE l.Editorial LIKE "%salamandra%";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.*, promedio.promedio_edades
FROM ESTUDIANTE AS e,
    (SELECT AVG(Edad) AS promedio_edades FROM ESTUDIANTE) AS promedio
WHERE e.Edad > promedio.promedio_edades;

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE
WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT A.Nombre FROM AUTOR A
JOIN LIBROAUTOR LA ON LA.idAutor = A.idAutor
JOIN LIBRO L ON L.idLibro = LA.idLibro
WHERE L.Titulo = 'Hamlet';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT L.* FROM LIBRO L
JOIN PRESTAMO P ON P.idLibro = L.idLibro
JOIN ESTUDIANTE E ON E.idLector = P.idLector
WHERE E.Nombre LIKE '%Filippo%' AND E.Apellido LIKE '%Galli%';

-- Listar el nombre del estudiante de menor edad.
SELECT Nombre From ESTUDIANTE
WHERE Edad < 18;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT E.Nombre FROM LIBRO L
JOIN PRESTAMO P ON P.idLibro = L.idLibro
JOIN ESTUDIANTE E ON E.idLector = P.idLector;


-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT L.* FROM AUTOR A
JOIN LIBROAUTOR LA ON LA.idAutor = A.idAutor
JOIN LIBRO L ON L.idLibro = LA.idLibro
WHERE A.Nombre = 'J.K. Rowling';


-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT L.Titulo FROM LIBRO L
JOIN PRESTAMO P ON P.idLibro = L.idLibro
WHERE P.FechaDevolucion = '2021-07-16';


