/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 119.29.101.72:3306
 Source Schema         : yiyong

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 04/06/2019 15:06:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_thing
-- ----------------------------
DROP TABLE IF EXISTS `my_thing`;
CREATE TABLE `my_thing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `category` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lp` float NULL DEFAULT NULL,
  `hp` float NULL DEFAULT NULL,
  `pic_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_thing
-- ----------------------------
INSERT INTO `my_thing` VALUES (18, '4条装 中空纱华夫格毛巾', '可以放进嘴里的抗敏感毛巾', '洗护', 10, 20, '/uploads/pic/2017/09/09/14/beb52b0e-6f53-4da6-81ab-1e7a4fee31ee.png');
INSERT INTO `my_thing` VALUES (19, '超细深层清洁洗脸刷', '85万根柔软细毛', '洗护', 10, 20, '/uploads/pic/2017/09/09/14/8d76a60f-a0d1-498c-80ce-1def7b23dcc0.png');
INSERT INTO `my_thing` VALUES (20, '棱面陶瓷凉水杯 250ml', '几何，色彩，暖心之选', '杯具', 10, 20, '/uploads/pic/2017/09/09/14/d4f23b55-130c-4539-a62c-2eaa129c0b9d.png');
INSERT INTO `my_thing` VALUES (21, '便携多功能分类收纳盒', '多格分类，小巧便携', '收纳', 19, 50, '/uploads/pic/2017/09/09/14/26c8007b-dd68-4268-b477-ba3285ae0d98.png');

SET FOREIGN_KEY_CHECKS = 1;
