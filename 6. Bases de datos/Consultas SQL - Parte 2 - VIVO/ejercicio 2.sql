create database empresa_internet;

create table planes_internet(id int primary key auto_increment, velocidad float, precio decimal(0.2), descuento int);

create table clientes(dni varchar(10) primary key, nombre varchar(20), apellido varchar(20), fecha_nacimiento date, 
provincia varchar(20), ciudad varchar(20), plan_id int, foreign key (plan_id) references planes_internet(id));

INSERT INTO planes_internet (velocidad, precio, descuento) VALUES
(50.5, 29.99, 10),
(100.0, 49.99, 15),
(200.0, 69.99, 20),
(500.0, 89.99, 25),
(1000.0, 109.99, 30);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id) VALUES
('1234567890', 'Juan', 'Pérez', '1988-05-23', 'Buenos Aires', 'Buenos Aires', 1),
('0987654321', 'María', 'González', '1992-08-17', 'Córdoba', 'Córdoba', 2),
('1122334455', 'Carlos', 'Sánchez', '1985-12-05', 'Santa Fe', 'Rosario', 3),
('5566778899', 'Ana', 'Rodriguez', '1990-03-13', 'Mendoza', 'Mendoza', 4),
('9988776655', 'Lucía', 'López', '1995-07-24', 'Chubut', 'Comodoro Rivadavia', 5),
('12345678', 'Ana', 'Del Valle', '1988-05-23', 'Buenos Aires', 'Buenos Aires', 5),
('23456789', 'Juan', 'Morales', '1992-08-17', 'Córdoba', 'Córdoba', 4),
('34567890', 'Trinidad', 'Díaz', '1985-12-05', 'Santa Fe', 'Rosario', 3),
('98765443', 'Alejandro', 'Gómez', '1990-03-13', 'Mendoza', 'Mendoza', 2),
('12334534', 'Cristian', 'Castro', '1995-07-24', 'Chubut', 'Comodoro Rivadavia', 1);

SELECT dni, nombre, apellido 
FROM clientes 
WHERE provincia = 'Buenos Aires' 
ORDER BY apellido 
LIMIT 10;

SELECT id, velocidad, precio 
FROM planes_internet 
WHERE velocidad > 100 
ORDER BY precio DESC 
LIMIT 5;

SELECT dni, nombre, apellido, fecha_nacimiento 
FROM clientes 
WHERE fecha_nacimiento > '1990-01-01' 
ORDER BY fecha_nacimiento 
LIMIT 10;

SELECT dni, nombre, apellido, ciudad 
FROM clientes
LIMIT 10;

SELECT dni, nombre, apellido, plan_id 
FROM clientes 
WHERE plan_id = 3 
ORDER BY ciudad 
LIMIT 10;

SELECT id, velocidad, precio, descuento 
FROM planes_internet 
ORDER BY descuento DESC 
LIMIT 5;