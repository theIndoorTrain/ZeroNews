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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='审核表';

-- 正在导出表  zeronewsdb.audit 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `newsId`, `reply`, `auditNum`, `createTime`) VALUES
	(28, 4, '不想不知道', 1001, '2018-11-20 15:41:52'),
	(29, 5, '无所畏惧', 1001, '2018-11-20 15:42:08'),
	(30, 4, NULL, 1001, '2018-11-20 15:46:49'),
	(31, 5, NULL, 1001, '2018-11-20 15:46:55'),
	(32, 4, NULL, 1001, '2018-11-20 15:48:03'),
	(33, 5, NULL, 1001, '2018-11-20 15:48:05');
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- 导出  表 zeronewsdb.comment 结构
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(16) DEFAULT NULL,
  `userId` bigint(16) DEFAULT NULL,
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 正在导出表  zeronewsdb.comment 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
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

-- 正在导出表  zeronewsdb.emp 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` (`num`, `userId`, `auditNum`, `name`, `phone`, `address`, `status`, `type`, `列 9`, `createTime`) VALUES
	(1001, 2, NULL, '郭小明', '1522611****', '郑州师范学院', 4, b'0', NULL, '2018-11-17 14:42:34'),
	(1002, 5, NULL, '李文霖', '15188852154', '郑州', 4, b'1', NULL, '2018-11-17 19:08:04'),
	(NULL, 6, NULL, NULL, NULL, NULL, 1, b'0', NULL, '2018-11-18 18:07:18');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;

-- 导出  表 zeronewsdb.love 结构
CREATE TABLE IF NOT EXISTS `love` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `userId` bigint(16) DEFAULT NULL,
  `editorId` bigint(16) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isLove` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表';

-- 正在导出表  zeronewsdb.love 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
/*!40000 ALTER TABLE `love` ENABLE KEYS */;

-- 导出  表 zeronewsdb.msg 结构
CREATE TABLE IF NOT EXISTS `msg` (
  `id` bigint(16) DEFAULT NULL,
  `userId` bigint(16) DEFAULT NULL,
  `isRead` bit(1) DEFAULT b'0',
  `context` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

-- 正在导出表  zeronewsdb.msg 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- 正在导出表  zeronewsdb.news 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `userId`, `title`, `context`, `images`, `type`, `status`, `createTime`, `pullTime`) VALUES
	(1, 5, '请实话', '<p>海</p>', NULL, 6, 1, '2018-11-18 15:55:02', NULL),
	(2, 5, '哈哈', '<p>嘟嘟嘟</p>', NULL, 5, 1, '2018-11-18 15:56:49', NULL),
	(3, 5, '哈哈', '<p>嘟嘟嘟</p><p><br></p>', NULL, 5, 1, '2018-11-18 15:58:31', NULL),
	(4, 5, '加油', '<p>啊是</p><p><img src="static/upload/5/news/5fb3e30c96b849d9b7c85c6b424c2276.jpg" width="822"></p><p>想家</p>', 'static/upload/5/news/5fb3e30c96b849d9b7c85c6b424c2276.jpg', 4, 5, '2018-11-18 16:14:36', NULL),
	(5, 5, '大玩家', '<p><img src="static/upload/5/news/435fad20a7654188a660e858f719a07e.jpg" width="318" style=""></p><p><span class="ql-size-huge">我是大玩家</span></p>', 'static/upload/5/news/435fad20a7654188a660e858f719a07e.jpg', 6, 5, '2018-11-18 18:02:21', '2018-11-18 18:02:41'),
	(6, 5, '亲历习近平在巴新精彩瞬间：“China， Good！”', '<p class="ql-indent-1"><span class="ql-size-large">“能欢迎习近平主席是我最大的荣幸！”</span></p><p class="ql-indent-1"><span class="ql-size-large">11月15日，当习近平主席的专机抵达巴布亚新几内亚首都莫尔兹比港时，欢迎队伍中的阿里克什非常激动，头戴羽饰、腰系草裙、手持皮鼓的他跳起最热情洋溢的迎宾舞蹈，欢迎中国贵宾的到来。</span></p><p class="ql-indent-1"><span class="ql-size-large">阿里克什来自巴布亚新几内亚赫拉省的胡里·温格曼部落，为了这次欢迎仪式，他和他的伙伴们提前7、8个小时就已经开始准备了。阿里克什说：“你看我们脸上和身上的装饰，需要两个多小时才能全部装扮完毕，这是我们部落欢迎最尊贵的客人的礼仪。非常荣幸我能够见证习近平主席访问巴新，能欢迎习近平主席是我最大的荣幸！”</span></p><p class="ql-indent-1"><span class="ql-size-large">欢迎仪式之前，鲁比一直拿着他的皮鼓反复练习，“我一定要用最好的状态展示巴新人的热情，”他说。</span></p><p class="ql-indent-1"><span class="ql-size-large">在欢迎人群中，一群身着华丽民族服装的学生颇引人注目，最小的孩子看上去只有7、8岁的样子。老师克里斯蒂娜带领着孩子们边舞蹈边高唱歌曲。“欢迎中国朋友！感谢中国为我们带来美好！……”孩子们的声音清澈空灵，又颇有节奏感，成为中国与巴新友好关系的最佳注脚之一。</span></p><p class="ql-indent-2"><img src="static/upload/5/news/e48eaa316fd84b5fbf8e41d867690d46.jpg" width="954" style=""></p>', 'static/upload/5/news/e48eaa316fd84b5fbf8e41d867690d46.jpg', 3, 1, '2018-11-19 14:56:42', NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';

-- 正在导出表  zeronewsdb.reply 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  zeronewsdb.user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `isActive`, `username`, `password`, `signature`, `code`, `image`, `bg`, `type`, `gender`, `birth`, `createTime`) VALUES
	(2, '1373572467@qq.com', b'1', '零度微笑', 'ggm0304', '一场游戏一场梦......', '347609', 'static/upload/default/head.jpg', 'static/upload/default/home.jpg', 3, b'1', '2018-11-20', '2018-11-17 09:01:08'),
	(5, '2595435815@qq.com', b'1', '班歌', '123456', NULL, '730254', 'static/upload/5/head.jpg', 'static/upload/default/home.jpg', 2, b'1', NULL, '2018-11-17 12:19:04'),
	(6, '1690485578@qq.com', b'1', 'laomeng', '123456', NULL, '758498', '', 'static/upload/default/home.jpg', 1, b'1', '2018-11-14', '2018-11-18 18:05:35');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
