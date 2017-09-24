# Host: 127.0.0.1  (Version 5.7.18)
# Date: 2017-09-24 22:43:33
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "book"
#

CREATE TABLE `book` (
  `price` double(11,0) DEFAULT NULL COMMENT '价格',
  `stock` int(11) DEFAULT NULL COMMENT '总数目',
  `publish_time` date DEFAULT NULL COMMENT '出版时间',
  `publisher` varchar(1024) DEFAULT NULL COMMENT '出版商',
  `translator` varchar(50) DEFAULT NULL COMMENT '译者',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `name` varchar(100) DEFAULT NULL COMMENT '书名',
  `id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (25,12,'2000-09-08','中华出版社','','唐龙','生活感悟','我们的世界','1'),(43,5,'2015-01-08','机械工业出版社','','刘慧宁','教材','Java程序设计','2');

#
# Structure for table "borrow"
#

CREATE TABLE `borrow` (
  `is_back` smallint(1) DEFAULT NULL,
  `back_date` date DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `reader_id` varchar(50) DEFAULT NULL,
  `book_id` varchar(50) NOT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for table "borrow"
#


#
# Structure for table "reader"
#

CREATE TABLE `reader` (
  `days_num` int(11) DEFAULT NULL,
  `max_num` int(3) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for table "reader"
#


#
# Structure for table "user"
#

CREATE TABLE `user` (
  `is_admin` smallint(1) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'root','root',1);
