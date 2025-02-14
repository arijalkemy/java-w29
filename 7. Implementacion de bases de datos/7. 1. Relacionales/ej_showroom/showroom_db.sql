DROP DATABASE IF EXISTS showroom_db;
CREATE DATABASE showroom_db;
USE showroom_db;

DROP TABLE IF EXISTS `brands`;
CREATE TABLE brands (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `payment_methods`;
CREATE TABLE payment_methods (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `clothes`;
CREATE TABLE clothes (
    code INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    id_brand INT NOT NULL,
    size VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_brand) REFERENCES brands(id)
);

DROP TABLE IF EXISTS `sales`;
CREATE TABLE sales (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    id_payment_method INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_payment_method) REFERENCES payment_methods(id)
);

DROP TABLE IF EXISTS `sale_details`;
CREATE TABLE sale_details (
    id_sale INT,
    code_clothe INT,
    quantity INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id_sale, code_clothe),
    FOREIGN KEY (id_sale) REFERENCES sales(id),
    FOREIGN KEY (code_clothe) REFERENCES clothes(code)
);

-- Insertar 20 prendas

INSERT INTO brands (name) VALUES
    ('Nike'),
    ('Adidas'),
    ('Puma'),
    ('Reebok'),
    ('Under Armour'),
    ('New Balance'),
    ('Columbia'),
    ('The North Face');

INSERT INTO payment_methods (name) VALUES
    ('Cash'),
    ('Credit Card'),
    ('Debit Card'),
    ('PayPal'),
    ('Bank Transfer');

INSERT INTO clothes (name, type, id_brand, size, color, stock, price) VALUES
    ('Nike Air Max', 'Shoes', 1, '42', 'Red', 10, 120.00),
    ('Adidas UltraBoost', 'Shoes', 2, '43', 'Black', 15, 150.00),
    ('Puma Suede Classic', 'Shoes', 3, '40', 'White', 20, 80.00),
    ('Reebok Classic Leather', 'Shoes', 4, '44', 'Blue', 12, 90.00),
    ('Under Armour HOVR', 'Shoes', 5, '41', 'Grey', 18, 110.00),
    ('New Balance 990', 'Shoes', 6, '45', 'Green', 8, 130.00),
    ('Columbia Trail Shoes', 'Shoes', 7, '42', 'Brown', 22, 95.00),
    ('The North Face Hedgehog', 'Shoes', 8, '43', 'Black', 25, 120.00),
    ('Nike Dri-FIT', 'T-Shirt', 1, 'M', 'White', 30, 35.00),
    ('Adidas Originals', 'T-Shirt', 2, 'L', 'Black', 40, 40.00),
    ('Puma Iconic', 'T-Shirt', 3, 'S', 'Grey', 25, 30.00),
    ('Reebok Vector', 'T-Shirt', 4, 'XL', 'Red', 18, 38.00),
    ('Under Armour Tech', 'T-Shirt', 5, 'M', 'Blue', 22, 36.00),
    ('New Balance Performance', 'T-Shirt', 6, 'L', 'Green', 15, 32.00),
    ('Columbia Pack Light', 'Jacket', 7, 'M', 'Yellow', 12, 110.00),
    ('The North Face Apex', 'Jacket', 8, 'L', 'Black', 20, 180.00),
    ('Nike Windrunner', 'Jacket', 1, 'S', 'Grey', 18, 120.00),
    ('Adidas Climacool', 'Jacket', 2, 'M', 'Red', 25, 130.00),
    ('Puma Essentials', 'Jacket', 3, 'L', 'Navy', 10, 110.00),
('Reebok Workout', 'Jacket', 4, 'XL', 'Green', 14, 120.00);

-- Insertar 8 ventas

INSERT INTO sales (date, id_payment_method, total) VALUES
    ('2025-02-01', 1, 320.00),
    ('2025-02-02', 2, 450.00),
    ('2025-02-03', 3, 275.00),
    ('2025-02-04', 4, 210.00),
    ('2025-02-05', 5, 340.00),
    ('2025-02-06', 1, 390.00),
    ('2025-02-07', 3, 230.00),
    ('2025-02-08', 2, 280.00);

INSERT INTO sale_details (id_sale, code_clothe, quantity, subtotal) VALUES
    (1, 1, 2, 240.00),
    (1, 10, 2, 80.00),
    (2, 2, 3, 450.00),
    (3, 3, 5, 400.00),
    (4, 4, 2, 180.00),
    (5, 5, 3, 330.00),
    (6, 6, 1, 130.00),
    (6, 7, 2, 190.00),
    (7, 8, 4, 480.00),
    (8, 9, 2, 72.00),
    (8, 10, 3, 120.00);


