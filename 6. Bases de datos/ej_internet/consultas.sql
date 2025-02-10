USE internet_db;

-- 1. Obtener todos los clientes con sus nombres y apellidos.
SELECT nombre, apellido FROM clientes;

-- 2. Obtener todos los planes y su precio base, ordenados por velocidad de menor a mayor.
SELECT id_plan, velocidad, precio_base
FROM planes
ORDER BY velocidad ASC;

-- 3. Obtener todos los contratos activos (fecha de inicio menor a la fecha actual).
SELECT c.id_contrato, cli.nombre, cli.apellido, p.velocidad, c.fecha_inicio, c.fecha_fin, c.precio_total
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
    JOIN planes p ON c.id_plan = p.id_plan
WHERE c.fecha_inicio <= CURDATE() AND (c.fecha_fin IS NULL OR c.fecha_fin >= CURDATE());

-- 4. Ver los planes contratados por un cliente específico.
SELECT cli.nombre, cli.apellido, p.velocidad, c.precio_total, c.descuento, c.fecha_inicio, c.fecha_fin
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
    JOIN planes p ON c.id_plan = p.id_plan
WHERE cli.id_cliente = 1;

-- 5. Ver los clientes que tienen contratos con un descuento mayor al 15% (ordenado por descuento de mayor a menor).
SELECT cli.nombre, cli.apellido, c.descuento
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
WHERE c.descuento > 15
ORDER BY descuento DESC;

-- 6. Obtener el total de clientes que han contratado un plan específico.
SELECT COUNT(*) AS total_clientes
FROM contratos
WHERE id_plan = 3;

-- 7. Ver el precio total de los planes para un cliente específico.
SELECT cli.nombre, cli.apellido, p.velocidad, c.precio_total
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
    JOIN planes p ON c.id_plan = p.id_plan
WHERE cli.id_cliente = 2;

-- 8. Obtener la fecha de inicio y fin de todos los contratos con el plan de velocidad 100.
SELECT c.id_contrato, cli.nombre, cli.apellido, c.fecha_inicio, c.fecha_fin
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
    JOIN planes p ON c.id_plan = p.id_plan
WHERE p.velocidad = 100;

-- 9. Obtener el top 3 planes con mayor velocidad.
SELECT id_plan, velocidad, precio_base
FROM planes
ORDER BY velocidad DESC LIMIT 3;

-- 10. Obtener el nombre y apellido de los clientes que tienen un contrato activo para el plan de velocidad 50.
SELECT cli.nombre, cli.apellido
FROM contratos c
    JOIN clientes cli ON c.id_cliente = cli.id_cliente
    JOIN planes p ON c.id_plan = p.id_plan
WHERE p.velocidad = 50 AND c.fecha_inicio <= CURDATE() AND (c.fecha_fin IS NULL OR c.fecha_fin >= CURDATE());
