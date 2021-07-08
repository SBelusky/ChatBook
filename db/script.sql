CREATE DATABASE  IF NOT EXISTS `chatbook` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `chatbook`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: chatbook
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `conversation`
--

DROP TABLE IF EXISTS `conversation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversation` (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `user_one` int NOT NULL,
  `user_two` int NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `conversation_ibfk_1` (`user_one`),
  KEY `conversation_ibfk_2` (`user_two`),
  CONSTRAINT `conversation_ibfk_1` FOREIGN KEY (`user_one`) REFERENCES `users` (`user_id`),
  CONSTRAINT `conversation_ibfk_2` FOREIGN KEY (`user_two`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversation`
--

LOCK TABLES `conversation` WRITE;
/*!40000 ALTER TABLE `conversation` DISABLE KEYS */;
INSERT INTO `conversation` VALUES (1,1,2),(3,1,3),(5,2,3),(7,5,3),(8,11,1);
/*!40000 ALTER TABLE `conversation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversation_reply`
--

DROP TABLE IF EXISTS `conversation_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversation_reply` (
  `cr_id` int NOT NULL AUTO_INCREMENT,
  `user_id_fk` int NOT NULL,
  `c_id_fk` int NOT NULL,
  `reply` text,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cr_id`),
  KEY `user_id_fk` (`user_id_fk`),
  KEY `c_id_fk` (`c_id_fk`),
  CONSTRAINT `conversation_reply_ibfk_1` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`),
  CONSTRAINT `conversation_reply_ibfk_2` FOREIGN KEY (`c_id_fk`) REFERENCES `conversation` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversation_reply`
--

LOCK TABLES `conversation_reply` WRITE;
/*!40000 ALTER TABLE `conversation_reply` DISABLE KEYS */;
INSERT INTO `conversation_reply` VALUES (1,1,1,'si tu?','2021-06-23 11:26:33'),(2,2,1,'hej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhehej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuhej som tuj som tuhej som tuhej som tuhej som tuhej som tuhej som tu','2021-06-23 11:26:45'),(3,2,1,'ako sa máš?','2021-06-30 15:34:20'),(4,1,1,'pohodka','2021-06-30 15:34:38'),(5,1,1,'čo nového?','2021-06-30 15:35:39'),(6,3,3,'chybaaaaaa','2021-06-30 15:35:39'),(7,1,1,'čo nového?','2021-07-06 10:42:37'),(8,1,1,'asdhajsdhajsdhsajd','2021-07-06 10:47:07'),(9,1,1,'fuj','2021-07-06 10:47:36'),(10,1,1,'asd','2021-07-06 10:47:42'),(11,1,1,'xx','2021-07-06 10:47:47'),(12,1,1,'prečo to nejde???','2021-07-06 10:49:19'),(13,1,1,'už fungujem trochu :D :D :D :D :D ','2021-07-06 10:52:27'),(14,1,1,'určite?','2021-07-06 11:31:05'),(15,1,3,'ticho :D','2021-07-06 11:53:44'),(16,11,8,'už to ide tuším','2021-07-06 11:59:58'),(17,1,8,'jop, ide :D','2021-07-06 12:00:15'),(18,1,1,'...','2021-07-06 12:00:40'),(19,1,1,'asd','2021-07-06 12:01:27'),(20,1,1,'a','2021-07-06 12:01:43'),(21,1,1,'x','2021-07-06 12:02:35'),(22,1,1,'asd','2021-07-06 12:03:07'),(23,1,1,'x','2021-07-06 12:05:13'),(24,1,1,'x','2021-07-06 12:05:41'),(25,1,1,'a','2021-07-06 12:07:21'),(26,1,1,'a','2021-07-06 12:08:39'),(27,1,1,'x','2021-07-06 12:09:02'),(28,1,1,'x','2021-07-06 12:12:46'),(29,1,1,'a','2021-07-06 12:12:50'),(30,1,1,'asd','2021-07-06 12:12:55');
/*!40000 ALTER TABLE `conversation_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Samuel','admin','samuel.belusky@gmail.com'),(2,'Barča','b','b@b.sk'),(3,'Lojzik','ahoj','lojzik.belusky@gmail.com'),(5,'Loasasasjzik','[B@329b1330','lojaaazik.belusky@gmail.com'),(6,'Baar','[B@1afe7ffa','lzik.belusky@gmail.com'),(8,'Baar','[B@2964cf8c','lziasdasdk.belusky@gmail.com'),(10,'Baar','$2a$10$9Y2QA/tfetK5rc0PnhR8JeDu/huUqLANVZ4a5dUJ7ODIek4rWCOuO','lziadk.belusky@gmail.com'),(11,'Samuel Beluský','admin','samuel.belusky@azet.com');
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

-- Dump completed on 2021-07-06 18:04:49
