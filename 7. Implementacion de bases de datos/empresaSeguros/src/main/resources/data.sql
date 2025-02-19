INSERT INTO vehiculo (patente, marca, anio_fabricacion, cantidad_ruedas)
VALUES ('DEF456', 'Honda', 2018, 4),
       ('GHI789', 'Ford', 2020, 4),
       ('JKL012', 'Chevrolet', 2017, 4),
       ('MNO345', 'BMW', 2019, 4);

INSERT INTO siniestro (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2025-01-10', 10000.00, 1),
-- Siniestro para el vehículo con id 1 (ABC123)
('2025-01-15', 5000.00, 2),
-- Siniestro para el vehículo con id 2 (XYZ789)
('2025-02-01', 20000.00, 3),
-- Siniestro para el vehículo con id 3 (LMN456)
('2025-02-10', 1500.00, 4);