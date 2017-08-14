/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-07-15 19:22:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(10) NOT NULL auto_increment,
  `picture` varchar(100) collate utf8_unicode_ci default NULL,
  `name` varchar(20) collate utf8_unicode_ci default NULL,
  `sex` varchar(4) collate utf8_unicode_ci default NULL,
  `school` varchar(50) collate utf8_unicode_ci default NULL,
  `course` varchar(20) collate utf8_unicode_ci default NULL,
  `goodness` varchar(100) collate utf8_unicode_ci default NULL,
  `phone` varchar(20) collate utf8_unicode_ci default NULL,
  `price` varchar(10) collate utf8_unicode_ci default NULL,
  `elegantshow` varchar(200) collate utf8_unicode_ci default NULL,
  `comment` varchar(100) character set utf8 default NULL COMMENT '教师信息',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'C:\\Users\\616934150\\Pictures', '张三', '男', '学校1', 'JAVA', '优势。。。。', '111111111111111', '200', '风采展示1', '不错..........');
INSERT INTO `teacher` VALUES ('2', 'C:\\Users\\616934150\\Pictures', '李四', '女', '学校2', 'C++', '略。。。。。。', '111111111111111', '200', '风采展示2', '不错。。。。。');
INSERT INTO `teacher` VALUES ('3', 'C:\\Users\\616934150\\Pictures', '王五', '男', '学校3', 'PHP', '..........', '2222222222222', '500', '3.................', 'good................');
