-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.5.51-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 zeronewsdb 的数据库结构
DROP DATABASE IF EXISTS `zeronewsdb`;
CREATE DATABASE IF NOT EXISTS `zeronewsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zeronewsdb`;

-- 导出  表 zeronewsdb.audit 结构
DROP TABLE IF EXISTS `audit`;
CREATE TABLE IF NOT EXISTS `audit` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(16) DEFAULT NULL,
  `reply` varchar(50) DEFAULT NULL,
  `auditNum` int(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='审核表';

-- 正在导出表  zeronewsdb.audit 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `newsId`, `reply`, `auditNum`, `createTime`) VALUES
	(1, 1, NULL, 1002, '2018-11-30 16:03:18');
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- 导出  表 zeronewsdb.comment 结构
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(16) DEFAULT NULL,
  `userId` bigint(16) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 正在导出表  zeronewsdb.comment 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `newsId`, `userId`, `context`, `createTime`) VALUES
	(1, 1, 2, '很不错', '2018-11-30 16:03:47');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 导出  表 zeronewsdb.emp 结构
DROP TABLE IF EXISTS `emp`;
CREATE TABLE IF NOT EXISTS `emp` (
  `num` int(4) DEFAULT NULL,
  `userId` bigint(16) DEFAULT NULL,
  `auditNum` int(4) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `type` bit(1) DEFAULT NULL,
  `列 9` bit(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职工表';

-- 正在导出表  zeronewsdb.emp 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` (`num`, `userId`, `auditNum`, `name`, `phone`, `address`, `status`, `type`, `列 9`, `createTime`) VALUES
	(1001, 1, NULL, '郭小明', '15226110381', '郑州师范学院', 4, b'1', NULL, '2018-11-30 15:55:44'),
	(1002, 2, NULL, 'Xm Guo', '15226110381', '郑州', 4, b'0', NULL, '2018-11-30 16:02:27');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;

-- 导出  表 zeronewsdb.love 结构
DROP TABLE IF EXISTS `love`;
CREATE TABLE IF NOT EXISTS `love` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `editorId` bigint(16) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isLove` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关注表';

-- 正在导出表  zeronewsdb.love 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
INSERT INTO `love` (`id`, `userId`, `editorId`, `createTime`, `isLove`) VALUES
	(1, 2, 1, '2018-11-30 16:03:58', b'1');
/*!40000 ALTER TABLE `love` ENABLE KEYS */;

-- 导出  表 zeronewsdb.msg 结构
DROP TABLE IF EXISTS `msg`;
CREATE TABLE IF NOT EXISTS `msg` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `isRead` bit(1) DEFAULT b'0',
  `context` text,
  `createTime` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT '零点新闻官方',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='消息表';

-- 正在导出表  zeronewsdb.msg 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` (`id`, `userId`, `isRead`, `context`, `createTime`, `name`) VALUES
	(1, 1, b'1', '<div>\r\n    <p>零点新闻欢迎您的加入！</p>\r\n    <p>快去完善自己的个人资料吧！</p>\r\n    <p>\r\n        详情请点击：<a href="/#/home/details/update">www.zeronews.com</a>\r\n    </p>\r\n</div>', '2018-11-30 14:28:32', '零点新闻官方'),
	(2, 2, b'0', '<div>\r\n    <p>零点新闻欢迎您的加入！</p>\r\n    <p>快去完善自己的个人资料吧！</p>\r\n    <p>\r\n        详情请点击：<a href="/#/home/details/update">www.zeronews.com</a>\r\n    </p>\r\n</div>', '2018-11-30 16:01:40', '零点新闻官方');
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;

-- 导出  表 zeronewsdb.news 结构
DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `context` text,
  `images` text,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `createTime` datetime DEFAULT NULL,
  `pullTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- 正在导出表  zeronewsdb.news 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `userId`, `title`, `context`, `images`, `type`, `status`, `createTime`, `pullTime`) VALUES
	(1, 1, '主要是', '<p>小哈</p><p><img src="static/upload/1/news/2ed9e69a625b4b0392f9f2b4b93be1d5.jpg" width="875" style=""></p>', 'static/upload/1/news/2ed9e69a625b4b0392f9f2b4b93be1d5.jpg', 1, 5, '2018-11-30 15:58:09', '2018-11-30 15:58:14');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- 导出  表 zeronewsdb.reply 结构
DROP TABLE IF EXISTS `reply`;
CREATE TABLE IF NOT EXISTS `reply` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `replyUserId` bigint(16) DEFAULT NULL,
  `newsId` bigint(16) DEFAULT NULL,
  `commentId` bigint(16) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='回复表';

-- 正在导出表  zeronewsdb.reply 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` (`id`, `userId`, `replyUserId`, `newsId`, `commentId`, `context`, `createTime`) VALUES
	(1, 1, 2, NULL, 1, '是啥', '2018-11-30 16:05:14');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;

-- 导出  表 zeronewsdb.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `isActive` bit(1) DEFAULT b'0',
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `signature` varchar(50) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `image` varchar(500) NOT NULL DEFAULT 'static/upload/default/head.jpg',
  `bg` varchar(500) NOT NULL DEFAULT 'static/upload/default/home.jpg',
  `type` int(11) DEFAULT '1',
  `gender` bit(1) DEFAULT b'1',
  `birth` date DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  zeronewsdb.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `isActive`, `username`, `password`, `signature`, `code`, `image`, `bg`, `type`, `gender`, `birth`, `createTime`) VALUES
	(1, '1373572467@qq.com', b'1', '即墨', '123456', NULL, '964199', 'static/upload/1/head.jpg', 'static/upload/1/bg.jpg', 2, b'1', NULL, '2018-11-30 14:28:32'),
	(2, 'xmxm0304@gmail.com', b'1', NULL, 'ggm0304', NULL, '901970', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 3, b'1', NULL, '2018-11-30 16:01:40');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 zeronewsdb.zan 结构
DROP TABLE IF EXISTS `zan`;
CREATE TABLE IF NOT EXISTS `zan` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `newsId` bigint(16) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='赞';

-- 正在导出表  zeronewsdb.zan 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `zan` DISABLE KEYS */;
INSERT INTO `zan` (`id`, `userId`, `newsId`, `createTime`) VALUES
	(1, 2, 1, '2018-11-30 16:03:30'),
	(2, 1, 1, '2018-11-30 16:05:08');
/*!40000 ALTER TABLE `zan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
