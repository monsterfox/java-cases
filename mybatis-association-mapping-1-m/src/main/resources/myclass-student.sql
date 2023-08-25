-- ----------------------------
-- Table structure for myclass
-- ----------------------------
DROP TABLE IF EXISTS `myclass`;
CREATE TABLE `myclass` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `class_name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myclass
-- ----------------------------
INSERT INTO `myclass` VALUES ('1', '一班');
INSERT INTO `myclass` VALUES ('2', '二班');
INSERT INTO `myclass` VALUES ('3', '三班');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           `cid` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '1');
INSERT INTO `student` VALUES ('2', '李四', '2');
INSERT INTO `student` VALUES ('3', '王五', '1');
INSERT INTO `student` VALUES ('4', '赵六', '3');
INSERT INTO `student` VALUES ('5', '蜀七', '1');
INSERT INTO `student` VALUES ('6', '魏八', '3');