-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: discotheque
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DJ`
--

DROP TABLE IF EXISTS `DJ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DJ` (
  `dj_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `salaire` int(11) NOT NULL,
  `date_naissance` date NOT NULL,
  `employe_id` int(11) NOT NULL,
  PRIMARY KEY (`dj_id`),
  KEY `FK_DJ_employe_id` (`employe_id`),
  CONSTRAINT `FK_DJ_employe_id` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DJ`
--

LOCK TABLES `DJ` WRITE;
/*!40000 ALTER TABLE `DJ` DISABLE KEYS */;
/*!40000 ALTER TABLE `DJ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batiment`
--

DROP TABLE IF EXISTS `batiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batiment` (
  `batiment_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `discotheque_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`batiment_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `FK_batiment_discotheque_id` (`discotheque_id`),
  CONSTRAINT `FK_batiment_discotheque_id` FOREIGN KEY (`discotheque_id`) REFERENCES `discotheque` (`discotheque_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batiment`
--

LOCK TABLES `batiment` WRITE;
/*!40000 ALTER TABLE `batiment` DISABLE KEYS */;
INSERT INTO `batiment` VALUES (1,'Hope',NULL),(2,'Jessica',NULL),(3,'Amy',NULL),(4,'Vivien',NULL),(5,'Jennifer',NULL),(6,'Daniel',NULL),(7,'Desiree',NULL),(8,'Hunter',NULL),(9,'Jordan',NULL),(10,'Charity',NULL),(11,'Raven',NULL),(12,'Victor',NULL),(13,'Uriel',NULL),(14,'Camille',NULL),(15,'Mark',NULL),(16,'Germane',NULL),(17,'Barrett',NULL),(18,'Kuame',NULL),(19,'Caesar',NULL),(20,'Chiquita',NULL),(21,'Marny',NULL),(22,'Chandler',NULL),(23,'Ignacia',NULL),(24,'Jakeem',NULL),(25,'Paul',NULL),(26,'Marshall',NULL),(27,'Michael',NULL),(28,'Gloria',NULL),(29,'Hilda',NULL),(30,'Harrison',NULL),(31,'George',NULL),(32,'Lucy',NULL),(33,'Thane',NULL),(34,'Wang',NULL),(35,'Angelica',NULL),(36,'Lenore',NULL),(37,'Priscilla',NULL),(38,'Jack',NULL),(39,'Deacon',NULL),(40,'Kelsie',NULL),(41,'Hedley',NULL),(42,'Xyla',NULL),(43,'Alexander',NULL),(44,'Solomon',NULL),(45,'Ray',NULL),(46,'Gabriel',NULL),(47,'Suki',NULL),(48,'Branden',NULL),(49,'Kylee',NULL),(50,'Arsenio',NULL),(51,'Barry',NULL),(52,'Rhonda',NULL),(53,'Risa',NULL),(54,'Yoshi',NULL),(55,'Yuli',NULL),(56,'Melyssa',NULL),(57,'Keely',NULL),(58,'Brian',NULL),(59,'Xena',NULL),(60,'Kaden',NULL),(91,'Murphy',NULL),(92,'Candace',NULL),(93,'Rinah',NULL),(94,'Melvin',NULL),(95,'Thaddeus',NULL),(96,'Hilel',NULL),(97,'Adrienne',NULL),(98,'Sarah',NULL),(99,'Kenyon',NULL),(100,'Signe',NULL);
/*!40000 ALTER TABLE `batiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanson`
--

DROP TABLE IF EXISTS `chanson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chanson` (
  `chanson_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `artiste` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`chanson_id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanson`
--

LOCK TABLES `chanson` WRITE;
/*!40000 ALTER TABLE `chanson` DISABLE KEYS */;
/*!40000 ALTER TABLE `chanson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `derouler`
--

DROP TABLE IF EXISTS `derouler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `derouler` (
  `location_id` int(11) NOT NULL,
  `soiree_id` int(11) NOT NULL,
  PRIMARY KEY (`location_id`,`soiree_id`),
  KEY `FK_derouler_soiree_id` (`soiree_id`),
  CONSTRAINT `FK_derouler_location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FK_derouler_soiree_id` FOREIGN KEY (`soiree_id`) REFERENCES `soiree` (`soiree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `derouler`
--

LOCK TABLES `derouler` WRITE;
/*!40000 ALTER TABLE `derouler` DISABLE KEYS */;
/*!40000 ALTER TABLE `derouler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discotheque`
--

DROP TABLE IF EXISTS `discotheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discotheque` (
  `discotheque_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `horaire_ouverture` time DEFAULT NULL,
  `horaire_fermeture` time DEFAULT NULL,
  PRIMARY KEY (`discotheque_id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discotheque`
--

LOCK TABLES `discotheque` WRITE;
/*!40000 ALTER TABLE `discotheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `discotheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employe` (
  `employe_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `salaire` int(11) NOT NULL,
  `poste` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  PRIMARY KEY (`employe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe`
--

LOCK TABLES `employe` WRITE;
/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipement`
--

DROP TABLE IF EXISTS `equipement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipement` (
  `equipement_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`equipement_id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipement`
--

LOCK TABLES `equipement` WRITE;
/*!40000 ALTER TABLE `equipement` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equiper`
--

DROP TABLE IF EXISTS `equiper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equiper` (
  `piece_id` int(11) NOT NULL,
  `equipement_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_id`,`equipement_id`),
  KEY `FK_equiper_equipement_id` (`equipement_id`),
  CONSTRAINT `FK_equiper_equipement_id` FOREIGN KEY (`equipement_id`) REFERENCES `equipement` (`equipement_id`),
  CONSTRAINT `FK_equiper_piece_id` FOREIGN KEY (`piece_id`) REFERENCES `piece` (`piece_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equiper`
--

LOCK TABLES `equiper` WRITE;
/*!40000 ALTER TABLE `equiper` DISABLE KEYS */;
/*!40000 ALTER TABLE `equiper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jouer`
--

DROP TABLE IF EXISTS `jouer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jouer` (
  `dj_id` int(11) NOT NULL,
  `chanson_id` int(11) NOT NULL,
  PRIMARY KEY (`dj_id`,`chanson_id`),
  KEY `FK_jouer_chanson_id` (`chanson_id`),
  CONSTRAINT `FK_jouer_chanson_id` FOREIGN KEY (`chanson_id`) REFERENCES `chanson` (`chanson_id`),
  CONSTRAINT `FK_jouer_dj_id` FOREIGN KEY (`dj_id`) REFERENCES `DJ` (`dj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jouer`
--

LOCK TABLES `jouer` WRITE;
/*!40000 ALTER TABLE `jouer` DISABLE KEYS */;
/*!40000 ALTER TABLE `jouer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `prix` decimal(15,3) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`location_id`),
  KEY `FK_location_client_id` (`client_id`),
  CONSTRAINT `FK_location_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `louer`
--

DROP TABLE IF EXISTS `louer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `louer` (
  `piece_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_id`,`location_id`),
  KEY `FK_louer_location_id` (`location_id`),
  CONSTRAINT `FK_louer_location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FK_louer_piece_id` FOREIGN KEY (`piece_id`) REFERENCES `piece` (`piece_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `louer`
--

LOCK TABLES `louer` WRITE;
/*!40000 ALTER TABLE `louer` DISABLE KEYS */;
/*!40000 ALTER TABLE `louer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participer`
--

DROP TABLE IF EXISTS `participer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participer` (
  `soiree_id` int(11) NOT NULL,
  `dj_id` int(11) NOT NULL,
  PRIMARY KEY (`soiree_id`,`dj_id`),
  KEY `FK_participer_dj_id` (`dj_id`),
  CONSTRAINT `FK_participer_dj_id` FOREIGN KEY (`dj_id`) REFERENCES `DJ` (`dj_id`),
  CONSTRAINT `FK_participer_soiree_id` FOREIGN KEY (`soiree_id`) REFERENCES `soiree` (`soiree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participer`
--

LOCK TABLES `participer` WRITE;
/*!40000 ALTER TABLE `participer` DISABLE KEYS */;
/*!40000 ALTER TABLE `participer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piece`
--

DROP TABLE IF EXISTS `piece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piece` (
  `piece_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `acces` tinyint(1) DEFAULT NULL,
  `batiment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`piece_id`),
  KEY `FK_piece_batiment_id` (`batiment_id`),
  CONSTRAINT `FK_piece_batiment_id` FOREIGN KEY (`batiment_id`) REFERENCES `batiment` (`batiment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piece`
--

LOCK TABLES `piece` WRITE;
/*!40000 ALTER TABLE `piece` DISABLE KEYS */;
/*!40000 ALTER TABLE `piece` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `produit_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prix` decimal(15,3) DEFAULT NULL,
  `nombre` int(11) DEFAULT NULL,
  `vente_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`produit_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `FK_produit_vente_id` (`vente_id`),
  KEY `FK_produit_type_id` (`type_id`),
  CONSTRAINT `FK_produit_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`),
  CONSTRAINT `FK_produit_vente_id` FOREIGN KEY (`vente_id`) REFERENCES `vente` (`vente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soiree`
--

DROP TABLE IF EXISTS `soiree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soiree` (
  `soiree_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `theme` varchar(50) NOT NULL,
  `date_soiree` date NOT NULL,
  `reduction` float DEFAULT NULL,
  `prix` decimal(15,3) DEFAULT NULL,
  `batiment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`soiree_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `FK_soiree_batiment_id` (`batiment_id`),
  CONSTRAINT `FK_soiree_batiment_id` FOREIGN KEY (`batiment_id`) REFERENCES `batiment` (`batiment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soiree`
--

LOCK TABLES `soiree` WRITE;
/*!40000 ALTER TABLE `soiree` DISABLE KEYS */;
/*!40000 ALTER TABLE `soiree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travailler`
--

DROP TABLE IF EXISTS `travailler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travailler` (
  `employe_id` int(11) NOT NULL,
  `soiree_id` int(11) NOT NULL,
  PRIMARY KEY (`employe_id`,`soiree_id`),
  KEY `FK_travailler_soiree_id` (`soiree_id`),
  CONSTRAINT `FK_travailler_employe_id` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`),
  CONSTRAINT `FK_travailler_soiree_id` FOREIGN KEY (`soiree_id`) REFERENCES `soiree` (`soiree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travailler`
--

LOCK TABLES `travailler` WRITE;
/*!40000 ALTER TABLE `travailler` DISABLE KEYS */;
/*!40000 ALTER TABLE `travailler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venir`
--

DROP TABLE IF EXISTS `venir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venir` (
  `nombre_client` int(11) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `soiree_id` int(11) NOT NULL,
  PRIMARY KEY (`client_id`,`soiree_id`),
  KEY `FK_venir_soiree_id` (`soiree_id`),
  CONSTRAINT `FK_venir_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `FK_venir_soiree_id` FOREIGN KEY (`soiree_id`) REFERENCES `soiree` (`soiree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venir`
--

LOCK TABLES `venir` WRITE;
/*!40000 ALTER TABLE `venir` DISABLE KEYS */;
/*!40000 ALTER TABLE `venir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vente`
--

DROP TABLE IF EXISTS `vente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vente` (
  `vente_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`vente_id`),
  KEY `FK_vente_client_id` (`client_id`),
  CONSTRAINT `FK_vente_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vente`
--

LOCK TABLES `vente` WRITE;
/*!40000 ALTER TABLE `vente` DISABLE KEYS */;
/*!40000 ALTER TABLE `vente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-20 11:37:27
