-- Insertar vehículos en la tabla `vehicle`
INSERT INTO vehicle (id, patent, brand, model, year_abricated, wheels) VALUES
                                                                           (1, 'AAA111', 'Toyota', 'Corolla', 2022, 4),
                                                                           (2, 'BBB222', 'Ford', 'Focus', 2020, 4),
                                                                           (3, 'CCC333', 'Chevrolet', 'Cruze', 2021, 4),
                                                                           (4, 'DDD444', 'Honda', 'Civic', 2025, 4),
                                                                           (5, 'EEE555', 'Volkswagen', 'Golf', 2025, 6), -- Más de 4 ruedas y del año actual
                                                                           (6, 'FFF666', 'Mercedes-Benz', 'Sprinter', 2025, 8), -- Más de 4 ruedas y del año actual
                                                                           (7, 'GGG777', 'Iveco', 'Daily', 2025, 6), -- Más de 4 ruedas y del año actual
                                                                           (8, 'HHH888', 'Renault', 'Kangoo', 2019, 4),
                                                                           (9, 'III999', 'Nissan', 'Sentra', 2018, 4),
                                                                           (10, 'JJJ000', 'Peugeot', '208', 2017, 4);

-- Insertar accidentes en la tabla `accident`
INSERT INTO accident (id, accident_date, economic_loss, vehicle_id) VALUES
                                                                        (1, '2023-05-10', 5000.00, 1),
                                                                        (2, '2022-08-15', 12000.50, 2), -- Mayor a 10,000
                                                                        (3, '2021-12-20', 7000.75, 3),
                                                                        (4, '2023-02-28', 2500.00, 4),
                                                                        (5, '2020-11-10', 15000.00, 5), -- Mayor a 10,000
                                                                        (6, '2021-06-22', 6000.00, 6),
                                                                        (7, '2023-01-05', 11000.00, 7), -- Mayor a 10,000
                                                                        (8, '2022-04-18', 18000.00, 8), -- Mayor a 10,000
                                                                        (9, '2023-07-19', 9500.00, 9),
                                                                        (10, '2023-03-10', 22000.00, 10); -- Mayor a 10,000
