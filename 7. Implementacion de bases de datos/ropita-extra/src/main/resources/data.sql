INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C001', 'T-Shirt', 'Top', 'Nike', 'Red', 'M', 50, 19.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C002', 'Jeans', 'Bottom', 'Levis', 'Blue', 'L', 30, 49.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C003', 'Sweater', 'Top', 'Adidas', 'Black', 'L', 40, 39.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C004', 'Jacket', 'Outerwear', 'North Face', 'Grey', 'M', 25, 89.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C005', 'Cargo Shorts', 'Bottom', 'Puma', 'Khaki', 'S', 20, 29.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C006', 'Button-Up Shirt', 'Top', 'Ralph Lauren', 'White', 'M', 15, 79.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C007', 'Tracksuit', 'Bottom', 'Adidas', 'Black', 'L', 35, 59.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C008', 'Hoodie', 'Top', 'Champion', 'Navy', 'L', 60, 34.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C009', 'Skirt', 'Bottom', 'H&M', 'Pink', 'M', 45, 24.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C010', 'Blouse', 'Top', 'Zara', 'Green', 'S', 28, 49.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C011', 'Joggers', 'Bottom', 'Nike', 'Charcoal', 'XL', 50, 39.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C012', 'Vest', 'Outerwear', 'Under Armour', 'Black', 'S', 22, 29.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C013', 'Tank Top', 'Top', 'Reebok', 'White', 'M', 38, 14.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C014', 'Denim Jacket', 'Outerwear', 'Levis', 'Blue', 'M', 40, 69.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C015', 'Sweatpants', 'Bottom', 'Nike', 'Grey', 'L', 45, 29.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C016', 'Shorts', 'Bottom', 'Adidas', 'Red', 'S', 50, 19.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C017', 'Blazer', 'Outerwear', 'Ralph Lauren', 'Black', 'L', 18, 149.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C018', 'Sweater', 'Top', 'H&M', 'Beige', 'S', 33, 39.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C019', 'Dress', 'Dress', 'Forever 21', 'Purple', 'M', 20, 49.99);

INSERT INTO clothes (code, name, type, brand, color, size, amount, price)
VALUES ('C020', 'Puffer Jacket', 'Outerwear', 'The North Face', 'Red', 'L', 12, 129.99);


-- Inserting sale records
INSERT INTO sales (id, sale_date, total, payment_method)
VALUES ('S001', '2025-02-18', 234.97, 'Credit Card');

INSERT INTO sales (id, sale_date, total, payment_method)
VALUES ('S002', '2025-02-19', 309.94, 'Cash');

INSERT INTO sales (id, sale_date, total, payment_method)
VALUES ('S003', '2025-02-20', 179.97, 'Debit Card');

-- Sale #1 includes T-Shirt (C001), Jeans (C002), and Hoodie (C008)
INSERT INTO sale_clothes (sale_id, clothes_id)
VALUES ('S001', 'C001'), ('S001', 'C002'), ('S001', 'C008');

-- Sale #2 includes Sweater (C003), Jacket (C004), and Button-Up Shirt (C006)
INSERT INTO sale_clothes (sale_id, clothes_id)
VALUES ('S002', 'C003'), ('S002', 'C004');

-- Sale #3 includes Cargo Shorts (C005), Blouse (C010), and Sweatpants (C015)
INSERT INTO sale_clothes (sale_id, clothes_id)
VALUES ('S003', 'C005'), ('S003', 'C010'), ('S003', 'C015');

