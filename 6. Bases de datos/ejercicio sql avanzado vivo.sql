create database empleado_departamento;
use empleado_departamento;

CREATE TABLE DEPARTAMENTO (
    depto_nro INT AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(255),
    localidad VARCHAR(255)
);

CREATE TABLE EMPLEADO (
    cod_emp INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    puesto VARCHAR(100),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro INT,
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

INSERT INTO DEPARTAMENTO (nombre_depto, localidad) VALUES 
('Recursos Humanos', 'Madrid'),
('Tecnología', 'Barcelona'),
('Finanzas', 'Valencia'),
('Marketing', 'Sevilla');

INSERT INTO EMPLEADO (nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
('Pablo', 'Diaz', 'Vendedor', '2021-01-15', 35000.00, 2500.00, 1),
('Laura', 'Gómez', 'Desarrollador', '2020-06-23', 45000.00, 3000.00, 2),
('Carlos', 'López', 'Contador', '2019-03-01', 40000.00, 2000.00, 3),
('Marta', 'Fernández', 'Gerente de Marketing', '2022-11-10', 55000.00, 5000.00, 4);

INSERT INTO EMPLEADO (nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
('Juan', 'Pérez', 'Analista', '2021-01-15', 35000.00, 2500.00, 1),
('Laura', 'Gómez', 'Desarrollador', '2020-06-23', 45000.00, 3000.00, 2),
('Carlos', 'López', 'Vendedor', '2019-03-01', 40000.00, 2000.00, 3),
('Marta', 'Fernández', 'Gerente de Marketing', '2022-11-10', 55000.00, 5000.00, 4),
('Ana', 'Martínez', 'Desarrollador', '2023-02-14', 46000.00, 2800.00, 2),
('Luis', 'Ramírez', 'Analista', '2022-08-30', 36000.00, 2600.00, 1),
('Sofía', 'Navarro', 'Contador', '2021-05-12', 41000.00, 2100.00, 3),
('David', 'Sánchez', 'Vendedor', '2021-09-07', 32000.00, 4000.00, 5),
('Isabel', 'Cruz', 'Gerente de Ventas', '2020-11-25', 60000.00, 6000.00, 5),
('Miguel', 'Torres', 'Operador', '2019-08-05', 28000.00, 1500.00, 6),
('Julia', 'Reyes', 'Operador', '2020-03-20', 28500.00, 1600.00, 6);

INSERT INTO EMPLEADO (nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
('Jorge', 'Moreno', 'Analista', '2021-12-05', 35500.00, 2550.00, 1),
('Elena', 'Vega', 'Desarrollador', '2023-03-10', 47000.00, 2900.00, 2),
('Alberto', 'Ruiz', 'Analista', '2022-07-15', 34500.00, 2450.00, 1),
('Cristina', 'Suárez', 'Contador', '2020-02-18', 42000.00, 2200.00, 3),
('Patricia', 'Ramos', 'Gerente de Marketing', '2019-05-30', 56000.00, 5100.00, 4),
('Pablo', 'Díaz', 'Desarrollador', '2021-10-16', 45000.00, 3100.00, 2),
('Carmen', 'García', 'Vendedor', '2020-06-19', 34000.00, 4200.00, 5),
('Raúl', 'Hernández', 'Gerente de Ventas', '2023-01-11', 61000.00, 6100.00, 5),
('Teresa', 'Blanco', 'Operador', '2022-04-25', 29000.00, 1700.00, 6),
('Francisco', 'Méndez', 'Operador', '2021-09-14', 27500.00, 1600.00, 6),
('Sara', 'Castro', 'Analista', '2020-11-22', 36000.00, 2700.00, 1),
('Iván', 'Ortiz', 'Desarrollador', '2019-12-01', 44000.00, 3000.00, 2),
('Gabriela', 'Ponce', 'Contador', '2021-03-03', 41500.00, 2150.00, 3),
('Mario', 'Rojas', 'Vendedor', '2021-08-07', 33000.00, 3900.00, 5),
('Lucía', 'Silva', 'Gerente de Marketing', '2022-10-06', 57000.00, 5200.00, 4);

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select empleado.nombre, empleado.puesto, departamento.localidad
from departamento inner join empleado on empleado.depto_nro = departamento.depto_nro
where puesto="vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.
select count(*) cantidad, departamento.nombre_depto
from departamento join empleado on empleado.depto_nro = departamento.depto_nro
group by departamento.nombre_depto
having cantidad>=5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que Jorge Moreno
select empleado.nombre, empleado.apellido, empleado.salario, departamento.nombre_depto
from departamento join empleado on empleado.depto_nro = departamento.depto_nro
where empleado.puesto IN (select puesto from empleado where nombre="jorge" and apellido="moreno");

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de finanzas, ordenados por nombre.
select empleado.nombre, empleado.apellido, departamento.nombre_depto
from departamento join empleado on empleado.depto_nro = departamento.depto_nro
where departamento.nombre_depto="finanzas"
order by empleado.nombre;

SELECT CONCAT(empleado.nombre, ' ', empleado.apellido) AS nombre_completo, departamento.nombre_depto
FROM departamento JOIN empleado ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Finanzas'
ORDER BY nombre_completo;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
select CONCAT(empleado.nombre, ' ', empleado.apellido) AS nombre_completo, salario
from empleado
order by salario
limit 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘marketing’.
select CONCAT(empleado.nombre, ' ', empleado.apellido) AS nombre_completo, empleado.salario, departamento.nombre_depto
FROM departamento JOIN empleado ON empleado.depto_nro = departamento.depto_nro
where departamento.nombre_depto="marketing"
order by salario desc
limit 1;