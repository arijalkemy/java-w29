CREATE TABLE IF NOT EXISTS clientes (
    id SERIAL,
    dni VARCHAR(255) NOT NULL ,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    nacimiento DATE,
    provincia VARCHAR(255),
    ciudad VARCHAR(255),

    CONSTRAINT PK_Cliente PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS planes_internet (
   id INT NOT NULL,
   velocidad INT NOT NULL,
   precio DOUBLE NOT NULL,
   descuento DOUBLE NOT NULL DEFAULT 0,

   CONSTRAINT PK_PlanInternet PRIMARY KEY (id)
);