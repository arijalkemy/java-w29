-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (x86_64)
--
-- Host: 127.0.0.1    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(25) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'88990011','Paula','Díaz','2003-05-18','Santander','Bucaramanga'),(2,'12345678','Juan','Pérez','1985-06-15','Buenos Aires','CABA'),(3,'87654321','María','Gómez','1990-02-20','Córdoba','Córdoba'),(4,'11223344','Carlos','López','2001-11-05','Mendoza','Mendoza'),(5,'22334455','Ana','Fernández','1995-08-25','Santa Fe','Rosario'),(6,'33445566','Diego','Martínez','1988-04-10','Tucumán','San Miguel de Tucumán'),(7,'44556677','Lucía','Rodríguez','1993-12-30','Cundinamarca','Bogotá'),(8,'55667788','Martín','Sánchez','2000-07-22','Antioquia','Medellín'),(9,'66778899','Sofía','González','1997-09-12','Valle del Cauca','Cali'),(10,'77889900','Andrés','Ruiz','1986-03-05','Atlántico','Barranquilla');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contratos`
--

DROP TABLE IF EXISTS `Contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Contratos` (
  `contrato_id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int NOT NULL,
  `plan_id` int NOT NULL,
  `descuento` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`contrato_id`),
  KEY `cliente_id_idx` (`cliente_id`),
  KEY `plan_id_idx` (`plan_id`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `Clientes` (`cliente_id`),
  CONSTRAINT `plan_id` FOREIGN KEY (`plan_id`) REFERENCES `Planes` (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contratos`
--

LOCK TABLES `Contratos` WRITE;
/*!40000 ALTER TABLE `Contratos` DISABLE KEYS */;
INSERT INTO `Contratos` VALUES (22,1,1,5.00),(23,2,2,10.00),(24,3,3,0.00),(25,4,4,15.00),(26,5,5,5.00),(27,6,1,10.00),(28,7,2,0.00),(29,8,3,5.00),(30,9,4,10.00),(31,10,5,15.00);
/*!40000 ALTER TABLE `Contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Planes`
--

DROP TABLE IF EXISTS `Planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Planes` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `velocidad` int DEFAULT NULL,
  `precio` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Planes`
--

LOCK TABLES `Planes` WRITE;
/*!40000 ALTER TABLE `Planes` DISABLE KEYS */;
INSERT INTO `Planes` VALUES (1,50,30.00),(2,100,50.00),(3,200,75.00),(4,300,90.00),(5,500,120.00);
/*!40000 ALTER TABLE `Planes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-10 19:09:46
