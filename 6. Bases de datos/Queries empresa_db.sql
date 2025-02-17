-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre,puesto,d.localidad FROM empleados e
INNER JOIN departamentos d
ON e.depto_nro=d.depto_nro
WHERE e.puesto ='Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT * FROM departamentos 
WHERE depto_nro 
IN (SELECT depto_nro FROM empleados GROUP BY depto_nro HAVING COUNT(*) > 5);

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto 
-- que ‘Mito Barchuk’.
SELECT nombre,salario,d.nombre_depto FROM empleados e
INNER JOIN departamentos d
ON e.depto_nro=d.depto_nro
WHERE puesto IN (SELECT puesto FROM empleados WHERE nombre='Mito'AND apellido='Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleados e
INNER JOIN departamentos d
ON e.depto_nro=d.depto_nro
WHERE d.nombre_depto='Contabilidad' ORDER BY e.nombre;


-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre,apellido FROM empleados ORDER BY salario ASC LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
SELECT * FROM empleados e
INNER JOIN departamentos d
ON e.depto_nro=d.depto_nro
WHERE d.nombre_depto='Ventas' 
ORDER BY e.salario DESC LIMIT 1;