CREATE DATABASE Biblioteca;
USE Biblioteca;
-- Tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(50)
);
-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Título VARCHAR(200) NOT NULL,
    Editorial VARCHAR(100),
    Area VARCHAR(100)
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
    Dirección VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);
-- Tabla PRESTAMO (relación muchos a muchos entre LIBRO y ESTUDIANTE)
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

-- Insercion de Datos

-- Tabla AUTOR
INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Julio Cortázar', 'Argentina'),
('Isabel Allende', 'Chilena'),
('Mario Vargas Llosa', 'Peruana'),
('J.K. Rowling', 'Británica'),
('George R.R. Martin', 'Estadounidense'),
('Haruki Murakami', 'Japonesa'),
('Stephen King', 'Estadounidense'),
('Jane Austen', 'Británica'),
('Miguel de Cervantes', 'Española'),
('Umberto Eco', 'Italiana'),
('Émile Zola', 'Francesa');

-- Tabla LIBRO
INSERT INTO LIBRO ( Título, Editorial, Area) VALUES
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('Rayuela', 'Random House', 'Literatura'),
('La casa de los espíritus', 'Plaza & Janés', 'Ficción'),
('La ciudad y los perros', 'Alfaguara', 'Ficción'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('Juego de tronos', 'Bantam', 'Fantasía'),
('Kafka en la orilla', 'Tusquets', 'Ficción'),
('El resplandor', 'Doubleday', 'Terror'),
('Orgullo y prejuicio', 'Penguin', 'Novela'),
('Don Quijote de la Mancha', 'Editorial RM', 'Clásico'),
('El nombre de la rosa', 'Bompiani', 'Misterio'),
('Germinal', 'Charpentier', 'Novela'),
('Germinal', 'Salamandra', 'Novela'),
('El Universo: Guía de viaje','Estrella','Fantasía');


-- Tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(1,49),
(3,49),
(5,49);

-- Tabla ESTUDIANTE
INSERT INTO ESTUDIANTE ( Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Ana', 'Pérez', 'Calle Falsa 123', 'Literatura', 22),
('Javier', 'López', 'Avenida Siempre Viva 456', 'Historia', 21),
('Luis', 'González', 'Calle 1', 'Ingeniería', 23),
('María', 'Rodríguez', 'Calle 2', 'Arquitectura', 24),
('Carlos', 'Martínez', 'Calle 3', 'Medicina', 21),
('Sofía', 'Hernández', 'Calle 4', 'Derecho', 22),
('José', 'Ramírez', 'Calle 5', 'Arte', 20),
('Elena', 'Fernández', 'Calle 6', 'Economía', 23),
('Fernando', 'García', 'Calle 7', 'Biología', 21),
('Laura', 'Pérez', 'Calle 8', 'Historia', 22),
('Marco', 'Rossi', 'Viale Roma 45', 'Informática', 25),
('Claudia', 'Dubois', 'Rue de Paris 12', 'Informática', 24);

-- Tabla PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-10-01', '2023-10-15', false),
(2, 2, '2023-10-05', '2023-10-19', true),
(3, 3, '2023-09-20', '2023-10-04', true),
(4, 4, '2023-09-22', '2023-10-06', false),
(5, 5, '2023-09-23', '2023-10-07', true),
(6, 6, '2023-09-25', '2023-10-09', false),
(7, 7, '2023-09-26', '2023-10-10', true),
(8, 8, '2023-09-27', '2023-10-11', false),
(9, 9, '2023-09-28', '2023-10-12', true),
(10, 10, '2023-09-29', '2023-10-13', false),
(11, 11, '2023-10-01', '2023-10-15', false),
(12, 12, '2023-10-03', '2023-10-17', true);


-- Consultas

-- 1. Listar los datos de los autores.
	SELECT * FROM autor;
    
-- 2.Listar nombre y edad de los estudiantes
	SELECT nombre,edad FROM estudiante;
    
-- 3.¿Qué estudiantes pertenecen a la carrera informática?
	SELECT *
    FROM estudiante 
    WHERE carrera = "Informatica";
    
-- 4.¿Qué autores son de nacionalidad francesa o italiana?
	SELECT *
    FROM autor
	WHERE nacionalidad IN ("Francesa","Italiana");
    
-- 5.¿Qué libros no son del área de internet?
	SELECT *
    FROM libro
	WHERE area != "internet";
    
-- 6.Listar los libros de la editorial Salamandra.
	SELECT *
    FROM libro
    WHERE editorial = "Salamandra";
    
-- 7.Listar los datos de los estudiantes cuya edad es mayor al promedio.
	SELECT *
    FROM estudiante
    WHERE EDAD > (SELECT AVG(edad) FROM estudiante);
    
-- 8.Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
	SELECT nombre
    FROM estudiante
    WHERE apellido like "G%";
    
-- 9.Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
	SELECT a.nombre
    FROM libroautor la
    JOIN libro l ON l.idlibro = la.idlibro
    JOIN autor a ON a.idautor = la.idautor
    WHERE l.título = "El Universo: Guía de viaje";
    
-- 10.¿Qué libros se prestaron al lector “Filippo Galli”?
	SELECT l.título
    FROM prestamo p
    JOIN estudiante e ON e.idlector = p.idlector
    JOIN libro l ON l.idlibro = p.idlibro
    WHERE e.nombre = "Ana" AND e.apellido = "Pérez";
    
-- 11.Listar el nombre del estudiante de menor edad.
	SELECT nombre
    FROM estudiante
    ORDER BY edad ASC
    LIMIT 1;
    
-- 12.Listar nombres de los estudiantes a los que se prestaron libros del area Literatura.
	SELECT e.nombre
    FROM prestamo p
    JOIN estudiante e ON e.idlector = p.idlector
    JOIN libro l ON l.idlibro = p.idlibro
    WHERE l.area = "Literatura";
    
-- 13.Listar los libros que pertenecen al autor 'Gabriel García Márquez'.
	SELECT l.título
    FROM libroautor la
    JOIN autor a ON a.idautor = la.idautor 
    JOIN libro l ON l.idlibro = la.idlibro
    WHERE a.nombre = "Gabriel García Márquez";
   
-- 14.Listar títulos de los libros que debían devolverse el 15/10/2023.
	SELECT l.título
    FROM prestamo p
    JOIN libro l ON l.idlibro = p.idlibro
    WHERE p.fechadevolucion = "2023-10-15";
