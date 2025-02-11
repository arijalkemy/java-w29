CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE clientes
(
    dni              VARCHAR(10) PRIMARY KEY,
    nombre           VARCHAR(50) NOT NULL,
    apellido         VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE        NOT NULL,
    provincia        VARCHAR(50) NOT NULL,
    ciudad           VARCHAR(50) NOT NULL,
    idPlan           INT,
    FOREIGN KEY (idPlan) REFERENCES planes_internet (id_plan)
);

CREATE TABLE planes_internet
(
    id_plan         INT PRIMARY KEY AUTO_INCREMENT,
    velocidad_megas INT            NOT NULL,
    precio          DECIMAL(10, 2) NOT NULL,
    descuento       DECIMAL(5, 2) DEFAULT 0
);

INSERT INTO planes_internet (velocidad_megas, precio, descuento)
VALUES (10, 29.99, 0),
       (20, 39.99, 5),
       (50, 59.99, 10),
       (100, 79.99, 15);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, idPlan)
VALUES ('12345678', 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'La Plata', 1),
       ('87654321', 'María', 'Gómez', '1985-06-30', 'Córdoba', 'Córdoba', 2),
       ('11223344', 'Luis', 'Martínez', '2000-12-05', 'Santa Fe', 'Rosario', 3),
       ('22334455', 'Ana', 'López', '1995-11-22', 'Mendoza', 'Mendoza', 4);

#10 CONSULTAS

-- 1 Obtener todos los clientes:
SELECT *
FROM clientes;

-- 2 Obtener todos los planes de Internet:
SELECT *
FROM planes_internet;

-- 3 Obtener un cliente específico por su DNI:
SELECT *
FROM clientes
WHERE dni = "11223344";

-- 4 Obtener todos los clientes que tienen un plan de velocidad mayor a 20 megas:
SELECT c.*
FROM clientes c
         JOIN planes_internet pi on c.idPlan = pi.id_plan
WHERE pi.velocidad_megas > 20;

-- 5 Obtener el número total de clientes en la base de datos:
SELECT COUNT(*) AS total_clientes
FROM clientes;

-- 6 Obtener el promedio de precios de los planes disponibles:
SELECT AVG(precio) as promedio_precio
FROM planes_internet;

-- 7 Obtener todos los planes con un descuento superior al 10%:
SELECT *
FROM planes_internet
WHERE descuento > 10;

-- 8 Listar los clientes junto con el nombre del plan que tienen:
SELECT c.*, pi.velocidad_megas, pi.precio
FROM clientes c
         JOIN planes_internet pi on pi.id_plan = c.idPlan;

-- 9 Obtener los clientes que viven en 'Córdoba':
SELECT *
FROM clientes
WHERE ciudad = "Cordoba";

-- 10 Obtener la cantidad de clientes por provincia:
SELECT provincia, COUNT(*)
FROM clientes
GROUP BY provincia;






