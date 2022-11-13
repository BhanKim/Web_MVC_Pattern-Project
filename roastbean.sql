-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: roastbean
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(30) NOT NULL,
  `admin_pw` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','qwer1234');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beaninfo`
--

DROP TABLE IF EXISTS `beaninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beaninfo` (
  `beaninfo_id` int NOT NULL AUTO_INCREMENT,
  `beaninfo_name` varchar(45) DEFAULT NULL,
  `beaninfo_content` text,
  `beaninfo_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`beaninfo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beaninfo`
--

LOCK TABLES `beaninfo` WRITE;
/*!40000 ALTER TABLE `beaninfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `beaninfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_seq` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `product_id` int NOT NULL,
  `cart_qty` int DEFAULT NULL,
  `cart_date` date DEFAULT NULL,
  PRIMARY KEY (`cart_seq`,`user_id`,`product_id`),
  KEY `fk_cart_user1_idx` (`user_id`),
  KEY `fk_cart_product1_idx` (`product_id`),
  CONSTRAINT `fk_cart_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_seq` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `category_type` varchar(45) DEFAULT NULL,
  `category_acidity` varchar(5) DEFAULT NULL,
  `category_aroma` varchar(5) DEFAULT NULL,
  `category_body` varchar(5) DEFAULT NULL,
  `category_sweet` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`category_seq`,`product_id`),
  KEY `fk_category_product1_idx` (`product_id`),
  CONSTRAINT `fk_category_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,1,'G블렌딩','1.5','2','4','4'),(2,2,'산미강한','4.5','5','2.5','3'),(3,3,'산미없는','1','3','4','3.5'),(4,4,'싱글오리진','2','3','4.5','5'),(5,5,'G블렌딩','1.5','3','5','5'),(6,20,'디카페인','1','1','1','1'),(7,6,'싱글오리진','4','4','3.5','3.5'),(8,7,'산미중간','3','3','4','4'),(9,19,'산미약간','3.5','4','4','4.5'),(10,9,'산미강한','4','4','2','2'),(11,14,'산미중간','3','4','3.5','4'),(12,15,'산미약간','2','3.5','3','4'),(13,10,'산미없는','1.5','2.5','3.5','4'),(14,16,'G블렌딩','3.5','4','3','3.5'),(15,8,'싱글오리진','1.5','3','5','3.5'),(16,12,'산미강한','4','4','3','3.5'),(17,18,'산미약간','2.5','3','4','4'),(18,11,'산미없는','2','3.5','3','4'),(19,13,'싱글오리진','3','3.5','4.5','4'),(20,17,'싱글오리진','4','4.5','3','3');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community` (
  `community_id` int NOT NULL AUTO_INCREMENT,
  `community_name` varchar(30) NOT NULL,
  `community_title` varchar(100) DEFAULT NULL,
  `community_content` varchar(3000) DEFAULT NULL,
  `community_hit` int DEFAULT NULL,
  `community_group` int DEFAULT NULL,
  `community_step` int DEFAULT NULL,
  `community_indent` int DEFAULT NULL,
  `community_cnt` int DEFAULT NULL,
  `community_initdate` datetime DEFAULT NULL,
  `community_updatedate` datetime DEFAULT NULL,
  `community_deletedate` datetime DEFAULT NULL,
  PRIMARY KEY (`community_id`,`community_name`),
  KEY `fk_community_user1_idx` (`community_name`),
  CONSTRAINT `fk_community_user1` FOREIGN KEY (`community_name`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_comment`
--

DROP TABLE IF EXISTS `community_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_comment` (
  `community_comment_cono` int NOT NULL AUTO_INCREMENT,
  `community_id` int NOT NULL,
  `community_comment_name` varchar(45) DEFAULT NULL,
  `community_comment_content` varchar(45) DEFAULT NULL,
  `community_comment_codate` datetime DEFAULT NULL,
  PRIMARY KEY (`community_comment_cono`,`community_id`),
  KEY `fk_community_comment_community1_idx` (`community_id`),
  CONSTRAINT `fk_community_comment_community1` FOREIGN KEY (`community_id`) REFERENCES `community` (`community_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_comment`
--

LOCK TABLES `community_comment` WRITE;
/*!40000 ALTER TABLE `community_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `community_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage`
--

DROP TABLE IF EXISTS `manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage` (
  `manage_id` int NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(30) NOT NULL,
  `product_id` int NOT NULL,
  `manage_date` date DEFAULT NULL,
  `manage_qty` int DEFAULT NULL,
  PRIMARY KEY (`manage_id`,`admin_id`,`product_id`),
  KEY `fk_manage_product1_idx` (`product_id`),
  KEY `fk_manage_admin1_idx` (`admin_id`),
  CONSTRAINT `fk_manage_admin1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`),
  CONSTRAINT `fk_manage_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage`
--

LOCK TABLES `manage` WRITE;
/*!40000 ALTER TABLE `manage` DISABLE KEYS */;
/*!40000 ALTER TABLE `manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_write`
--

DROP TABLE IF EXISTS `notice_write`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_write` (
  `notice_write_seq` int NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(30) NOT NULL,
  `notice_write_title` varchar(45) DEFAULT NULL,
  `notice_write_content` text,
  `notice_write_initdate` date DEFAULT NULL,
  `notice_write_updatedate` date DEFAULT NULL,
  `notice_write_deletedate` date DEFAULT NULL,
  PRIMARY KEY (`notice_write_seq`,`admin_id`),
  KEY `fk_notice_write_admin1_idx` (`admin_id`),
  CONSTRAINT `fk_notice_write_admin1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_write`
--

LOCK TABLES `notice_write` WRITE;
/*!40000 ALTER TABLE `notice_write` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_write` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_seq` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `product_id` int NOT NULL,
  `order_name` varchar(30) DEFAULT NULL,
  `order_addresszipcode` varchar(100) DEFAULT NULL,
  `order_address1` varchar(100) DEFAULT NULL,
  `order_address2` varchar(100) DEFAULT NULL,
  `order_address3` varchar(100) DEFAULT NULL,
  `order_qty` int DEFAULT NULL,
  `order_price` int DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_email` varchar(100) DEFAULT NULL,
  `order_telno` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`order_seq`,`user_id`,`product_id`),
  KEY `fk_orders_user1_idx` (`user_id`),
  KEY `fk_orders_product1_idx` (`product_id`),
  CONSTRAINT `fk_orders_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_orders_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_weight` int DEFAULT NULL,
  `product_info` varchar(100) DEFAULT NULL,
  `product_image` varchar(150) DEFAULT NULL,
  `product_initdate` date DEFAULT NULL,
  `product_updatedate` date DEFAULT NULL,
  `product_deletedate` date DEFAULT NULL,
  `product_price` int DEFAULT NULL,
  `product_stock` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'G블렌딩 딥블랙 아라비카 블렌드',200,'구수한 깊은 바디감의 고소한 단맛, 카페용 도매가격 에스프레소 원두','1.png','2022-11-13',NULL,NULL,7300,30),(2,'에티오피아 코케 허니 예가체프 G1',200,'입안을 채우는 다채로운 향과 맛. 꿀처럼 달콤한 맛과 싱그러운 산미의 조화','2.png','2022-11-13',NULL,NULL,11500,30),(3,'과테말라 안티구아 SHB',200,'고소한 구수한 신맛적은(없는) 중강배전 커피원두로 갓볶아 배송, 도매가 판매중입니다.','3.png','2022-11-13',NULL,NULL,8200,30),(4,'케냐 AA 키암부 원두커피',200,'은은하게 스며나오는 소량의 산미. 다크초콜릿의 깊은 향과 단맛. 젠더를 넘나드는 바디감','4.png','2022-11-13',NULL,NULL,11800,30),(5,'G블렌딩 오리지널 커피원두',200,'케냐원두 특유의 맛과 향, 묵직하고 남성적인 바디감과 단맛이 섞인 최고의 블렌딩','5.png','2022-11-13',NULL,NULL,9900,30),(6,'에티오피아 모모라 구지 G1 내추럴',200,'딸기와 꿀의 바디감 뒤 느껴지는 환상적인 후미','6.png','2022-11-13',NULL,NULL,16200,30),(7,'콜롬비아 산타로사 수프리모 커피원두',200,'꽃향기, 부드럽고 은은한 산미와 고소한 견과류의 만남','7.png','2022-11-13',NULL,NULL,9900,30),(8,'인도네시아 만델링 G1 커피원두',200,'매우 풍부한 바디감과 짙은 흙내음. 견과류의 고소함과 흑설탕의 단맛','8.png','2022-11-13',NULL,NULL,9400,30),(9,'에티오피아 예가체프 G2 프리미엄',200,'매우 밝은 산미, 과하지 않는 단맛과 가벼운 바디감. 꽃향 가득 피어오르는 여성스러움','9.png','2022-11-13',NULL,NULL,8300,30),(10,'콜롬비아 후일라 수프리모 커피원두',200,'가벼운 산미와 헤이즐럿 혹은 바닐라류의 달콤함.무겁지 않은 바디감과 부드러운 목넘김.잘 짜여진 밸런스','10.png','2022-11-13',NULL,NULL,8000,30),(11,'브라질 세하도 FC NY2 커피원두',200,'부드러운 향, 적당한 바디감. 로스팅 포인트 시티후반에서 잡아낸 섬세한 단맛과 호두의 향','11.png','2022-11-13',NULL,NULL,6300,30),(12,'에티오피아 아리차 예가체프 G1 내추럴',200,'싱그러운 장미의 신맛 끝에 오는 달콤한 후미','12.png','2022-11-13',NULL,NULL,12600,30),(13,'케냐 AA Plus 아이히더 커피원두',200,'라임의 깔끔한 산미와 입안에서 느껴지는 부드러운 촉감','13.png','2022-11-13',NULL,NULL,12800,30),(14,'G블렌딩 블루라마 커피원두',200,'밀크초콜릿과 바닐라의 단맛, 알싸한 꽃향기와 온화한 산미의 만남. 부드러운 바디와 깔끔한 후미의 블렌딩','14.png','2022-11-13',NULL,NULL,9900,30),(15,'코스타리카 따라주 SHB 커피원두',200,'커피의 진주. 와인의 향, 부드러운 산미와 바디감이 균형을 이룸','15.png','2022-11-13',NULL,NULL,9300,30),(16,'G블렌딩 먼로화이트 스페셜티 블렌드',200,'베리류의 산미, 요거트향과 달콤한 바디, 부드러운 촉감, 실크, 꽃과 과일','16.png','2022-11-13',NULL,NULL,12600,30),(17,'에티오피아 코체레 예가체프 G1 내추럴',200,'풍성한 후르츠 아로마에 오래 지속되는 후미','17.png','2022-11-13',NULL,NULL,14900,30),(18,'과테말라 산타모니카 SHB 커피원두',200,'깊고 선명한 달콤함과 기분 좋은 스모키함의 만남','18.png','2022-11-13',NULL,NULL,12300,30),(19,'예멘 모카 마타리 알 함다니',200,'플로럴,건포도,자두,대추차,카카오닙스,오트밀,민감초,복합적인,부드러움','19.png','2022-11-13',NULL,NULL,23000,30),(20,'지로스팅 디카페인원두 콜롬비아 에티오피아 커피원두',200,'천연 CO2(이산화탄소)추출 공법으로 카페인을 99.9% 제거한 더 맛있는 디카페인 커피 원두','20.png','2022-11-13',NULL,NULL,13500,30),(21,'G블렌딩 딥블랙 아라비카 블렌드',200,'구수한 깊은 바디감의 고소한 단맛, 카페용 도매가격 에스프레소 원두','1.png','2022-11-13',NULL,NULL,7300,30),(22,'에티오피아 코케 허니 예가체프 G1',200,'입안을 채우는 다채로운 향과 맛. 꿀처럼 달콤한 맛과 싱그러운 산미의 조화','2.png','2022-11-13',NULL,NULL,11500,30),(23,'과테말라 안티구아 SHB',200,'고소한 구수한 신맛적은(없는) 중강배전 커피원두로 갓볶아 배송, 도매가 판매중입니다.','3.png','2022-11-13',NULL,NULL,8200,30),(24,'케냐 AA 키암부 원두커피',200,'은은하게 스며나오는 소량의 산미. 다크초콜릿의 깊은 향과 단맛. 젠더를 넘나드는 바디감','4.png','2022-11-13',NULL,NULL,11800,30),(25,'G블렌딩 오리지널 커피원두',200,'케냐원두 특유의 맛과 향, 묵직하고 남성적인 바디감과 단맛이 섞인 최고의 블렌딩','5.png','2022-11-13',NULL,NULL,9900,30),(26,'에티오피아 모모라 구지 G1 내추럴',200,'딸기와 꿀의 바디감 뒤 느껴지는 환상적인 후미','6.png','2022-11-13',NULL,NULL,16200,30),(27,'콜롬비아 산타로사 수프리모 커피원두',200,'꽃향기, 부드럽고 은은한 산미와 고소한 견과류의 만남','7.png','2022-11-13',NULL,NULL,9900,30),(28,'인도네시아 만델링 G1 커피원두',200,'매우 풍부한 바디감과 짙은 흙내음. 견과류의 고소함과 흑설탕의 단맛','8.png','2022-11-13',NULL,NULL,9400,30),(29,'에티오피아 예가체프 G2 프리미엄',200,'매우 밝은 산미, 과하지 않는 단맛과 가벼운 바디감. 꽃향 가득 피어오르는 여성스러움','9.png','2022-11-13',NULL,NULL,8300,30),(30,'콜롬비아 후일라 수프리모 커피원두',200,'가벼운 산미와 헤이즐럿 혹은 바닐라류의 달콤함.무겁지 않은 바디감과 부드러운 목넘김.잘 짜여진 밸런스','10.png','2022-11-13',NULL,NULL,8000,30),(31,'브라질 세하도 FC NY2 커피원두',200,'부드러운 향, 적당한 바디감. 로스팅 포인트 시티후반에서 잡아낸 섬세한 단맛과 호두의 향','11.png','2022-11-13',NULL,NULL,6300,30),(32,'에티오피아 아리차 예가체프 G1 내추럴',200,'싱그러운 장미의 신맛 끝에 오는 달콤한 후미','12.png','2022-11-13',NULL,NULL,12600,30),(33,'케냐 AA Plus 아이히더 커피원두',200,'라임의 깔끔한 산미와 입안에서 느껴지는 부드러운 촉감','13.png','2022-11-13',NULL,NULL,12800,30),(34,'G블렌딩 블루라마 커피원두',200,'밀크초콜릿과 바닐라의 단맛, 알싸한 꽃향기와 온화한 산미의 만남. 부드러운 바디와 깔끔한 후미의 블렌딩','14.png','2022-11-13',NULL,NULL,9900,30),(35,'코스타리카 따라주 SHB 커피원두',200,'커피의 진주. 와인의 향, 부드러운 산미와 바디감이 균형을 이룸','15.png','2022-11-13',NULL,NULL,9300,30),(36,'G블렌딩 먼로화이트 스페셜티 블렌드',200,'베리류의 산미, 요거트향과 달콤한 바디, 부드러운 촉감, 실크, 꽃과 과일','16.png','2022-11-13',NULL,NULL,12600,30),(37,'에티오피아 코체레 예가체프 G1 내추럴',200,'풍성한 후르츠 아로마에 오래 지속되는 후미','17.png','2022-11-13',NULL,NULL,14900,30),(38,'과테말라 산타모니카 SHB 커피원두',200,'깊고 선명한 달콤함과 기분 좋은 스모키함의 만남','18.png','2022-11-13',NULL,NULL,12300,30),(39,'예멘 모카 마타리 알 함다니',200,'플로럴,건포도,자두,대추차,카카오닙스,오트밀,민감초,복합적인,부드러움','19.png','2022-11-13',NULL,NULL,23000,30),(40,'지로스팅 디카페인원두 콜롬비아 에티오피아 커피원두',200,'천연 CO2(이산화탄소)추출 공법으로 카페인을 99.9% 제거한 더 맛있는 디카페인 커피 원두','20.png','2022-11-13',NULL,NULL,13500,30);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qna_write`
--

DROP TABLE IF EXISTS `qna_write`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna_write` (
  `qna_write_seq` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `qna_write_category` varchar(10) DEFAULT NULL,
  `qna_write_title` varchar(45) DEFAULT NULL,
  `qna_write_content` text,
  `qna_write_initdate` datetime DEFAULT NULL,
  `qna_write_updatedate` date DEFAULT NULL,
  `qna_write_deletedate` date DEFAULT NULL,
  PRIMARY KEY (`qna_write_seq`,`user_id`),
  KEY `fk_qna_write_user1_idx` (`user_id`),
  KEY `fk_qna_write_user1_idx1` (`user_id`),
  CONSTRAINT `fk_qna_write_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna_write`
--

LOCK TABLES `qna_write` WRITE;
/*!40000 ALTER TABLE `qna_write` DISABLE KEYS */;
INSERT INTO `qna_write` VALUES (1,'kimsin','상품문의','여긴 어떤 사이트인가요?','이번에 처음 가입해서 활동하려는데 사용방법이 궁금합니다^^!','2022-11-13 15:50:24',NULL,NULL),(2,'nara7','신고문의','사용자 신고합니다.','다른 사람 비방하고 욕하는 글을 쓰는 거 같아요ㅠㅠ','2022-11-13 15:54:18',NULL,NULL),(3,'nara7','상품문의','상품문의드려요~','블루마운틴 재고 얼마나 남았나요??','2022-11-13 15:54:31',NULL,NULL);
/*!40000 ALTER TABLE `qna_write` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qna_write_comment`
--

DROP TABLE IF EXISTS `qna_write_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna_write_comment` (
  `qna_write_comment_seq` int NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(30) NOT NULL,
  `qna_write_seq` int NOT NULL,
  `qna_write_comment_content` text,
  `qna_write_comment_initdate` datetime DEFAULT NULL,
  `qna_write_comment_updatedate` date DEFAULT NULL,
  `qna_write_comment_deletedate` date DEFAULT NULL,
  PRIMARY KEY (`qna_write_comment_seq`,`admin_id`,`qna_write_seq`),
  KEY `fk_qna_write_comment_admin1_idx` (`admin_id`),
  KEY `fk_qna_write_comment_qna_write1_idx` (`qna_write_seq`),
  CONSTRAINT `fk_qna_write_comment_admin1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`),
  CONSTRAINT `fk_qna_write_comment_qna_write1` FOREIGN KEY (`qna_write_seq`) REFERENCES `qna_write` (`qna_write_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna_write_comment`
--

LOCK TABLES `qna_write_comment` WRITE;
/*!40000 ALTER TABLE `qna_write_comment` DISABLE KEYS */;
INSERT INTO `qna_write_comment` VALUES (1,'admin',1,'안녕하세요 kimsin님^^ 저희 Roast Bean에 방문해주셔서 진심으로 감사드립니다. 저희 사이트는 커피를 사랑하는 사람들이 모일 수 있는 커뮤니티 형성을 목로 하고 있습니다. 우선 커뮤니티로 접속하시어 다른 분들과 커피에 관한 좋은 정보 공유를 해보시는 것을 추천드립니다. 감사합니다^^','2022-11-13 15:52:02',NULL,NULL),(2,'admin',1,'안녕하세요 nara7님^^ 저희 Roast Bean에 방문해주셔서 진심으로 감사드립니다. 문의하신 상품은 현재 재고가 25개 가량 남았습니다. 인기있는 상품이어서 조기소진 될 수 있는 점 양해 부탁드립니다. 감사합니다^^','2022-11-13 15:56:12',NULL,NULL);
/*!40000 ALTER TABLE `qna_write_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_seq` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `order_seq` int NOT NULL,
  `product_id` int NOT NULL,
  `review_date` datetime DEFAULT NULL,
  `review_content` varchar(300) DEFAULT NULL,
  `review_star` int DEFAULT NULL,
  PRIMARY KEY (`review_seq`,`user_id`,`order_seq`,`product_id`),
  KEY `fk_review_orders1_idx` (`order_seq`,`user_id`,`product_id`),
  CONSTRAINT `fk_review_orders1` FOREIGN KEY (`order_seq`, `user_id`, `product_id`) REFERENCES `orders` (`order_seq`, `user_id`, `product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(30) NOT NULL,
  `user_nick` varchar(30) DEFAULT NULL,
  `user_pw` varchar(30) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_address1` varchar(100) DEFAULT NULL,
  `user_address2` varchar(100) DEFAULT NULL,
  `user_address3` varchar(100) DEFAULT NULL,
  `user_addresszipcode` varchar(30) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_gender` varchar(45) DEFAULT NULL,
  `user_telno` varchar(45) DEFAULT NULL,
  `user_initdate` date DEFAULT NULL,
  `user_updatedate` date DEFAULT NULL,
  `user_deletedate` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('butter77','비오는날엔라떼지','hfhdj478','butter77@gmail.com','김희원','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123','1995-03-05','여자','01038950291','2022-09-15',NULL,NULL),('inna5255','shininginna','innapwpw1','inna007@naver.com','유인나','서울 서대문구 봉원사2길 10-2','서울 서대문구 신촌동 1-19','더조은오피스텔 201-1001','03721','1987-03-18','여자','01026118689','2022-10-03',NULL,NULL),('kimsin','doggaebi','qwe123','kimsin@gmail.com','김신','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705','07134','1983-07-12','남자','01077175277','2022-09-27',NULL,NULL),('nara7','모닝커피','qwe123','nara77@gmail.com','권나라','서울 강남구 도산대로 402-2','서울 강남구 청담동 77','푸르지오 107-1705','06062','1992-07-05','여자','01051132872','2022-08-12',NULL,NULL),('soonsin12','커피가좋아','asd77qwe','leesoonsin01@gmail.com','이순신','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관','07558','1980-07-30','남자','01074637896','2022-09-11',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-13 16:02:06
