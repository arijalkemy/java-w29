INSERT INTO ventas (numero, fecha, total, medio_pago) VALUES
                                                          (1, '2023-10-01 10:00:00', 150.00, 'Efectivo'),
                                                          (2, '2023-10-02 11:30:00', 200.00, 'Tarjeta'),
                                                          (3, '2023-10-03 14:45:00', 300.00, 'Transferencia');

INSERT INTO prendas (codigo, nombre, tipo, marca, color, talle, cantidad, precio_venta) VALUES
                                                                                            (1, 'Camisa', 'Ropa', 'Marca A', 'Azul', 42, 10, 50.00),
                                                                                            (2, 'Pantalón', 'Ropa', 'Marca B', 'Negro', 40, 5, 75.00),
                                                                                            (3, 'Zapatos', 'Calzado', 'Marca C', 'Marrón', 42, 7, 100.00),
                                                                                            (4, 'Sombrero', 'Accesorio', 'Marca D', 'Beige', null, 15, 25.00);


INSERT INTO ventas_prendas (prenda_codigo, venta_numero) VALUES
                                                             (1, 1),
                                                             (2, 1),
                                                             (3, 2),
                                                             (1, 2),
                                                             (4, 3),
                                                             (2, 3),
                                                             (3, 3);