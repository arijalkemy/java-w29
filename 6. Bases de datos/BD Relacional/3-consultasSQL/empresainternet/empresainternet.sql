CREATE DATABASE empresa_internet;

CREATE TABLE `empresa_internet`.`Pack` (
  `pack_id` INT NOT NULL AUTO_INCREMENT,
  `velocity` INT NULL,
  `megas` INT NULL,
  `price` DECIMAL(10,0) NULL,
  `discount` INT NULL,
  PRIMARY KEY (`pack_id`),
  UNIQUE INDEX `pack_id_UNIQUE` (`pack_id` ASC) VISIBLE);

CREATE TABLE `empresa_internet`.`Client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  `pack_id` INT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `fk_client_pack`
    FOREIGN KEY (`pack_id`)
    REFERENCES `empresa_internet`.`Pack` (`pack_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL
);

INSERT INTO `empresa_internet`.`Pack` (`velocity`, `megas`, `price`, `discount`) VALUES
(50, 100, 5000, 10),
(100, 200, 7500, 15),
(300, 500, 12000, 20),
(500, 1000, 18000, 25),
(1000, 2000, 25000, 30);

INSERT INTO `empresa_internet`.`Client` (`dni`, `first_name`, `last_name`, `state`, `city`, `birth_date`, `pack_id`) VALUES
('12345678', 'Juan', 'Pérez', 'Buenos Aires', 'CABA', '1990-05-10', 1),
('87654321', 'María', 'González', 'Córdoba', 'Córdoba Capital', '1985-08-25', 2),
('11223344', 'Carlos', 'López', 'Mendoza', 'Mendoza', '1992-11-30', 3),
('22334455', 'Ana', 'Martínez', 'Santa Fe', 'Rosario', '1995-04-15', 4),
('33445566', 'Jorge', 'Fernández', 'Salta', 'Salta', '1988-09-20', 5),
('44556677', 'Laura', 'Gutiérrez', 'Tucumán', 'San Miguel de Tucumán', '1991-07-05', 1),
('55667788', 'Ricardo', 'Díaz', 'Neuquén', 'Neuquén', '1983-12-12', 2),
('66778899', 'Sofía', 'Romero', 'Misiones', 'Posadas', '2000-06-22', 3),
('77889900', 'Martín', 'Sosa', 'Chubut', 'Comodoro Rivadavia', '1997-03-17', 4),
('88990011', 'Camila', 'Méndez', 'Jujuy', 'San Salvador de Jujuy', '1996-01-29', 5);

# 1 - traer los pack con descuentos mayores o iguales a 20
use empresa_internet;
SELECT * FROM Pack WHERE discount >= 20.0;
# 2 - traer el pack con mayor descuento
select max(discount) as 'mayor descuento'from Pack;
# 3 - traer el pack con menor descuento
select min(discount) as 'menor descuento' from Pack;
# 4 - contar la cantidad de clientes
SELECT COUNT(*) AS total_clientes FROM Client;
# 5 - cliente mas joven 
SELECT client_id, first_name, last_name, birth_date
FROM Client
ORDER BY birth_date DESC
LIMIT 1;
# 6 - ordenar los planes por precio
SELECT * FROM Pack
ORDER BY price DESC;
# 7 - velocidad promedio de los planes
SELECT AVG(velocity) AS velocidad_promedio FROM Pack;
# 8 - cuantos clientes hay por provincia
SELECT state, COUNT(*) AS total_clientes
FROM Client
GROUP BY state
ORDER BY total_clientes DESC;
# 9 - cliente sin plan
SELECT * FROM Client
WHERE pack_id IS NULL;
# 10 - pack con precio mas alto
SELECT MAX(price) FROM Pack;