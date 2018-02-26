-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: SistemaRestaurante
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
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
-- Table structure for table `itemComanda`
--

DROP TABLE IF EXISTS `itemComanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemComanda` (
  `idItemComanda` int(11) NOT NULL AUTO_INCREMENT,
  `idComanda` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idItemComanda`,`idComanda`,`idProducto`),
  KEY `fk_ItemComanda_Comanda1_idx` (`idComanda`),
  KEY `fk_ItemComanda_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_ItemComanda_Comanda1` FOREIGN KEY (`idComanda`) REFERENCES `comanda` (`idComanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemComanda_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemComanda`
--

LOCK TABLES `itemComanda` WRITE;
/*!40000 ALTER TABLE `itemComanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemComanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemListaPrecio`
--

DROP TABLE IF EXISTS `itemListaPrecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemListaPrecio` (
  `idItemListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `idListaPrecio` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idItemListaPrecio`,`idListaPrecio`,`idProducto`),
  KEY `fk_ItemListaPrecio_Producto1_idx` (`idProducto`),
  KEY `fk_ItemListaPrecio_ListaPrecio1_idx` (`idListaPrecio`),
  CONSTRAINT `fk_ItemListaPrecio_ListaPrecio1` FOREIGN KEY (`idListaPrecio`) REFERENCES `listaprecio` (`idListaPrecio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemListaPrecio_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemListaPrecio`
--

LOCK TABLES `itemListaPrecio` WRITE;
/*!40000 ALTER TABLE `itemListaPrecio` DISABLE KEYS */;
INSERT INTO `itemListaPrecio` VALUES (1,1,1,100),(2,3,3,200),(3,1,2,150),(4,2,3,400),(5,1,3,200),(6,2,1,110),(7,2,2,165),(8,3,1,75),(9,3,2,130),(10,4,1,135),(11,4,2,200),(12,4,3,260);
/*!40000 ALTER TABLE `itemListaPrecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemMenu`
--

DROP TABLE IF EXISTS `itemMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemMenu` (
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
-- Dumping data for table `itemMenu`
--

LOCK TABLES `itemMenu` WRITE;
/*!40000 ALTER TABLE `itemMenu` DISABLE KEYS */;
INSERT INTO `itemMenu` VALUES (1,1),(2,2),(3,1);
/*!40000 ALTER TABLE `itemMenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemReceta`
--

DROP TABLE IF EXISTS `itemReceta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemReceta` (
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
-- Dumping data for table `itemReceta`
--

LOCK TABLES `itemReceta` WRITE;
/*!40000 ALTER TABLE `itemReceta` DISABLE KEYS */;
INSERT INTO `itemReceta` VALUES (1,1,3,100),(2,2,2,200),(3,1,2,40),(4,3,1,100);
/*!40000 ALTER TABLE `itemReceta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemRubro`
--

DROP TABLE IF EXISTS `itemRubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemRubro` (
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
-- Dumping data for table `itemRubro`
--

LOCK TABLES `itemRubro` WRITE;
/*!40000 ALTER TABLE `itemRubro` DISABLE KEYS */;
INSERT INTO `itemRubro` VALUES (1,2),(2,3),(3,1);
/*!40000 ALTER TABLE `itemRubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemTicket`
--

DROP TABLE IF EXISTS `itemTicket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemTicket` (
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemTicket`
--

LOCK TABLES `itemTicket` WRITE;
/*!40000 ALTER TABLE `itemTicket` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemTicket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemVianda`
--

DROP TABLE IF EXISTS `itemVianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemVianda` (
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
-- Dumping data for table `itemVianda`
--

LOCK TABLES `itemVianda` WRITE;
/*!40000 ALTER TABLE `itemVianda` DISABLE KEYS */;
INSERT INTO `itemVianda` VALUES (1,1),(3,2),(2,3);
/*!40000 ALTER TABLE `itemVianda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listaPrecio`
--

DROP TABLE IF EXISTS `listaPrecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listaPrecio` (
  `idListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `idTipoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idListaPrecio`,`idTipoCliente`),
  KEY `fk_ListaPrecio_TipoCliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_ListaPrecio_TipoCliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listaPrecio`
--

LOCK TABLES `listaPrecio` WRITE;
/*!40000 ALTER TABLE `listaPrecio` DISABLE KEYS */;
INSERT INTO `listaPrecio` VALUES (1,'2017-01-00',1),(2,'2017-02-00',2),(3,'2017-03-00',4),(4,'2017-04-00',3),(5,'2016-08-02',2);
/*!40000 ALTER TABLE `listaPrecio` ENABLE KEYS */;
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
-- Table structure for table `mesaSimple`
--

DROP TABLE IF EXISTS `mesaSimple`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesaSimple` (
  `idMesaSimple` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  PRIMARY KEY (`idMesaSimple`),
  KEY `fk_MesaSimple_mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_MesaSimple_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesaSimple`
--

LOCK TABLES `mesaSimple` WRITE;
/*!40000 ALTER TABLE `mesaSimple` DISABLE KEYS */;
INSERT INTO `mesaSimple` VALUES (1,1,4),(2,2,4),(3,3,2);
/*!40000 ALTER TABLE `mesaSimple` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,1,1,'Cocacola','Primera marca, 650ml.',NULL,''),(2,1,2,2,'Cosecha tardia','Vino de la casa',NULL,''),(3,1,2,3,'Carne con papas','Abundante porcion',NULL,'');
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
INSERT INTO `rubro` VALUES (1,'Entrada'),(2,'Plato principal'),(3,'Postre');
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
-- Table structure for table `subRubro`
--

DROP TABLE IF EXISTS `subRubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subRubro` (
  `idSubRubro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSubRubro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subRubro`
--

LOCK TABLES `subRubro` WRITE;
/*!40000 ALTER TABLE `subRubro` DISABLE KEYS */;
INSERT INTO `subRubro` VALUES (1,'Bebida'),(2,'Carnes'),(3,'Pastas');
/*!40000 ALTER TABLE `subRubro` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoCliente`
--

DROP TABLE IF EXISTS `tipoCliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoCliente` (
  `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoCliente`),
  UNIQUE KEY `tipo_UNIQUE` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoCliente`
--

LOCK TABLES `tipoCliente` WRITE;
/*!40000 ALTER TABLE `tipoCliente` DISABLE KEYS */;
INSERT INTO `tipoCliente` VALUES (3,'Diamante'),(4,'nocliente'),(2,'Oro'),(1,'Plata');
/*!40000 ALTER TABLE `tipoCliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoUsuario`
--

DROP TABLE IF EXISTS `tipoUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoUsuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoUsuario`
--

LOCK TABLES `tipoUsuario` WRITE;
/*!40000 ALTER TABLE `tipoUsuario` DISABLE KEYS */;
INSERT INTO `tipoUsuario` VALUES (1,'Admin'),(2,'Normal');
/*!40000 ALTER TABLE `tipoUsuario` ENABLE KEYS */;
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
-- Table structure for table `usuarioPrivilegio`
--

DROP TABLE IF EXISTS `usuarioPrivilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioPrivilegio` (
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
-- Dumping data for table `usuarioPrivilegio`
--

LOCK TABLES `usuarioPrivilegio` WRITE;
/*!40000 ALTER TABLE `usuarioPrivilegio` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioPrivilegio` ENABLE KEYS */;
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

--
-- Dumping events for database 'SistemaRestaurante'
--

--
-- Dumping routines for database 'SistemaRestaurante'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-25 22:56:47
