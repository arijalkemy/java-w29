-- Data.sql

-- Insert dress 1
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido de Noche Clásico', 'Vestido de Noche', 'Dior', 'Negro', 'M', 5, 250.00);

-- Insert dress 2
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Casual', 'Vestido Casual', 'Zara', 'Azul', 'L', 10, 49.99);

-- Insert dress 3
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Formal', 'Vestido Formal', 'H&M', 'Gris', 'S', 8, 69.99);

-- Insert dress 4
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Bohemio Verano', 'Vestido Bohemio', 'Mango', 'Multicolor', 'XL', 3, 89.99);

-- Insert dress 5
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido de Fiesta', 'Vestido de Fiesta', 'Gucci', 'Rosa', 'S', 2, 450.00);

-- Insert dress 6
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Casual Otoño', 'Vestido Casual', 'Calvin Klein', 'Beige', 'M', 7, 99.99);

-- Insert dress 7
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Tiro Cruzado', 'Vestido Formal', 'Guess', 'Negro', 'L', 4, 79.99);

-- Insert dress 8
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Tule', 'Vestido de Noche', 'Chanel', 'Blanco', 'XL', 1, 800.00);

-- Insert dress 9
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Casual Primavera', 'Vestido Casual', 'Zara', 'Verde', 'XS', 12, 59.99);

-- Insert dress 10
INSERT INTO dresses (name, type, brand, color, size, amount, price)
VALUES 
('Vestido Almidonado', 'Vestido Formal', 'Guess', 'Azul Oscuro', 'S', 6, 89.99);

-- Insertar 5 facturas con diferentes combinaciones de vestidos

-- Factura 1
INSERT INTO sales (date, total, payment_method)
VALUES ('2023-07-20', 769.98, 'Tarjeta de Crédito');

-- Relaciones para Factura 1 (IDs de vestidos: 1, 3, 5)
INSERT INTO sales_dresses (sale_id, dress_id)
VALUES
(1, 1),  -- Vestido de Noche Clásico
(1, 3),  -- Vestido Formal
(1, 5);  -- Vestido de Fiesta

-- Factura 2
INSERT INTO sales (date, total, payment_method)
VALUES ('2023-07-21', 239.97, 'Cash');

-- Relaciones para Factura 2 (IDs de vestidos: 2, 4, 6)
INSERT INTO sales_dresses (sale_id, dress_id)
VALUES
(2, 2),  -- Vestido Casual
(2, 4),  -- Vestido Bohemio Verano
(2, 6);  -- Vestido Casual Otoño

-- Factura 3
INSERT INTO sales (date, total, payment_method)
VALUES ('2023-07-22', 788.98, 'Tarjeta de Débito');

-- Relaciones para Factura 3 (IDs de vestidos: 7, 8, 9)
INSERT INTO sales_dresses (sale_id, dress_id)
VALUES
(3, 7),  -- Vestido Tiro Cruzado
(3, 8),  -- Vestido Tule
(3, 9);  -- Vestido Casual Primavera

-- Factura 4
INSERT INTO sales (date, total, payment_method)
VALUES ('2023-07-23', 939.98, 'PayPal');

-- Relaciones para Factura 4 (IDs de vestidos: 10, 2, 8)
INSERT INTO sales_dresses (sale_id, dress_id)
VALUES
(4, 10), -- Vestido Almidonado
(4, 2),  -- Vestido Casual
(4, 8);  -- Vestido Tule

-- Factura 5
INSERT INTO sales (date, total, payment_method)
VALUES ('2023-07-24', 499.98, 'Tarjeta de Crédito');

-- Relaciones para Factura 5 (IDs de vestidos: 5, 9, 10)
INSERT INTO sales_dresses (sale_id, dress_id)
VALUES
(5, 5),  -- Vestido de Fiesta
(5, 9),  -- Vestido Casual Primavera
(5, 10); -- Vestido Almidonado