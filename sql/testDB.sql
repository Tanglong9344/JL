# Host: 127.0.0.1  (Version 5.7.18)
# Date: 2017-08-20 16:14:01
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "hero"
#

CREATE TABLE `hero` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `hp` float DEFAULT NULL COMMENT '血量',
  `damage` int(11) DEFAULT NULL COMMENT '伤害值',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英雄表';

#
# Data for table "hero"
#

INSERT INTO `hero` VALUES (1,'提莫',313,50),(2,'阿拉丁',313,50),(3,'巨灵神',800,100),(4,'提莫',313,50),(6,'提莫',313,50),(7,'提莫',313,50),(8,'提莫',313,50);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'user','123');
