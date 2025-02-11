DROP DATABASE IF EXISTS empleado;
CREATE DATABASE empleado;
USE empleado;


CREATE TABLE DEPARTAMENTO (
                              depto_nro VARCHAR(10) PRIMARY KEY,
                              nombre_depto VARCHAR(50),
                              localidad VARCHAR(50)
);
CREATE TABLE EMPLEADO (
                          cod_emp VARCHAR(10) PRIMARY KEY,
                          nombre VARCHAR(50),
                          apellido VARCHAR(50),
                          puesto VARCHAR(50),
                          fecha_alta DATE,
                          salario DECIMAL(10, 2),
                          comision DECIMAL(10, 2),
                          depto_nro VARCHAR(10),
                          FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);
-- Inserts para la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
                                                                  ('D-000-1', 'Software', 'Los Tigres'),
                                                                  ('D-000-2', 'Sistemas', 'Guadalupe'),
                                                                  ('D-000-3', 'Contabilidad', 'La Roca'),
                                                                  ('D-000-4', 'Ventas', 'Plata');
-- Inserts para la tabla EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
                                                                                                       ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-12-05', 80000.00, 15000.00, 'D-000-4'),
                                                                                                       ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-000-2'),
                                                                                                       ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.00, 0.00, 'D-000-3'),
                                                                                                       ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-000-4'),
                                                                                                       ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-000-4'),
                                                                                                       ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-000-3'),
                                                                                                       ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000.00, 0.00, 'D-000-1');
-- 1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad from EMPLEADO e left join DEPARTAMENTO d on e.depto_nro = d.depto_nro;

-- 2 Visualizar los departamentos con más de cinco empleados.
select
    count(*) total_empleados,
    e.depto_nro ,
    d.localidad
from EMPLEADO e
         join DEPARTAMENTO d on d.depto_nro = e.depto_nro
GROUP by e.depto_nro
having total_empleados > 5;

-- 3 Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select
    e.nombre, e.salario, d.nombre_depto
from EMPLEADO e
         join DEPARTAMENTO d on d.depto_nro = e.depto_nro
where e.puesto = (select puesto from EMPLEADO where cod_emp = 'E-0006');

-- 4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select
    *
from EMPLEADO e
         join DEPARTAMENTO d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Contabilidad'
order by e.nombre;

-- 5 Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from EMPLEADO e order by e.salario limit 1;

-- 6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.* from EMPLEADO e
                    join DEPARTAMENTO d on d.depto_nro = e.depto_nro
where d.nombre_depto  = 'Ventas'
order by e.salario desc limit 1 ;