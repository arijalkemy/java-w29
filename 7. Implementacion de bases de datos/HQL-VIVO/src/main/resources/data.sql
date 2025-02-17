INSERT INTO `Vehiculo` (`id`, `patente`, `marca`, `modelo`, `fechaFabricacion`, `ruedas`) VALUES
                                                                                (1, 'ABC123', 'Toyota', 'Corolla', '2015-06-15', 4),
                                                                                (2, 'DEF456', 'Honda', 'Civic', '2018-09-20', 4),
                                                                                (3, 'GHI789', 'Ford', 'Focus', '2012-03-10', 4),
                                                                                (4, 'JKL012', 'Chevrolet', 'Cruze', '2019-11-05', 4),
                                                                                (5, 'MNO345', 'Volkswagen', 'Golf', '2017-01-25', 4);

INSERT INTO `Siniestro` (`id`, `perdidaEconomica`, `vehiculo_id`) VALUES
                                                              (1, 12000, 1),
                                                              (2, 8000, 2),
                                                              (3, 15000, 3),
                                                              (4, 5000, 4),
                                                              (5, 20000, 5);