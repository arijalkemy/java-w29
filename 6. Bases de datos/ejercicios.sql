DROP DATABASE Biblioteca;
CREATE DATABASE IF NOT EXISTS Biblioteca;

USE Biblioteca;

CREATE TABLE IF NOT EXISTS Autor(
	idAutor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50),
    nacionalidad varchar(50)
);

CREATE TABLE IF NOT EXISTS Estudiante(
	idLector INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50),
    apellido varchar(50),
    direccion varchar(50),
    carrera varchar(50),
    edad int
);

CREATE TABLE IF NOT EXISTS Libro(
	idLibro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo varchar(255),
    editorial varchar(100),
    area varchar(100)
);

CREATE TABLE IF NOT EXISTS LibroAutor (
	idAutor int NOT NULL,
    idLibro int NOT NULL,
    FOREIGN KEY(idAutor) REFERENCES Autor(idAutor),
    FOREIGN KEY(idLibro) REFERENCES Libro(idLibro),
    PRIMARY KEY(idAutor, idLibro)
);

CREATE TABLE IF NOT EXISTS Prestamo(
	idLector int NOT NULL,
    idLibro int NOT NULL,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOL,
    FOREIGN KEY(idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY(idLibro) REFERENCES Libro(idLibro),
    PRIMARY KEY(idLector, idLibro)
);

-- Insertar datos en la tabla Autor
INSERT INTO Autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiano'),
('J.K. Rowling', 'Británica'),
('George Orwell', 'Británica'),
('Mario Vargas Llosa', 'Peruano'),
('Isaac Asimov', 'Ruso-estadounidense'),
('Pierre Dupont', 'Francés'),
('Luca Bianchi', 'Italiano'),
('Sophie Martin', 'Francesa');

-- Insertar datos en la tabla Estudiante
INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería de Sistemas', 22),
('Ana', 'González', 'Av. Siempre Viva 456', 'Derecho', 21),
('Carlos', 'Martínez', 'Calle de la Paz 789', 'Medicina', 23),
('Laura', 'López', 'Av. Libertador 101', 'Arquitectura', 24),
('Pedro', 'Ramírez', 'Calle 7 No. 34', 'Literatura', 25),
('Filippo', 'Galli', 'Via Roma 50', 'Informática', 28),
('Sophie', 'Martin', 'Calle de la Paz 32', 'Informática', 21),
('Luigi', 'Verdi', 'Via Milano 21', 'Informática', 22),
('Clara', 'González', 'Calle Nueva 101', 'Informática', 20);

-- Insertar datos en la tabla Libro
INSERT INTO Libro (titulo, editorial, area) VALUES
('Cien Años de Soledad', 'Editorial Sudamericana', 'Literatura Latinoamericana'),
('Harry Potter y la Piedra Filosofal', 'Bloomsbury', 'Fantasía'),
('1984', 'Secker & Warburg', 'Distopía'),
('La Fiesta del Chivo', 'Alfaguara', 'Política'),
('Fundación', 'Doubleday', 'Ciencia ficción'),
('El Universo: Guía de viaje', 'Salamandra', 'Astronomía'),
('La Magia de los Libros', 'Salamandra', 'Literatura Infantil'),
('Base de Datos: Fundamentos', 'McGraw-Hill', 'Internet'),
('Redes de Computadoras', 'Prentice Hall', 'Informática');

-- Insertar relaciones entre Autor y Libro
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez y Cien Años de Soledad
(2, 2),  -- J.K. Rowling y Harry Potter y la Piedra Filosofal
(3, 3),  -- George Orwell y 1984
(4, 4),  -- Mario Vargas Llosa y La Fiesta del Chivo
(5, 5),  -- Isaac Asimov y Fundación
(6, 6),
(7, 6),  -- Pierre Dupont y El Universo: Guía de viaje
(7, 7),  -- Luca Bianchi y La Magia de los Libros
(5, 8),  -- Isaac Asimov y Base de Datos: Fundamentos
(2, 9);  -- J.K. Rowling y Redes de Computadoras

-- Insertar datos en la tabla Prestamo
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2025-02-01', '2025-02-15', TRUE),
(2, 2, '2025-02-05', '2025-02-19', FALSE),
(3, 3, '2025-02-07', '2025-02-21', TRUE),
(4, 4, '2025-02-10', '2025-02-24', FALSE),
(5, 5, '2025-02-11', '2025-02-25', TRUE),
(6, 6, '2025-02-01', '2025-02-15', TRUE),
(7, 7, '2025-02-05', '2025-02-19', TRUE),
(8, 8, '2025-02-08', '2025-02-22', FALSE),
(1, 8, '2025-02-08', '2021-07-16', TRUE),
(1, 5, '2025-02-08', '2021-07-16', TRUE);


# Listar los datos de los autores.
SELECT * FROM autor;
# Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;
# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';
# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad LIKE 'Franc%' OR nacionalidad LIKE 'Itali%';
# ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area <> 'Internet';
# Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';
# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);
# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiante WHERE apellido LIKE 'G%';
# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre FROM (Autor NATURAL JOIN LibroAutor) NATURAL JOIN Libro  WHERE Libro.titulo = 'El Universo: Guía de viaje';
# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT titulo FROM (Libro NATURAL JOIN Prestamo) NATURAL JOIN Estudiante WHERE nombre = 'Filippo' AND apellido = 'Galli';
# Listar el nombre del estudiante de menor edad.
SELECT nombre FROM Estudiante ORDER BY edad ASC LIMIT 1;
# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre FROM Estudiante WHERE idLector IN (SELECT idLector FROM Prestamo);
# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT titulo FROM (Autor NATURAL JOIN LibroAutor) NATURAL JOIN Libro  WHERE Autor.nombre = 'J.K. Rowling';
# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo FROM (Libro NATURAL JOIN Prestamo) WHERE FechaDevolucion = '2021-07-16';