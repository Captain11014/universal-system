/*
 Navicat Premium Data Transfer

 Source Server         : 47.115.226.141
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : 47.115.226.141:3306
 Source Schema         : system_database

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 23/01/2024 15:15:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '其他操作');
INSERT INTO `sys_dict_data` VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2023-12-13 15:33:44', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '游客' COMMENT '操作人员',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回参数',
  `status` int NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, '菜单管理', 'com.universal.system.controller.SysMenuController.add()', 'POST', '游客', '/system/menu', '127.0.0.1', '[{\"menuName\":\"系统日志\",\"parentId\":1,\"orderNum\":4,\"path\":\"log\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:log:list\",\"icon\":\"chart\",\"children\":[],\"createBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-07 17:01:04');
INSERT INTO `sys_log` VALUES (2, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', '游客', '/system/menu', '127.0.0.1', '[{\"menuId\":5,\"menuName\":\"系统日志\",\"parentId\":1,\"orderNum\":4,\"path\":\"log\",\"component\":\"system/log/index\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:log:list\",\"icon\":\"chart\",\"children\":[],\"createTime\":1699347664000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-07 17:01:32');
INSERT INTO `sys_log` VALUES (3, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', '游客', '/system/menu', '127.0.0.1', '[{\"menuId\":5,\"menuName\":\"系统日志\",\"parentId\":1,\"orderNum\":4,\"path\":\"log\",\"component\":\"system/log/index\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:log:list\",\"icon\":\"chart\",\"children\":[],\"createTime\":1699347664000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-07 17:04:36');
INSERT INTO `sys_log` VALUES (4, '用户管理', 'com.universal.system.controller.SysUserController.updateUser()', 'PUT', 'admin', '/system/user', '127.0.0.1', '[{\"userId\":7,\"userName\":\"260521812@qq.com\",\"nickName\":\"260521812@qq.com\",\"email\":\"260521812@qq.com\",\"phonenumber\":\"18818151555\",\"gender\":\"0\",\"avatar\":\"\",\"status\":\"0\",\"delFlag\":\"0\",\"loginIp\":\"\",\"roles\":[],\"roleIds\":[],\"createBy\":\"\",\"createTime\":1699286092000,\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-07 17:21:45');
INSERT INTO `sys_log` VALUES (5, '角色管理', 'com.universal.system.controller.SysRoleController.deleteRole()', 'DELETE', 'admin', '/system/role/7', '180.136.244.96', '[[7]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-15 12:14:40');
INSERT INTO `sys_log` VALUES (6, '角色管理', 'com.universal.system.controller.SysRoleController.cancelAuthUserAll()', 'PUT', 'admin', '/system/role/authUser/cancelAll', '180.136.244.96', '[6,[1,3,4]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-15 12:14:55');
INSERT INTO `sys_log` VALUES (7, '角色管理', 'com.universal.system.controller.SysRoleController.deleteRole()', 'DELETE', 'admin', '/system/role/6', '180.136.244.96', '[[6]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-15 12:15:01');
INSERT INTO `sys_log` VALUES (8, '角色管理', 'com.universal.system.controller.SysRoleController.updateRole()', 'PUT', 'admin', '/system/role/updateRole', '180.136.244.96', '[{\"roleId\":2,\"roleName\":\"普通用户\",\"roleKey\":\"pt\",\"roleSort\":2,\"dataScope\":\"1\",\"menuCheckStrictly\":true,\"deptCheckStrictly\":false,\"status\":\"0\",\"delFlag\":\"0\",\"flag\":false,\"menuIds\":[1,5],\"createTime\":1698476223000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-15 12:15:12');
INSERT INTO `sys_log` VALUES (9, '角色管理', 'com.universal.system.controller.SysRoleController.selectAuthUserAll()', 'PUT', 'admin', '/system/role/authUser/selectAll', '180.136.244.96', '[2,[8]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-11-15 12:15:26');
INSERT INTO `sys_log` VALUES (10, '用户管理', 'com.universal.system.controller.SysUserController.updateUser()', 'PUT', 'admin', '/system/user', '127.0.0.1', '[{\"userId\":8,\"userName\":\"3322826870@qq.com\",\"nickName\":\"3322826870@qq.com\",\"email\":\"3322826870@qq.com\",\"phonenumber\":\"18815498500\",\"gender\":\"0\",\"avatar\":\"\",\"status\":\"0\",\"delFlag\":\"0\",\"loginIp\":\"\",\"roles\":[{\"roleId\":2,\"roleName\":\"普通用户\",\"roleKey\":\"pt\",\"roleSort\":2,\"dataScope\":\"1\",\"menuCheckStrictly\":false,\"deptCheckStrictly\":false,\"status\":\"0\",\"flag\":false,\"params\":{}}],\"roleIds\":[2],\"createBy\":\"\",\"createTime\":1700020793000,\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-12-10 17:52:14');
INSERT INTO `sys_log` VALUES (11, '用户管理', 'com.universal.system.controller.SysUserController.addUser()', 'POST', 'admin', '/un/system/user', '180.136.245.170', '[{\"userName\":\"df\",\"nickName\":\"sdfs\",\"email\":\"45@qq.com\",\"phonenumber\":\"18816535100\",\"gender\":\"0\",\"status\":\"0\",\"roleIds\":[],\"createBy\":\"admin\",\"params\":{}}]', NULL, 1, '2', '2023-12-13 09:20:19');
INSERT INTO `sys_log` VALUES (12, '用户管理', 'com.universal.system.controller.SysUserController.addUser()', 'POST', 'admin', '/un/system/user', '180.136.245.170', '[{\"userName\":\"df\",\"nickName\":\"sdfs\",\"email\":\"45@qq.com\",\"phonenumber\":\"18816535100\",\"gender\":\"0\",\"status\":\"0\",\"roleIds\":[2],\"createBy\":\"admin\",\"params\":{}}]', NULL, 1, '2', '2023-12-13 09:20:25');
INSERT INTO `sys_log` VALUES (13, '用户管理', 'com.universal.system.controller.SysUserController.addUser()', 'POST', 'admin', '/un/system/user', '180.136.245.170', '[{\"userId\":9,\"userName\":\"df\",\"nickName\":\"dfsdf\",\"email\":\"dss@qq.com\",\"phonenumber\":\"18865420100\",\"gender\":\"0\",\"password\":\"$2a$10$APhKnJ8CHUvGrWHdePBnTeMIqotf5HaEGSSaleKGtnZwKk2F2HBta\",\"status\":\"0\",\"roleIds\":[],\"createBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-12-13 11:18:24');
INSERT INTO `sys_log` VALUES (14, '用户管理', 'com.universal.system.controller.SysUserController.deleteUser()', 'DELETE', 'admin', '/un/system/user/9', '180.136.245.170', '[[9]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '2', '2023-12-13 11:18:33');
INSERT INTO `sys_log` VALUES (15, '菜单管理', 'com.universal.system.controller.SysMenuController.add()', 'POST', 'admin', '/system/menu', '127.0.0.1', '[{\"menuName\":\"字典管理\",\"parentId\":0,\"orderNum\":4,\"path\":\"dict\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"M\",\"visible\":\"0\",\"status\":\"0\",\"icon\":\"list\",\"children\":[],\"createBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 15:43:48');
INSERT INTO `sys_log` VALUES (16, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', 'admin', '/system/menu', '127.0.0.1', '[{\"menuId\":6,\"menuName\":\"字典管理\",\"parentId\":1,\"orderNum\":4,\"path\":\"dict\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"\",\"icon\":\"list\",\"children\":[],\"createTime\":1705909428000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 15:44:13');
INSERT INTO `sys_log` VALUES (17, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', 'admin', '/system/menu', '127.0.0.1', '[{\"menuId\":5,\"menuName\":\"系统日志\",\"parentId\":1,\"orderNum\":5,\"path\":\"log\",\"component\":\"system/log/index\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:log:list\",\"icon\":\"chart\",\"children\":[],\"createTime\":1699347664000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 15:44:24');
INSERT INTO `sys_log` VALUES (18, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', 'admin', '/system/menu', '127.0.0.1', '[{\"menuId\":6,\"menuName\":\"字典管理\",\"parentId\":1,\"orderNum\":4,\"path\":\"dict\",\"component\":\"system/dict/index\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"\",\"icon\":\"list\",\"children\":[],\"createTime\":1705909428000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 16:29:07');
INSERT INTO `sys_log` VALUES (19, '菜单管理', 'com.universal.system.controller.SysMenuController.edit()', 'PUT', 'admin', '/system/menu', '127.0.0.1', '[{\"menuId\":6,\"menuName\":\"字典管理\",\"parentId\":1,\"orderNum\":4,\"path\":\"dict\",\"component\":\"system/dict/index\",\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"C\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:dict:list\",\"icon\":\"list\",\"children\":[],\"createTime\":1705909428000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 16:29:22');
INSERT INTO `sys_log` VALUES (20, '菜单管理', 'com.universal.system.controller.SysMenuController.add()', 'POST', 'admin', '/system/menu', '127.0.0.1', '[{\"menuName\":\"字典查询\",\"parentId\":6,\"orderNum\":1,\"isFrame\":\"1\",\"isCache\":\"0\",\"menuType\":\"F\",\"visible\":\"0\",\"status\":\"0\",\"perms\":\"system:dict:query\",\"children\":[],\"createBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 16:30:22');
INSERT INTO `sys_log` VALUES (21, '字典数据', 'com.universal.system.controller.SysDictTypeController.remove()', 'DELETE', 'admin', '/system/dict/type/102', '127.0.0.1', '[[102]]', NULL, 1, '0', '2024-01-22 17:30:00');
INSERT INTO `sys_log` VALUES (22, '字典数据', 'com.universal.system.controller.SysDictTypeController.refreshCache()', 'DELETE', 'admin', '/system/dict/type/refreshCache', '127.0.0.1', '[]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 17:44:57');
INSERT INTO `sys_log` VALUES (23, '字典数据', 'com.universal.system.controller.SysDictDataController.edit()', 'PUT', 'admin', '/system/dict/data', '127.0.0.1', '[{\"dictCode\":106,\"dictSort\":1,\"dictLabel\":\"市\",\"dictValue\":\"2\",\"dictType\":\"city_type\",\"listClass\":\"warning\",\"isDefault\":\"N\",\"status\":\"0\",\"createBy\":\"admin\",\"createTime\":1702906015000,\"updateBy\":\"admin\",\"params\":{}}]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:16');
INSERT INTO `sys_log` VALUES (24, '字典数据', 'com.universal.system.controller.SysDictDataController.remove()', 'DELETE', 'admin', '/system/dict/data/106', '127.0.0.1', '[[106]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:20');
INSERT INTO `sys_log` VALUES (25, '字典数据', 'com.universal.system.controller.SysDictDataController.remove()', 'DELETE', 'admin', '/system/dict/data/105,107,108,109', '127.0.0.1', '[[105,107,108,109]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:25');
INSERT INTO `sys_log` VALUES (26, '字典数据', 'com.universal.system.controller.SysDictTypeController.remove()', 'DELETE', 'admin', '/system/dict/type/102', '127.0.0.1', '[[102]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:31');
INSERT INTO `sys_log` VALUES (27, '字典数据', 'com.universal.system.controller.SysDictDataController.remove()', 'DELETE', 'admin', '/system/dict/data/102,103,104', '127.0.0.1', '[[102,103,104]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:40');
INSERT INTO `sys_log` VALUES (28, '字典数据', 'com.universal.system.controller.SysDictTypeController.remove()', 'DELETE', 'admin', '/system/dict/type/101', '127.0.0.1', '[[101]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:46');
INSERT INTO `sys_log` VALUES (29, '字典数据', 'com.universal.system.controller.SysDictDataController.remove()', 'DELETE', 'admin', '/system/dict/data/100,101', '127.0.0.1', '[[100,101]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:55');
INSERT INTO `sys_log` VALUES (30, '字典数据', 'com.universal.system.controller.SysDictTypeController.remove()', 'DELETE', 'admin', '/system/dict/type/100', '127.0.0.1', '[[100]]', '{\"msg\":\"操作成功\",\"code\":200}', 0, '0', '2024-01-22 18:26:59');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 5, 'system', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'system', 'admin', '2023-11-05 15:02:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, 1, 'sysUser', 'system/sysUser/index', NULL, 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2023-11-05 15:05:20', 'admin', '2023-11-05 15:06:53', '');
INSERT INTO `sys_menu` VALUES (3, '角色管理', 1, 2, 'role', 'system/role/index', NULL, 1, 0, 'C', '0', '0', 'system:role:list', 'list', 'admin', '2023-11-05 15:06:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (4, '菜单管理', 1, 3, 'menu', 'system/menu/index', NULL, 1, 0, 'C', '0', '0', 'system:menu:list', 'nested', 'admin', '2023-11-05 15:08:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (5, '系统日志', 1, 5, 'log', 'system/log/index', NULL, 1, 0, 'C', '0', '0', 'system:log:list', 'chart', 'admin', '2023-11-07 17:01:04', 'admin', '2024-01-22 15:44:24', '');
INSERT INTO `sys_menu` VALUES (6, '字典管理', 1, 4, 'dict', 'system/dict/index', NULL, 1, 0, 'C', '0', '0', 'system:dict:list', 'list', 'admin', '2024-01-22 15:43:48', 'admin', '2024-01-22 16:29:22', '');
INSERT INTO `sys_menu` VALUES (7, '字典查询', 6, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2024-01-22 16:30:22', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 0, '1', 1, 1, '0', '0', '', '2023-10-28 14:41:36', '', NULL, NULL);
INSERT INTO `sys_role` VALUES (2, '普通用户', 'pt', 2, '1', 1, 0, '0', '0', '', '2023-10-28 14:57:03', 'admin', '2023-11-15 12:15:12', NULL);
INSERT INTO `sys_role` VALUES (3, '管理员111', 'aaa', 0, '1', 1, 0, '1', '2', '', '2023-10-28 15:02:35', '', '2023-11-01 17:30:04', NULL);
INSERT INTO `sys_role` VALUES (4, 'ss', 'admin', 0, '1', 1, 0, '1', '2', '', '2023-10-28 15:03:27', '', '2023-11-01 17:30:05', NULL);
INSERT INTO `sys_role` VALUES (5, '管理员1', 'admin1', 0, '1', 1, 1, '0', '1', '', '2023-10-28 15:09:39', '', NULL, NULL);
INSERT INTO `sys_role` VALUES (6, '测试', 'test', 3, '1', 1, 0, '0', '2', '', '2023-11-03 22:35:08', 'admin', '2023-11-05 16:36:25', NULL);
INSERT INTO `sys_role` VALUES (7, 'hhh', 'hhh', 0, '1', 1, 1, '0', '2', '', '2023-11-06 00:04:25', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (6, 1);
INSERT INTO `sys_role_menu` VALUES (6, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '码农', '00', '2109276571@qq.com', '15888888888', '1', '', '$2a$10$L5D2DuM8N5rs3LEFAqRal.sp/YeVo4mmglj8ZxityQszncWEhVxb.', '0', '0', '', '2023-10-19 15:27:25', 'admin', '2023-09-23 21:25:02', '', '2023-10-19 15:27:41', '超级管理员');
INSERT INTO `sys_user` VALUES (3, 'zs', '法外狂徒', '00', '123@qq.com', '18815465100', '0', '', '$2a$10$LOa11K/00/kgKptnYQICNOfLbugerYT8ehpZxWUQuAbszfU3Z58KC', '0', '0', '', NULL, '', '2023-11-01 13:26:47', '', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'ls', 'llll', '00', '111@qq.com', '13211212111', '0', '', '$2a$10$LOa11K/00/kgKptnYQICNOfLbugerYT8ehpZxWUQuAbszfU3Z58KC', '0', '0', '', NULL, 'admin', '2023-11-01 13:33:47', '', NULL, 'ddd参数');
INSERT INTO `sys_user` VALUES (8, '3322826870@qq.com', '3322826870@qq.com', '00', '3322826870@qq.com', '18815498500', '0', '', '$2a$10$PjlqxaFfJMn07bZ3S2RHjOTB0/yiE4yKCzarGcnVZYH5bblhGI1Ri', '0', '0', '', NULL, '', '2023-11-15 11:59:53', '', '2023-12-10 17:52:14', NULL);
INSERT INTO `sys_user` VALUES (9, 'df', 'dfsdf', '00', 'dss@qq.com', '18865420100', '0', '', '$2a$10$APhKnJ8CHUvGrWHdePBnTeMIqotf5HaEGSSaleKGtnZwKk2F2HBta', '0', '2', '', NULL, 'admin', '2023-12-13 11:18:24', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (3, 2);
INSERT INTO `sys_user_role` VALUES (8, 2);

SET FOREIGN_KEY_CHECKS = 1;
