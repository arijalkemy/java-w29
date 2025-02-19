INSERT INTO Departamento  (depto_nro, nombre_depto, localidad) VALUES
('D-0001', 'Software', 'Los Tigres'),
('D-0002', 'Sistemas', 'Guadaloupe'),
('D-0003', 'Contabilidad', 'La Roca'),
('D-0004', 'Ventas', 'Plata');

INSERT INTO Empleado  (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-0004'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-0002'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-0003'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-0004'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-0004'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-0003'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-0001');

SELECT e.nombre, e.puesto, d.localidad
FROM Empleado e JOIN Departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto = 'Vendedor';

SELECT d.nombre_depto
FROM Departamento d JOIN Empleado e ON d.depto_nro = e.depto_nro 
GROUP BY e.depto_nro
HAVING COUNT(e.cod_emp)>5;

SELECT e.nombre, e.salario, d.nombre_depto
FROM Empleado e JOIN Departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto IN (SELECT puesto from Empleado where Concat(nombre,apellido) like 'Mito%Barchuk');

SELECT * from Empleado e JOIN Departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre, e.apellido;

SELECT e.nombre, e.apellido 
FROM Empleado e 
ORDER BY e.salario ASC
LIMIT 1;

SELECT e.nombre, e.apellido 
FROM Empleado e JOIN Departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;