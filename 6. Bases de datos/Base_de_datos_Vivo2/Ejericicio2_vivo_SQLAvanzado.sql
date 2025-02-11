-- Crear la base de datos (opcional)
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

-- Crear la tabla AUTOR
CREATE TABLE Autor (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(50) NOT NULL
);

-- Crear la tabla LIBRO
CREATE TABLE Libro (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(200) NOT NULL,
    Editorial VARCHAR(100),
    Area VARCHAR(100)
);

-- Crear la tabla LIBROAUTOR (tabla intermedia)
CREATE TABLE LibroAutor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

-- Crear la tabla ESTUDIANTE
CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Direccion VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);

-- Crear la tabla PRESTAMO
CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    Devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

-- Insertar registros en la tabla AUTOR
INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiano'),
('J.K. Rowling', 'Británica'),
('George Orwell', 'Británico'),
('Mario Vargas Llosa', 'Peruano'),
('Margaret Atwood', 'Canadiense'),
('Franz Kafka', 'Checo'),
('Víctor Hugo', 'Francés'),
('Italo Calvino', 'Italiano');

-- Insertar registros en la tabla LIBRO
INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Ficción'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('1984', 'Random House', 'Distopía'),
('La casa verde', 'Tusquets', 'Ficción'),
('El cuento de la criada', 'Salamandra', 'Ficción'),
('La metamorfosis', 'Losada', 'Ficción'),
('Los miserables', 'Pantalón', 'Ficción'),
('El universo: Guía de viaje', 'Ediciones SM', 'Guía');

-- Insertar registros en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Filippo', 'Galli', 'Via Roma 123', 'Informática', 22),
('Laura', 'González', 'Calle Mayor 456', 'Informática', 23),
('David', 'Martínez', 'Avenida del Sol 789', 'Historia', 21),
('Sofía', 'Hernández', 'Plaza Central 321', 'Literatura', 25),
('María', 'Gómez', 'Calle de los Abetos 654', 'Informática', 24),
('Carlos', 'Lopez', 'Calle del Río 159', 'Ciencias', 20),
('Julia', 'Garcia', 'Boulevard de los Sueños 112', 'Informática', 22),
('Luis', 'Fernández', 'Calle Verde 888', 'Matemáticas', 27);

-- Insertar registros en la tabla PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 2, '2022-07-01', '2022-07-15', TRUE),
(1, 1, '2021-05-01', '2021-05-15', TRUE),
(2, 3, '2022-08-01', NULL, FALSE),
(3, 5, '2022-07-20', '2022-08-01', TRUE),
(4, 4, '2022-06-01', NULL, FALSE),
(5, 7, '2022-05-15', '2022-06-01', TRUE),
(6, 8, '2021-06-05', '2021-06-15', TRUE),
(7, 6, '2021-07-10', NULL, FALSE);

-- Insertar registros en la tabla LIBROAUTOR
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1), -- Gabriel García Márquez - Cien años de soledad
(2, 2), -- J.K. Rowling - Harry Potter y la piedra filosofal
(3, 3), -- George Orwell - 1984
(4, 4), -- Mario Vargas Llosa - La casa verde
(4, 5), -- Mario Vargas Llosa - El cuento de la criada
(5, 6), -- Margaret Atwood - La metamorfosis
(6, 7), -- Víctor Hugo - Los miserables
(7, 8); -- Italo Calvino - El universo: Guía de viaje


use biblioteca;

-- listar los datos de los autores
SELECT * from Autor;

-- listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM Estudiante;

-- que estudiantes pertenecen a la carrera de informatica
SELECT * FROM Estudiante WHERE Carrera = 'Informática';

-- que autores son de nacionalidad francesa e italiana
SELECT * FROM Autor WHERE Nacionalidad IN ('Francés', 'Italiano');

-- que libros no son del area de internet
SELECT * FROM Libro WHERE Area != 'Internet';

-- listar los libros de la editorial salamandra
SELECT * FROM Libro WHERE Editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre FROM Estudiante WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”
SELECT a.Nombre, L.Titulo
FROM Autor a
JOIN LibroAutor la ON a.idAutor = la.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.Titulo = 'El universo: Guía de viaje';

SELECT * FROM LibroAutor;
SELECT * FROM Libro;

-- Qué libros se prestaron al lector “Filippo Galli”
SELECT l.Titulo 
FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
JOIN Estudiante e ON p.idLector = e.idLector
WHERE e.Nombre = 'Filippo' AND e.Apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad
SELECT Nombre, Edad FROM Estudiante ORDER BY Edad ASC LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT e.Nombre 
FROM Estudiante e
JOIN Prestamo p ON e.idLector = p.idLector
JOIN Libro l ON p.idLibro = l.idLibro
WHERE l.Titulo LIKE '%Base de Datos%';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo 
FROM Libro l
JOIN LibroAutor la ON l.idLibro = la.idLibro
JOIN Autor a ON la.idAutor = a.idAutor
WHERE a.Nombre = 'J.K. Rowling';

SELECT * FROM Autor;
SELECT * FROM Libro;

-- Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.Titulo, p.FechaDevolucion
FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
WHERE p.FechaDevolucion <= '2021-07-16';

SELECT * FROM Prestamo;



