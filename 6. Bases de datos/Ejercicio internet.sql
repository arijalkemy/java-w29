CREATE SCHEMA empresaInternet;
USE empresaInternet;
DROP TABLE IF EXISTS `InternetPlan`;
CREATE TABLE InternetPlan (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);
DROP TABLE IF EXISTS `Cliente`;
CREATE TABLE Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_nacimiento DATE,
    provincia VARCHAR(100),
    ciudad VARCHAR(100),
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES InternetPlan(id_plan)
);
-- Inserción de 5 registros en la tabla InternetPlan
INSERT INTO InternetPlan (velocidad, precio, descuento)
VALUES
(50, 150.00, 10),
(100, 250.00, 15),
(200, 350.00, 20),
(300, 450.00, 25),
(500, 600.00, 30);
-- Inserción de 10 registros en la tabla Cliente
INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)
VALUES
('12345678A', 'Juan', 'Pérez', '1990-05-12', 'Buenos Aires', 'La Plata', 1),
('87654321B', 'Ana', 'Gómez', '1985-02-25', 'Córdoba', 'Córdoba', 2),
('11223344C', 'Carlos', 'López', '1987-08-19', 'Santa Fe', 'Rosario', 3),
('55667788D', 'Laura', 'Martínez', '1992-11-30', 'Mendoza', 'Mendoza', 4),
('99887766E', 'Pedro', 'García', '1995-01-05', 'Buenos Aires', 'Quilmes', 5),
('33445566F', 'Sofía', 'Rodríguez', '1993-04-22', 'CABA', 'Buenos Aires', 1),
('22334455G', 'José', 'Hernández', '1988-07-15', 'Salta', 'Salta', 2),
('66554433H', 'María', 'Sánchez', '1984-12-11', 'Tucumán', 'San Miguel de Tucumán', 3),
('99881122I', 'Luis', 'Ramírez', '1991-03-17', 'Chaco', 'Resistencia', 4),
('55443322J', 'Isabel', 'Fernández', '1994-09-27', 'Misiones', 'Posadas', 5);