/*
 Navicat Premium Dump SQL

 Source Server         : 192.168.98.131
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40-0ubuntu0.20.04.1)
 Source Host           : 192.168.98.131:3306
 Source Schema         : blog_system

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40-0ubuntu0.20.04.1)
 File Encoding         : 65001

 Date: 10/01/2025 20:06:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '属性名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典code',
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (1, '菜单类型', '100', '[{\"key\":\"101\",\"value\":\"directory\",\"des\":\"目录\"},{\"key\":\"102\",\"value\":\"menu\",\"des\":\"菜单\"},{\"key\":\"103\",\"value\":\"button\",\"des\":\"按钮\"}]');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL COMMENT '菜单表id',
  `pid` bigint NULL DEFAULT NULL COMMENT '父级id',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '路径',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '路由名称',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图标',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `deep` int NULL DEFAULT NULL COMMENT '层级',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '按钮权限',
  `has_children` bit(1) NULL DEFAULT NULL COMMENT '是否有子级: 0.否、1.是',
  `menu_type` int NULL DEFAULT NULL COMMENT '菜单类型',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建用户id',
  `update_user` bigint NULL DEFAULT NULL COMMENT '修改用户id',
  `flag` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (100, 0, '/system', '系统管理', 'menus.pureSysManagement', 'ri:settings-3-line', 1, 1, NULL, b'1', 101, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (110, 100, '/system/user/index', '用户管理', 'menus.pureUser', 'ri:admin-line', 1, 2, NULL, b'0', 102, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (111, 110, NULL, '新增用户', '', NULL, 1, 3, 'system:user:add', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (112, 110, NULL, '编辑用户', NULL, NULL, 2, 3, 'system:user:edit', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (113, 110, NULL, '删除用户', NULL, NULL, 3, 3, 'system:user:delete', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (120, 100, '/system/role/index', '角色管理', 'menus.pureRole', 'ri:admin-fill', 2, 2, NULL, b'0', 102, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (121, 120, NULL, '新增角色', NULL, NULL, 1, 3, 'system:role:add', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (122, 120, NULL, '编辑角色', NULL, NULL, 2, 3, 'system:role:edit', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (123, 120, NULL, '删除角色', NULL, NULL, 3, 3, 'system:role:delete', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (124, 120, NULL, '权限', NULL, NULL, 4, 3, 'system:role:permissions', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (130, 100, '/system/menu/index', '菜单管理', 'menus.pureSystemMenu', 'ep:menu', 3, 2, NULL, b'0', 102, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (131, 130, NULL, '新增菜单', NULL, NULL, 1, 3, 'system:menu:add', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (132, 130, NULL, '编辑菜单', NULL, NULL, 2, 3, 'system:menu:edit', b'0', 103, NULL, NULL, NULL, NULL, b'0');
INSERT INTO `menu` VALUES (133, 130, NULL, '删除菜单', NULL, NULL, 3, 3, 'system:menu:delete', b'0', 103, NULL, NULL, NULL, NULL, b'0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL COMMENT '角色表id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色名称',
  `is_lock` bit(1) NULL DEFAULT NULL COMMENT '是否锁定',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标识，唯一',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', b'1', 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NULL DEFAULT NULL,
  `menu_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1861065033711976457 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 100);
INSERT INTO `role_menu` VALUES (2, 1, 110);
INSERT INTO `role_menu` VALUES (3, 1, 111);
INSERT INTO `role_menu` VALUES (4, 1, 112);
INSERT INTO `role_menu` VALUES (5, 1, 113);
INSERT INTO `role_menu` VALUES (6, 1, 120);
INSERT INTO `role_menu` VALUES (7, 1, 121);
INSERT INTO `role_menu` VALUES (8, 1, 122);
INSERT INTO `role_menu` VALUES (9, 1, 123);
INSERT INTO `role_menu` VALUES (10, 1, 124);
INSERT INTO `role_menu` VALUES (11, 1, 130);
INSERT INTO `role_menu` VALUES (12, 1, 131);
INSERT INTO `role_menu` VALUES (13, 1, 132);
INSERT INTO `role_menu` VALUES (14, 1, 133);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint NOT NULL,
  `role_id` bigint NULL DEFAULT NULL,
  `user_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
