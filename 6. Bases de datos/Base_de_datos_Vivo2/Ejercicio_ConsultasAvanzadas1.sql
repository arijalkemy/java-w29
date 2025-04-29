use empresa;
select * from departamento;
select * from empleados;


-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM EMPLEADOs AS e
INNER JOIN DEPARTAMENTO AS d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.cod_emp) AS total_empleados
FROM DEPARTAMENTO AS d
INNER JOIN EMPLEADOS AS e ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro, d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto, e.puesto
FROM EMPLEADOS AS e
INNER JOIN DEPARTAMENTO AS d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM EMPLEADOS WHERE nombre = 'Mito' AND apellido = 'Barchuk');
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM EMPLEADOS AS e
INNER JOIN DEPARTAMENTO AS d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.salario
FROM EMPLEADOS AS e
WHERE e.salario = (SELECT MIN(salario) FROM EMPLEADOS);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM EMPLEADOS AS e
WHERE e.depto_nro = (SELECT d.depto_nro
                      FROM DEPARTAMENTO AS d
                      WHERE d.nombre_depto = 'Ventas')
AND e.salario = (SELECT MAX(salario) 
                 FROM EMPLEADOS 
                 WHERE depto_nro = (SELECT d.depto_nro 
                                    FROM DEPARTAMENTO AS d 
                                    WHERE d.nombre_depto = 'Ventas'));
                                    
                                    
                                    
