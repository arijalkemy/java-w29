CREATE DATABASE EmpresaDB;
USE EmpresaDB;
-- Crear la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);
-- Insertar datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-0001', 'Software', 'Los Tigres'),
('D-0002', 'Sistemas', 'Guadalupe'),
('D-0003', 'Contabilidad', 'La Roca'),
('D-0004', 'Ventas', 'Plata');
-- Crear la tabla EMPLEADO
CREATE TABLE IF NOT EXISTS EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    comision DECIMAL(10,2) NOT NULL,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);
-- Insertar datos en la tabla EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-0004'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-0002'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-0003'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-0004'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 0, 'D-0004'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-0003'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-0001'),
('E-0008', 'Mariela', 'Mendez', 'Director', '2014-06-05', 185000, 0, 'D-0003');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, dep.localidad FROM Empleado AS em JOIN Departamento AS dep ON (em.depto_nro = dep.depto_nro);
SELECT em.nombre, em.puesto, dep.localidad FROM Empleado AS em NATURAL JOIN Departamento AS dep;
-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.nombre_depto, COUNT(*) FROM Departamento AS dep NATURAL JOIN Empleado AS em GROUP BY em.depto_nro HAVING COUNT(*) > 2; 
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, dep.nombre_depto FROM Departamento AS dep NATURAL JOIN Empleado AS em WHERE em.puesto = (
	SELECT puesto FROM Empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.nombre, em.apellido, em.salario FROM Empleado AS em WHERE em.depto_nro = 'D-0003' ORDER BY em.nombre ASC;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido, salario
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM EMPLEADO em
JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro
WHERE dep.nombre_depto = 'Ventas' 
AND salario = (SELECT MAX(em.salario)
	FROM EMPLEADO em
    JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro
    WHERE dep.nombre_depto = 'Ventas');