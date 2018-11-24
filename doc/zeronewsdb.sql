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
CREATE TABLE IF NOT EXISTS `audit` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(16) DEFAULT NULL,
  `reply` varchar(50) DEFAULT NULL,
  `auditNum` int(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='审核表';

-- 正在导出表  zeronewsdb.audit 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `newsId`, `reply`, `auditNum`, `createTime`) VALUES
	(28, 4, '不想不知道', 1001, '2018-11-20 15:41:52'),
	(29, 5, '无所畏惧', 1001, '2018-11-20 15:42:08'),
	(30, 4, NULL, 1001, '2018-11-20 15:46:49'),
	(31, 5, NULL, 1001, '2018-11-20 15:46:55'),
	(32, 4, NULL, 1001, '2018-11-20 15:48:03'),
	(33, 5, NULL, 1001, '2018-11-20 15:48:05'),
	(34, 6, NULL, 1001, '2018-11-22 11:35:58'),
	(35, 1, NULL, 1001, '2018-11-24 10:32:33'),
	(36, 3, NULL, 1001, '2018-11-24 10:32:35'),
	(37, 2, '嘎嘎嘎', 1001, '2018-11-24 14:16:47'),
	(38, 8, NULL, 1001, '2018-11-24 17:26:11');
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- 导出  表 zeronewsdb.comment 结构
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(16) DEFAULT NULL,
  `userId` bigint(16) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 正在导出表  zeronewsdb.comment 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `newsId`, `userId`, `context`, `createTime`) VALUES
	(1, 6, 5, '嘿嘿，我们来了', '2018-11-21 14:46:28'),
	(2, 6, 5, '骄傲回复', '2018-11-21 17:22:53'),
	(3, 3, 5, 'sahjwdhh', '2018-11-21 18:16:49'),
	(4, 4, 5, 'hjdahqg', '2018-11-22 10:35:51'),
	(5, 4, 5, '哈哈哈', '2018-11-22 12:54:21'),
	(6, 4, 5, '哈哈哈', '2018-11-22 12:56:02'),
	(7, 4, 5, '嘎嘎', '2018-11-22 12:57:31'),
	(8, 4, 2, '嘉佳', '2018-11-24 11:00:31'),
	(9, 5, 10, '6666', '2018-11-24 15:48:36'),
	(10, 1, 11, 'gaga', '2018-11-24 15:50:19'),
	(11, 1, 5, '哈哈度', '2018-11-24 17:23:10');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 导出  表 zeronewsdb.emp 结构
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

-- 正在导出表  zeronewsdb.emp 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` (`num`, `userId`, `auditNum`, `name`, `phone`, `address`, `status`, `type`, `列 9`, `createTime`) VALUES
	(1001, 2, NULL, '郭小明', '1522611****', '郑州师范学院', 4, b'0', NULL, '2018-11-17 14:42:34'),
	(1002, 5, NULL, '李文霖', '15188852154', '郑州', 4, b'1', NULL, '2018-11-17 19:08:04'),
	(NULL, 6, NULL, NULL, NULL, NULL, 1, b'0', NULL, '2018-11-18 18:07:18'),
	(NULL, 10, NULL, NULL, NULL, NULL, 1, NULL, NULL, '2018-11-24 15:50:52');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;

-- 导出  表 zeronewsdb.love 结构
CREATE TABLE IF NOT EXISTS `love` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `editorId` bigint(16) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isLove` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='关注表';

-- 正在导出表  zeronewsdb.love 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
INSERT INTO `love` (`id`, `userId`, `editorId`, `createTime`, `isLove`) VALUES
	(1, 2, 5, '2018-11-24 10:49:41', b'1'),
	(3, 5, 5, '2018-11-24 13:14:33', b'1'),
	(4, 11, 5, '2018-11-24 15:50:10', b'1');
/*!40000 ALTER TABLE `love` ENABLE KEYS */;

-- 导出  表 zeronewsdb.msg 结构
CREATE TABLE IF NOT EXISTS `msg` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `isRead` bit(1) DEFAULT b'0',
  `context` text,
  `createTime` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT '零点新闻官方',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='消息表';

-- 正在导出表  zeronewsdb.msg 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` (`id`, `userId`, `isRead`, `context`, `createTime`, `name`) VALUES
	(1, 5, b'1', '<div>\r\n    <p>零点新闻欢迎您的加入！</p>\r\n    <p>快去完善自己的个人资料吧！</p>\r\n    <p>\r\n        详情请点击：<a href="/#/home/details/update">www.zeronews.com</a>\r\n    </p>\r\n</div>', '2018-11-24 15:45:47', '零点新闻官方'),
	(2, 11, b'0', '<div>\r\n    <p>零点新闻欢迎您的加入！</p>\r\n    <p>快去完善自己的个人资料吧！</p>\r\n    <p>\r\n        详情请点击：<a href="/#/home/details/update">www.zeronews.com</a>\r\n    </p>\r\n</div>', '2018-11-24 15:49:16', '零点新闻官方');
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;

-- 导出  表 zeronewsdb.news 结构
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- 正在导出表  zeronewsdb.news 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `userId`, `title`, `context`, `images`, `type`, `status`, `createTime`, `pullTime`) VALUES
	(1, 5, '请实话', '<p>海</p>', NULL, 6, 5, '2018-11-18 15:55:02', '2018-11-22 13:02:14'),
	(2, 5, '哈哈', '<p>嘟嘟嘟</p>', NULL, 5, 4, '2018-11-18 15:56:49', '2018-11-24 14:16:25'),
	(3, 5, '哈哈', '<p>嘟嘟嘟</p><p><br></p>', NULL, 5, 5, '2018-11-18 15:58:31', '2018-11-22 13:02:07'),
	(4, 5, '加油', '<p>啊是</p><p><img src="static/upload/5/news/5fb3e30c96b849d9b7c85c6b424c2276.jpg" width="822"></p><p>想家</p>', 'static/upload/5/news/5fb3e30c96b849d9b7c85c6b424c2276.jpg', 4, 5, '2018-11-18 16:14:36', NULL),
	(5, 5, '大玩家', '<p><img src="static/upload/5/news/435fad20a7654188a660e858f719a07e.jpg" width="318" style=""></p><p><span class="ql-size-huge">我是大玩家</span></p>', 'static/upload/5/news/435fad20a7654188a660e858f719a07e.jpg', 6, 5, '2018-11-18 18:02:21', '2018-11-18 18:02:41'),
	(8, 5, '阿卜杜', '<p>是擦看K，</p><p><img src="static/upload/5/news/ae35305679c74006b6e86e903e569c54.jpg" width="598" style="cursor: nwse-resize;"></p>', 'static/upload/5/news/ae35305679c74006b6e86e903e569c54.jpg', 4, 5, '2018-11-24 17:24:44', '2018-11-24 17:25:47');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- 导出  表 zeronewsdb.reply 结构
CREATE TABLE IF NOT EXISTS `reply` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `replyUserId` bigint(16) DEFAULT NULL,
  `newsId` bigint(16) DEFAULT NULL,
  `commentId` bigint(16) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='回复表';

-- 正在导出表  zeronewsdb.reply 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` (`id`, `userId`, `replyUserId`, `newsId`, `commentId`, `context`, `createTime`) VALUES
	(2, 5, 5, NULL, 1, '按计划', '2018-11-21 17:45:53'),
	(3, 5, NULL, NULL, NULL, 'yangcheng', '2018-11-21 18:10:19'),
	(4, 5, NULL, NULL, NULL, 'hahah', '2018-11-21 18:11:15'),
	(5, 5, 5, NULL, NULL, 'hahh1d', '2018-11-21 18:12:55'),
	(6, 5, 5, NULL, 1, 'hahqhs', '2018-11-21 18:15:49'),
	(7, 5, 5, NULL, 1, 'ahjhwfhh', '2018-11-21 18:19:09'),
	(8, 5, 5, NULL, 4, '加油', '2018-11-22 12:59:36'),
	(9, 2, 5, NULL, 4, '很厉害吗', '2018-11-24 11:00:08'),
	(10, 5, 11, NULL, 10, '啊哈哈的', '2018-11-24 17:23:24'),
	(11, 5, 5, NULL, 10, '爱国歌曲', '2018-11-24 17:23:31');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;

-- 导出  表 zeronewsdb.user 结构
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  zeronewsdb.user 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `isActive`, `username`, `password`, `signature`, `code`, `image`, `bg`, `type`, `gender`, `birth`, `createTime`) VALUES
	(2, '1373572467@qq.com', b'1', '零度微笑', 'ggm0304', '一场游戏一场梦......', '498705', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 3, b'1', '2018-11-20', '2018-11-17 09:01:08'),
	(5, '2595435815@qq.com', b'1', '班歌', '123456', NULL, '730254', 'static/upload/5/head.jpg', 'static/upload/default/home.jpg', 2, b'1', NULL, '2018-11-17 12:19:04'),
	(6, '1690485578@qq.com', b'1', 'laomeng', '123456', NULL, '758498', '', 'static/upload/default/home.jpg', 1, b'1', '2018-11-14', '2018-11-18 18:05:35'),
	(7, '1269009546@qq.com', b'1', NULL, 'xueli123', '333333333333', '657880', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 1, b'0', '2018-11-13', '2018-11-22 15:58:23'),
	(8, 'satxyo02649@chacuo.net', b'0', NULL, NULL, NULL, '548427', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 1, b'1', NULL, NULL),
	(9, '598062183@qq.com', b'0', NULL, NULL, NULL, '135035', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 1, b'1', NULL, NULL),
	(10, '598062186@qq.com', b'1', NULL, '123456', NULL, '178560', 'static/upload/10/head.jpg', 'static/upload/default/home.jpg', 1, b'1', NULL, '2018-11-24 15:41:54'),
	(11, 'tkv49991@ebbob.com', b'1', NULL, '123456', NULL, '840319', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 1, b'1', NULL, '2018-11-24 15:49:16');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 zeronewsdb.zan 结构
CREATE TABLE IF NOT EXISTS `zan` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `newsId` bigint(16) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='赞';

-- 正在导出表  zeronewsdb.zan 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `zan` DISABLE KEYS */;
INSERT INTO `zan` (`id`, `userId`, `newsId`, `createTime`) VALUES
	(1, 5, 6, '2018-11-21 13:59:48'),
	(2, 5, 3, '2018-11-21 18:16:21'),
	(3, 5, 2, '2018-11-21 18:19:44'),
	(4, 5, 4, '2018-11-22 10:35:47'),
	(5, 2, 4, '2018-11-24 10:59:54'),
	(6, 2, 1, '2018-11-24 12:00:52'),
	(7, 5, 1, '2018-11-24 13:14:48'),
	(8, 10, 1, '2018-11-24 15:48:14'),
	(9, 11, 1, '2018-11-24 15:50:14'),
	(10, 5, 8, '2018-11-24 17:25:03'),
	(11, 2, 8, '2018-11-24 17:26:36');
/*!40000 ALTER TABLE `zan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
