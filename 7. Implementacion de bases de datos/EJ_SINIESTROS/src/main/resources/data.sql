-- No uses comandos para crear base de datos o usarla
DROP TABLE IF EXISTS siniestros;
DROP TABLE IF EXISTS vehiculos;

CREATE TABLE vehiculos
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    patente         VARCHAR(50) NOT NULL,
    marca           VARCHAR(50) NOT NULL,
    modelo          VARCHAR(50) NOT NULL,
    anio            INT         NOT NULL,
    cantidad_ruedas INT         NOT NULL
);

DROP TABLE IF EXISTS siniestros;
CREATE TABLE siniestros
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    fecha             INT     NOT NULL,
    perdida_economica DECIMAL NOT NULL,
    id_vehiculo       INT,
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculos (id)
);

-- Insertar registros en la tabla vehiculos
INSERT INTO vehiculos (patente, marca, modelo, anio, cantidad_ruedas)
VALUES ('ABC123', 'Ford', 'Fiesta', 2010, 4),
       ('DEF456', 'Chevrolet', 'Corsa', 2025, 4),
       ('GHI789', 'Fiat', 'Uno', 2025, 4),
       ('JKL012', 'Renault', 'Clio', 2018, 4),
       ('MNO345', 'Peugeot', '208', 2019, 4),
       ('PQR678', 'Volkswagen', 'Gol', 2017, 4),
       ('STU901', 'Toyota', 'Corolla', 2016, 4),
       ('VWX234', 'Nissan', 'March', 2014, 4),
       ('YZA567', 'Citroen', 'C3', 2024, 4),
       ('BCD890', 'Honda', 'Civic', 2011, 4);

-- Insertar registros en la tabla siniestros
INSERT INTO siniestros (fecha, perdida_economica, id_vehiculo)
VALUES (2018, 100000, 1),
       (2020, 200000, 2),
       (2023, 300000, 3),
       (2024, 400000, 4),
       (2025, 500000, 5);