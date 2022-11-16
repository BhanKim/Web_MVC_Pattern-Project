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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beaninfo`
--

LOCK TABLES `beaninfo` WRITE;
/*!40000 ALTER TABLE `beaninfo` DISABLE KEYS */;
INSERT INTO `beaninfo` VALUES (1,'브라질 산토스','세계 커피생산량의 30%. 고소함과 산미의 조화. 부드러운 풍미와 적당히 쓴맛이 어우러진 커피로 깊은 향과 깔끔함이 특징.','https://ziaandiy.tistory.com/72'),(2,'콜롬비아 수프리모','세계 커피생산량 3위. 중량감 있는 맛과 진한 향기, 균형잡힌 산도가 특징이며, 어떤 강도의 로스팅에도 좋은 맛을 내는 고급 커피.','https://leader222.com/entry/%EC%BD%9C%EB%A1%AC%EB%B9%84%EC%95%84-%EC%BB%A4%ED%94%BC-%EC%9B%90%EB%91%90-%EC%88%98%ED%94%84%EB%A6%AC%EB%AA%A8%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90'),(3,'에티오피아 예가체프','에티오피아 대표 원두 예가체프. 신맛이 강하고 향과 바디감이 있는 커피. 발랄한 꽃향기와 신맛과 단맛의 밸런스.','https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=aristalove&logNo=220996766246'),(4,'케냐 AA','해발 2,000미터 고지대 생산.  AA는 가장 큰 원두이며 최고등급. 와인향, 과일같은 상큼한 신맛이 특징. 독특한 쌉쌀함이 일품.','https://m.blog.naver.com/donggu1989/221302963508'),(5,'자메이카 블루마운틴','해발 1,200미터 고지대 생산. 세계 3대 원두. 신맛, 단맛, 스모키한 맛이 부드럽고 깔끔하게 조화를 이루어 \'커피의 황제\'라고 불림.','http://the-edit.co.kr/42814'),(6,'탄자니아 AA','킬리만자로 커피라고도 불리며 깊은 향과 신맛, 단맛, 쓴맛이 오묘하게 조화를 이룸. 초콜릿향미가 특징.','https://ziaandiy.tistory.com/67'),(7,'하와이코나','하와이 코나섬에서 재배, 수확한 원두로 세계 3대 원두. 커피에 꽃향과 브라과일향이 은은하게 나며, 적당한 신맛이 일품.','https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=goldmonji2&logNo=221191760292');
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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (3,'kim9238',13,1,'2022-11-14');
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
  `community_content` text,
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (1,'test1','안녕하세요~ 가입인사 드립니다.','<p>이번에 가입하게 된 사람입니다. 소통하며 지내요~</p>\r\n',8,NULL,0,0,0,'2022-11-14 15:05:17',NULL,NULL),(2,'test2','에스프레소 추출 시 단맛을 늘리는 팁 조언 부탁드립니다','<p>약배전 혹은 약중배전 정도의 싱글 에스프레소를 추출할때 산미를 자극적이지 않고 밸런스를 어느정도 갖춰지게 추출을 한다 싶어도 항상 단맛이 아쉽더라구요.좀 더 분쇄도를 조여보면 단맛이 늘어나기 보다는&nbsp;자극적인 맛이 더 강해져서. 단맛을 더 끌어낼 수 있는 팁이 있을까요?</p>\r\n',0,2,0,0,0,'2022-11-14 15:08:40',NULL,NULL),(3,'test3','농도는 고정 하고 수율을 올릴수 있을까요?','<p>농도는 고정 하고 수율을 올릴수 있을까요?</p>\r\n',0,3,0,0,0,'2022-11-14 15:10:19',NULL,NULL),(4,'test4','카페라떼와 카푸치노의 차이를 정확하게 정의 해주실 분 있나요?','<p>카페라떼와 카푸치노의 차이를 정확하게 정의 해주실 분 있나요?</p>\r\n\r\n<p>디테일하게 적어주시면 감사하겠습니다.!!</p>\r\n',2,4,0,0,0,'2022-11-14 15:11:08',NULL,NULL),(5,'test1','진로에 대한 고민 같이 해주시면 감사하겠습니다','<p>&nbsp;안녕하세요 저는 현재 베이커리에서 판매 및 서비스직으로 근무하고 있는 23살 남자입니다. 원래는 이번 9월까지만하면 1년이라 퇴직금받고 퇴사를 하고 바리스타를 하려고 했는데요 여기를 다니면서 원래는 좋아하지도 않던 빵에 대한 호감과 지식, 여러가지 빵들을 맛보고 하다보니 어느샌가 저도 빵에 대해 어느정도 애착 및 관심이 생기더라구요. 그리고 최근에 승진가능성에 대해서도 듣기도 했었구요. 그냥 일반 베이커리면 그냥 퇴사해도 후회는 없는데, 제가 운좋게도 제과명장님이 운영하시는 직영점이어서 더 고민이 됩니다.. 현재 SCA 디플로마과정을 거치고 있는 중이어서 1년정도만 더 바리스타로 있다가 빵을 배우고 나갈까 생각중입니다. 어쩌면 그동안에 승진하면 더 다닐수도 있겠지만요(그냥 제소망이지만요..) 어쨋든 더 다니는게 좋을까요 아니면 바로 퇴사하고 카페로 이직하는게 좋을까요? 여러분들의 답변 기다리겠습니다.</p>\r\n',1,5,0,0,0,'2022-11-14 15:11:53',NULL,NULL),(6,'test6','2022년 코리아커피리그 접수가 시작되었네요~','<p>7월 1일부터 시작하긴 했지만..ㅎㅎㅎ&nbsp; 혹시 참가하시는 분 계신가요?&nbsp; 저는 일단 커피를 사랑하는 사람으로 남아있는 것으로.. ^^</p>\r\n\r\n<p>조금 더 커피에 대한 깊이가 쌓이면 그때 도전을 한번.. ㅎㅎ&nbsp;&nbsp;</p>\r\n\r\n<p>참가하시는 분들 모두 응원합니다~ ^^</p>\r\n',2,6,0,0,0,'2022-11-14 15:12:51',NULL,NULL),(7,'test7','물가 상승 너무 무섭네요...','<p>요즘 물가상승 체감이 강하게 느껴지네요. 우유값 인상부터 시작해서, 최근 생두 산지 문제로 원두 값이 상승해서 또 인상된다고...여기에 최저임금까지</p>\r\n\r\n<p>다들 어떻게 준비하고 계신가요</p>\r\n\r\n<p>저는 올해보다 내년이 더 힘들거 같아요ㅠㅠㅠㅠ</p>\r\n',2,7,0,0,0,'2022-11-14 15:13:45',NULL,NULL),(8,'test8','지나가는 사람이 없네요...','<p>손님도 진상도 없는 카페...</p>\r\n\r\n<p>너무 한가할 때는 다들 뭐하시나요?</p>\r\n',0,8,0,0,0,'2022-11-14 15:14:40',NULL,NULL),(9,'test8','카페 이벤트 뭐가 좋을까요?','<p>아파트 상가에서 작게 카페하고 있습니다.</p>\r\n\r\n<p>운영한지는 1년 가까이 됐는데, 아직 이벤트를 한번도 한 적이 없네요.</p>\r\n\r\n<p>이제 위드코로나도 한다고 하니, 사람들 좀 나올까싶어서 이벤트 한번 해보려구요.</p>\r\n\r\n<p>혹시 뭐가 좋을까요??</p>\r\n',0,9,0,0,0,'2022-11-14 15:21:34',NULL,NULL),(10,'test10','브라운백에서 접하는 원두 중','<p>브라운백에서 접하는 원두 중&nbsp;순번상 오랜만에 만나게된 테라돌체 원두. 전자동 에스프레소 머신을 사용한 결과임을 먼저 밝힙니다.</p>\r\n\r\n<p>전자동 커피머신이다보니 핸드드립이나 반자동머신을 이용할때 사용하는&nbsp; 별도 그라인딩과정에서 느껴지는 향은 감춰졌어요.</p>\r\n\r\n<p>그라인딩 향이 커피의 만족도를 결정하는데 주요한 영향을 미쳐왔는데 그 부분을 리뷰하지 못해 아쉽네요.&nbsp;</p>\r\n\r\n<p>버튼을 누르고 기다리면 노즐에서 에스프레소가 분출되기 시작할때 즈음 고소한 향기가 은은하게 퍼져나옵니다.</p>\r\n\r\n<p>잔 속으로 모이는 커피는&nbsp; 연갈색으로 농도 짙어보이는 크레마가 인상적입니다.</p>\r\n\r\n<p>뜨거운 커피를 식히기 위해 테이블 위에 커피를 올려놓았는데 색이 참 예뻤어요. 그 모습을 남겨두고 싶어 몇 장찍어 봤는데 눈으로 느껴지는 감정을 휴대폰 카메라에 넣기엔&nbsp; 카메라 다루는 실력이 역부족 인듯합니다.</p>\r\n\r\n<p>잘 표현이 안되네요. 테라돌체 커피를 한 모금입에 넣으면 에스프레소의 묵직함이 처음느껴지고, 혀를 천천히 돌릴때마다 구수와 고소의 그 사이 어디쯤에 있는 단맛이 혀 끝을 감싸버립니다. 그 과정에서 에스프레소의 진한맛이 입 안쪽에서 함께 뿜어져 나옵니다.</p>\r\n\r\n<p>&nbsp;천천히 삼키면 입속을 채우던 커피는 비워지고, 처음 느껴 졌던 단맛이 입속 빈공간에 은은하게 퍼져나옵니다. 두 번 정도 입맛을 다시면 군고구마를 먹었을때의 고소한 단맛과 향이 입속에서 돌아나갑니다.</p>\r\n\r\n<p>&nbsp; 완성된 고소함이 느껴집니다.&nbsp; 원두 선택을 위해 고민하며 리뷰를 보고있는 누군가에게 고소함과 단맛의 조화를 원한다면..이라는&nbsp; 요약을 전하며 리뷰를 마무리 합니다</p>\r\n',0,10,0,0,0,'2022-11-14 15:24:55',NULL,NULL),(11,'test11','세비지커피','<p>안녕하세요. 대구 동구 세비지커피입니다. 재개발 구역으로 공사가 한창인 이 동네는 걸어다니는 사람도, 차도 그렇게 많이 다니지 않는 동네입니다. &nbsp;웃기게도 계약하고나서야 바로 앞에 아파트가 들어온다는 것을 알았어요. 제가 원한 그 골목 감성은 사라지겠지만요..;( &nbsp;하지만 이 근처 10분만 걸어 내려가면 대구 신세계백화점과 동대구역이 있답니다.</p>\r\n',0,11,0,0,0,'2022-11-14 15:25:20',NULL,NULL),(12,'test1','커피머신 중고구매','<p>안녕하세요-! 인천에 카페창업 준비중인 예비창업자입다!&nbsp;커피머신을 중고로 구매할까 고려하고 있는데요 &lt;/br&gt; 머신 중고로 주로 어디서 구매하고 찾아보시나요..? 조금이라도 더 믿을만 한곳 추천해주시면 감사하겠습니다!!.</p>\r\n',3,12,0,0,0,'2022-11-14 15:26:19',NULL,NULL),(13,'test2','커피를 공부하는 학생입니다','<p>다름이 아닌 필터커피 에 관해 여쩌보려합니다&nbsp;.</p>\r\n\r\n<p>소위 말하는 린싱 이라는 과정을 생략하고&nbsp; 추출을 하시는경우를 보아서 &nbsp;</p>\r\n\r\n<p>제가 알기론 린싱을 하지 않으면 필터지의 눈내?&nbsp; 난다고 하여 린싱을 하는걸로 아는데&nbsp; 린싱을 하지 않고 내리는데 이유가 있나요?</p>\r\n\r\n<p>&nbsp;그리고 그 커피 배전도에 따라서 &nbsp;분쇄도 입자를 다르게 해야하나요?</p>\r\n',0,13,0,0,0,'2022-11-14 15:27:19',NULL,NULL),(14,'test3','브루잉 주문이 여러잔 들어오면 어떻게 하십니까?','<p>여러가지 매체들의 드립영상을 보면&nbsp; 레시피는 대다수&nbsp;드리퍼1개 만을 가지고 합니다.&nbsp;&nbsp;</p>\r\n\r\n<p>그런데 실제 필드에서는 한 잔씩 &nbsp; &nbsp;주문이 들어오지 않습니다. &nbsp; &nbsp;</p>\r\n\r\n<p>하나씩 하나씩 하게되면 시간이 많이 걸리고 &nbsp; &nbsp;그만큼 손님도 기다리게 됩니다. &nbsp; &nbsp; &nbsp; &nbsp;</p>\r\n\r\n<p>어떻게 하시나요? &nbsp; &nbsp;여러잔을 동시에 하는 것을 많이 연습하는게 &nbsp; &nbsp;</p>\r\n\r\n<p>더 중요한 것이 아닐지 생각해봅니다.&nbsp;</p>\r\n',1,14,0,0,0,'2022-11-14 15:28:01',NULL,NULL),(15,'test5','바라짜 포르테 얼라이먼트 해보신 분 계신가요?','<p>최근 호주의 바리스타 데빈 룽이 자신의 인스타그램 피드에 올린 내용인데 바라짜 포르테 유저들에게 꽤나 흥미로운 내용인 것 같습니다.</p>\r\n\r\n<p>이미 홈바리스타닷컴에서 바라짜 바리오, 포르테 BG 모델과 관련해서 올라온 내용인데 혹시 해보신 분이 계신가 해서 여쭤봅니다!&nbsp;</p>\r\n',0,15,0,0,0,'2022-11-14 15:28:39',NULL,NULL),(16,'test6','Arabica에 대해서 정확히 알고싶습니다.','<p>&nbsp;안녕하세요 예전부터 혼동되는 부분이 있어 질문을 하게 되었습니다. &nbsp;생두 품종은 Arabica,Robsta 로 구분하여 일반적으로 소개가 많이 되는데요, &nbsp;어떤책을 보아도 아라비카 밑으로 버본/티피카 그 밑으로 수많은 교배종과 변이종이 소개됩니다. &nbsp;</p>\r\n\r\n<p>- Arabica 라는 것이 고유한 품종의 명칭을 뜻하는 것인가요 아니면 티피카,버번,카투라 등의 품종들을 포괄하는 단어인가요??? &nbsp;</p>\r\n\r\n<p>&nbsp;-만약 아라비카라는 고유품종이 존재하고 아라비카의 변이종들을 &nbsp;함께 아라비카로 포괄하여 정의되는 것이라면 유게니 오이데스 같은 원시품종 또한 아라비카와 같은 가계도가 존재하는 건가요???&nbsp;</p>\r\n',0,16,0,0,0,'2022-11-14 15:29:28',NULL,NULL),(17,'test6','에스프레소 유래가 어디라고 생각하시나요??','<p>&nbsp;그동안은 당연히 이탈리아라고 생각했는데 최근 읽고있는 책이나 지나가면서 보는 글들에서 프랑스라고 하는 곳도 다수 있더라고요. &nbsp; &nbsp;</p>\r\n\r\n<p>실제 근무를 하면서 크게 중요한 부분은 아니지만 궁금해서 한번 글 올려봅니다.</p>\r\n',0,17,0,0,0,'2022-11-14 15:29:53',NULL,NULL),(18,'test7','프리인퓨전에 관련해서 질문 드립니다 !','<p>인제 막 커피를 배우고 있는 학생입니다. 다름이 아니라 프리인퓨전에 대해서 궁금한게 생겨서 질문드립니다. &nbsp;</p>\r\n\r\n<p>인퓨전 시간이나 압력에 변화에 따라 추출되었을때 맛의 변화 같은 것을 알고싶습니다. &nbsp;예를 들어 인퓨전 시간이 길어졋을때는 어떠한 변화를 짧아졋을때는 이러한 변화를 가진다. &nbsp;</p>\r\n\r\n<p>프리인퓨전이 있어야 커피의 맛이 좋아진다 라는 글이나 얘기는 들었지만 작용방법? 이라고 해야하나요.</p>\r\n\r\n<p>이러한 변화를 주었을때 어떠한 결과를 가져온다 이렇게 명시된 것을 잘 찾아보지 못하여서 글을 남기게됩니다. &nbsp;혹시나 아시는 분 계시면 말씀해주시면 정말 감사하겠습니다. 관련 링크라도 괜찮습니다! &nbsp;</p>\r\n\r\n<p>&nbsp;다들 추석연휴 잘보내시고 행복한 일상이 가득하세요~&nbsp;</p>\r\n',0,18,0,0,0,'2022-11-14 15:30:35',NULL,NULL),(19,'test7','Coffee Recipe | How to make Ice Aeropress with natural coffee (Ethiopia)','<p>사실 이미 늦었지만 여름용, 내추럴 커피에 아주 잘 어울리는 에어로프레스 레시피를 &nbsp;공유합니다!!</p>\r\n\r\n<p>추출이 너무 빨라서 괜찮을까? &nbsp; &nbsp;싶지만 꿀맛입니다 &nbsp;(레시피 출처는 이곳저곳에서... 훔쳤습니다 ^^;;;)&nbsp;</p>\r\n\r\n<p>댓글로 이메일 남겨주시면 제가 보내드릴게요!!</p>\r\n',0,19,0,0,0,'2022-11-14 15:31:08',NULL,NULL),(20,'test8','수동식 머신에 대해 알고싶습니다','<p>&nbsp;현재 1년째 일하고 있는 매장이 수동식 커피머신을 쓰고 있습니다! 기본적인 이론정도는 들어 알고있지만 조금 더 깊은 정보가 알고싶습니다.</p>\r\n\r\n<p>&nbsp;원두의 양과 추출시간 등등의 요소를 같게 해도 추출양이 다를때도 있고 기계 자체의 온도 변화도 추출할때 신경쓰게 되더라구요!</p>\r\n\r\n<p>&nbsp;수동식 머신을 조금 더 공부하고 싶은데 자료가 너무 없어요,,,도와주세요</p>\r\n',0,20,0,0,0,'2022-11-14 15:31:44',NULL,NULL),(21,'test9','커피맛나는 술이 있을까요??','<p>요새 잠을 못자서 술을 마시려고하는데 커피맛 나는 술 찾고있어요</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>도움좀주세요..! ㅠㅠㅠ</p>\r\n',8,21,0,0,0,'2022-11-14 15:32:59',NULL,NULL),(22,'test10','원두의 산패에 대한 논쟁이 있어서 살짝 가져와봅니다.','<p>&nbsp;클리앙의 클다방의 게시물인데, 댓글 중 원두의 산패와 에이징, 디개싱에 대한 글들이 있습니다.</p>\r\n\r\n<p>&nbsp;산패와 에이징 등에 대한 여러분들의 의견이 궁금합니다.&nbsp;&nbsp;</p>\r\n\r\n<p>기본적으로 로스팅 레벨에 따른 커피 빈의 조직 상태, 잔존 이산화탄소 농도 등 따져볼게 많아 한달, 두달의 시간을 두고 단순히 이 기간이 지나면 산패가 일어난다의 개념으로 접근하긴 어렵다고 보는 입장이구요.</p>\r\n',17,22,0,0,4,'2022-11-14 15:34:20',NULL,NULL),(24,'admin','Roast Bean 커뮤니티 가이드','<p>Roast Bean의 웹사이트 및 소셜미디어 운영에 관한 커뮤니티 가이드 입니다. 아래 각호의 사항에 위반되는 게시물 및 댓글의 경우 예고없이 삭제 될 수 있고 해당 계정은 이용이 정지될 수 있습니다.</p>\r\n\r\n<p>1. 혐오 및 욕설</p>\r\n\r\n<p>- 특정인 또는 특정업체에 대한 혐오표현 및 욕설</p>\r\n\r\n<p>2. 현행법 위반</p>\r\n\r\n<p>- 사이버 명예훼손 또는 모욕 등 현행법에 저촉되는 내용</p>\r\n\r\n<p>3. 광고 홍보</p>\r\n\r\n<p>- 각 게시판 이용목적에 맞지 않는 광고홍보성 글</p>\r\n\r\n<p>4. 게시판 도배</p>\r\n\r\n<p>- 같은 글 또는 댓글의 반복적 게시</p>\r\n',1,23,0,0,0,'2022-11-14 15:42:14',NULL,NULL),(25,'admin',' 원두를 납품 하시려는 로스터분들을 위한 작성 예시','<p>서울 마포구에 위치한 스페셜티커피 로스팅 회사 OOOO입니다. 현재 스페셜티라인으로 A, B, C 세가지 타입의 블렌드를 제공하고 있고 대량 납품을 위한 커머셜 블렌드 ㄱ,ㄴ,ㄷ도 납품을 진행하고 있습니다. 단순 원두 납품 뿐만 아니라 오픈, 리뉴얼 컨설팅과 바리스타 정기교육도 위탁하여 진행하고 있습니다. 현재 직영 카페는 마포구 3개점을 운영하고 있고 2021년 인천 송도의 qwer카페와 남양주의 asdf카페, 역삼동의 xxxx카페를 컨설팅한 바 있습니다.&nbsp;</p>\r\n\r\n<p>현재 서울 경기 인천의 거래처 30여곳에 납품을 진행하고 있으나 호남, 영남, 제주 분들의 문의도 언제든 환영합니다. &nbsp;</p>\r\n\r\n<p>더 자세한 소개는 아래 첨부된 회사소개서를 참고해 주세요.&nbsp;</p>\r\n\r\n<p>email : adsffdsa@gmail.cooom</p>\r\n\r\n<p>전화 : 02-3333-3333&nbsp;</p>\r\n\r\n<p>담당자 : 김이박 팀장 (010-3000-3000)</p>\r\n\r\n<p>첨부파일 :ㅇㅇㅇㅇ회사소개서.pdf</p>\r\n\r\n<p>감사합니다.</p>\r\n',0,25,0,0,0,'2022-11-14 15:42:47',NULL,NULL),(26,'admin','원두를 새로 납품 받고자 하는 카페 오너분들을 위한 작성 예시','<p>에스프레소 머신 &nbsp; 시네소 s200<br />\r\n그라인더 &nbsp; 콤팍 e8, pk100, 말코닉 e65gbw<br />\r\n선호 원두 스타일<br />\r\n고소하고 무난한 커머셜 블렌드와 필터커피를 위한 싱글오리진<br />\r\n매장 소개<br />\r\n(예)마포구 합정동에 위치한 카페로 오피스상권에 위치하고 있습니다. 현재 2가지 타입의 블렌드커피를 취급하고 있고 앞으로 필터커피를 새로 시작해보려고 합니다. 사용량은 월 80kg이상 입니다. 샘플 테스트 후 방문상담 요청드릴 예정이며 저희 매니저와 함께 원두세팅을 부탁드리고 간단한 바리스타 교육도 해주신다면 감사하겠습니다. 담당자 연락처 : 010-0900-9900 (김이박 매니저)<br />\r\n담당자에게 연락주시거나 블랙워터이슈쪽지, 댓글로 컨택해 주시면 연락 드리겠습니다.</p>\r\n',0,26,0,0,0,'2022-11-14 15:43:11',NULL,NULL),(27,'test5','커피머신 판매합니다.','<p>커피머신 판매해요~ 얼마안썼어요~ 싸게팜니다 연락주세요!</p>\r\n\r\n<p>카카오톡 알려주세요!</p>\r\n',8,27,1,0,1,'2022-11-14 16:16:30',NULL,'2022-11-14 16:20:15'),(28,'test5','커피머신 판매합니다.','<p>이분이 판매하는 것은 사기에요!</p>',1,27,1,1,0,'2022-11-14 16:19:22',NULL,'2022-11-14 16:19:30'),(29,'admin','이것은 테스트 공지입니다.','<p>테스트공지!</p>\r\n',1,29,0,0,0,'2022-11-14 16:20:32',NULL,'2022-11-14 16:20:57'),(30,'admin','test1','<p>1</p>\r\n',1,30,0,0,0,'2022-11-15 03:52:52',NULL,'2022-11-15 03:52:58'),(31,'test11','아 야 너네 여기가좋냐?','<p>ㅡㅡ난별론데</p>\r\n',1,31,0,0,0,'2022-11-15 12:37:57',NULL,'2022-11-15 12:38:16');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_comment`
--

LOCK TABLES `community_comment` WRITE;
/*!40000 ALTER TABLE `community_comment` DISABLE KEYS */;
INSERT INTO `community_comment` VALUES (4,1,'test2','반가워요 ~~ 잘지내봐요!','2022-11-14 15:09:41'),(5,4,'test8','시나몬 가루에 차이가 있습니다. 흔히 계피라고 하죠~','2022-11-14 15:15:45'),(6,7,'test8','코로나 이겨냅시다 화이팅!!!!','2022-11-14 15:15:56'),(9,22,'test1','ggg','2022-11-15 10:52:48'),(10,22,'test1','123','2022-11-15 10:53:47');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_write`
--

LOCK TABLES `notice_write` WRITE;
/*!40000 ALTER TABLE `notice_write` DISABLE KEYS */;
INSERT INTO `notice_write` VALUES (1,'admin','원두를 구매하려고 하면 어떻게 해야하나요?','상단에 COFFEE SHOP 을 클릭하면 저희가 판매하는 원두 종류를 볼 수 있고, 구매버튼 및 장바구니로 구매가 가능합니다^^.','2022-11-15',NULL,'2022-11-15'),(2,'admin','제가 무슨 원두를 좋아하는지 모르는데 어떡해야하나요?','상단에 ABOUT 버튼에 Coffee That Suits Me 란을 클릭하시면 나와 맞는 원두찾기를 하실 수 있습니다. ','2022-11-15',NULL,'2022-11-15'),(3,'admin','이벤트 행사 진행하려고합니다.','지금 이벤트로 커피할인 행사를 진행하려고 합니다. 추후 공지 날짜에 맞춰 내방하시는 고객님께 커피원두를 무료로 드리려고합니다.','2022-11-15',NULL,NULL),(4,'admin','커피를 좋아하는 사람들을 위해','커피를 좋아하는 사람들을 위해 소박한 선물을 준비했습니다. 상품구매후 리뷰를 선발하여 소정의 선물을 드리려고 합니다. 많은 참여 부탁드립니다.','2022-11-15',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'supersounds',13,NULL,NULL,NULL,NULL,NULL,1,12800,'2022-11-14',NULL,NULL),(2,'test1',12,'김춘배','07134','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705',1,12600,'2022-11-14','test1@naver.com','01012341234'),(3,'test1',12,'김춘배','07134','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705',2,25200,'2022-11-14','test1@naver.com','01012341234'),(5,'test2',12,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,12600,'2022-11-14','test2@dreamwiz.com','01043214312'),(6,'test2',13,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',2,25600,'2022-11-14','test2@dreamwiz.com','01043214312'),(7,'test2',14,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',4,39600,'2022-11-14','test2@dreamwiz.com','01043214312'),(8,'test2',15,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,9300,'2022-11-14','test2@dreamwiz.com','01043214312'),(9,'test2',16,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,12600,'2022-11-14','test2@dreamwiz.com','01043214312'),(10,'test2',17,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,14900,'2022-11-14','test2@dreamwiz.com','01043214312'),(11,'test2',18,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,12300,'2022-11-14','test2@dreamwiz.com','01043214312'),(12,'test2',19,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,23000,'2022-11-14','test2@dreamwiz.com','01043214312'),(13,'test2',20,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,13500,'2022-11-14','test2@dreamwiz.com','01043214312'),(14,'test3',12,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',2,25200,'2022-11-14','test3@naver.com','01012341234'),(15,'test3',13,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,12800,'2022-11-14','test3@naver.com','01012341234'),(16,'test3',14,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',4,39600,'2022-11-14','test3@naver.com','01012341234'),(17,'test3',14,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,9900,'2022-11-14','test3@naver.com','01012341234'),(18,'test3',15,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,9300,'2022-11-14','test3@naver.com','01012341234'),(19,'test3',16,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,12600,'2022-11-14','test3@naver.com','01012341234'),(20,'test3',17,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,14900,'2022-11-14','test3@naver.com','01012341234'),(21,'test3',18,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,12300,'2022-11-14','test3@naver.com','01012341234'),(22,'test3',19,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',2,46000,'2022-11-14','test3@naver.com','01012341234'),(23,'test3',20,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',2,27000,'2022-11-14','test3@naver.com','01012341234'),(24,'test3',2,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,11500,'2022-11-14','test3@naver.com','01012341234'),(25,'test5',3,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',2,16400,'2022-11-14','test5@naver.com','01012341234'),(26,'test5',4,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,11800,'2022-11-14','test5@gmail.com','01043124121'),(27,'test5',5,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9900,'2022-11-14','test5@naver.com','01043214321'),(28,'test5',6,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,16200,'2022-11-14','test5@naver.com','01043124132'),(29,'test5',7,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9900,'2022-11-14','test5@daum.net','01043214321'),(30,'test5',8,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9400,'2022-11-14','test5@naver.com','01043214321'),(31,'test5',9,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',2,16600,'2022-11-14','test5@korea.com','01043214321'),(32,'test5',10,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,8000,'2022-11-14','test5@gmail.com','01043214321'),(33,'test5',11,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,6300,'2022-11-14','test5@naver.com','01043214321'),(34,'test1',12,'김춘배','07134','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705',1,12600,'2022-11-15','test1@naver.com','01012341234'),(35,'test1',8,'김춘배','07134','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705',1,9400,'2022-11-15','test1@naver.com','01012341234'),(37,'test2',12,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,12600,'2022-11-15','test2@dreamwiz.com','01043214312'),(38,'test2',8,'황인심','26378','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032',1,9400,'2022-11-15','test2@dreamwiz.com','01043214312'),(40,'test3',12,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,12600,'2022-11-15','test3@naver.com','01023422342'),(41,'test3',8,'나선욱','07558','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관',1,9400,'2022-11-15','test3@naver.com','01023422342'),(43,'test5',12,'김환영','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',2,25200,'2022-11-15','test5@naver.com','01041231243'),(44,'test6',12,'박상훈','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,12600,'2022-11-15','test6@daum.net','01055555555'),(45,'test6',8,'박상훈','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9400,'2022-11-15','test6@daum.net','01055555555'),(47,'test7',12,'한상열','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,12600,'2022-11-15','test7@gmail.com','01033331421'),(48,'test7',8,'한상열','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9400,'2022-11-15','test7@gmail.com','01033331421'),(50,'test8',12,'김경호','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,12600,'2022-11-15','test8@naver.com','01012434125'),(51,'test8',8,'김경호','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9400,'2022-11-15','test8@naver.com','01012434125'),(53,'test9',12,'송명철','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,12600,'2022-11-15','test9@naver.com','01044442222'),(54,'test9',8,'송명철','08123','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트',1,9400,'2022-11-15','test9@naver.com','01044442222'),(56,'test10',12,'이호식','03721','서울 서대문구 봉원사2길 10-2','서울 서대문구 신촌동 1-19','더조은오피스텔 201-1001',1,12600,'2022-11-15','test10@naver.com','01012341234'),(57,'test10',8,'이호식','03721','서울 서대문구 봉원사2길 10-2','서울 서대문구 신촌동 1-19','더조은오피스텔 201-1001',1,9400,'2022-11-15','test10@naver.com','01012341234'),(59,'test11',12,'김신영','06062','서울 강남구 도산대로 402-2','서울 강남구 청담동 77','푸르지오 107-1705',1,12600,'2022-11-15','test11@naver.com','01066666666'),(60,'test11',8,'김신영','06062','서울 강남구 도산대로 402-2','서울 강남구 청담동 77','푸르지오 107-1705',1,9400,'2022-11-15','test11@naver.com','01066666666');
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
INSERT INTO `product` VALUES (1,'G블렌딩 딥블랙 아라비카 블렌드',200,'구수한 깊은 바디감의 고소한 단맛, 카페용 도매가격 에스프레소 원두','1.png','2022-11-13',NULL,NULL,7300,30),(2,'에티오피아 코케 허니 예가체프 G1',200,'입안을 채우는 다채로운 향과 맛. 꿀처럼 달콤한 맛과 싱그러운 산미의 조화','2.png','2022-11-13',NULL,NULL,11500,29),(3,'과테말라 안티구아 SHB',200,'고소한 구수한 신맛적은(없는) 중강배전 커피원두로 갓볶아 배송, 도매가 판매중입니다.','3.png','2022-11-13',NULL,NULL,8200,28),(4,'케냐 AA 키암부 원두커피',200,'은은하게 스며나오는 소량의 산미. 다크초콜릿의 깊은 향과 단맛. 젠더를 넘나드는 바디감','4.png','2022-11-13',NULL,NULL,11800,29),(5,'G블렌딩 오리지널 커피원두',200,'케냐원두 특유의 맛과 향, 묵직하고 남성적인 바디감과 단맛이 섞인 최고의 블렌딩','5.png','2022-11-13',NULL,NULL,9900,29),(6,'에티오피아 모모라 구지 G1 내추럴',200,'딸기와 꿀의 바디감 뒤 느껴지는 환상적인 후미','6.png','2022-11-13',NULL,NULL,16200,29),(7,'콜롬비아 산타로사 수프리모 커피원두',200,'꽃향기, 부드럽고 은은한 산미와 고소한 견과류의 만남','7.png','2022-11-13',NULL,NULL,9900,29),(8,'인도네시아 만델링 G1 커피원두',200,'매우 풍부한 바디감과 짙은 흙내음. 견과류의 고소함과 흑설탕의 단맛','8.png','2022-11-13',NULL,NULL,9400,20),(9,'에티오피아 예가체프 G2 프리미엄',200,'매우 밝은 산미, 과하지 않는 단맛과 가벼운 바디감. 꽃향 가득 피어오르는 여성스러움','9.png','2022-11-13',NULL,NULL,8300,28),(10,'콜롬비아 후일라 수프리모 커피원두',200,'가벼운 산미와 헤이즐럿 혹은 바닐라류의 달콤함.무겁지 않은 바디감과 부드러운 목넘김.잘 짜여진 밸런스','10.png','2022-11-13',NULL,NULL,8000,29),(11,'브라질 세하도 FC NY2 커피원두',200,'부드러운 향, 적당한 바디감. 로스팅 포인트 시티후반에서 잡아낸 섬세한 단맛과 호두의 향','11.png','2022-11-13',NULL,NULL,6300,29),(12,'에티오피아 아리차 예가체프 G1 내추럴',200,'싱그러운 장미의 신맛 끝에 오는 달콤한 후미','12.png','2022-11-13',NULL,NULL,12600,16),(13,'케냐 AA Plus 아이히더 커피원두',200,'라임의 깔끔한 산미와 입안에서 느껴지는 부드러운 촉감','13.png','2022-11-13',NULL,NULL,12800,27),(14,'G블렌딩 블루라마 커피원두',200,'밀크초콜릿과 바닐라의 단맛, 알싸한 꽃향기와 온화한 산미의 만남. 부드러운 바디와 깔끔한 후미의 블렌딩','14.png','2022-11-13',NULL,NULL,9900,21),(15,'코스타리카 따라주 SHB 커피원두',200,'커피의 진주. 와인의 향, 부드러운 산미와 바디감이 균형을 이룸','15.png','2022-11-13',NULL,NULL,9300,28),(16,'G블렌딩 먼로화이트 스페셜티 블렌드',200,'베리류의 산미, 요거트향과 달콤한 바디, 부드러운 촉감, 실크, 꽃과 과일','16.png','2022-11-13',NULL,NULL,12600,28),(17,'에티오피아 코체레 예가체프 G1 내추럴',200,'풍성한 후르츠 아로마에 오래 지속되는 후미','17.png','2022-11-13',NULL,NULL,14900,28),(18,'과테말라 산타모니카 SHB 커피원두',200,'깊고 선명한 달콤함과 기분 좋은 스모키함의 만남','18.png','2022-11-13',NULL,NULL,12300,28),(19,'예멘 모카 마타리 알 함다니',200,'플로럴,건포도,자두,대추차,카카오닙스,오트밀,민감초,복합적인,부드러움','19.png','2022-11-13',NULL,NULL,23000,27),(20,'지로스팅 디카페인원두 콜롬비아 에티오피아 커피원두',200,'천연 CO2(이산화탄소)추출 공법으로 카페인을 99.9% 제거한 더 맛있는 디카페인 커피 원두','20.png','2022-11-13',NULL,NULL,13500,27),(21,'G블렌딩 딥블랙 아라비카 블렌드',200,'구수한 깊은 바디감의 고소한 단맛, 카페용 도매가격 에스프레소 원두','1.png','2022-11-13',NULL,NULL,7300,30),(22,'에티오피아 코케 허니 예가체프 G1',200,'입안을 채우는 다채로운 향과 맛. 꿀처럼 달콤한 맛과 싱그러운 산미의 조화','2.png','2022-11-13',NULL,NULL,11500,30),(23,'과테말라 안티구아 SHB',200,'고소한 구수한 신맛적은(없는) 중강배전 커피원두로 갓볶아 배송, 도매가 판매중입니다.','3.png','2022-11-13',NULL,NULL,8200,30),(24,'케냐 AA 키암부 원두커피',200,'은은하게 스며나오는 소량의 산미. 다크초콜릿의 깊은 향과 단맛. 젠더를 넘나드는 바디감','4.png','2022-11-13',NULL,NULL,11800,30),(25,'G블렌딩 오리지널 커피원두',200,'케냐원두 특유의 맛과 향, 묵직하고 남성적인 바디감과 단맛이 섞인 최고의 블렌딩','5.png','2022-11-13',NULL,NULL,9900,30),(26,'에티오피아 모모라 구지 G1 내추럴',200,'딸기와 꿀의 바디감 뒤 느껴지는 환상적인 후미','6.png','2022-11-13',NULL,NULL,16200,30),(27,'콜롬비아 산타로사 수프리모 커피원두',200,'꽃향기, 부드럽고 은은한 산미와 고소한 견과류의 만남','7.png','2022-11-13',NULL,NULL,9900,30),(28,'인도네시아 만델링 G1 커피원두',200,'매우 풍부한 바디감과 짙은 흙내음. 견과류의 고소함과 흑설탕의 단맛','8.png','2022-11-13',NULL,NULL,9400,30),(29,'에티오피아 예가체프 G2 프리미엄',200,'매우 밝은 산미, 과하지 않는 단맛과 가벼운 바디감. 꽃향 가득 피어오르는 여성스러움','9.png','2022-11-13',NULL,NULL,8300,30),(30,'콜롬비아 후일라 수프리모 커피원두',200,'가벼운 산미와 헤이즐럿 혹은 바닐라류의 달콤함.무겁지 않은 바디감과 부드러운 목넘김.잘 짜여진 밸런스','10.png','2022-11-13',NULL,NULL,8000,30),(31,'브라질 세하도 FC NY2 커피원두',200,'부드러운 향, 적당한 바디감. 로스팅 포인트 시티후반에서 잡아낸 섬세한 단맛과 호두의 향','11.png','2022-11-13',NULL,NULL,6300,30),(32,'에티오피아 아리차 예가체프 G1 내추럴',200,'싱그러운 장미의 신맛 끝에 오는 달콤한 후미','12.png','2022-11-13',NULL,NULL,12600,30),(33,'케냐 AA Plus 아이히더 커피원두',200,'라임의 깔끔한 산미와 입안에서 느껴지는 부드러운 촉감','13.png','2022-11-13',NULL,NULL,12800,30),(34,'G블렌딩 블루라마 커피원두',200,'밀크초콜릿과 바닐라의 단맛, 알싸한 꽃향기와 온화한 산미의 만남. 부드러운 바디와 깔끔한 후미의 블렌딩','14.png','2022-11-13',NULL,NULL,9900,30),(35,'코스타리카 따라주 SHB 커피원두',200,'커피의 진주. 와인의 향, 부드러운 산미와 바디감이 균형을 이룸','15.png','2022-11-13',NULL,NULL,9300,30),(36,'G블렌딩 먼로화이트 스페셜티 블렌드',200,'베리류의 산미, 요거트향과 달콤한 바디, 부드러운 촉감, 실크, 꽃과 과일','16.png','2022-11-13',NULL,NULL,12600,30),(37,'에티오피아 코체레 예가체프 G1 내추럴',200,'풍성한 후르츠 아로마에 오래 지속되는 후미','17.png','2022-11-13',NULL,NULL,14900,30),(38,'과테말라 산타모니카 SHB 커피원두',200,'깊고 선명한 달콤함과 기분 좋은 스모키함의 만남','18.png','2022-11-13',NULL,NULL,12300,30),(39,'예멘 모카 마타리 알 함다니',200,'플로럴,건포도,자두,대추차,카카오닙스,오트밀,민감초,복합적인,부드러움','19.png','2022-11-13',NULL,NULL,23000,30),(40,'지로스팅 디카페인원두 콜롬비아 에티오피아 커피원두',200,'천연 CO2(이산화탄소)추출 공법으로 카페인을 99.9% 제거한 더 맛있는 디카페인 커피 원두','20.png','2022-11-13',NULL,NULL,13500,30);
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
INSERT INTO `qna_write` VALUES (1,'test1',NULL,NULL,NULL,'2022-11-15 12:39:49',NULL,NULL),(2,'test1',NULL,NULL,NULL,'2022-11-15 12:39:53',NULL,NULL),(3,'test1',NULL,NULL,NULL,'2022-11-15 13:54:18',NULL,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna_write_comment`
--

LOCK TABLES `qna_write_comment` WRITE;
/*!40000 ALTER TABLE `qna_write_comment` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'supersounds',1,13,'2022-11-14 01:44:45','호시기',5),(2,'test1',3,12,'2022-11-15 11:48:57','커피맛이 너무 좋아요 에티오피아 산은 역시 다르네요!',5),(3,'test1',2,12,'2022-11-15 11:49:11','원하는 맛보다 살짝 달라서 4점남깁니당..ㅠㅠ',4),(4,'test2',5,12,'2022-11-15 11:50:22','맛있어용 회사사람들도 다들 좋아해용!!',4),(5,'test2',6,13,'2022-11-15 11:50:39','아 너무아쉬워요 ㅠㅠ 다음엔 이제품 안먹을거같아요',2),(6,'test5',30,8,'2022-11-15 11:54:02','인도네시아산은 처음인데.. 브라질 에티오피아만 먹다가 저렴해서 혹해서 샀는데 맛있네용!!',4),(7,'test5',43,12,'2022-11-15 11:54:59','맛있어요 집에서 내려먹고 커피숍가는 것 보다 더 좋은거같아요 !! 강추합니다!',5),(8,'test6',45,8,'2022-11-15 11:56:48','나와의 맞는 원두 찾기를하고 구매를 했는데 제 입맛과는 다른 맛이네요 ㅜㅜ 다음엔 다른 제품 시켜먹어볼게요',3),(9,'test6',44,12,'2022-11-15 11:57:13','자주 시켜먹는 제품 팔길레 이쪽 사이트에서 구매했는데 가격도 착하고 배송도빠르네요 !! 굿굿',4),(10,'test7',47,12,'2022-11-15 12:02:26','가격대비 별로입니다 저는 안먹을래요',2),(11,'test7',48,8,'2022-11-15 12:02:43','가성비 좋네요 딱 그정도?? 회사용으로 먹기 좋은듯~',4),(12,'test8',50,12,'2022-11-15 12:04:42','비싼값합니다 추천드리고싶네요 산미 바디감 적당합니다!',4),(13,'test8',51,8,'2022-11-15 12:05:07','인도네시아.. 저하고는 안맞는거같아요 저는 브라질산가겠습니다 ㅠㅠㅋ',3),(14,'test9',53,12,'2022-11-15 12:11:54','에잉 전 이거 별로에요! ㅠㅠ!',1),(15,'test9',54,8,'2022-11-15 12:12:05','이건 뭐 쪼꼼 괜찮다?싶은정도네용 흥!',2),(16,'test10',56,12,'2022-11-15 12:29:53','치킨먹고 디저트 타임때 먹으면 느끼함이 싹 가셔요!! 좋습니다!!',5),(17,'test10',57,8,'2022-11-15 12:30:10','느끼함이 싹가시진 못하고 여운이 좀 남아서 아쉽습니다 ㅠㅠ 그래도 4점!',4),(18,'test11',59,12,'2022-11-15 12:31:32','높은 산미와 아로마향의 진함으로 진짜 커피숍에서 먹는 느낌이에요 너무좋아요!!',5),(19,'test11',60,8,'2022-11-15 12:31:55','적당한 커피라고 생각이들어요 제가 생각한거보단 기대이하여서 3점남겨드리빈다.',3);
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
INSERT INTO `user` VALUES ('admin','관리자','1234','manage@manage.com','관리자',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('butter77','비오는날엔라떼지','hfhdj478','butter77@gmail.com','김희원','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123','1995-03-05','여자','01038950291','2022-09-15',NULL,NULL),('inna5255','shininginna','innapwpw1','inna007@naver.com','유인나','서울 서대문구 봉원사2길 10-2','서울 서대문구 신촌동 1-19','더조은오피스텔 201-1001','03721','1987-03-18','여자','01026118689','2022-10-03',NULL,NULL),('kim9238','티뱃폭스','qwer1234','dudgur1992@gmail.com','김영혁','강원 동해시 가마골길 1','강원 동해시 부곡동 95-27','가마솥밥','25733','1992-04-24','남자','010-5656-3333','2022-11-14',NULL,NULL),('kimsin','doggaebi','qwe123','kimsin@gmail.com','김신','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705','07134','1983-07-12','남자','01077175277','2022-09-27',NULL,NULL),('nara7','모닝커피','qwe123','nara77@gmail.com','권나라','서울 강남구 도산대로 402-2','서울 강남구 청담동 77','푸르지오 107-1705','06062','1992-07-05','여자','01051132872','2022-08-12',NULL,NULL),('soonsin12','커피가좋아','asd77qwe','leesoonsin01@gmail.com','이순신','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관','07558','1980-07-30','남자','01074637896','2022-09-11',NULL,NULL),('supersounds','반킴','qwe123','supersounds@naver.com','김영혁','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','106-1303','26378','1992-04-28','남자','010-5656-4569','2022-11-14',NULL,NULL),('test1','커피매니아','1234','test1@test1.com','김춘배','서울 강남구 강남대로 525','서울 강남구 강남대로 615','힐스테이트 105-1705','07134',NULL,NULL,NULL,'2022-11-14',NULL,NULL),('test10','호시기두마링','1234','test10@test10.com','이호식','서울 서대문구 봉원사2길 10-2','서울 서대문구 신촌동 1-19','더조은오피스텔 201-1001','03721',NULL,NULL,NULL,NULL,NULL,NULL),('test11','커피맛사탕','1234','test11@test11.com','김신영','서울 강남구 도산대로 402-2','서울 강남구 청담동 77','푸르지오 107-1705','06062',NULL,NULL,NULL,NULL,NULL,NULL),('test2','라임맛소세지','1234','test2@test2.com','황인심','강원 원주시 봉화서부로 26','강원 원주시 단계동 1168-1','108-2032','26378',NULL,NULL,NULL,'2022-11-14',NULL,NULL),('test3','황금맛비율','1234','test3@test3.com','나선욱','서울 강서구 공항대로 615','서울 강서구 공항대로 615','강서도서관','07558',NULL,NULL,NULL,'2022-11-14',NULL,NULL),('test4','혼자만의시간','1234','test4@test4.com','진창선','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL),('test5','커피맛초코','1234','test5@test5.com','김환영','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL),('test6','기능적인만남','1234','test6@test6.com','박상훈','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL),('test7','변하지않는사랑','1234','test7@test7.com','한상열','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL),('test8','와인','1234','test8@test8.com','김경호','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL),('test9','명철이닷','1234','test9@test9.com','송명철','서울 강북대로 615','서울 강북구 강북대로 615','강북아파트','08123',NULL,NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-11-15 14:01:48
