-- Inserción de datos para la tabla "sale" (solo ejemplo, ajusta según tu estructura real)
--INSERT INTO sale (id, sale_date) VALUES (1, '2025-02-18');
--INSERT INTO sale (id, sale_date) VALUES (2, '2025-02-19');

-- Inserción de datos para la tabla "clothes"
--INSERT INTO clothes (code, name, type, brand, color, size, qty, sale_price) VALUES
--(1, 'T-shirt', 'Top', 'Nike', 'Red', 42, 10, 29.99),
--(2, 'Jeans', 'Bottom', 'Levi\'s', 'Blue', 32, 15, 49.99),
--(3, 'Jacket', 'Outerwear', 'Adidas', 'Black', 38, 5, 79.99),
--(4, 'Sweater', 'Top', 'Puma', 'Gray', 40, 8, 39.99);

-- Inserción de datos en la tabla intermedia de ManyToMany (ajusta según el nombre real de la tabla intermedia)
-- Suponiendo que la relación ManyToMany tiene una tabla llamada "clothes_sales"
-- Si no existe la tabla intermedia, deberías usar la convención de JPA para gestionarla automáticamente

-- Relaciones entre prendas y ventas
--INSERT INTO clothes_sales (clothe_code, sale_id) VALUES
--(1, 1),
--(2, 1),
--(3, 2),
--(4, 2);

/*
    INSERT INTO ´CLOTHES´ (´code´,´name´,´type´,´brand´, ´color´,´size´,´qty´,´sale_price´) VALUES
  (1, 'T-shirt', 'Top', 'Nike', 'Red', 42, 10, 29.99),
  (2, 'Jeans', 'Bottom', 'Levi\'s', 'Blue', 32, 15, 49.99),
  (3, 'Jacket', 'Outerwear', 'Adidas', 'Black', 38, 5, 79.99),
  (4, 'Sweater', 'Top', 'Puma', 'Gray', 40, 8, 39.99);
*/

INSERT INTO "CLOTHES" ("CODE", "NAME", "TYPE", "BRAND", "COLOR", "SIZE", "QTY", "SALE_PRICE") VALUES
  (1, 'T-shirt', 'Top', 'Nike', 'Red', 42, 10, 29.99),
  (2, 'Jeans', 'Bottom', 'Levi''s', 'Blue', 32, 15, 49.99),
  (3, 'Jacket', 'Outerwear', 'Adidas', 'Black', 38, 5, 79.99),
  (4, 'Sweater', 'Top', 'Puma', 'Gray', 40, 8, 39.99),
(5, 'buzo blanco', 'Top', 'Puma', 'Gray', 40, 8, 39.99),
(6, 'buzo negro', 'Top', 'Puma', 'Gray', 40, 8, 39.99),
(7, 'buzo marron', 'Top', 'Puma', 'Gray', 40, 8, 39.99);

