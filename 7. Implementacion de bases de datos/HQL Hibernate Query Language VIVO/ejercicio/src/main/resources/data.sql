INSERT INTO vehiculos (patente, marca, modelo, anio_fabricacion, cantidad_ruedas)
VALUES
    ('ABC123', 'Toyota', 'Corolla', 2015, 4),
    ('XYZ789', 'Honda', 'Civic', 2018, 4),
    ('LMN456', 'Ford', 'F-150', 2025, 4),
    ('JKL321', 'Harley-Davidson', 'Sportster', 2025, 6);

INSERT INTO siniestros (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES
    ('2023-01-15', 15000.00, 1),
    ('2023-02-20', 25000.00, 2),
    ('2023-03-25', 30000.00, 1),
    ('2023-04-30', 5000.00, 3),
    ('2023-05-05', 75000.00, 4);