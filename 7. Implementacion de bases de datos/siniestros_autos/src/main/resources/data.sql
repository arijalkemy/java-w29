-- Insert vehicles
INSERT INTO vehicle (id, patent, brand, model, fabrication_year, number_of_tires)
VALUES
     (1, 'ABC123', 'Toyota', 'Corolla', 2020, 4),
     (2, 'XYZ789', 'Ford', 'Ranger', 2022, 4),
     (3, 'JKL456', 'Mercedes', 'Actros', 2025, 6);

-- Insert accidents
INSERT INTO accident (id, date, economic_loss, vehicle_id) VALUES
    (1, '2024-02-01', 5000, 1),
    (2, '2024-01-15', 12000, 2),
    (3, '2024-06-15', 10000, 2),
    (4, '2025-02-10', 25000, 3),
    (5, '2025-01-01', 25000, 3);
