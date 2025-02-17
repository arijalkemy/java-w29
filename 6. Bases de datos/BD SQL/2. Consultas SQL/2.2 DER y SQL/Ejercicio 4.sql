-- 1. Listar todos los clientes ordenados alfabéticamente por apellido
SELECT * FROM clientes
ORDER BY apellido ASC;

-- 2. Mostrar los planes de internet con velocidad mayor a 200MB
SELECT * FROM planes_internet
WHERE velocidad > 200;

-- 3. Contar cuántos clientes hay por provincia
SELECT provincia, COUNT(*) as cantidad_clientes
FROM clientes
GROUP BY provincia;

-- 4. Obtener el precio promedio de los planes de internet
SELECT AVG(precio) as precio_promedio
FROM planes_internet;

-- 5. Mostrar los clientes que tienen planes con descuento mayor al 15%
SELECT c.nombre, c.apellido, p.velocidad, p.descuento
FROM clientes c
         JOIN planes_internet p ON c.plan_internet_id = p.id
WHERE p.descuento > 15;

-- 6. Encontrar el plan más caro y cuántos clientes lo tienen
SELECT p.velocidad, p.precio, COUNT(c.id) as cantidad_clientes
FROM planes_internet p
         LEFT JOIN clientes c ON p.id = c.plan_internet_id
WHERE p.precio = (SELECT MAX(precio) FROM planes_internet)
GROUP BY p.id, p.velocidad, p.precio;

-- 7. Mostrar la cantidad de clientes por cada plan de internet
SELECT p.velocidad as "Velocidad MB", p.precio, COUNT(c.id) as cantidad_clientes
FROM planes_internet p
         LEFT JOIN clientes c ON p.id = c.plan_internet_id
GROUP BY p.id, p.velocidad, p.precio
ORDER BY p.velocidad;

-- 8. Calcular el ingreso total por planes
SELECT SUM(p.precio) as ingreso_total
FROM clientes c
         JOIN planes_internet p ON c.plan_internet_id = p.id;

-- 9. Clientes que su nombre contenga 'an'
SELECT * FROM clientes WHERE nombre LIKE '%an%';

-- 10. Clientes que su ciudad empiece con 'la' y hayan nacido entre 1980 y el 2000.
SELECT * FROM clientes WHERE ciudad LIKE 'la%' AND YEAR(nacimiento) BETWEEN 1980 AND 2000;