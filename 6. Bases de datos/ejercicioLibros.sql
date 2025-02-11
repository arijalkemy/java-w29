DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(255) NOT NULL,
    Editorial VARCHAR(100),
    Area VARCHAR(100)
);

-- Tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(100)
);

-- Tabla LIBROAUTOR (relación muchos a muchos entre LIBRO y AUTOR)
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

-- Tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT CHECK (Edad >= 0)
);

-- Tabla PRESTAMO (relación entre LIBRO y ESTUDIANTE)
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    Devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);



-- Agregar más registros para que tengan sentido las consultas
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'J.K. Rowling', 'Británica'),
(2, 'Gabriel García Márquez', 'Colombiana'),
(3, 'Umberto Eco', 'Italiana'),
(4, 'Victor Hugo', 'Francesa');

SELECT* FROM AUTOR;


INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Filippo', 'Galli', 'Calle A, 123', 'Informática', 21),
(2, 'Carlos', 'Perez', 'Calle B, 456', 'Matemáticas', 22),
(3, 'Ana', 'Gonzalez', 'Calle C, 789', 'Informática', 20),
(4, 'Lucia', 'Gimenez', 'Calle D, 321', 'Física', 23);

SELECT* FROM LIBRO;

INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'El Universo: Guía de viaje', 'Salamandra', 'Astronomía'),
(2, 'Cien Años de Soledad', 'Norma', 'Literatura'),
(3, 'El Nombre de la Rosa', 'Planeta', 'Historia'),
(4, 'Los Miserables', 'Salamandra', 'Literatura');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2021-07-01', '2021-07-16', 0),
(2, 2, '2021-06-10', '2021-06-30', 1),
(3, 3, '2021-08-15', '2021-08-30', 0),
(4, 4, '2021-05-10', '2021-05-25', 1);

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