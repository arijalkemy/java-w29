drop database if exists biblioteca_db;
create database biblioteca_db;
use biblioteca_db;

drop table if exists libro;
create table libro(
`idLibro` int not null primary key auto_increment,
`titulo` varchar(50) not null,
`editorial` varchar(20) not null,
`area` varchar(50)
);

drop table if exists autor;
create table autor(
`idAutor` int not null primary key auto_increment,
`nombre` varchar(50) not null,
`nacionalidad` varchar(30)
);

drop table if exists estudiante;
create table estudiante(
`idLector` int not null primary key auto_increment,
`nombre` varchar(50) not null,
`apellido` varchar(50) not null,
`direccion` varchar(30),
`carrera` varchar(30),
`edad` int
);

drop table if exists libro_autor;
create table libro_autor(
`idLibro` int not null,
`idAutor` int not null,
constraint `idLibro_autor_foreign` foreign key (`idLibro`) references libro (`idLibro`),
constraint `idAutor_foreign` foreign key (`idAutor`) references autor (`idAutor`)
);

drop table if exists prestamo;
create table prestamo(
`idLibro` int not null,
`idLector` int not null,
`fechaPrestamo` date,
`fechaDevolucion` date,
`devuelto` bool,
constraint `idLibro_prestamo_foreign` foreign key (`idLibro`) references libro (`idLibro`),
constraint `idLector_foreign` foreign key (`idLector`) references estudiante (`idLector`)
);


INSERT INTO libro (titulo, editorial, area) VALUES
('Cien Años de Soledad', 'Editorial XYZ', 'Literatura'),
('Don Quijote de la Mancha', 'Editorial ABC', 'Literatura'),
('1984', 'Editorial DEF', 'Ficción'),
('El Gran Gatsby', 'Editorial GHI', 'Ficción'),
('Orgullo y Prejuicio', 'Editorial JKL', 'Romántica'),
('Matar a un ruiseñor', 'Editorial MNO', 'Drama'),
('La Odisea', 'Editorial PQR', 'Clásicos'),
('El Hobbit', 'Editorial STU', 'Aventura'),
('La Casa de los Espíritus', 'Editorial VWX', 'Misterio'),
('El Retrato de Dorian Gray', 'Editorial YZA', 'Filosofía'),
('El Código Da Vinci', 'Salamandra', 'Misterio'),
('El Alquimista', 'Salamandra', 'Aventura'),
('La Sombra del Viento', 'Salamandra', 'Suspenso'),
('Introducción a la Programación Web', 'Editorial Digital', 'Internet'),
('Redes y Conectividad', 'TechBooks', 'Internet'),
('Desarrollo de Aplicaciones Web', 'Online Press', 'Internet');


INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiano'),
('Miguel de Cervantes', 'Español'),
('George Orwell', 'Inglés'),
('F. Scott Fitzgerald', 'Estadounidense'),
('Jane Austen', 'Británica'),
('Harper Lee', 'Estadounidense'),
('Homero', 'Griego'),
('J.R.R. Tolkien', 'Inglés'),
('Isabel Allende', 'Chilena'),
('Oscar Wilde', 'Irlandés'),
('Victor Hugo', 'Francés'),
('Marcel Proust', 'Francés'),
('Dante Alighieri', 'Italiano'),
('Italo Calvino', 'Italiano'),
('Albert Camus', 'Francés');


INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle 123', 'Ingeniería', 33),
('Ana', 'Gómez', 'Avenida 456', 'Ingeniería', 19),
('Carlos', 'López', 'Calle 789', 'Derecho', 19),
('Laura', 'Martínez', 'Calle 101', 'Medicina', 24),
('Pedro', 'Rodríguez', 'Avenida 202', 'Arquitectura', 51),
('Marta', 'Hernández', 'Calle 303', 'Ingeniería', 45),
('Luis', 'García', 'Calle 404', 'Biología', 32),
('Sofía', 'Díaz', 'Avenida 505', 'Psicología', 21),
('David', 'Ramírez', 'Calle 606', 'Filosofía', 26),
('Elena', 'Fernández', 'Avenida 707', 'Sociología', 37),
('Elenonora', 'No se', 'Calle Falsa 123', 'Medicina', 58),
('Roberto', 'Martínez', 'Calle 808', 'Informática', 22),
('María', 'Vázquez', 'Avenida 909', 'Informática', 23),
('José', 'Paredes', 'Calle 1010', 'Informática', 21),
('Lucía', 'Sánchez', 'Avenida 1111', 'Informática', 24),
('Diego', 'Jiménez', 'Calle 1212', 'Informática', 22);




/*
Listar los datos de los autores.
Listar nombre y edad de los estudiantes
¿Qué estudiantes pertenecen a la carrera informática?
¿Qué autores son de nacionalidad francesa o italiana?
¿Qué libros no son del área de internet?
Listar los libros de la editorial Salamandra.
*/

select * from autor;

select nombre, edad from estudiante;

select * from estudiante where carrera = 'Informática';

select * from autor where nacionalidad in ('Francés', 'Francesa', 'Italiano', 'Italiana');

select * from libro where area != 'Internet';

select * from libro where editorial = 'Salamandra';

/*
Listar los datos de los estudiantes cuya edad es mayor al promedio.
Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
¿Qué libros se prestaron al lector “Filippo Galli”?
Listar el nombre del estudiante de menor edad.
Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Listar los libros que pertenecen a la autora J.K. Rowling.
Listar títulos de los libros que debían devolverse el 16/07/2021.*/

select * 
from estudiante
where edad > (select avg(edad) from estudiante);

select nombre from estudiante
where apellido like 'G%'









