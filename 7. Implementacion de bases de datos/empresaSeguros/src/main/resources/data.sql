INSERT INTO vehiculo (patente, marca, anio_fabricacion, cantidad_ruedas, modelo)
VALUES
    ('DEF456', 'Honda', 2018, 4, "Modelo 1"),
    ('GHI789', 'Ford', 2020, 4, "Modelo 2"),
    ('JKL012', 'Chevrolet', 2017, 4, "Modelo 3"),
    ('MNO345', 'BMW', 2019, 4, "Modelo 4");

INSERT INTO siniestro (fecha_siniestro, perdida_economica, id_vehiculo_denunciado)
VALUES ('2023-09-15', 15000.50, 1);

INSERT INTO siniestro (fecha_siniestro, perdida_economica, id_vehiculo_denunciado)
VALUES ('2023-09-16', 25000.00, 2);

INSERT INTO siniestro (fecha_siniestro, perdida_economica, id_vehiculo_denunciado)
VALUES ('2023-09-17', 3200.75, 3);