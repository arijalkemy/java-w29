-- Crear la base de datos
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

-- Crear la tabla de planes de internet
CREATE TABLE planes_internet (
                                 id_plan INT PRIMARY KEY AUTO_INCREMENT,
                                 velocidad_megas INT NOT NULL,
                                 precio DECIMAL(10,2) NOT NULL,
                                 descuento DECIMAL(5,2)
);

-- Crear la tabla de clientes
CREATE TABLE clientes (
                          dni VARCHAR(20) PRIMARY KEY,
                          nombre VARCHAR(50) NOT NULL,
                          apellido VARCHAR(50) NOT NULL,
                          fecha_nacimiento DATE,
                          provincia VARCHAR(50),
                          ciudad VARCHAR(50),
                          id_plan INT,
                          FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan)
);

-- Insertar registros en la tabla de planes de internet
INSERT INTO planes_internet (velocidad_megas, precio, descuento) VALUES
                                                                     (50, 40.99, 5.00),
                                                                     (100, 60.99, 10.00),
                                                                     (200, 80.99, 15.00),
                                                                     (300, 100.99, 20.00),
                                                                     (500, 150.99, 25.00);

-- Insertar registros en la tabla de clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
                                                                                               ('12345678A', 'Juan', 'Pérez', '1990-05-20', 'Buenos Aires', 'La Plata', 1),
                                                                                               ('23456789B', 'María', 'López', '1985-10-12', 'Córdoba', 'Córdoba', 2),
                                                                                               ('34567890C', 'Carlos', 'García', '1992-07-15', 'Santa Fe', 'Rosario', 3),
                                                                                               ('45678901D', 'Ana', 'Martínez', '1988-03-08', 'Mendoza', 'Mendoza', 4),
                                                                                               ('56789012E', 'Luis', 'Fernández', '1995-09-30', 'Tucumán', 'San Miguel', 5),
                                                                                               ('67890123F', 'Lucía', 'Díaz', '1993-11-25', 'Buenos Aires', 'Mar del Plata', 1),
                                                                                               ('78901234G', 'Martín', 'Sánchez', '1991-04-17', 'Salta', 'Salta', 2),
                                                                                               ('89012345H', 'Sofía', 'Romero', '1987-06-22', 'Jujuy', 'San Salvador', 3),
                                                                                               ('90123456I', 'Diego', 'Alvarez', '1994-12-05', 'Chaco', 'Resistencia', 4),
                                                                                               ('01234567J', 'Valeria', 'Gómez', '1989-01-19', 'Neuquén', 'Neuquén', 5);
