-- Creación de la tabla Vehículo
CREATE TABLE Vehiculo (
                          id_vehiculo INT PRIMARY KEY,        -- Id del vehículo (clave primaria)
                          patente VARCHAR(20) NOT NULL,       -- Patente del vehículo
                          marca VARCHAR(50),                  -- Marca del vehículo
                          modelo VARCHAR(50),                 -- Modelo del vehículo
                          ano_fabricacion INT,                -- Año de fabricación
                          cantidad_ruedas INT                -- Cantidad de ruedas
);

-- Creación de la tabla Siniestro
CREATE TABLE Siniestro (
                           id_siniestro INT PRIMARY KEY,       -- Id del siniestro (clave primaria)
                           fecha_siniestro DATE,               -- Fecha del siniestro
                           perdida_economica DECIMAL(10, 2),   -- Pérdida económica en el siniestro
                           id_vehiculo INT,                    -- Id del vehículo denunciado (clave foránea)
                           FOREIGN KEY (id_vehiculo) REFERENCES Vehiculo(id_vehiculo)  -- Relación con la tabla Vehiculo
);




-- Insertar 10 vehículos
INSERT INTO Vehiculo (id_vehiculo, patente, marca, modelo, ano_fabricacion, cantidad_ruedas) VALUES
                                                                                                 (1, 'ABC123', 'Toyota', 'Corolla', 2019, 4),
                                                                                                 (2, 'DEF456', 'Ford', 'Fiesta', 2020, 4),
                                                                                                 (3, 'GHI789', 'Chevrolet', 'Sonic', 2018, 4),
                                                                                                 (4, 'JKL012', 'Honda', 'Civic', 2017, 4),
                                                                                                 (5, 'MNO345', 'Nissan', 'Altima', 2021, 4),
                                                                                                 (6, 'PQR678', 'BMW', 'X5', 2022, 4),
                                                                                                 (7, 'STU901', 'Audi', 'A4', 2016, 4),
                                                                                                 (8, 'VWX234', 'Hyundai', 'Elantra', 2020, 4),
                                                                                                 (9, 'YZA567', 'Mazda', 'CX-5', 2019, 4),
                                                                                                 (10, 'BCD890', 'Mercedes-Benz', 'GLC', 2021, 4);


-- Insertar 10 siniestros
INSERT INTO Siniestro (id_siniestro, fecha_siniestro, perdida_economica, id_vehiculo) VALUES
                                                                                          (1, '2024-01-15', 5000.00, 1),
                                                                                          (2, '2024-02-03', 3000.00, 2),
                                                                                          (3, '2024-03-10', 4000.00, 3),
                                                                                          (4, '2024-04-05', 1500.00, 4),
                                                                                          (5, '2024-05-20', 6000.00, 5),
                                                                                          (6, '2024-06-17', 7000.00, 6),
                                                                                          (7, '2024-07-25', 2000.00, 7),
                                                                                          (8, '2024-08-12', 4500.00, 8),
                                                                                          (9, '2024-09-30', 3500.00, 9),
                                                                                          (10, '2024-10-01', 8000.00, 10);
