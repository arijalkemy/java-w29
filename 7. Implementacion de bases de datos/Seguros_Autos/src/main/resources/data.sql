-- Insertar vehículos
INSERT INTO vehiculos (id_vehiculo, Patente, Marca, Modelo, anio_fabricacion, cantidad_de_ruedas) VALUES
                                                                                                      (5005, 'XYZ111', 'Toyota', 'Corolla', 2015, 4),
                                                                                                      (5006, 'UVW222', 'Honda', 'Civic', 2018, 4),
                                                                                                      (5007, 'RST333', 'Ford', 'Focus', 2012, 4),
                                                                                                      (5008, 'PQR444', 'Chevrolet', 'Cruze', 2019, 4),
                                                                                                      (5009, 'LMN555', 'Volkswagen', 'Golf', 2017, 4);

-- Insertar siniestros
INSERT INTO siniestros (id_siniestro, fecha_siniestro, perdida_economica, id_vehiculo) VALUES
                                                                                           (5005, '2024-02-15', 12000, 5005),
                                                                                           (5006, '2024-02-16', 1500.75, 5006),
                                                                                           (5007, '2024-02-17', 3000.00, 5007),
                                                                                           (5008, '2024-02-18', 15000, 5008),
                                                                                           (5009, '2024-02-19', 2500.00, 5009);
