-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';
-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, COUNT(e.cod_emp) AS cantidad_empleados
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro, d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM EMPLEADO
ORDER BY salario ASC
LIMIT 1;
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;