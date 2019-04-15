SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lcl`
-- ----------------------------
DROP TABLE IF EXISTS `lcl`;
CREATE TABLE `lcl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL DEFAULT '',
  `lastName` varchar(50) NOT NULL DEFAULT '',
  `salary` float unsigned NOT NULL DEFAULT '0',
  `age` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `sex` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
