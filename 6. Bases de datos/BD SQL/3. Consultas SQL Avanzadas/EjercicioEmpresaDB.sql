-- DDL

CREATE TABLE empleado (
    cod_emp VARCHAR(6) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(7)
);

CREATE TABLE departamento (
    depto_nro VARCHAR(7) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- END DDL

-- DML

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', STR_TO_DATE('12/05/2018', '%d/%m/%Y'), 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', STR_TO_DATE('14/07/2015', '%d/%m/%Y'), 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', STR_TO_DATE('03/06/2015', '%d/%m/%Y'), 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', STR_TO_DATE('03/03/2018', '%d/%m/%Y'), 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', STR_TO_DATE('02/08/2014', '%d/%m/%Y'), 60000, 0, 'D-000-1');

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- END DML

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
	FROM empleado e
	INNER JOIN departamento d ON e.depto_nro = d.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.cod_emp) AS nro_empleados
	FROM departamento d 
	INNER JOIN empleado e ON e.depto_nro = d.depto_nro 
	GROUP BY d.nombre_depto
	HAVING nro_empleados > 5;
	
-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
	FROM empleado e
	INNER JOIN departamento d ON e.depto_nro = d.depto_nro
	WHERE e.puesto IN (SELECT e.puesto FROM empleado e WHERE e.nombre = "Mito" AND e.apellido = "Barchuk");
	
-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
	FROM empleado e
	INNER JOIN departamento d ON e.depto_nro = d.depto_nro
	WHERE e.depto_nro IN (SELECT d2.depto_nro FROM departamento d2 WHERE d2.nombre_depto = "Contabilidad")
	ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
	FROM empleado e
	WHERE e.salario IN (SELECT MIN(e2.salario) FROM empleado e2)
	LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
	FROM empleado e
	WHERE e.salario IN (SELECT MAX(e.salario)
		FROM empleado e
		INNER JOIN departamento d ON e.depto_nro = d.depto_nro
		WHERE e.depto_nro IN (SELECT d2.depto_nro FROM departamento d2 WHERE d2.nombre_depto = "Ventas"))









