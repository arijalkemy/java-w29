DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE departamento(
	depto_nro varchar(10) NOT NULL,
    nombre_depto varchar(25) NOT NULL,
    localidad varchar(25) NOT NULL,
    PRIMARY KEY(depto_nro)
);
	
CREATE TABLE empleado(
	cod_emp varchar(10) NOT NULL,
    nombre varchar(25) NOT NULL,
    apellido varchar(25) NOT NULL,
    puesto varchar(25) NOT NULL,
    fecha_alta timestamp NOT NULL,
    salario int(10) NOT NULL,
    comision int(10) NOT NULL,
    depto_nro varchar(10) NOT NULL,
    PRIMARY KEY(cod_emp),
	FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);
	
	
	# Insertar valores
	
INSERT INTO departamento  (depto_nro, nombre_depto, localidad) 
VALUES
		('D-000-1', 'Software', 'Los Tigres'),
		('D-000-2', 'Sistemas', 'Guadalupe'),
		('D-000-3', 'Contabilidad', 'La Roca'),
		('D-000-4', 'Ventas', 'Plata');
	
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
	('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
	('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
	('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
	('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
	('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
	('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
	('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
	
# Queries

SELECT empleado.nombre, departamento.nombre_depto, empleado.puesto, departamento.localidad 
FROM empleado AS empleado JOIN empresa_db.departamento AS departamento 
ON empleado.depto_nro = departamento.depto_nro
GROUP BY empleado.nombre, departamento.nombre_depto, empleado.puesto, departamento.localidad 
HAVING empleado.puesto LIKE "%vendedor%";

SELECT empleado.nombre, departamento.nombre_depto, empleado.puesto, departamento.localidad 
FROM empleado AS empleado JOIN empresa_db.departamento AS departamento 
ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto LIKE "%vendedor%";

SELECT departamento.depto_nro, departamento.nombre_depto, COUNT(empleado.cod_emp) AS cantidad_empleados
FROM empresa_db.departamento AS departamento JOIN empresa_db.empleado AS empleado
ON empleado.depto_nro = departamento.depto_nro
GROUP BY empresa_db.departamento.depto_nro
HAVING COUNT(empresa_db.empleado.cod_emp) > 1;

SELECT nombre, salario, nombre_depto
FROM empresa_db.departamento AS departamento JOIN empresa_db.empleado AS empleado
ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (
	SELECT puesto FROM empresa_db.empleado AS empleado
    WHERE empleado.nombre LIKE "%mito%" AND empleado.apellido LIKE "%barchuk%"
);

SELECT * FROM empresa_db.departamento AS departamento JOIN empresa_db.empleado AS empleado
WHERE departamento.nombre_depto LIKE "%contabilidad%"
ORDER BY empleado.nombre;

SELECT nombre FROM empresa_db.empleado AS empleado
ORDER BY empleado.salario
LIMIT 1;

SELECT empleado.*
FROM empresa_db.empleado AS empleado JOIN empresa_db.departamento AS departamento 
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = "Ventas"
ORDER BY empleado.salario DESC
LIMIT 1;