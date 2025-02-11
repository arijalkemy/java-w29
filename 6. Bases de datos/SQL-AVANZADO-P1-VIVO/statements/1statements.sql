-- Parte 1

-- Crear tabla departamentos
CREATE TABLE departamentos (
                               depto_nro VARCHAR(7) PRIMARY KEY,
                               nombre_depto VARCHAR(50) NOT NULL,
                               localidad VARCHAR(50) NOT NULL
);

-- Crear tabla empleados
CREATE TABLE empleados (
                           cod_emp VARCHAR(6) PRIMARY KEY,
                           nombre VARCHAR(50) NOT NULL,
                           apellido VARCHAR(50) NOT NULL,
                           puesto VARCHAR(50) NOT NULL,
                           fecha_alta DATE NOT NULL,
                           salario DECIMAL(10,2) NOT NULL,
                           comision DECIMAL(10,2) NOT NULL DEFAULT 0,
                           depto_nro VARCHAR(7) NOT NULL,
                           FOREIGN KEY (depto_nro) REFERENCES departamentos(depto_nro)
);

-- Insertar datos en departamentos
INSERT INTO departamentos (depto_nro, nombre_depto, localidad) VALUES
                                                                   ('D-000-1', 'Software', 'Los Tigres'),
                                                                   ('D-000-2', 'Sistemas', 'Guadalupe'),
                                                                   ('D-000-3', 'Contabilidad', 'La Roca'),
                                                                   ('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en empleados
INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
                                                                                                        ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
                                                                          ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
                                                                                                        ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, dep.localidad FROM Empleado AS em JOIN Departamento AS dep ON (em.depto_nro = dep.depto_nro);
SELECT em.nombre, em.puesto, dep.localidad FROM Empleado AS em NATURAL JOIN Departamento AS dep;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT dep.nombre_depto, COUNT(*) FROM Departamento AS dep NATURAL JOIN Empleado AS em GROUP BY em.depto_nro HAVING COUNT(*) > 2;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, dep.nombre_depto FROM Departamento AS dep NATURAL JOIN Empleado AS em WHERE em.puesto = (
    SELECT puesto FROM Empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);
-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.nombre, em.apellido, em.salario FROM Empleado AS em WHERE em.depto_nro = 'D-0003' ORDER BY em.nombre ASC;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido, salario
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM EMPLEADO em
         JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro
WHERE dep.nombre_depto = 'Ventas'
  AND salario = (SELECT MAX(em.salario)
                 FROM EMPLEADO em
                          JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro
                 WHERE dep.nombre_depto = 'Ventas');