-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `card_number` int(11) DEFAULT NULL,
                        `sid` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '178283992', '3');
INSERT INTO `card` VALUES ('2', '123624573', '2');
INSERT INTO `card` VALUES ('3', '234122212', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) DEFAULT NULL,
                           `cid` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '3');
INSERT INTO `student` VALUES ('2', '李四', '2');
INSERT INTO `student` VALUES ('3', '王五', '1');