CREATE DATABASE IF NOT EXISTS empresa_db;

USE empresa_db;

-- Crear la tabla Empleado
CREATE TABLE IF NOT EXISTS empleado (
    cod_emp VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10,2),
    comision DECIMAL(10,2),
    depto_nro VARCHAR(10)
);

-- Insertar registros en la tabla Empleado

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


CREATE TABLE IF NOT EXISTS departamento (
    depto_nro VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Insertar registros en la tabla DEPARTAMENTO
INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ('D-000-1', 'Software', 'Los Tigres');

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ('D-000-2', 'Sistemas', 'Guadalupe');

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ('D-000-3', 'Contabilidad', 'La Roca');

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ('D-000-4', 'Ventas', 'Plata');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

select
concat(e.nombre, " ", e.apellido) as "Nombre completo",
e.puesto,
d.nombre_depto as "nombre departamento",
d.localidad
from empleado e
inner join departamento d on d.depto_nro = e.depto_nro
where e.puesto = "vendedor";

-- Visualizar los departamentos con más de cinco empleados.
select 
d.nombre_depto as "nombre departamento",
COUNT(*) as nro_empleado
from departamento d
inner join empleado e on d.depto_nro = e.depto_nro
GROUP by d.depto_nro
having nro_empleado > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

select
concat(e.nombre, " ", e.apellido) as "Nombre completo",
e.salario,
d.nombre_depto as "nombre departamento"
from empleado e
inner join departamento d on d.depto_nro = e.depto_nro 
WHERE e.puesto = "presidente";


-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

select 
e.cod_emp,
concat(e.nombre, " ", e.apellido) as "Nombre completo",
e.puesto,
e.fecha_alta,
e.salario,
e.comision,
e.depto_nro 
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = "Contabilidad"
order by `Nombre completo`;

-- Mostrar el nombre del empleado que tiene el salario más bajo.

select *
from empleado e 
where e.salario = (select min(salario) from empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

select *
from empleado e 
where e.salario = (select max(salario) from empleado);

