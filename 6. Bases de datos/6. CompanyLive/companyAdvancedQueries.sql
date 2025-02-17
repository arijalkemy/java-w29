INSERT INTO department VALUES ("D-000-1", "Software", "Los Tigres");
INSERT INTO department VALUES ("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO department VALUES ("D-000-3", "Contabilidad", "La Roca");
INSERT INTO department VALUES ("D-000-4", "Ventas", "Plata");

INSERT INTO employee VALUES ("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", "80000", "15000", "D-000-4");
INSERT INTO employee VALUES ("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", "140000", "0", "D-000-2");
INSERT INTO employee VALUES ("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", "185000", "0", "D-000-3");
INSERT INTO employee VALUES ("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", "85000", "10000", "D-000-4");
INSERT INTO employee VALUES ("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", "83000", "10000", "D-000-4");
INSERT INTO employee VALUES ("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", "190000", "0", "D-000-3");
INSERT INTO employee VALUES ("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", "60000", "0", "D-000-1");

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT emp.name, emp.lastname, emp.position, dept.location
FROM employee AS emp
JOIN department AS dept ON emp.dept_nro = dept.dept_nro
HAVING emp.position = 'Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT dept.dept_name, COUNT(*) AS Empleados
FROM department AS dept
JOIN employee AS emp ON dept.dept_nro = emp.dept_nro
GROUP BY dept.dept_name
HAVING COUNT(*) > 1;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.name, emp.lastname, emp.salary, dept.dept_name
FROM employee AS emp
JOIN department AS dept ON dept.dept_nro = emp.dept_nro
WHERE emp.position = (SELECT position FROM employee WHERE employee.name = 'Mito' AND employee.lastname = 'Barchuk')
		AND emp.name <> 'Mito' AND emp.lastname <> 'Barchuk';

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * 
FROM employee AS emp
JOIN department AS dept ON dept.dept_nro = emp.dept_nro
WHERE dept.dept_name = 'Contabilidad'
ORDER BY emp.name ASC;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT emp.name
FROM employee AS emp
ORDER BY emp.salary ASC
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM employee AS emp
JOIN department AS dept ON emp.dept_nro = dept.dept_nro
WHERE dept.dept_name = 'Ventas'
ORDER BY emp.salary DESC
LIMIT 1;
