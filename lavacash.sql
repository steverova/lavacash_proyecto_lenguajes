CREATE DATABASE  IF NOT EXISTS `db_lavacash` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_lavacash`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 208.109.41.231    Database: db_lavacash
-- ------------------------------------------------------
-- Server version	5.6.51-cll-lve

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
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `asunto` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comentario` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (47,'angularnuevo','angularnuevo@gmail.com','angularnuevo','angularnuevoji','2022-07-28 14:56:38',NULL,'2022-07-29 04:53:26'),(49,'nuevo react modificado','nuevo react@gmail.com','nuevo react','nuevo react','2022-07-19 13:06:20',NULL,NULL),(51,'nuevoasp modificado','nuevoasp@gmail.com','nuevoasp','nuevoasp','2022-07-19 14:14:25',NULL,NULL);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `failed_jobs`
--

DROP TABLE IF EXISTS `failed_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `failed_jobs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `connection` text COLLATE utf8_unicode_ci NOT NULL,
  `queue` text COLLATE utf8_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `failed_jobs`
--

LOCK TABLES `failed_jobs` WRITE;
/*!40000 ALTER TABLE `failed_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `failed_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (1,'2014_10_12_000000_create_users_table',1),(2,'2014_10_12_100000_create_password_resets_table',1),(3,'2019_08_19_000000_create_failed_jobs_table',1),(4,'2019_12_14_000001_create_personal_access_tokens_table',1),(5,'2022_07_28_165501_create_vehiculos_table',1);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_resets`
--

DROP TABLE IF EXISTS `password_resets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  KEY `password_resets_email_index` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_resets`
--

LOCK TABLES `password_resets` WRITE;
/*!40000 ALTER TABLE `password_resets` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_resets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_access_tokens`
--

DROP TABLE IF EXISTS `personal_access_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tokenable_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tokenable_id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `abilities` text COLLATE utf8_unicode_ci,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_access_tokens`
--

LOCK TABLES `personal_access_tokens` WRITE;
/*!40000 ALTER TABLE `personal_access_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_access_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reporte` (
  `tipo_servicio` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `detalle_cita` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `nombre_servicio` varchar(255) DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `precio` int(11) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tiempo` int(11) NOT NULL,
  `tipo_vehiculo` int(11) NOT NULL,
  PRIMARY KEY (`tipo_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte`
--

LOCK TABLES `reporte` WRITE;
/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cita`
--

DROP TABLE IF EXISTS `tb_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `servicio_id` int(11) NOT NULL,
  `vehiculo_id` int(11) NOT NULL,
  `tb_cita_ibfk_2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehiculo_id` (`vehiculo_id`),
  KEY `servicio_id` (`servicio_id`),
  KEY `FKk8qoyj8or78igd2j122nvin0a` (`tb_cita_ibfk_2`),
  CONSTRAINT `FKk8qoyj8or78igd2j122nvin0a` FOREIGN KEY (`tb_cita_ibfk_2`) REFERENCES `tb_servicio` (`id`),
  CONSTRAINT `tb_cita_ibfk_1` FOREIGN KEY (`vehiculo_id`) REFERENCES `tb_vehiculo` (`id`),
  CONSTRAINT `tb_cita_ibfk_2` FOREIGN KEY (`servicio_id`) REFERENCES `tb_servicio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cita`
--

LOCK TABLES `tb_cita` WRITE;
/*!40000 ALTER TABLE `tb_cita` DISABLE KEYS */;
INSERT INTO `tb_cita` VALUES (1,'2020-02-02','19:30:10','urge',50,7,NULL),(2,'2022-07-30','16:30:00','vehiculo nuevo',50,4,NULL),(3,'2023-01-01','11:00:00','lavado especial',50,6,NULL);
/*!40000 ALTER TABLE `tb_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cita_cita`
--

DROP TABLE IF EXISTS `tb_cita_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cita_cita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cita_padre` int(11) NOT NULL,
  `cita_hijo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cita_hijo` (`cita_hijo`),
  KEY `cita_padre` (`cita_padre`),
  CONSTRAINT `tb_cita_cita_ibfk_1` FOREIGN KEY (`cita_hijo`) REFERENCES `tb_cita` (`id`),
  CONSTRAINT `tb_cita_cita_ibfk_2` FOREIGN KEY (`cita_padre`) REFERENCES `tb_cita` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cita_cita`
--

LOCK TABLES `tb_cita_cita` WRITE;
/*!40000 ALTER TABLE `tb_cita_cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cita_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comentarios`
--

DROP TABLE IF EXISTS `tb_comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comentarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `comentario` varchar(300) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `disponibilidad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_idx` (`id_user`),
  KEY `FKmlykv2h9owwpgla1ntwuooye0` (`user_id`),
  CONSTRAINT `FKmlykv2h9owwpgla1ntwuooye0` FOREIGN KEY (`user_id`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_user`) REFERENCES `tb_usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comentarios`
--

LOCK TABLES `tb_comentarios` WRITE;
/*!40000 ALTER TABLE `tb_comentarios` DISABLE KEYS */;
INSERT INTO `tb_comentarios` VALUES (75,27,'ddddd;oli',NULL,'2022-07-03 15:38:36',1),(76,18,'eeeeeee;oli',NULL,'2022-07-03 15:39:01',1),(87,16,'visible;este es un comentario visible',NULL,'2022-07-21 22:16:08',1),(90,16,'sdas;asdsa',NULL,'2022-07-21 22:44:44',1);
/*!40000 ALTER TABLE `tb_comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_examen_fabricio`
--

DROP TABLE IF EXISTS `tb_examen_fabricio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_examen_fabricio` (
  `nombre` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` int(11) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `precio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_examen_fabricio`
--

LOCK TABLES `tb_examen_fabricio` WRITE;
/*!40000 ALTER TABLE `tb_examen_fabricio` DISABLE KEYS */;
INSERT INTO `tb_examen_fabricio` VALUES ('la negra',18,101,'tiene una linda forma de ser',50000,'2020-05-14'),('la negra1',22,10,'tiene una linda forma de ser',50000,'2020-05-14'),('la negra3',24,10,'tiene una linda forma de ser',50000,'2020-05-14'),('NET Core',37,10,'Prueba net core editado',5000,'2022-07-04'),('Prueba angular',38,10,'Prueba desde angular editado',5000,'2022-07-13');
/*!40000 ALTER TABLE `tb_examen_fabricio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_examen_steven`
--

DROP TABLE IF EXISTS `tb_examen_steven`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_examen_steven` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `asunto` varchar(45) NOT NULL,
  `comentario` varchar(200) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_examen_steven`
--

LOCK TABLES `tb_examen_steven` WRITE;
/*!40000 ALTER TABLE `tb_examen_steven` DISABLE KEYS */;
INSERT INTO `tb_examen_steven` VALUES (153,'nettttttaaaaaaaaaaa','net','net','net','2022-07-18 15:41:43'),(154,'uuuuu','uuuuu','uuuuuuu','uuuuuuuu','2022-07-15 23:09:54'),(160,'sasdasd','sxasx','sxaasx','asxasxa cscac cqwasdac csaca CSADEW  34REWF 3R43 4R34R 34R3 4R','2022-07-16 01:31:06'),(164,'php','php','php','php','2022-07-16 16:10:58'),(167,'steven','aaaa','aaa','aaaaaaaa','2022-07-19 02:15:49'),(168,'steven','aaaa','aaa','aaaaaaaa','2022-07-19 02:16:11'),(169,'steven','aaaa','aaa','aaaaaaaa','2022-07-19 02:16:19'),(170,'steven','aaaa','aaa','aaaaaaaa','2022-07-19 02:17:25'),(171,'steven','aaaa','aaa','aaaaaaaa','2022-07-19 02:17:56');
/*!40000 ALTER TABLE `tb_examen_steven` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_flotilla`
--

DROP TABLE IF EXISTS `tb_flotilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_flotilla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_flotilla`
--

LOCK TABLES `tb_flotilla` WRITE;
/*!40000 ALTER TABLE `tb_flotilla` DISABLE KEYS */;
INSERT INTO `tb_flotilla` VALUES (5,NULL),(10,NULL);
/*!40000 ALTER TABLE `tb_flotilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_persona`
--

DROP TABLE IF EXISTS `tb_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `cedula` varchar(255) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_persona`
--

LOCK TABLES `tb_persona` WRITE;
/*!40000 ALTER TABLE `tb_persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_servicio`
--

DROP TABLE IF EXISTS `tb_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_servicio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `tiempo` int(11) NOT NULL,
  `servicio_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_servicio`
--

LOCK TABLES `tb_servicio` WRITE;
/*!40000 ALTER TABLE `tb_servicio` DISABLE KEYS */;
INSERT INTO `tb_servicio` VALUES (50,3,'Maxi Lavado','Todo lo necesario para su auto en época de lluvias',47500,15,NULL),(52,1,'Lavado','Dejamos su auto como nuevo.',45000,10,NULL),(53,1,'Aspirado','Limpiecito por dentro, como debe ser.',2500,5,NULL),(54,2,'Lavaspira','Lavado y aspirado para su nave.',8000,25,NULL);
/*!40000 ALTER TABLE `tb_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_servicio_hijo`
--

DROP TABLE IF EXISTS `tb_servicio_hijo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_servicio_hijo` (
  `padre_id` int(11) NOT NULL,
  `hijo_id` int(11) NOT NULL,
  PRIMARY KEY (`hijo_id`,`padre_id`),
  KEY `fk_padre_idx` (`padre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_servicio_hijo`
--

LOCK TABLES `tb_servicio_hijo` WRITE;
/*!40000 ALTER TABLE `tb_servicio_hijo` DISABLE KEYS */;
INSERT INTO `tb_servicio_hijo` VALUES (50,52),(50,53),(54,52),(54,53);
/*!40000 ALTER TABLE `tb_servicio_hijo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `rol` varchar(45) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `contrasena_` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Joan','Zuñiga','joan@gmail.com','27100909','100 estee barrio diamantes','ADMIN','1234','1234',NULL),(16,'Steven','Rojas','steverova0594@gmail.com','88888888','Limon, Guacimo, Barrio Los Colegios. ','CLIENT','pokemon','pokemon','ba3f1656-c5b1-4980-a23f-06e09a413213.jpg'),(17,'Juan','Perez','JUAN@GMAIL.COM','2324234','DWCDSVCEF','CLIENT','4323','4323','0f58c0fc-ded3-4899-9bcf-e220aed93e4e.jpg'),(18,'Mario','Castro','aaaa@gmail.com','1121','dsdasd','CLIENT','1','1','684372d3-f4dc-47ab-98d3-8b691cc9c397.jpg'),(25,'maria','rojas','maria@gmail.com','45345','dsfsd','CLIENT','1234','1234','79e48a3e-238d-4752-ad70-f0dc4585be00.jpg'),(26,'Guillermo','Rojas','guillermo@qqq.com','234533','gdfgdfg','CLIENT','1234','1234','6c702625-0940-487a-a225-067b1ddbfc47.jpg'),(27,'Josue','Valverde','jopuse@QQQ.com','234234','wfdsfcsd','CLIENT','1234','1234','785ce883-0a18-4b21-858b-a63133e6acc9.jpg'),(28,'adan','sdasas','steverova0594@gmail.com','2324234','wdwqd','CLIENT','1234','1234',''),(29,'admin','admin','admin@gmail.com','admin','admin','ADMIN','admin','admin',NULL);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vehiculo`
--

DROP TABLE IF EXISTS `tb_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_vehiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` int(11) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `vehiculo_id` int(11) DEFAULT NULL,
  `cita` int(11) DEFAULT NULL,
  `flotilla_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `FKojuak9xm0dfn1vftjrpvfupyd` (`vehiculo_id`),
  KEY `FKfmlv329d55n5u40tswsga8cgb` (`cita`),
  KEY `FK2kjllmjegmp6idp6ukcaipdi2` (`flotilla_id`),
  CONSTRAINT `FKam89xpw0u3hi4ofelhhkntdd1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKfmlv329d55n5u40tswsga8cgb` FOREIGN KEY (`cita`) REFERENCES `tb_cita` (`id`),
  CONSTRAINT `FKojuak9xm0dfn1vftjrpvfupyd` FOREIGN KEY (`vehiculo_id`) REFERENCES `tb_cita` (`id`),
  CONSTRAINT `tb_vehiculo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vehiculo`
--

LOCK TABLES `tb_vehiculo` WRITE;
/*!40000 ALTER TABLE `tb_vehiculo` DISABLE KEYS */;
INSERT INTO `tb_vehiculo` VALUES (4,12,'695826','Toyota','Prius','super veloz',1,NULL,NULL,0),(6,23,'13321321','Hyundai ','i10','pochomovil',1,NULL,NULL,0),(7,99,'284675','Ferrari','f40','color rojo',1,NULL,NULL,0);
/*!40000 ALTER TABLE `tb_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `placa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `precio` double(8,2) NOT NULL,
  `tipo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fecha` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `creado` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (16,'select prueba','qweqwe','qwe','233',20000.00,'02 - 4x4','2022-07-30',NULL,NULL,'2022-08-10'),(17,'probando select angular','qweqwe','qweqwe','qweee',20333.00,'03 - variado','2022-07-22',NULL,NULL,NULL),(18,'prueba net select','qweqwe','qwe','232323',200000.00,'02 - 4x4',NULL,NULL,NULL,'2022-07-29'),(25,'android lunes 4','toyota 1','2000 1','122122 1',999999.99,'11','2012-11-11',NULL,NULL,NULL),(27,'android 55','erree','erer','1233',123.00,'12','2012-12-12',NULL,NULL,NULL),(28,'prueba final modificado','qweee','qwee','eeee',123122.00,'12','2012-11-11',NULL,NULL,NULL);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_lavacash'
--
/*!50003 DROP FUNCTION IF EXISTS `CAP_FIRST` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` FUNCTION `CAP_FIRST`(input VARCHAR(255)) RETURNS varchar(255) CHARSET latin1
    DETERMINISTIC
BEGIN
	DECLARE len INT;
	DECLARE i INT;

	SET len   = CHAR_LENGTH(input);
	SET input = LOWER(input);
	SET i = 0;

	WHILE (i < len) DO
		IF (MID(input,i,1) = ' ' OR i = 0) THEN
			IF (i < len) THEN
				SET input = CONCAT(
					LEFT(input,i),
					UPPER(MID(input,i + 1,1)),
					RIGHT(input,len - i - 1)
				);
			END IF;
		END IF;
		SET i = i + 1;
	END WHILE;

	RETURN input;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CHANGE_PASSWORD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `CHANGE_PASSWORD`(
IN $correo varchar(45), 
IN $contrasena varchar(45)
)
begin
SET SQL_SAFE_UPDATES = 0;
update  tb_usuario set contrasena = $contrasena, contrasena_ = $contrasena where correo = $correo;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EMAIL_EXIST` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `EMAIL_EXIST`(IN $correo varchar(45))
begin
SELECT EXISTS(SELECT * FROM tb_usuario WHERE correo = $correo) as RESULT;  
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_COMMENTS_CLIENT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_COMMENTS_CLIENT`()
begin
select (tb_usuario.id, tb_usuario.nombre, tb_usuario.apellido, tb_usuario.image, tb_comentarios.comentario) from tb_usuario inner join tb_comentarios on tb_usuario.id = tb_comentarios.id_user;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_COMMENTS_CLIENTS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_COMMENTS_CLIENTS`()
begin
select tb_usuario.id, tb_usuario.nombre, tb_usuario.apellido, tb_usuario.image, tb_comentarios.comentario, tb_comentarios.disponibilidad
from tb_usuario inner join tb_comentarios on tb_usuario.id = tb_comentarios.id_user;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_COMMENTS_CLIENTS2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_COMMENTS_CLIENTS2`()
begin
select tb_comentarios.id as id_comentario, tb_usuario.id, tb_usuario.nombre, tb_usuario.apellido, tb_usuario.image, tb_comentarios.comentario, tb_comentarios.disponibilidad
from tb_usuario inner join tb_comentarios on tb_usuario.id = tb_comentarios.id_user;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_COMMENTS_CLIENTS_PAGE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_COMMENTS_CLIENTS_PAGE`(IN $pag int)
begin
DECLARE setItem INT;
SET setItem = $pag*4;
select tb_usuario.id, tb_usuario.nombre, tb_usuario.apellido, tb_usuario.image, tb_comentarios.comentario,tb_comentarios.fecha, tb_comentarios.disponibilidad
from tb_usuario inner join tb_comentarios on tb_usuario.id = tb_comentarios.id_user where tb_comentarios.disponibilidad = 1 order by tb_comentarios.fecha desc limit setItem, 4 ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_COMMENTS_CLIENTS_PAGE_ORDER` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_COMMENTS_CLIENTS_PAGE_ORDER`(IN $pag int)
begin
DECLARE setItem INT;
SET setItem = $pag*4;
select tb_usuario.id, tb_usuario.nombre, tb_usuario.apellido, tb_usuario.image, tb_comentarios.comentario
from tb_usuario inner join tb_comentarios on tb_usuario.id = tb_comentarios.id_user ORDER BY tb_comentarios.id desc limit setItem, 4;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_USER_VERIFY` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `GET_USER_VERIFY`(
IN $correo varchar(45),
IN $contrasena varchar(45))
begin 
select * from tb_usuario where correo = $correo and contrasena = $contrasena;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PASSWORD_VALIDATE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `PASSWORD_VALIDATE`(IN $password varchar(45))
begin
SELECT EXISTS(SELECT * FROM tb_usuario WHERE contrasena  = $password) as RESULT;  
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_examen_fabricio_create` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_examen_fabricio_create`(
	IN p_nombre varchar(50),
    IN p_tipo INT(11),
    IN p_descripcion varchar(250),
    IN p_precio INT(11),
    IN fecha DATE
)
BEGIN
	INSERT INTO tb_examen_fabricio (nombre, tipo, descripcion, precio, fecha)
    VALUES (p_nombre, p_tipo, p_descripcion, p_precio, p_fecha);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_examen_fabricio_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_examen_fabricio_update`(
	IN p_id int(11),
    IN p_nombre varchar(50),
    IN p_tipo INT(11),
    IN p_descripcion varchar(250),
    IN p_precio INT(11),
    IN fecha DATE
)
BEGIN
	UPDATE tb_examen_fabricio 
    SET nombre = p_nombre,
		tipo = p_tipo,
        descripcion = p_descripcion,
        precio = p_precio,
        fecha = p_fecha
    WHERE id = p_id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_hijo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_insertar_hijo`(
	IN p_id_padre INT(11),
    IN p_id_hijo INT(11)
)
BEGIN
	insert into tb_servicio_hijo 
		(padre_id, hijo_id)
        values 
        (p_id_padre, p_id_hijo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_recuperar_hijos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_recuperar_hijos`(
	IN p_id_padre INT(11)
)
BEGIN
	select id, nombre, descripcion 
		from tb_servicio s
			inner join tb_servicio_hijo sh
			on s.id = sh.hijo_id
        where sh.padre_id = p_id_padre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_reiniciar_hijos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_reiniciar_hijos`(
	IN p_id_padre INT(11)
)
BEGIN
	delete from tb_servicio_hijo 
        where padre_id = p_id_padre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_reporte_select` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `sp_reporte_select`()
BEGIN
	select
		CT.fecha as fecha,
        CT.hora as hora,
        CT.detalle as detalleCita,
        VC.tipo as tipoVehiculo,
        VC.placa as placa,
        VC.marca as marca,
        VC.modelo as modelo,
        US.nombre as nombreUsuario,
        US.apellido as apellido,
        US.correo as correo,
        US.telefono as telefono,
        SV.tipo as tipoServicio,
        SV.nombre as nombreServicio,
        SV.precio as precio,
        SV.tiempo as tiempo
    from tb_cita CT
		inner join tb_vehiculo VC
        on CT.vehiculo_id = VC.id
        inner join tb_usuario US
        on VC.usuario_id = US.id
        inner join tb_servicio SV
        on CT.servicio_id = SV.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UPDATE_AVAILABILITY` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `UPDATE_AVAILABILITY`(IN $id int)
begin
IF (select disponibilidad from tb_comentarios where id = $id) = 1 then 
UPDATE tb_comentarios
SET disponibilidad = 0 where id = $id;
select 1 as result;
Else
UPDATE tb_comentarios
SET disponibilidad = 1 where id = $id;
select 1 as result;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UppercaseFirstLetter` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`lavacash`@`%` PROCEDURE `UppercaseFirstLetter`()
begin
UPDATE tb_usuario SET nombre = CAP_FIRST(nombre);
UPDATE tb_usuario SET apellido = CAP_FIRST(apellido);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-16 15:53:51
