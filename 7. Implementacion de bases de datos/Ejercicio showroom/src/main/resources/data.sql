-- Insert data into garment table
INSERT INTO Garment (id, name, type, brand, color, size, amount, price) VALUES
                                                                            (1, 'T-shirt Basic', 'Shirt', 'Nike', 'Red', 'M', 50, 19.99),
                                                                            (2, 'Slim Jeans', 'Pants', 'Levis', 'Blue', 'L', 30, 39.99),
                                                                            (3, 'Sports Jacket', 'Jacket', 'Adidas', 'Black', 'L', 20, 59.99),
                                                                            (4, 'Summer Dress', 'Dress', 'H&M', 'Yellow', 'S', 15, 29.99),
                                                                            (5, 'Running Shoes', 'Shoes', 'Puma', 'White', 'M', 40, 49.99);


INSERT INTO Sale (number, date, total, payment_Method) VALUES
    (1, '2023-10-01 00:00:00', 100.0, 'Credit Card');

INSERT INTO sale_garment (sale_number, garment_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (1, 3);