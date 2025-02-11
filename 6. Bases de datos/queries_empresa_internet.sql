USE empresa_internet;
# 10 CONSULTAS A LA BASE DE DATOS

SELECT * FROM planes_internet;

SELECT *
FROM planes_internet
WHERE descuento > 10;

SELECT nombre, apellido, dni
FROM clientes
WHERE provincia = 'Buenos Aires';

SELECT *
FROM planes_internet
WHERE precio > 70.00;

SELECT nombre, apellido, dni
FROM clientes
WHERE fecha_nacimiento > '1990-01-01';

SELECT nombre, apellido, dni
FROM clientes
WHERE dni = '12345678A';

SELECT *
FROM planes_internet
WHERE precio <= 60.00;

SELECT nombre, apellido, dni
FROM clientes
WHERE nombre LIKE 'J%';

SELECT *
FROM planes_internet
WHERE descuento > 0;

SELECT nombre, apellido
FROM clientes
WHERE apellido = 'Pérez';










