-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (arm64)
--
-- Host: localhost    Database: company
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_code` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `position` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `discharge_date` datetime DEFAULT NULL,
  `salary` decimal(6,0) DEFAULT NULL,
  `commission` decimal(6,0) DEFAULT NULL,
  `dept_nro` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`emp_code`),
  KEY `dept_nro` (`dept_nro`),
  CONSTRAINT `dept_nro` FOREIGN KEY (`dept_nro`) REFERENCES `department` (`dept_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('E-0001','César','Piñero','Vendedor','2018-05-12 00:00:00',80000,15000,'D-000-4'),('E-0002','Yosep','Kowaleski','Analista','2015-07-14 00:00:00',140000,0,'D-000-2'),('E-0003','Mariela','Barrios','Director','2014-06-05 00:00:00',185000,0,'D-000-3'),('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03 00:00:00',85000,10000,'D-000-4'),('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03 00:00:00',83000,10000,'D-000-4'),('E-0006','Mito','Barchuk','Presidente','2014-06-05 00:00:00',190000,0,'D-000-3'),('E-0007','Emilio','Galarza','Desarrollador','2014-08-02 00:00:00',60000,0,'D-000-1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-16 17:02:23
