/*
Navicat MySQL Data Transfer

Source Server         : YZD
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hotel_13

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-05-28 15:44:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `No` int(20) NOT NULL AUTO_INCREMENT,
  `BookName` varchar(20) NOT NULL,
  `ArTime` datetime(6) NOT NULL,
  `PhoneNum` varchar(20) NOT NULL,
  `ParkingNum` varchar(10) NOT NULL,
  PRIMARY KEY (`No`),
  KEY `ToRoom` (`ParkingNum`) USING BTREE,
  CONSTRAINT `ToRoom1` FOREIGN KEY (`ParkingNum`) REFERENCES `parking` (`ParkingID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('6', 'zs', '2015-05-20 00:00:00.000000', '1456', '004');
INSERT INTO `book` VALUES ('7', 'ki', '2015-06-01 00:00:00.000000', '123568', '004');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CustomerlID` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `PhoneNum` varchar(11) NOT NULL,
  `ArrivalTime` datetime(6) NOT NULL,
  `ParkingID` varchar(10) NOT NULL,
  `DepositCash` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CustomerlID`),
  KEY `ToRoom` (`ParkingID`) USING BTREE,
  CONSTRAINT `ToRoom` FOREIGN KEY (`ParkingID`) REFERENCES `parking` (`ParkingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('4', 'ew', '4', '2015-05-17 12:58:51.000000', '001', '259.00');
INSERT INTO `customer` VALUES ('4254254', '1', '12241', '2015-05-17 12:03:17.000000', '002', '320.00');
INSERT INTO `customer` VALUES ('452722', '2', '4254', '2015-05-17 12:03:17.000000', '003', '355.00');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Role` varchar(10) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('123', '000', '1');
INSERT INTO `login` VALUES ('131110128', '123456', '1');
INSERT INTO `login` VALUES ('1507441', '123', '1');
INSERT INTO `login` VALUES ('562831664', '152', '0');
INSERT INTO `login` VALUES ('a', 'a', '0');
INSERT INTO `login` VALUES ('admin', 'admin', '0');

-- ----------------------------
-- Table structure for parking
-- ----------------------------
DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking` (
  `ParkingID` varchar(10) NOT NULL,
  `ParkingType` varchar(20) NOT NULL,
  `ParkingStatus` varchar(10) NOT NULL,
  `ParkingTel` varchar(10) NOT NULL,
  PRIMARY KEY (`ParkingID`),
  KEY `RoomType` (`ParkingType`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parking
-- ----------------------------
INSERT INTO `parking` VALUES ('001', '0', '3', '0');
INSERT INTO `parking` VALUES ('002', '0', '0', '0');
INSERT INTO `parking` VALUES ('003', '0', '2', '0');
INSERT INTO `parking` VALUES ('004', '0', '1', '0');
INSERT INTO `parking` VALUES ('005', '0', '0', '0');
INSERT INTO `parking` VALUES ('006', '0', '0', '0');
INSERT INTO `parking` VALUES ('007', '0', '0', '0');
INSERT INTO `parking` VALUES ('008', '0', '0', '0');
INSERT INTO `parking` VALUES ('009', '0', '3', '0');
INSERT INTO `parking` VALUES ('010', '0', '0', '0');
INSERT INTO `parking` VALUES ('011', '0', '0', '0');
INSERT INTO `parking` VALUES ('012', '0', '0', '0');
INSERT INTO `parking` VALUES ('013', '0', '0', '0');
INSERT INTO `parking` VALUES ('014', '0', '0', '0');
INSERT INTO `parking` VALUES ('015', '0', '0', '0');
INSERT INTO `parking` VALUES ('016', '0', '0', '0');
INSERT INTO `parking` VALUES ('017', '0', '0', '0');
INSERT INTO `parking` VALUES ('018', '0', '0', '0');
INSERT INTO `parking` VALUES ('019', '0', '0', '0');
INSERT INTO `parking` VALUES ('020', '0', '0', '0');
INSERT INTO `parking` VALUES ('021', '0', '0', '0');
INSERT INTO `parking` VALUES ('022', '0', '0', '0');
INSERT INTO `parking` VALUES ('023', '0', '0', '0');
INSERT INTO `parking` VALUES ('024', '0', '0', '0');
INSERT INTO `parking` VALUES ('025', '0', '0', '0');
INSERT INTO `parking` VALUES ('026', '0', '0', '0');
INSERT INTO `parking` VALUES ('027', '0', '0', '0');
INSERT INTO `parking` VALUES ('028', '0', '0', '0');
INSERT INTO `parking` VALUES ('029', '0', '0', '0');
INSERT INTO `parking` VALUES ('030', '0', '0', '0');
INSERT INTO `parking` VALUES ('031', '0', '0', '0');
INSERT INTO `parking` VALUES ('032', '0', '0', '0');
INSERT INTO `parking` VALUES ('033', '0', '0', '0');
INSERT INTO `parking` VALUES ('034', '0', '0', '0');
INSERT INTO `parking` VALUES ('035', '0', '0', '0');
INSERT INTO `parking` VALUES ('101', '1', '0', '0');
INSERT INTO `parking` VALUES ('102', '1', '0', '0');
INSERT INTO `parking` VALUES ('103', '1', '0', '0');
INSERT INTO `parking` VALUES ('104', '1', '0', '0');
INSERT INTO `parking` VALUES ('105', '1', '0', '0');
INSERT INTO `parking` VALUES ('106', '1', '0', '0');
INSERT INTO `parking` VALUES ('107', '1', '0', '0');
INSERT INTO `parking` VALUES ('108', '1', '0', '0');
INSERT INTO `parking` VALUES ('109', '1', '0', '0');
INSERT INTO `parking` VALUES ('110', '1', '0', '0');
INSERT INTO `parking` VALUES ('111', '1', '0', '0');
INSERT INTO `parking` VALUES ('112', '1', '0', '0');
INSERT INTO `parking` VALUES ('113', '1', '0', '0');
INSERT INTO `parking` VALUES ('114', '1', '0', '0');
INSERT INTO `parking` VALUES ('115', '1', '0', '0');
INSERT INTO `parking` VALUES ('116', '1', '0', '0');
INSERT INTO `parking` VALUES ('117', '1', '0', '0');
INSERT INTO `parking` VALUES ('118', '1', '0', '0');
INSERT INTO `parking` VALUES ('119', '1', '0', '0');
INSERT INTO `parking` VALUES ('120', '1', '0', '0');
INSERT INTO `parking` VALUES ('121', '1', '0', '0');
INSERT INTO `parking` VALUES ('122', '1', '0', '0');
INSERT INTO `parking` VALUES ('123', '1', '0', '0');
INSERT INTO `parking` VALUES ('124', '1', '0', '0');
INSERT INTO `parking` VALUES ('125', '1', '0', '0');
INSERT INTO `parking` VALUES ('126', '1', '0', '0');
INSERT INTO `parking` VALUES ('127', '1', '0', '0');
INSERT INTO `parking` VALUES ('128', '1', '0', '0');
INSERT INTO `parking` VALUES ('129', '1', '0', '0');
INSERT INTO `parking` VALUES ('130', '1', '0', '0');
INSERT INTO `parking` VALUES ('131', '1', '0', '0');
INSERT INTO `parking` VALUES ('132', '1', '0', '0');
INSERT INTO `parking` VALUES ('133', '1', '0', '0');
INSERT INTO `parking` VALUES ('134', '1', '0', '0');
INSERT INTO `parking` VALUES ('135', '1', '0', '0');
INSERT INTO `parking` VALUES ('201', '2', '0', '0');
INSERT INTO `parking` VALUES ('202', '2', '0', '0');
INSERT INTO `parking` VALUES ('203', '2', '0', '0');
INSERT INTO `parking` VALUES ('204', '2', '0', '0');
INSERT INTO `parking` VALUES ('205', '2', '0', '0');
INSERT INTO `parking` VALUES ('206', '2', '0', '0');
INSERT INTO `parking` VALUES ('207', '2', '0', '0');
INSERT INTO `parking` VALUES ('208', '2', '0', '0');
INSERT INTO `parking` VALUES ('209', '2', '0', '0');
INSERT INTO `parking` VALUES ('210', '2', '0', '0');
INSERT INTO `parking` VALUES ('211', '2', '0', '0');
INSERT INTO `parking` VALUES ('212', '2', '0', '0');
INSERT INTO `parking` VALUES ('213', '2', '0', '0');
INSERT INTO `parking` VALUES ('214', '2', '0', '0');
INSERT INTO `parking` VALUES ('215', '2', '0', '0');
INSERT INTO `parking` VALUES ('216', '2', '0', '0');
INSERT INTO `parking` VALUES ('217', '2', '0', '0');
INSERT INTO `parking` VALUES ('218', '2', '0', '0');
INSERT INTO `parking` VALUES ('219', '2', '0', '0');
INSERT INTO `parking` VALUES ('220', '2', '0', '0');
INSERT INTO `parking` VALUES ('221', '2', '0', '0');
INSERT INTO `parking` VALUES ('222', '2', '0', '0');
INSERT INTO `parking` VALUES ('223', '2', '0', '0');
INSERT INTO `parking` VALUES ('224', '2', '0', '0');
INSERT INTO `parking` VALUES ('225', '2', '0', '0');
INSERT INTO `parking` VALUES ('226', '2', '0', '0');
INSERT INTO `parking` VALUES ('227', '2', '0', '0');
INSERT INTO `parking` VALUES ('228', '2', '0', '0');
INSERT INTO `parking` VALUES ('229', '2', '0', '0');
INSERT INTO `parking` VALUES ('230', '2', '0', '0');
INSERT INTO `parking` VALUES ('231', '2', '0', '0');
INSERT INTO `parking` VALUES ('232', '2', '0', '0');
INSERT INTO `parking` VALUES ('233', '2', '0', '0');
INSERT INTO `parking` VALUES ('234', '2', '0', '0');
INSERT INTO `parking` VALUES ('235', '2', '0', '0');
INSERT INTO `parking` VALUES ('236', '2', '0', '0');
INSERT INTO `parking` VALUES ('237', '2', '0', '0');
INSERT INTO `parking` VALUES ('238', '2', '0', '0');
INSERT INTO `parking` VALUES ('239', '2', '0', '0');
INSERT INTO `parking` VALUES ('240', '2', '0', '0');
INSERT INTO `parking` VALUES ('301', '3', '0', '0');
INSERT INTO `parking` VALUES ('302', '3', '0', '0');
INSERT INTO `parking` VALUES ('303', '3', '0', '0');
INSERT INTO `parking` VALUES ('304', '3', '0', '0');
INSERT INTO `parking` VALUES ('305', '3', '0', '0');
INSERT INTO `parking` VALUES ('306', '3', '0', '0');
INSERT INTO `parking` VALUES ('307', '3', '0', '0');
INSERT INTO `parking` VALUES ('308', '3', '0', '0');
INSERT INTO `parking` VALUES ('309', '3', '0', '0');
INSERT INTO `parking` VALUES ('310', '3', '0', '0');
INSERT INTO `parking` VALUES ('311', '3', '0', '0');
INSERT INTO `parking` VALUES ('312', '3', '0', '0');
INSERT INTO `parking` VALUES ('313', '3', '0', '0');
INSERT INTO `parking` VALUES ('314', '3', '0', '0');
INSERT INTO `parking` VALUES ('315', '3', '0', '0');
INSERT INTO `parking` VALUES ('316', '3', '0', '0');
INSERT INTO `parking` VALUES ('317', '3', '0', '0');
INSERT INTO `parking` VALUES ('318', '3', '0', '0');
INSERT INTO `parking` VALUES ('319', '3', '0', '0');
INSERT INTO `parking` VALUES ('320', '3', '0', '0');
INSERT INTO `parking` VALUES ('321', '3', '0', '0');
INSERT INTO `parking` VALUES ('322', '3', '0', '0');
INSERT INTO `parking` VALUES ('323', '3', '0', '0');
INSERT INTO `parking` VALUES ('324', '3', '0', '0');
INSERT INTO `parking` VALUES ('325', '3', '0', '0');
INSERT INTO `parking` VALUES ('326', '3', '0', '0');
INSERT INTO `parking` VALUES ('327', '3', '0', '0');
INSERT INTO `parking` VALUES ('328', '3', '0', '0');
INSERT INTO `parking` VALUES ('329', '3', '0', '0');
INSERT INTO `parking` VALUES ('330', '3', '0', '0');
INSERT INTO `parking` VALUES ('331', '3', '0', '0');
INSERT INTO `parking` VALUES ('332', '3', '0', '0');
INSERT INTO `parking` VALUES ('333', '3', '0', '0');
INSERT INTO `parking` VALUES ('334', '3', '0', '0');
INSERT INTO `parking` VALUES ('335', '3', '0', '0');
INSERT INTO `parking` VALUES ('336', '3', '0', '0');
INSERT INTO `parking` VALUES ('337', '3', '0', '0');
INSERT INTO `parking` VALUES ('338', '3', '0', '0');
INSERT INTO `parking` VALUES ('339', '3', '0', '0');
INSERT INTO `parking` VALUES ('340', '3', '0', '0');
INSERT INTO `parking` VALUES ('991', '1', '3', '0');
INSERT INTO `parking` VALUES ('993', '1', '3', '0');
INSERT INTO `parking` VALUES ('999', '1', '3', '0');
INSERT INTO `parking` VALUES ('9999', '1', '3', '0');

-- ----------------------------
-- Table structure for parkingtotal
-- ----------------------------
DROP TABLE IF EXISTS `parkingtotal`;
CREATE TABLE `parkingtotal` (
  `ParkingType` varchar(20) NOT NULL,
  `ParkingCount` varchar(10) NOT NULL,
  PRIMARY KEY (`ParkingType`),
  KEY `ToRoomType` (`ParkingType`) USING BTREE,
  CONSTRAINT `ToRoomType` FOREIGN KEY (`ParkingType`) REFERENCES `parking` (`ParkingType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkingtotal
-- ----------------------------
INSERT INTO `parkingtotal` VALUES ('0', '35');
INSERT INTO `parkingtotal` VALUES ('1', '35');
INSERT INTO `parkingtotal` VALUES ('2', '40');
INSERT INTO `parkingtotal` VALUES ('3', '40');
