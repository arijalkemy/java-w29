USE empresa_internet;

/* Insertar 10 registros en la tabla Clientes. */
INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
	('12345678', 'Juan', 'Pérez', '1985-06-15', 'Buenos Aires', 'CABA'),
	('87654321', 'María', 'Gómez', '1990-02-20', 'Córdoba', 'Córdoba'),
	('11223344', 'Carlos', 'López', '2001-11-05', 'Mendoza', 'Mendoza'),
	('22334455', 'Ana', 'Fernández', '1995-08-25', 'Santa Fe', 'Rosario'),
	('33445566', 'Diego', 'Martínez', '1988-04-10', 'Tucumán', 'San Miguel de Tucumán'),
	('44556677', 'Lucía', 'Rodríguez', '1993-12-30', 'Cundinamarca', 'Bogotá'),
	('55667788', 'Martín', 'Sánchez', '2000-07-22', 'Antioquia', 'Medellín'),
	('66778899', 'Sofía', 'González', '1997-09-12', 'Valle del Cauca', 'Cali'),
	('77889900', 'Andrés', 'Ruiz', '1986-03-05', 'Atlántico', 'Barranquilla'),
	('88990011', 'Paula', 'Díaz', '2003-05-18', 'Santander', 'Bucaramanga');

/* Insertar 5 registros en la tabla Planes. */
INSERT INTO Planes (velocidad, precio)
VALUES 
	(50, 30.00),
	(100, 50.00),
	(200, 75.00),
	(300, 90.00),
	(500, 120.00);
    
/* Insertar Contratos para cada Cliente. */
INSERT INTO Contratos (cliente_id, plan_id, descuento)
VALUES 
	(1, 1, 5.00),
	(2, 2, 10.00),
	(3, 3, 0.00),
	(4, 4, 15.00),
	(5, 5, 5.00),
	(6, 1, 10.00),
	(7, 2, 0.00),
	(8, 3, 5.00),
	(9, 4, 10.00),
	(10, 5, 15.00);
    
/* ------------------- CONSULTAS ------------------- */
/* 1. Clientes que nacieron después del 2000. */
SELECT 
	nombre, 
	apellido 
FROM Clientes  
WHERE YEAR(fecha_nacimiento) >= 2000;

/* 2. Obtener los clientes que tienen un descuento mayor a 10 en su contrato. */
SELECT 
	nombre, 
	apellido 
FROM Clientes 
WHERE cliente_id IN (SELECT cliente_id FROM Contratos WHERE descuento > 10);

/* 3. Clientes mayores a 30 años. */
SELECT 
	nombre, 
	apellido 
FROM Clientes 
WHERE TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE()) > 30;
-- TIMESTAMPDIFF(YEAR, X, Y) calcula la diferencia en años entre las fechas X e Y, CURDATE() devuelve la fecha actual.

/* 4. Clientes cuyo nombre empieza con la letra 'A'. */
SELECT 
	nombre, 
	apellido 
FROM Clientes 
WHERE nombre LIKE 'a%';

/* 5. Obtener el promedio de los precios de los planes. */
SELECT AVG(precio) AS 'Precio promedio' FROM Planes;

/* 6. Contar cuántos clientes hay en cada provincia o departamento. */
SELECT 
	provincia, 
	COUNT(*) AS cantidad_clientes
FROM Clientes 
GROUP BY provincia 
ORDER BY cantidad_clientes DESC;

/* 7. Clientes cuyo apellido NO termine en "ez". */
SELECT 
	nombre, 
	apellido 
FROM Clientes 
WHERE apellido NOT LIKE '%ez';

/* 8. Cuántos clientes tiene cada plan. */
SELECT 
	plan_id, 
    COUNT(cliente_id) AS 'Cantidad de clientes'
FROM Contratos 
GROUP BY plan_id 
ORDER BY 2 DESC;

/* 9. Plan más barato. */
SELECT 
	plan_id,
    precio
FROM Planes 
WHERE precio = (SELECT MIN(precio) FROM Planes);

/* 10. Plan con la mayor velocidad. */
SELECT 
	plan_id,
    velocidad
FROM Planes 
WHERE velocidad = (SELECT MAX(velocidad) FROM Planes);