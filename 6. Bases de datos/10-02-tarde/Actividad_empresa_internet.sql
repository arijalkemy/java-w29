DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

drop table if exists clientes;
create table clientes(
`id` int(10) NOT NULL AUTO_INCREMENT,
`dni` varchar(25),
`nombre` varchar(50),
`apellido` varchar(50),
`fecha_nacimiento` date,
`provincia` varchar(50),
`ciudad` varchar(50),
`id_plan` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  constraint `plan_id_foreign` foreign key (`id_plan`) references `planes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

drop table if exists planes;
create table planes(
`id` int(10) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50),
`velocidad` int,
`precio` float,
`descuento` float,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into planes(`nombre`, `velocidad`, `precio`, `descuento`) values 
('Plan1', 100, 1000, 0),
('Plan2', 200, 1500, 173),
('Plan3', 300, 2300, 0),
('Plan4', 400, 2700, 180),
('Plan5', 500, 3000, 223);

insert into clientes(`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`, `id_plan`) values
('12345678','Pepe','Pérez','2000-04-17','CABA','CABA',153),
('22345679','Pepa','Pérez','2000-03-17','CABA','CABA',152),
('22345677','Pepi','Vázquez','2000-02-17','CABA','CABA',153),
('22345676','Pepo','Agu','2001-01-17','CABA','CABA',153),
('22345675','Coco','Ague','2002-08-17','CABA','CABA',151),
('12345679','Maria','No se','1990-04-01','CABA','CABA',154),
('12345677','Mario','Ido','1991-11-07','CABA','CABA',154),
('12345676','Lujan','Apell','1991-10-23','CABA','CABA',155),
('12345675','Fabi','Aguero','1994-04-19','CABA','CABA',152),
('12345674','Fiona','Aguero','1995-09-30','CABA','CABA',152);
