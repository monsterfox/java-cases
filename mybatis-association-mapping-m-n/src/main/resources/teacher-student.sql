-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三');
INSERT INTO `student` VALUES ('2', '李四');
INSERT INTO `student` VALUES ('3', '王五');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `course_name` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '语文', '刘伟');
INSERT INTO `teacher` VALUES ('2', '语文', '张帅');
INSERT INTO `teacher` VALUES ('3', '数学', '赵凯');
INSERT INTO `teacher` VALUES ('4', '英语', '刘波');
INSERT INTO `teacher` VALUES ('5', '英语', '英丽');