CREATE DATABASE  IF NOT EXISTS `davendiv` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `davendiv`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: davendiv
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentid` varchar(100) NOT NULL,
  `postid` varchar(100) NOT NULL,
  `sendby` bigint(20) NOT NULL,
  `text` longtext NOT NULL,
  PRIMARY KEY (`commentid`,`postid`),
  UNIQUE KEY `commentid` (`commentid`),
  UNIQUE KEY `commentid_2` (`commentid`),
  KEY `FK38A5EE5F8F243D13` (`postid`),
  CONSTRAINT `FK38A5EE5F8F243D13` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connectiondetails`
--

DROP TABLE IF EXISTS `connectiondetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connectiondetails` (
  `connid` bigint(20) NOT NULL AUTO_INCREMENT,
  `conusername` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`connid`),
  KEY `FKAFEF9DA43B27F076` (`userid`),
  CONSTRAINT `FKAFEF9DA43B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectiondetails`
--

LOCK TABLES `connectiondetails` WRITE;
/*!40000 ALTER TABLE `connectiondetails` DISABLE KEYS */;
INSERT INTO `connectiondetails` VALUES (1,'divyansh','confirm',7),(2,'new','confirm',3);
/*!40000 ALTER TABLE `connectiondetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connectionnotification`
--

DROP TABLE IF EXISTS `connectionnotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connectionnotification` (
  `connid` bigint(20) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `notid` bigint(20) NOT NULL,
  PRIMARY KEY (`notid`),
  KEY `FKC211AAC9866546D1` (`notid`),
  CONSTRAINT `FKC211AAC9866546D1` FOREIGN KEY (`notid`) REFERENCES `notification` (`notid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectionnotification`
--

LOCK TABLES `connectionnotification` WRITE;
/*!40000 ALTER TABLE `connectionnotification` DISABLE KEYS */;
INSERT INTO `connectionnotification` VALUES (NULL,'new',1);
/*!40000 ALTER TABLE `connectionnotification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `davenfeed`
--

DROP TABLE IF EXISTS `davenfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `davenfeed` (
  `davenid` varchar(100) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `post` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`davenid`,`userid`),
  UNIQUE KEY `davenid` (`davenid`),
  UNIQUE KEY `davenid_2` (`davenid`),
  KEY `FK5BC422A03B27F076` (`userid`),
  CONSTRAINT `FK5BC422A03B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `davenfeed`
--

LOCK TABLES `davenfeed` WRITE;
/*!40000 ALTER TABLE `davenfeed` DISABLE KEYS */;
INSERT INTO `davenfeed` VALUES ('some',3,'undefined'),('Tue Apr 26 08:39:51 EDT 2016',3,'afhiauhdadsas');
/*!40000 ALTER TABLE `davenfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `eduid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`eduid`),
  UNIQUE KEY `eduid` (`eduid`),
  KEY `FKEEAB67A83B27F076` (`userid`),
  CONSTRAINT `FKEEAB67A83B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `expid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`expid`),
  UNIQUE KEY `expid` (`expid`),
  KEY `FKFAE6596A3B27F076` (`userid`),
  CONSTRAINT `FKFAE6596A3B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `groupid` bigint(20) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `owner` varchar(20) NOT NULL,
  PRIMARY KEY (`groupid`),
  UNIQUE KEY `groupid` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupfeedrecord`
--

DROP TABLE IF EXISTS `groupfeedrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupfeedrecord` (
  `postid` varchar(100) NOT NULL,
  `groupid` bigint(20) NOT NULL,
  PRIMARY KEY (`postid`,`groupid`),
  KEY `FK1169472E7DB486A1` (`groupid`),
  KEY `FK1169472E8F243D13` (`postid`),
  CONSTRAINT `FK1169472E7DB486A1` FOREIGN KEY (`groupid`) REFERENCES `group` (`groupid`),
  CONSTRAINT `FK1169472E8F243D13` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupfeedrecord`
--

LOCK TABLES `groupfeedrecord` WRITE;
/*!40000 ALTER TABLE `groupfeedrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupfeedrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inbox` (
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`),
  KEY `FK5FB22863B27F076` (`userid`),
  CONSTRAINT `FK5FB22863B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inbox`
--

LOCK TABLES `inbox` WRITE;
/*!40000 ALTER TABLE `inbox` DISABLE KEYS */;
/*!40000 ALTER TABLE `inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pass` varchar(20) NOT NULL,
  `uname` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','admin'),(2,'user','user'),(3,'d','divyansh'),(5,'world','world'),(6,'prof','prof'),(7,'new','new');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messegeid` varchar(50) NOT NULL,
  `reciever` bigint(20) NOT NULL,
  `msg_body` longtext,
  `sender` bigint(20) NOT NULL,
  `subject` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`messegeid`,`reciever`),
  UNIQUE KEY `messegeid` (`messegeid`),
  UNIQUE KEY `messegeid_2` (`messegeid`),
  KEY `FK38EB00073C53C945` (`reciever`),
  CONSTRAINT `FK38EB00073C53C945` FOREIGN KEY (`reciever`) REFERENCES `inbox` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notid` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`notid`),
  KEY `FK237A88EB3B27F076` (`userid`),
  CONSTRAINT `FK237A88EB3B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'new is now your connection','confirm','Connection',3);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_info`
--

DROP TABLE IF EXISTS `personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_info` (
  `personid` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`personid`),
  UNIQUE KEY `personid` (`personid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_info`
--

LOCK TABLES `personal_info` WRITE;
/*!40000 ALTER TABLE `personal_info` DISABLE KEYS */;
INSERT INTO `personal_info` VALUES (1,NULL,'USA','div',NULL,NULL,NULL,'MA'),(2,NULL,'USA','crazy',NULL,NULL,NULL,'MA'),(3,'world','Turkey','alpha','beta','one',NULL,'hello'),(5,'uuu','U.S. Virgin Islands','asd','uyi','bkj',NULL,'bgh'),(6,'rrtdtf','Taiwan','njasnd','dreser','gyct',NULL,'xdr'),(7,'yt','Gabon','new','gyu','jh',NULL,'yfv');
/*!40000 ALTER TABLE `personal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `postid` varchar(100) NOT NULL,
  `postmsg` longtext NOT NULL,
  `posttime` datetime NOT NULL,
  PRIMARY KEY (`postid`),
  UNIQUE KEY `postid` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectid` varchar(50) NOT NULL,
  `enddate` datetime DEFAULT NULL,
  `projectdetail` longtext,
  `startdate` datetime DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `eduid` bigint(20) DEFAULT NULL,
  `expid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`projectid`),
  UNIQUE KEY `projectid` (`projectid`),
  KEY `FKED904B19E81EB341` (`eduid`),
  KEY `FKED904B1983929A1A` (`expid`),
  CONSTRAINT `FKED904B1983929A1A` FOREIGN KEY (`expid`) REFERENCES `experience` (`expid`),
  CONSTRAINT `FKED904B19E81EB341` FOREIGN KEY (`eduid`) REFERENCES `education` (`eduid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (101,'admin'),(102,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `sessionid` varchar(200) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `hostname` varchar(20) DEFAULT NULL,
  `session` varchar(20) DEFAULT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`sessionid`,`userid`),
  UNIQUE KEY `sessionid` (`sessionid`),
  UNIQUE KEY `sessionid_2` (`sessionid`),
  KEY `FK53BFD09D3B27F076` (`userid`),
  CONSTRAINT `FK53BFD09D3B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `userid` bigint(20) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK143BF46A928B6F3F` (`roleid`),
  KEY `FK143BF46A3B27F076` (`userid`),
  CONSTRAINT `FK143BF46A3B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `FK143BF46A928B6F3F` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,101),(1,102),(2,102);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroup`
--

DROP TABLE IF EXISTS `usergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroup` (
  `userid` bigint(20) NOT NULL,
  `groupid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`,`groupid`),
  KEY `FK14ACB1947DB486A1` (`groupid`),
  KEY `FK14ACB1943B27F076` (`userid`),
  CONSTRAINT `FK14ACB1943B27F076` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `FK14ACB1947DB486A1` FOREIGN KEY (`groupid`) REFERENCES `group` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroup`
--

LOCK TABLES `usergroup` WRITE;
/*!40000 ALTER TABLE `usergroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountstatus` int(11) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `logicalpic` varchar(255) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `pass` varchar(20) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `theme` varchar(20) DEFAULT NULL,
  `timezone` varchar(20) DEFAULT NULL,
  `uname` varchar(50) NOT NULL,
  `user_url` varchar(20) DEFAULT NULL,
  `Personal_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`),
  KEY `FK6A68E0833F2F0EA` (`Personal_FK`),
  CONSTRAINT `FK6A68E0833F2F0EA` FOREIGN KEY (`Personal_FK`) REFERENCES `personal_info` (`personid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,NULL,NULL,'admin@davendiv.com','admin',NULL,NULL,NULL,'admin',NULL,1),(2,0,NULL,NULL,'user@davendiv.com','user',NULL,NULL,NULL,'user',NULL,2),(3,1,NULL,'C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\31461665863404logo2.jpg','divyansh@gmail.com','d','C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\31461665863404logo2.jpg',NULL,NULL,'divyansh',NULL,3),(5,0,NULL,'C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\51461665954813WIN_20151112_031851.JPG','world@imge.com','world','C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\51461665954813WIN_20151112_031851.JPG',NULL,NULL,'world',NULL,5),(6,0,NULL,'C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\61461673699937DSC_0165.JPG','prof@gmail.com','prof','C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\61461673699937DSC_0165.JPG',NULL,NULL,'prof',NULL,6),(7,0,NULL,'C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\71461674337948DSC_0133.JPG','new@jksocn.cm','new','C:\\software\\STS\\sts-bundle\\sts-3.7.3.RELEASE\\webapp\\resources\\div-picture\\71461674337948DSC_0133.JPG',NULL,NULL,'new',NULL,7);
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

-- Dump completed on 2016-04-26  8:41:54
