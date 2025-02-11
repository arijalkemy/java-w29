#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, de.localidad FROM empleado e 
JOIN departamento de ON de.depto_nro = e.depto_nro;
#Visualizar los departamentos con más de cinco empleados.
SELECT * FROM empleado;
SELECT d.*
FROM departamento d 
JOIN empleado e
	ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro 
HAVING COUNT(d.depto_nro) > 5;
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, e.puesto, d.nombre_depto
FROM empleado e 
JOIN departamento d 
	ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
	SELECT puesto
	FROM empleado
	WHERE nombre LIKE 'Mito'
		AND apellido LIKE 'Barchuk'
);
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.depto_nro = 'D-000-3'
ORDER BY e.nombre ASC;
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre 
FROM empleado e 
ORDER BY e.salario ASC
LIMIT 1;
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* 
FROM empleado e 
WHERE depto_nro =  'D-000-4'
ORDER BY e.salario DESC
LIMIT 1;