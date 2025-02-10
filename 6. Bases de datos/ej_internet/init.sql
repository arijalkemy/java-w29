-- crear base de datos
DROP DATABASE IF EXISTS internet_db;
CREATE DATABASE internet_db;
USE internet_db;

-- crear tabla clientes
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);

-- crear tabla planes
DROP TABLE IF EXISTS `planes`;
CREATE TABLE planes (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    velocidad INT NOT NULL,
    precio_base DECIMAL(10, 2) NOT NULL
);

-- crear tabla contratos
DROP TABLE IF EXISTS `contratos`;
CREATE TABLE contratos (
    id_contrato INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_plan INT NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    precio_total DECIMAL(10, 2),
    descuento DECIMAL(5, 2),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_plan) REFERENCES planes(id_plan)
);

-- trigger para calcular el precio total de un plan al insertar un nuevo registro en la tabla contratos
DELIMITER $$

CREATE TRIGGER calcular_precio_total
    BEFORE INSERT ON contratos
    FOR EACH ROW
BEGIN
    DECLARE precio DECIMAL(10, 2);

    -- obtener el precio del plan
    SELECT precio_base INTO precio
    FROM planes
    WHERE id_plan = NEW.id_plan;

    -- calcular el precio total
    SET NEW.precio_total = precio - (precio * (NEW.descuento / 100));
END$$

    DELIMITER ;

-- insertar registros de ejemplo en la tabla clientes (10 clientes)

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
    ('12345678A', 'Juan', 'Pérez', '1985-03-10', 'Buenos Aires', 'La Plata'),
    ('98765432B', 'Ana', 'Gómez', '1990-07-25', 'CABA', 'Buenos Aires'),
    ('11122233C', 'Carlos', 'López', '1980-01-15', 'Mendoza', 'Mendoza'),
    ('22334455D', 'Laura', 'Martínez', '1995-02-18', 'Santa Fe', 'Rosario'),
    ('66778899E', 'Pedro', 'García', '1988-04-12', 'CABA', 'Buenos Aires'),
    ('33445566F', 'Marta', 'Fernández', '1983-08-22', 'Cordoba', 'Córdoba'),
    ('55667788G', 'Luis', 'Rodríguez', '1992-11-30', 'Tucumán', 'San Miguel de Tucumán'),
    ('88990011H', 'José', 'Vázquez', '1987-06-10', 'Buenos Aires', 'Avellaneda'),
    ('44332211I', 'Elena', 'Mendoza', '1993-01-05', 'Chaco', 'Resistencia'),
    ('99887766J', 'Ricardo', 'Sánchez', '1981-09-14', 'Neuquén', 'Neuquén');

-- insertar registros de ejemplo en la tabla planes (5 planes)
INSERT INTO planes (velocidad, precio_base)
VALUES
    (20, 500.00),
    (50, 1000.00),
    (100, 1500.00),
    (200, 2500.00),
    (300, 3000.00);

-- insertar registros de ejemplo en la tabla contratos (relacionar 10 clientes con 5 planes)
INSERT INTO contratos (id_cliente, id_plan, fecha_inicio, fecha_fin, descuento)
VALUES
    (1, 1, '2025-02-01', '2026-02-01', 10.00),
    (2, 2, '2025-03-01', '2026-03-01', 20.00),
    (3, 3, '2025-04-01', '2026-04-01', 15.00),
    (4, 4, '2025-05-01', '2026-05-01', 5.00),
    (5, 5, '2025-06-01', '2026-06-01', 25.00),
    (6, 1, '2025-07-01', '2026-07-01', 30.00),
    (7, 2, '2025-08-01', '2026-08-01', 10.00),
    (8, 3, '2025-09-01', '2026-09-01', 18.00),
    (9, 4, '2025-10-01', '2026-10-01', 12.00),
    (10, 5, '2025-11-01', '2026-11-01', 7.00);
