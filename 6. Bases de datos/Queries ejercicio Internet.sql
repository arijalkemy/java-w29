
-- 1. Recuperar todos los clientes de la provincia de Buenos Aires:
SELECT * FROM Cliente WHERE provincia = 'Buenos Aires';

-- 2. Listar todos los planes de Internet con un descuento mayor al 20%:
SELECT * FROM InternetPlan WHERE descuento > 20;

-- 3. Encontrar el precio promedio de todos los planes de Internet:
SELECT AVG(precio) AS precio_promedio FROM InternetPlan;

-- 4. Contar el número de clientes en la provincia de Buenos Aires:
SELECT COUNT(*) AS cantidad_clientes FROM Cliente WHERE provincia = 'Buenos Aires';

-- 5. Recuperar clientes que nacieron después de 1990:
SELECT * FROM Cliente WHERE fecha_nacimiento > '1990-01-01';

-- 6. Listar todos los clientes ordenados por su apellido en orden ascendente:
SELECT * FROM Cliente ORDER BY apellido ASC;

-- 7. Encontrar el número total de clientes:
SELECT COUNT(*) AS total_clientes FROM Cliente;

-- 8. Recuperar todos los clientes cuyo nombre empieza con 'A':
SELECT * FROM Cliente WHERE nombre LIKE 'A%';

-- 9. Listar todos los planes de Internet ordenados por velocidad en orden descendente:
SELECT * FROM InternetPlan ORDER BY velocidad DESC;

-- 10. Encontrar el plan de Internet con el mayor precio:
SELECT * FROM InternetPlan ORDER BY precio DESC LIMIT 1;