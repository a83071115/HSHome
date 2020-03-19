/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.38 : Database - ruoyi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ruoyi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ruoyi`;

/*Table structure for table `wx_member_location_current` */

DROP TABLE IF EXISTS `wx_member_location_current`;

CREATE TABLE `wx_member_location_current` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `openid` varchar(64) NOT NULL COMMENT '用户id',
  `latitude` varchar(20) NOT NULL COMMENT '纬度',
  `longitude` varchar(20) NOT NULL COMMENT '经度',
  `speed` varchar(100) DEFAULT NULL COMMENT '速度',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='会员当前位置';

/*Data for the table `wx_member_location_current` */

insert  into `wx_member_location_current`(`id`,`openid`,`latitude`,`longitude`,`speed`,`create_time`,`update_time`) values (7,'osIAd5LrlCwO3NTJHj3tN_wWznuw','39.95642768012153','116.36209120008681','0','2019-12-01 12:27:38','2019-12-01 12:27:38'),(6,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-12-01 10:17:42','2019-12-01 10:17:42'),(5,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 22:56:01','2019-12-01 22:56:01'),(8,'osIAd5E0mDubSDt803tBbUO744jo','39.8880729675293','116.3852310180664','-1','2019-11-30 19:15:58','2019-11-30 19:15:58');

/*Table structure for table `wx_member_location_history` */

DROP TABLE IF EXISTS `wx_member_location_history`;

CREATE TABLE `wx_member_location_history` (
  `id` int(32) NOT NULL DEFAULT '0',
  `openid` varchar(64) NOT NULL COMMENT '用户id',
  `latitude` varchar(20) NOT NULL COMMENT '纬度',
  `longitude` varchar(20) NOT NULL COMMENT '经度',
  `speed` varchar(100) DEFAULT NULL COMMENT '速度',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='会员历史位置';

/*Data for the table `wx_member_location_history` */

insert  into `wx_member_location_history`(`id`,`openid`,`latitude`,`longitude`,`speed`,`create_time`,`update_time`) values (0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.8880500793457','116.3851318359375','0','2019-11-30 21:45:59','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.8880500793457','116.3851318359375','0','2019-11-30 21:45:59','0000-00-00 00:00:00'),(0,'osIAd5E0mDubSDt803tBbUO744jo','39.8880729675293','116.3852310180664','-1','2019-11-30 19:15:58','0000-00-00 00:00:00'),(0,'osIAd5LrlCwO3NTJHj3tN_wWznuw','39.88808376736111','116.38497667100694','0','2019-11-30 19:14:14','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.888038635253906','116.38507080078125','-1','2019-11-30 19:14:12','0000-00-00 00:00:00'),(0,'osIAd5LrlCwO3NTJHj3tN_wWznuw','39.888142632378475','116.3849986436632','0','2019-11-30 19:11:03','0000-00-00 00:00:00'),(0,'osIAd5LrlCwO3NTJHj3tN_wWznuw','39.888142632378475','116.3849986436632','0','2019-11-30 19:11:02','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.94325637817383','116.35658264160156','-1','2019-11-30 17:41:24','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145538330078125','116.30133056640625','-1','2019-11-30 16:26:54','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.1455192565918','116.30132293701172','-1','2019-11-30 16:26:29','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 16:23:51','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145511627197266','116.30135345458984','-1','2019-11-30 16:04:55','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14551544189453','116.30136108398438','-1','2019-11-30 16:04:50','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14556884765625','116.30137634277344','-1','2019-11-30 16:04:44','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145538330078125','116.3013687133789','-1','2019-11-30 16:04:33','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14557647705078','116.3013687133789','-1','2019-11-30 16:04:02','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14555358886719','116.30134582519531','-1','2019-11-30 15:56:22','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14554977416992','116.30135345458984','-1','2019-11-30 15:56:00','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14554214477539','116.30131530761719','-1','2019-11-30 15:55:46','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:54:27','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:54:26','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14554214477539','116.3013687133789','-1','2019-11-30 15:51:46','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:33:02','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:30:23','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:27:30','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:24:03','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 15:10:20','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.1454963684082','116.30137634277344','-1','2019-11-30 14:56:27','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14553451538086','116.30133819580078','-1','2019-11-30 14:56:17','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 14:47:52','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145565032958984','116.30126953125','-1','2019-11-30 14:40:33','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-11-30 14:38:45','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-11-30 14:34:23','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145538330078125','116.3013916015625','-1','2019-11-30 14:23:44','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-11-30 14:20:11','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-11-30 14:19:10','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-11-30 14:15:28','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-11-30 14:15:12','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.95903015136719','116.34688568115234','-1','2019-11-30 22:38:01','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.99299240112305','116.33675384521484','-1','2019-11-30 22:50:26','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','39.99299240112305','116.33675384521484','-1','2019-11-30 22:50:35','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.042991638183594','116.31522369384766','-1','2019-11-30 22:50:43','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.042991638183594','116.31522369384766','-1','2019-11-30 22:50:46','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.042991638183594','116.31522369384766','-1','2019-11-30 22:50:46','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.042991638183594','116.31522369384766','-1','2019-11-30 22:50:47','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.042991638183594','116.31522369384766','-1','2019-11-30 22:50:47','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.05316925048828','116.30577850341797','-1','2019-11-30 22:53:52','0000-00-00 00:00:00'),(0,'osIAd5Kw2xSeafXTPhKxNoCcGIJU','40.22077','116.23128','-1','2019-12-01 10:17:42','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:20:05','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:21:37','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:28:11','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:28:25','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:29:50','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:30:43','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:30:51','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:32:48','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:47:28','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 10:48:03','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:05:32','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:05:53','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:09:04','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:09:27','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:10:46','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 11:11:19','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:10:34','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:14:33','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14552307128906','116.30126953125','-1','2019-12-01 12:15:04','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.14551544189453','116.3012924194336','-1','2019-12-01 12:15:55','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:19:54','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:04','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:04','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:04','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:05','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:05','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:05','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:05','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:42','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 12:20:58','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.145545959472656','116.30133056640625','-1','2019-12-01 12:21:40','0000-00-00 00:00:00'),(0,'osIAd5LrlCwO3NTJHj3tN_wWznuw','39.95642768012153','116.36209120008681','0','2019-12-01 12:27:38','0000-00-00 00:00:00'),(0,'osIAd5Ont961XbAzlqy0tP6OndMs','40.22077','116.23128','-1','2019-12-01 22:56:01','0000-00-00 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;