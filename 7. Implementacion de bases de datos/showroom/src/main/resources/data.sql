-- INSERTANDO ROPA (CLOTHES)
INSERT INTO clothes (id, code, name, type, brand, color, size, quantity, price_sale) VALUES
(1, 'C001', 'Camiseta Básica', 'Camiseta', 'Nike', 'Blanca', 'M', 50, 25.99),
(2, 'C002', 'Jeans Skinny', 'Pantalón', 'Levi', 'Azul', '32', 30, 49.99),
(3, 'C003', 'Chaqueta de Cuero', 'Chaqueta', 'Zara', 'Negro', 'L', 15, 99.99),
(4, 'C004', 'Vestido Floral', 'Vestido', 'H&M', 'Rojo', 'S', 20, 39.99),
(5, 'C005', 'Suéter de Lana', 'Suéter', 'Tommy Hilfiger', 'Beige', 'M', 18, 69.99),
(6, 'C006', 'Pantalón Chino', 'Pantalón', 'Dockers', 'Marrón', '34', 22, 44.99);

-- INSERTANDO VENTAS (SALES)
INSERT INTO sales (id, number, total, means_of_payment, date) VALUES
(1, 1001, 125.97, 'Tarjeta de Crédito', '2024-02-01'),
(2, 1002, 89.98, 'Efectivo', '2024-02-05'),
(3, 1003, 149.98, 'Transferencia Bancaria', '2024-02-10'),
(4, 1004, 69.99, 'Tarjeta Débito', '2024-02-15'),
(5, 1005, 99.98, 'PayPal', '2024-02-20'),
(6, 1006, 74.99, 'Efectivo', '2024-02-25');

-- INSERTANDO DETALLES DE VENTA (SALE_DETAILS)
INSERT INTO sale_details (id, sale_id, clothe_id, quantity) VALUES
(1, 1, 1, 2),  -- Venta 1001 -> 2 Camisetas Básicas
(2, 1, 2, 1),  -- Venta 1001 -> 1 Jeans Skinny
(3, 2, 3, 1),  -- Venta 1002 -> 1 Chaqueta de Cuero
(4, 2, 4, 1),  -- Venta 1002 -> 1 Vestido Floral
(5, 3, 5, 2),  -- Venta 1003 -> 2 Suéteres de Lana
(6, 3, 6, 2);  -- Venta 1003 -> 2 Pantalones Chinos
