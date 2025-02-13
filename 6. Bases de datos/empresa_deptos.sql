-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS empresa;

-- Selección de la base de datos
USE empresa;

-- Creación de la tabla DEPARTAMENTO
CREATE TABLE IF NOT EXISTS DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

-- Creación de la tabla EMPLEADO
CREATE TABLE IF NOT EXISTS EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

-- Insertar datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en la tabla EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d
ON e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(*) AS total
FROM DEPARTAMENTO d INNER JOIN EMPLEADO e
ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto
HAVING total > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d
ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
	SELECT e2.puesto 
    FROM EMPLEADO e2 
    WHERE e2.nombre = 'Mito' AND e2.apellido = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.apellido
FROM EMPLEADO e
WHERE e.salario = (SELECT MIN(e2.salario) FROM EMPLEADO e2);

-- Otra forma...
/*
SELECT e.nombre, e.apellido
FROM EMPLEADO e
ORDER BY e.salario ASC
LIMIT 1;
*/

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM EMPLEADO e
WHERE e.salario = (
	SELECT MAX(e2.salario) 
    FROM EMPLEADO e2 INNER JOIN DEPARTAMENTO d
	ON e2.depto_nro = d.depto_nro
	WHERE d.nombre_depto = 'Ventas' 
);