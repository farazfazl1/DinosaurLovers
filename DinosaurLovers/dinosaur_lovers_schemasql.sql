CREATE DATABASE  IF NOT EXISTS `dinosaur_lovers_schema` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dinosaur_lovers_schema`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: dinosaur_lovers_schema
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `dinosaurs`
--

DROP TABLE IF EXISTS `dinosaurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dinosaurs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `diet` varchar(200) NOT NULL,
  `facts` varchar(400) NOT NULL,
  `habitat` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `size` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdly51p9xug90kunnyllsm9msk` (`user_id`),
  CONSTRAINT `FKdly51p9xug90kunnyllsm9msk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dinosaurs`
--

LOCK TABLES `dinosaurs` WRITE;
/*!40000 ALTER TABLE `dinosaurs` DISABLE KEYS */;
INSERT INTO `dinosaurs` VALUES (2,'2022-05-14 16:23:26.655000','Texas BBQ','Loves to be killed by predators ','Africa','Brontosaurus',1200,NULL,1),(4,'2022-05-16 10:21:45.608000','Corn','Loves to eat corn\r\n','Asia','TyrNaliko ajira',900,NULL,1),(5,'2022-05-16 12:32:22.655000','In N out','Goes to in n out every day','North East Asia','SurpaloSores',12200,NULL,1),(7,'2022-05-16 13:45:23.385000','Kangaroos','It hunts Kangaroos everyday','Australia','SuperDino',2000,NULL,4);
/*!40000 ALTER TABLE `dinosaurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(128) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2022-05-14 14:41:37.746000','faraz.fazlbusiness@gmail.com','$2a$10$S1jwQGr5pxjMNFp6haCTxuh/ZZ2bXgFUwihR6mhjJrg127ovW60XC',NULL,'farazfazl'),(2,'2022-05-14 16:30:15.018000','jackson@gmail.com','$2a$10$8oSBEkjnqRVmTkJuWd0XtuD80BGAap1l1/TYdb3tq9.LkI8GE2k5S',NULL,'jacksonBrown'),(3,'2022-05-16 10:59:51.322000','faraz.collegework@gmail.com','$2a$10$xu4bpsZi7PmdeWFsUUp03uLJI5HEesi/XKODkD47snDQNoKwDIL5a',NULL,'lululemon'),(4,'2022-05-16 13:44:46.142000','hane@gmail.com','$2a$10$SoZZ.DpmJVWfh3zbR4odcuLHyY4CVOid.6Nhup9A1BU.4yyObGErO',NULL,'fafafa');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-16 13:46:57
