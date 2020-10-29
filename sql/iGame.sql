/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.20 : Database - igame_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`igame_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `igame_db`;

/*Table structure for table `tb_article` */

DROP TABLE IF EXISTS `tb_article`;

CREATE TABLE `tb_article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `game_id` int DEFAULT NULL,
  `head_cover` varchar(50) NOT NULL DEFAULT '/picture/cover/headdefault.png',
  `article_cover` varchar(50) NOT NULL DEFAULT '/picture/cover/default.png',
  `title` varchar(20) DEFAULT NULL,
  `outline` varchar(50) DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `advantages` varchar(100) DEFAULT NULL,
  `disadvantages` varchar(100) DEFAULT NULL,
  `up_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_article` */

insert  into `tb_article`(`article_id`,`user_id`,`game_id`,`head_cover`,`article_cover`,`title`,`outline`,`content`,`advantages`,`disadvantages`,`up_date`) values 
(1,1,1,'/picture/cover/headdefault.png','/picture/cover/default.png','Title1','OutLineOutLineOutLineOutLineOutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(2,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','画质好-可玩性高-可多人合作','1-2-3-4','2020-10-19 11:26:13'),
(3,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(4,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(5,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(6,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(7,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13'),
(8,1,2,'/picture/cover/headdefault.png','/picture/cover/default.png','Tilte','OutLineOutLineOutLine','ContentContentContentContentContentContentContentContentContent','1-2-3-4','1-2-3-4','2020-10-19 11:26:13');

/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `article_id` int DEFAULT NULL,
  `game_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `parent_id` int DEFAULT NULL,
  `reply_id` int DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comment_state` int NOT NULL DEFAULT '1',
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_comment` */

insert  into `tb_comment`(`comment_id`,`article_id`,`game_id`,`user_id`,`parent_id`,`reply_id`,`content`,`comment_state`,`comment_date`) values 
(1,NULL,2,1,1,NULL,'333333',1,'2020-10-16 12:43:50'),
(24,NULL,2,1,24,NULL,'二楼？',1,'2020-10-16 12:44:17'),
(25,NULL,2,1,25,NULL,'三楼！',1,'2020-10-16 12:44:48'),
(26,NULL,2,1,1,1,'23333？',1,'2020-10-16 12:44:58'),
(27,NULL,2,3,1,26,'自己回复自己？？？',1,'2020-10-16 12:46:29'),
(28,NULL,2,3,28,NULL,'那我是四楼！！',1,'2020-10-16 12:50:17'),
(29,NULL,2,3,29,NULL,'123333',1,'2020-10-16 13:02:11'),
(30,NULL,2,3,1,26,'自 娱 自 乐',1,'2020-10-16 13:02:33'),
(31,NULL,2,1,1,30,'？？？？',1,'2020-10-16 13:03:06'),
(32,NULL,2,1,28,28,'你是憨憨吗？',1,'2020-10-16 13:03:26'),
(33,NULL,2,6,1,31,'hhh',1,'2020-10-27 14:04:40'),
(34,NULL,1,6,34,NULL,'我来看看',1,'2020-10-27 14:05:03'),
(35,NULL,6,6,35,NULL,'让我康康',1,'2020-10-27 14:24:17'),
(36,NULL,6,6,35,35,'沙发',1,'2020-10-27 14:24:28'),
(37,NULL,6,1,35,36,'????',1,'2020-10-27 14:24:53'),
(38,NULL,2,1,38,NULL,'又来？',1,'2020-10-27 14:29:50'),
(39,NULL,2,7,39,NULL,'lucky 黄',1,'2020-10-27 16:30:06'),
(40,NULL,1,7,40,NULL,'lucky 黄',1,'2020-10-27 16:34:37'),
(41,NULL,2,7,41,NULL,'cccccccccccccccc',1,'2020-10-27 16:46:10'),
(42,NULL,1,8,42,NULL,'11111',1,'2020-10-27 16:56:36'),
(43,NULL,1,8,43,NULL,'11111',1,'2020-10-27 16:56:45'),
(44,NULL,1,9,44,NULL,'1',1,'2020-10-27 17:12:36'),
(45,NULL,1,9,45,NULL,'kkk',1,'2020-10-27 17:12:47'),
(46,NULL,1,9,34,34,'test',1,'2020-10-27 17:14:15'),
(47,NULL,1,9,34,46,'test2',1,'2020-10-27 17:14:26'),
(48,NULL,1,9,34,47,'test3',1,'2020-10-27 17:14:34'),
(49,NULL,12,9,49,NULL,'good',1,'2020-10-27 20:28:32'),
(50,NULL,2,1,1,30,'333',1,'2020-10-28 14:55:17');

/*Table structure for table `tb_game_platform` */

DROP TABLE IF EXISTS `tb_game_platform`;

CREATE TABLE `tb_game_platform` (
  `game_id` int NOT NULL,
  `platform_id` int NOT NULL,
  `game_price` decimal(11,2) DEFAULT NULL,
  `release_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_game_platform` */

insert  into `tb_game_platform`(`game_id`,`platform_id`,`game_price`,`release_date`) values 
(1,101,58.00,'2015-07-10'),
(1,103,116.00,'2015-05-14'),
(2,101,27.00,'2015-03-13'),
(3,103,58.00,'2020-08-08'),
(4,102,59.00,'2020-10-13'),
(6,101,59.00,'2020-12-19'),
(7,102,59.00,'2020-10-13'),
(8,101,59.00,'2020-10-24'),
(9,102,59.00,'2020-12-19'),
(10,103,59.00,'2020-10-29'),
(11,103,59.00,'2020-12-19'),
(12,101,59.00,'2020-10-31'),
(13,101,59.00,'2020-10-28'),
(14,103,59.00,'2020-10-13'),
(15,101,59.00,'2020-10-26'),
(16,102,59.00,'2020-11-28'),
(17,103,59.00,'2020-10-13'),
(18,101,59.00,'2020-10-13'),
(19,102,59.00,'2021-02-13'),
(20,101,59.00,'2021-03-05'),
(21,103,59.00,'2020-10-13'),
(5,101,59.00,'2021-01-15');

/*Table structure for table `tb_gameinfo` */

DROP TABLE IF EXISTS `tb_gameinfo`;

CREATE TABLE `tb_gameinfo` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `game_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `game_type` int NOT NULL,
  `views` int NOT NULL DEFAULT '0',
  `game_cover_img` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publisher` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `game_introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gameplay` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_gameinfo` */

insert  into `tb_gameinfo`(`game_id`,`game_name`,`game_type`,`views`,`game_cover_img`,`publisher`,`game_introduce`,`gameplay`) values 
(1,'GTA5',11,100,'/image/gameInfo/1_GTA5_cover.jpg','Rock Star','《侠盗猎车5(Grand Theft Auto V)》是由Rockstar制作发行的一款围绕犯罪为主题的开放式动作冒险游戏，游戏背景洛圣都基于现实地区中的美国洛杉矶和加州南部制作，游戏拥有几乎与现实世界相同的世界观。玩家可扮演三位主角并在任意时刻进行切换，每位主角都有自己独特的人格与故事背景，以及交织的剧情。','《侠盗猎车5(Grand Theft Auto V)》是由Rockstar制作发行的一款围绕犯罪为主题的开放式动作冒险游戏，游戏背景洛圣都基于现实地区中的美国洛杉矶和加州南部制作，游戏拥有几乎与现实世界相同的世界观。玩家可扮演三位主角并在任意时刻进行切换，每位主角都有自己独特的人格与故事背景，以及交织的剧情。'),
(2,'ARK',11,1000,'/image/gameInfo/2_ARK_cover.jpg','Studio Wildcard','《方舟：生存进化(ARK: Survival Evolved)》是由Studio Wildcard制作发行的一款生存类开放世界游戏，采用虚幻4引擎打造。游戏将以生存要素为主，并混合了独特的多人合作和竞争要素。游戏开始时玩家们将在某个神秘的小岛中醒来，而这里还有和玩家同样陷入混乱的一群人。而在游戏中，大家需要通过打猎、工艺、研究技术等多种方式来生存下去，此外玩家们还需要建立庇护所来保护自己，防止大家因为恶劣的天气、危险的野生动物或潜在的敌人丧命。','《方舟：生存进化(ARK: Survival Evolved)》是由Studio Wildcard制作发行的一款生存类开放世界游戏，采用虚幻4引擎打造。游戏将以生存要素为主，并混合了独特的多人合作和竞争要素。游戏开始时玩家们将在某个神秘的小岛中醒来，而这里还有和玩家同样陷入混乱的一群人。而在游戏中，大家需要通过打猎、工艺、研究技术等多种方式来生存下去，此外玩家们还需要建立庇护所来保护自己，防止大家因为恶劣的天气、危险的野生动物或潜在的敌人丧命。'),
(3,'GTA5',11,200,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(4,'GTA5',11,200,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(5,'GTA5',11,200,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(6,'GTA6',11,400,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(7,'尼尔：机械纪元',11,700,'/image/gameInfo/1532327846_923833.jpg','Square Enix','《尼尔：机械纪元(NieR：Automata)》是由索尼与白金工作室联合制作，Square Enix发行的一款动作RPG游戏，讲述了在被摧毁的地球上由人类的敌人外星人派来的机械生命体与人类方派出的人造人“尤尔哈(YoRHa)”部队进行战斗的故事。游戏背景设定在和《尼尔》相同的世界，并将有一个全新的故事剧情，但和前作几乎没有关联。','《尼尔：机械纪元(NieR：Automata)》是由索尼与白金工作室联合制作，Square Enix发行的一款动作RPG游戏，讲述了在被摧毁的地球上由人类的敌人外星人派来的机械生命体与人类方派出的人造人“尤尔哈(YoRHa)”部队进行战斗的故事。游戏背景设定在和《尼尔》相同的世界，并将有一个全新的故事剧情，但和前作几乎没有关联。'),
(8,'GTA5',11,10,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(9,'GTA5',11,220,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(10,'GTA5',11,750,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(11,'GTA5',11,77,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(12,'GTA5',11,542,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(13,'GTA5',11,400,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(14,'GTA5',11,442,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(15,'GTA5',11,220,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(16,'GTA5',11,110,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(17,'GTA5',11,770,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(18,'GTA5',11,57,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(19,'GTA5',11,57,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(20,'GTA5',11,440,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法'),
(21,'GTA5',11,990,'/image/gameInfo/1_GTA5_cover.jpg','RockStar','GTA5介绍','GTA5玩法');

/*Table structure for table `tb_gamer` */

DROP TABLE IF EXISTS `tb_gamer`;

CREATE TABLE `tb_gamer` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(11) NOT NULL,
  `user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` int NOT NULL DEFAULT '2',
  `h_img_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '/image/headPhoto/default.jpg',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_gamer` */

insert  into `tb_gamer`(`user_id`,`phone_number`,`user_name`,`password`,`role_id`,`h_img_path`) values 
(1,'17799996666','Admin','123',1,'/image/headPhoto/b640879f-e89a-45c5-8e28-da02afc4982c.jpg'),
(2,'17799995555','Lucky','123',2,'/image/headPhoto/default.jpg'),
(3,'13366663333','Lucy','123333',2,'/image/headPhoto/default.jpg'),
(4,'19900002222','Tom','333222111',2,'/image/headPhoto/default.jpg'),
(5,'15611231123','Sam','123333',2,'/image/headPhoto/default.jpg'),
(6,'13366664444','uu1','123456',2,'/image/headPhoto/default.jpg'),
(7,'18607996847','catcc','445566',2,'/image/headPhoto/default.jpg'),
(8,'18279121587','111','111111',2,'/image/headPhoto/default.jpg'),
(9,'15779173031','jzw','123456',2,'/image/headPhoto/default.jpg'),
(10,'18877776666','u123','123123',2,'/image/headPhoto/default.jpg');

/*Table structure for table `tb_gametag` */

DROP TABLE IF EXISTS `tb_gametag`;

CREATE TABLE `tb_gametag` (
  `tag_id` int NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_gametag` */

insert  into `tb_gametag`(`tag_id`,`game_id`) values 
(105,1),
(106,1),
(107,1),
(101,2),
(106,2),
(107,2),
(107,18),
(106,18);

/*Table structure for table `tb_images` */

DROP TABLE IF EXISTS `tb_images`;

CREATE TABLE `tb_images` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `image_path` varchar(100) DEFAULT NULL,
  `game_id` int DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_images` */

insert  into `tb_images`(`image_id`,`image_path`,`game_id`) values 
(1,'/picture/gamePic/2/156-150531155A3.jpg',2),
(2,'/picture/gamePic/2/156-150531155A3.jpg',2),
(3,'/picture/gamePic/2/156-150531155A3.jpg',2),
(4,'/picture/gamePic/2/156-150531155A3.jpg',2),
(5,'/picture/gamePic/2/156-150531155A3.jpg',2);

/*Table structure for table `tb_platform` */

DROP TABLE IF EXISTS `tb_platform`;

CREATE TABLE `tb_platform` (
  `platform_id` int NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `platform_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `platform_url` varchar(100) DEFAULT NULL,
  `company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_platform` */

insert  into `tb_platform`(`platform_id`,`platform_name`,`platform_desc`,`platform_url`,`company`) values 
(101,'Steam','Steam???',NULL,'Steam'),
(102,'Switch','Switch...',NULL,'任天堂'),
(103,'PS5','PlayStation 5',NULL,'索尼');

/*Table structure for table `tb_rank` */

DROP TABLE IF EXISTS `tb_rank`;

CREATE TABLE `tb_rank` (
  `game_id` int DEFAULT NULL,
  `views` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_rank` */

/*Table structure for table `tb_score` */

DROP TABLE IF EXISTS `tb_score`;

CREATE TABLE `tb_score` (
  `score_id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `user_id` int NOT NULL,
  `score_count` float NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_score` */

insert  into `tb_score`(`score_id`,`game_id`,`user_id`,`score_count`) values 
(1,2,1,8.9),
(5,2,2,8.4),
(6,2,3,4.6),
(7,8,1,8.9),
(9,1,1,6.7),
(10,2,6,9.9),
(11,1,6,9.4),
(12,8,6,5.1),
(13,6,6,9.6),
(14,2,7,0.6),
(15,18,7,9.9),
(16,8,9,7.9),
(17,15,9,4.7),
(18,2,10,9.3);

/*Table structure for table `tb_tag` */

DROP TABLE IF EXISTS `tb_tag`;

CREATE TABLE `tb_tag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(20) NOT NULL,
  `tag_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `head_img` varchar(50) NOT NULL DEFAULT '/image/tagpic/default.jpg',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_tag` */

insert  into `tb_tag`(`tag_id`,`tag_name`,`tag_desc`,`head_img`) values 
(100,'国产','国产游戏在21世纪初期，通过《仙剑奇侠传》和《轩辕剑》“两剑”为首，曾有一段不小的辉煌时刻，但随着时间的流逝，渐渐地没落了。不过目前仍然有许多优秀的国产独立游戏逐渐涌出，也有大作在进行研发，这可能是国产单机游戏最好的时候。','/image/tagpic/default.jpg'),
(101,'沙盒','沙盒游戏（Sandbox Games），是由沙盘游戏慢慢演变而来，自成一种游戏类型，由一个或多个地图区域构成，往往包含动作、射击，格斗，驾驶等多种元素，一般游戏地图较大，交互性强、自由度高、随机事件多，创造性强，是其特点，玩家可以在游戏世界中自由奔跑而不是根据游戏设置的主线剧情进行游戏。创造性是该类型游戏核心玩法，利用游戏中的提供的物件制造出玩家自己独创的东西。','/image/tagpic/default.jpg'),
(102,'音乐','Tag Desc','/image/tagpic/default.jpg'),
(103,'回合制','Tag Desc','/image/tagpic/default.jpg'),
(104,'卡牌','Tag Desc','/image/tagpic/default.jpg'),
(105,'动作','Tag Desc','/image/tagpic/default.jpg'),
(106,'开放世界','开放世界可以说是当今最为流行的游戏类型之一了，这类游戏都拥有着极度自由的特性，它们都包含了非常广阔的地图、众多的可探索区域、大量的可交互物体和丰富的剧情线，这些要素组合成了一个无比真实的游戏世界，给玩家们带来了非常优秀的沉浸式体验，毕竟，谁会讨厌来一次“第二人生”？','/image/tagpic/default.jpg'),
(107,'大型游戏','Tag Desc','/image/tagpic/default.jpg');

/*Table structure for table `tb_type` */

DROP TABLE IF EXISTS `tb_type`;

CREATE TABLE `tb_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_type` */

insert  into `tb_type`(`type_id`,`type_name`) values 
(10,'角色扮演'),
(11,'动作'),
(12,'休闲');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
