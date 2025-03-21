-- Insertar Usuarios (Supervisores y Buyers)
INSERT INTO users (username, name, password, role) VALUES
                                                       ('supervisor_norte', 'Juan Perez', 'hashedpassword1', 'SUPERVISOR'),
                                                       ('supervisor_sur', 'María López', 'hashedpassword2', 'SUPERVISOR'),
                                                       ('buyer_juan', 'Juan Perez', 'hashedpassword1', 'BUYER'),
                                                       ('ramao', 'Ramiro Garcia', 'hashedpassword1', 'BUYER'),
                                                       ('buyer_maria', 'María Lopez', 'hashedpassword2', 'BUYER');

-- Insertar Warehouses con Supervisores
INSERT INTO warehouse (id, name, supervisor_id) VALUES
                                                    (1, 'Warehouse Norte', 1),
                                                    (2, 'Warehouse Sur', 2);

-- Insertar Secciones dentro de los Warehouses
INSERT INTO sector (id, product_type, warehouse_id, name) VALUES
                                                              (1, 'FRESH', 1, 'Sección Frescos'),
                                                              (2, 'REFRIGERATED', 2, 'Sección Refrigerados sur'),
                                                              (3, 'FROZEN', 2, 'Sección Congelados'),
                                                              (4, 'REFRIGERATED', 2, 'Sección Refrigerados norte');

-- Insertar carritos asociados a buyers
INSERT INTO purchase_order(id, date, buyer_id) VALUES
                                                   (1, '2025-03-13', 4),
                                                   (2, '2025-03-14', 5);

-- Insertar productos
INSERT INTO product (id, name, unitary_price, type) VALUES
                                                        (1, 'Carne de Res', 1200.00, 'FRESH'),
                                                        (2, 'Leche Entera', 800.50, 'REFRIGERATED'),
                                                        (3, 'Harina de Trigo', 450.00, 'FRESH'),
                                                        (4, 'Hielo', 250.00, 'FROZEN');

-- Insertar productos en carritos (order_product)
INSERT INTO purchase_order_product (id, order_id, product_id, order_quantity) VALUES
                                                                                  (1, 1, 1, 2), -- Juan tiene 2 unidades de Carne de Res en su carrito
                                                                                  (2, 1, 2, 1), -- Juan tiene 1 unidad de Leche Entera en su carrito
                                                                                  (3, 2, 3, 3); -- María tiene 3 unidades de Harina de Trigo en su carrito


-- Insertar lotes (batch) asociados a secciones
INSERT INTO batch (batch_number, current_quantity, current_temperature, due_date, initial_quantity, minimum_temperature, manufacturing_time,manufacturing_date, product_id, sector_id) VALUES
                                                                                                                                                                                           (23, 2, 5, '2025-04-10', 2, 2, '2024-03-10 14:30:45', '2024-03-10', 2, 2), -- Lote de leche en Refrigerados
                                                                                                                                                                                           (24, 2, 5, '2025-04-10', 2, 2, '2024-03-10 14:30:45', '2024-03-10', 2, 2), -- Lote de leche en Refrigerados
                                                                                                                                                                                           (25, 4, 0, '2025-04-10', 2, 2, '2024-03-10 14:30:45', '2024-03-10', 2, 4), -- Lote de leche en Refrigerados
                                                                                                                                                                                           (21, 20, 7, '2025-05-15', 20, 2, '2024-03-12 15:00:30', '2024-03-12', 2, 1), -- Lote de leche en Refrigerados
                                                                                                                                                                                           (2351, 30, -18, '2025-06-01', 30, -20, '2024-03-05 10:15:20', '2024-03-05', 3, 1), -- Lote de harina en Congelados (incorrecto si es fresco)
                                                                                                                                                                                           (123, 25, -10, '2025-04-20', 25, -15, '2024-03-06 09:40:10', '2024-03-06', 3, 1), -- Lote de harina en Congelados (incorrecto si es fresco)
                                                                                                                                                                                           (111045, 1000, 0, '2025-07-10', 1000, 0, '2024-02-28 12:20:50', '2024-02-28', 1, 1), -- Lote de carne en Frescos
                                                                                                                                                                                           (324512,5,5.2,'2025-04-17',5,0.5,'2025-03-15 17:00:00','2025-03-15',2,2);