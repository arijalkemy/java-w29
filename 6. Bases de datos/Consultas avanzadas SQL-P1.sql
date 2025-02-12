
CREATE TABLE empresa_db.EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    comision DECIMAL(10, 2) DEFAULT 0,
    depto_nro VARCHAR(10) NOT NULL
);

INSERT INTO empresa_db.EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.00, 0.00, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000.00, 0.00, 'D-000-1');

CREATE TABLE empresa_db.DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

INSERT INTO empresa_db.DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT nombre, puesto, localidad 
FROM EMPLEADO as em
INNER JOIN DEPARTAMENTO as de ON de.depto_nro = em.depto_nro;

/*Visualizar los departamentos con más de cinco empleados.*/
SELECT nombre_depto
FROM DEPARTAMENTO as de
INNER JOIN EMPLEADO as em 
ON de.depto_nro = em.depto_nro
group by de.nombre_depto
HAVING count(em.cod_emp) > 5;

/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que 
‘Mito Barchuk’.*/
SELECT nombre, salario, nombre_depto 
FROM EMPLEADO as em
INNER JOIN DEPARTAMENTO as de
ON de.depto_nro = em.depto_nro
WHERE em.puesto IN (SELECT puesto FROM EMPLEADO WHERE nombre='Mito' AND apellido='Barchuk');

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT * FROM EMPLEADO as em
INNER JOIN DEPARTAMENTO as de
ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto LIKE '%contabilidad%'
ORDER BY em.nombre;

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre FROM EMPLEADO 
ORDER BY salario LIMIT 1;

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’*/
/**opción 1**/
SELECT *
FROM EMPLEADO as em
INNER JOIN DEPARTAMENTO as de
ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto LIKE '%Ventas%' 
AND em.salario = (SELECT MAX(salario) 
                  FROM EMPLEADO 
                  WHERE depto_nro = em.depto_nro
                  AND depto_nro = (SELECT depto_nro FROM DEPARTAMENTO WHERE nombre_depto LIKE '%Ventas%'));
				
/**opción 2**/
SELECT *
FROM EMPLEADO
WHERE depto_nro = (SELECT depto_nro
                   FROM DEPARTAMENTO
                   WHERE nombre_depto = 'Ventas')
ORDER BY salario DESC
LIMIT 1;

