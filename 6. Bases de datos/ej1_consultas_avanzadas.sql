-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
	E.nombre,
    E.puesto,
    D.localidad
FROM Empleados E
JOIN Departamentos D ON E.depto_nro = D.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT 
	D.depto_nro,
    D.nombre_depto,
    D.localidad,
    COUNT(*) AS cantidad_empleados
FROM Departamentos D
JOIN Empleados E ON E.depto_nro = D.depto_nro
GROUP BY D.depto_nro
HAVING cantidad_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
	E.nombre,
    E.salario,
    D.nombre_depto
FROM Empleados E
JOIN Departamentos D ON E.depto_nro = D.depto_nro
WHERE E.puesto = (SELECT puesto from Empleados WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT
	E.*
FROM Empleados E
JOIN Departamentos D ON E.depto_nro = D.depto_nro
WHERE D.nombre_depto = 'Contabilidad'
ORDER BY E.nombre ASC;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT
	E.nombre
FROM Empleados E
WHERE E.Salario = (SELECT MIN(salario) FROM Empleados);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT
	E.*
FROM Empleados E
WHERE E.Salario = (
	SELECT MAX(E1.salario) 
    FROM Empleados E1
    JOIN Departamentos D1 ON E1.depto_nro = D1.depto_nro
    WHERE D1.nombre_depto = 'Ventas'
);