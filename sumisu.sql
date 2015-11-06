CREATE DATABASE  IF NOT EXISTS `sumisu` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sumisu`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sumisu
-- ------------------------------------------------------
-- Server version	5.5.20-log

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
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendence` (
  `EmpID` int(11) NOT NULL DEFAULT '0',
  `Date` varchar(45) NOT NULL,
  `StartTime` varchar(45) DEFAULT NULL,
  `EndTime` varchar(45) DEFAULT NULL,
  `section` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EmpID`,`Date`),
  CONSTRAINT `fk11` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`empId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendence`
--

LOCK TABLES `attendence` WRITE;
/*!40000 ALTER TABLE `attendence` DISABLE KEYS */;
INSERT INTO `attendence` VALUES (3,'2014-09-30','15:44:21',NULL,'N/A'),(3,'2014-10-01','11:01:04',NULL,'N/A'),(12,'2014-09-30','10:59:58',NULL,'N/A'),(14,'2014-09-25','13:14:56',NULL,'N/A'),(15,'2014-09-25','13:15:00',NULL,'N/A'),(15,'2014-09-30','11:00:38',NULL,'N/A'),(16,'2014-09-25','13:15:10',NULL,'N/A'),(18,'2014-09-25','13:15:26',NULL,'N/A'),(18,'2014-09-30','11:00:47',NULL,'N/A'),(18,'2014-10-01','11:57:58',NULL,'N/A'),(19,'2014-09-25','13:15:30',NULL,'N/A'),(19,'2014-09-30','11:00:59',NULL,'N/A'),(19,'2014-10-01','11:01:25',NULL,'Preprocess'),(28,'2014-09-25','13:15:35',NULL,'N/A'),(28,'2014-09-30','11:01:03',NULL,'loading'),(28,'2014-10-01','11:01:32',NULL,'grinding'),(29,'2014-09-25','13:15:39',NULL,'N/A'),(29,'2014-09-30','11:01:08',NULL,'loading'),(29,'2014-10-01','11:01:41',NULL,'loading'),(30,'2014-09-25','13:15:43',NULL,'N/A'),(30,'2014-09-30','11:01:14',NULL,'packing'),(30,'2014-10-01','11:01:52',NULL,'grinding'),(31,'2014-09-25','13:15:47',NULL,'N/A'),(31,'2014-09-30','11:01:24',NULL,'packing'),(33,'2014-09-25','13:15:59',NULL,'N/A'),(33,'2014-09-30','11:01:38',NULL,'grinding'),(33,'2014-10-01','11:02:02',NULL,'Preprocess'),(35,'2014-09-25','13:16:13',NULL,'N/A'),(35,'2014-09-30','11:01:45',NULL,'loading'),(35,'2014-10-01','11:02:12',NULL,'packing'),(36,'2014-09-25','13:16:17',NULL,'N/A'),(36,'2014-09-30','11:01:50',NULL,'Preprocess'),(41,'2014-09-25','13:16:26',NULL,'N/A'),(41,'2014-09-30','11:02:02',NULL,'grinding'),(42,'2014-09-25','13:16:30',NULL,'N/A'),(42,'2014-09-30','11:02:09',NULL,'Preprocess');
/*!40000 ALTER TABLE `attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `cusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartId`,`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complains`
--

DROP TABLE IF EXISTS `complains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complains` (
  `compID` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `personID` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`compID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complains`
--

LOCK TABLES `complains` WRITE;
/*!40000 ALTER TABLE `complains` DISABLE KEYS */;
/*!40000 ALTER TABLE `complains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_delivery_chart`
--

DROP TABLE IF EXISTS `daily_delivery_chart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_delivery_chart` (
  `ddcid` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `Vno` varchar(45) DEFAULT NULL,
  `repid` int(11) DEFAULT NULL,
  `route` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ddcid`)
) ENGINE=MyISAM AUTO_INCREMENT=20012 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_delivery_chart`
--

LOCK TABLES `daily_delivery_chart` WRITE;
/*!40000 ALTER TABLE `daily_delivery_chart` DISABLE KEYS */;
INSERT INTO `daily_delivery_chart` VALUES (1,'2014-09-30','hc-0908',43,'Rathnaoura','On Route'),(2,'date','Vno',0,'route','status'),(20009,'2014-09-30','LG1235',20,'Rathnapura','Came Back'),(20010,'2014-09-30','LG1234',21,'Galle','On Route'),(20011,'2014-10-01','GA1935',46,'balangoda','Came Back');
/*!40000 ALTER TABLE `daily_delivery_chart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_products`
--

DROP TABLE IF EXISTS `delivery_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_products` (
  `ddcid` int(11) DEFAULT NULL,
  `ddid` int(11) NOT NULL AUTO_INCREMENT,
  `prouct_name` varchar(45) DEFAULT NULL,
  `product_id` varchar(45) DEFAULT NULL,
  `number_of_products` int(11) DEFAULT NULL,
  `stockId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ddid`),
  KEY `fk_delivery_products_idx` (`ddid`),
  KEY `fk_dP_idx` (`ddcid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_products`
--

LOCK TABLES `delivery_products` WRITE;
/*!40000 ALTER TABLE `delivery_products` DISABLE KEYS */;
INSERT INTO `delivery_products` VALUES (1,1,'Curry Powder','12019',0,25),(20011,2,'Chillie Powder','12018',10,28);
/*!40000 ALTER TABLE `delivery_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverycustomer`
--

DROP TABLE IF EXISTS `deliverycustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverycustomer` (
  `cusId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `StartDate` varchar(45) DEFAULT NULL,
  `deliveryVehicleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5682 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverycustomer`
--

LOCK TABLES `deliverycustomer` WRITE;
/*!40000 ALTER TABLE `deliverycustomer` DISABLE KEYS */;
INSERT INTO `deliverycustomer` VALUES (5643,'Hoshani','Jayamini','hjaye@gmail.com','Chilaw','0719988045','2',1),(5645,'Lakshan','Madushanka','lak@ymail.com','Balangoda','0789288910','21',11),(5646,'Lalindi','Amarasinghe','lale@ymail.com','Horana','0715527800','21',11),(5647,'Sankalpa','Udayanga','sanke@gmail.com','galle','0772177890','2014-01-01',11),(5649,'Hashini','Eshika','hashini@gmail.com','Maharagama','0712233456','2011-12-12',11),(5652,'Koliya ','Harshanath','koliya@ymail.com','Galle','0784567343','21',11),(5657,'Chanaka','Amarasinghe','chanaka@ymail.com','Galle','0725567899','2011-03-23',11),(5658,'Koliya ','Harshanath','koliya@gmail.com','Galle','0776539015','2014-05-10',11),(5661,'Thilina','Thilakarathna','thili@gmail.com','Alpitiya','0322256333','2010-03-07',11),(5662,'Malith','Rodrigo','malith@gamil.com','Piliyandala','0113477867','2012-05-05',1),(5663,'Himani','Prabodya','himani@yahoo.com','piliyandala','0782323456','2013-05-07',1),(5664,'Nethmini','Senaka','nethmi@yahoo.com','Pannipitiya','0778892347','2010-10-09',1),(5665,'Thinisha','Dadigamuwa','thd@gmail.com','Waliweriya','0753347890','2013-09-25',1),(5666,'Asanka ','Ranasinghe','rasanka@gmail.com','Galle','0778909234','2010-10-10',1),(5667,'Upeksha','Adikari','upeksha8@gmail.com','Gampaha','0789034567','2013-05-13',1),(5668,'Erandi','Balasuriya','erandi18@gmail.com','Chilaw','0723341890','2010-06-06',1),(5669,'Anu','Weerrathna','anu@gmail.com','Kurunegala','0728897567','2013-08-11',1),(5670,'Maduwanthi','Weerasekara','madu@yahoo.com','Colombo','0783325678','2011-10-04',1),(5678,'Tharindu','Silva','danushka@gmail.com','Maharagama','0775801632','2014-09-29',1),(5679,'Malinga','Bandara','mal@yahoo.com','Wattala','0786521098','2014-09-30',1),(5680,'Malithi','Walawage','mal@gmail.com','Bandarawela','0987654321','2014-01-01',11),(5681,'mahela','silva','asdf@gmail.com','delkada','0723435653','2014-10-01',1);
/*!40000 ALTER TABLE `deliverycustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverymaintain`
--

DROP TABLE IF EXISTS `deliverymaintain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverymaintain` (
  `vNo` varchar(11) NOT NULL DEFAULT '',
  `amount` float DEFAULT NULL,
  `MaintainDate` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `mID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mID`,`vNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverymaintain`
--

LOCK TABLES `deliverymaintain` WRITE;
/*!40000 ALTER TABLE `deliverymaintain` DISABLE KEYS */;
INSERT INTO `deliverymaintain` VALUES ('1234',1000,'2014-01-01','jkhik',1001),('741852',1200,'2014-8-1','aaaaaaaaaa',1002),('741852',34555,'2014-8-1','fhfjjhgjk',1003),('HC0908',1000000,'2014-8-1','by lalee',1004),('456',10000,'2014-8-7','asdfghjk',1005),('456',123,'2014-8-12','sdb',1006),('456',2500,'2014-8-28','zxcvbnm,asdj',1007),('LA1929',1000,'2014-8-2','mkl',1008),('kmk4564816',10000,'2014-8-8','gfybupiop',1009),('lk5',456,'2014-8-9',' ml',1010),('qwe17523',0,'2014-8-16','cds',1011),('qwe17523',213.231,'2014-8-2','saddsds',1012),('qwe17523',456,'2014-8-8','hih',1013),('qwe17523',4596,'2014-8-15','ghk13',1014),('qwe17523',416,'2014-8-8','hui',1015),('vNo',0,'MaintainDate','description',1016),('qwe17523',789,'2014-08-02','gkyug',1017),('hc-0908',100,'2014-08-07','fftghj',1018),('na1254',200,'2014-10-10','bla bla bla',1019),('LG1213',200,'2014-10-01','Test',1020),('na3421',400,'2014-10-01','test',1021);
/*!40000 ALTER TABLE `deliverymaintain` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `deliverymaintain_AINS` AFTER INSERT ON `deliverymaintain` FOR EACH ROW
BEGIN
SET @id = (select max(`mID`) from sumisu.deliverymaintain);
SET @pdate =   (select MaintainDate from sumisu.deliverymaintain where mID = @id);
SET @descriptA = (select description from sumisu.deliverymaintain where mID = @id);
SET @amt = (select `amount` from sumisu.deliverymaintain where mID = @id);
SET @vNo = (select `vNo` from sumisu.deliverymaintain where mID = @id);
SET @transType = 'Credit';
SET @descript = concat(@descriptA,'  |  vehicle no :', @vNo);
INSERT INTO `sumisu`.`profit` (`transactionType`, `date`, `description`, `amount`, `transaction`) VALUES (@transType, @pdate, @descript, @amt, 'Vehicle Maintain');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `deliveryvehicle`
--

DROP TABLE IF EXISTS `deliveryvehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliveryvehicle` (
  `vId` int(11) NOT NULL AUTO_INCREMENT,
  `vNo` varchar(20) NOT NULL,
  `vType` varchar(20) DEFAULT NULL,
  `fuelType` varchar(50) DEFAULT NULL,
  `Mrent` int(11) DEFAULT NULL,
  `LInsureDate` varchar(45) DEFAULT NULL,
  `InsExpDate` varchar(45) DEFAULT NULL,
  `LicenDate` varchar(45) DEFAULT NULL,
  `LicenExpDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vId`,`vNo`),
  UNIQUE KEY `vNo_UNIQUE` (`vNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1286 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryvehicle`
--

LOCK TABLES `deliveryvehicle` WRITE;
/*!40000 ALTER TABLE `deliveryvehicle` DISABLE KEYS */;
INSERT INTO `deliveryvehicle` VALUES (1260,'hc-0908','Van','Diesel',65000,'2014-08-15','null','2014-08-15','null'),(1266,'LG1235','Van','Diesel',20000,'2014-09-05','null','2014-09-05','null'),(1268,'LG1236','Demo Batta','Petrol',20000,'2014-09-06','null','2014-09-06','null'),(1269,'NV2548','Lorry','Diesel',25000,'2014-09-019','2015-09-011','2014-09-019','2015-09-019'),(1271,'VA2648','Van','Diesel',2000,'2014-09-12','null','2014-09-12','null'),(1272,'NV3258','Demo Batta','Diesel',50000,'2014-09-020','2015-09-018','2014-09-026','2015-09-019'),(1273,'LG5213','Lorry','Diesel',0,'2014-09-05','2015-09-018','2014-09-019','2015-09-018'),(1274,'NV3678','Van','Diesel',0,'2014-09-022','2015-09-021','2014-09-02','2015-09-023'),(1275,'NV8125','Van','Petrol',0,'2014-09-027','2015-09-026','2014-09-020','2015-09-026'),(1276,'nv2561566','Van','Petrol',0,'2014-09-04','2015-09-018','2014-09-011','2015-09-018'),(1278,'P2154','Van','Diesel',0,'2014-09-12','2015-09-12','2014-09-20','2015-09-20'),(1279,'GA1935','Van','Diesel',60000,'2014-09-18','2015-09-18','2014-09-17','2015-09-17'),(1280,'GA3525','Van','Petrol',50000,'2014-09-01','2015-09-01','2014-09-27','2015-09-27'),(1281,'vNo','vType','fuelType',0,'LInsureDate','InsExpDate','LicenDate','LicenExpDate'),(1282,'na1254','Van','Petrol',15000,'2014-10-16','2015-10-16','2014-10-10','2015-10-10'),(1284,'LG1213','Lorry','Diesel',20000,'2014-09-01','2015-09-01','2014-08-01','2015-08-01'),(1285,'na3421','Van','Diesel',45000,'2014-10-03','2015-10-03','2014-10-04','2015-10-04');
/*!40000 ALTER TABLE `deliveryvehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delorder`
--

DROP TABLE IF EXISTS `delorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delorder` (
  `custid` int(11) NOT NULL,
  `proid` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`custid`,`proid`),
  KEY `fk12_idx` (`proid`),
  CONSTRAINT `fk111` FOREIGN KEY (`custid`) REFERENCES `deliverycustomer` (`cusId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk121` FOREIGN KEY (`proid`) REFERENCES `product` (`itemId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delorder`
--

LOCK TABLES `delorder` WRITE;
/*!40000 ALTER TABLE `delorder` DISABLE KEYS */;
INSERT INTO `delorder` VALUES (5645,12021,20),(5645,12022,10),(5647,12020,45);
/*!40000 ALTER TABLE `delorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empcomplains`
--

DROP TABLE IF EXISTS `empcomplains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empcomplains` (
  `compID` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `Details` varchar(1000) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `isViewed` binary(1) DEFAULT '0',
  PRIMARY KEY (`compID`),
  KEY `fk11_idx` (`empid`),
  CONSTRAINT `fk15` FOREIGN KEY (`empid`) REFERENCES `employee` (`empId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empcomplains`
--

LOCK TABLES `empcomplains` WRITE;
/*!40000 ALTER TABLE `empcomplains` DISABLE KEYS */;
INSERT INTO `empcomplains` VALUES (2,41,'rtretrtretry','2014-09-29','13:38:33','1'),(3,30,'aldfghjkldfghkl;m,cvbncc ','2014-09-29','18:32:01','1'),(4,43,'bla bla bla bla ........................','2014-10-01','14:45:40','1');
/*!40000 ALTER TABLE `empcomplains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `BOD` varchar(50) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `nic` varchar(10) DEFAULT NULL,
  `accNo` int(11) DEFAULT NULL,
  `maritalStatus` varchar(20) DEFAULT NULL,
  `sDate` datetime DEFAULT NULL,
  `basicSal` int(11) DEFAULT '0',
  `Allowances` int(11) DEFAULT '0',
  `otHrs` int(11) DEFAULT '0',
  `bonus` int(11) DEFAULT '0',
  `mobile` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `section` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isFirstLogin` int(11) DEFAULT '1',
  PRIMARY KEY (`empId`),
  UNIQUE KEY `nic_UNIQUE` (`nic`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,'lalindi','thathsarani','kaduwela','123456789','2013-10-04','Female','922652345v',0,'false','2014-08-16 00:00:00',546,800,0,1000,'711789182','lalin@gmail.com',NULL,NULL,'lalee',NULL,1),(12,'sachini','hirunika','polonnaruwa','123456345','1991-08-12','Female','916463456v',12345678,'false','2014-08-21 00:00:00',50,100,0,10,'714257483','sachini@gmail.com','Cashier','--Select--',NULL,NULL,0),(14,'Koliya','Harshanath','galle','234567890','1993.10.10','Male','935467789v',12435,'false','2014-08-21 00:00:00',0,0,0,0,'234567890','abc@abc.com','Cashier','--Select--','harshanath','12345678',0),(15,'dinidu','gayasri','mathale','0235476843','1991-04-27','Male','913465738v',0,'false','2014-08-22 00:00:00',0,0,0,0,'284759274','dinidu@gmail.com','labour','Delivery','dinidu',NULL,1),(16,'apple','sampath','elpitiya','913910439','1994-01-07','Male','940070201v',1234568,'false','2014-08-22 00:00:00',5000,5000,0,3000,'782778815','synthxenon@gmail.com','Cashier','--Select--','apple123','asdf1234',0),(18,'lakshitha','Ruwan','Dehiaththakandiya','273723052','1991-06-17','Male','911690020v',23456789,'false','2014-08-23 00:00:00',40000,100,0,50,'776998585','ruwanslj@gmail.com','Cashier','--Select--','lakshitha',NULL,1),(19,'Sarath','Gajanayake','Colombo','987654321','09-09-1999','Female','931451990v',124324,'false','2014-08-24 00:00:00',12000,0,0,0,'987654321','abc@gmail.com','labour','Delivery','sarath','asdfasdf',0),(28,'Jayamini','Hoshini','Halawatha','345678909','90.8.12','Female','908978656v',123,'false','2014-09-23 00:00:00',8000,0,0,0,'789076564','acx@gmail.com','labour','Grinding','Jayamini',NULL,1),(29,'kamal','Lakmal','Colombo','987654321','90.2.1','Male','908767564v',1239,'false','2014-09-23 00:00:00',8000,0,0,0,'773423456','qwe@gmail.com','labour','Grinding','kamal',NULL,1),(30,'namal','nalaka','Horana','256789012','89.9.9','Male','890989789v',890,'true','2014-09-23 00:00:00',8000,0,0,0,'778990987','qaz@gmail.com','labour','Grinding','namal123','namal',1),(31,'rangana','Kasun','Horana`','767890123','89.6.2','Male','8909978909',678,'true','2014-09-23 00:00:00',9000,0,0,0,'789078901','sdg@gmail.com','labour','Grinding','rangana',NULL,1),(33,'Lalindi','Amarasinghe','bbbbbb','123456789','92.8.3','Female','926789087v',456,'false','2014-09-23 00:00:00',7500,0,0,0,'776567890','adg@gmail.com','labour','Grinding','lalindi','12345678',0),(35,'Angelo','mathews','dfghj','987654321','89.9.7','Male','8909876534',908,'true','2014-09-23 00:00:00',8000,0,0,0,'987654321','asd@gmail.lk','labour','Grinding','Angelo',NULL,1),(36,'kasun','lakmal','aaaaa','987654321','89.9.2','Male','891234567v',5678,'true','2014-09-23 00:00:00',8900,0,0,0,'987667890','ase@yahoo.lk','labour','Grinding','kasun',NULL,1),(41,'ranathunaga','kumara','zzzzzzz','789612845','84.5.7','Male','123496789v',63456,'true','2014-09-23 00:00:00',89000,0,0,0,'987650321','asd4fg@gmail.com','labour','Grinding','ranathunaga',NULL,1),(42,'Malith','Rodrigo','Piliyanadala','897654321','91.3.2','Female','912345678v',45670,'true','2014-09-23 00:00:00',4500,0,0,0,'781234561','ghi@yahoo.com','labour','Loading','malith','malithmalith',0),(43,'chaminda','sanjeewa','borella','112677013','1965-02-26','Male','652345678v',0,'true','2014-09-29 00:00:00',0,0,0,0,'717305894','star@gmail.com','Sales Rep','--Select--','652345678',NULL,1),(45,'Manager','manager','malabe','987654321','1991-10-30','Male','987654321v',12345678,'false','2014-10-01 00:00:00',45000,0,0,0,'987654321','manager@gmail.com','Manager','--Select--','manager123','manager1234',0),(46,'mahela','amarasinghe','Horana','342261193','1997-10-21','Male','975662934v',123456,'false','2014-10-01 00:00:00',30000,2000,0,0,'776089502','Mahela@gmail.com','Sales Rep','--Select--','975662934v',NULL,1),(47,'Udaranga','Pathmalal','Galle','894671260','1992-10-27','Male','927444366v',789567,'false','2014-10-01 00:00:00',30000,0,0,0,'716783256','uda@gmail.com','Sales Rep','--Select--','927444366v',NULL,1),(49,'mahinda','perera','kaduwela','112673456','1990-10-17','Male','902345678v',0,'true','2014-10-01 00:00:00',0,0,0,0,'777345267','mahinda@gmail.com','Sales Rep','--Select--','902345678v',NULL,1),(50,'dasun','perera','mathale','112756384','2004-10-15','Male','347593573v',1234234,'false','2014-10-01 00:00:00',20000,0,0,0,'345235365','dasun@gmail.com','Labour','Packing','347593573v',NULL,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expire_and_return_products`
--

DROP TABLE IF EXISTS `expire_and_return_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expire_and_return_products` (
  `Rid` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_id` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Rid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expire_and_return_products`
--

LOCK TABLES `expire_and_return_products` WRITE;
/*!40000 ALTER TABLE `expire_and_return_products` DISABLE KEYS */;
INSERT INTO `expire_and_return_products` VALUES (7,'Curry Powder','12019',5,'2014-09-30'),(8,'String Hoppers Flour','12012',10,'2014-10-01'),(9,'Rice Flour','12014',10,'2014-10-01');
/*!40000 ALTER TABLE `expire_and_return_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `invoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `itemPrice` double DEFAULT NULL,
  `itemName` varchar(45) DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `outletCustId` int(11) DEFAULT NULL,
  `empID` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoiceId`),
  KEY `fk_invoice1_idx` (`outletCustId`),
  KEY `fk_invoice2_idx` (`empID`),
  CONSTRAINT `fk_invoice1` FOREIGN KEY (`outletCustId`) REFERENCES `outletcustomer` (`cusId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice2` FOREIGN KEY (`empID`) REFERENCES `employee` (`empId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_product`
--

DROP TABLE IF EXISTS `invoice_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_product` (
  `invoiceId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`invoiceId`,`productId`),
  KEY `fk_invoiceProduct2_idx` (`productId`),
  CONSTRAINT `fk_invoiceProduct1` FOREIGN KEY (`invoiceId`) REFERENCES `invoice` (`invoiceId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoiceProduct2` FOREIGN KEY (`productId`) REFERENCES `product` (`itemId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_product`
--

LOCK TABLES `invoice_product` WRITE;
/*!40000 ALTER TABLE `invoice_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `loanID` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `acc_No` int(11) DEFAULT NULL,
  `financeName` varchar(45) DEFAULT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `installmentpayed` varchar(45) DEFAULT '0',
  `dateLastpaid` varchar(45) DEFAULT NULL,
  `no_of_installment` int(11) DEFAULT '0',
  `min_installment` float DEFAULT '0',
  PRIMARY KEY (`loanID`)
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (2015,10000,'2014-09-16','12','test',10,1211,'BOC','Galle','2','2014-09-12',0,0),(2016,1000,'2014-10-01','10','test',11,12312,'boc','Malabe','1','2014-10-01',0,0),(2017,20000,'2014-10-01','10','test',12,121114,'BOC','Galle','1','2014-10-01',0,0);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `loan_AINS` AFTER INSERT ON `loan` FOR EACH ROW
BEGIN
SET @id = (select max(`loanID`) from sumisu.loan);
SET @pdate =   (select `date` from sumisu.loan where loanID = @id);
SET @descriptA = (select `financeName` from sumisu.loan where loanID = @id);
SET @amt = (select `amount` from sumisu.loan where loanID = @id);
SET @branch = (select `branch` from sumisu.loan where loanID = @id);
SET @transType = 'Credit';
SET @descript = concat(@descriptA,'  |  bank :', @branch, @descriptA, @id);
INSERT INTO `sumisu`.`profit` (`transactionType`, `date`, `description`, `amount`, `transaction`) VALUES (@transType, @pdate, @descript, @amt, 'Loan');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `loan_installments`
--

DROP TABLE IF EXISTS `loan_installments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_installments` (
  `idLonaIns` int(11) NOT NULL AUTO_INCREMENT,
  `Instalamtl` float DEFAULT NULL,
  `InstallMentDate` varchar(45) DEFAULT NULL,
  `Loan_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLonaIns`),
  KEY `Fk_profi_loan_idx` (`Loan_ID`),
  CONSTRAINT `Fk_profi_loan` FOREIGN KEY (`Loan_ID`) REFERENCES `loan` (`loanID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_installments`
--

LOCK TABLES `loan_installments` WRITE;
/*!40000 ALTER TABLE `loan_installments` DISABLE KEYS */;
INSERT INTO `loan_installments` VALUES (12,1000,'2014-09-03',2015),(13,1000,'2014-09-12',2015),(14,1000,'2014-10-01',2016),(15,1200,'2014-10-01',2017);
/*!40000 ALTER TABLE `loan_installments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginun`
--

DROP TABLE IF EXISTS `loginun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginun`
--

LOCK TABLES `loginun` WRITE;
/*!40000 ALTER TABLE `loginun` DISABLE KEYS */;
INSERT INTO `loginun` VALUES (1,'manager123');
/*!40000 ALTER TABLE `loginun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materials` (
  `ItemId` int(11) NOT NULL AUTO_INCREMENT,
  `proName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `ingredient` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`ItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials_supply`
--

DROP TABLE IF EXISTS `materials_supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materials_supply` (
  `itemID` int(11) NOT NULL,
  `SupplierID` int(11) NOT NULL,
  PRIMARY KEY (`itemID`,`SupplierID`),
  KEY `fk_matirialSupplly2_idx` (`SupplierID`),
  CONSTRAINT `fk_matirialSupplly1` FOREIGN KEY (`itemID`) REFERENCES `materials` (`ItemId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matirialSupplly2` FOREIGN KEY (`SupplierID`) REFERENCES `suppllier` (`supId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials_supply`
--

LOCK TABLES `materials_supply` WRITE;
/*!40000 ALTER TABLE `materials_supply` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials_supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outleinvoice`
--

DROP TABLE IF EXISTS `outleinvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outleinvoice` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `transactionType` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `transaction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transactionId`)
) ENGINE=InnoDB AUTO_INCREMENT=20050 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outleinvoice`
--

LOCK TABLES `outleinvoice` WRITE;
/*!40000 ALTER TABLE `outleinvoice` DISABLE KEYS */;
INSERT INTO `outleinvoice` VALUES (20046,'Credit','2014-10-01','Sales',2650,'Outlet Sales'),(20047,'Credit','2014-10-01','Sales',1300,'Outlet Sales'),(20048,'Credit','2014-10-01','Sales',790,'Outlet Sales'),(20049,'Credit','2014-10-01','Sales',677,'Outlet Sales');
/*!40000 ALTER TABLE `outleinvoice` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `outleinvoice_AINS` AFTER INSERT ON `outleinvoice`
FOR EACH ROW 
BEGIN
SET @id = (select max(`transactionId`) from sumisu.outleinvoice);
SET @pdate =  (select `date` from sumisu.outleinvoice where transactionId = @id);
SET @descript = (select `description` from sumisu.outleinvoice where transactionId = @id);
SET @amt = (select `amount` from sumisu.outleinvoice where transactionId = @id);
SET @transType = 'Credit';
INSERT INTO `sumisu`.`profit` (`transactionType`, `date`, `description`, `amount`, `transaction`) VALUES (@transType, @pdate, @descript, @amt, 'Outlet Sales');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `outletcustomer`
--

DROP TABLE IF EXISTS `outletcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outletcustomer` (
  `cusId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `startDate` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cusId`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outletcustomer`
--

LOCK TABLES `outletcustomer` WRITE;
/*!40000 ALTER TABLE `outletcustomer` DISABLE KEYS */;
INSERT INTO `outletcustomer` VALUES (1,'fname','lname','address','phone','0000-00-00 00:00:00','email'),(29,'Hirunika','Karunarathna','Anuradhapura','0717239819','2014-08-22 00:00:00','sachi@gmail.com'),(31,'jayamini','hashini','halawathaaaa','0712345678','2014-08-22 00:00:00','as@gmail.com'),(36,'sankalpa','sanke','asdfgh','776856789','2014-08-22 00:00:00','dfg@gmail.co'),(37,'Sachiniaaaa','Rathnayake','Malabe','0123456789','2014-8-24','abc@gmail.com'),(92,'fname','lname','address','phone','startDate','email'),(93,'dfghjk','qwertyuioasdfghj','sdfghjkl','1234567890','2014-08-21 00:00:00','asdfgh@yahoo.com'),(94,'sachini','hirunika','anuradhapura','717239819','2014-08-22 00:00:00','sachi@gmail.com'),(95,'jayamini','hashini','halawatha','712345678','2014-08-22 00:00:00','as@gmail.com'),(96,'asdfg','asdfg','sdfghj','1234567890','2014-08-22 00:00:00','sdfgh@j.v'),(97,'sankalpa','sanke','asdfgh','776856789','2014-08-22 00:00:00','dfg@gmail.co'),(98,'jayamini','hoshini','colombo','717238908','2014-08-23 00:00:00','acb@gmail.com'),(99,'Lakshan','kasun','balangoda','0756789123','2014-08-23 00:00:00','asd@gmail.com'),(100,'Lalindi','Amarashinghe','Horana','717239789','2014-08-23 00:00:00','lalee@yahoo.com'),(101,'Koliya','Harshanath','Galle','757667890','2014-08-23 00:00:00','koli@gmail.com'),(102,'appleson','fernando','abilipitiya','775567890','2014-08-23 00:00:00','apple@gmail.com'),(103,'Vindya','Vishwani','Kaluthara','774567789','2014-08-24 00:00:00','Vindya@gmail.com'),(104,'Thilina ','Sampath','Kaluthara','717234567','2014-08-24 00:00:00','thili@gmail.com'),(105,'Asanka ','Ranasinghe','Malabe','778976543','2014-08-24 00:00:00','asa@yahoo.com'),(106,'Liyara','Silva','Horana','788987654','2014-08-24 00:00:00','liya@yahoo.com'),(107,'Thakshila','Ranasinghe','Kaduwela','789876543','2014-08-24 00:00:00','zxc@gmail.com'),(108,'Nuwan ','Sanjeewa','Kaduwela','789876543','2014-08-24 00:00:00','nj@yahoo.com'),(109,'Nuwan','Sameera','Athurugiriya','789678954','2014-08-24 00:00:00','nuwa@gmail.com'),(110,'Angelo','Mathews','Malabe','717238897','2014-08-24 00:00:00','angi@yahoo.com'),(111,'thaushika','Karunarathna','Horana','724567823','2014-08-24 00:00:00','asd@gmail.com'),(112,'Lakidu','Nanayakkara','Kaduwela','782345678','2014-08-24 00:00:00','lakidu@gamail.com'),(113,'Sachi','Rathnayake','Malabe','0987654321','2014-10-01','abc@gmail.com');
/*!40000 ALTER TABLE `outletcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outletinvoiceproduct`
--

DROP TABLE IF EXISTS `outletinvoiceproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outletinvoiceproduct` (
  `outletInvoiceProductId` int(11) NOT NULL AUTO_INCREMENT,
  `proId` int(11) DEFAULT NULL,
  `proName` varchar(45) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `transactionId1` int(11) DEFAULT NULL,
  PRIMARY KEY (`outletInvoiceProductId`),
  KEY `transacationId_idx` (`transactionId1`),
  KEY `transacationId_idxx` (`transactionId1`),
  CONSTRAINT `Fk1_outlet_invoice_product` FOREIGN KEY (`transactionId1`) REFERENCES `outleinvoice` (`transactionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outletinvoiceproduct`
--

LOCK TABLES `outletinvoiceproduct` WRITE;
/*!40000 ALTER TABLE `outletinvoiceproduct` DISABLE KEYS */;
INSERT INTO `outletinvoiceproduct` VALUES (1,12012,'String Hoppers Flour',10,20046),(2,12019,'Curry Powder',10,20046),(3,12012,'String Hoppers Flour',10,20046),(4,12025,'aaaaaa',10,20047),(5,12012,'String Hoppers Flour',10,20047),(6,12019,'Curry Powder',6,20048),(7,12012,'String Hoppers Flour',4,20048),(8,12019,'Curry Powder',9,20049),(9,12022,'Chillie Powder',4,20049);
/*!40000 ALTER TABLE `outletinvoiceproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outletstock`
--

DROP TABLE IF EXISTS `outletstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outletstock` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `proName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `ingredient` varchar(45) DEFAULT NULL,
  `qty` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=MyISAM AUTO_INCREMENT=12026 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outletstock`
--

LOCK TABLES `outletstock` WRITE;
/*!40000 ALTER TABLE `outletstock` DISABLE KEYS */;
INSERT INTO `outletstock` VALUES (12019,'Curry Powder',65,' koththamalli','352',100),(12012,'String Hoppers Flour',100,' rice','364',1000),(12022,'Chillie Powder',23,' chillie','186',50),(12024,'Test Product',100,'Test, Test','185',100),(12025,'aaaaaa',30,'abcd','178',100);
/*!40000 ALTER TABLE `outletstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `proName` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `ingredient` varchar(100) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=12027 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (12012,'String Hoppers Flour',100,' rice',2210,1000),(12014,'Rice Flour',300,' rice',2570,1000),(12018,'Chillie Powder',46,'chillie',2550,100),(12019,'Curry Powder',65,' koththamalli',3477,100),(12020,' Turmeric Powder',70,' turmeric',800,100),(12021,' Papadam',40,' flour',1500,70),(12022,'Chillie Powder',23,' chillie',3300,50),(12025,'aaaaaa',30,'abcd',3900,100),(12026,'noodles',90,' wheat,salt',2000,100);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profit`
--

DROP TABLE IF EXISTS `profit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profit` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `transactionType` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `transaction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transactionId`)
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profit`
--

LOCK TABLES `profit` WRITE;
/*!40000 ALTER TABLE `profit` DISABLE KEYS */;
INSERT INTO `profit` VALUES (1,'transactionType','0000-00-00','description',0,'transaction'),(1003,'Debit','2014-08-01','aaa',12345,'Salary pay'),(1006,'Debit','2014-08-08','sdadasddaas',123456,'Salary pay'),(1008,'Debit','2014-08-01','sanke me',12343,'Salary pay'),(1009,'Debit','2014-08-09','mansw',2222,'Salary pay'),(1010,'Debit','2014-08-01','djdls',121234,'Salary pay'),(1012,'Debit','2014-08-01','ansmmmmm',2132131,'Salary pay'),(1014,'Credit','2014-08-01','sdaosdhao',123231,'Salary pay'),(1015,'Debit','2014-09-30','hc-0908',1495,'Deliver Sales'),(1016,'Debit','2014-09-30','hc-0908',1495,'Deliver Sales'),(1017,'Debit','2014-10-01','nkaLHSK',1200,'transaction'),(1018,'Credit','2014-10-01','sndlka',2000,'transaction'),(1019,'Credit','2014-10-01','Sales',430,'Outlet Sales'),(1020,'Credit','2014-10-01','Sales',2650,'Outlet Sales'),(1021,'Credit','2014-10-01','Sales',1300,'Outlet Sales'),(1023,'Credit','2014-10-01','boc  |  bank :Malabeboc2016',1000,'Loan'),(1025,'Credit','2014-10-10','bla bla bla  |  vehicle no :na1254',200,'Vehicle Maintain'),(1026,'Credit','2014-10-01','Test  |  vehicle no :LG1213',200,'Vehicle Maintain'),(1027,'Debit','2014-10-01','test',3454,'Salary pay'),(1028,'Credit','2014-10-01','BOC  |  bank :GalleBOC2017',20000,'Loan'),(1029,'Credit','2014-10-01','Sales',677,'Outlet Sales'),(1030,'Credit','2014-10-01','test  |  vehicle no :na3421',400,'Vehicle Maintain');
/*!40000 ALTER TABLE `profit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `stockId` int(11) NOT NULL AUTO_INCREMENT,
  `manDate` varchar(20) DEFAULT NULL,
  `expDate` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `supplierID` varchar(45) DEFAULT NULL,
  `Rate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stockId`),
  KEY `fk11_idx` (`proId`),
  KEY `fk10_idx` (`proId`),
  KEY `fk101_idx` (`proId`),
  CONSTRAINT `asdf` FOREIGN KEY (`proId`) REFERENCES `product` (`itemId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (20,'aaaaaaa','bbbbbb',20,12012,100,'1234','90'),(25,'jlhjh','ggjg',31,12019,59,'mbmjg','hkjhk'),(26,'sdfcds','sscs',48,12019,45,'fgfd','40'),(27,'gfnh','hgd',100,12019,45,'hjj','43'),(28,'2014-10-01','2016-10-01',190,12018,NULL,NULL,NULL),(29,'2014-10-01','2016-10-01',1000,12014,NULL,NULL,NULL),(30,'2014-10-01','2016-10-01',1000,12014,NULL,NULL,NULL),(31,'2014-10-01','2016-10-01',800,12012,NULL,NULL,NULL),(32,'2014-10-01','2016-10-01',1000,12012,NULL,NULL,NULL),(33,'2014-10-01','2016-10-01',800,12019,NULL,NULL,NULL),(34,'2014-10-01','2016-10-01',1000,12019,NULL,NULL,NULL),(35,'2014-10-01','2016-10-01',1000,12021,NULL,NULL,NULL),(36,'2014-10-01','2016-10-01',600,12022,NULL,NULL,NULL),(37,'2014-10-01','2016-10-01',1000,12022,NULL,NULL,NULL),(38,'2014-10-01','2016-10-01',1000,12022,NULL,NULL,NULL),(39,'2014-10-01','2016-10-01',1000,12025,NULL,NULL,NULL),(40,'2014-10-01','2016-10-01',1000,12025,NULL,NULL,NULL),(41,'2014-10-01','2016-10-01',800,12025,NULL,NULL,NULL),(42,'2014-10-01','2016-10-01',1000,12025,NULL,NULL,NULL),(43,'2014-10-01','2014-10-31',40,12019,NULL,NULL,NULL);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppllier`
--

DROP TABLE IF EXISTS `suppllier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppllier` (
  `supId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `accNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`supId`)
) ENGINE=InnoDB AUTO_INCREMENT=20023 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppllier`
--

LOCK TABLES `suppllier` WRITE;
/*!40000 ALTER TABLE `suppllier` DISABLE KEYS */;
INSERT INTO `suppllier` VALUES (20014,'Koliya','Harshanath','Galle','dkharshanath@yahoo.com',719237354,1234356273),(20015,'Sankalpa','Udaranga','Galle','sankalpa@yahoo.com',719232343,1234356345),(20016,'Ridmi','Udarangi','Galle','udarangi@microsoft.com',112344567,1234356345),(20018,'Hasitha','Karunanayaka','Katubadda','karu.Hasitha@yahoo.com',912232665,1234672348),(20022,'Saman','Rathnapala','Colombo','abc@gmail.com ',987654324,9867545);
/*!40000 ALTER TABLE `suppllier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tax` (
  `taxId` int(11) NOT NULL AUTO_INCREMENT,
  `invoiceno` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `quartile` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`taxId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES (1,'12121','2014-10-01','Income Tax',12000,'Quartile One','hdsa'),(2,'1200','2014-10-01','Income Tax',12000,'Quartile Two','sgahd');
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sumisu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-02 10:55:13
