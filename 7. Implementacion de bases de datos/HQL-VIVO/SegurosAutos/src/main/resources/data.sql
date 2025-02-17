
INSERT INTO vehiculo (id_vehiculo, patente, marca, modelo, anio_fabricacion, cantidad_ruedas)
VALUES
    -- Vehículos estándar (4 ruedas)
    (1, 'AA1234', 'Toyota', 'Corolla', 2022, 4),
    (2, 'BB5678', 'Honda', 'Civic', 2021, 4),
    (3, 'CC9012', 'Ford', 'Focus', 2023, 4),
    (4, 'DD3456', 'Chevrolet', 'Cruze', 2020, 4),
    (5, 'EE7890', 'Nissan', 'Sentra', 2019, 4),
    (6, 'FF1234', 'Hyundai', 'Elantra', 2022, 4),
    (7, 'GG5678', 'Kia', 'Forte', 2021, 4),
    (8, 'HH9012', 'Mazda', 'Mazda3', 2023, 4),
    (9, 'JJ3456', 'Subaru', 'Impreza', 2020, 4),
    (10, 'KK7890', 'Volkswagen', 'Jetta', 2019, 4),

    -- Vehículos nuevos del año 2024
    (11, 'LL1234', 'Tesla', 'Model 3', 2024, 4),
    (12, 'MM5678', 'BMW', 'Serie 3', 2024, 4),
    (13, 'NN9012', 'Audi', 'A4', 2024, 4),
    (14, 'OO3456', 'Mercedes', 'Clase C', 2024, 4),
    (15, 'PP7890', 'Porsche', 'Taycan', 2024, 4),

    -- Vehículos con más ruedas (camiones y buses)
    (16, 'QQ1234', 'Volvo', 'FH16', 2023, 18),  -- Camión de carga
    (17, 'RR5678', 'Scania', 'R500', 2022, 18), -- Camión de larga distancia
    (18, 'SS9012', 'Mercedes', 'Sprinter', 2023, 6), -- Minibus
    (19, 'TT3456', 'Blue Bird', 'Vision', 2022, 6), -- Autobús escolar
    (20, 'UU7890', 'MAN', 'Lions Coach', 2021, 8), -- Autobús de larga distancia

    -- Vehículos con menos ruedas (motos y triciclos)
    (21, 'VV1234', 'Yamaha', 'R1', 2024, 2), -- Motocicleta deportiva
    (22, 'WW5678', 'Ducati', 'Panigale V4', 2023, 2), -- Motocicleta de alto rendimiento
    (23, 'XX9012', 'Harley-Davidson', 'Sportster', 2022, 2), -- Motocicleta clásica
    (24, 'YY3456', 'Piaggio', 'MP3', 2023, 3), -- Triciclo motorizado
    (25, 'ZZ7890', 'Can-Am', 'Spyder', 2024, 3); -- Triciclo deportivo


INSERT INTO siniestro (id_siniestro, fecha_siniestro, perdida_economica, id_vehiculo)
VALUES
    -- Siniestros existentes
    (1, '2023-05-01', 1500.00, 3),
    (2, '2023-06-15', 5000.00, 1),
    (3, '2023-07-22', 10000.00, 5),
    (4, '2023-08-10', 2500.00, 8),
    (5, '2023-09-03', 7500.00, 2),
    (6, '2023-10-18', 12000.00, 6),
    (7, '2023-11-05', 3000.00, 9),
    (8, '2023-12-12', 9000.00, 4),
    (9, '2024-01-20', 500.00, 7),
    (10, '2024-02-08', 6000.00, 10),

    -- Siniestros nuevos en 2024
    (11, '2024-03-10', 2500.00, 11),  -- Tesla Model 3
    (12, '2024-04-15', 8000.00, 12),  -- BMW Serie 3
    (13, '2024-05-20', 15000.00, 13), -- Audi A4
    (14, '2024-06-05', 500.00, 14),   -- Mercedes Clase C (daño menor)
    (15, '2024-07-12', 22000.00, 15), -- Porsche Taycan (accidente grave)

    -- Siniestros en camiones y buses (daños más costosos)
    (16, '2024-08-25', 30000.00, 16), -- Volvo FH16 (choque con otro camión)
    (17, '2024-09-18', 18000.00, 17), -- Scania R500 (falla mecánica en carretera)
    (18, '2024-10-05', 5000.00, 18),  -- Mercedes Sprinter (accidente leve)
    (19, '2024-11-22', 12000.00, 19), -- Blue Bird Vision (colisión en ciudad)
    (20, '2024-12-01', 25000.00, 20), -- MAN Lions Coach (daño estructural)

    -- Siniestros en motos y triciclos (costos más variables)
    (21, '2025-01-10', 700.00, 21),   -- Yamaha R1 (raspones y caída leve)
    (22, '2025-01-25', 2500.00, 22),  -- Ducati Panigale V4 (golpe lateral)
    (23, '2025-02-10', 1200.00, 23),  -- Harley-Davidson Sportster (choque con auto)
    (24, '2025-02-15', 500.00, 24),   -- Piaggio MP3 (accidente menor)
    (25, '2025-02-17', 6000.00, 25);  -- Can-Am Spyder (choque con poste)







