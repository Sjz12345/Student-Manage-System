单人课设项目：学生管理系统
本项目参考 https://www.yuque.com/fhzheng/springboot_jsp_ems  

环境搭建: 

    1.在src/main/resources/appliation.yml和src/main/resources/application.properties中修改MySQL数据库配置信息

    2.在本地MySQL数据库中,运行下列""内语句

    t-user --登录用户数据表
    user --学生数据表
"

CREATE database sb_jsp_ems;
use sb_jsp_ems;
CREATE TABLE `t_user` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`username` varchar(50) NOT NULL COMMENT '用户名（唯一）',
`password` varchar(60) NOT NULL COMMENT '加密后的密码',
PRIMARY KEY (`id`),
UNIQUE KEY `username` (`username`)
);
CREATE TABLE `user` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(60) NOT NULL,
`age` int DEFAULT NULL,
`gender` char(10) DEFAULT NULL,
`birthday` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
);
INSERT INTO t_user (username, password) VALUES('admin','123456');

INSERT INTO user (name, age, gender, birthday) VALUES
('张伟', 28, '男', '1995-07-12 09:15:00'),
('王芳', 35, '女', '1988-11-23 14:45:00'),
('李强', 22, '男', '2001-03-05 20:30:00'),
('刘洋', 30, '女', '1993-01-17 11:00:00'),
('陈杰', 40, '男', '1983-05-29 08:20:00'),
('杨敏', 26, '女', '1997-10-10 16:10:00'),
('赵磊', 33, '男', '1990-04-02 13:55:00'),
('黄娜', 29, '女', '1994-12-08 19:05:00'),
('周斌', 31, '男', '1992-06-18 07:40:00'),
('吴静', 24, '女', '1999-02-25 22:25:00');


"

页面访问: 
        程序运行后,打开浏览器,访问  "localhost:8080/login"  即可


