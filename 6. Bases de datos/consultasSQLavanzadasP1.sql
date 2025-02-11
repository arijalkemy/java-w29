CREATE DATABASE empresa_db;
USE empresa_db;
CREATE TABLE empresa_db.departamento (
                                         depto_nro VARCHAR(10) PRIMARY KEY,
                                         nombre_depto VARCHAR(20),
                                         localidad VARCHAR(20)
);
CREATE TABLE empresa_db.empleado (
                                     cod_emp VARCHAR(10) PRIMARY KEY,
                                     nombre VARCHAR(100),
                                     apellido VARCHAR(100),
                                     puesto VARCHAR(50),
                                     fecha_alta DATE,
                                     salario DECIMAL(10, 2),
                                     comision DECIMAL(10, 2),
                                     depto_nro VARCHAR(10),
                                     FOREIGN KEY (depto_nro) REFERENCES departamento (depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
                                                                  ('D-000-1', 'Software', 'Los Tigres'),
                                                                  ('D-000-2', 'Sistemas', 'Guadalupe'),
                                                                  ('D-000-3', 'Contabilidad', 'La Roca'),
                                                                  ('D-000-4', 'Ventas', 'Plata');
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
                                                                                                      ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
                                                                                                      ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
                                                                                                      ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
                                                                                                      ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
                                                                                                      ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
                                                                                                      ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
                                                                                                      ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Consultas
-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
    e.nombre, e.puesto, d.nombre_depto, d.localidad
FROM
    empleado e
        INNER JOIN
    departamento d ON d.depto_nro = e.depto_nro;
-- 2.Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(*) AS numero_empleados
FROM departamento d
         JOIN empleado e ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto
HAVING numero_empleados > 2;
-- 3.Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario , d.nombre_depto
FROM empleado e
         JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Jonathan' AND apellido = 'Aguilera');
-- 4.Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
         JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
-- 5.Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre,salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);
SELECT nombre,salario
FROM empleado
ORDER BY salario
LIMIT 1;
-- 6.Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre,e.salario
FROM empleado e
         JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY salario DESC
LIMIT 1;
