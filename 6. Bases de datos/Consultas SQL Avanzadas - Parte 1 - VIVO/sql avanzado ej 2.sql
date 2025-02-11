create database biblioteca;
use biblioteca;

CREATE TABLE LIBRO (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(255),
    Editorial VARCHAR(255),
    Area VARCHAR(100)
);

CREATE TABLE AUTOR (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Nacionalidad VARCHAR(100)
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE ESTUDIANTE (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Apellido VARCHAR(255),
    Dirección VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Un Libro Cualquiera', 'Salamandra', 'Literatura'),
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Sapiens', 'Editorial Debate', 'Historia'),
('El origen de las especies', 'Editorial Penguin', 'Ciencia'),
('1984', 'Editorial Secker & Warburg', 'Ficción');

INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Taylor Swift', 'Francesa'),
('Emilia Mernes', 'Italiana'),
('Yuval Noah Harari', 'Israelí'),
('Charles Darwin', 'Británica'),
('George Orwell', 'Británica');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),  -- Miguel de Cervantes -> El Quijote
(2, 2),  -- Gabriel García Márquez -> Cien años de soledad
(3, 3),  -- Yuval Noah Harari -> Sapiens
(4, 4),  -- Charles Darwin -> El origen de las especies
(5, 5);  -- George Orwell -> 1984

INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Carolina', 'Galarza', 'Calle Falsa 123', 'Informatica', 22),
('María', 'González', 'Avenida Siempre Viva 456', 'Historia', 21),
('Carlos', 'Sánchez', 'Callejón del Beso 789', 'Ciencias', 23),
('Ana', 'Rodriguez', 'Camino Real 1011', 'Filosofía', 24),
('Lucía', 'López', 'Boulevard de los Sueños 1213', 'Ingeniería', 20);

INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('David', 'Martínez', 'Calle del Sol 1415', 'Ingeniería', 25),
('Elena', 'Torres', 'Pasaje de la Luna 1617', 'Filosofía', 22),
('Sofía', 'Méndez', 'Avenida del Cielo 1819', 'Literatura', 24),
('Javier', 'Ramírez', 'Boulevard Estrella 2021', 'Ciencias', 23),
('Marta', 'Castillo', 'Calle Arco Iris 2223', 'Arte', 21);

INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Andrés', 'García', 'Calle Primavera 2425', 'Economía', 22),
('Valeria', 'Fernández', 'Avenida del Verano 2627', 'Derecho', 24),
('Fernando', 'Lara', 'Camino de Otoño 2829', 'Sociología', 23),
('Carolina', 'Romero', 'Boulevard Invierno 3031', 'Psicología', 25),
('Iván', 'Silva', 'Plaza de Mayo 3233', 'Música', 21),
('Natalia', 'Ríos', 'Avenida de las Flores 3435', 'Arquitectura', 22),
('Marco', 'Vargas', 'Paseo de la Paz 3637', 'Medicina', 24),
('Alicia', 'Soto', 'Camino Real 3839', 'Historia', 23),
('Gustavo', 'Morales', 'Paso de la Vida 4041', 'Matemática', 25),
('Isabel', 'Herrera', 'Calle de la Cultura 4243', 'Ingeniería Civil', 21);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-09-01', '2023-09-15', TRUE),   -- Juan prestó El Quijote
(2, 3, '2023-09-05', '2023-09-20', FALSE),  -- María prestó Sapiens
(3, 5, '2023-09-10', NULL, FALSE),           -- Carlos prestó 1984, sin devolver aún
(4, 4, '2023-09-12', '2023-09-28', TRUE),   -- Ana prestó El origen de las especies
(5, 2, '2023-09-15', NULL, FALSE);           -- Lucía prestó Cien años de soledad, sin devolver aún

INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('El Universo: Guía de viaje', 'Editorial Estelar', 'Ciencia');
INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Neil deGrasse Tyson', 'Estadounidense'),
('Brian Cox', 'Británica'),
('Michio Kaku', 'Estadounidense-Japonesa');
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(13, 7),  -- Neil deGrasse Tyson -> El Universo: Guía de viaje
(14, 7),  -- Brian Cox -> El Universo: Guía de viaje
(15, 7);  -- Michio Kaku -> El Universo: Guía de viaje



INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Fundamentos de Bases de Datos', 'Editorial Pearson', 'Base de Datos'),
('Diseño de Bases de Datos Modernas', 'Editorial McGraw-Hill', 'Base de Datos');

INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Luis', 'Hernández', 'Calle 1', 'Ing. Sistemas', 24),
('Raquel', 'Jiménez', 'Calle 2', 'Informática', 23),
('Miguel', 'Álvarez', 'Calle 3', 'Ciencias Computacionales', 22);

-- Supongamos que los ID generados para los libros y estudiantes son los siguientes
-- Ajusta los valores de idLector y idLibro a los que correspondan en tu base de datos
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(23, 8, '2023-10-01', NULL, FALSE),  -- Luis prestó "Fundamentos de Bases de Datos"
(24, 8, '2023-10-02', NULL, FALSE),  -- Raquel prestó "Fundamentos de Bases de Datos"
(23, 9, '2023-10-03', NULL, FALSE),  -- Luis prestó "Diseño de Bases de Datos Modernas"
(25, 9, '2023-10-04', '2023-10-09', TRUE);  -- Miguel prestó y devolvió "Diseño de Bases de Datos Modernas"



INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('J.K. Rowling', 'Británica');
select * from autor;

INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Harry Potter y la piedra filosofal', 'Editorial Bloomsbury', 'Ficción'),
('Harry Potter y la cámara secreta', 'Editorial Bloomsbury', 'Ficción');
select * from libro;


-- Supongamos que J.K. Rowling tiene el idAutor = 14 y los libros tienen idLibro = 13 y 14
-- Ajusta los valores según correspondan a esa tabla.
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(16, 10),  -- J.K. Rowling -> Harry Potter y la piedra filosofal
(16, 11);  -- J.K. Rowling -> Harry Potter y la cámara secreta



INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('El señor de los anillos', 'Editorial Minotauro', 'Ficción'),
('1Q84', 'Editorial Tusquets', 'Ficción'),
('Orgullo y prejuicio', 'Editorial Penguin Classics', 'Literatura');

-- Asegúrate de ajustar el idLector a un estudiante existente y el idLibro de acuerdo al orden de inserción.
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 13, '2021-07-01', '2021-07-16', TRUE),   -- "El señor de los anillos" devuelto el 2021-07-16
(2, 14, '2021-07-10', '2021-07-16', TRUE);   -- "1Q84" devuelto el 2021-07-16



INSERT INTO ESTUDIANTE (Nombre, Apellido, Dirección, Carrera, Edad) VALUES
('Filippo', 'Galli', 'Viale Roma 10', 'Literatura', 23);

INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('El alquimista', 'Editorial HarperCollins', 'Ficción'),
('El nombre del viento', 'Editorial DAW Books', 'Fantasía'),
('Rayuela', 'Editorial Sudamericana', 'Literatura');

-- Supongamos que el idLector para Filippo Galli es 11 y los libros tienen idLibro 15, 16, 17
-- Ajusta los valores según correspondan a esa tabla.
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(26, 15, '2023-06-10', '2023-06-20', TRUE),  -- "El alquimista" prestado a Filippo
(26, 16, '2023-07-01', NULL, FALSE);         -- "El nombre del viento" prestado a Filippo



-- 1. Listar los datos de los autores.
select * from autor;

-- 2. Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
select nombre, apellido, carrera
from estudiante
where carrera="informatica";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad in ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
select * from libro where area <> "internet";

-- 6. Listar los libros de la editorial Salamandra.
select * from libro where editorial="salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad<(select avg(edad) from estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where apellido like "g%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre 
from autor a join libroautor la on a.idAutor = la.idAutor join LIBRO l on la.idLibro = l.idLibro
where l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
select libro.titulo
from prestamo join estudiante ON prestamo.idLector = estudiante.idLector join libro ON prestamo.idLibro = libro.idLibro
where estudiante.nombre = 'Filippo' and estudiante.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
select nombre 
from estudiante
order by edad
limit 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select distinct estudiante.nombre 
from prestamo
join estudiante on prestamo.idLector = estudiante.idLector
join libro on prestamo.idLibro = libro.idLibro
where libro.area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
select libro.titulo 
from libro
join libroautor ON libro.idLibro = libroautor.idLibro
join autor on libroautor.idAutor = autor.idAutor
where autor.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
select libro.titulo 
from prestamo join libro on prestamo.idLibro = libro.idLibro
where prestamo.fechaDevolucion = '2021-07-16';