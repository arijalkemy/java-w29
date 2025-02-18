INSERT INTO vehicle (id, license_plate, brand, model, manufacturing_year, wheels)
VALUES (1, 'ABC123', 'Toyota', 'Corolla', 2015, 4),
       (2, 'XYZ789', 'Honda', 'Civic', 2018, 4),
       (3, 'DEF456', 'Ford', 'Focus', 2025, 8),
       (4, 'GHI012', 'Chevrolet', 'Malibu', 2025, 8),
       (5, 'JKL345', 'Nissan', 'Altima', 2025, 8),
       (6, 'MNO678', 'Hyundai', 'Elantra', 2020, 4),
       (7, 'PQR901', 'Kia', 'Optima', 2014, 4),
       (8, 'STU234', 'Volkswagen', 'Jetta', 2025, 8),
       (9, 'VWX567', 'Subaru', 'Impreza', 2021, 4),
       (10, 'YZA890', 'Mazda', '3', 2022, 4);

INSERT INTO accident (id, date, economic_loss, vehicle_id)
VALUES (1, '2023-01-15', 50000.00, 1),
       (2, '2023-02-20', 3000.00, 1),
       (3, '2023-03-10', 7000.00, 2),
       (4, '2023-04-05', 45000.00, 3),
       (5, '2023-05-12', 6000.00, 4),
       (6, '2023-06-18', 3500.00, 5),
       (7, '2023-07-22', 80000.00, 6),
       (8, '2023-08-30', 2000.00, 7),
       (9, '2023-09-14', 9000.00, 8),
       (10, '2023-10-25', 100000.00, 9),
       (11, '2023-10-25', 100000.00, 9),
       (12, '2023-10-25', 100000.00, 9);