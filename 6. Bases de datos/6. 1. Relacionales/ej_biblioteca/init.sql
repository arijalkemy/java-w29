-- Crear base de datos y tablas
DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

DROP TABLE IF EXISTS `autores`;
CREATE TABLE autores (
    id_autor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `nacionalidades`;
CREATE TABLE nacionalidades (
    id_nacionalidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `libros`;
CREATE TABLE libros (
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    editorial VARCHAR(50) NOT NULL,
    area VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE estudiantes (
    id_lector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    carrera VARCHAR(50) NOT NULL,
    edad INT NOT NULL
);

DROP TABLE IF EXISTS `autor_libro`;
CREATE TABLE autor_libro (
    id_autor INT,
    id_libro INT,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES autores(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro)
);

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE prestamos (
    id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
    id_libro INT,
    id_lector INT,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE NOT NULL,
    devuelto BOOLEAN NOT NULL,
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro),
    FOREIGN KEY (id_lector) REFERENCES estudiantes(id_lector)
);

-- insertar 5 registros en la tabla nacionalidades
INSERT INTO nacionalidades (nombre) VALUES
    ('Colombiana'),
    ('Británica'),
    ('Peruana'),
    ('Mexicana'),
    ('Chilena'),
    ('Francesa'),
    ('Estadounidense');

-- insertar 5 registros en la tabla autor
INSERT INTO autores (nombre, nacionalidad) VALUES
    ('Gabriel García Márquez', 1),
    ('J.K. Rowling', 2),
    ('Mario Vargas Llosa', 3),
    ('Carlos Fuentes', 4),
    ('Isabel Allende', 5),
    ('Victor Hugo', 6),
    ('John Boswell', 7),
    ('Jean-Pierre Luminet', 6);

-- insertar 5 registros en la tabla libro
INSERT INTO libros (titulo, editorial, area) VALUES
    ('Cien años de soledad', 'Editorial Sudamericana', 'Ficción'),
    ('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
    ('La ciudad y los perros', 'Editorial Seix Barral', 'Literatura Latinoamericana'),
    ('Terra Nostra', 'Editorial Seix Barral', 'Ficción Histórica'),
    ('La casa de los espíritus', 'Editorial Plaza & Janés', 'Realismo Mágico'),
    ('El arte de la informática', 'Editorial T3ch', 'Internet'),
    ('Redes sociales y su impacto', 'Editorial Digital', 'Internet'),
    ('Transformación digital para empresas', 'Editorial Innovatec', 'Internet'),
    ('El Universo: Guía de viaje', 'Editorial Planeta', 'Astronomía'),
    ('Fundamentos de Bases de Datos', 'Pearson', 'Base de Datos');

-- insertar 5 registros en la tabla estudiantes
INSERT INTO estudiantes (nombre, apellido, direccion, carrera, edad) VALUES
    ('Filippo', 'Galli', 'Av. Libertador 123', 'Informática', 22),
    ('Ana', 'Gómez', 'Calle Falsa 456', 'Derecho', 20),
    ('Carlos', 'López', 'Calle Principal 789', 'Informática', 24),
    ('Lucía', 'Martínez', 'Calle San Martín 101', 'Arquitectura', 23),
    ('Marta', 'Rodríguez', 'Calle Real 202', 'Biología', 21);

-- insertar 5 registros en la tabla autor_libro
INSERT INTO autor_libro (id_autor, id_libro) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (7, 9),
    (8, 9);

-- insertar 5 registros en la tabla prestamos
INSERT INTO prestamos (id_libro, id_lector, fecha_prestamo, fecha_devolucion, devuelto) VALUES
    (1, 1, '2025-01-01', '2025-02-01', TRUE),
    (2, 2, '2021-07-10', '2021-07-16', FALSE),
    (3, 3, '2021-06-29', '2021-07-16', TRUE),
    (4, 4, '2025-01-20', '2025-02-20', FALSE),
    (5, 5, '2025-01-25', '2025-02-25', TRUE),
    (10, 1, '2025-01-01', '2025-02-01', TRUE);
