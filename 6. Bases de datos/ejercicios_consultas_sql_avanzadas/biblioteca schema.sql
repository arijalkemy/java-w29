-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (x86_64)
--
-- Host: 127.0.0.1    Database: biblioteca
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
-- Table structure for table `Autores`
--

DROP TABLE IF EXISTS `Autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autores` (
  `autor_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`autor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autores`
--

LOCK TABLES `Autores` WRITE;
/*!40000 ALTER TABLE `Autores` DISABLE KEYS */;
INSERT INTO `Autores` VALUES (1,'Isaac Newton','Inglaterra'),(2,'Marie Curie','Francia'),(3,'Charles Darwin','Inglaterra'),(4,'Albert Einstein','Alemania'),(5,'Sigmund Freud','Austria'),(6,'Adam Smith','Escocia'),(7,'Plutarco','Grecia'),(8,'Miguel de Cervantes','España'),(9,'Hippocrates','Grecia'),(10,'Ludwig Mies van der Rohe','Alemania'),(11,'Carlos López','Española'),(12,'María González','Argentina'),(13,'J.K. Rowling','Británica');
/*!40000 ALTER TABLE `Autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiantes`
--

DROP TABLE IF EXISTS `Estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiantes` (
  `lector_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`lector_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiantes`
--

LOCK TABLES `Estudiantes` WRITE;
/*!40000 ALTER TABLE `Estudiantes` DISABLE KEYS */;
INSERT INTO `Estudiantes` VALUES (1,'Juan','Perez','Calle 123','Ingeniería',20),(2,'Maria','Gomez','Av. Siempre Viva','Medicina',22),(3,'Carlos','Lopez','Calle Luna','Derecho',21),(4,'Ana','Martinez','Calle Sol','Arquitectura',23),(5,'Pedro','Sanchez','Av. Estrella','Economía',24),(6,'Lucia','Ramirez','Calle Mar','Psicología',22),(7,'Fernando','Torres','Av. Roca','Administración',25),(8,'Sofia','Diaz','Calle Río','Ingeniería',20),(9,'Luis','Fernandez','Av. Norte','Medicina',22),(10,'Elena','Mendoza','Calle Sur','Derecho',21),(11,'Andrea','Fernández','Calle 123, Ciudad A','Ingeniería Informática',22),(12,'Carlos','Ramírez','Av. Siempre Viva 456, Ciudad B','Ingeniería Informática',24),(13,'Lucía','Gómez','Pasaje 789, Ciudad C','Ingeniería Informática',23),(14,'Filippo','Galli','Calle Italia 456, Roma','Ingeniería Informática',25);
/*!40000 ALTER TABLE `Estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro_Autor`
--

DROP TABLE IF EXISTS `Libro_Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro_Autor` (
  `libro_id` int NOT NULL,
  `autor_id` int NOT NULL,
  PRIMARY KEY (`libro_id`,`autor_id`),
  KEY `autor_id_idx` (`autor_id`),
  CONSTRAINT `autor_id` FOREIGN KEY (`autor_id`) REFERENCES `Autores` (`autor_id`),
  CONSTRAINT `libro_id` FOREIGN KEY (`libro_id`) REFERENCES `Libros` (`libro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro_Autor`
--

LOCK TABLES `Libro_Autor` WRITE;
/*!40000 ALTER TABLE `Libro_Autor` DISABLE KEYS */;
INSERT INTO `Libro_Autor` VALUES (1,1),(2,2),(3,3),(8,4),(6,5),(5,6),(7,6),(10,7),(9,9),(4,10),(15,11),(15,12),(16,13),(17,13),(18,13),(19,13),(20,13),(21,13),(22,13);
/*!40000 ALTER TABLE `Libro_Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libros`
--

DROP TABLE IF EXISTS `Libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libros` (
  `libro_id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) DEFAULT NULL,
  `editorial` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`libro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libros`
--

LOCK TABLES `Libros` WRITE;
/*!40000 ALTER TABLE `Libros` DISABLE KEYS */;
INSERT INTO `Libros` VALUES (1,'Matemáticas Avanzadas','Alfa','Ciencias Exactas'),(2,'Biología Molecular','Beta','Ciencias Naturales'),(3,'Derecho Constitucional','Gama','Ciencias Sociales'),(4,'Arquitectura Moderna','Delta','Arte y Diseño'),(5,'Macroeconomía','Epsilon','Economía'),(6,'Psicología Clínica','Zeta','Salud'),(7,'Gestión Empresarial','Eta','Administración'),(8,'Física Cuántica','Theta','Ciencias Exactas'),(9,'Medicina Interna','Iota','Salud'),(10,'Historia Universal','Kappa','Historia'),(11,'Redes y Comunicaciones','Salamandra','Internet'),(12,'Seguridad en la Web','Salamandra','Internet'),(13,'Desarrollo de Aplicaciones Web','Salamandra','Internet'),(14,'Protocolos de Internet','Salamandra','Internet'),(15,'El Universo: Guía de viaje','Editorial Científica','Astronomía'),(16,'Harry Potter y la Piedra Filosofal','Salamandra','Fantasía'),(17,'Harry Potter y la Cámara Secreta','Salamandra','Fantasía'),(18,'Harry Potter y el Prisionero de Azkaban','Salamandra','Fantasía'),(19,'Harry Potter y el Cáliz de Fuego','Salamandra','Fantasía'),(20,'Harry Potter y la Orden del Fénix','Salamandra','Fantasía'),(21,'Harry Potter y el Misterio del Príncipe','Salamandra','Fantasía'),(22,'Harry Potter y las Reliquias de la Muerte','Salamandra','Fantasía');
/*!40000 ALTER TABLE `Libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamos`
--

DROP TABLE IF EXISTS `Prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamos` (
  `lector_id` int NOT NULL,
  `libro_id` int NOT NULL,
  `fecha_prestamo` datetime DEFAULT NULL,
  `fecha_devolucion` datetime DEFAULT NULL,
  `devuelto` tinyint DEFAULT NULL,
  PRIMARY KEY (`lector_id`,`libro_id`),
  KEY `libro_id_idx` (`libro_id`),
  CONSTRAINT `prestamo_lector_id` FOREIGN KEY (`lector_id`) REFERENCES `Estudiantes` (`lector_id`),
  CONSTRAINT `prestamo_libro_id` FOREIGN KEY (`libro_id`) REFERENCES `Libros` (`libro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamos`
--

LOCK TABLES `Prestamos` WRITE;
/*!40000 ALTER TABLE `Prestamos` DISABLE KEYS */;
INSERT INTO `Prestamos` VALUES (1,1,'2024-02-01 10:00:00','2024-02-15 10:00:00',1),(1,5,'2021-07-01 00:00:00','2021-07-16 00:00:00',1),(2,2,'2024-02-02 11:00:00','2024-02-16 11:00:00',0),(2,6,'2021-06-26 00:00:00','2021-07-16 00:00:00',1),(3,3,'2024-02-03 12:00:00','2024-02-17 12:00:00',1),(3,7,'2021-07-06 00:00:00','2021-07-16 00:00:00',0),(4,4,'2024-02-04 13:00:00','2024-02-18 13:00:00',0),(4,8,'2021-06-16 00:00:00','2021-07-16 00:00:00',0),(5,5,'2024-02-05 14:00:00','2024-02-19 14:00:00',1),(6,6,'2024-02-06 15:00:00','2024-02-20 15:00:00',0),(7,7,'2024-02-07 16:00:00','2024-02-21 16:00:00',1),(8,8,'2024-02-08 17:00:00','2024-02-22 17:00:00',0),(9,9,'2024-02-09 18:00:00','2024-02-23 18:00:00',1),(10,10,'2024-02-10 19:00:00','2024-02-24 19:00:00',0),(14,1,'2025-02-11 12:22:04','2025-02-26 12:22:04',0),(14,2,'2025-02-11 12:22:04','2025-03-03 12:22:04',0);
/*!40000 ALTER TABLE `Prestamos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-11 12:38:51
