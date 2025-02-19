-- Insert statements for Vehiculo
INSERT INTO Vehiculo (id, license_plate, brand, model, year_of_manufacture, number_of_wheels) VALUES
(1, 'ABC123', 'Toyota', 'Corolla', 2015, 4),
(2, 'XYZ789', 'Honda', 'Civic', 2018, 4);

-- Insert statements for Siniestro
INSERT INTO Siniestro (id, date_of_incident, economic_loss, vehiculo_id) VALUES
(1, '2023-01-15', 5000.00, 1),
(2, '2023-02-20', 3000.00, 2);