drop database if exists empresa_db;
create database empresa_db;
use empresa_db;

drop table if exists departamentos;
create table departamentos(
`depto_nro` varchar(20) NOT NULL primary key,
`nombre_depto` varchar(50) NOT NULL,
`localidad` varchar(50)
);

drop table if exists empleados;
create table empleados(
`cod_emp` varchar(20) NOT NULL primary key,
`nombre` varchar(50) NOT NULL,
`apellido` varchar(50) NOT NULL,
`puesto` varchar(50),
`fecha_alta` date,
`salario` float,
`comision` int,
`depto_nro` varchar(20),
constraint `foreign_depto_nro` foreign key (`depto_nro`) references departamentos (`depto_nro`)
);



INSERT INTO departamentos (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'),
('E-0008', 'Dani', 'Brezezi', 'Vendedor', '2015-11-03', 83000, 10000, 'D-000-4'),
('E-0009', 'Daniela', 'Brezicki', 'Vendedor', '2010-03-20', 83000, 10000, 'D-000-4'),
('E-00010', 'Damián', 'Zicki', 'Vendedor', '2017-07-07', 83000, 10000, 'D-000-4'),
('E-00011', 'Césarito', 'Piñera', 'Presidente', '2018-05-12', 80000, 15000, 'D-000-3');

/*
Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
Visualizar los departamentos con más de cinco empleados.
Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
Mostrar el nombre del empleado que tiene el salario más bajo.
Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
*/

/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores*/
select em.nombre, em.puesto, de.localidad
from empleados em
inner join departamentos de
on em.depto_nro=de.depto_nro;


/*Agregué más vendedores para que traiga datos*/
select count(*), de.*
from departamentos de
inner join empleados em
on em.depto_nro=de.depto_nro
group by de.depto_nro
having count(*) > 5;


/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’*/
/*Agregué otro presidente para probar*/
select em.nombre, em.salario, de.nombre_depto
from empleados em
inner join departamentos de
on em.depto_nro=de.depto_nro
where em.puesto = (select puesto from empleados where nombre = 'Mito' and apellido = 'Barchuk');

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre*/
select em.*
from empleados em
inner join departamentos de
on em.depto_nro=de.depto_nro
where de.nombre_depto = 'Contabilidad'
order by em.nombre;


/*Mostrar el nombre del empleado que tiene el salario más bajo*/
select nombre
from empleados
order by salario
limit 1;

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’*/

select em.*
from empleados em
inner join departamentos de
on em.depto_nro=de.depto_nro
where de.nombre_depto = 'Ventas'
order by em.salario desc
limit 1

