use empresa;

select * from departamento;
select * from empleados;
/*Seleccionar el nombre, el puesto y la localidad de los departamentos
 donde trabajan los vendedores.*/
 select e.nombre,e.apellido, e.puesto, d.*
 from empleados e
 inner join departamento d on d.depto_nro = e.depto_nro;
 
/*Visualizar los departamentos con más de cinco empleados.*/
select d.*,count(e.cod_emp) as cantidad_empleados
from departamento d
inner join empleados e on e.depto_nro = d.depto_nro
group by d.depto_nro
having count(e.cod_emp) > 2;

/*Mostrar los datos de los empleados que trabajan en
 el departamento de contabilidad, ordenados por nombre.*/
 select e.* from empleados e
 inner join departamento d on d.depto_nro = e.depto_nro
 where d.nombre_depto = "Contabilidad";
/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
select e.nombre, e.apellido, e.salario 
from empleados e 
where e.salario = (select min(salario) from empleados);
/*Mostrar los datos del empleado que tiene el salario más
 alto en el departamento de ‘Ventas’.*/
select e.* from empleados e
 inner join departamento d on d.depto_nro = e.depto_nro
 where d.nombre_depto = "Ventas" and
 e.salario = (select max(salario) from empleados where depto_nro = d.depto_nro);
