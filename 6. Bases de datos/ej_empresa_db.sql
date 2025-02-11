DROP SCHEMA IF EXISTS empresa_db;
CREATE SCHEMA IF NOT EXISTS empresa_db;
USE empresa_db;

-- Crear la tabla departamento
CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

-- Crear la tabla empleado con depto_nro como llave foránea
CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    comision DECIMAL(10,2) NOT NULL,
    depto_nro VARCHAR(10) NOT NULL,
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insertar datos en la tabla departamento
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en la tabla empleado
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


/* 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT emp.nombre, emp.puesto, depto.localidad 
FROM empleado emp 
INNER JOIN departamento depto 
ON emp.depto_nro = depto.depto_nro;

/* 2. Visualizar los departamentos con más de cinco empleados. */
SELECT d.depto_nro, d.nombre_depto, d.localidad, COUNT(e.cod_emp) AS cantidad_empleados
FROM departamento d
JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro, d.nombre_depto, d.localidad
HAVING COUNT(e.cod_emp) > 5;

/* 3. Mostrar el nombre, salario y nombre del departamento de los 
empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

/* 4. Mostrar los datos de los empleados que trabajan en el departamento de 
contabilidad, ordenados por nombre. */
SELECT e.* FROM empleado e 
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'contabilidad'
ORDER BY e.nombre;

/* 5. Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

/* 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
AND e.salario = (
    SELECT MAX(salario)
    FROM empleado
    WHERE depto_nro = d.depto_nro
);








