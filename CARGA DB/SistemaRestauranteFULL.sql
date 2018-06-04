-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemarestaurante
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `camarero`
--

DROP TABLE IF EXISTS `camarero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camarero` (
  `idCamarero` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCamarero`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camarero`
--

LOCK TABLES `camarero` WRITE;
/*!40000 ALTER TABLE `camarero` DISABLE KEYS */;
INSERT INTO `camarero` VALUES (1,111111111,'Matias','Torsello'),(2,111111112,'Juan Pablo','Federico'),(3,111111113,'Lucio','Trucco'),(4,111111114,'Ruben','Gomez');
/*!40000 ALTER TABLE `camarero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoCliente` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `numHabitacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_Cliente_TipoCliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_Cliente_TipoCliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,39276649,'Matias','Torsello',1),(2,1,39872663,'Lucio','Trucco',2),(3,2,39105048,'Juan Pablo','Federico',3),(4,3,34567890,'Nicolas','Gomez',4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `idComanda` int(11) NOT NULL AUTO_INCREMENT,
  `idMesa` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`idComanda`),
  KEY `fk_Comanda_Mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_Comanda_Mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,1,'2018-05-15 16:51:56','\0'),(2,1,'2018-05-15 17:13:09','\0'),(3,1,'2018-05-20 12:56:39','\0'),(4,1,'2018-05-20 14:51:46','\0'),(5,1,'2017-06-04 12:54:33','\0'),(6,1,'2018-05-15 00:00:00','\0'),(7,2,'2018-05-17 10:00:00','\0'),(8,1,'2018-05-10 20:00:00','\0'),(9,2,'2018-05-20 01:00:00','\0'),(10,3,'2018-05-20 02:00:00','\0'),(11,3,'2018-05-15 03:00:00','\0'),(12,3,'2018-05-18 03:00:00','\0'),(13,4,'2018-05-14 04:00:00','\0'),(14,4,'2018-05-13 05:00:00','\0'),(15,5,'2018-05-20 06:00:00','\0'),(16,1,'2018-05-25 07:00:00','\0'),(17,1,'2018-05-20 08:00:00','\0'),(18,1,'2018-04-20 10:00:00','\0'),(19,3,'2018-04-20 15:00:00','\0'),(20,1,'2018-04-10 14:00:00','\0'),(21,4,'2018-04-15 14:00:00','\0'),(22,2,'2018-04-02 17:00:00','\0'),(23,1,'2018-05-28 15:09:00','\0'),(24,1,'2018-05-28 15:13:58','\0'),(25,2,'2018-05-28 15:17:23','\0'),(26,2,'2018-05-28 15:17:39','\0');
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversion`
--

DROP TABLE IF EXISTS `conversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conversion` (
  `idConversion` int(11) NOT NULL AUTO_INCREMENT,
  `unidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idConversion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversion`
--

LOCK TABLES `conversion` WRITE;
/*!40000 ALTER TABLE `conversion` DISABLE KEYS */;
INSERT INTO `conversion` VALUES (1,'Kg'),(2,'Gr'),(3,'L'),(4,'Ml');
/*!40000 ALTER TABLE `conversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `idIngrediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `unidad` varchar(35) DEFAULT NULL,
  `unidadCompra` double DEFAULT NULL,
  `unidadConsumo` double DEFAULT NULL,
  `idConversion` bigint(20) NOT NULL,
  PRIMARY KEY (`idIngrediente`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'Carne','carnes','kg',NULL,NULL,0),(2,'Pollo','carnes','kg',NULL,NULL,0),(3,'Tomate','verdura','kg',NULL,NULL,0);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemcomanda`
--

DROP TABLE IF EXISTS `itemcomanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemcomanda` (
  `idItemComanda` int(11) NOT NULL AUTO_INCREMENT,
  `idComanda` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idItemComanda`,`idComanda`,`idProducto`),
  KEY `fk_ItemComanda_Comanda1_idx` (`idComanda`),
  KEY `fk_ItemComanda_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_ItemComanda_Comanda1` FOREIGN KEY (`idComanda`) REFERENCES `comanda` (`idComanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemComanda_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemcomanda`
--

LOCK TABLES `itemcomanda` WRITE;
/*!40000 ALTER TABLE `itemcomanda` DISABLE KEYS */;
INSERT INTO `itemcomanda` VALUES (1,1,3,2),(2,2,1,2),(3,3,3,2),(4,4,1,3),(5,1,1,1),(6,1,1,1),(7,1,1,2),(8,2,2,2),(9,2,2,2),(10,2,3,1),(11,3,2,1),(12,1,3,3),(13,5,3,2),(14,5,2,2),(15,6,2,3),(16,6,1,2),(17,6,1,1),(18,3,2,3),(19,3,3,3),(20,3,3,2),(21,2,2,2),(22,23,3,1),(23,23,1,2),(24,24,1,1),(25,25,2,1),(26,25,1,1),(27,26,1,1);
/*!40000 ALTER TABLE `itemcomanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemlistaprecio`
--

DROP TABLE IF EXISTS `itemlistaprecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemlistaprecio` (
  `idItemListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `idListaPrecio` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idItemListaPrecio`,`idListaPrecio`,`idProducto`),
  KEY `fk_ItemListaPrecio_Producto1_idx` (`idProducto`),
  KEY `fk_ItemListaPrecio_ListaPrecio1_idx` (`idListaPrecio`),
  CONSTRAINT `fk_ItemListaPrecio_ListaPrecio1` FOREIGN KEY (`idListaPrecio`) REFERENCES `listaprecio` (`idListaPrecio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemListaPrecio_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlistaprecio`
--

LOCK TABLES `itemlistaprecio` WRITE;
/*!40000 ALTER TABLE `itemlistaprecio` DISABLE KEYS */;
INSERT INTO `itemlistaprecio` VALUES (1,1,1,50),(2,2,1,60),(3,3,1,70),(4,4,1,80),(5,5,1,90),(6,1,2,150),(7,2,2,160),(8,3,2,170),(9,4,2,180),(10,5,2,190),(11,1,3,130),(12,2,3,140),(13,3,3,150),(14,4,3,160),(15,5,3,170),(16,1,4,100),(17,2,4,110),(18,3,4,120),(19,4,4,130),(20,5,4,140),(21,1,5,110),(22,2,5,120),(23,3,5,130),(24,4,5,140),(25,5,5,150),(26,1,6,40),(27,2,6,50),(28,3,6,60),(29,4,6,70),(30,5,6,80),(31,1,7,30),(32,2,7,40),(33,3,7,50),(34,4,7,60),(35,5,7,70),(36,1,8,60),(37,2,8,70),(38,3,8,80),(39,4,8,90),(40,5,8,100),(41,1,9,70),(42,2,9,80),(43,3,9,90),(44,4,9,100),(45,5,9,110),(46,1,10,60),(47,2,10,70),(48,3,10,80),(49,4,10,90),(50,5,10,100),(51,1,11,70),(52,2,11,80),(53,3,11,90),(54,4,11,100),(55,5,11,110),(56,1,12,80),(57,2,12,90),(58,3,12,100),(59,4,12,110),(60,5,12,120),(61,1,13,60),(62,2,13,70),(63,3,13,80),(64,4,13,90),(65,5,13,100),(66,1,14,60),(67,2,14,70),(68,3,14,80),(69,4,14,90),(70,5,14,100);
/*!40000 ALTER TABLE `itemlistaprecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemmenu`
--

DROP TABLE IF EXISTS `itemmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemmenu` (
  `idMenu` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`,`idProducto`),
  KEY `fk_ItemMenu_Menu1_idx` (`idMenu`),
  KEY `fk_ItemMenu_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_ItemMenu_Menu1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemMenu_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemmenu`
--

LOCK TABLES `itemmenu` WRITE;
/*!40000 ALTER TABLE `itemmenu` DISABLE KEYS */;
INSERT INTO `itemmenu` VALUES (1,1),(2,2),(3,1);
/*!40000 ALTER TABLE `itemmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemreceta`
--

DROP TABLE IF EXISTS `itemreceta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemreceta` (
  `idItemReceta` int(11) NOT NULL AUTO_INCREMENT,
  `idReceta` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idItemReceta`,`idReceta`,`idIngrediente`),
  KEY `fk_ItemReceta_Ingrediente1_idx` (`idIngrediente`),
  KEY `fk_ItemReceta_Receta1_idx` (`idReceta`),
  CONSTRAINT `fk_ItemReceta_Ingrediente1` FOREIGN KEY (`idIngrediente`) REFERENCES `ingrediente` (`idIngrediente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemReceta_Receta1` FOREIGN KEY (`idReceta`) REFERENCES `receta` (`idReceta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemreceta`
--

LOCK TABLES `itemreceta` WRITE;
/*!40000 ALTER TABLE `itemreceta` DISABLE KEYS */;
INSERT INTO `itemreceta` VALUES (1,1,3,100),(2,2,2,200),(3,1,2,40),(4,3,1,100);
/*!40000 ALTER TABLE `itemreceta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemrubro`
--

DROP TABLE IF EXISTS `itemrubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemrubro` (
  `idSubRubro` int(11) NOT NULL,
  `idRubro` int(11) NOT NULL,
  PRIMARY KEY (`idSubRubro`,`idRubro`),
  KEY `fk_Rubro_SubRubro_SubRubro1_idx` (`idSubRubro`),
  KEY `fk_Rubro_SubRubro_Rubro1_idx` (`idRubro`),
  CONSTRAINT `fk_Rubro_SubRubro_Rubro1` FOREIGN KEY (`idRubro`) REFERENCES `rubro` (`idRubro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rubro_SubRubro_SubRubro1` FOREIGN KEY (`idSubRubro`) REFERENCES `subrubro` (`idSubRubro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemrubro`
--

LOCK TABLES `itemrubro` WRITE;
/*!40000 ALTER TABLE `itemrubro` DISABLE KEYS */;
INSERT INTO `itemrubro` VALUES (1,2),(2,3),(3,1);
/*!40000 ALTER TABLE `itemrubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemticket`
--

DROP TABLE IF EXISTS `itemticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemticket` (
  `idItemTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `idTicket` int(11) NOT NULL,
  `precioUnitario` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idItemTicket`,`idProducto`,`idTicket`),
  KEY `fk_ItemTicket_Producto1_idx` (`idProducto`),
  KEY `fk_ItemTicket_Ticket1_idx` (`idTicket`),
  CONSTRAINT `fk_ItemTicket_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemTicket_Ticket1` FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemticket`
--

LOCK TABLES `itemticket` WRITE;
/*!40000 ALTER TABLE `itemticket` DISABLE KEYS */;
INSERT INTO `itemticket` VALUES (1,3,1,200,2),(2,1,2,100,2),(3,3,3,400,2),(4,1,4,110,3),(5,1,1,100,2),(6,1,2,100,2),(7,2,2,100,1),(8,1,3,100,1),(9,1,3,100,1),(10,3,4,200,1),(11,1,4,100,1),(12,1,5,100,1),(13,2,5,100,1),(14,3,5,200,1),(15,1,6,100,2),(16,3,6,200,2),(17,1,7,100,5),(18,2,7,100,5),(19,3,8,200,3),(20,2,8,100,2),(21,3,10,200,5),(22,2,10,100,2),(23,1,15,110,3),(24,3,15,400,1),(25,1,16,110,2),(26,2,16,165,1);
/*!40000 ALTER TABLE `itemticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemvianda`
--

DROP TABLE IF EXISTS `itemvianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemvianda` (
  `idProducto` int(11) NOT NULL,
  `idVianda` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`,`idVianda`),
  KEY `fk_Producto_has_Vianda_Vianda1_idx` (`idVianda`),
  KEY `fk_Producto_has_Vianda_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Vianda_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Vianda_Vianda1` FOREIGN KEY (`idVianda`) REFERENCES `vianda` (`idVianda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemvianda`
--

LOCK TABLES `itemvianda` WRITE;
/*!40000 ALTER TABLE `itemvianda` DISABLE KEYS */;
INSERT INTO `itemvianda` VALUES (1,1),(3,2),(2,3);
/*!40000 ALTER TABLE `itemvianda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listaprecio`
--

DROP TABLE IF EXISTS `listaprecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listaprecio` (
  `idListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `idTipoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idListaPrecio`,`idTipoCliente`),
  KEY `fk_ListaPrecio_TipoCliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_ListaPrecio_TipoCliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listaprecio`
--

LOCK TABLES `listaprecio` WRITE;
/*!40000 ALTER TABLE `listaprecio` DISABLE KEYS */;
INSERT INTO `listaprecio` VALUES (1,'2017-01-00',1),(2,'2017-02-00',2),(3,'2017-03-00',4),(4,'2017-04-00',3),(5,'2016-08-02',2);
/*!40000 ALTER TABLE `listaprecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`idLogin`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Matias','123456'),(2,'JuanPablo','223344'),(3,'Lucio','343434');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `fechaUnica` date DEFAULT NULL,
  `disponibilidadSemana` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2009-01-00','Lunes'),(2,'2009-01-01','Martes'),(3,'2009-01-02','Miercoles'),(4,'2009-01-03','Jueves');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `idSalon` int(11) NOT NULL,
  `estadoMesa` int(11) NOT NULL DEFAULT '1',
  `nroMesa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMesa`,`idSalon`),
  UNIQUE KEY `nroMesa_UNIQUE` (`nroMesa`),
  KEY `fk_Mesa_Salon1_idx` (`idSalon`),
  CONSTRAINT `fk_Mesa_Salon1` FOREIGN KEY (`idSalon`) REFERENCES `salon` (`idSalon`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4),(5,1,1,5),(6,2,1,6),(7,2,1,7);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesasimple`
--

DROP TABLE IF EXISTS `mesasimple`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesasimple` (
  `idMesaSimple` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  PRIMARY KEY (`idMesaSimple`),
  KEY `fk_MesaSimple_mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_MesaSimple_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesasimple`
--

LOCK TABLES `mesasimple` WRITE;
/*!40000 ALTER TABLE `mesasimple` DISABLE KEYS */;
INSERT INTO `mesasimple` VALUES (1,1,4),(2,2,4),(3,3,2);
/*!40000 ALTER TABLE `mesasimple` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilegio`
--

DROP TABLE IF EXISTS `privilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilegio` (
  `idPrivilegio` int(11) NOT NULL AUTO_INCREMENT,
  `privilegio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPrivilegio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegio`
--

LOCK TABLES `privilegio` WRITE;
/*!40000 ALTER TABLE `privilegio` DISABLE KEYS */;
INSERT INTO `privilegio` VALUES (1,'Borrar mesa'),(2,'Añadir producto'),(3,'Añadir menu'),(4,'Añadir plato'),(5,'Añadir mesa');
/*!40000 ALTER TABLE `privilegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `idReceta` int(11) NOT NULL,
  `idRubro` int(11) NOT NULL,
  `idSubRubro` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `imagen` varchar(80) DEFAULT NULL,
  `habilitado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`idProducto`,`idReceta`,`idRubro`,`idSubRubro`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_Producto_SubRubro_idx` (`idSubRubro`),
  KEY `fk_Producto_Rubro1_idx` (`idRubro`),
  KEY `fk_Producto_Receta1_idx` (`idReceta`),
  CONSTRAINT `fk_Producto_Receta1` FOREIGN KEY (`idReceta`) REFERENCES `receta` (`idReceta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Rubro1` FOREIGN KEY (`idRubro`) REFERENCES `rubro` (`idRubro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_SubRubro` FOREIGN KEY (`idSubRubro`) REFERENCES `subrubro` (`idSubRubro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,2,1,'Cocacola','Primera marca, 650ml.',NULL,''),(2,1,2,1,'Cosecha tardia','Vino de la casa',NULL,''),(3,1,2,2,'Carne con papas','Abundante porcion',NULL,''),(4,1,2,2,'Milanesa con papas','Abundante porcion',NULL,''),(5,1,2,3,'Fideos con tuco','Abundante porcion',NULL,''),(6,1,2,3,'Fideos con crema','Abundante porcion',NULL,''),(7,1,1,2,'Salamin','Primera marca',NULL,''),(8,1,1,2,'Empanaditas','Saltenias',NULL,''),(9,1,1,2,'Porcion Sushi','Degustacion',NULL,''),(10,1,1,1,'Cerveza','Degustacion',NULL,''),(11,1,3,4,'Flan','Casero',NULL,''),(12,1,3,4,'Panqueque','Dulce de leche',NULL,''),(13,1,3,4,'Torta','Abundante porcion',NULL,''),(14,1,3,4,'Helado','Variedad de sabores',NULL,'');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta` (
  `idReceta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idReceta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Milanesa con papas','Para compartir'),(2,'Papas con cheddar','Para compartir'),(3,'Carne al horno','Una persona');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubro` (
  `idRubro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRubro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubro`
--

LOCK TABLES `rubro` WRITE;
/*!40000 ALTER TABLE `rubro` DISABLE KEYS */;
INSERT INTO `rubro` VALUES (1,'Entrada'),(2,'Platos y bebidas'),(3,'Postre');
/*!40000 ALTER TABLE `rubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salon`
--

DROP TABLE IF EXISTS `salon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salon` (
  `idSalon` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idSalon`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salon`
--

LOCK TABLES `salon` WRITE;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
INSERT INTO `salon` VALUES (1,'Comun'),(2,'VIP');
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `idStock` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL,
  `cantidadActual` double NOT NULL,
  `cantidadMinima` double DEFAULT NULL,
  `cantidadDeseada` double DEFAULT NULL,
  PRIMARY KEY (`idStock`,`idIngrediente`),
  KEY `fk_Stock_Ingrediente1_idx` (`idIngrediente`),
  CONSTRAINT `fk_Stock_Ingrediente1` FOREIGN KEY (`idIngrediente`) REFERENCES `ingrediente` (`idIngrediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,1,50,10,30),(2,3,50,15,32),(3,2,20,3,10);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subrubro`
--

DROP TABLE IF EXISTS `subrubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subrubro` (
  `idSubRubro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSubRubro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subrubro`
--

LOCK TABLES `subrubro` WRITE;
/*!40000 ALTER TABLE `subrubro` DISABLE KEYS */;
INSERT INTO `subrubro` VALUES (1,'Bebida'),(2,'Carnes'),(3,'Pastas'),(4,'Dulces');
/*!40000 ALTER TABLE `subrubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT NULL,
  `idMesa` int(11) NOT NULL,
  `idCamarero` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `monto` double NOT NULL,
  `fechaEmision` datetime DEFAULT NULL,
  `esCortesia` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idTicket`,`idUsuario`),
  KEY `fk_Ticket_Usuario1_idx` (`idUsuario`),
  KEY `fk_ticket_camarero1_idx` (`idCamarero`),
  KEY `fk_ticket_cliente1_idx` (`idCliente`),
  KEY `fk_ticket_mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_Ticket_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_camarero1` FOREIGN KEY (`idCamarero`) REFERENCES `camarero` (`idCamarero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,1,1,1,1,400,'2018-05-15 16:53:30','\0'),(2,1,1,1,1,200,'2018-05-15 17:13:36','\0'),(3,3,1,1,2,800,'2018-05-20 12:57:23','\0'),(4,3,1,1,2,330,'2018-05-20 14:52:04','\0'),(5,1,1,1,1,200,'2018-05-15 12:37:00','\0'),(6,1,2,2,1,300,'2018-05-17 14:52:00','\0'),(7,2,1,3,1,200,'2018-05-10 14:33:00','\0'),(8,3,2,2,1,300,'2018-05-20 01:22:00','\0'),(9,4,3,1,1,400,'2018-05-20 13:13:00','\0'),(10,1,3,3,1,600,'2018-05-15 12:00:00','\0'),(11,4,3,4,1,1000,'2018-05-18 16:03:00','\0'),(12,2,1,2,1,800,'2018-03-14 18:00:00','\0'),(13,4,3,2,1,100,'2018-01-13 20:00:00','\0'),(14,1,1,1,1,1200,'2018-04-17 22:59:00','\0'),(15,3,1,1,2,730,'2018-05-28 15:14:42','\0'),(16,3,2,1,2,385,'2018-05-28 15:18:43','\0');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoCliente`),
  UNIQUE KEY `tipo_UNIQUE` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
INSERT INTO `tipocliente` VALUES (3,'Diamante'),(4,'nocliente'),(2,'Oro'),(1,'Plata');
/*!40000 ALTER TABLE `tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'Admin'),(2,'Normal');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `idLogin` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`idTipoUsuario`,`idLogin`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombre`),
  KEY `fk_Usuario_TipoUsuario1_idx` (`idTipoUsuario`),
  KEY `fk_usuario_login1_idx` (`idLogin`),
  CONSTRAINT `fk_Usuario_TipoUsuario1` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_login1` FOREIGN KEY (`idLogin`) REFERENCES `login` (`idLogin`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,2,'Matias','Torsello',1),(2,1,'Juan Pablo','Federico',2),(3,2,'Lucio','Trucco',3);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioprivilegio`
--

DROP TABLE IF EXISTS `usuarioprivilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioprivilegio` (
  `idTipoUsuario` int(11) NOT NULL,
  `idPrivilegio` int(11) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`,`idPrivilegio`),
  KEY `fk_TipoUsuario_Privilegio_TipoUsuario1_idx` (`idTipoUsuario`),
  KEY `fk_TipoUsuario_Privilegio_Privilegio1_idx` (`idPrivilegio`),
  CONSTRAINT `fk_TipoUsuario_Privilegio_Privilegio1` FOREIGN KEY (`idPrivilegio`) REFERENCES `privilegio` (`idPrivilegio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TipoUsuario_Privilegio_TipoUsuario1` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioprivilegio`
--

LOCK TABLES `usuarioprivilegio` WRITE;
/*!40000 ALTER TABLE `usuarioprivilegio` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioprivilegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vianda`
--

DROP TABLE IF EXISTS `vianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vianda` (
  `idVianda` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idVianda`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vianda`
--

LOCK TABLES `vianda` WRITE;
/*!40000 ALTER TABLE `vianda` DISABLE KEYS */;
INSERT INTO `vianda` VALUES (1,'Vegetariana'),(2,'Rapida'),(3,'Dietetica');
/*!40000 ALTER TABLE `vianda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-03 23:41:32
