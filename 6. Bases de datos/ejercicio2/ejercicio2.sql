CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE clientes (
    id INTEGER AUTO_INCREMENT,
    dni VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(30) NOT NULL,  
    ciudad VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)  
);

CREATE TABLE planes (
    id INTEGER AUTO_INCREMENT,
    identificacion VARCHAR(30) NOT NULL,
    velocidad_mb INTEGER NOT NULL,
    precio DOUBLE NOT NULL,
    descuento DOUBLE NOT NULL,
    cliente_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) 
);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) 
VALUES
('12345678', 'Carlos', 'González', '1985-02-15', 'Cundinamarca', 'Bogotá'),
('23456789', 'María', 'López', '1990-03-22', 'Antioquia', 'Medellín'),
('34567890', 'José', 'Rodríguez', '1982-05-11', 'Valle del Cauca', 'Cali'),
('45678901', 'Ana', 'Martínez', '1995-07-09', 'Atlántico', 'Barranquilla'),
('56789012', 'Pedro', 'Sánchez', '1987-08-30', 'Boyacá', 'Tunja'),
('67890123', 'Laura', 'Pérez', '1992-09-14', 'Santander', 'Bucaramanga'),
('78901234', 'Juan', 'Díaz', '1980-11-05', 'Tolima', 'Ibagué'),
('89012345', 'Lucía', 'Gómez', '1998-01-20', 'Nariño', 'Pasto'),
('90123456', 'Miguel', 'Fernández', '1993-12-30', 'Cundinamarca', 'Soacha'),
('01234567', 'Elena', 'Serrano', '1988-04-02', 'La Guajira', 'Riohacha');

INSERT INTO planes (identificacion, velocidad_mb, precio, descuento, cliente_id) 
VALUES
('Plan A1', 50, 100000, 10, 1),  
('Plan B2', 100, 180000, 15, 2),
('Plan C3', 200, 250000, 20, 3), 
('Plan D4', 500, 400000, 25, 4),
('Plan E5', 1000, 600000, 30, 5);

-- obtener todo los clientes
SELECT * FROM clientes;
-- buscar un cliente por su numero de dni
SELECT * FROM clientes WHERE dni = '12345678';
-- Listar los planes disponibles con su velocidad y precio
SELECT identificacion, velocidad_mb, precio FROM planes;
-- Obtener el nombre y apellido de los clientes que viven en Bogotá.
SELECT nombre, apellido FROM clientes WHERE ciudad = 'Bogotá';
-- Ver los planes con descuento superior al 20%.
SELECT * FROM planes WHERE descuento > 20;
-- Contar el número de clientes por cada ciudad.
SELECT ciudad, COUNT(*) AS total_clientes
FROM clientes
GROUP BY ciudad;
-- Obtener el cliente con el precio de plan más alto.
SELECT c.nombre, c.apellido, p.precio
FROM clientes c
JOIN planes p ON c.id = p.cliente_id
ORDER BY p.precio DESC
LIMIT 1;
-- Ver los planes que tienen una velocidad mayor a 100 Mbps
SELECT * FROM planes WHERE velocidad_mb > 100;
-- Listar todos los clientes que nacieron después de 1990.
SELECT * FROM clientes WHERE fecha_nacimiento > '1990-01-01';
-- Obtener el promedio de precios de los planes ofrecidos.
SELECT AVG(precio) AS promedio_precio FROM planes;




