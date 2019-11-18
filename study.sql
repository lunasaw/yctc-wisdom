/*
 Navicat Premium Data Transfer

 Source Server         : manager
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : fwwb

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 17/11/2019 19:17:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_academy
-- ----------------------------
DROP TABLE IF EXISTS `tb_academy`;
CREATE TABLE `tb_academy`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `academy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称\r\n',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_academy`(`academy`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_academy
-- ----------------------------
INSERT INTO `tb_academy` VALUES (2, '信息工程学院', '2019-03-05 21:51:11.000000', '2019-03-05 21:51:11.000000');

-- ----------------------------
-- Table structure for tb_attendance
-- ----------------------------
DROP TABLE IF EXISTS `tb_attendance`;
CREATE TABLE `tb_attendance`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课时id',
  `attend_state` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '出勤情况',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_attendance`(`user_id`, `lesson_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 455 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生考勤点名，算法写入' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_attendance
-- ----------------------------
INSERT INTO `tb_attendance` VALUES (65, NULL, NULL, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (66, NULL, NULL, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (67, NULL, NULL, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (68, NULL, NULL, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (69, 6, 2, 2, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (70, 7, 2, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (71, 8, 2, 1, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (72, 9, 2, 1, '2019-04-07 13:59:39.000000', '2019-04-11 21:48:30.000000');
INSERT INTO `tb_attendance` VALUES (73, NULL, NULL, 2, '2019-04-07 13:59:39.000000', '2019-04-07 13:59:39.000000');
INSERT INTO `tb_attendance` VALUES (124, NULL, NULL, 1, '2019-05-11 10:25:26.000000', '2019-05-11 10:25:26.000000');
INSERT INTO `tb_attendance` VALUES (125, NULL, NULL, 1, '2019-05-11 10:25:26.000000', '2019-05-11 10:25:26.000000');
INSERT INTO `tb_attendance` VALUES (126, 13, 4, 1, '2019-05-11 10:25:26.000000', '2019-05-11 10:25:26.000000');
INSERT INTO `tb_attendance` VALUES (127, 14, 4, 1, '2019-05-11 10:25:26.000000', '2019-05-11 10:25:26.000000');
INSERT INTO `tb_attendance` VALUES (128, 15, 5, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (129, 16, 6, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (130, 17, 7, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (131, 18, 7, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (132, 19, 8, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (133, 20, 9, 1, '2019-05-11 10:25:27.000000', '2019-05-11 10:25:27.000000');
INSERT INTO `tb_attendance` VALUES (244, NULL, NULL, 1, '2019-10-30 13:42:42.000000', '2019-10-30 13:42:42.000000');
INSERT INTO `tb_attendance` VALUES (245, 1, 2, 1, '2019-10-30 16:48:03.000000', '2019-10-30 16:48:05.000000');
INSERT INTO `tb_attendance` VALUES (246, NULL, NULL, 1, '2019-10-30 16:52:11.000000', '2019-10-30 16:52:13.000000');
INSERT INTO `tb_attendance` VALUES (247, NULL, NULL, 2, '2019-10-30 16:52:23.000000', '2019-10-30 16:52:25.000000');
INSERT INTO `tb_attendance` VALUES (248, 27, 2, 2, '2019-10-30 16:52:37.000000', '2019-10-30 16:52:40.000000');
INSERT INTO `tb_attendance` VALUES (249, 28, 2, 2, '2019-10-30 16:52:54.000000', '2019-10-30 16:52:55.000000');
INSERT INTO `tb_attendance` VALUES (250, 6, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (251, 10, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (252, 9, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (253, 8, 23, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (254, 7, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (255, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (256, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (257, NULL, NULL, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (258, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (259, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (260, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (261, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (262, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (263, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (264, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (265, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (266, 1, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (267, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (268, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (269, NULL, NULL, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (270, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (271, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (272, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (273, 16, 2, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (274, 17, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (275, 18, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (276, 19, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (277, 20, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (278, 21, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (279, 22, 2, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (280, 28, 23, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (281, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (282, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (283, 1, 36, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (284, 2, 36, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (285, 3, 36, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (286, 4, 36, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (287, 5, 36, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (288, 1, 5, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (289, 2, 5, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (290, 3, 5, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (291, 4, 5, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (292, 5, 5, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (293, 1, 8, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (294, 2, 8, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (295, 3, 8, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (296, 4, 8, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (297, 5, 8, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (298, 6, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (299, 7, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (300, 8, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (301, 9, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (302, 10, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (303, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (304, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (305, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (306, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (307, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (308, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (309, 11, 37, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (310, 12, 37, 3, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (311, 13, 37, 4, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (313, 14, 37, 5, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (314, 15, 37, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (315, 1, 35, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (316, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (317, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (318, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (319, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (320, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (321, 1, 241, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (322, 2, 241, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (323, 3, 241, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (324, 4, 241, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (325, 5, 241, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (326, 1, 249, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (327, 2, 259, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (328, 3, 249, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (329, 4, 249, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (330, 5, 249, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (331, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (332, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (333, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (334, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (335, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (336, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (337, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (338, 1, 253, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_attendance` VALUES (339, 2, 253, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_attendance` VALUES (340, 3, 253, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_attendance` VALUES (341, 4, 253, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_attendance` VALUES (342, 5, 253, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_attendance` VALUES (343, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (344, NULL, NULL, 0, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (345, 1, 254, 0, '2019-11-02 14:16:47.000000', '2019-11-02 14:16:47.000000');
INSERT INTO `tb_attendance` VALUES (346, 16, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (347, 17, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (348, 18, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (349, 19, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (350, 20, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (351, 21, 257, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_attendance` VALUES (352, 16, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (353, 17, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (354, 18, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (355, 19, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (356, 20, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (357, 21, 261, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_attendance` VALUES (358, 11, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (359, 12, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (360, 13, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (361, 14, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (362, 15, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (363, 16, 1, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (364, 17, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (365, 18, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (366, 19, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (367, 20, 1, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (368, 21, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (369, 22, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (370, 23, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (371, 24, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (372, 25, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (373, 26, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (374, 27, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (375, 28, 1, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (376, 29, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (377, 1, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (378, 2, 1, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (379, 3, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (380, 4, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (381, 5, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (382, 6, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (383, 7, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (384, 8, 1, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (385, 9, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (386, 10, 1, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (387, 11, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (388, 12, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (389, 13, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (390, 14, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (391, 15, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (392, 16, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (393, 17, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (394, 18, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (395, 19, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (396, 20, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (397, 21, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (398, 22, 33, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (399, 23, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (400, 24, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (401, 25, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (402, 26, 33, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (403, 27, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (404, 28, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (405, 29, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (406, 1, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (407, 2, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (408, 3, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (409, 4, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (410, 5, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (411, 6, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (412, 7, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (413, 8, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (414, 9, 33, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (415, 10, 33, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (416, 11, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (417, 12, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (418, 13, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (419, 14, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (420, 15, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (421, 16, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (422, 17, 34, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (423, 18, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (424, 19, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (425, 20, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (426, 21, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (427, 22, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (428, 23, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (429, 24, 34, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (430, 25, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (431, 26, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (432, 27, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (433, 28, 34, 2, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (434, 29, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (435, 1, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (436, 2, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (437, 3, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (438, 4, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (439, 5, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (440, 6, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (441, 7, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (442, 8, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (443, 16, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (444, 17, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (445, 18, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (446, 19, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (447, 20, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (448, 21, 262, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_attendance` VALUES (449, 9, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (450, 10, 34, 1, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (451, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (452, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (453, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (454, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (455, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_attendance` VALUES (456, 134, 1, 1, '2019-11-17 17:18:11.000000', '2019-11-17 17:18:11.000000');

-- ----------------------------
-- Table structure for tb_building_floor
-- ----------------------------
DROP TABLE IF EXISTS `tb_building_floor`;
CREATE TABLE `tb_building_floor`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `building` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼号',
  `floor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼层',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `floor`) USING BTREE,
  UNIQUE INDEX `uk_building_floor`(`building`, `floor`) USING BTREE,
  INDEX `idx_building`(`building`) USING BTREE,
  INDEX `idx_floor`(`floor`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_building_floor
-- ----------------------------
INSERT INTO `tb_building_floor` VALUES (2, '主楼', '二楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (3, '主楼', '三楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (4, '4号楼', '十二楼', '2019-03-04 13:07:12.000000', '2019-04-07 15:57:10.000000');
INSERT INTO `tb_building_floor` VALUES (5, '7号楼', '一楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (6, '7号楼', '二楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (7, '5号楼', '一楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (8, '5号楼', '二楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (10, '6号楼', '一楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (11, '6号楼', '二楼', '2019-03-04 13:07:12.000000', '2019-03-04 13:08:03.000000');
INSERT INTO `tb_building_floor` VALUES (12, '主楼', '十一楼', '2019-03-04 13:07:12.000000', '2019-04-07 17:17:42.000000');
INSERT INTO `tb_building_floor` VALUES (13, '主楼', '一楼', '2019-10-30 13:42:42.000000', '2019-10-30 13:42:42.000000');

-- ----------------------------
-- Table structure for tb_checkpicture
-- ----------------------------
DROP TABLE IF EXISTS `tb_checkpicture`;
CREATE TABLE `tb_checkpicture`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pictureId` int(255) NULL DEFAULT NULL,
  `intflag` int(11) NULL DEFAULT NULL,
  `knowledgeid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 393 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_checkpicture
-- ----------------------------
INSERT INTO `tb_checkpicture` VALUES (51, 1, 2, 331);
INSERT INTO `tb_checkpicture` VALUES (52, 2, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (53, 3, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (54, 4, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (55, 5, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (56, 6, 2, 2);
INSERT INTO `tb_checkpicture` VALUES (57, 7, 2, 2);
INSERT INTO `tb_checkpicture` VALUES (58, 8, 2, 2);
INSERT INTO `tb_checkpicture` VALUES (59, 9, 2, 2);
INSERT INTO `tb_checkpicture` VALUES (60, 10, 2, 2);
INSERT INTO `tb_checkpicture` VALUES (61, 11, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (62, 12, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (63, 13, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (64, 14, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (65, 15, 1, 331);
INSERT INTO `tb_checkpicture` VALUES (66, 16, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (67, 17, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (68, 18, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (69, 19, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (70, 20, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (71, 21, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (72, 22, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (73, 23, 2, 362);
INSERT INTO `tb_checkpicture` VALUES (74, 24, 2, 362);
INSERT INTO `tb_checkpicture` VALUES (75, 25, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (76, 26, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (77, 27, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (78, 28, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (79, 29, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (80, 30, 2, 363);
INSERT INTO `tb_checkpicture` VALUES (81, 31, 2, 363);
INSERT INTO `tb_checkpicture` VALUES (82, 32, 2, 363);
INSERT INTO `tb_checkpicture` VALUES (83, 33, 2, 364);
INSERT INTO `tb_checkpicture` VALUES (84, 34, 2, 364);
INSERT INTO `tb_checkpicture` VALUES (85, 35, 1, 364);
INSERT INTO `tb_checkpicture` VALUES (86, 36, 1, 364);
INSERT INTO `tb_checkpicture` VALUES (87, 37, 1, 364);
INSERT INTO `tb_checkpicture` VALUES (88, 38, 1, 365);
INSERT INTO `tb_checkpicture` VALUES (89, 39, 1, 365);
INSERT INTO `tb_checkpicture` VALUES (90, 40, 1, 365);
INSERT INTO `tb_checkpicture` VALUES (91, 41, 2, 365);
INSERT INTO `tb_checkpicture` VALUES (92, 42, 2, 365);
INSERT INTO `tb_checkpicture` VALUES (93, 43, 2, 342);
INSERT INTO `tb_checkpicture` VALUES (94, 44, 2, 342);
INSERT INTO `tb_checkpicture` VALUES (95, 45, 2, 342);
INSERT INTO `tb_checkpicture` VALUES (96, 46, 2, 342);
INSERT INTO `tb_checkpicture` VALUES (97, 47, 2, 342);
INSERT INTO `tb_checkpicture` VALUES (98, 48, 1, 343);
INSERT INTO `tb_checkpicture` VALUES (99, 49, 1, 343);
INSERT INTO `tb_checkpicture` VALUES (100, 50, 1, 343);
INSERT INTO `tb_checkpicture` VALUES (332, 587, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (333, 588, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (334, 589, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (335, 590, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (336, 591, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (337, 592, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (338, 593, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (339, 594, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (340, 595, 2, 360);
INSERT INTO `tb_checkpicture` VALUES (341, 596, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (342, 597, 1, 360);
INSERT INTO `tb_checkpicture` VALUES (343, 598, 1, 361);
INSERT INTO `tb_checkpicture` VALUES (344, 599, 1, 361);
INSERT INTO `tb_checkpicture` VALUES (345, 600, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (346, 601, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (347, 602, 1, 362);
INSERT INTO `tb_checkpicture` VALUES (348, 603, 1, 364);
INSERT INTO `tb_checkpicture` VALUES (349, 604, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (350, 605, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (351, 606, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (352, 607, 1, 363);
INSERT INTO `tb_checkpicture` VALUES (353, 608, 1, 365);
INSERT INTO `tb_checkpicture` VALUES (354, 609, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (355, 610, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (356, 611, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (357, 612, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (358, 613, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (359, 614, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (360, 615, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (361, 616, 1, 366);
INSERT INTO `tb_checkpicture` VALUES (362, 617, 1, 367);
INSERT INTO `tb_checkpicture` VALUES (363, 618, 1, 367);
INSERT INTO `tb_checkpicture` VALUES (364, 619, 1, 368);
INSERT INTO `tb_checkpicture` VALUES (365, 620, 2, 368);
INSERT INTO `tb_checkpicture` VALUES (366, 621, 2, 368);
INSERT INTO `tb_checkpicture` VALUES (367, 622, 2, 368);
INSERT INTO `tb_checkpicture` VALUES (368, 623, 1, 369);
INSERT INTO `tb_checkpicture` VALUES (369, 624, 1, 369);
INSERT INTO `tb_checkpicture` VALUES (370, 625, 1, 369);
INSERT INTO `tb_checkpicture` VALUES (371, 626, 1, 370);
INSERT INTO `tb_checkpicture` VALUES (372, 627, 1, 370);
INSERT INTO `tb_checkpicture` VALUES (373, 628, 1, 370);
INSERT INTO `tb_checkpicture` VALUES (374, 629, 1, 370);
INSERT INTO `tb_checkpicture` VALUES (375, 630, 1, 371);
INSERT INTO `tb_checkpicture` VALUES (376, 631, 1, 372);
INSERT INTO `tb_checkpicture` VALUES (377, 632, 2, 372);
INSERT INTO `tb_checkpicture` VALUES (378, 633, 2, 372);
INSERT INTO `tb_checkpicture` VALUES (379, 634, 2, 372);
INSERT INTO `tb_checkpicture` VALUES (380, 635, 2, 372);
INSERT INTO `tb_checkpicture` VALUES (381, 636, 1, 371);
INSERT INTO `tb_checkpicture` VALUES (382, 637, 2, 371);
INSERT INTO `tb_checkpicture` VALUES (383, 638, 2, 371);
INSERT INTO `tb_checkpicture` VALUES (384, 639, 2, 371);
INSERT INTO `tb_checkpicture` VALUES (385, 640, 2, 371);
INSERT INTO `tb_checkpicture` VALUES (386, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (387, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (388, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (389, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (390, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (391, NULL, NULL, NULL);
INSERT INTO `tb_checkpicture` VALUES (392, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `academy_id` bigint(20) UNSIGNED NOT NULL COMMENT '学院id',
  `profession_id` bigint(20) UNSIGNED NOT NULL COMMENT '专业id',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级号',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_academy_id_number`(`academy_id`, `number`) USING BTREE,
  UNIQUE INDEX `uk_number`(`number`) USING BTREE,
  INDEX `idx_academy_id`(`academy_id`) USING BTREE,
  INDEX `idx_profession_id`(`profession_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES (2, 2, 1, '软件187', '2019-04-06 19:12:04.000000', '2019-04-06 19:12:04.000000');
INSERT INTO `tb_class` VALUES (3, 2, 4, '信18(4)数媒D', '2019-04-06 17:00:59.000000', '2019-04-06 17:00:59.000000');
INSERT INTO `tb_class` VALUES (4, 2, 4, '信18（9）数媒D', '2019-04-06 19:28:11.000000', '2019-04-06 19:28:11.000000');
INSERT INTO `tb_class` VALUES (5, 2, 5, '物联网186', '2019-04-06 19:12:04.000000', '2019-04-06 19:12:04.000000');
INSERT INTO `tb_class` VALUES (6, 2, 5, '物联网189', '2019-10-29 22:31:15.000000', '2019-10-29 22:31:18.000000');
INSERT INTO `tb_class` VALUES (100, 1, 1, '汉语言文学181', '2019-10-30 13:42:42.000000', '2019-10-30 13:42:42.000000');
INSERT INTO `tb_class` VALUES (101, 1, 8, '数师185', '2019-04-06 19:12:03.000000', '2019-04-06 19:12:03.000000');
INSERT INTO `tb_class` VALUES (102, 1, 7, '小教181', '2019-03-05 21:23:51.000000', '2019-03-05 21:24:55.000000');
INSERT INTO `tb_class` VALUES (103, 1, 3, '文183', '2019-03-05 21:23:51.000000', '2019-04-04 19:57:20.000000');
INSERT INTO `tb_class` VALUES (104, 1, 1, '软件175', '2019-10-31 17:03:04.000000', '2019-10-31 17:03:04.000000');

-- ----------------------------
-- Table structure for tb_class_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_class_score`;
CREATE TABLE `tb_class_score`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课程id',
  `score` double(8, 3) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '课程评分',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_class_score`(`user_id`, `lesson_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 303 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生上课评分，算法写入' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_class_score
-- ----------------------------
INSERT INTO `tb_class_score` VALUES (2, NULL, NULL, 0078.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (3, NULL, NULL, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (65, NULL, NULL, 0078.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (66, NULL, NULL, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (67, 6, 2, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (68, 7, 2, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (69, 8, 2, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (70, 9, 2, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (71, 10, 2, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (72, NULL, NULL, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (73, NULL, NULL, 0092.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (74, NULL, NULL, 0097.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (75, NULL, NULL, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (76, NULL, NULL, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (77, 16, 4, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (78, 17, 4, 0073.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (79, 18, 7, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (80, 19, 8, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (81, 20, 9, 0056.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (82, 21, 10, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (83, 22, 11, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (84, NULL, NULL, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (85, 24, 2, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (87, 25, 9, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (88, 26, 2, 0085.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (89, 27, 4, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (90, 28, 5, 0065.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (91, NULL, NULL, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (92, 16, 2, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (93, 23, 6, 0065.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (94, 6, 23, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (95, 10, 23, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (96, 9, 23, 0066.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (97, 8, 23, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (98, 7, 23, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (99, NULL, NULL, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (100, NULL, NULL, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (101, NULL, NULL, 0059.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (102, NULL, NULL, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (103, NULL, NULL, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (104, NULL, NULL, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (105, NULL, NULL, 0088.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (106, NULL, NULL, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (107, NULL, NULL, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (108, NULL, NULL, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (109, NULL, NULL, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (110, NULL, NULL, 0064.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (111, NULL, NULL, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (112, NULL, NULL, 0066.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (113, NULL, NULL, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (114, NULL, NULL, 0088.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (115, NULL, NULL, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (117, 17, 2, 0061.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (118, 18, 2, 0068.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (119, 19, 2, 0069.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (120, 20, 2, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (121, 21, 2, 0073.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (122, 22, 2, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (123, 28, 23, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (124, 1, 36, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (125, 2, 36, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (126, 3, 36, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (127, 4, 36, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (128, 5, 36, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (129, 1, 5, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (130, 2, 5, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (131, 3, 5, 0092.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (132, 4, 5, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (133, 5, 5, 0093.000, '2019-10-31 15:54:27.000000', '2019-10-31 15:55:02.000000');
INSERT INTO `tb_class_score` VALUES (134, 1, 35, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (135, 2, 8, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (136, 3, 8, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (137, 4, 8, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (138, 5, 8, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (139, 6, 35, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (140, 7, 35, 0068.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (141, 8, 35, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (142, 9, 35, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (143, 10, 35, 0093.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (144, NULL, NULL, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (145, NULL, NULL, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (146, NULL, NULL, 0060.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (147, NULL, NULL, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (148, NULL, NULL, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (149, NULL, NULL, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (151, NULL, NULL, 0065.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (152, NULL, NULL, 0066.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (153, NULL, NULL, 0092.000, '2019-10-31 17:03:04.000000', '2019-10-31 23:23:43.000000');
INSERT INTO `tb_class_score` VALUES (154, 11, 37, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (155, 12, 37, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (156, 13, 37, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (157, 14, 37, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (158, 15, 37, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (159, 1, 23, 0068.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (160, 1, 25, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (161, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (162, NULL, NULL, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (163, NULL, NULL, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (164, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (165, 1, 8, 0074.000, NULL, '2019-10-31 23:23:43.000000');
INSERT INTO `tb_class_score` VALUES (166, NULL, NULL, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (167, NULL, NULL, 0093.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (168, NULL, NULL, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (169, NULL, NULL, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (170, NULL, NULL, 0060.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (171, NULL, NULL, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (172, NULL, NULL, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (173, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (174, 1, 241, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (175, 2, 241, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (176, 3, 241, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (177, 4, 241, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (178, 5, 241, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (179, 1, 249, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (180, 2, 259, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (181, 3, 249, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (182, 4, 249, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (183, 5, 249, 0000.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (184, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (185, 1, 253, 0000.000, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_class_score` VALUES (186, 2, 253, 0000.000, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_class_score` VALUES (187, 3, 253, 0000.000, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_class_score` VALUES (188, 4, 253, 0000.000, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_class_score` VALUES (189, 5, 253, 0000.000, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_class_score` VALUES (190, NULL, NULL, 0058.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (191, NULL, NULL, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (192, NULL, NULL, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (193, 1, 254, 0000.000, '2019-11-02 14:16:47.000000', '2019-11-02 14:16:47.000000');
INSERT INTO `tb_class_score` VALUES (194, 16, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (195, 17, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (196, 18, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (197, 19, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (198, 20, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (199, 21, 257, 0000.000, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_class_score` VALUES (200, 16, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (201, 17, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (202, 18, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (203, 19, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (204, 20, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (205, 21, 261, 0000.000, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_class_score` VALUES (211, 11, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (212, 12, 33, 0056.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (213, 13, 33, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (214, 14, 33, 0086.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (215, 15, 33, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (216, 16, 33, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (217, 17, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (218, 18, 33, 0085.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (219, 19, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (220, 20, 33, 0065.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (221, 21, 33, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (222, 22, 33, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (223, 23, 33, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (224, 24, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (225, 25, 33, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (226, 26, 33, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (227, 27, 33, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (228, 28, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (229, 29, 33, 0089.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (230, 1, 33, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (231, 2, 33, 0059.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (232, 3, 33, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (233, 4, 33, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (234, 5, 33, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (235, 6, 33, 0088.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (236, 7, 33, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (237, 8, 33, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (238, 9, 33, 0061.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (239, 10, 33, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (240, 11, 1, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (241, 12, 1, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (242, 13, 1, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (243, 14, 1, 0085.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (244, 15, 1, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (245, 16, 1, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (246, 17, 1, 0077.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (247, 18, 1, 0088.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (248, 19, 1, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (249, 20, 1, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (250, 21, 1, 0068.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (251, 22, 1, 0069.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (252, 23, 1, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (253, 24, 1, 0073.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (254, 25, 1, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (255, 26, 1, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (256, 27, 1, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (257, 28, 1, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (258, 29, 1, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (259, 1, 1, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (260, 2, 1, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (261, 3, 1, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (262, 4, 1, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (263, 5, 1, 0092.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (264, 6, 1, 0091.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (265, 7, 1, 0093.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (266, 8, 1, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (267, 9, 1, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (268, 10, 1, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (269, 11, 34, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (270, 12, 34, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (271, 13, 34, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (272, 14, 34, 0071.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (273, 15, 34, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (274, 16, 34, 0092.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (275, 17, 34, 0061.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (276, 18, 34, 0093.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (277, 19, 34, 0076.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (278, 16, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (279, 17, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (280, 18, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (281, 19, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (282, 20, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (283, 21, 262, 0000.000, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_class_score` VALUES (284, 20, 34, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (285, 21, 34, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (286, 22, 34, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (287, 23, 34, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (288, 24, 34, 0067.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (289, 25, 34, 0068.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (290, 26, 34, 0082.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (291, 27, 34, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (292, 28, 34, 0070.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (293, 29, 34, 0075.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (294, 1, 34, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (295, 2, 34, 0085.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (296, 3, 34, 0087.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (297, 4, 34, 0084.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (298, 5, 34, 0074.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (299, 6, 34, 0073.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (300, 7, 34, 0083.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (301, 8, 34, 0092.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (302, 9, 34, 0081.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (303, 10, 34, 0072.000, NULL, NULL);
INSERT INTO `tb_class_score` VALUES (304, 134, 9, 0001.000, '2019-11-17 17:18:11.000000', '2019-11-17 17:18:11.000000');

-- ----------------------------
-- Table structure for tb_classroom
-- ----------------------------
DROP TABLE IF EXISTS `tb_classroom`;
CREATE TABLE `tb_classroom`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教室id',
  `building_floor_id` bigint(20) UNSIGNED NOT NULL COMMENT '楼层号id',
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼层号',
  `equipment_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备id',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_number`(`number`) USING BTREE,
  UNIQUE INDEX `uk_equipment_id`(`equipment_id`) USING BTREE,
  INDEX `idx_building_floor_id`(`building_floor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_classroom
-- ----------------------------
INSERT INTO `tb_classroom` VALUES (1, 1, '主A111', '[666,2]', '2019-02-12 23:28:27.000000', '2019-07-08 19:47:01.000000');
INSERT INTO `tb_classroom` VALUES (2, 2, '主B201', '[1,2]', '2019-02-12 23:39:42.000000', '2019-02-12 23:39:42.000000');
INSERT INTO `tb_classroom` VALUES (3, 3, '主A301', '[3,4]', '2019-02-12 23:28:27.000000', '2019-04-04 19:50:16.000000');
INSERT INTO `tb_classroom` VALUES (4, 12, '423', '[5,6]', '2019-02-12 23:28:27.000000', '2019-04-04 21:52:12.000000');
INSERT INTO `tb_classroom` VALUES (5, 4, '4102', '[7,8]', '2019-02-12 23:28:27.000000', '2019-04-04 21:50:41.000000');
INSERT INTO `tb_classroom` VALUES (6, 8, '5202', '[9,10]', '2019-02-12 23:28:27.000000', '2019-04-04 19:58:22.000000');
INSERT INTO `tb_classroom` VALUES (7, 5, '7106', '[11,12]', '2019-02-12 23:28:27.000000', '2019-02-12 23:33:00.000000');
INSERT INTO `tb_classroom` VALUES (8, 1, '主A102', '[13,14]', '2019-02-12 23:28:27.000000', '2019-02-12 23:33:00.000000');
INSERT INTO `tb_classroom` VALUES (9, 12, '6201', '[15,16]', '2019-02-12 23:28:27.000000', '2019-03-08 17:29:59.000000');
INSERT INTO `tb_classroom` VALUES (10, 1, '主A103', '[17,18]', '2019-02-12 23:28:27.000000', '2019-02-14 15:13:25.000000');

-- ----------------------------
-- Table structure for tb_classroom_state
-- ----------------------------
DROP TABLE IF EXISTS `tb_classroom_state`;
CREATE TABLE `tb_classroom_state`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `classroom_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '教室id',
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课时id',
  `state` int(11) NULL DEFAULT NULL COMMENT '占用状态',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 254 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教室占用情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_classroom_state
-- ----------------------------
INSERT INTO `tb_classroom_state` VALUES (3, 2, 3, 1, '2019-03-27 21:17:24.000000', '2019-03-27 21:17:24.000000');
INSERT INTO `tb_classroom_state` VALUES (4, 3, 4, 1, '2019-03-29 14:52:34.000000', '2019-03-29 14:52:34.000000');
INSERT INTO `tb_classroom_state` VALUES (5, 4, 5, 1, '2019-03-29 14:55:35.000000', '2019-03-29 14:55:35.000000');
INSERT INTO `tb_classroom_state` VALUES (6, 5, 6, 1, '2019-03-29 14:57:12.000000', '2019-03-29 14:57:12.000000');
INSERT INTO `tb_classroom_state` VALUES (7, 6, 7, 1, '2019-03-29 15:00:59.000000', '2019-03-29 15:00:59.000000');
INSERT INTO `tb_classroom_state` VALUES (8, 7, 8, 1, '2019-03-29 20:00:27.000000', '2019-03-29 20:00:27.000000');
INSERT INTO `tb_classroom_state` VALUES (9, 8, 9, 1, '2019-03-29 20:00:28.000000', '2019-03-29 20:00:28.000000');
INSERT INTO `tb_classroom_state` VALUES (10, 9, 10, 1, '2019-03-29 23:11:19.000000', '2019-03-29 23:11:19.000000');
INSERT INTO `tb_classroom_state` VALUES (11, 10, 11, 1, '2019-04-03 12:29:46.000000', '2019-04-03 12:29:46.000000');
INSERT INTO `tb_classroom_state` VALUES (12, 1, 12, 1, '2019-04-05 13:21:23.000000', '2019-04-05 13:21:23.000000');
INSERT INTO `tb_classroom_state` VALUES (13, 2, 13, 1, '2019-04-05 13:23:05.000000', '2019-04-05 13:23:05.000000');
INSERT INTO `tb_classroom_state` VALUES (14, 3, 14, 1, '2019-04-05 13:28:59.000000', '2019-04-05 13:28:59.000000');
INSERT INTO `tb_classroom_state` VALUES (15, 4, 15, 1, '2019-04-05 13:43:04.000000', '2019-04-05 13:43:04.000000');
INSERT INTO `tb_classroom_state` VALUES (16, 5, 16, 1, '2019-04-05 15:49:37.000000', '2019-04-05 15:49:37.000000');
INSERT INTO `tb_classroom_state` VALUES (17, 6, 17, 1, '2019-04-05 16:08:37.000000', '2019-04-05 16:08:37.000000');
INSERT INTO `tb_classroom_state` VALUES (18, 7, 18, 1, '2019-04-05 16:11:55.000000', '2019-04-05 16:11:55.000000');
INSERT INTO `tb_classroom_state` VALUES (19, 8, 19, 1, '2019-04-05 16:24:54.000000', '2019-04-05 16:24:54.000000');
INSERT INTO `tb_classroom_state` VALUES (20, 9, 20, 1, '2019-04-05 16:37:50.000000', '2019-04-05 16:37:50.000000');
INSERT INTO `tb_classroom_state` VALUES (21, 10, 21, 1, '2019-04-05 16:39:54.000000', '2019-04-05 16:39:54.000000');
INSERT INTO `tb_classroom_state` VALUES (22, 1, 22, 1, '2019-04-05 16:49:43.000000', '2019-04-05 16:49:43.000000');
INSERT INTO `tb_classroom_state` VALUES (23, 2, 23, 1, '2019-04-05 16:57:40.000000', '2019-04-05 16:57:40.000000');
INSERT INTO `tb_classroom_state` VALUES (25, 3, 25, 1, '2019-04-05 17:05:57.000000', '2019-04-05 17:05:57.000000');
INSERT INTO `tb_classroom_state` VALUES (33, 4, 33, 1, '2019-04-05 17:11:04.000000', '2019-04-05 17:11:04.000000');
INSERT INTO `tb_classroom_state` VALUES (34, 5, 34, 1, '2019-04-05 17:14:09.000000', '2019-04-05 17:14:09.000000');
INSERT INTO `tb_classroom_state` VALUES (35, 6, 35, 1, '2019-04-05 17:25:42.000000', '2019-04-05 17:25:42.000000');
INSERT INTO `tb_classroom_state` VALUES (36, 7, 36, 1, '2019-04-05 17:26:15.000000', '2019-04-05 17:26:15.000000');
INSERT INTO `tb_classroom_state` VALUES (37, 8, 37, 1, '2019-04-05 17:26:59.000000', '2019-04-05 17:26:59.000000');
INSERT INTO `tb_classroom_state` VALUES (58, 10, NULL, 1, '2019-04-05 18:05:44.000000', '2019-04-05 18:05:44.000000');
INSERT INTO `tb_classroom_state` VALUES (59, NULL, NULL, 1, '2019-04-05 18:06:21.000000', '2019-04-05 18:06:21.000000');
INSERT INTO `tb_classroom_state` VALUES (60, NULL, NULL, 1, '2019-04-05 18:07:45.000000', '2019-04-05 18:07:45.000000');
INSERT INTO `tb_classroom_state` VALUES (61, NULL, NULL, 1, '2019-04-07 15:22:06.000000', '2019-04-07 15:22:06.000000');
INSERT INTO `tb_classroom_state` VALUES (62, NULL, NULL, 1, '2019-04-07 15:56:52.000000', '2019-04-07 15:56:52.000000');
INSERT INTO `tb_classroom_state` VALUES (63, NULL, NULL, 1, '2019-04-07 17:16:20.000000', '2019-04-07 17:16:20.000000');
INSERT INTO `tb_classroom_state` VALUES (64, NULL, NULL, 1, '2019-04-09 17:45:43.000000', '2019-04-09 17:45:43.000000');
INSERT INTO `tb_classroom_state` VALUES (65, NULL, NULL, 1, '2019-04-09 17:46:08.000000', '2019-04-09 17:46:08.000000');
INSERT INTO `tb_classroom_state` VALUES (66, NULL, NULL, 1, '2019-04-09 17:46:39.000000', '2019-04-09 17:46:39.000000');
INSERT INTO `tb_classroom_state` VALUES (67, NULL, NULL, 1, '2019-04-09 17:51:13.000000', '2019-04-09 17:51:13.000000');
INSERT INTO `tb_classroom_state` VALUES (68, NULL, NULL, 1, '2019-04-09 17:51:45.000000', '2019-04-09 17:51:45.000000');
INSERT INTO `tb_classroom_state` VALUES (69, NULL, NULL, 1, '2019-04-09 17:52:14.000000', '2019-04-09 17:52:14.000000');
INSERT INTO `tb_classroom_state` VALUES (70, NULL, NULL, 1, '2019-04-09 17:52:42.000000', '2019-04-09 17:52:42.000000');
INSERT INTO `tb_classroom_state` VALUES (71, NULL, NULL, 1, '2019-04-09 17:53:09.000000', '2019-04-09 17:53:09.000000');
INSERT INTO `tb_classroom_state` VALUES (72, NULL, NULL, 1, '2019-04-09 19:47:02.000000', '2019-04-09 19:47:02.000000');
INSERT INTO `tb_classroom_state` VALUES (73, NULL, NULL, 1, '2019-04-10 00:05:42.000000', '2019-04-10 00:05:42.000000');
INSERT INTO `tb_classroom_state` VALUES (74, NULL, NULL, 1, '2019-04-10 12:08:15.000000', '2019-04-10 12:08:15.000000');
INSERT INTO `tb_classroom_state` VALUES (75, NULL, NULL, 1, '2019-04-11 20:56:34.000000', '2019-04-11 20:56:34.000000');
INSERT INTO `tb_classroom_state` VALUES (76, NULL, NULL, 1, '2019-04-11 20:57:52.000000', '2019-04-11 20:57:52.000000');
INSERT INTO `tb_classroom_state` VALUES (77, NULL, NULL, 1, '2019-04-11 21:08:58.000000', '2019-04-11 21:08:58.000000');
INSERT INTO `tb_classroom_state` VALUES (78, NULL, NULL, 1, '2019-04-12 23:39:39.000000', '2019-04-12 23:39:39.000000');
INSERT INTO `tb_classroom_state` VALUES (79, NULL, NULL, 1, '2019-05-11 10:21:13.000000', '2019-05-11 10:21:13.000000');
INSERT INTO `tb_classroom_state` VALUES (80, NULL, NULL, 1, '2019-05-11 10:53:00.000000', '2019-05-11 10:53:00.000000');
INSERT INTO `tb_classroom_state` VALUES (81, NULL, NULL, 1, '2019-05-14 19:58:13.000000', '2019-05-14 19:58:13.000000');
INSERT INTO `tb_classroom_state` VALUES (82, NULL, NULL, 1, '2019-05-15 19:42:18.000000', '2019-05-15 19:42:18.000000');
INSERT INTO `tb_classroom_state` VALUES (83, NULL, NULL, 1, '2019-05-26 13:29:33.000000', '2019-05-26 13:29:33.000000');
INSERT INTO `tb_classroom_state` VALUES (84, NULL, NULL, 1, '2019-08-05 22:06:52.000000', '2019-08-05 22:06:52.000000');
INSERT INTO `tb_classroom_state` VALUES (85, NULL, NULL, 1, '2019-10-16 14:37:55.000000', '2019-10-16 14:37:55.000000');
INSERT INTO `tb_classroom_state` VALUES (86, NULL, NULL, 0, '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');
INSERT INTO `tb_classroom_state` VALUES (87, NULL, NULL, 1, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_classroom_state` VALUES (89, NULL, NULL, 1, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_classroom_state` VALUES (90, NULL, NULL, 1, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_classroom_state` VALUES (91, NULL, NULL, 1, '2019-11-01 12:47:18.000000', '2019-11-01 12:47:18.000000');
INSERT INTO `tb_classroom_state` VALUES (92, NULL, NULL, 1, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_classroom_state` VALUES (93, NULL, NULL, 1, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_classroom_state` VALUES (94, NULL, NULL, 1, '2019-11-02 14:16:47.000000', '2019-11-02 14:16:47.000000');
INSERT INTO `tb_classroom_state` VALUES (95, NULL, NULL, 1, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_classroom_state` VALUES (96, NULL, NULL, 1, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_classroom_state` VALUES (253, 9, 253, 1, '2019-04-05 17:35:02.000000', '2019-04-05 17:35:02.000000');
INSERT INTO `tb_classroom_state` VALUES (254, 3, 262, 1, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_classroom_state` VALUES (256, 1, 1, 0, '2019-11-17 17:22:10.000000', '2019-11-17 17:22:10.000000');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `lesson_sum` int(11) NULL DEFAULT NULL COMMENT '课时(第几课时)',
  `year` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课学年',
  `term` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '开课学期',
  `profession_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '开课专业',
  `class_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课班级',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_number`(`number`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, '20086401', 'C语言', 64, '2017-2018学年', 0, 1, '[2,3,4,5]', '2019-02-15 15:34:23.000000', '2019-04-04 21:33:15.000000');
INSERT INTO `tb_course` VALUES (2, '20086402', '人文教育', 64, '2018-2019学年', 0, 1, '[1,2,3,4,5]', '2019-02-15 15:34:23.000000', '2019-10-30 15:27:34.000000');
INSERT INTO `tb_course` VALUES (4, '20086404', '高等数学B1', 64, '2019-2020学年', 1, 2, '[1,2,3,4,5]', '2019-02-15 15:34:23.000000', '2019-11-02 14:28:50.000000');
INSERT INTO `tb_course` VALUES (5, '20086405', '算法设计', 64, '2017-2018学年', 1, 1, '[1,2,3,4,5]', '2019-02-15 15:34:23.000000', '2019-02-15 15:34:23.000000');
INSERT INTO `tb_course` VALUES (6, '20086406', 'JAVA高级程序设计', 64, '2018-2019学年', 0, 1, '[1,2,3,4,5]', '2019-02-15 15:34:23.000000', '2019-02-23 21:05:41.000000');
INSERT INTO `tb_course` VALUES (7, '20086411', '计算机网络', 64, '2019-2020学年', 1, 2, '[1]', '2019-02-27 20:13:03.000000', '2019-02-27 20:13:03.000000');
INSERT INTO `tb_course` VALUES (8, '20086407', '操作系统', 64, '2017-2018学年', 0, 1, '[1,2,3,4,5]', '2019-03-05 22:38:47.000000', '2019-03-18 22:54:23.000000');
INSERT INTO `tb_course` VALUES (9, '20086408', '离散数学', 64, '2018-2019学年', 1, 1, '[1,2,3,4,5]', '2019-03-05 23:25:49.000000', '2019-10-30 15:41:30.000000');
INSERT INTO `tb_course` VALUES (10, '20086409', '马克思主义思想', 64, '2019-2020学年', 1, 2, '[1,2,3,4,5]', '2019-03-05 23:25:49.000000', '2019-03-05 23:25:49.000000');
INSERT INTO `tb_course` VALUES (11, '20086410', '大学英语', 64, '2018-2019学年', 1, 2, '[1,2,3,4]', '2019-03-05 23:25:49.000000', '2019-03-05 23:25:49.000000');
INSERT INTO `tb_course` VALUES (12, '20086510', '计算机导论', 64, '2018-2019学年', 1, 2, '[1,2,3,4]', '2019-03-05 23:25:49.000000', '2019-03-05 23:25:49.000000');

-- ----------------------------
-- Table structure for tb_equipment
-- ----------------------------
DROP TABLE IF EXISTS `tb_equipment`;
CREATE TABLE `tb_equipment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频播放地址',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_number`(`number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_equipment
-- ----------------------------
INSERT INTO `tb_equipment` VALUES (1, '111', 'sadas', 'http://123.206.53.234/yctc/%E7%90%83%E6%9C%BA%E7%AE%A1%E7%90%86.mp4', '2019-03-08 11:14:00.000000', '2019-03-08 11:14:00.000000');
INSERT INTO `tb_equipment` VALUES (2, '112', 'sadassad', 'http://123.206.53.234/yctc/test1.mp4', '2019-03-08 11:14:00.000000', '2019-03-08 11:14:00.000000');
INSERT INTO `tb_equipment` VALUES (6, '123', '123', '123', '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');

-- ----------------------------
-- Table structure for tb_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge`;
CREATE TABLE `tb_knowledge`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '知识点描述',
  `length` double(20, 1) UNSIGNED NULL DEFAULT NULL COMMENT '预计时长',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_content`(`content`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 381 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledge
-- ----------------------------
INSERT INTO `tb_knowledge` VALUES (2, '数据结构语句', 7.0, '2019-05-25 22:46:50.000000', '2019-10-30 22:32:51.000000');
INSERT INTO `tb_knowledge` VALUES (3, '循环控制', 5.0, '2019-05-25 22:46:50.000000', '2019-10-30 22:33:02.000000');
INSERT INTO `tb_knowledge` VALUES (4, '一维数组', 7.5, '2019-07-06 16:50:13.000000', '2019-10-30 22:33:10.000000');
INSERT INTO `tb_knowledge` VALUES (5, '二维数组', 5.0, '2019-10-30 13:42:43.000000', '2019-10-30 22:33:22.000000');
INSERT INTO `tb_knowledge` VALUES (6, '字符数组与字符串', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (7, '关系运算符', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (8, '逻辑运算符', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (9, 'if语句', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (10, 'for语句', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (11, 'while语句', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (12, 'do-while语句', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (13, 'break语句', 2.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (14, 'switch....case语句', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (331, '曲面方程与空间曲线方程的概念', 8.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (332, '平面的点法式方程', 8.5, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (333, '平面的一般方程', 5.5, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (334, '平面的夹角', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (335, '空间直线的一般方程', 6.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (336, '空间直角坐标系', 6.5, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (342, '向量及其线性运算', 7.5, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (343, '数量积', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (344, '向量积', 5.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (345, '混合积', 6.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (356, '知识点1', 5.0, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge` VALUES (357, '计算机网络在信息时代中的作用', 12.0, '2019-11-01 12:50:01.000000', '2019-11-01 12:50:01.000000');
INSERT INTO `tb_knowledge` VALUES (358, '网络的网络', 2.0, '2019-11-01 12:50:19.000000', '2019-11-01 12:50:19.000000');
INSERT INTO `tb_knowledge` VALUES (359, '互联网基础结构发展的三个阶段', 3.0, '2019-11-01 12:50:40.000000', '2019-11-01 12:50:40.000000');
INSERT INTO `tb_knowledge` VALUES (360, '亲子关系及其对儿童品德发展的影响', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (361, '恒河猴实验\r\n', 5.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (362, '亲子关系有利于儿童品德的发展', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (363, '家庭', 2.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (364, '亲子关系的相关因素对小学生品德发展的影响', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (365, '父母教养方式对儿童问题行为的影响', 7.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (366, '亲子关系影响小学生品德养成的机制', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (367, '家长在家中也可以运用替代性强化的原理', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (368, '认同作用', 5.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (369, '借助亲子教育促进儿童品德发展', 3.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (370, '亲职教育内容主要有五个方面', 5.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (371, '学校亲情教育', 4.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (372, '适合儿童品德发展的家校合作方法', 5.0, NULL, NULL);
INSERT INTO `tb_knowledge` VALUES (373, '互联网基础结构发展的三个阶段', 5.0, '2019-11-02 14:14:53.000000', '2019-11-02 14:14:53.000000');
INSERT INTO `tb_knowledge` VALUES (374, '曲面方程与空间曲线方程的概念', 8.0, '2019-11-03 14:35:29.000000', '2019-11-03 14:35:29.000000');
INSERT INTO `tb_knowledge` VALUES (375, '曲面方程与空间曲线方程的概念', 5.0, '2019-11-03 16:48:04.000000', '2019-11-03 16:48:04.000000');
INSERT INTO `tb_knowledge` VALUES (378, '平面的点法式方程', 8.5, '2019-11-03 16:54:00.000000', '2019-11-03 16:54:00.000000');
INSERT INTO `tb_knowledge` VALUES (379, '计算机网络在信息时代中的作用', 12.0, '2019-11-03 19:09:57.000000', '2019-11-03 19:09:57.000000');
INSERT INTO `tb_knowledge` VALUES (381, '知识点1', 5.0, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_knowledge` VALUES (382, '知识点1', 5.0, '2019-11-17 17:22:10.000000', '2019-11-17 17:22:10.000000');
INSERT INTO `tb_knowledge` VALUES (383, '知识点1', 5.0, '2019-11-17 18:46:02.000000', '2019-11-17 18:46:02.000000');
INSERT INTO `tb_knowledge` VALUES (384, '知识点1', 5.0, '2019-11-17 18:46:49.000000', '2019-11-17 18:46:49.000000');
INSERT INTO `tb_knowledge` VALUES (385, '知识点1', 5.0, '2019-11-17 18:47:55.000000', '2019-11-17 18:47:55.000000');
INSERT INTO `tb_knowledge` VALUES (386, '知识点1', 5.0, '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_knowledge` VALUES (387, '知识点1', 5.0, '2019-11-17 18:49:07.000000', '2019-11-17 18:49:07.000000');

-- ----------------------------
-- Table structure for tb_knowledge_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge_lesson`;
CREATE TABLE `tb_knowledge_lesson`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课程id',
  `knowledge_id` bigint(20) NULL DEFAULT NULL COMMENT '知识点id',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_lesson_knowledge`(`lesson_id`, `knowledge_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledge_lesson
-- ----------------------------
INSERT INTO `tb_knowledge_lesson` VALUES (2, 33, 360, '2019-05-25 15:44:00.000000', '2019-05-25 15:46:16.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (3, 33, 361, '2019-05-25 15:44:00.000000', '2019-05-25 15:46:16.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (4, 33, 362, '2019-05-25 15:44:00.000000', '2019-05-25 15:46:16.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (5, 33, 363, '2019-07-06 16:50:14.000000', '2019-07-06 16:50:14.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (6, 33, 364, '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (7, 33, 365, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (8, 33, 366, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (9, 33, 367, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (10, 33, 368, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (11, 33, 369, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (12, 33, 370, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (13, 33, 371, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (14, 33, 372, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (24, 34, 336, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (25, 1, 3, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (26, 1, 4, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (27, 1, 5, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (28, 1, 6, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (29, 34, 342, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (30, 34, 343, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (31, 34, 344, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (32, 34, 345, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (33, 34, 346, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (34, 34, 331, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (35, 34, 332, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (36, 34, 333, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (37, 34, 334, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (38, 34, 335, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (76, 1, 2, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (77, 34, 357, '2019-11-01 12:50:01.000000', '2019-11-01 12:50:01.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (78, 34, 358, '2019-11-01 12:50:19.000000', '2019-11-01 12:50:19.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (79, 34, 359, '2019-11-01 12:50:40.000000', '2019-11-01 12:50:40.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (80, 1, 7, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (81, 1, 8, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (82, 1, 9, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (83, 1, 10, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (84, 1, 11, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (85, 1, 12, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (86, 1, 13, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (87, 1, 14, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (88, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (89, 253, 373, '2019-11-02 14:14:53.000000', '2019-11-02 14:14:53.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (90, 257, 331, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (91, 257, 332, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (92, 257, 333, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (93, 257, 334, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (94, 257, 335, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (95, 257, 336, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (96, 257, 342, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (97, 257, 343, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (98, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (99, 261, 373, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (100, 261, 374, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (102, 261, 375, '2019-11-03 16:48:04.000000', '2019-11-03 16:48:04.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (105, 261, 378, '2019-11-03 16:54:00.000000', '2019-11-03 16:54:00.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (106, 253, 379, '2019-11-03 19:09:57.000000', '2019-11-03 19:09:57.000000');
INSERT INTO `tb_knowledge_lesson` VALUES (112, 253, 357, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (113, 253, 358, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (114, 253, 359, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (115, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (116, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (117, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (118, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (119, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_lesson` VALUES (120, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tb_knowledge_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge_picture`;
CREATE TABLE `tb_knowledge_picture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '识别到的照片',
  `knowledgeid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 749 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledge_picture
-- ----------------------------
INSERT INTO `tb_knowledge_picture` VALUES (1, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (2, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (3, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (4, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (5, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (6, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (7, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (8, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (9, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (10, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (11, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (12, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (13, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (14, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (15, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (332, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (333, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (334, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (335, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (336, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (337, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (338, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (339, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (340, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (341, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (342, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (343, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (344, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (345, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (346, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (347, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (348, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (349, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (350, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (351, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (352, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (353, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (354, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (355, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (356, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (357, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (358, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (359, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (360, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (361, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (362, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (363, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (364, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (365, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (366, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (367, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (368, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (369, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (370, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (371, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (372, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (373, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (374, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (375, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (376, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (377, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (378, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (379, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (380, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (381, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (382, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (383, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (384, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (385, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (386, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (387, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (388, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (389, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (390, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (391, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (392, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (393, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (394, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (395, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (396, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (397, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (398, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (399, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (400, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (401, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (402, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (403, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (404, NULL, NULL);
INSERT INTO `tb_knowledge_picture` VALUES (587, 'src/img/001.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (588, 'src/img/002.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (589, 'src/img/003.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (590, 'src/img/004.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (591, 'src/img/005.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (592, 'src/img/006.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (593, 'src/img/007.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (594, 'src/img/008.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (595, 'src/img/009.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (596, 'src/img/010.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (597, 'src/img/011.jpg', 360);
INSERT INTO `tb_knowledge_picture` VALUES (598, 'src/img/012.jpg', 361);
INSERT INTO `tb_knowledge_picture` VALUES (599, 'src/img/013.jpg', 361);
INSERT INTO `tb_knowledge_picture` VALUES (600, 'src/img/014.jpg', 362);
INSERT INTO `tb_knowledge_picture` VALUES (601, 'src/img/015.jpg', 362);
INSERT INTO `tb_knowledge_picture` VALUES (602, 'src/img/016.jpg', 362);
INSERT INTO `tb_knowledge_picture` VALUES (603, 'src/img/017.jpg', 364);
INSERT INTO `tb_knowledge_picture` VALUES (604, 'src/img/018.jpg', 363);
INSERT INTO `tb_knowledge_picture` VALUES (605, 'src/img/019.jpg', 363);
INSERT INTO `tb_knowledge_picture` VALUES (606, 'src/img/020.jpg', 363);
INSERT INTO `tb_knowledge_picture` VALUES (607, 'src/img/021.jpg', 363);
INSERT INTO `tb_knowledge_picture` VALUES (608, 'src/img/022.jpg', 365);
INSERT INTO `tb_knowledge_picture` VALUES (609, 'src/img/023.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (610, 'src/img/024.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (611, 'src/img/025.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (612, 'src/img/026.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (613, 'src/img/027.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (614, 'src/img/028.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (615, 'src/img/029.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (616, 'src/img/030.jpg', 366);
INSERT INTO `tb_knowledge_picture` VALUES (617, 'src/img/031.jpg', 367);
INSERT INTO `tb_knowledge_picture` VALUES (618, 'src/img/032.jpg', 367);
INSERT INTO `tb_knowledge_picture` VALUES (619, 'src/img/033.jpg', 368);
INSERT INTO `tb_knowledge_picture` VALUES (620, 'src/img/034.jpg', 368);
INSERT INTO `tb_knowledge_picture` VALUES (621, 'src/img/035.jpg', 368);
INSERT INTO `tb_knowledge_picture` VALUES (622, 'src/img/036.jpg', 368);
INSERT INTO `tb_knowledge_picture` VALUES (623, 'src/img/037.jpg', 369);
INSERT INTO `tb_knowledge_picture` VALUES (624, 'src/img/038.jpg', 369);
INSERT INTO `tb_knowledge_picture` VALUES (625, 'src/img/039.jpg', 369);
INSERT INTO `tb_knowledge_picture` VALUES (626, 'src/img/040.jpg', 370);
INSERT INTO `tb_knowledge_picture` VALUES (627, 'src/img/041.jpg', 370);
INSERT INTO `tb_knowledge_picture` VALUES (628, 'src/img/042.jpg', 370);
INSERT INTO `tb_knowledge_picture` VALUES (629, 'src/img/043.jpg', 370);
INSERT INTO `tb_knowledge_picture` VALUES (630, 'src/img/044.jpg', 371);
INSERT INTO `tb_knowledge_picture` VALUES (631, 'src/img/045.jpg', 372);
INSERT INTO `tb_knowledge_picture` VALUES (632, 'src/img/046.jpg', 372);
INSERT INTO `tb_knowledge_picture` VALUES (633, 'src/img/047.jpg', 372);
INSERT INTO `tb_knowledge_picture` VALUES (634, 'src/img/048.jpg', 372);
INSERT INTO `tb_knowledge_picture` VALUES (635, 'src/img/049.jpg', 372);
INSERT INTO `tb_knowledge_picture` VALUES (636, 'src/img/050.jpg', 371);
INSERT INTO `tb_knowledge_picture` VALUES (637, 'src/img/051.jpg', 371);
INSERT INTO `tb_knowledge_picture` VALUES (638, 'src/img/052.jpg', 371);
INSERT INTO `tb_knowledge_picture` VALUES (639, 'src/img/053.jpg', 371);
INSERT INTO `tb_knowledge_picture` VALUES (640, 'src/img/054.jpg', 371);

-- ----------------------------
-- Table structure for tb_knowledge_student_state
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge_student_state`;
CREATE TABLE `tb_knowledge_student_state`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课程id',
  `state` int(1) UNSIGNED NULL DEFAULT NULL COMMENT '状态',
  `scan_start_time` datetime(6) NULL DEFAULT NULL COMMENT '开始扫描时间',
  `scan_end_time` datetime(6) NULL DEFAULT NULL COMMENT '结束扫描时间',
  `knowledge_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '知识点id',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE,
  INDEX `idx_user_id_lesson_id`(`user_id`, `lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 471 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledge_student_state
-- ----------------------------
INSERT INTO `tb_knowledge_student_state` VALUES (2, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (3, 1, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (4, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (5, 4, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (6, 5, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 360, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (7, 6, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 331, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (8, 7, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 331, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (9, 8, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 331, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (10, 9, 34, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 331, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (11, 10, 34, 1, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (12, 11, 34, 1, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (13, 12, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (14, 13, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (15, 14, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (16, 15, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 332, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (17, 2, 241, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (18, 3, 241, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 358, '2019-07-08 15:44:40.000000', '2019-07-08 15:44:40.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (19, 4, 241, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 358, '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (20, 1, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (21, 1, 241, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (22, 2, 241, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (23, 3, 241, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (24, 4, 241, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (25, 5, 241, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (26, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (27, 3, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 2, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (28, 4, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (29, 5, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (30, 5, 241, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (31, 1, 241, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (32, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (33, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (34, 3, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (35, 4, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 361, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (36, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (37, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (38, 1, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (39, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (40, 4, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 362, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (41, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (42, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (43, 1, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (44, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (45, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 363, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (46, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (47, 2, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (48, 1, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (49, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (50, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 364, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (51, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (52, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (53, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (54, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (55, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 365, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (56, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (57, 6, 34, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 342, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (58, 7, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 342, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (59, 8, 34, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 342, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (60, 9, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 342, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (61, 10, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 342, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (62, 6, 34, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 343, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (63, 7, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 343, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (64, 8, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 343, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (65, 9, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 343, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (66, 10, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 343, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (67, 6, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 344, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (68, 7, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 344, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (69, 8, 34, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 344, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (70, 9, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 344, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (71, 10, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 344, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (72, 6, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 345, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (73, 7, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 345, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (74, 8, 34, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 345, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (75, 9, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 345, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (76, 10, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 345, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (77, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (78, 3, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 3, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (79, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (80, 5, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (81, 1, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (82, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 4, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (83, 3, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 4, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (84, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (85, 5, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (86, 1, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 4, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (87, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 5, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (88, 3, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 5, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (89, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 5, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (90, 5, 1, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 5, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (91, 1, 1, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 5, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (92, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 6, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (93, 3, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 6, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (94, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 6, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (95, 5, 1, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 6, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (96, 1, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 6, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (97, 2, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 7, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (98, 3, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 7, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (99, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 7, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (100, 5, 1, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 7, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (101, 1, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 7, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (102, 1, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 357, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (103, 2, 253, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (104, 3, 253, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 357, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (105, 4, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (106, 5, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 357, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (108, 1, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 358, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (109, 2, 253, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (110, 3, 253, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 358, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (111, 4, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (112, 5, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 358, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (113, 1, 253, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 359, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (114, 2, 253, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 359, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (115, 3, 253, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 359, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (116, 4, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 359, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (117, 5, 253, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 359, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (118, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (119, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (120, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (121, 14, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (122, 15, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 360, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (123, 16, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (124, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (125, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (126, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (127, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 360, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (128, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (129, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (130, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (131, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 360, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (132, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 360, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (133, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 360, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (134, 11, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (135, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (136, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (137, 14, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (138, 15, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 361, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (139, 16, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (140, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (141, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (142, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (143, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 361, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (144, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (145, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (146, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (147, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 361, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (148, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 361, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (149, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 361, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (150, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (151, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (152, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (153, 14, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (154, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 362, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (155, 16, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (156, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (157, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (158, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (159, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 362, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (160, 21, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (161, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (162, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (163, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 362, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (164, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 362, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (165, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 362, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (166, 11, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (167, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (168, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (169, 14, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (170, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 363, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (171, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (172, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (173, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (174, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (175, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 363, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (176, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (177, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (178, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (179, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 363, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (180, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 363, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (181, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 363, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (182, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (183, 12, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (184, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (185, 14, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (186, 15, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 364, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (187, 16, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (188, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (189, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (190, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (191, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 364, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (192, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (193, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (194, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (195, 27, 33, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 364, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (196, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 364, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (197, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 364, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (198, 11, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (199, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (200, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (201, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (202, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 365, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (203, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (204, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (205, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (206, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (207, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 365, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (208, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (209, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (210, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (211, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 365, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (212, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 365, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (213, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 365, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (214, 11, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (215, 12, 1, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (216, 13, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (217, 14, 1, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (218, 15, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (219, 16, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (220, 17, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (221, 18, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (222, 19, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (223, 20, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (224, 21, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (225, 22, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (226, 23, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (227, 27, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 2, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (228, 28, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (229, 29, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (230, 1, 1, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (231, 3, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (232, 4, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 3, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (233, 5, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (234, 2, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (235, 11, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (236, 12, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (237, 13, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (238, 14, 1, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (239, 15, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (240, 16, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (241, 17, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (242, 18, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (243, 19, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (244, 20, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (245, 21, 1, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (246, 22, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (247, 23, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (248, 27, 1, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 3, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (249, 28, 1, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (250, 29, 1, 3, '2019-07-08 15:44:38.000000', '2019-11-10 14:06:00.000000', 3, '2019-07-08 15:03:19.000000', '2019-11-10 14:06:07.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (251, 11, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (252, 12, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (253, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (254, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (255, 15, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 366, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (256, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (257, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (258, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (259, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (260, 20, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 366, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (261, 21, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (262, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (263, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (264, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (265, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 366, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (266, 29, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 366, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (267, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (268, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (269, 3, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (270, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 366, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (271, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 366, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (272, 11, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (273, 12, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (274, 13, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (275, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (276, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 367, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (277, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (278, 17, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (279, 18, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (280, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (281, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 367, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (282, 21, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (283, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (284, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (285, 27, 33, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (286, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 367, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (287, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 367, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (288, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (289, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (290, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (291, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 367, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (292, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 367, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (293, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (294, 12, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (295, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (296, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (297, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 368, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (298, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (299, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (300, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (301, 19, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (302, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 368, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (303, 21, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (304, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (305, 23, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (306, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (307, 28, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 368, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (308, 29, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 368, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (309, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (310, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (311, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (312, 4, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 368, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (313, 5, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 368, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (314, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (315, 12, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (316, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (317, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (318, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 369, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (319, 16, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (320, 17, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (321, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (322, 19, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (323, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 369, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (324, 21, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (325, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (326, 23, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (327, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (328, 28, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 369, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (329, 29, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 369, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (330, 2, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (331, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (332, 3, 33, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (333, 4, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 369, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (334, 5, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 369, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (335, 11, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (336, 12, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (337, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (338, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (339, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 370, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (340, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (341, 17, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (342, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (343, 19, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (344, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 370, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (345, 21, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (346, 22, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (347, 23, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (348, 27, 33, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (349, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 370, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (350, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 370, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (351, 2, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (352, 1, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (353, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (354, 4, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 370, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (355, 5, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 370, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (356, 11, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (357, 12, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (358, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (359, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (360, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 371, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (361, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (362, 17, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (363, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (364, 19, 33, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (365, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 371, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (366, 21, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (367, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (368, 23, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (369, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (370, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 371, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (371, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 371, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (372, 2, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (373, 1, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (374, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (375, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 371, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (376, 5, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 371, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (377, 11, 33, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (378, 12, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (379, 13, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (380, 14, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (381, 15, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 372, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (382, 16, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (383, 17, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (384, 18, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (385, 19, 33, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (386, 20, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 372, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (387, 21, 33, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (388, 22, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (389, 23, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (390, 27, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (391, 28, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 372, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (392, 29, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 372, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (393, 2, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (394, 1, 33, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (395, 3, 33, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (396, 4, 33, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 372, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (397, 5, 33, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 372, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (398, 11, 34, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (399, 12, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (400, 13, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (401, 14, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (402, 15, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 373, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (403, 16, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (404, 17, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (405, 18, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (406, 19, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (407, 20, 34, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 373, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (408, 21, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (409, 22, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (410, 23, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (411, 27, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (412, 28, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 373, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (413, 29, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 373, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (414, 2, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (415, 1, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (416, 3, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (417, 4, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 373, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (418, 5, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 373, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (419, 11, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (420, 12, 34, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (421, 13, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (422, 14, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (423, 15, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 374, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (424, 16, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (425, 17, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (426, 18, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (427, 19, 34, 4, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (428, 20, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 374, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (429, 21, 34, 3, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (430, 22, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (431, 23, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (432, 27, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (433, 28, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 374, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (434, 29, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 374, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (435, 2, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (436, 1, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (437, 3, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (438, 4, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 374, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (439, 5, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 374, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (440, 11, 34, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (441, 12, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (442, 13, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (443, 14, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (444, 15, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 375, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (445, 16, 34, 4, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (446, 17, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (447, 18, 34, 3, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (448, 19, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (449, 20, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 375, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (450, 21, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 13:08:38.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (451, 22, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-06 16:02:50.000000', '2019-07-08 15:03:19.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (452, 23, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (453, 27, 34, 2, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:19.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (454, 28, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 375, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (455, 29, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 375, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (456, 2, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:39.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (457, 1, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (458, 3, 34, 1, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (459, 4, 34, 2, '2019-07-08 15:03:20.000000', '2019-07-08 15:03:20.000000', 375, '2019-07-08 15:44:38.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (460, 5, 34, 1, '2019-07-08 15:03:20.000000', '2019-07-08 15:44:38.000000', 375, '2019-07-08 15:44:39.000000', '2019-07-08 15:44:38.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (461, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (462, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (463, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (464, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (465, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (466, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (467, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (468, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (469, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (470, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_knowledge_student_state` VALUES (471, 1, 1, 1, '2019-11-17 17:18:12.000000', NULL, 1, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (472, 1, 1, 1, '2019-11-17 17:22:10.000000', NULL, 1, '2019-11-17 17:22:10.000000', '2019-11-17 17:22:10.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (473, 1, 1, 1, '2019-11-17 18:46:02.000000', NULL, 1, '2019-11-17 18:46:02.000000', '2019-11-17 18:46:02.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (474, 1, 1, 1, '2019-11-17 18:46:49.000000', NULL, 1, '2019-11-17 18:46:49.000000', '2019-11-17 18:46:49.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (475, 1, 1, 1, '2019-11-17 18:47:55.000000', NULL, 1, '2019-11-17 18:47:55.000000', '2019-11-17 18:47:55.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (476, 1, 1, 1, '2019-11-17 18:48:27.000000', NULL, 1, '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_knowledge_student_state` VALUES (477, 1, 1, 1, '2019-11-17 18:49:07.000000', NULL, 1, '2019-11-17 18:49:07.000000', '2019-11-17 18:49:07.000000');

-- ----------------------------
-- Table structure for tb_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tb_lesson`;
CREATE TABLE `tb_lesson`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课程id',
  `number` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '课时号',
  `classroom_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '教室',
  `begin` datetime(6) NULL DEFAULT NULL COMMENT '上课时间',
  `end` datetime(6) NULL DEFAULT NULL COMMENT '下课时间',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_lesson`(`course_id`, `number`) USING BTREE,
  UNIQUE INDEX `uk_lesson_begin`(`classroom_id`, `begin`) USING BTREE,
  UNIQUE INDEX `uk_lesson_end`(`classroom_id`, `end`) USING BTREE,
  INDEX `idx_number`(`number`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_classroom_id`(`classroom_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 263 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_lesson
-- ----------------------------
INSERT INTO `tb_lesson` VALUES (3, 5, 2, 3, '2019-04-08 21:00:00.000000', '2019-04-08 22:40:00.000000', '2019-04-09 17:45:43.000000', '2019-04-09 17:45:43.000000');
INSERT INTO `tb_lesson` VALUES (4, 6, 2, 2, '2019-04-10 19:00:00.000000', '2019-04-10 20:40:00.000000', '2019-04-09 17:46:39.000000', '2019-04-09 17:46:39.000000');
INSERT INTO `tb_lesson` VALUES (5, NULL, 2, NULL, '2019-04-12 01:00:00.000000', '2019-04-12 02:40:00.000000', '2019-04-09 17:51:13.000000', '2019-04-09 17:51:13.000000');
INSERT INTO `tb_lesson` VALUES (6, 8, 2, 9, '2019-04-12 06:00:00.000000', '2019-04-12 07:40:00.000000', '2019-04-09 17:51:45.000000', '2019-04-09 17:51:45.000000');
INSERT INTO `tb_lesson` VALUES (7, 9, 2, 1, '2019-04-09 21:00:00.000000', '2019-04-09 22:40:00.000000', '2019-04-09 17:52:14.000000', '2019-04-09 17:52:14.000000');
INSERT INTO `tb_lesson` VALUES (8, 10, 2, 10, '2019-04-13 01:00:00.000000', '2019-04-13 02:40:00.000000', '2019-04-09 17:52:42.000000', '2019-04-09 17:52:42.000000');
INSERT INTO `tb_lesson` VALUES (9, 11, 2, 8, '2019-04-14 01:00:00.000000', '2019-04-14 02:40:00.000000', '2019-04-09 17:53:09.000000', '2019-04-09 17:53:09.000000');
INSERT INTO `tb_lesson` VALUES (10, 12, 2, 1, '2019-02-15 03:00:00.000000', '2019-04-15 06:40:00.000000', '2019-04-09 19:47:02.000000', '2019-04-09 19:47:02.000000');
INSERT INTO `tb_lesson` VALUES (11, 13, 2, 8, '2019-05-26 20:00:00.000000', '2019-02-26 21:40:00.000000', '2019-04-10 00:05:42.000000', '2019-04-10 00:05:42.000000');
INSERT INTO `tb_lesson` VALUES (12, 14, 2, 8, '2019-02-26 18:00:00.000000', '2019-02-26 19:40:00.000000', '2019-04-10 12:08:14.000000', '2019-04-10 12:08:14.000000');
INSERT INTO `tb_lesson` VALUES (13, 15, 2, 3, '2019-02-26 20:00:00.000000', '2019-02-26 21:40:00.000000', '2019-04-11 20:56:33.000000', '2019-04-11 20:56:33.000000');
INSERT INTO `tb_lesson` VALUES (14, 16, 2, 2, '2019-02-26 20:00:00.000000', '2019-02-26 21:40:00.000000', '2019-04-11 20:57:52.000000', '2019-04-11 20:57:52.000000');
INSERT INTO `tb_lesson` VALUES (15, 17, 2, 7, '2019-02-26 20:00:00.000000', '2019-02-26 21:40:00.000000', '2019-04-11 21:08:57.000000', '2019-04-11 21:08:57.000000');
INSERT INTO `tb_lesson` VALUES (16, 18, 2, 2, '2019-02-26 18:00:00.000000', '2019-02-26 19:40:00.000000', '2019-04-12 23:39:39.000000', '2019-04-12 23:39:39.000000');
INSERT INTO `tb_lesson` VALUES (17, 19, 2, 9, '2019-06-27 01:00:00.000000', '2019-06-27 02:40:00.000000', '2019-05-11 10:21:13.000000', '2019-05-11 10:21:13.000000');
INSERT INTO `tb_lesson` VALUES (18, 20, 2, 2, '2019-05-18 01:00:00.000000', '2019-05-18 02:40:00.000000', '2019-05-11 10:53:00.000000', '2019-05-11 10:53:00.000000');
INSERT INTO `tb_lesson` VALUES (19, 21, 2, 2, '2019-05-17 19:00:00.000000', '2019-05-17 20:40:00.000000', '2019-05-14 19:58:13.000000', '2019-05-14 19:58:13.000000');
INSERT INTO `tb_lesson` VALUES (20, 22, 2, 2, '2019-12-17 18:00:00.000000', '2019-12-17 19:40:00.000000', '2019-05-15 19:42:18.000000', '2019-05-15 19:42:18.000000');
INSERT INTO `tb_lesson` VALUES (21, 23, 2, 2, '2019-07-17 19:00:00.000000', '2019-07-17 20:40:00.000000', '2019-05-26 13:29:33.000000', '2019-05-26 13:29:33.000000');
INSERT INTO `tb_lesson` VALUES (22, 24, 2, 1, '2019-08-07 19:00:00.000000', '2019-08-07 20:40:00.000000', '2019-08-05 22:06:52.000000', '2019-08-05 22:06:52.000000');
INSERT INTO `tb_lesson` VALUES (23, 2, 2, 6, '2019-07-01 12:31:29.000000', '2019-10-08 12:32:47.000000', '2019-10-31 12:31:32.000000', '2019-10-31 12:31:34.000000');
INSERT INTO `tb_lesson` VALUES (25, 25, 2, 1, '2019-05-17 19:00:00.000000', '2019-05-17 20:40:00.000000', '2019-10-16 14:37:54.000000', '2019-10-16 14:37:54.000000');
INSERT INTO `tb_lesson` VALUES (33, 2, 32, 2, '2019-09-30 23:27:01.000000', '2020-01-31 23:27:20.000000', '2019-10-31 23:27:29.000000', '2019-10-31 23:27:30.000000');
INSERT INTO `tb_lesson` VALUES (34, 4, 4, 1, '2019-11-18 19:00:00.000000', '2020-01-01 20:40:00.000000', '2019-06-30 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_lesson` VALUES (35, 2, 64, 6, '2019-09-15 17:18:55.000000', '2020-01-01 17:19:03.000000', '2019-01-01 17:19:19.000000', '2019-06-01 17:19:27.000000');
INSERT INTO `tb_lesson` VALUES (36, NULL, NULL, NULL, '2020-01-31 17:19:51.000000', '2020-06-01 17:19:56.000000', '2019-10-31 17:20:00.000000', '2019-10-31 17:20:03.000000');
INSERT INTO `tb_lesson` VALUES (37, 3, 64, 4, '2020-01-01 17:19:51.000000', '2020-06-01 17:19:56.000000', '2019-10-31 17:20:00.000000', '2019-10-31 17:20:03.000000');
INSERT INTO `tb_lesson` VALUES (253, 7, 2, 3, '2019-12-18 16:00:00.000000', '2019-12-18 17:40:00.000000', '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_lesson` VALUES (262, 4, 2, 3, '2019-12-18 08:00:00.000000', '2019-12-18 09:40:00.000000', '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_lesson` VALUES (263, 1, 1, 2, '2019-11-17 17:18:12.308000', '2019-11-17 17:18:12.308000', '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES (52, '通知1', '通知正文', '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');
INSERT INTO `tb_news` VALUES (53, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_news` VALUES (54, '通知1', '通知正文', '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_news` VALUES (55, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_news` VALUES (56, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_news` VALUES (57, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-01 12:47:18.000000', '2019-11-01 12:47:18.000000');
INSERT INTO `tb_news` VALUES (58, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_news` VALUES (59, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_news` VALUES (60, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-02 14:16:47.000000', '2019-11-02 14:16:47.000000');
INSERT INTO `tb_news` VALUES (61, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_news` VALUES (62, '申请通知!', '您有新的教室申请!请查看', NULL, NULL);
INSERT INTO `tb_news` VALUES (63, '申请反馈!', '您的申请已接受!请查收', NULL, NULL);
INSERT INTO `tb_news` VALUES (64, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_news` VALUES (65, '上课通知!', '李丽老师有新授课计划,请注意查看课表.该通知由系统自动推送.', '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_news` VALUES (66, '通知1', '通知正文', '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_news` VALUES (67, '通知1', '通知正文', '2019-11-17 17:22:10.000000', '2019-11-17 17:22:10.000000');
INSERT INTO `tb_news` VALUES (68, '通知1', '通知正文', '2019-11-17 18:46:03.000000', '2019-11-17 18:46:03.000000');
INSERT INTO `tb_news` VALUES (69, '通知1', '通知正文', '2019-11-17 18:46:49.000000', '2019-11-17 18:46:49.000000');
INSERT INTO `tb_news` VALUES (70, '通知1', '通知正文', '2019-11-17 18:47:55.000000', '2019-11-17 18:47:55.000000');
INSERT INTO `tb_news` VALUES (71, '通知1', '通知正文', '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_news` VALUES (72, '通知1', '通知正文', '2019-11-17 18:49:07.000000', '2019-11-17 18:49:07.000000');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`resource`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES (2, '教学课表', 'tea:teachingSchedule', '2019-02-12 22:53:14.000000', '2019-02-12 22:53:16.000000');
INSERT INTO `tb_permission` VALUES (3, '我的听课质量', 'stu:myClassQuality', '2019-01-29 13:38:49.000000', '2019-01-29 13:38:49.000000');
INSERT INTO `tb_permission` VALUES (4, '我的课表', 'stu:mySchedule', '2019-02-13 09:53:05.000000', '2019-02-13 09:53:07.000000');
INSERT INTO `tb_permission` VALUES (5, '权限管理', 'admin:authorityManagement', '2019-01-29 13:38:49.000000', '2019-01-29 13:38:49.000000');
INSERT INTO `tb_permission` VALUES (6, '学生管理', 'admin:studentsManagement', '2019-01-29 13:38:49.000000', '2019-01-29 13:38:49.000000');
INSERT INTO `tb_permission` VALUES (7, '教师管理', 'admin:teachersManagement', '2019-02-12 17:22:45.000000', '2019-02-12 17:22:47.000000');
INSERT INTO `tb_permission` VALUES (8, '教室管理', 'admin:classroomsManagement', '2019-02-12 17:23:30.000000', '2019-02-12 17:23:33.000000');
INSERT INTO `tb_permission` VALUES (9, '班级管理', 'admin:classesManagement', '2019-02-12 22:59:45.000000', '2019-02-12 22:59:47.000000');
INSERT INTO `tb_permission` VALUES (10, '教室直播', 'admin:classroomLive', '2019-02-12 17:29:10.000000', '2019-02-12 17:29:14.000000');
INSERT INTO `tb_permission` VALUES (11, '课堂详情', 'tea:lessonDetails', '2019-02-12 22:47:32.000000', '2019-02-12 22:47:36.000000');
INSERT INTO `tb_permission` VALUES (12, '课程详情', 'tea:courseDetails', '2019-02-12 22:49:35.000000', '2019-02-12 22:49:38.000000');
INSERT INTO `tb_permission` VALUES (13, '学生详情', 'tea:studentDetails', '2019-02-12 22:50:49.000000', '2019-02-12 22:50:53.000000');
INSERT INTO `tb_permission` VALUES (16, '课程管理', 'admin:coursesManagement', '2019-02-13 16:48:41.000000', '2019-02-13 16:48:44.000000');
INSERT INTO `tb_permission` VALUES (17, '楼宇管理', 'admin:buildingsManagement', '2019-03-23 14:09:54.000000', '2019-03-23 14:09:56.000000');
INSERT INTO `tb_permission` VALUES (18, '我的照片信息显示', 'stu:myPictureAndClassAndFaceTokenShow', '2019-03-23 10:00:55.000000', '2019-03-23 10:00:58.000000');
INSERT INTO `tb_permission` VALUES (19, '考勤', 'tea:checkAttendance', '2019-03-23 10:00:55.000000', '2019-03-23 10:00:58.000000');
INSERT INTO `tb_permission` VALUES (20, '状态检测', 'tea:checkState', '2019-03-23 10:00:55.000000', '2019-03-23 10:00:58.000000');
INSERT INTO `tb_permission` VALUES (21, '数据导入', 'admin:importData', '2019-02-13 16:48:41.000000', '2019-02-13 16:48:44.000000');
INSERT INTO `tb_permission` VALUES (22, '球机管理', 'admin:cameraControl', '2019-02-13 16:48:41.000000', '2019-02-13 16:48:44.000000');
INSERT INTO `tb_permission` VALUES (23, '设置知识点', 'tea:fillKnowledge', '2019-02-13 16:48:41.000000', '2019-02-13 16:48:44.000000');
INSERT INTO `tb_permission` VALUES (24, '知识点学情反馈', 'tea:knowledgeStudyStatement', '2019-07-07 19:08:31.000000', '2019-07-07 19:08:33.000000');
INSERT INTO `tb_permission` VALUES (25, '角色管理', 'admin:roleManagement', '2019-07-07 19:19:06.000000', '2019-07-07 19:19:08.000000');
INSERT INTO `tb_permission` VALUES (27, '123', '33', '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');

-- ----------------------------
-- Table structure for tb_permission_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission_group`;
CREATE TABLE `tb_permission_group`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET big5 COLLATE big5_chinese_ci NOT NULL COMMENT '权限组名',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission_group
-- ----------------------------
INSERT INTO `tb_permission_group` VALUES (2, 'permStudent', '2019-01-29 16:07:59.000000', '2019-01-29 16:08:03.000000');
INSERT INTO `tb_permission_group` VALUES (3, 'permAdministrator', '2019-01-29 16:09:51.000000', '2019-01-29 16:09:53.000000');
INSERT INTO `tb_permission_group` VALUES (6, '123', '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');

-- ----------------------------
-- Table structure for tb_permission_group_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission_group_permission`;
CREATE TABLE `tb_permission_group_permission`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `permission_group_id` bigint(20) UNSIGNED NOT NULL COMMENT '权限组id',
  `permission_id` bigint(20) UNSIGNED NOT NULL COMMENT '权限id',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_permission_group_id`(`permission_group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission_group_permission
-- ----------------------------
INSERT INTO `tb_permission_group_permission` VALUES (2, 1, 2, '2019-01-29 16:11:04.000000', '2019-01-29 16:11:07.000000');
INSERT INTO `tb_permission_group_permission` VALUES (3, 2, 3, '2019-01-29 16:11:27.000000', '2019-01-29 16:11:30.000000');
INSERT INTO `tb_permission_group_permission` VALUES (4, 2, 4, '2019-01-29 16:11:43.000000', '2019-01-29 16:11:47.000000');
INSERT INTO `tb_permission_group_permission` VALUES (5, 3, 5, '2019-01-29 16:11:56.000000', '2019-01-29 16:11:59.000000');
INSERT INTO `tb_permission_group_permission` VALUES (6, 3, 6, '2019-01-29 16:12:09.000000', '2019-01-29 16:12:13.000000');
INSERT INTO `tb_permission_group_permission` VALUES (7, 3, 7, '2019-02-12 17:27:03.000000', '2019-02-12 17:27:07.000000');
INSERT INTO `tb_permission_group_permission` VALUES (8, 3, 8, '2019-02-12 17:27:19.000000', '2019-02-12 17:27:21.000000');
INSERT INTO `tb_permission_group_permission` VALUES (9, 3, 9, '2019-02-12 17:36:47.000000', '2019-02-12 17:36:50.000000');
INSERT INTO `tb_permission_group_permission` VALUES (10, 3, 10, '2019-02-13 11:38:03.000000', '2019-02-13 11:38:04.000000');
INSERT INTO `tb_permission_group_permission` VALUES (12, 3, 16, '2019-02-13 17:23:37.000000', '2019-02-13 17:23:40.000000');
INSERT INTO `tb_permission_group_permission` VALUES (21, 1, 11, '2019-02-13 10:52:55.000000', '2019-02-13 10:52:58.000000');
INSERT INTO `tb_permission_group_permission` VALUES (22, 1, 12, '2019-02-13 10:53:19.000000', '2019-02-13 10:53:22.000000');
INSERT INTO `tb_permission_group_permission` VALUES (23, 1, 13, '2019-02-13 10:53:37.000000', '2019-02-13 10:53:41.000000');
INSERT INTO `tb_permission_group_permission` VALUES (24, 3, 17, '2019-03-23 10:02:07.000000', '2019-03-23 10:02:09.000000');
INSERT INTO `tb_permission_group_permission` VALUES (25, 2, 18, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (26, 1, 19, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (27, 1, 20, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (28, 3, 21, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (29, 3, 22, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (30, 1, 23, '2019-03-23 15:15:54.000000', '2019-03-23 15:15:56.000000');
INSERT INTO `tb_permission_group_permission` VALUES (31, 1, 24, '2019-07-07 19:08:49.000000', '2019-07-07 19:08:51.000000');
INSERT INTO `tb_permission_group_permission` VALUES (32, 3, 25, '2019-07-07 19:19:26.000000', '2019-07-07 19:19:27.000000');
INSERT INTO `tb_permission_group_permission` VALUES (39, 1, 3, '2019-10-29 22:59:45.000000', '2019-10-29 22:59:46.000000');
INSERT INTO `tb_permission_group_permission` VALUES (40, 1, 4, '2019-10-29 23:00:02.000000', '2019-10-29 23:00:03.000000');
INSERT INTO `tb_permission_group_permission` VALUES (41, 1, 4, '2019-10-29 23:00:02.000000', '2019-10-29 23:00:03.000000');
INSERT INTO `tb_permission_group_permission` VALUES (42, 1, 5, '2019-10-29 23:00:02.000000', '2019-10-29 23:00:03.000000');
INSERT INTO `tb_permission_group_permission` VALUES (43, 1, 6, '2019-10-29 23:00:47.000000', '2019-10-29 23:00:50.000000');
INSERT INTO `tb_permission_group_permission` VALUES (44, 1, 7, '2019-10-29 23:01:09.000000', '2019-10-29 23:01:11.000000');
INSERT INTO `tb_permission_group_permission` VALUES (45, 1, 1, '2019-10-30 13:42:43.000000', '2019-10-30 13:42:43.000000');
INSERT INTO `tb_permission_group_permission` VALUES (46, 1, 1, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_permission_group_permission` VALUES (47, 1, 1, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_permission_group_permission` VALUES (48, 1, 1, '2019-11-17 17:22:11.000000', '2019-11-17 17:22:11.000000');
INSERT INTO `tb_permission_group_permission` VALUES (49, 1, 1, '2019-11-17 18:46:03.000000', '2019-11-17 18:46:03.000000');
INSERT INTO `tb_permission_group_permission` VALUES (50, 1, 1, '2019-11-17 18:46:49.000000', '2019-11-17 18:46:49.000000');
INSERT INTO `tb_permission_group_permission` VALUES (51, 1, 1, '2019-11-17 18:47:55.000000', '2019-11-17 18:47:55.000000');
INSERT INTO `tb_permission_group_permission` VALUES (52, 1, 1, '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_permission_group_permission` VALUES (53, 1, 1, '2019-11-17 18:49:07.000000', '2019-11-17 18:49:07.000000');

-- ----------------------------
-- Table structure for tb_permission_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission_user`;
CREATE TABLE `tb_permission_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `permission_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 332 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission_user
-- ----------------------------
INSERT INTO `tb_permission_user` VALUES (32, 31, 1, '2019-02-13 14:01:43.000000', '2019-02-13 14:01:43.000000');
INSERT INTO `tb_permission_user` VALUES (33, 31, 2, '2019-02-13 14:01:43.000000', '2019-02-13 14:01:43.000000');
INSERT INTO `tb_permission_user` VALUES (34, 31, 3, '2019-02-13 14:01:43.000000', '2019-02-13 14:01:43.000000');
INSERT INTO `tb_permission_user` VALUES (35, 31, 4, '2019-02-13 14:01:43.000000', '2019-02-13 14:01:43.000000');
INSERT INTO `tb_permission_user` VALUES (36, 31, 5, '2019-02-13 14:01:43.000000', '2019-02-13 14:01:43.000000');
INSERT INTO `tb_permission_user` VALUES (39, 31, 6, '2019-02-13 14:02:07.000000', '2019-02-13 14:02:07.000000');
INSERT INTO `tb_permission_user` VALUES (40, 31, 7, '2019-02-13 14:02:07.000000', '2019-02-13 14:02:07.000000');
INSERT INTO `tb_permission_user` VALUES (41, 31, 8, '2019-02-13 14:02:07.000000', '2019-02-13 14:02:07.000000');
INSERT INTO `tb_permission_user` VALUES (42, 31, 9, '2019-02-13 14:02:07.000000', '2019-02-13 14:02:07.000000');
INSERT INTO `tb_permission_user` VALUES (60, 31, 11, '2019-02-13 17:27:52.000000', '2019-02-13 17:27:52.000000');
INSERT INTO `tb_permission_user` VALUES (61, 31, 12, '2019-02-13 17:27:52.000000', '2019-02-13 17:27:52.000000');
INSERT INTO `tb_permission_user` VALUES (62, 31, 13, '2019-02-13 17:27:52.000000', '2019-02-13 17:27:52.000000');
INSERT INTO `tb_permission_user` VALUES (63, 31, 14, '2019-02-13 17:27:52.000000', '2019-02-13 17:27:52.000000');
INSERT INTO `tb_permission_user` VALUES (64, 31, 15, '2019-02-13 17:27:52.000000', '2019-02-13 17:27:52.000000');
INSERT INTO `tb_permission_user` VALUES (75, 31, 16, '2019-02-13 17:48:24.000000', '2019-02-13 17:48:24.000000');
INSERT INTO `tb_permission_user` VALUES (115, 31, 17, '2019-02-20 19:53:49.000000', '2019-02-20 19:53:49.000000');
INSERT INTO `tb_permission_user` VALUES (116, 31, 18, '2019-02-20 19:53:49.000000', '2019-02-20 19:53:49.000000');
INSERT INTO `tb_permission_user` VALUES (117, 31, 19, '2019-02-20 20:13:08.000000', '2019-02-20 20:13:11.000000');
INSERT INTO `tb_permission_user` VALUES (118, 31, 20, '2019-02-20 20:13:24.000000', '2019-02-20 20:13:29.000000');
INSERT INTO `tb_permission_user` VALUES (119, 31, 21, '2019-02-20 20:13:39.000000', '2019-02-20 20:13:41.000000');
INSERT INTO `tb_permission_user` VALUES (120, 31, 22, '2019-02-20 20:13:50.000000', '2019-02-20 20:13:52.000000');
INSERT INTO `tb_permission_user` VALUES (121, 31, 23, '2019-02-20 20:14:05.000000', '2019-02-20 20:14:07.000000');
INSERT INTO `tb_permission_user` VALUES (122, 31, 24, '2019-02-20 20:14:19.000000', '2019-02-20 20:14:21.000000');
INSERT INTO `tb_permission_user` VALUES (129, 31, 25, '2019-02-22 14:16:31.000000', '2019-02-22 14:16:31.000000');
INSERT INTO `tb_permission_user` VALUES (130, 31, 26, '2019-02-22 14:16:31.000000', '2019-02-22 14:16:31.000000');
INSERT INTO `tb_permission_user` VALUES (131, 31, 0, '2019-02-22 14:16:31.000000', '2019-02-22 14:16:31.000000');
INSERT INTO `tb_permission_user` VALUES (132, 31, 12, '2019-02-22 14:16:32.000000', '2019-02-22 14:16:32.000000');
INSERT INTO `tb_permission_user` VALUES (133, 31, 13, '2019-02-22 14:16:32.000000', '2019-02-22 14:16:32.000000');
INSERT INTO `tb_permission_user` VALUES (140, 31, 5, '2019-02-13 14:02:55.000000', '2019-02-13 14:02:55.000000');
INSERT INTO `tb_permission_user` VALUES (141, 31, 6, '2019-02-13 14:02:55.000000', '2019-02-13 14:02:55.000000');
INSERT INTO `tb_permission_user` VALUES (142, 31, 7, '2019-02-13 14:02:56.000000', '2019-02-13 14:02:56.000000');
INSERT INTO `tb_permission_user` VALUES (143, 31, 8, '2019-02-13 14:02:56.000000', '2019-02-13 14:02:56.000000');
INSERT INTO `tb_permission_user` VALUES (144, 31, 9, '2019-02-13 16:51:52.000000', '2019-02-13 16:51:55.000000');
INSERT INTO `tb_permission_user` VALUES (145, 31, 10, '2019-03-09 15:16:32.000000', '2019-03-09 15:16:34.000000');
INSERT INTO `tb_permission_user` VALUES (146, 31, 11, '2019-03-09 15:18:11.000000', '2019-03-09 15:18:11.000000');
INSERT INTO `tb_permission_user` VALUES (147, 31, 12, '2019-03-09 15:18:11.000000', '2019-03-09 15:18:11.000000');
INSERT INTO `tb_permission_user` VALUES (148, 31, 13, '2019-03-09 15:18:11.000000', '2019-03-09 15:18:11.000000');
INSERT INTO `tb_permission_user` VALUES (151, 31, 16, '2019-03-09 15:18:11.000000', '2019-03-09 15:18:11.000000');
INSERT INTO `tb_permission_user` VALUES (161, 31, 1, '2019-03-09 15:22:20.000000', '2019-03-09 15:22:20.000000');
INSERT INTO `tb_permission_user` VALUES (162, 31, 2, '2019-03-09 15:40:22.000000', '2019-03-09 15:40:22.000000');
INSERT INTO `tb_permission_user` VALUES (164, 31, 17, '2019-03-30 11:29:15.000000', '2019-03-30 11:29:17.000000');
INSERT INTO `tb_permission_user` VALUES (173, 31, 4, '2019-03-23 10:31:01.000000', '2019-03-23 10:31:01.000000');
INSERT INTO `tb_permission_user` VALUES (174, 31, 17, '2019-03-23 10:31:02.000000', '2019-03-23 10:31:02.000000');
INSERT INTO `tb_permission_user` VALUES (176, 31, 3, '2019-03-23 16:33:16.000000', '2019-03-23 16:33:16.000000');
INSERT INTO `tb_permission_user` VALUES (178, 31, 4, '2019-03-29 20:25:58.000000', '2019-03-29 20:25:58.000000');
INSERT INTO `tb_permission_user` VALUES (187, 31, 3, '2019-03-30 13:13:33.000000', '2019-03-30 13:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (188, 31, 4, '2019-03-30 13:13:33.000000', '2019-03-30 13:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (189, 31, 18, '2019-03-30 13:13:33.000000', '2019-03-30 13:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (194, 31, 21, '2019-03-30 13:13:33.000000', '2019-03-30 13:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (197, 31, 22, '2019-03-30 13:13:33.000000', '2019-03-30 13:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (198, 31, 3, '2019-04-06 18:37:00.000000', '2019-04-06 18:37:00.000000');
INSERT INTO `tb_permission_user` VALUES (201, 31, 18, '2019-04-09 19:35:21.000000', '2019-04-09 19:35:21.000000');
INSERT INTO `tb_permission_user` VALUES (203, 31, 2, '2019-04-09 19:46:09.000000', '2019-04-09 19:46:09.000000');
INSERT INTO `tb_permission_user` VALUES (204, 31, 11, '2019-04-09 19:46:09.000000', '2019-04-09 19:46:09.000000');
INSERT INTO `tb_permission_user` VALUES (205, 31, 12, '2019-04-09 19:46:09.000000', '2019-04-09 19:46:09.000000');
INSERT INTO `tb_permission_user` VALUES (206, 31, 13, '2019-04-09 19:46:10.000000', '2019-04-09 19:46:10.000000');
INSERT INTO `tb_permission_user` VALUES (209, 2, 5, '2019-04-12 16:20:56.000000', '2019-04-12 16:20:56.000000');
INSERT INTO `tb_permission_user` VALUES (210, 31, 6, '2019-04-12 16:20:56.000000', '2019-04-12 16:20:56.000000');
INSERT INTO `tb_permission_user` VALUES (211, 31, 7, '2019-04-12 16:20:56.000000', '2019-04-12 16:20:56.000000');
INSERT INTO `tb_permission_user` VALUES (212, 31, 8, '2019-04-12 16:20:56.000000', '2019-04-12 16:20:56.000000');
INSERT INTO `tb_permission_user` VALUES (213, 31, 9, '2019-04-12 16:20:56.000000', '2019-04-12 16:20:56.000000');
INSERT INTO `tb_permission_user` VALUES (214, 31, 10, '2019-04-12 16:20:57.000000', '2019-04-12 16:20:57.000000');
INSERT INTO `tb_permission_user` VALUES (215, 31, 16, '2019-04-12 16:20:57.000000', '2019-04-12 16:20:57.000000');
INSERT INTO `tb_permission_user` VALUES (216, 31, 17, '2019-04-12 16:20:57.000000', '2019-04-12 16:20:57.000000');
INSERT INTO `tb_permission_user` VALUES (217, 31, 21, '2019-04-12 16:20:57.000000', '2019-04-12 16:20:57.000000');
INSERT INTO `tb_permission_user` VALUES (218, 31, 22, '2019-04-12 16:20:57.000000', '2019-04-12 16:20:57.000000');
INSERT INTO `tb_permission_user` VALUES (220, 31, 3, '2019-05-15 20:57:11.000000', '2019-05-15 20:57:11.000000');
INSERT INTO `tb_permission_user` VALUES (222, 31, 23, '2019-05-22 23:39:05.000000', '2019-05-22 23:39:08.000000');
INSERT INTO `tb_permission_user` VALUES (224, 31, 24, '2019-07-07 19:20:28.000000', '2019-07-07 19:20:31.000000');
INSERT INTO `tb_permission_user` VALUES (225, 31, 25, '2019-07-07 19:20:45.000000', '2019-07-07 19:20:48.000000');
INSERT INTO `tb_permission_user` VALUES (226, 31, 25, '2019-07-07 19:21:38.000000', '2019-07-07 19:21:41.000000');
INSERT INTO `tb_permission_user` VALUES (229, 31, 20, '2019-08-07 20:23:50.000000', '2019-08-07 20:23:50.000000');
INSERT INTO `tb_permission_user` VALUES (230, 30, 5, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (231, 30, 6, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (232, 30, 7, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (233, 30, 8, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (234, 30, 9, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (235, 30, 10, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (236, 30, 16, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (237, 30, 17, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (238, 30, 21, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (239, 30, 22, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (240, 30, 25, '2019-10-29 23:23:22.000000', '2019-10-29 23:23:22.000000');
INSERT INTO `tb_permission_user` VALUES (241, 30, 1, '2019-10-29 23:25:49.000000', '2019-10-29 23:25:49.000000');
INSERT INTO `tb_permission_user` VALUES (242, 30, 2, '2019-10-29 23:25:54.000000', '2019-10-29 23:25:54.000000');
INSERT INTO `tb_permission_user` VALUES (243, 30, 3, '2019-10-29 23:25:57.000000', '2019-10-29 23:25:57.000000');
INSERT INTO `tb_permission_user` VALUES (244, 30, 4, '2019-10-29 23:26:00.000000', '2019-10-29 23:26:00.000000');
INSERT INTO `tb_permission_user` VALUES (245, 30, 11, '2019-10-29 23:26:02.000000', '2019-10-29 23:26:02.000000');
INSERT INTO `tb_permission_user` VALUES (246, 30, 12, '2019-10-29 23:26:05.000000', '2019-10-29 23:26:05.000000');
INSERT INTO `tb_permission_user` VALUES (247, 30, 13, '2019-10-29 23:26:07.000000', '2019-10-29 23:26:07.000000');
INSERT INTO `tb_permission_user` VALUES (248, 30, 18, '2019-10-29 23:26:09.000000', '2019-10-29 23:26:09.000000');
INSERT INTO `tb_permission_user` VALUES (249, 30, 19, '2019-10-29 23:26:11.000000', '2019-10-29 23:26:11.000000');
INSERT INTO `tb_permission_user` VALUES (250, 30, 24, '2019-10-29 23:26:13.000000', '2019-10-29 23:26:13.000000');
INSERT INTO `tb_permission_user` VALUES (251, 30, 23, '2019-10-29 23:26:15.000000', '2019-10-29 23:26:15.000000');
INSERT INTO `tb_permission_user` VALUES (252, 30, 20, '2019-10-29 23:26:18.000000', '2019-10-29 23:26:18.000000');
INSERT INTO `tb_permission_user` VALUES (256, 134, 5, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (257, 134, 6, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (258, 134, 7, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (259, 134, 8, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (260, 134, 9, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (261, 134, 10, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (262, 134, 16, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (263, 134, 17, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (264, 35, 1, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (265, 34, 1, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (266, 32, 1, '2019-10-30 14:11:55.000000', '2019-10-30 14:11:55.000000');
INSERT INTO `tb_permission_user` VALUES (273, 32, 11, '2019-10-30 14:13:29.000000', '2019-10-30 14:13:29.000000');
INSERT INTO `tb_permission_user` VALUES (274, 32, 2, '2019-10-30 14:13:33.000000', '2019-10-30 14:13:33.000000');
INSERT INTO `tb_permission_user` VALUES (275, 32, 4, '2019-10-30 14:13:37.000000', '2019-10-30 14:13:37.000000');
INSERT INTO `tb_permission_user` VALUES (276, 32, 12, '2019-10-30 14:13:54.000000', '2019-10-30 14:13:54.000000');
INSERT INTO `tb_permission_user` VALUES (277, 32, 19, '2019-10-30 14:13:59.000000', '2019-10-30 14:13:59.000000');
INSERT INTO `tb_permission_user` VALUES (278, 32, 24, '2019-10-30 14:14:06.000000', '2019-10-30 14:14:06.000000');
INSERT INTO `tb_permission_user` VALUES (279, 32, 3, '2019-10-30 14:14:10.000000', '2019-10-30 14:14:10.000000');
INSERT INTO `tb_permission_user` VALUES (280, 32, 20, '2019-10-30 14:14:24.000000', '2019-10-30 14:14:24.000000');
INSERT INTO `tb_permission_user` VALUES (281, 32, 23, '2019-10-30 14:14:28.000000', '2019-10-30 14:14:28.000000');
INSERT INTO `tb_permission_user` VALUES (282, 32, 18, '2019-10-30 14:14:31.000000', '2019-10-30 14:14:31.000000');
INSERT INTO `tb_permission_user` VALUES (284, 32, 13, '2019-10-30 14:14:55.000000', '2019-10-30 14:14:55.000000');
INSERT INTO `tb_permission_user` VALUES (285, 32, 25, '2019-10-30 14:15:19.000000', '2019-10-30 14:15:19.000000');
INSERT INTO `tb_permission_user` VALUES (286, 33, 1, '2019-10-30 14:15:51.000000', '2019-10-30 14:15:51.000000');
INSERT INTO `tb_permission_user` VALUES (291, 33, 2, '2019-10-30 14:16:16.000000', '2019-10-30 14:16:16.000000');
INSERT INTO `tb_permission_user` VALUES (294, 33, 19, '2019-10-30 14:16:27.000000', '2019-10-30 14:16:27.000000');
INSERT INTO `tb_permission_user` VALUES (295, 33, 20, '2019-10-30 14:16:30.000000', '2019-10-30 14:16:30.000000');
INSERT INTO `tb_permission_user` VALUES (296, 33, 12, '2019-10-30 14:16:40.000000', '2019-10-30 14:16:40.000000');
INSERT INTO `tb_permission_user` VALUES (297, 33, 18, '2019-10-30 14:16:48.000000', '2019-10-30 14:16:48.000000');
INSERT INTO `tb_permission_user` VALUES (298, 33, 23, '2019-10-30 14:16:53.000000', '2019-10-30 14:16:53.000000');
INSERT INTO `tb_permission_user` VALUES (299, 33, 1, '2019-10-30 14:16:57.000000', '2019-10-30 14:16:57.000000');
INSERT INTO `tb_permission_user` VALUES (300, 33, 24, '2019-10-30 14:17:01.000000', '2019-10-30 14:17:01.000000');
INSERT INTO `tb_permission_user` VALUES (301, 33, 13, '2019-10-30 14:17:13.000000', '2019-10-30 14:17:13.000000');
INSERT INTO `tb_permission_user` VALUES (302, 34, 2, '2019-10-30 16:17:29.000000', '2019-10-30 16:17:29.000000');
INSERT INTO `tb_permission_user` VALUES (303, 34, 13, '2019-10-30 16:17:41.000000', '2019-10-30 16:17:41.000000');
INSERT INTO `tb_permission_user` VALUES (304, 34, 19, '2019-10-30 16:17:52.000000', '2019-10-30 16:17:52.000000');
INSERT INTO `tb_permission_user` VALUES (305, 34, 18, '2019-10-30 16:17:56.000000', '2019-10-30 16:17:56.000000');
INSERT INTO `tb_permission_user` VALUES (306, 34, 24, '2019-10-30 16:18:00.000000', '2019-10-30 16:18:00.000000');
INSERT INTO `tb_permission_user` VALUES (307, 34, 23, '2019-10-30 16:18:09.000000', '2019-10-30 16:18:09.000000');
INSERT INTO `tb_permission_user` VALUES (308, 34, 20, '2019-10-30 16:18:14.000000', '2019-10-30 16:18:14.000000');
INSERT INTO `tb_permission_user` VALUES (309, 2, 4, '2019-10-30 16:19:37.000000', '2019-10-30 16:19:37.000000');
INSERT INTO `tb_permission_user` VALUES (310, 2, 3, '2019-10-30 16:19:40.000000', '2019-10-30 16:19:40.000000');
INSERT INTO `tb_permission_user` VALUES (311, 2, 18, '2019-10-30 16:19:48.000000', '2019-10-30 16:19:48.000000');
INSERT INTO `tb_permission_user` VALUES (313, 134, 20, '2019-10-31 13:32:53.000000', '2019-10-31 13:32:54.000000');
INSERT INTO `tb_permission_user` VALUES (314, 134, 21, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (315, 134, 22, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (316, 134, 23, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (317, 134, 24, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (318, 134, 25, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (319, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (320, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (321, 1, 3, '2019-10-31 13:38:55.000000', '2019-10-31 13:38:55.000000');
INSERT INTO `tb_permission_user` VALUES (322, 1, 4, '2019-10-31 13:38:55.000000', '2019-10-31 13:38:55.000000');
INSERT INTO `tb_permission_user` VALUES (323, 1, 18, '2019-10-31 13:38:55.000000', '2019-10-31 13:38:55.000000');
INSERT INTO `tb_permission_user` VALUES (325, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (326, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (327, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (328, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (329, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (330, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (331, NULL, NULL, NULL, NULL);
INSERT INTO `tb_permission_user` VALUES (332, 1, 1, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_permission_user` VALUES (333, 1, 1, '2019-11-17 17:22:11.000000', '2019-11-17 17:22:11.000000');
INSERT INTO `tb_permission_user` VALUES (334, 1, 1, '2019-11-17 18:46:03.000000', '2019-11-17 18:46:03.000000');
INSERT INTO `tb_permission_user` VALUES (335, 1, 1, '2019-11-17 18:46:50.000000', '2019-11-17 18:46:50.000000');
INSERT INTO `tb_permission_user` VALUES (336, 1, 1, '2019-11-17 18:47:55.000000', '2019-11-17 18:47:55.000000');
INSERT INTO `tb_permission_user` VALUES (337, 1, 1, '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_permission_user` VALUES (338, 1, 1, '2019-11-17 18:49:08.000000', '2019-11-17 18:49:08.000000');

-- ----------------------------
-- Table structure for tb_profession
-- ----------------------------
DROP TABLE IF EXISTS `tb_profession`;
CREATE TABLE `tb_profession`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `profession` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业\r\n\r\n',
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_profession`(`profession`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_profession
-- ----------------------------
INSERT INTO `tb_profession` VALUES (2, '计算机科学与技术', '2019-03-18 11:29:15.000000', '2019-03-18 11:29:15.000000');
INSERT INTO `tb_profession` VALUES (3, '汉语言文学', '2019-03-18 11:29:15.000000', '2019-03-18 11:29:15.000000');
INSERT INTO `tb_profession` VALUES (4, '数字媒体技术D', '2019-04-06 17:00:59.000000', '2019-04-06 17:00:59.000000');
INSERT INTO `tb_profession` VALUES (5, '物联网工程', '2019-04-06 17:10:07.000000', '2019-04-06 17:10:07.000000');
INSERT INTO `tb_profession` VALUES (6, '信息技术', '2019-04-06 17:23:29.000000', '2019-04-06 17:23:29.000000');
INSERT INTO `tb_profession` VALUES (7, '小学教育', '2019-04-06 17:23:29.000000', '2019-04-06 17:23:29.000000');
INSERT INTO `tb_profession` VALUES (8, '数学师范', '2019-04-06 19:12:03.000000', '2019-04-06 19:12:03.000000');
INSERT INTO `tb_profession` VALUES (11, '软件工程', '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');

-- ----------------------------
-- Table structure for tb_student_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_course`;
CREATE TABLE `tb_student_course`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `course_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课程id',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(6) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_id_course_id`(`user_id`, `course_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student_course
-- ----------------------------
INSERT INTO `tb_student_course` VALUES (6, 1, 1, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (15, 2, 1, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (18, 3, 1, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (19, 4, 1, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (20, 5, 1, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (21, 6, 2, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (22, 7, 2, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (23, 8, 2, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (24, 9, 2, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (25, 10, 2, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (26, 11, 3, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (27, 12, 3, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (28, 13, 3, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (29, 14, 3, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (30, 15, 3, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (31, 16, 4, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (32, 17, 4, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (33, 18, 4, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (34, 19, 4, '2019-03-29 19:23:25.000000', '2019-03-29 19:23:28.000000');
INSERT INTO `tb_student_course` VALUES (45, 20, 4, '2019-10-30 13:42:44.000000', '2019-10-30 13:42:44.000000');
INSERT INTO `tb_student_course` VALUES (46, 21, 4, '2019-10-30 14:47:32.000000', '2019-10-30 14:47:35.000000');
INSERT INTO `tb_student_course` VALUES (47, 22, 1, '2019-10-30 16:50:39.000000', '2019-10-30 16:50:43.000000');
INSERT INTO `tb_student_course` VALUES (48, 23, 1, '2019-10-30 16:50:54.000000', '2019-10-30 16:50:56.000000');
INSERT INTO `tb_student_course` VALUES (49, 24, 1, '2019-10-30 16:51:06.000000', '2019-10-30 16:51:08.000000');
INSERT INTO `tb_student_course` VALUES (50, 25, 1, '2019-10-30 16:51:14.000000', '2019-10-30 16:51:15.000000');
INSERT INTO `tb_student_course` VALUES (51, 26, 1, '2019-10-30 16:51:22.000000', '2019-10-30 16:51:24.000000');
INSERT INTO `tb_student_course` VALUES (52, 27, 1, '2019-10-30 16:51:34.000000', '2019-10-30 16:51:37.000000');
INSERT INTO `tb_student_course` VALUES (53, 29, 1, '2019-10-31 12:53:42.000000', '2019-10-31 12:53:44.000000');
INSERT INTO `tb_student_course` VALUES (54, 28, 2, '2019-10-31 13:00:48.000000', '2019-10-31 13:00:49.000000');
INSERT INTO `tb_student_course` VALUES (55, 1, 10, '2019-10-31 13:17:25.000000', '2019-10-31 13:17:26.000000');
INSERT INTO `tb_student_course` VALUES (56, 1, 7, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (57, 2, 7, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (58, 3, 7, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (59, 4, 7, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (60, 5, 7, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (61, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (62, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (63, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (64, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (65, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (66, NULL, NULL, NULL, NULL);
INSERT INTO `tb_student_course` VALUES (67, 1, 2, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');

-- ----------------------------
-- Table structure for tb_student_state
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_state`;
CREATE TABLE `tb_student_state`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `lesson_id` bigint(20) UNSIGNED NOT NULL COMMENT '课时id',
  `state` int(11) UNSIGNED NOT NULL COMMENT '学生上课状态',
  `scan_start_time` datetime(6) NOT NULL COMMENT '扫描开始时间',
  `scan_end_time` datetime(6) NULL DEFAULT NULL COMMENT '扫描结束时间',
  `face_token` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人脸标识',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modify_time` datetime(6) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_student_state_start`(`user_id`, `scan_start_time`) USING BTREE,
  UNIQUE INDEX `uk_student_state_end`(`user_id`, `scan_end_time`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 419 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生上课状态，算法写入' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student_state
-- ----------------------------
INSERT INTO `tb_student_state` VALUES (34, 1, 1, 1, '2019-03-19 22:49:14.000000', '2019-11-17 18:49:08.000000', '123', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (35, 2, 1, 2, '2019-03-19 22:55:29.000000', '2019-03-19 22:56:13.000000', '1233232', '2019-03-19 22:55:29.000000', '2019-03-19 22:55:29.000000');
INSERT INTO `tb_student_state` VALUES (36, 3, 1, 2, '2019-03-19 22:59:51.000000', '2019-03-19 22:58:13.000000', '123sadss', '2019-03-19 22:59:51.000000', '2019-03-19 22:59:51.000000');
INSERT INTO `tb_student_state` VALUES (37, 4, 1, 2, '2019-03-19 22:50:14.000000', '2019-03-19 22:57:53.000000', '123sdsds', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (38, 5, 1, 3, '2019-03-19 22:49:34.000000', '2019-03-19 22:57:41.000000', '123s6ad56a', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (39, 6, 2, 4, '2019-03-19 22:51:14.000000', '2019-03-19 22:52:53.000000', '123sadasasd', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (40, 7, 2, 1, '2019-03-19 22:29:14.000000', '2019-03-19 22:57:22.000000', '123ghghg', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (41, 8, 2, 1, '2019-03-19 22:43:14.000000', '2019-03-19 22:37:52.000000', '123fdgdfgd', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (42, 9, 2, 1, '2019-03-19 22:19:34.000000', '2019-03-19 23:57:41.000000', '123s6ad56adsfds', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (43, 10, 2, 1, '2019-03-19 23:51:10.000000', '2019-03-19 22:54:53.000000', '123sadasasdsadas', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (44, 11, 3, 1, '2019-03-19 22:29:24.000000', '2019-03-19 22:57:12.000000', 'sadassadsad', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (46, 12, 3, 1, '2019-03-19 21:21:10.000000', '2019-03-19 22:57:23.000000', '123sdsdssadasdasdsa', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (47, 13, 3, 1, '2019-03-19 22:44:34.000000', '2019-03-19 22:57:21.000000', '123s6ad56asadsfdsf', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (48, 14, 3, 1, '2019-03-19 20:31:12.000000', '2019-03-19 18:52:53.000000', '123sadasasddsfds', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (49, 15, 3, 3, '2019-03-19 22:22:14.000000', '2019-03-19 22:57:32.000000', '123ghghgdsfdsfg', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (50, 16, 4, 4, '2019-03-19 22:43:28.000000', '2019-03-19 22:27:22.000000', '123fdgdfgddfgfd', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (51, 17, 4, 1, '2019-03-19 22:42:34.000000', '2019-03-19 23:52:21.000000', '123s6ad56ad65dg', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (52, 18, 5, 1, '2019-03-19 23:55:14.000000', '2019-03-19 22:24:52.000000', '123sadfgfg36s', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (53, 19, 6, 1, '2019-03-19 22:25:24.000000', '2019-03-19 22:17:13.000000', 'saf6g5f', '2019-03-19 22:49:14.000000', '2019-03-19 22:49:14.000000');
INSERT INTO `tb_student_state` VALUES (57, 20, 7, 1, '2019-04-02 00:32:36.010000', '2019-04-02 00:32:37.000011', '123sadsada', '2019-04-02 00:32:36.000000', '2019-04-02 00:32:36.000000');
INSERT INTO `tb_student_state` VALUES (58, 21, 8, 1, '2019-04-02 00:32:36.000000', '2019-04-02 00:32:37.000000', '123sadsadasadas', '2019-04-02 00:32:36.000000', '2019-04-02 00:32:36.000000');
INSERT INTO `tb_student_state` VALUES (59, 22, 9, 3, '2019-04-02 00:32:33.000000', '2019-04-02 00:32:37.100000', '123sadsadasadassd', '2019-04-02 00:32:36.000000', '2019-04-02 00:32:36.000000');
INSERT INTO `tb_student_state` VALUES (60, 23, 10, 2, '2019-04-02 00:32:36.002000', '2019-04-02 00:32:37.000020', '123sadsadasad', '2019-04-02 00:32:36.000000', '2019-04-02 00:32:36.000000');
INSERT INTO `tb_student_state` VALUES (61, 24, 11, 2, '2019-04-02 00:32:36.012000', '2019-04-02 00:32:37.000221', '123sadsadasadsd', '2019-04-02 00:32:36.000000', '2019-04-02 00:32:36.000000');
INSERT INTO `tb_student_state` VALUES (94, 25, 1, 1, '2019-04-07 13:55:34.000000', '2019-04-07 13:55:34.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 13:55:34.000000', '2019-04-07 13:55:34.000000');
INSERT INTO `tb_student_state` VALUES (95, 26, 2, 3, '2019-04-07 13:55:34.000000', '2019-04-07 13:55:34.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 13:55:34.000000', '2019-04-07 13:55:34.000000');
INSERT INTO `tb_student_state` VALUES (96, 27, 2, 4, '2019-04-07 15:24:53.000000', '2019-04-07 15:24:53.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 15:24:53.000000', '2019-04-07 15:24:53.000000');
INSERT INTO `tb_student_state` VALUES (97, 28, 3, 4, '2019-04-07 15:24:54.000000', '2019-04-07 15:24:54.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 15:24:54.000000', '2019-04-07 15:24:54.000000');
INSERT INTO `tb_student_state` VALUES (98, 1, 8, 1, '2019-04-07 15:30:48.000000', '2019-04-07 15:30:48.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 15:30:48.000000', '2019-04-07 15:30:48.000000');
INSERT INTO `tb_student_state` VALUES (99, 33, 4, 2, '2019-04-07 15:30:48.000000', '2019-04-07 15:30:48.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 15:30:48.000000', '2019-04-07 15:30:48.000000');
INSERT INTO `tb_student_state` VALUES (100, 34, 5, 2, '2019-04-07 15:59:57.000000', '2019-04-07 15:59:57.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 15:59:57.000000', '2019-04-07 15:59:57.000000');
INSERT INTO `tb_student_state` VALUES (101, 9, 168, 1, '2019-04-07 15:59:57.000000', '2019-04-07 15:59:57.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 15:59:57.000000', '2019-04-07 15:59:57.000000');
INSERT INTO `tb_student_state` VALUES (102, 10, 168, 1, '2019-04-07 16:05:51.000000', '2019-04-07 16:05:51.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 16:05:51.000000', '2019-04-07 16:05:51.000000');
INSERT INTO `tb_student_state` VALUES (103, 11, 168, 3, '2019-04-07 16:05:52.000000', '2019-04-07 16:05:52.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 16:05:52.000000', '2019-04-07 16:05:52.000000');
INSERT INTO `tb_student_state` VALUES (104, 12, 168, 1, '2019-04-07 16:11:46.000000', '2019-04-07 16:11:46.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 16:11:46.000000', '2019-04-07 16:11:46.000000');
INSERT INTO `tb_student_state` VALUES (105, 13, 168, 3, '2019-04-07 16:11:46.000000', '2019-04-07 16:11:46.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 16:11:46.000000', '2019-04-07 16:11:46.000000');
INSERT INTO `tb_student_state` VALUES (106, 14, 168, 1, '2019-04-07 16:17:40.000000', '2019-04-07 16:17:40.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 16:17:40.000000', '2019-04-07 16:17:40.000000');
INSERT INTO `tb_student_state` VALUES (107, 15, 168, 2, '2019-04-07 16:17:40.000000', '2019-04-07 16:17:40.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 16:17:40.000000', '2019-04-07 16:17:40.000000');
INSERT INTO `tb_student_state` VALUES (108, 16, 168, 4, '2019-04-07 16:23:34.000000', '2019-04-07 16:23:34.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 16:23:34.000000', '2019-04-07 16:23:34.000000');
INSERT INTO `tb_student_state` VALUES (109, 17, 168, 2, '2019-04-07 16:23:34.000000', '2019-04-07 16:23:34.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 16:23:34.000000', '2019-04-07 16:23:34.000000');
INSERT INTO `tb_student_state` VALUES (110, 18, 168, 4, '2019-04-07 18:32:21.000000', '2019-04-07 18:32:21.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 18:32:21.000000', '2019-04-07 18:32:21.000000');
INSERT INTO `tb_student_state` VALUES (111, 19, 168, 4, '2019-04-07 18:32:21.000000', '2019-04-07 18:32:21.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 18:32:21.000000', '2019-04-07 18:32:21.000000');
INSERT INTO `tb_student_state` VALUES (112, 20, 168, 3, '2019-04-07 18:38:39.000000', '2019-04-07 18:38:39.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 18:38:39.000000', '2019-04-07 18:38:39.000000');
INSERT INTO `tb_student_state` VALUES (113, 21, 168, 1, '2019-04-07 18:38:40.000000', '2019-04-07 18:38:40.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 18:38:40.000000', '2019-04-07 18:38:40.000000');
INSERT INTO `tb_student_state` VALUES (114, 22, 168, 3, '2019-04-07 19:10:40.000000', '2019-04-07 19:10:40.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 19:10:40.000000', '2019-04-07 19:10:40.000000');
INSERT INTO `tb_student_state` VALUES (115, 23, 168, 3, '2019-04-07 19:10:41.000000', '2019-04-07 19:10:41.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 19:10:41.000000', '2019-04-07 19:10:41.000000');
INSERT INTO `tb_student_state` VALUES (116, 24, 168, 2, '2019-04-07 19:17:44.000000', '2019-04-07 19:17:44.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 19:17:44.000000', '2019-04-07 19:17:44.000000');
INSERT INTO `tb_student_state` VALUES (117, 25, 168, 4, '2019-04-07 19:17:44.000000', '2019-04-07 19:17:44.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 19:17:44.000000', '2019-04-07 19:17:44.000000');
INSERT INTO `tb_student_state` VALUES (118, 26, 168, 3, '2019-04-07 19:28:31.000000', '2019-04-07 19:28:31.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 19:28:31.000000', '2019-04-07 19:28:31.000000');
INSERT INTO `tb_student_state` VALUES (119, 27, 168, 1, '2019-04-07 19:28:31.000000', '2019-04-07 19:28:31.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 19:28:31.000000', '2019-04-07 19:28:31.000000');
INSERT INTO `tb_student_state` VALUES (120, 13, 168, 1, '2019-04-07 19:41:24.000000', '2019-04-07 19:41:24.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-07 19:41:24.000000', '2019-04-07 19:41:24.000000');
INSERT INTO `tb_student_state` VALUES (121, 14, 168, 4, '2019-04-07 19:41:24.000000', '2019-04-07 19:41:24.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-07 19:41:24.000000', '2019-04-07 19:41:24.000000');
INSERT INTO `tb_student_state` VALUES (124, 15, 168, 4, '2019-04-09 17:11:17.000000', '2019-04-09 17:11:17.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-09 17:11:17.000000', '2019-04-09 17:11:17.000000');
INSERT INTO `tb_student_state` VALUES (125, 16, 168, 1, '2019-04-09 17:11:17.000000', '2019-04-09 17:11:17.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 17:11:17.000000', '2019-04-09 17:11:17.000000');
INSERT INTO `tb_student_state` VALUES (126, 17, 168, 3, '2019-04-09 17:26:28.000000', '2019-04-09 17:26:28.000000', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-09 17:26:28.000000', '2019-04-09 17:26:28.000000');
INSERT INTO `tb_student_state` VALUES (127, 18, 168, 1, '2019-04-09 17:26:28.000000', '2019-04-09 17:26:28.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 17:26:28.000000', '2019-04-09 17:26:28.000000');
INSERT INTO `tb_student_state` VALUES (128, 19, 168, 2, '2019-04-09 17:32:22.000110', '2019-04-09 17:32:22.100100', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-04-09 17:32:22.000000', '2019-04-09 17:32:22.000000');
INSERT INTO `tb_student_state` VALUES (129, 20, 168, 1, '2019-04-09 17:32:22.000000', '2019-04-09 17:32:22.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 17:32:22.000000', '2019-04-09 17:32:22.000000');
INSERT INTO `tb_student_state` VALUES (130, 21, 178, 1, '2019-04-09 17:32:22.100220', '2019-04-09 17:32:22.030400', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 17:32:22.000000', '2019-04-09 17:32:22.000000');
INSERT INTO `tb_student_state` VALUES (131, 22, 187, 4, '2019-04-09 20:17:56.000000', '2019-04-09 20:17:56.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 20:17:56.000000', '2019-04-09 20:17:56.000000');
INSERT INTO `tb_student_state` VALUES (132, 21, 187, 3, '2019-04-09 20:19:46.000000', '2019-04-09 20:19:46.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 20:19:46.000000', '2019-04-09 20:19:46.000000');
INSERT INTO `tb_student_state` VALUES (133, 21, 187, 1, '2019-04-09 20:25:40.000000', '2019-04-09 20:25:40.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 20:25:40.000000', '2019-04-09 20:25:40.000000');
INSERT INTO `tb_student_state` VALUES (134, 21, 187, 1, '2019-04-09 20:31:34.000000', '2019-04-09 20:31:34.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 20:31:34.000000', '2019-04-09 20:31:34.000000');
INSERT INTO `tb_student_state` VALUES (135, 21, 187, 3, '2019-04-09 21:34:05.000000', '2019-04-09 21:34:05.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 21:34:05.000000', '2019-04-09 21:34:05.000000');
INSERT INTO `tb_student_state` VALUES (136, 21, 187, 1, '2019-04-09 21:39:58.000000', '2019-04-09 21:39:58.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 21:39:58.000000', '2019-04-09 21:39:58.000000');
INSERT INTO `tb_student_state` VALUES (137, 21, 187, 3, '2019-04-09 23:42:20.000000', '2019-04-09 23:42:20.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-09 23:42:20.000000', '2019-04-09 23:42:20.000000');
INSERT INTO `tb_student_state` VALUES (138, 1, 187, 4, '2019-04-10 00:07:57.000000', '2019-04-10 00:07:57.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-10 00:07:57.000000', '2019-04-10 00:07:57.000000');
INSERT INTO `tb_student_state` VALUES (139, 2, 187, 2, '2019-04-12 14:14:27.000000', '2019-04-12 14:14:27.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 14:14:27.000000', '2019-04-12 14:14:27.000000');
INSERT INTO `tb_student_state` VALUES (140, 3, 187, 1, '2019-04-12 15:34:40.000000', '2019-04-12 15:34:40.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 15:34:40.000000', '2019-04-12 15:34:40.000000');
INSERT INTO `tb_student_state` VALUES (141, 4, 187, 3, '2019-04-12 16:08:43.000000', '2019-04-12 16:08:43.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-12 16:08:43.000000', '2019-04-12 16:08:43.000000');
INSERT INTO `tb_student_state` VALUES (142, 5, 187, 3, '2019-04-12 16:08:44.000000', '2019-04-12 16:08:44.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 16:08:44.000000', '2019-04-12 16:08:44.000000');
INSERT INTO `tb_student_state` VALUES (143, 6, 187, 1, '2019-04-12 16:15:40.000000', '2019-04-12 16:15:40.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-12 16:15:40.000000', '2019-04-12 16:15:40.000000');
INSERT INTO `tb_student_state` VALUES (144, 7, 187, 1, '2019-04-12 16:15:40.000000', '2019-04-12 16:15:40.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 16:15:40.000000', '2019-04-12 16:15:40.000000');
INSERT INTO `tb_student_state` VALUES (145, 8, 187, 2, '2019-04-12 16:22:36.000000', '2019-04-12 16:22:36.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-12 16:22:36.000000', '2019-04-12 16:22:36.000000');
INSERT INTO `tb_student_state` VALUES (146, 9, 187, 1, '2019-04-12 16:22:37.000000', '2019-04-12 16:22:37.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 16:22:37.000000', '2019-04-12 16:22:37.000000');
INSERT INTO `tb_student_state` VALUES (147, 10, 187, 3, '2019-04-12 16:29:33.000000', '2019-04-12 16:29:33.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-12 16:29:33.000000', '2019-04-12 16:29:33.000000');
INSERT INTO `tb_student_state` VALUES (148, 11, 187, 3, '2019-04-12 16:29:33.000000', '2019-04-12 16:29:33.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 16:29:33.000000', '2019-04-12 16:29:33.000000');
INSERT INTO `tb_student_state` VALUES (149, 12, 187, 4, '2019-04-12 16:36:32.000000', '2019-04-12 16:36:32.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-12 16:36:32.000000', '2019-04-12 16:36:32.000000');
INSERT INTO `tb_student_state` VALUES (150, 13, 187, 3, '2019-04-12 16:36:32.000000', '2019-04-12 16:36:32.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-12 16:36:32.000000', '2019-04-12 16:36:32.000000');
INSERT INTO `tb_student_state` VALUES (151, 1, 176, 3, '2019-04-24 12:55:19.000000', '2019-04-24 12:55:19.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-04-24 12:55:19.000000', '2019-04-24 12:55:19.000000');
INSERT INTO `tb_student_state` VALUES (152, 1, 176, 4, '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000');
INSERT INTO `tb_student_state` VALUES (153, 3, 176, 3, '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000');
INSERT INTO `tb_student_state` VALUES (154, 4, 176, 3, '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000', 'b99004ab1f39797cee47b46830540d03', '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000');
INSERT INTO `tb_student_state` VALUES (155, 5, 176, 4, '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-04-24 12:55:20.000000', '2019-04-24 12:55:20.000000');
INSERT INTO `tb_student_state` VALUES (156, 12, 176, 1, '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000');
INSERT INTO `tb_student_state` VALUES (157, 14, 176, 1, '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000');
INSERT INTO `tb_student_state` VALUES (158, 5, 176, 3, '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000');
INSERT INTO `tb_student_state` VALUES (159, 6, 176, 3, '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000');
INSERT INTO `tb_student_state` VALUES (160, 7, 176, 4, '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-04-24 12:55:21.000000', '2019-04-24 12:55:21.000000');
INSERT INTO `tb_student_state` VALUES (161, 8, 176, 3, '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000');
INSERT INTO `tb_student_state` VALUES (162, 9, 176, 3, '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000');
INSERT INTO `tb_student_state` VALUES (163, 10, 176, 1, '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-11 10:30:44.000000', '2019-05-11 10:30:44.000000');
INSERT INTO `tb_student_state` VALUES (164, 11, 176, 2, '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000');
INSERT INTO `tb_student_state` VALUES (165, 12, 176, 2, '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000');
INSERT INTO `tb_student_state` VALUES (166, 13, 176, 4, '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000');
INSERT INTO `tb_student_state` VALUES (167, 14, 176, 1, '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-11 10:30:45.000000', '2019-05-11 10:30:45.000000');
INSERT INTO `tb_student_state` VALUES (168, 6, 176, 2, '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000');
INSERT INTO `tb_student_state` VALUES (169, 3, 176, 1, '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000');
INSERT INTO `tb_student_state` VALUES (170, 4, 176, 4, '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-11 10:30:46.000000', '2019-05-11 10:30:46.000000');
INSERT INTO `tb_student_state` VALUES (171, 5, 176, 3, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (172, 6, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (173, 7, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (174, 8, 176, 2, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (175, 9, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (176, 10, 176, 2, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (177, 11, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (178, 12, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (179, 13, 176, 4, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (180, 14, 176, 2, '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-13 20:23:13.000000', '2019-05-13 20:23:13.000000');
INSERT INTO `tb_student_state` VALUES (181, 15, 176, 3, '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000');
INSERT INTO `tb_student_state` VALUES (182, 16, 176, 3, '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000');
INSERT INTO `tb_student_state` VALUES (183, 17, 176, 2, '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-13 20:30:08.000000', '2019-05-13 20:30:08.000000');
INSERT INTO `tb_student_state` VALUES (184, 18, 176, 4, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (185, 19, 176, 4, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (186, 20, 176, 4, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (187, 95, 176, 2, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (188, 87, 176, 4, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (189, 94, 176, 1, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (190, 93, 176, 3, '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-13 20:30:09.000000', '2019-05-13 20:30:09.000000');
INSERT INTO `tb_student_state` VALUES (191, 83, 176, 2, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (192, 77, 176, 3, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (193, 76, 176, 3, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (194, 71, 176, 3, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (195, 103, 176, 3, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (196, 80, 176, 1, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (197, 95, 176, 1, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (198, 87, 176, 2, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (199, 94, 176, 2, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (200, 93, 176, 3, '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-13 20:37:04.000000', '2019-05-13 20:37:04.000000');
INSERT INTO `tb_student_state` VALUES (201, 83, 176, 1, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (202, 77, 176, 1, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (203, 76, 176, 3, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (204, 71, 176, 1, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (205, 103, 176, 4, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (206, 80, 176, 2, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (207, 95, 176, 3, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (208, 87, 176, 3, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (209, 94, 176, 4, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (210, 93, 176, 3, '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-13 20:43:59.000000', '2019-05-13 20:43:59.000000');
INSERT INTO `tb_student_state` VALUES (211, 83, 176, 1, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (212, 77, 176, 4, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (213, 76, 176, 1, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (214, 71, 176, 4, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (215, 103, 176, 1, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (216, 80, 176, 2, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (217, 95, 176, 2, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (218, 87, 176, 3, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (219, 94, 176, 3, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (220, 93, 176, 1, '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-13 20:50:54.000000', '2019-05-13 20:50:54.000000');
INSERT INTO `tb_student_state` VALUES (221, 83, 176, 4, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (222, 77, 176, 3, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (223, 76, 176, 2, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (224, 71, 176, 1, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (225, 103, 176, 1, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (226, 80, 176, 3, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (227, 95, 176, 4, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (228, 87, 176, 3, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (229, 94, 176, 4, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (230, 93, 176, 4, '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-14 20:02:51.000000', '2019-05-14 20:02:51.000000');
INSERT INTO `tb_student_state` VALUES (231, 83, 176, 3, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (232, 77, 176, 1, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (233, 76, 176, 1, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (234, 71, 176, 2, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (235, 103, 176, 2, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (236, 80, 176, 4, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (237, 95, 176, 3, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (238, 87, 176, 1, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (239, 94, 176, 1, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (240, 93, 176, 1, '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-14 20:09:46.000000', '2019-05-14 20:09:46.000000');
INSERT INTO `tb_student_state` VALUES (241, 83, 176, 2, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (242, 77, 176, 2, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (243, 76, 176, 2, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (244, 71, 176, 1, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (245, 103, 176, 1, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (246, 80, 176, 3, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (247, 95, 176, 4, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (248, 87, 176, 2, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (249, 94, 176, 1, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (250, 93, 176, 2, '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-14 20:16:41.000000', '2019-05-14 20:16:41.000000');
INSERT INTO `tb_student_state` VALUES (251, 83, 176, 4, '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000');
INSERT INTO `tb_student_state` VALUES (252, 77, 176, 1, '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000');
INSERT INTO `tb_student_state` VALUES (253, 76, 176, 2, '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-14 20:23:36.000000', '2019-05-14 20:23:36.000000');
INSERT INTO `tb_student_state` VALUES (254, 71, 176, 4, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (255, 103, 176, 1, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (256, 80, 176, 1, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (257, 95, 176, 1, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (258, 87, 176, 3, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (259, 1, 176, 3, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (260, 2, 176, 3, '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-14 20:23:37.000000', '2019-05-14 20:23:37.000000');
INSERT INTO `tb_student_state` VALUES (261, 3, 176, 3, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (262, 4, 176, 3, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (263, 21, 176, 2, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (264, 22, 176, 2, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (265, 23, 176, 1, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (266, 24, 176, 3, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (267, 25, 176, 3, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (268, 26, 176, 1, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (269, 27, 176, 2, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (270, 28, 176, 4, '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-14 20:30:32.000000', '2019-05-14 20:30:32.000000');
INSERT INTO `tb_student_state` VALUES (271, 83, 176, 1, '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000');
INSERT INTO `tb_student_state` VALUES (272, 77, 176, 1, '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000');
INSERT INTO `tb_student_state` VALUES (273, 76, 176, 2, '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 20:14:09.000000', '2019-05-15 20:14:09.000000');
INSERT INTO `tb_student_state` VALUES (274, 71, 176, 3, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (275, 103, 176, 2, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (276, 80, 176, 3, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (277, 95, 176, 2, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (278, 87, 176, 3, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (279, 94, 176, 4, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (280, 93, 176, 3, '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 20:14:10.000000', '2019-05-15 20:14:10.000000');
INSERT INTO `tb_student_state` VALUES (281, 83, 176, 2, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (282, 77, 176, 4, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (283, 76, 176, 4, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (284, 71, 176, 3, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (285, 103, 176, 3, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (286, 80, 176, 1, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (287, 95, 176, 3, '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 20:21:08.000000', '2019-05-15 20:21:08.000000');
INSERT INTO `tb_student_state` VALUES (288, 87, 176, 3, '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000');
INSERT INTO `tb_student_state` VALUES (289, 94, 176, 1, '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000');
INSERT INTO `tb_student_state` VALUES (290, 93, 176, 3, '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 20:21:09.000000', '2019-05-15 20:21:09.000000');
INSERT INTO `tb_student_state` VALUES (291, 83, 176, 2, '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000');
INSERT INTO `tb_student_state` VALUES (292, 77, 176, 1, '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000');
INSERT INTO `tb_student_state` VALUES (293, 76, 176, 1, '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000');
INSERT INTO `tb_student_state` VALUES (294, 71, 176, 4, '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 20:28:06.000000', '2019-05-15 20:28:06.000000');
INSERT INTO `tb_student_state` VALUES (295, 103, 176, 3, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (296, 80, 176, 2, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (297, 95, 176, 1, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (298, 87, 176, 4, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (299, 94, 176, 2, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (300, 93, 176, 3, '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 20:28:07.000000', '2019-05-15 20:28:07.000000');
INSERT INTO `tb_student_state` VALUES (301, 83, 176, 2, '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000');
INSERT INTO `tb_student_state` VALUES (302, 77, 176, 3, '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000');
INSERT INTO `tb_student_state` VALUES (303, 76, 176, 1, '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 20:51:07.000000', '2019-05-15 20:51:07.000000');
INSERT INTO `tb_student_state` VALUES (304, 71, 176, 3, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (305, 103, 176, 3, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (306, 80, 176, 1, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (307, 95, 176, 1, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (308, 87, 176, 3, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (309, 94, 176, 2, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (310, 93, 176, 3, '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 20:51:08.000000', '2019-05-15 20:51:08.000000');
INSERT INTO `tb_student_state` VALUES (311, 83, 176, 1, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (312, 77, 176, 3, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (313, 76, 176, 4, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (314, 71, 176, 3, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (315, 103, 176, 3, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (316, 80, 176, 1, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (317, 95, 176, 4, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (318, 87, 176, 1, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (319, 94, 176, 1, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (320, 93, 176, 2, '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 23:26:05.000000', '2019-05-15 23:26:05.000000');
INSERT INTO `tb_student_state` VALUES (321, 83, 176, 4, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (322, 77, 176, 2, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (323, 76, 176, 2, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (324, 71, 176, 3, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (325, 103, 176, 3, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (326, 80, 176, 2, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (327, 95, 176, 4, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (328, 87, 176, 1, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (329, 94, 176, 3, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (330, 93, 176, 3, '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 23:33:01.000000', '2019-05-15 23:33:01.000000');
INSERT INTO `tb_student_state` VALUES (331, 83, 176, 4, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (332, 77, 176, 2, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (333, 76, 176, 3, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (334, 71, 176, 4, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (335, 103, 176, 4, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (336, 80, 176, 1, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (337, 95, 176, 2, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (338, 87, 176, 4, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (339, 94, 176, 1, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (340, 93, 176, 4, '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 23:39:56.000000', '2019-05-15 23:39:56.000000');
INSERT INTO `tb_student_state` VALUES (341, 83, 176, 4, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (342, 77, 176, 4, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (343, 76, 176, 3, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (344, 71, 176, 4, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (345, 103, 176, 4, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (346, 80, 176, 4, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (347, 95, 176, 2, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (348, 87, 176, 1, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (349, 94, 176, 2, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (350, 93, 176, 1, '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 23:46:51.000000', '2019-05-15 23:46:51.000000');
INSERT INTO `tb_student_state` VALUES (351, 83, 176, 3, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (352, 77, 176, 2, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (353, 76, 176, 2, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (354, 71, 176, 4, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (355, 103, 176, 4, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (356, 80, 176, 4, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (357, 95, 176, 1, '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-15 23:53:46.000000', '2019-05-15 23:53:46.000000');
INSERT INTO `tb_student_state` VALUES (358, 87, 176, 1, '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000');
INSERT INTO `tb_student_state` VALUES (359, 94, 176, 3, '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000');
INSERT INTO `tb_student_state` VALUES (360, 93, 176, 2, '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-15 23:53:47.000000', '2019-05-15 23:53:47.000000');
INSERT INTO `tb_student_state` VALUES (361, 83, 176, 1, '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000');
INSERT INTO `tb_student_state` VALUES (362, 77, 176, 1, '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000');
INSERT INTO `tb_student_state` VALUES (363, 76, 176, 1, '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000');
INSERT INTO `tb_student_state` VALUES (364, 71, 176, 4, '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-17 23:03:04.000000', '2019-05-17 23:03:04.000000');
INSERT INTO `tb_student_state` VALUES (365, 103, 176, 4, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (366, 80, 176, 1, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (367, 95, 176, 3, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (368, 87, 176, 3, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (369, 94, 176, 3, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (370, 93, 176, 4, '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-17 23:03:05.000000', '2019-05-17 23:03:05.000000');
INSERT INTO `tb_student_state` VALUES (371, 83, 176, 3, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (372, 77, 176, 3, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (373, 76, 176, 3, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (374, 71, 176, 4, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (375, 103, 176, 2, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (376, 80, 176, 2, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (377, 95, 176, 4, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (378, 87, 176, 1, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (379, 94, 176, 3, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (380, 93, 176, 1, '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-17 23:10:00.000000', '2019-05-17 23:10:00.000000');
INSERT INTO `tb_student_state` VALUES (381, 83, 176, 2, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (382, 77, 176, 4, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (383, 76, 176, 2, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (384, 71, 176, 3, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (385, 103, 176, 1, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (386, 80, 176, 3, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (387, 95, 176, 3, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (388, 87, 176, 1, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (389, 94, 176, 1, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (390, 93, 176, 2, '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-17 23:16:56.000000', '2019-05-17 23:16:56.000000');
INSERT INTO `tb_student_state` VALUES (391, 83, 176, 3, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (392, 77, 176, 1, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (393, 76, 176, 3, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (394, 71, 176, 4, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (395, 103, 176, 4, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (396, 80, 176, 1, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (397, 95, 176, 3, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (398, 87, 176, 1, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (399, 94, 176, 1, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (400, 93, 176, 2, '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-17 23:23:51.000000', '2019-05-17 23:23:51.000000');
INSERT INTO `tb_student_state` VALUES (401, 83, 176, 1, '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000');
INSERT INTO `tb_student_state` VALUES (402, 77, 176, 2, '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000');
INSERT INTO `tb_student_state` VALUES (403, 76, 176, 1, '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-05-17 23:30:46.000000', '2019-05-17 23:30:46.000000');
INSERT INTO `tb_student_state` VALUES (404, 71, 176, 1, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', 'b99004ab1f39797cee47b46830540d03', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (405, 23, 176, 1, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (406, 80, 176, 3, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', '271218d7cd58589a1510efe7eb1e4554', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (407, 95, 176, 4, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (408, 87, 176, 1, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (409, 94, 176, 2, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', 'd63843d9d0ecc28e480c710846993c8e', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (410, 93, 176, 4, '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-05-17 23:30:47.000000', '2019-05-17 23:30:47.000000');
INSERT INTO `tb_student_state` VALUES (411, 77, 176, 2, '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000');
INSERT INTO `tb_student_state` VALUES (412, 87, 176, 3, '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000', '7d2fcf0d7d983da1d1dda586352d3132', '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000');
INSERT INTO `tb_student_state` VALUES (413, 23, 176, 2, '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000');
INSERT INTO `tb_student_state` VALUES (414, 83, 176, 3, '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000');
INSERT INTO `tb_student_state` VALUES (415, 93, 176, 2, '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-07-08 02:01:53.000000', '2019-07-08 02:01:53.000000');
INSERT INTO `tb_student_state` VALUES (416, 76, 176, 1, '2019-07-08 02:01:54.000000', '2019-07-08 02:01:54.000000', '3a0bddf4fb415256344df4e2a4203cbe', '2019-07-08 02:01:54.000000', '2019-07-08 02:01:54.000000');
INSERT INTO `tb_student_state` VALUES (417, 71, 176, 3, '2019-07-08 02:01:54.000000', '2019-07-08 02:01:54.000000', 'b99004ab1f39797cee47b46830540d03', '2019-07-08 02:01:54.000000', '2019-07-08 02:01:54.000000');
INSERT INTO `tb_student_state` VALUES (418, 38, 1, 2, '2019-10-30 13:42:44.000000', '2019-10-30 13:42:44.000000', '123sad', '2019-10-30 13:42:44.000000', '2019-10-30 13:42:44.000000');
INSERT INTO `tb_student_state` VALUES (419, 38, 1, 2, '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000', '123sad', '2019-10-31 17:03:05.000000', '2019-10-31 17:03:05.000000');
INSERT INTO `tb_student_state` VALUES (420, 38, 1, 2, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000', '123sad', '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');
INSERT INTO `tb_student_state` VALUES (421, 38, 1, 2, '2019-11-17 17:22:11.000000', '2019-11-17 17:22:11.000000', '123sad', '2019-11-17 17:22:11.000000', '2019-11-17 17:22:11.000000');
INSERT INTO `tb_student_state` VALUES (422, 38, 1, 2, '2019-11-17 18:46:03.000000', '2019-11-17 18:46:03.000000', '123sad', '2019-11-17 18:46:03.000000', '2019-11-17 18:46:03.000000');
INSERT INTO `tb_student_state` VALUES (423, 38, 1, 2, '2019-11-17 18:46:50.000000', '2019-11-17 18:46:50.000000', '123sad', '2019-11-17 18:46:50.000000', '2019-11-17 18:46:50.000000');
INSERT INTO `tb_student_state` VALUES (424, 38, 1, 2, '2019-11-17 18:47:56.000000', '2019-11-17 18:47:56.000000', '123sad', '2019-11-17 18:47:56.000000', '2019-11-17 18:47:56.000000');
INSERT INTO `tb_student_state` VALUES (425, 38, 1, 2, '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000', '123sad', '2019-11-17 18:48:27.000000', '2019-11-17 18:48:27.000000');
INSERT INTO `tb_student_state` VALUES (426, 38, 1, 2, '2019-11-17 18:49:08.000000', '2019-11-17 18:49:08.000000', '123sad', '2019-11-17 18:49:08.000000', '2019-11-17 18:49:08.000000');

-- ----------------------------
-- Table structure for tb_teacher_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher_lesson`;
CREATE TABLE `tb_teacher_lesson`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `lesson_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '课时id',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(6) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_lesson_id`(`lesson_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_lesson_id`(`lesson_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher_lesson
-- ----------------------------
INSERT INTO `tb_teacher_lesson` VALUES (31, 33, 1, '2019-04-05 18:05:44.000000', '2019-04-05 18:05:44.000000');
INSERT INTO `tb_teacher_lesson` VALUES (33, 34, 3, '2019-04-07 15:56:52.000000', '2019-04-07 15:56:52.000000');
INSERT INTO `tb_teacher_lesson` VALUES (34, 34, 4, '2019-04-07 17:16:20.000000', '2019-04-07 17:16:20.000000');
INSERT INTO `tb_teacher_lesson` VALUES (70, 34, 5, '2019-04-09 17:45:43.000000', '2019-04-09 17:45:43.000000');
INSERT INTO `tb_teacher_lesson` VALUES (71, 35, 6, '2019-04-09 17:46:09.000000', '2019-04-09 17:46:09.000000');
INSERT INTO `tb_teacher_lesson` VALUES (72, 35, 7, '2019-04-09 17:46:40.000000', '2019-04-09 17:46:40.000000');
INSERT INTO `tb_teacher_lesson` VALUES (73, 35, 8, '2019-04-09 17:51:13.000000', '2019-04-09 17:51:13.000000');
INSERT INTO `tb_teacher_lesson` VALUES (74, 35, 9, '2019-04-09 17:51:45.000000', '2019-04-09 17:51:45.000000');
INSERT INTO `tb_teacher_lesson` VALUES (75, NULL, NULL, '2019-04-09 17:52:14.000000', '2019-04-09 17:52:14.000000');
INSERT INTO `tb_teacher_lesson` VALUES (76, NULL, NULL, '2019-04-09 17:52:42.000000', '2019-04-09 17:52:42.000000');
INSERT INTO `tb_teacher_lesson` VALUES (77, NULL, NULL, '2019-04-09 17:53:09.000000', '2019-04-09 17:53:09.000000');
INSERT INTO `tb_teacher_lesson` VALUES (81, NULL, NULL, '2019-04-11 20:56:34.000000', '2019-04-11 20:56:34.000000');
INSERT INTO `tb_teacher_lesson` VALUES (82, 36, 14, '2019-04-11 20:57:52.000000', '2019-04-11 20:57:52.000000');
INSERT INTO `tb_teacher_lesson` VALUES (83, 37, 15, '2019-04-11 21:08:58.000000', '2019-04-11 21:08:58.000000');
INSERT INTO `tb_teacher_lesson` VALUES (85, 37, 16, '2019-04-12 23:39:39.000000', '2019-04-12 23:39:39.000000');
INSERT INTO `tb_teacher_lesson` VALUES (86, 38, 17, '2019-05-11 10:21:13.000000', '2019-05-11 10:21:13.000000');
INSERT INTO `tb_teacher_lesson` VALUES (87, 38, 18, '2019-05-11 10:53:00.000000', '2019-05-11 10:53:00.000000');
INSERT INTO `tb_teacher_lesson` VALUES (88, 39, 19, '2019-05-14 19:58:13.000000', '2019-05-14 19:58:13.000000');
INSERT INTO `tb_teacher_lesson` VALUES (91, 39, 20, '2019-08-05 22:06:53.000000', '2019-08-05 22:06:53.000000');
INSERT INTO `tb_teacher_lesson` VALUES (92, 40, 21, '2019-10-16 14:37:55.000000', '2019-10-16 14:37:55.000000');
INSERT INTO `tb_teacher_lesson` VALUES (93, 40, 22, '2019-10-30 13:42:44.000000', '2019-10-30 13:42:44.000000');
INSERT INTO `tb_teacher_lesson` VALUES (94, 33, 33, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_teacher_lesson` VALUES (98, NULL, NULL, NULL, NULL);
INSERT INTO `tb_teacher_lesson` VALUES (99, NULL, NULL, NULL, NULL);
INSERT INTO `tb_teacher_lesson` VALUES (103, 33, 253, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_teacher_lesson` VALUES (107, 33, 262, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_teacher_lesson` VALUES (108, 1, 2, '2019-11-17 17:18:12.000000', '2019-11-17 17:18:12.000000');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `academy_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `class_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `type` int(11) UNSIGNED NOT NULL COMMENT '用户类别',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `id_card_number` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人脸照片',
  `face_token` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人脸标识',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `modify_time` datetime(6) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_number`(`number`) USING BTREE,
  UNIQUE INDEX `uk_id_card_number`(`id_card_number`) USING BTREE,
  UNIQUE INDEX `uk_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `uk_mail`(`mail`) USING BTREE,
  UNIQUE INDEX `uk_picture`(`picture`) USING BTREE,
  UNIQUE INDEX `uk_face_token`(`face_token`) USING BTREE,
  INDEX `idx_type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 2, 1, '1812630715', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '程新月', 2, '男', '320586199901011112', '17715939829', '1527215026@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554820249936&di=8871a4e90aed756b0179b2b241a5c2bc&imgtype=0&src=http%3A%2F%2Fimg.cwq.com%2F201612%2F1482144508944947.jpeg', 'sa65d6as53ds2a32', '2019-01-21 18:52:54.000000', '2019-05-17 22:28:01.000000');
INSERT INTO `tb_user` VALUES (2, 2, 1, '1812630901', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '陈丹青', 3, '男', '1812630901', '18126309011', '1812630901@qq.com', 'http://123.206.53.234/yctc/1812630901.jpg', 'b99004ab1f39797cee47b46830540d03', '2019-01-25 13:37:29.000000', '2019-04-09 21:30:20.000000');
INSERT INTO `tb_user` VALUES (3, 2, 1, '1812630902', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '蔡天新', 2, '男', '1812630902', '1812630902', '1812630902@qq.com', 'http://123.206.53.234/yctc/1812630902.jpg', '94945f66815c26a30f04781294f2664f', '2019-01-25 13:37:29.000000', '2019-04-09 20:28:58.000000');
INSERT INTO `tb_user` VALUES (4, 2, 1, '1812630904', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '郭震海', 2, '男', '1812630904', '1812630904', '1812630904@qq.com', 'http://123.206.53.234/yctc/1812630904.jpg', 'a5ac00c998132d3397c96838b0e536a4', '2019-01-25 13:37:30.000000', '2019-04-12 15:59:30.000000');
INSERT INTO `tb_user` VALUES (5, 2, 1, '1812630905', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '程鹤麟', 2, '男', '1812630905', '1812630905', '1812630905@qq.com', 'http://123.206.53.234/yctc/1812630905.jpg', 'fecf36ef587329c122dbcd59ea8d7679', '2019-01-25 13:37:30.000000', '2019-04-06 15:03:44.000000');
INSERT INTO `tb_user` VALUES (6, 2, 2, '1812630906', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '何亚娟', 2, '女', '1812630906', '1812630906', '1812630906@qq.com', 'http://123.206.53.234/yctc/1812630906.jpg', '3a0bddf4fb415256344df4e2a4203cbe', '2019-01-25 13:37:30.000000', '2019-04-06 15:03:55.000000');
INSERT INTO `tb_user` VALUES (7, 2, 2, '1812630907', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '杜平让', 2, '女', '1812630907', '1812630907', '1812630907@qq.com', 'http://123.206.53.234/yctc/1812630907.jpg', '64ba393ee94b1c7779ef8be56dedf2ca', '2019-01-25 13:37:30.000000', '2019-04-06 15:04:07.000000');
INSERT INTO `tb_user` VALUES (8, 2, 2, '1812630908', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '崔卫平', 2, '女', '1812630908', '1812630908', '1812630908@qq.com', 'http://123.206.53.234/yctc/1812630908.jpg', 'f46dbfe1e255c6ac0bce8146638875c0', '2019-01-25 13:37:30.000000', '2019-04-06 15:04:18.000000');
INSERT INTO `tb_user` VALUES (9, 2, 2, '1812630909', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '程一身', 2, '女', '1812630909', '18126309099', '1812630909@qq.com', 'http://123.206.53.234/yctc/1812630909.jpg', '95677fd03a94963e917645819a700df2', '2019-01-25 13:37:30.000000', '2019-04-06 15:04:30.000000');
INSERT INTO `tb_user` VALUES (10, 2, 2, '1812630910', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '高建华', 2, '女', '1812630910', '18126309100', '1812630910@qq.com', 'http://123.206.53.234/yctc/1812630910.jpg', '271218d7cd58589a1510efe7eb1e4554', '2019-01-25 13:38:49.000000', '2019-04-06 15:04:42.000000');
INSERT INTO `tb_user` VALUES (11, 2, 3, '1812630912', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '金文明', 2, '女', '1812630912', '18126309122', '1812630912@qq.com', 'http://123.206.53.234/yctc/1812630912.jpg', '9431b8c45e1c3dd22527999581c920b0', '2019-01-25 13:38:49.000000', '2019-04-06 15:11:38.000000');
INSERT INTO `tb_user` VALUES (12, 2, 3, '1812630913', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '葛剑', 2, '女', '1812630913', '1812630913', '1812630913@qq.com', 'http://123.206.53.234/yctc/1812630913.jpg', '57d70109c37a4d000fa97fec5ab6ce7d', '2019-01-25 13:38:49.000000', '2019-04-06 15:11:50.000000');
INSERT INTO `tb_user` VALUES (13, 2, 3, '1812630914', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '刘继兴 ', 2, '女', '1812630914', '17098044226', '873731696@qq.com', 'http://123.206.53.234/yctc/1812630914.jpg', '870cbc966c0877f480f3770dad10ef87', '2019-01-25 13:38:49.000000', '2019-04-06 15:18:19.000000');
INSERT INTO `tb_user` VALUES (14, 2, 3, '1812630915', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '江晓原', 2, '男', '1812630915', '1812630915', '1812630915@qq.com', 'http://123.206.53.234/yctc/1812630915.jpg', '95efa42b3d786ff6c19893d19af60cbb', '2019-01-25 13:38:49.000000', '2019-04-06 15:18:31.000000');
INSERT INTO `tb_user` VALUES (15, 2, 3, '1812630916', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '路佳瑄', 2, '男', '1812630916', '1812630916', '1812630916@qq.com', 'http://123.206.53.234/yctc/1812630916.jpg', '9b1e71e3e91ec50c3a1479d88856c24e', '2019-01-25 13:38:49.000000', '2019-04-06 15:18:44.000000');
INSERT INTO `tb_user` VALUES (16, 2, 4, '1812630917', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '高星', 2, '男', '1812630917', '1812630917', '1812630917@qq.com', 'http://123.206.53.234/yctc/1812630917.jpg', '7d2fcf0d7d983da1d1dda586352d3132', '2019-01-25 13:38:49.000000', '2019-04-06 15:18:55.000000');
INSERT INTO `tb_user` VALUES (17, 2, 4, '1812630918', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '巩高峰', 2, '男', '1812630918', '1812630918', '1812630918@qq.com', 'http://123.206.53.234/yctc/1812630918.jpg', 'ba04ee5201d4d8d834c5f713432006c5', '2019-01-25 13:38:50.000000', '2019-04-06 15:19:07.000000');
INSERT INTO `tb_user` VALUES (18, 2, 4, '1812630919', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '胡续冬', 2, '男', '1812630919', '1812630919', '1812630919@qq.com', 'http://123.206.53.234/yctc/1812630919.jpg', '05d5899a345ab1b323da70e36cfb9297', '2019-01-25 13:38:50.000000', '2019-04-06 15:19:19.000000');
INSERT INTO `tb_user` VALUES (19, 2, 4, '1812630920', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '李碧华', 2, '男', '1812630920', '18126309200', '1812630920@qq.com', 'http://123.206.53.234/yctc/1812630920.jpg', 'a245bc2ac26ed94fa85cc4185748be20', '2019-01-25 13:38:50.000000', '2019-04-06 15:19:30.000000');
INSERT INTO `tb_user` VALUES (20, 2, 4, '1812630921', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '冯志丹', 2, '男', '1812630921', '18126309211', '1812630921@qq.com', 'http://123.206.53.234/yctc/1812630921.jpg', 'f4b657a27b12a6ef6ffe323d708af84d', '2019-01-25 13:38:50.000000', '2019-04-06 15:19:43.000000');
INSERT INTO `tb_user` VALUES (21, 2, 5, '1812630922', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '傅光明', 2, '男', '1812630922', '1812630922', '1812630922@qq.com', 'http://123.206.53.234/yctc/1812630922.jpg', '202d5526387715feb729d7e1155ca72f', '2019-01-25 13:38:50.000000', '2019-04-06 15:19:54.000000');
INSERT INTO `tb_user` VALUES (22, 2, 5, '1812630923', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '李银河', 2, '男', '1812630923', '1812630923', '1812630923@qq.com', 'http://123.206.53.234/yctc/1812630923.jpg', '1ed8835863ffbdedf3b7ddc9336fee63', '2019-01-25 13:38:50.000000', '2019-04-06 15:20:06.000000');
INSERT INTO `tb_user` VALUES (23, 2, 5, '1812630924', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '陈众议', 2, '男', '1812630924', '1812630924', '1812630924@qq.com', 'http://123.206.53.234/yctc/1812630924.jpg', 'd63843d9d0ecc28e480c710846993c8e', '2019-01-25 13:38:50.000000', '2019-04-06 15:20:18.000000');
INSERT INTO `tb_user` VALUES (24, 2, 5, '1812630925', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '刘墉', 2, '男', '1812630925', '1812630925', '1812630925@qq.com', 'http://123.206.53.234/yctc/1812630925.jpg', 'b11a8406ad32630ff48080c99ecf4cfb', '2019-01-25 13:38:50.000000', '2019-04-06 15:20:29.000000');
INSERT INTO `tb_user` VALUES (25, 2, 5, '1812630928', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '韩雨山', 2, '男', '1812630928', '1812630928', '1812630928@qq.com', 'http://123.206.53.234/yctc/1812630928.jpg', '017c8dfa56b645f3b8209250bc151bff', '2019-01-25 13:38:51.000000', '2019-04-06 15:20:42.000000');
INSERT INTO `tb_user` VALUES (26, 2, 2, '1812630930', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '韩松落', 2, '男', '1812630930', '1812630930', '1812630930@qq.com', 'http://123.206.53.234/yctc/1812630930.jpg', 'fa3780e224f4712d0ae1a7939bb5b4f3', '2019-01-25 13:38:51.000000', '2019-04-06 15:20:53.000000');
INSERT INTO `tb_user` VALUES (27, 2, 2, '1812630933', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '恭小兵', 2, '男', '1812630933', '1812630933', '1812630933@qq.com', 'http://123.206.53.234/yctc/1812630933.jpg', 'f6dbaa1cdb3eca9fde3b9efced58a8e3', '2019-01-25 13:38:51.000000', '2019-04-06 15:21:06.000000');
INSERT INTO `tb_user` VALUES (28, 2, 2, '1812630934', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '关凌', 2, '男', '1812630934', '1812630934', '1812630934@qq.com', 'http://123.206.53.234/yctc/1812630934.jpg', 'fb083493e4ab96f725feb434c89f11f0', '2019-01-25 13:38:51.000000', '2019-04-06 15:21:19.000000');
INSERT INTO `tb_user` VALUES (29, 2, 2, '1812630935', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '高远', 2, '男', '1812630935', '1812630935', '1812630935@qq.com', 'http://123.206.53.234/yctc/1812630935.jpg', 'c14cfbbe34c456de49a3a350273fa802', '2019-01-25 13:38:51.000000', '2019-04-06 15:21:30.000000');
INSERT INTO `tb_user` VALUES (31, 1, NULL, '10001', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '管理员', 1, '男', '879656566532x', '17788888888', 'testTeacher@qq.com', NULL, NULL, '2019-02-02 00:00:00.000000', '2019-02-03 00:00:00.000000');
INSERT INTO `tb_user` VALUES (32, 2, 1, '10003', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '王小明', 1, '男', '879626566532x', '13789677568', '13789677568@163.com', NULL, NULL, '2019-10-29 22:13:10.000000', '2019-10-29 22:13:15.000000');
INSERT INTO `tb_user` VALUES (33, 2, 2, '10002', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '王小明', 1, '女', '879656566533x', '17788888883', '10002@qq.com', NULL, NULL, '2019-02-02 00:00:00.000000', '2019-02-03 00:00:00.000000');
INSERT INTO `tb_user` VALUES (34, 2, 3, '10004', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '冯小红', 1, '女', '879656576533x', '17788888884', '10004@qq.com', NULL, NULL, '2019-02-02 00:00:00.000000', '2019-02-03 00:00:00.000000');
INSERT INTO `tb_user` VALUES (35, 2, 4, '10005', '94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71', '梁用心', 1, '女', '879656166533x', '17788888885', '10005@qq.com', NULL, NULL, '2019-02-02 00:00:00.000000', '2019-02-03 00:00:00.000000');
INSERT INTO `tb_user` VALUES (134, 2, 2, '00001', 'd4735e3a265e16eee03f59718b9b5d03019c07d8b6c51f90da3a666eec13ab35', 'Administrator', 3, '男', '12345', '18816236008', 'wanglt1234@126.com', '22', 'ccc', '2019-02-13 14:02:55.000000', '2019-06-16 20:37:04.000000');
INSERT INTO `tb_user` VALUES (274, 2, 2, '17263829', '4cc8f4d609b717356701c57a03e737e5ac8fe885da8c7163d3de47e01849c635', 'tony', 1, '男', 'lsakdlaskd', '1195656', '6565sd65', '123as98d9a8', '321s9a8d9', '2019-11-17 17:18:13.000000', '2019-11-17 17:18:13.000000');

-- ----------------------------
-- Table structure for tb_user_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_news`;
CREATE TABLE `tb_user_news`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `news_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '消息id',
  `state` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '阅读状态',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(6) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_id_news_id`(`user_id`, `news_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_news_id`(`news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = big5 COLLATE = big5_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_news
-- ----------------------------
INSERT INTO `tb_user_news` VALUES (96, 16, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (97, 17, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (98, 18, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (99, 19, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (100, 20, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (101, 21, 53, 0, '2019-10-31 15:58:40.000000', '2019-10-31 15:58:40.000000');
INSERT INTO `tb_user_news` VALUES (102, 38, 1, 0, '2019-10-31 17:03:06.000000', '2019-11-17 18:46:51.000000');
INSERT INTO `tb_user_news` VALUES (103, 16, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (104, 17, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (105, 18, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (106, 19, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (107, 20, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (108, 21, 55, 0, '2019-10-31 23:31:50.000000', '2019-10-31 23:31:50.000000');
INSERT INTO `tb_user_news` VALUES (109, 1, 56, 0, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_user_news` VALUES (110, 2, 56, 0, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_user_news` VALUES (111, 3, 56, 0, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_user_news` VALUES (112, 4, 56, 0, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_user_news` VALUES (113, 5, 56, 0, '2019-10-31 23:42:12.000000', '2019-10-31 23:42:12.000000');
INSERT INTO `tb_user_news` VALUES (114, 1, 57, 0, '2019-11-01 12:47:18.000000', '2019-11-01 12:47:18.000000');
INSERT INTO `tb_user_news` VALUES (115, 1, 58, 0, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_user_news` VALUES (116, 2, 58, 0, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_user_news` VALUES (117, 3, 58, 0, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_user_news` VALUES (118, 4, 58, 0, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_user_news` VALUES (119, 5, 58, 0, '2019-11-01 15:05:01.000000', '2019-11-01 15:05:01.000000');
INSERT INTO `tb_user_news` VALUES (120, 1, 59, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_user_news` VALUES (121, 2, 59, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_user_news` VALUES (122, 3, 59, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_user_news` VALUES (123, 4, 59, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_user_news` VALUES (124, 5, 59, 0, '2019-11-01 15:44:37.000000', '2019-11-01 15:44:37.000000');
INSERT INTO `tb_user_news` VALUES (125, 1, 60, 0, '2019-11-02 14:16:47.000000', '2019-11-02 14:16:47.000000');
INSERT INTO `tb_user_news` VALUES (126, 16, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (127, 17, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (128, 18, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (129, 19, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (130, 20, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (131, 21, 61, 0, '2019-11-02 14:21:32.000000', '2019-11-02 14:21:32.000000');
INSERT INTO `tb_user_news` VALUES (132, 31, 62, 1, NULL, NULL);
INSERT INTO `tb_user_news` VALUES (133, 33, 62, 1, NULL, '2019-11-06 13:38:55.000000');
INSERT INTO `tb_user_news` VALUES (134, 16, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (135, 17, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (136, 18, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (137, 19, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (138, 20, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (139, 21, 64, 0, '2019-11-03 14:34:58.000000', '2019-11-03 14:34:58.000000');
INSERT INTO `tb_user_news` VALUES (140, 16, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_user_news` VALUES (141, 17, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_user_news` VALUES (142, 18, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_user_news` VALUES (143, 19, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_user_news` VALUES (144, 20, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');
INSERT INTO `tb_user_news` VALUES (145, 21, 65, 0, '2019-11-10 14:33:58.000000', '2019-11-10 14:33:58.000000');

SET FOREIGN_KEY_CHECKS = 1;
