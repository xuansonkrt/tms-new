-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: db_tms
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_type_id` bigint(20) DEFAULT NULL,
  `effect_date` date DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `the_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Giao_Su','Giáo sư',1,'2019-12-02','2019-12-22',NULL,NULL,'2019-12-21 18:27:58',0,1),(2,'PGS','Phó giáo sư',1,'2019-12-02','2020-01-02','2019-12-21 18:22:41',0,NULL,NULL,2),(3,'master','master',1,'2019-12-04','2019-12-17','2019-12-21 18:27:48',0,NULL,NULL,3),(34,'TG','Trợ giảng',7,NULL,NULL,'2019-12-21 23:38:14',0,NULL,NULL,1),(35,'GV','Giảng viên',7,'2019-12-01','2019-12-31','2019-12-21 23:38:31',0,'2019-12-21 23:38:55',0,2),(36,'GVC','Giảng viên chính',7,NULL,NULL,'2019-12-21 23:38:47',0,NULL,NULL,3),(37,'GVCC','Giảng viên cao cấp',7,NULL,NULL,'2019-12-21 23:39:11',0,NULL,NULL,4),(38,'CD','Cao đẳng',8,NULL,NULL,'2019-12-22 13:17:20',0,NULL,NULL,1),(39,'DH','Đại học',8,'2019-12-01','2019-12-25','2019-12-22 13:17:29',0,'2019-12-22 13:17:45',0,2),(40,'SDH','Sau đại học',8,NULL,NULL,'2019-12-22 13:17:38',0,NULL,NULL,3),(41,'CN','Cử nhân',2,NULL,NULL,'2019-12-24 17:05:48',0,NULL,NULL,NULL),(42,'KS','Kỹ sư',2,NULL,NULL,'2019-12-24 17:05:57',0,NULL,NULL,NULL),(43,'ThS','Thạc sỹ',2,NULL,NULL,'2019-12-24 17:06:10',0,NULL,NULL,NULL),(44,'TS','Tiến sỹ',2,NULL,NULL,'2019-12-24 17:06:18',0,NULL,NULL,NULL),(45,'CU','Chuẩn úy',10,NULL,NULL,'2019-12-24 17:06:47',0,NULL,NULL,NULL),(46,'TU','Thiếu úy',10,NULL,NULL,'2019-12-24 17:06:55',0,NULL,NULL,NULL),(47,'TrU','Trung úy',10,NULL,NULL,'2019-12-24 17:07:11',0,NULL,NULL,NULL),(48,'ThU','Thượng Úy',10,NULL,NULL,'2019-12-24 17:07:31',0,NULL,NULL,NULL),(49,'DU','Đại úy',10,NULL,NULL,'2019-12-24 17:07:38',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_type`
--

DROP TABLE IF EXISTS `category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `effect_date` date DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_type`
--

LOCK TABLES `category_type` WRITE;
/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
INSERT INTO `category_type` VALUES (1,'HOC_HAM','Học hàm','2019-12-02','2020-01-01',NULL,NULL,'2019-12-20 15:49:39',0),(2,'HOC_VI','Học vị','2019-12-10','2019-12-30',NULL,NULL,'2019-12-20 15:53:33',0),(5,'CHUC_VU_DANG','Chức vụ Đảng','2019-12-02','2019-12-24','2019-12-20 15:54:36',0,NULL,NULL),(6,'CHUC_VU_CHINH_QUYEN','Chức vụ chính quyền','2019-12-17','2019-12-26','2019-12-20 15:55:06',0,NULL,NULL),(7,'CDNG','Chức danh nhà giáo',NULL,NULL,'2019-12-21 23:37:56',0,NULL,NULL),(8,'EDU_LEVEL','Cấp học',NULL,NULL,'2019-12-22 13:16:57',0,NULL,NULL),(10,'CAP_BAC','Cấp bậc',NULL,NULL,'2019-12-24 17:03:30',0,NULL,NULL);
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `term_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `student_amount` int(11) DEFAULT NULL,
  `education_level_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'345','34534',3,1,300,38,'2019-12-23 16:26:03',0,NULL,NULL),(2,'2312321','Lập trình nâng cao 1',4,3,100,39,'2019-12-23 16:45:00',0,NULL,NULL),(3,'111555','Lập trình nâng cao 2',4,3,111,39,'2019-12-23 16:46:32',0,'2019-12-23 16:48:36',0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_type`
--

DROP TABLE IF EXISTS `learning_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `learning_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education_level_id` bigint(20) DEFAULT NULL,
  `is_detail` tinyint(1) DEFAULT NULL,
  `factor` double DEFAULT NULL,
  `unit` double DEFAULT NULL,
  `unit_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_type`
--

LOCK TABLES `learning_type` WRITE;
/*!40000 ALTER TABLE `learning_type` DISABLE KEYS */;
INSERT INTO `learning_type` VALUES (1,'123','123','update   ',39,NULL,1,1,'1','2019-12-22 13:24:23',0,'2019-12-22 13:29:19',0);
/*!40000 ALTER TABLE `learning_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `path` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `the_order` int(11) DEFAULT NULL,
  `founded_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'0001','Học viện Kỹ thuật Quân sự ','                            ','','','',NULL,'/1/',1,1,NULL,NULL,NULL,'2019-12-24 12:10:49',0),(2,'0002','Khoa Công nghệ thông tin','                            ','','','Tầng 19 - S1',1,'/1/2/',2,2,'2019-12-03',NULL,NULL,'2019-12-24 12:08:21',0),(3,'0003','Khoa Xây dựng',NULL,NULL,NULL,NULL,1,'/1/3/',2,3,NULL,NULL,NULL,NULL,NULL),(4,'0004','Bộ môn Toán','                            ','','sonnx115@d2t.vn','',2,'/1/2/4/',3,4,'2019-12-09',NULL,NULL,'2019-12-24 11:51:07',0),(7,'3424','Bộ môn An toàn thông tin','                            ','234','234','234',2,'/1/2/7/',3,NULL,'2019-12-03','2019-12-24 11:56:42',0,NULL,NULL),(8,'224','Bộ môn Mạng máy tính','                            ','34534','345','236 Hoàng Quốc Việt',2,'/1/2/8/',3,NULL,'2019-12-11','2019-12-24 12:11:26',0,NULL,NULL),(9,'12312','Khoa Tác chiến điện tử','                            ','','','',1,'/1/9/',2,NULL,'2020-01-08','2020-01-01 17:22:56',4,'2020-01-01 17:27:17',4);
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper_type`
--

DROP TABLE IF EXISTS `paper_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paper_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paper_level_id` bigint(20) DEFAULT NULL,
  `research_point` double DEFAULT NULL,
  `unit` double DEFAULT NULL,
  `unit_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_type`
--

LOCK TABLES `paper_type` WRITE;
/*!40000 ALTER TABLE `paper_type` DISABLE KEYS */;
INSERT INTO `paper_type` VALUES (5,'HOITHAO','Hội nghị Khoa học trong nước','Hệ số quy chuẩn 100 cho 1 bài chia đều cho các tác giả                            ',NULL,100,1,'Bài','2020-01-04 14:46:59',4,NULL,NULL),(6,'TAPCHI','Tạp chí Khoa học trong nước','Hệ số quy chuẩn 150 cho 1 bài chia đều cho các tác giả',NULL,150,1,'Bài','2020-01-04 14:48:50',4,NULL,NULL),(7,'HOITHAOQUOCTE','Hội nghị Khoa học quốc tế','Hệ số quy chuẩn 150 cho 1 bài chia đều cho các tác giả                            ',NULL,150,1,'Bài','2020-01-04 14:49:30',4,NULL,NULL),(8,'TAPCHIQUOCTE','Tạp chí Khoa học quốc tế','Hệ số quy chuẩn 150 cho 1 bài chia đều cho các tác giả                            ',NULL,150,1,'Bài','2020-01-04 14:49:57',4,NULL,NULL);
/*!40000 ALTER TABLE `paper_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_hash` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `army_rank_id` bigint(20) DEFAULT NULL,
  `academic_level_id` bigint(20) DEFAULT NULL,
  `academic_title_id` bigint(20) DEFAULT NULL,
  `level_title_id` bigint(20) DEFAULT NULL,
  `avatar` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teaching` tinyint(1) DEFAULT NULL,
  `manager` tinyint(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (2,'3434534','Nguyễn Xuân Sơn',0,'2019-12-26','24234234','sonnx@d2t.vn','Hưng Yên','sonnx',NULL,7,46,41,3,37,'/link/1577210174-62261310_2289064291214067_2593609266904432640_n.png',NULL,NULL,'2019-12-24 17:45:37',0,'2019-12-25',0),(3,'3534','DỰ ÁN BẮC NAM edit',0,'2019-12-18','1','xuansonkaratedo.com@gmail.com','1','sonnx1',NULL,3,46,43,1,37,'/link/1577188763-IMG_2286.png',NULL,NULL,'2019-12-24 17:53:55',0,'2019-12-24',0),(4,'234234','Nguyễn Xuân Sơn',NULL,'2019-12-10','','','','sonnx0','$2a$10$jK5VikL3D9wWzcAQnolhO.w79RFPwLfidjJhCWJujO/k7RK90za16',7,46,41,3,NULL,'/link/1577207477-IMG_2286.png',NULL,NULL,'2019-12-24 23:50:02',0,'2020-01-03',4),(5,'2423432','Xuân chạy , hạ đi , thu dừng , đông lùi lại',NULL,'2019-12-18','','','','sonnx11','$2a$10$koYRecO1N5hE6s6SVsKO.Oh564be6339s655PRdNBQ6g2STYAohb6',NULL,49,43,3,34,'/link/1577244579-IMG_9405-3.jpg',NULL,NULL,'2019-12-25 10:29:39',4,NULL,NULL),(6,'#9465fc','Alvy Abbotts',1,'1960-09-03',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(7,'#f5de9b','Honor McMeanma',1,'1964-03-23',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(8,'#e01102','Olive Duplock',0,'1968-07-14',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(9,'#d3d62f','Olav Tours',0,'1971-12-29',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(10,'#b6a39e','Calvin Tristram',0,'1968-12-26',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(11,'#159d09','Gilberte Bills',1,'1997-07-20',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(12,'#56d210','Thornie Fitzharris',0,'1974-10-14',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(13,'#9ee42c','Codi Cansdill',1,'1997-02-17',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(14,'#fe55e6','Jerrylee Neilly',0,'1990-05-25',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL),(15,'#088e2c','Nari Tellenbach',1,'1960-07-08',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,'/link/avatar.png',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_course`
--

DROP TABLE IF EXISTS `staff_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `learning_type_id` bigint(20) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `edu_point` double DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `finish_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_course`
--

LOCK TABLES `staff_course` WRITE;
/*!40000 ALTER TABLE `staff_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_paper`
--

DROP TABLE IF EXISTS `staff_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` bigint(20) DEFAULT NULL,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_author` int(11) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `research_point` decimal(10,2) DEFAULT NULL,
  `paper_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_paper`
--

LOCK TABLES `staff_paper` WRITE;
/*!40000 ALTER TABLE `staff_paper` DISABLE KEYS */;
INSERT INTO `staff_paper` VALUES (2,NULL,'34','3423','34',3,NULL,NULL,NULL,NULL,'2020-01-03 18:21:51',4,NULL,NULL,78.00,2),(5,4,'13','3443','Nguyễn Xuân Sơn; Phan Trung Kiên',2,'2019-12-25',1,2019,7,'2020-01-04 14:51:08',4,'2020-01-04 14:58:03',4,75.00,6),(6,4,'32','Bài báo 1','Trần Trung Kiên',1,'2020-02-10',2,2019,NULL,'2020-01-04 14:59:04',4,NULL,NULL,150.00,8),(7,4,'123','DỰ ÁN BẮC NAM edit','Nguyễn Xuân Sơn, Nguyễn Hữu Mạnh',2,'2019-12-29',1,2019,NULL,'2020-01-04 15:06:06',4,NULL,NULL,75.00,7);
/*!40000 ALTER TABLE `staff_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_role`
--

DROP TABLE IF EXISTS `staff_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_role`
--

LOCK TABLES `staff_role` WRITE;
/*!40000 ALTER TABLE `staff_role` DISABLE KEYS */;
INSERT INTO `staff_role` VALUES (1,2,1),(2,4,1),(3,5,2);
/*!40000 ALTER TABLE `staff_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `education_level_id` bigint(20) DEFAULT NULL,
  `learning_type_id` bigint(20) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL COMMENT 'số tín chỉ',
  `class_period` int(11) DEFAULT NULL COMMENT 'số tiết',
  `organization_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'123','234','                            ',38,NULL,123,1233,8,'2019-12-23 00:24:06',0,'2019-12-24 14:36:56',0),(3,'2313123','Lập trình nâng cao','                            ',39,NULL,3,90,NULL,'2019-12-23 16:20:25',0,NULL,NULL),(4,'3232232','Cơ sở dữ liệu nâng cao','                            ',39,NULL,2,50,2,'2019-12-24 14:39:11',0,NULL,NULL);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `target`
--

DROP TABLE IF EXISTS `target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `target` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `edu_duty` int(11) DEFAULT NULL COMMENT 'định mức giảng dạy\n',
  `research_duty` int(11) DEFAULT NULL COMMENT 'định mức nghiên cứu',
  `the_type` bigint(20) DEFAULT NULL,
  `staff_property_id` bigint(20) DEFAULT NULL COMMENT 'id chức danh',
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `target`
--

LOCK TABLES `target` WRITE;
/*!40000 ALTER TABLE `target` DISABLE KEYS */;
INSERT INTO `target` VALUES (2,23,32,7,37,'2019-12-22 01:00:09',0,NULL,NULL),(4,123,123,7,34,'2019-12-22 01:03:37',0,NULL,NULL),(5,123,123,7,36,'2019-12-22 01:08:36',0,NULL,NULL),(6,343,343,7,35,'2019-12-22 01:08:56',0,NULL,NULL);
/*!40000 ALTER TABLE `target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term`
--

DROP TABLE IF EXISTS `term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `term` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `the_order` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term`
--

LOCK TABLES `term` WRITE;
/*!40000 ALTER TABLE `term` DISABLE KEYS */;
INSERT INTO `term` VALUES (3,'HK2','Học kỳ 2 update',2019,'2020-01-06','2020-06-30',2,'2019-12-21 22:57:19',0,'2020-01-04 14:29:35',4),(4,'HK1','Học kỳ 1',2019,'2019-08-01','2020-01-05',1,'2019-12-23 16:44:17',0,'2020-01-04 14:29:17',4),(5,'HK1','Học kỳ 1',2020,'2020-08-01','2021-01-02',1,'2020-01-04 15:05:00',4,NULL,NULL),(6,'HK2','Học kỳ 2',2020,'2021-01-04','2021-07-30',2,'2020-01-04 15:05:33',4,NULL,NULL);
/*!40000 ALTER TABLE `term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_tms'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 15:46:14
