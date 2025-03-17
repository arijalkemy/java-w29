-- Insertar marcas
INSERT INTO brands (name) VALUES
                              ('Nike'),
                              ('Adidas'),
                              ('Puma');

-- Insertar ropa con las marcas relacionadas
INSERT INTO clothes (name, type, id_brand, size, color, stock, price) VALUES
                                                                          ('T-Shirt', 'Shirt', 1, 'M', 'Red', 50, 29.99),
                                                                          ('Jeans', 'Pants', 2, 'L', 'Blue', 30, 49.99),
                                                                          ('Jacket', 'Outerwear', 3, 'M', 'Black', 20, 89.99),
                                                                          ('Sneakers', 'Shoes', 1, '42', 'White', 100, 69.99),
                                                                          ('Sweatshirt', 'Shirt', 2, 'L', 'Grey', 25, 39.99);
