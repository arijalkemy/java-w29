DROP TABLE clientes;
DROP TABLE planes_internet;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS planes_internet (
                                               id INT NOT NULL,
                                               velocidad INT NOT NULL,
                                               precio DOUBLE NOT NULL,
                                               descuento DOUBLE NOT NULL DEFAULT 0,
                                               CONSTRAINT PK_PlanInternet PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS clientes (
                                        id SERIAL,
                                        dni VARCHAR(255) NOT NULL,
                                        nombre VARCHAR(255),
                                        apellido VARCHAR(255),
                                        nacimiento DATE,
                                        provincia VARCHAR(255),
                                        ciudad VARCHAR(255),
                                        plan_internet_id INT,
                                        CONSTRAINT PK_Cliente PRIMARY KEY (id),
                                        CONSTRAINT FK_Cliente_PlanInternet FOREIGN KEY (plan_internet_id) REFERENCES planes_internet(id)
);


-- Insertar planes de internet
INSERT INTO planes_internet (id, velocidad, precio, descuento) VALUES
                                                                   (1, 50, 5000, 0),
                                                                   (2, 100, 8000, 10),
                                                                   (3, 200, 12000, 15),
                                                                   (4, 300, 15000, 20),
                                                                   (5, 500, 20000, 25);

-- Insertar clientes
INSERT INTO clientes (dni, nombre, apellido, nacimiento, provincia, ciudad, plan_internet_id) VALUES
                                                                                                  ('25789456', 'Juan', 'García', '1990-05-15', 'Buenos Aires', 'La Plata', 1),
                                                                                                  ('30654987', 'María', 'López', '1985-08-22', 'Córdoba', 'Córdoba', 2),
                                                                                                  ('28963741', 'Pedro', 'Martínez', '1988-03-10', 'Santa Fe', 'Rosario', 3),
                                                                                                  ('33741852', 'Ana', 'Rodríguez', '1992-11-30', 'Mendoza', 'Mendoza', 4),
                                                                                                  ('27159357', 'Luis', 'Fernández', '1987-07-25', 'Buenos Aires', 'Mar del Plata', 5),
                                                                                                  ('31852963', 'Carolina', 'Sánchez', '1991-04-18', 'Córdoba', 'Villa María', 1),
                                                                                                  ('29357159', 'Miguel', 'González', '1989-09-05', 'Santa Fe', 'Santa Fe', 2),
                                                                                                  ('34963741', 'Laura', 'Díaz', '1993-12-08', 'Buenos Aires', 'Quilmes', 3),
                                                                                                  ('26852147', 'Roberto', 'Pérez', '1986-06-20', 'Mendoza', 'San Rafael', 4),
                                                                                                  ('32147963', 'Sofía', 'Torres', '1992-01-15', 'Buenos Aires', 'Tandil', 5);