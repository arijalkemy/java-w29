CREATE DATABASE IF NOT EXISTS internet_company;

USE internet_company;

CREATE TABLE IF NOT EXISTS Planes (
    id_plan INT NOT NULL PRIMARY KEY,
    identificador VARCHAR(50),
    velocidad_en_mb VARCHAR(50),
    precio DECIMAL(10,
2),
    descuento DECIMAL(10,
2)
);

CREATE TABLE IF NOT EXISTS Clientes (
    id_cliente INT NOT NULL PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_de_nacimiento DATE,
    provincia VARCHAR(100),
    ciudad VARCHAR(100),
    id_plan INT,
    CONSTRAINT fk_id_plan FOREIGN KEY (id_plan)
        REFERENCES Planes(id_plan)
);

/* Inserciones de registros */
-- planes

INSERT
	INTO
	Planes (id_plan,
	identificador,
	velocidad_en_mb,
	precio,
	descuento)
VALUES (1,
'Plan Básico',
'10',
19.99,
0.00);

INSERT
	INTO
	Planes (id_plan,
	identificador,
	velocidad_en_mb,
	precio,
	descuento)
VALUES (2,
'Plan Estándar',
'50',
39.99,
5.00);

INSERT
	INTO
	Planes (id_plan,
	identificador,
	velocidad_en_mb,
	precio,
	descuento)
VALUES (3,
'Plan Premium',
'100',
59.99,
10.00);

INSERT
	INTO
	Planes (id_plan,
	identificador,
	velocidad_en_mb,
	precio,
	descuento)
VALUES (4,
'Plan Ultra',
'200',
79.99,
15.00);

INSERT
	INTO
	Planes (id_plan,
	identificador,
	velocidad_en_mb,
	precio,
	descuento)
VALUES (5,
'Plan VIP',
'500',
99.99,
20.00);
-- Clientes

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (1,
'12345678A',
'John',
'Doe',
'1985-06-15',
'Buenos Aires',
'La Plata',
1);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (2,
'23456789B',
'Alice',
'Smith',
'1990-04-20',
'Córdoba',
'Córdoba',
2);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (3,
'34567890C',
'Bob',
'Johnson',
'1978-09-10',
'Santa Fe',
'Rosario',
3);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (4,
'45678901D',
'Carol',
'Williams',
'1988-12-05',
'Mendoza',
'Mendoza',
4);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (5,
'56789012E',
'David',
'Brown',
'1992-03-15',
'Buenos Aires',
'Mar del Plata',
5);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (6,
'67890123F',
'Emma',
'Jones',
'1980-11-30',
'Tucumán',
'San Miguel de Tucumán',
1);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (7,
'78901234G',
'Frank',
'Miller',
'1975-05-25',
'Salta',
'Salta',
2);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (8,
'89012345H',
'Grace',
'Davis',
'1995-08-12',
'Chubut',
'Comodoro Rivadavia',
3);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (9,
'90123456I',
'Henry',
'Wilson',
'1983-02-28',
'Entre Ríos',
'Paraná',
4);

INSERT
	INTO
	Clientes (id_cliente,
	dni,
	nombre,
	apellido,
	fecha_de_nacimiento,
	provincia,
	ciudad,
	id_plan)
VALUES (10,
'01234567J',
'Isabel',
'Taylor',
'1998-07-07',
'Neuquén',
'Neuquén',
5);

/* Consultas asociadas */
-- clientes de plan basico

select
	c.id_cliente,
	c.dni,
	c.nombre,
	c.apellido,
	p.identificador
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
where
	p.identificador = "Plan Básico";
-- clientes con plan VIP nacidos entre 1990 y 2000

select 
	c.id_cliente,
	concat(c.nombre, " ", c.apellido) as "nombre y apellido",
	c.fecha_de_nacimiento
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
where
	c.fecha_de_nacimiento between "1990-01-01" and "2000-12-31"
	and p.id_plan = 5;
-- dni, nombre del cliente y provincia

select
	c.dni,
	concat(c.nombre, " ", c.apellido) as "nombre y apellido",
	c.provincia
from
	Clientes c;
-- conteo de usuarios por plan

select
	p.identificador,
	count(c.id_cliente) as "clientes por plan"
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
GROUP BY
	p.id_plan;
-- promedio de clientes por plan

SELECT
	AVG(clientes_por_plan) AS promedio_de_clientes
FROM
	(
	SELECT
		COUNT(c.id_cliente) AS clientes_por_plan
	FROM
		Clientes c
	INNER JOIN Planes p ON
		p.id_plan = c.id_plan
	GROUP BY
		p.id_plan
) AS plan_counts;
-- clientes de plan premium, ultra y VIP

    SELECT
	p.identificador,
	COUNT(c.id_cliente) AS clientes_por_plan
FROM
	Clientes c
INNER JOIN Planes p ON
	p.id_plan = c.id_plan
where
	p.id_plan in (3, 4, 5)
GROUP BY
	p.id_plan;
-- total por plan de acuerdo a la cantidad de clientes
    
select
	p.identificador,
	count(c.id_cliente) as "cantidad de clientes",
	sum(p.precio) as "Ingresos por plan"
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
GROUP BY
	p.id_plan;
-- clienes nacidos entre 1995 y 1998 y tipo de plan


select 
	c.id_cliente,
	concat(c.nombre, " ", c.apellido) as "nombre y apellido",
	c.fecha_de_nacimiento
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
where
	c.fecha_de_nacimiento between "1995-01-01" and "1998-12-31"
	and p.id_plan = 5;
-- cantidad de clientes por provincia

SELECT
	c.provincia,
	COUNT(c.id_cliente) as "clientes provincia"
FROM
	Clientes c
GROUP BY
	c.provincia;
-- clientes con plan estandar

select
	c.id_cliente,
	c.dni,
	c.nombre,
	c.apellido,
	p.identificador
from
	Clientes c
inner join Planes p on
	p.id_plan = c.id_plan
where
	p.identificador = "Plan Estándar";
