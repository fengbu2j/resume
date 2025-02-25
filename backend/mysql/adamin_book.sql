-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: adamin
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category` int DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `fee` int DEFAULT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Java Programming',1,'John Doe',10,'cover1.jpg','/books/java',11.2,3),(2,'Spring Framework',1,'Jane Smith',0,'cover2.jpg','/books/spring',0,22),(3,'Database Systems',2,'Michael Johnson',40,'cover3.jpg','/books/database',25.5,122),(4,'Data Structures',1,'Chris Lee',55,'cover4.jpg','/books/data-structures',32.99,200),(5,'Web Development',3,'Emily Davis',45,'cover5.jpg','/books/web-dev',27.99,131),(6,'Machine Learning',4,'Sarah Wilson',70,'cover6.jpg','/books/machine-learning',59.99,81),(7,'Deep Learning',4,'James Brown',80,'cover7.jpg','/books/deep-learning',89.99,62),(8,'Artificial Intelligence',4,'David White',75,'cover8.jpg','/books/ai',49.99,110),(9,'Computer Networks',2,'Linda Clark',65,'cover9.jpg','/books/computer-networks',35,90),(10,'Software Engineering',3,'Robert Harris',50,'cover10.jpg','/books/software-engineering',41.99,140),(11,'编程之美',1,'张三',50,'cover1.jpg','/books/programming',39.99,120),(12,'算法导论',1,'李四',60,'cover2.jpg','/books/algorithm',49.99,200),(13,'数据库系统概论',2,'王五',45,'cover3.jpg','/books/database',29.99,150),(14,'数据结构与算法',1,'赵六',55,'cover4.jpg','/books/data-structure',35.99,180),(15,'前端开发实战',3,'钱七',40,'cover5.jpg','/books/frontend',29.5,130),(16,'机器学习实战',4,'孙八',70,'cover6.jpg','/books/machine-learning',69.99,90),(17,'深度学习入门',4,'周九',75,'cover7.jpg','/books/deep-learning',89.99,80),(18,'人工智能基础',4,'吴十',80,'cover8.jpg','/books/ai-foundation',59.99,100),(19,'计算机网络',2,'郑十一',65,'cover9.jpg','/books/computer-networks',42.5,110),(20,'示例书名',1,'作者姓名',10,'http://example.com/cover.jpg','http://example.com/path/to/resource',9.99,6),(23,'示例书名',1,'作者姓名',10,'http://example.com/cover.jpg','http://example.com/path/to/resource',9.99,5),(24,'示例书名',1,'作者姓名',10,'http://example.com/cover.jpg','http://example.com/path/to/resource',9.99,5),(25,'数据库',1,'hash',12,'C:\\Users\\Administrator\\Desktop\\uploads\\5d38b08a-a207-4646-bba3-7c504c3310c7_数据库基本信息.xlsx','C:\\Users\\Administrator\\Desktop\\uploads\\5d38b08a-a207-4646-bba3-7c504c3310c7_数据库基本信息.xlsx',123.1,2),(26,'数据库',1,'hash',12,'C:\\Users\\Administrator\\Desktop\\uploads\\6cf3de59-8526-4b6f-a2f9-46b8d76592bd_数据库基本信息.xlsx','C:\\Users\\Administrator\\Desktop\\uploads\\6cf3de59-8526-4b6f-a2f9-46b8d76592bd_数据库基本信息.xlsx',123.1,2),(27,'实验报告',1,'吴兆延',0,'C:\\Users\\Administrator\\Desktop\\uploads\\ab7df56e-bda6-48d6-8957-2e3680a1eb62_计算机排球进馆人员信息表(1).xlsx','C:\\Users\\Administrator\\Desktop\\uploads\\9199c8a0-aff2-4f46-9ca7-64f7320572dd_第1次实验报告-简单数据类型和流程控制.doc',0.99,2),(29,'java',2,'作者',0,'C:\\Users\\Administrator\\Desktop\\uploads\\19a0d157-a41e-434e-ad0b-45fd83b2cfe0_fc9770bc_E889051_cd828fa0.png','C:\\Users\\Administrator\\Desktop\\uploads\\4da363e5-b886-46bb-9355-9612627f1fd4_任务书.pdf',0,22);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-18 16:22:05
