use empresa_internet;

create table planes_internet(id int primary key auto_increment, velocidad float, precio decimal(0.2), descuento decimal(0.1));


create table clientes(dni varchar(10) primary key, nombre varchar(20), apellido varchar(20), fecha_nacimiento date, 
provincia varchar(20), ciudad varchar(20), plan_id int, foreign key (plan_id) references planes_internet(id));


INSERT INTO planes_internet (velocidad, precio, descuento) 
VALUES
('10 Mbps', 15.99, 5.00),
('50 Mbps', 25.99, 10.00),
('100 Mbps', 35.99, 15.00);