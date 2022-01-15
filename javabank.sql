/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : javabank

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 15/01/2022 15:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `firstName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lastName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `balance` int NOT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1001', '123456', '普华', '孙', 71888, NULL);
INSERT INTO `account` VALUES ('1002', '123456', '昊天', '朱', 10000, NULL);
INSERT INTO `account` VALUES ('1003', '123', '天宸', '郭', 960201, NULL);
INSERT INTO `account` VALUES ('1005', '111', '一涵', '刘', 1000, NULL);

-- ----------------------------
-- Table structure for turnover
-- ----------------------------
DROP TABLE IF EXISTS `turnover`;
CREATE TABLE `turnover`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `fk` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `amount` int NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of turnover
-- ----------------------------
INSERT INTO `turnover` VALUES (1, '1003', '存款', 100, '2021-12-22');
INSERT INTO `turnover` VALUES (2, '1003', '存款', 300, '2021-12-22');
INSERT INTO `turnover` VALUES (3, '1003', '存款', 100, '2021-12-22');
INSERT INTO `turnover` VALUES (4, '1003', '取款', 1000, '2021-12-22');
INSERT INTO `turnover` VALUES (5, '1003', '存款', 600, '2021-12-22');
INSERT INTO `turnover` VALUES (10, '1003', '存款', 100, '2021-12-22');
INSERT INTO `turnover` VALUES (11, '1003', '存款', 200, '2021-12-22');
INSERT INTO `turnover` VALUES (13, '1003', '取款', 5000, '2021-12-22');
INSERT INTO `turnover` VALUES (14, '1005', '存款', 200, '2021-12-22');
INSERT INTO `turnover` VALUES (15, '1001', '取款', 2000, '2021-12-22');
INSERT INTO `turnover` VALUES (16, '1001', '取款', 5000, '2021-12-22');
INSERT INTO `turnover` VALUES (17, '1003', '存款', 200, '2022-01-02');
INSERT INTO `turnover` VALUES (19, '1003', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (20, '1003', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (21, '1003', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (22, '1003', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (23, '1003', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (24, '1003', '取款', 5000, '2022-01-02');
INSERT INTO `turnover` VALUES (25, '1001', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (26, '1001', '取款', 5000, '2022-01-02');
INSERT INTO `turnover` VALUES (27, '1001', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (28, '1001', '取款', 2000, '2022-01-02');
INSERT INTO `turnover` VALUES (29, '1001', '取款', 1000, '2022-01-02');
INSERT INTO `turnover` VALUES (30, '1003', '存款', 100, '2022-01-03');

SET FOREIGN_KEY_CHECKS = 1;
