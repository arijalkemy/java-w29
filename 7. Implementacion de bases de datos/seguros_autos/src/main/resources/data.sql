-- Insertar Vehículos
INSERT INTO vehiculos (id, patente, marca, modelo, anio_fabricacion, cantidad_ruedas)
VALUES
    (1, 'ABC123', 'Toyota', 'Corolla', 2020, 4),
    (2, 'XYZ789', 'Honda', 'Civic', 2019, 4),
    (3, 'DEF456', 'Ford', 'Ranger', 2021, 4),
    (4, 'GHI789', 'Volkswagen', 'Golf', 2018, 4),
    (5, 'JKL012', 'Chevrolet', 'S10', 2022, 4);

-- Insertar Siniestros
INSERT INTO siniestros (id, fecha, perdida_economica, vehiculo_id)
VALUES
-- Siniestros para el vehículo 1
(1, '2023-01-15', 5000.00, 1),
(2, '2023-03-20', 3500.50, 1),
(3, '2023-06-10', 2800.75, 1),

-- Siniestros para el vehículo 2
(4, '2023-02-28', 4200.00, 2),
(5, '2023-05-15', 1500.25, 2),

-- Siniestros para el vehículo 3
(6, '2023-04-05', 6500.00, 3),
(7, '2023-07-22', 3200.50, 3),

-- Siniestros para el vehículo 4
(8, '2023-08-30', 4800.75, 4),

-- Siniestros para el vehículo 5
(9, '2023-09-12', 2900.00, 5),
(10, '2023-10-05', 1800.25, 5);