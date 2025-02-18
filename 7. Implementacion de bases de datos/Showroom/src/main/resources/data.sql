-- Desactivar verificación de claves foráneas temporalmente

INSERT INTO clothing (id, code, name, type, brand, color, size, quantity, sale_price) VALUES
                                                                                          (1, 'TSH001', 'T-Shirt Classic', 'Shirt', 'Nike', 'Red', 'M', 15, 19.99),
                                                                                          (2, 'TSH002', 'T-Shirt Sport', 'Shirt', 'Adidas', 'Blue', 'L', 10, 22.99),
                                                                                          (3, 'JKT001', 'Leather Jacket', 'Jacket', 'Puma', 'Black', 'XL', 5, 79.99),
                                                                                          (4, 'JKT002', 'Denim Jacket', 'Jacket', 'Levi’s', 'Blue', 'M', 8, 59.99),
                                                                                          (5, 'HOD001', 'Hoodie Basic', 'Sweater', 'Under Armour', 'Gray', 'L', 12, 34.99),
                                                                                          (6, 'HOD002', 'Hoodie Premium', 'Sweater', 'Reebok', 'Black', 'S', 9, 44.99),
                                                                                          (7, 'PNTS001', 'Jeans Slim Fit', 'Pants', 'Levi’s', 'Dark Blue', 'M', 20, 49.99),
                                                                                          (8, 'PNTS002', 'Chino Pants', 'Pants', 'Zara', 'Beige', 'L', 18, 39.99),
                                                                                          (9, 'SRT001', 'Cargo Shorts', 'Shorts', 'H&M', 'Green', 'M', 14, 29.99),
                                                                                          (10, 'SRT002', 'Denim Shorts', 'Shorts', 'Diesel', 'Light Blue', 'S', 10, 24.99);

-- Insertar ventas en la tabla sales
INSERT INTO sales (id, number, date, total, payment_method) VALUES
                                                                (1, 'V001', '2024-02-01', 89.97, 'Credit Card'),
                                                                (2, 'V002', '2024-02-03', 59.98, 'Cash'),
                                                                (3, 'V003', '2024-02-05', 129.95, 'Debit Card'),
                                                                (4, 'V004', '2024-02-07', 79.99, 'PayPal'),
                                                                (5, 'V005', '2024-02-10', 44.99, 'Credit Card'),
                                                                (6, 'V006', '2024-02-15', 99.99, 'Credit Card');

-- Insertar relaciones en la tabla intermedia sale_clothing (ventas con sus prendas)
INSERT INTO sale_clothing (sale_id, clothing_id) VALUES
                                                     (1, 1),  -- Venta V001 -> Prenda 1
                                                     (1, 3),  -- Venta V001 -> Prenda 3
                                                     (1, 5),  -- Venta V001 -> Prenda 5
                                                     (2, 2),  -- Venta V002 -> Prenda 2
                                                     (2, 6),  -- Venta V002 -> Prenda 6
                                                     (3, 4),  -- Venta V003 -> Prenda 4
                                                     (3, 7),  -- Venta V003 -> Prenda 7
                                                     (3, 8),  -- Venta V003 -> Prenda 8
                                                     (3, 9),  -- Venta V003 -> Prenda 9
                                                     (4, 10), -- Venta V004 -> Prenda 10
                                                     (5, 6),  -- Venta V005 -> Prenda 6
                                                     (6, 1),  -- Venta V006 -> Prenda 1
                                                     (6, 3),  -- Venta V006 -> Prenda 3
                                                     (6, 5);  -- Venta V006 -> Prenda 5

