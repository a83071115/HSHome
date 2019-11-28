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
insert into `wx_member` (`id`, `nickname`, `openid`, `mobile`, `sex`, `avatar`, `salt`, `reg_ip`, `status`, `updated_time`, `created_time`) values('1','Alex','osIAd5Ont961XbAzlqy0tP6OndMs','','1','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epuR5PQXqlLEGFttsNnwFPibP953um42sKWXX4zmnibnZIDibu1J6Y5x9icibzDVJ4tEXTb7PtS5szTCHw/132','3b9429a3-1fb2-46fe-85c0-aae4aa2f6749',',China,Beijing','1',NULL,'2019-11-28 22:27:05');
