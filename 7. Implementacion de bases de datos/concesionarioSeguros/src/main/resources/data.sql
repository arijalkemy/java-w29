-- Inserción de 5 vehículos

INSERT INTO vehiculos (patente, marca, modelo, año_de_fabricacion, numero_de_ruedas)
VALUES ('ABC123', 'Toyota', 'Corolla', 2010, 4);

INSERT INTO vehiculos (patente, marca, modelo, año_de_fabricacion, numero_de_ruedas)
VALUES ('DEF456', 'Honda', 'Civic', 2012, 4);

INSERT INTO vehiculos (patente, marca, modelo, año_de_fabricacion, numero_de_ruedas)
VALUES ('GHI789', 'Ford', 'Focus', 2015, 4);

INSERT INTO vehiculos (patente, marca, modelo, año_de_fabricacion, numero_de_ruedas)
VALUES ('JKL012', 'Chevrolet', 'Cruze', 2018, 4);

INSERT INTO vehiculos (patente, marca, modelo, año_de_fabricacion, numero_de_ruedas)
VALUES ('MNO345', 'Nissan', 'Sentra', 2020, 4);

-- Inserción de 15 siniestros. Se asume que el campo vehiculo_id en siniestro es la FK que referencia vehiculo.id_vehiculo

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-01-10', 1500.50, 1);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-02-15', 2300.00, 2);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-03-20', 1200.75, 3);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-04-05', 3000.00, 4);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-05-12', 750.25, 5);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-06-18', 1800.00, 1);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-07-22', 2200.40, 2);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-08-30', 1300.00, 3);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-09-10', 950.00, 4);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-10-15', 1600.90, 5);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-11-20', 2100.00, 1);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-12-25', 1100.00, 2);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2024-01-05', 1400.50, 3);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2024-02-14', 1250.75, 4);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2024-03-18', 1700.00, 5);
