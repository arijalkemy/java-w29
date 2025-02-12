-- Tabla AUTOR
CREATE TABLE biblioteca_db.autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

-- Tabla LIBRO
CREATE TABLE biblioteca_db.libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(50) NOT NULL
);

-- Tabla LIBROAUTOR (Relación N:M entre LIBRO y AUTOR)
CREATE TABLE biblioteca_db.libroautor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro) ON DELETE CASCADE
);

-- Tabla ESTUDIANTE
CREATE TABLE biblioteca_db.estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

-- Tabla PRESTAMO
CREATE TABLE biblioteca_db.prestamo (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro) ON DELETE CASCADE
);

/*************** Query de insert en las tablas **************/
-- Insertar autores
INSERT INTO biblioteca_db.autor (nombre, nacionalidad) VALUES 
('Gabriel García Márquez', 'Colombiano'),
('Julio Verne', 'Francés'),
('J.K. Rowling', 'Británica'),
('Miguel de Cervantes', 'Español'),
('Jane Austen', 'Británica'),
('Mark Twain', 'Estadounidense'),
('Ernest Hemingway', 'Estadounidense'),
('Isabel Allende', 'Chilena'),
('Franz Kafka', 'Alemán'),
('George Orwell', 'Británico');

-- Insertar libros
INSERT INTO biblioteca_db.libro (titulo, editorial, area) VALUES 
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('Veinte mil leguas de viaje submarino', 'Hetzel', 'Ciencia Ficción'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('Don Quijote de la Mancha', 'Francisco de Robles', 'Literatura Clásica'),
('Orgullo y prejuicio', 'T. Egerton', 'Romance'),
('Las aventuras de Tom Sawyer', 'American Publishing Company', 'Aventura'),
('El viejo y el mar', 'Charles Scribner’s Sons', 'Drama'),
('La casa de los espíritus', 'Plaza & Janés', 'Realismo Mágico'),
('La metamorfosis', 'Kurt Wolff Verlag', 'Filosofía'),
('1984', 'Salamandra', 'Distopía');

-- Insertar relación LIBROAUTOR
INSERT INTO biblioteca_db.libroautor (idAutor, idLibro) VALUES 
(1, 1),  -- Gabriel García Márquez - Cien años de soledad
(2, 2),  -- Julio Verne - 20,000 leguas
(3, 3),  -- J.K. Rowling - Harry Potter
(4, 4),  -- Miguel de Cervantes - Don Quijote
(5, 5),  -- Jane Austen - Orgullo y Prejuicio
(6, 6),  -- Mark Twain - Tom Sawyer
(7, 7),  -- Ernest Hemingway - El viejo y el mar
(8, 8),  -- Isabel Allende - La casa de los espíritus
(9, 9),  -- Franz Kafka - La metamorfosis
(10, 10); -- George Orwell - 1984

-- Insertar estudiantes
INSERT INTO biblioteca_db.estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
('Carlos', 'Pérez', 'Calle 123', 'Ingeniería', 22),
('María', 'Gómez', 'Av. Central', 'Medicina', 20),
('Juan', 'Rodríguez', 'Calle 45', 'Derecho', 23),
('Ana', 'López', 'Carrera 7', 'Arquitectura', 21),
('Pedro', 'Martínez', 'Calle 10', 'Administración', 24),
('Laura', 'Fernández', 'Av. Sur', 'Psicología', 22),
('Diego', 'Hernández', 'Calle 89', 'Economía', 23),
('Elena', 'Torres', 'Pasaje 3', 'Contaduría', 25),
('Fernando', 'Díaz', 'Calle 5', 'Informática', 21),
('Isabel', 'Ramírez', 'Avenida Norte', 'Diseño Gráfico', 22);

-- Insertar préstamos
INSERT INTO biblioteca_db.prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES 
(1, 1, '2024-02-01', '2024-02-10', TRUE),
(2, 2, '2024-02-02', '2024-02-11', FALSE),
(3, 3, '2024-02-03', '2024-02-12', TRUE),
(4, 4, '2024-02-04', '2024-02-13', FALSE),
(5, 5, '2024-02-05', '2024-02-14', TRUE),
(6, 6, '2024-02-06', '2024-02-15', FALSE),
(7, 7, '2024-02-07', '2024-02-16', TRUE),
(8, 8, '2024-02-08', '2024-02-17', FALSE),
(9, 9, '2024-02-09', '2024-02-18', TRUE),
(10, 10, '2024-02-10', '2024-02-19', FALSE);

/******Querys *****/
/*listar la lista de los autores */
SELECT * FROM autor;

/*Listar nombre y edad de los estudiantes*/
SELECT nombre, edad FROM estudiante;

/*¿Qué estudiantes pertenecen a la carrera informática?*/
SELECT * FROM estudiante WHERE carrera='Informática';

/*¿Qué autores son de nacionalidad francesa o italiana?*/
SELECT * FROM autor WHERE nacionalidad='Francés' OR 'Italiano';

/*¿Qué libros no son del área de internet?*/
SELECT * FROM libro WHERE area!='Internet';

/*Listar los libros de la editorial Salamandra.*/
SELECT * FROM libro WHERE editorial='Salamandra';

/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
SELECT * 
FROM estudiante 
WHERE edad > (SELECT AVG(edad) FROM estudiante);

/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)*/
SELECT nombre FROM autor as au
INNER JOIN libroautor as la
ON au.idAutor = la.idAutor;

/*¿Qué libros se prestaron al lector “Filippo Galli”?*/
SELECT lb.titulo 
FROM libro AS lb
INNER JOIN prestamo AS pr ON lb.idLibro = pr.idLibro
INNER JOIN estudiante AS est ON pr.idLector = est.idLector
WHERE est.nombre = 'Fernando' AND est.apellido = 'Díaz';

/*Listar el nombre del estudiante de menor edad.*/
SELECT * FROM estudiante
ORDER BY edad LIMIT 1;

/*Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
SELECT nombre FROM estudiante as es
INNER JOIN prestamo AS pres ON es.idLector = pres.idLector
INNER JOIN libro AS lb ON pres.idLibro = lb.idLibro
WHERE lb.titulo = 'La metamorfosis';

/*Listar los libros que pertenecen a la autora J.K. Rowling.*/
SELECT * FROM libro AS lb
INNER JOIN autor AS aut
INNER JOIN libroautor as lbAu ON lbAu.idAutor= aut.idAutor AND lbAu.idLibro= lb.idLibro
WHERE aut.nombre='J.K. Rowling';

/*Listar títulos de los libros que debían devolverse el 16/07/2021.*/
SELECT lb.titulo 
FROM libro AS lb
INNER JOIN prestamo AS pres ON lb.idLibro = pres.idLibro
WHERE pres.fechaDevolucion = '2024-02-11';

