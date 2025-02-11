-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.puesto, d.localidad
FROM empleados e
    JOIN departamentos d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, d.localidad
FROM departamentos d
WHERE d.depto_nro IN (SELECT depto_nro FROM empleados GROUP BY depto_nro HAVING COUNT(*) > 5);

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados e
    JOIN departamentos d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleados WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM empleados e
    JOIN departamentos d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleados
ORDER BY salario ASC LIMIT 1;

SELECT nombre
FROM empleados
WHERE salario = (SELECT MIN(e.salario) FROM empleados e);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleados e
    JOIN departamentos d ON e.depto_nro = d.depto_nro
WHERE e.salario = (
    SELECT MAX(e1.salario)
    FROM empleados e1
        JOIN departamentos d1 ON d1.depto_nro = e1.depto_nro
    WHERE d1.nombre_depto = 'Ventas'
);

SELECT *
FROM empleados e
    JOIN departamentos d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY salario DESC LIMIT 1;