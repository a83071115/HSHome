/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.38 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `wx_member` (
	`id` int (11),
	`nickname` varchar (300),
	`openid` varchar (240),
	`mobile` varchar (33),
	`sex` tinyint (1),
	`avatar` varchar (600),
	`salt` varchar (192),
	`reg_ip` varchar (300),
	`status` tinyint (1),
	`updated_time` timestamp ,
	`created_time` timestamp 
); 
insert into `wx_member` (`id`, `nickname`, `openid`, `mobile`, `sex`, `avatar`, `salt`, `reg_ip`, `status`, `updated_time`, `created_time`) values('15','张小勇','osIAd5Kw2xSeafXTPhKxNoCcGIJU','','1','https://wx.qlogo.cn/mmopen/vi_32/OCAp4uz2Q0DrhEpMbIknp8KQKhagw8hA1n8WWAUmupNJG3GaOpsiaeF6o0KGLB5aR77LnoINuIcQztOicenQSaWQ/132','a6de2b8c-f761-454c-952e-2fa8f173425c','Tongzhou,China,Beijing','1',NULL,'2019-11-30 15:54:23');
insert into `wx_member` (`id`, `nickname`, `openid`, `mobile`, `sex`, `avatar`, `salt`, `reg_ip`, `status`, `updated_time`, `created_time`) values('16','Alex','osIAd5Ont961XbAzlqy0tP6OndMs','','1','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epuR5PQXqlLEGFttsNnwFPibP953um42sKWXX4zmnibnZIDibu1J6Y5x9icibzDVJ4tEXTb7PtS5szTCHw/132','f55260a6-80a2-4691-92db-27dfa6ac8c6c',',China,Beijing','1',NULL,'2019-11-30 17:41:24');
insert into `wx_member` (`id`, `nickname`, `openid`, `mobile`, `sex`, `avatar`, `salt`, `reg_ip`, `status`, `updated_time`, `created_time`) values('17','否极泰来','osIAd5LrlCwO3NTJHj3tN_wWznuw','','1','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIsdBPvqH0AoJPc3jiadfUgqzwHc2LA8E9BJxLCl5p5ZbZgcPPOyUMvmFXibL90Q1hUm0EZDbtIMR0A/132','12ca9ff9-3e4c-4c3c-9eee-7ec26fcebce1',',China,','1',NULL,'2019-11-30 19:10:58');
insert into `wx_member` (`id`, `nickname`, `openid`, `mobile`, `sex`, `avatar`, `salt`, `reg_ip`, `status`, `updated_time`, `created_time`) values('18','Mikk','osIAd5E0mDubSDt803tBbUO744jo','','1','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIibicIaiaeJJmWFRs63nzITZ5oWPsNWlVE3icibq0MHbCtlGTEn4gs0RPhibibpl5mlpbyCEnYlulwQbzLg/132','34dead99-5003-4f49-ba28-c7f78c7ce42c',',China,Beijing','1',NULL,'2019-11-30 19:15:04');
