/*
 Navicat Premium Data Transfer

 Source Server         : VM-WEIXIN
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 192.168.0.102:3306
 Source Schema         : sell

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/02/2019 08:56:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1547110001229907857', '1547110001162537870', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-10 16:46:48', '2019-01-10 16:46:48');
INSERT INTO `order_detail` VALUES ('1547110235685242422', '1547110235620880640', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-10 16:50:34', '2019-01-10 16:50:34');
INSERT INTO `order_detail` VALUES ('1547111385530559120', '1547111385469176792', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-10 17:09:44', '2019-01-10 17:09:44');
INSERT INTO `order_detail` VALUES ('1547111542936482626', '1547111542873930524', '123123', '炸鸡翅', 0.01, 1, 'http://zxcvbn.jpg', '2019-01-10 17:12:21', '2019-01-10 17:12:21');
INSERT INTO `order_detail` VALUES ('1547111542956820798', '1547111542873930524', '123469', '麻辣烫', 0.02, 1, 'http://xxxxxx.jpg', '2019-01-10 17:12:21', '2019-01-10 17:12:21');
INSERT INTO `order_detail` VALUES ('1547111648960992847', '1547111648891126149', '123123', '炸鸡翅', 0.01, 1, 'http://zxcvbn.jpg', '2019-01-10 17:14:08', '2019-01-10 17:14:08');
INSERT INTO `order_detail` VALUES ('1547111648976701229', '1547111648891126149', '123469', '麻辣烫', 0.02, 3, 'http://xxxxxx.jpg', '2019-01-10 17:14:08', '2019-01-10 17:14:08');
INSERT INTO `order_detail` VALUES ('1547117006929965713', '1547117006864121210', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-10 18:43:25', '2019-01-10 18:43:25');
INSERT INTO `order_detail` VALUES ('1547117006947403296', '1547117006864121210', '123469', '麻辣烫', 0.02, 2, 'http://xxxxxx.jpg', '2019-01-10 18:43:25', '2019-01-10 18:43:25');
INSERT INTO `order_detail` VALUES ('1547120382185490955', '1547120382183750965', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-10 19:39:40', '2019-01-10 19:39:40');
INSERT INTO `order_detail` VALUES ('1547121027536720218', '1547121027494640721', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-10 19:50:25', '2019-01-10 19:50:25');
INSERT INTO `order_detail` VALUES ('1547121078147484094', '1547121078144627969', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-10 19:51:16', '2019-01-10 19:51:16');
INSERT INTO `order_detail` VALUES ('1547192430673634273', '1547192430657869205', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:40:30', '2019-01-11 15:40:30');
INSERT INTO `order_detail` VALUES ('1547192430691441396', '1547192430657869205', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:40:30', '2019-01-11 15:40:30');
INSERT INTO `order_detail` VALUES ('1547192459299343744', '1547192459296264027', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:40:59', '2019-01-11 15:40:59');
INSERT INTO `order_detail` VALUES ('1547192459303929121', '1547192459296264027', '123123', '炸鸡翅', 0.01, 1, 'http://zxcvbn.jpg', '2019-01-11 15:40:59', '2019-01-11 15:40:59');
INSERT INTO `order_detail` VALUES ('1547192484322728831', '1547192484320453142', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:41:24', '2019-01-11 15:41:24');
INSERT INTO `order_detail` VALUES ('1547192484325822527', '1547192484320453142', '123469', '麻辣烫', 0.02, 1, 'http://xxxxxx.jpg', '2019-01-11 15:41:24', '2019-01-11 15:41:24');
INSERT INTO `order_detail` VALUES ('1547192490734637236', '1547192490732338914', '123469', '麻辣烫', 0.02, 1, 'http://xxxxxx.jpg', '2019-01-11 15:41:30', '2019-01-11 15:41:30');
INSERT INTO `order_detail` VALUES ('1547192505120107141', '1547192505118265502', '123469', '麻辣烫', 0.02, 4, 'http://xxxxxx.jpg', '2019-01-11 15:41:45', '2019-01-11 15:41:45');
INSERT INTO `order_detail` VALUES ('1547192518090751474', '1547192518089277425', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:41:58', '2019-01-11 15:41:58');
INSERT INTO `order_detail` VALUES ('1547192518094986889', '1547192518089277425', '123469', '麻辣烫', 0.02, 4, 'http://xxxxxx.jpg', '2019-01-11 15:41:58', '2019-01-11 15:41:58');
INSERT INTO `order_detail` VALUES ('1547192538477167976', '1547192538475765031', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:42:18', '2019-01-11 15:42:18');
INSERT INTO `order_detail` VALUES ('1547192538480403596', '1547192538475765031', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:42:18', '2019-01-11 15:42:18');
INSERT INTO `order_detail` VALUES ('1547192542045640562', '1547192542043306900', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:42:22', '2019-01-11 15:42:22');
INSERT INTO `order_detail` VALUES ('1547192542048952997', '1547192542043306900', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-11 15:42:22', '2019-01-11 15:42:22');
INSERT INTO `order_detail` VALUES ('1547192545726979624', '1547192545724489205', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:42:25', '2019-01-11 15:42:25');
INSERT INTO `order_detail` VALUES ('1547192545729298090', '1547192545724489205', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-11 15:42:25', '2019-01-11 15:42:25');
INSERT INTO `order_detail` VALUES ('1547192548844280182', '1547192548841396692', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:42:28', '2019-01-11 15:42:28');
INSERT INTO `order_detail` VALUES ('1547192548848591018', '1547192548841396692', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-11 15:42:28', '2019-01-11 15:42:28');
INSERT INTO `order_detail` VALUES ('1547192552497891922', '1547192552494723884', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:42:32', '2019-01-11 15:42:32');
INSERT INTO `order_detail` VALUES ('1547192552502145686', '1547192552494723884', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:42:32', '2019-01-11 15:42:32');
INSERT INTO `order_detail` VALUES ('1547192556653808033', '1547192556651665978', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:42:36', '2019-01-11 15:42:36');
INSERT INTO `order_detail` VALUES ('1547192556657582693', '1547192556651665978', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:42:36', '2019-01-11 15:42:36');
INSERT INTO `order_detail` VALUES ('1547192561369190096', '1547192561368552073', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:42:41', '2019-01-11 15:42:41');
INSERT INTO `order_detail` VALUES ('1547192561372426425', '1547192561368552073', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-11 15:42:41', '2019-01-11 15:42:41');
INSERT INTO `order_detail` VALUES ('1547192659669836074', '1547192659668981968', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:44:19', '2019-01-11 15:44:19');
INSERT INTO `order_detail` VALUES ('1547192659672308672', '1547192659668981968', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:44:19', '2019-01-11 15:44:19');
INSERT INTO `order_detail` VALUES ('1547192665422875870', '1547192665421359170', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:44:25', '2019-01-11 15:44:25');
INSERT INTO `order_detail` VALUES ('1547192665425296776', '1547192665421359170', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:44:25', '2019-01-11 15:44:25');
INSERT INTO `order_detail` VALUES ('1547192670639494000', '1547192670638956008', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:30', '2019-01-11 15:44:30');
INSERT INTO `order_detail` VALUES ('1547192670642966501', '1547192670638956008', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:44:30', '2019-01-11 15:44:30');
INSERT INTO `order_detail` VALUES ('1547192675139705634', '1547192675138544142', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:35', '2019-01-11 15:44:35');
INSERT INTO `order_detail` VALUES ('1547192675141127369', '1547192675138544142', '123123', '炸鸡翅', 0.01, 6, 'http://zxcvbn.jpg', '2019-01-11 15:44:35', '2019-01-11 15:44:35');
INSERT INTO `order_detail` VALUES ('1547192678766956921', '1547192678765353727', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:38', '2019-01-11 15:44:38');
INSERT INTO `order_detail` VALUES ('1547192678768642473', '1547192678765353727', '123123', '炸鸡翅', 0.01, 1, 'http://zxcvbn.jpg', '2019-01-11 15:44:38', '2019-01-11 15:44:38');
INSERT INTO `order_detail` VALUES ('1547192682243492037', '1547192682241364441', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:42', '2019-01-11 15:44:42');
INSERT INTO `order_detail` VALUES ('1547192682247521887', '1547192682241364441', '123123', '炸鸡翅', 0.01, 2, 'http://zxcvbn.jpg', '2019-01-11 15:44:42', '2019-01-11 15:44:42');
INSERT INTO `order_detail` VALUES ('1547192685442567421', '1547192685441473606', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:45', '2019-01-11 15:44:45');
INSERT INTO `order_detail` VALUES ('1547192685447840192', '1547192685441473606', '123123', '炸鸡翅', 0.01, 3, 'http://zxcvbn.jpg', '2019-01-11 15:44:45', '2019-01-11 15:44:45');
INSERT INTO `order_detail` VALUES ('1547192688650142329', '1547192688649965403', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:48', '2019-01-11 15:44:48');
INSERT INTO `order_detail` VALUES ('1547192688652921998', '1547192688649965403', '123123', '炸鸡翅', 0.01, 4, 'http://zxcvbn.jpg', '2019-01-11 15:44:48', '2019-01-11 15:44:48');
INSERT INTO `order_detail` VALUES ('1547192692448145752', '1547192692446581355', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:52', '2019-01-11 15:44:52');
INSERT INTO `order_detail` VALUES ('1547192692451785068', '1547192692446581355', '123123', '炸鸡翅', 0.01, 5, 'http://zxcvbn.jpg', '2019-01-11 15:44:52', '2019-01-11 15:44:52');
INSERT INTO `order_detail` VALUES ('1547192695844379359', '1547192695843754515', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:55', '2019-01-11 15:44:55');
INSERT INTO `order_detail` VALUES ('1547192695847790695', '1547192695843754515', '123123', '炸鸡翅', 0.01, 6, 'http://zxcvbn.jpg', '2019-01-11 15:44:55', '2019-01-11 15:44:55');
INSERT INTO `order_detail` VALUES ('1547192699063237534', '1547192699062836208', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:44:59', '2019-01-11 15:44:59');
INSERT INTO `order_detail` VALUES ('1547192699066641688', '1547192699062836208', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:44:59', '2019-01-11 15:44:59');
INSERT INTO `order_detail` VALUES ('1547192703627232341', '1547192703624764930', '123456', '皮蛋瘦肉粥', 0.02, 1, 'http://?????.jpg', '2019-01-11 15:45:03', '2019-01-11 15:45:03');
INSERT INTO `order_detail` VALUES ('1547192703633561425', '1547192703624764930', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:45:03', '2019-01-11 15:45:03');
INSERT INTO `order_detail` VALUES ('1547192706650508540', '1547192706648576722', '123456', '皮蛋瘦肉粥', 0.02, 2, 'http://?????.jpg', '2019-01-11 15:45:06', '2019-01-11 15:45:06');
INSERT INTO `order_detail` VALUES ('1547192706652622904', '1547192706648576722', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:45:06', '2019-01-11 15:45:06');
INSERT INTO `order_detail` VALUES ('1547192710835995523', '1547192710834883488', '123456', '皮蛋瘦肉粥', 0.02, 3, 'http://?????.jpg', '2019-01-11 15:45:10', '2019-01-11 15:45:10');
INSERT INTO `order_detail` VALUES ('1547192710838811545', '1547192710834883488', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:45:10', '2019-01-11 15:45:10');
INSERT INTO `order_detail` VALUES ('1547192714325357554', '1547192714323486797', '123456', '皮蛋瘦肉粥', 0.02, 4, 'http://?????.jpg', '2019-01-11 15:45:14', '2019-01-11 15:45:14');
INSERT INTO `order_detail` VALUES ('1547192714328396418', '1547192714323486797', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:45:14', '2019-01-11 15:45:14');
INSERT INTO `order_detail` VALUES ('1547192720115432914', '1547192720114441170', '123456', '皮蛋瘦肉粥', 0.02, 5, 'http://?????.jpg', '2019-01-11 15:45:20', '2019-01-11 15:45:20');
INSERT INTO `order_detail` VALUES ('1547192720117817794', '1547192720114441170', '123123', '炸鸡翅', 0.01, 7, 'http://zxcvbn.jpg', '2019-01-11 15:45:20', '2019-01-11 15:45:20');
INSERT INTO `order_detail` VALUES ('1547550386866847728', '1547550386857905209', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:04:00', '2019-01-15 19:04:00');
INSERT INTO `order_detail` VALUES ('1547550623731418448', '1547550623724540720', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:07:57', '2019-01-15 19:07:57');
INSERT INTO `order_detail` VALUES ('1547551059027839890', '1547551059018186825', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:15:12', '2019-01-15 19:15:12');
INSERT INTO `order_detail` VALUES ('1547551178441399567', '1547551178437311670', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:17:12', '2019-01-15 19:17:12');
INSERT INTO `order_detail` VALUES ('1547551185669840642', '1547551185664892661', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:17:19', '2019-01-15 19:17:19');
INSERT INTO `order_detail` VALUES ('1547551197354693919', '1547551197350903933', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:17:31', '2019-01-15 19:17:31');
INSERT INTO `order_detail` VALUES ('1547551266000802589', '1547551265997599437', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:18:39', '2019-01-15 19:18:39');
INSERT INTO `order_detail` VALUES ('1547551417915249469', '1547551417913334900', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:21:11', '2019-01-15 19:21:11');
INSERT INTO `order_detail` VALUES ('1547551595834657071', '1547551595832983108', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:24:09', '2019-01-15 19:24:09');
INSERT INTO `order_detail` VALUES ('1547552034839551673', '1547552034828773187', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-15 19:31:28', '2019-01-15 19:31:28');
INSERT INTO `order_detail` VALUES ('1547585971743559558', '1547585971740384562', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 04:57:04', '2019-01-16 04:57:04');
INSERT INTO `order_detail` VALUES ('1547588103117845898', '1547588103112151127', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 05:32:35', '2019-01-16 05:32:35');
INSERT INTO `order_detail` VALUES ('1547588401913429512', '1547588401905268474', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 05:37:34', '2019-01-16 05:37:34');
INSERT INTO `order_detail` VALUES ('1547588846161158032', '1547588846151535734', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 05:44:58', '2019-01-16 05:44:58');
INSERT INTO `order_detail` VALUES ('1547589147283665258', '1547589147270750446', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 05:50:00', '2019-01-16 05:50:00');
INSERT INTO `order_detail` VALUES ('1547589592566625402', '1547589592559304829', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 05:57:25', '2019-01-16 05:57:25');
INSERT INTO `order_detail` VALUES ('1547589967381235674', '1547589967373260254', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 06:03:40', '2019-01-16 06:03:40');
INSERT INTO `order_detail` VALUES ('1547590171883438269', '1547590171874572904', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 06:07:04', '2019-01-16 06:07:04');
INSERT INTO `order_detail` VALUES ('1547591515123592865', '1547591515110834604', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 06:29:27', '2019-01-16 06:29:27');
INSERT INTO `order_detail` VALUES ('1547602370372367036', '1547602370368214505', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 09:30:22', '2019-01-16 09:30:22');
INSERT INTO `order_detail` VALUES ('1547602670249123530', '1547602670244832362', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 09:35:22', '2019-01-16 09:35:22');
INSERT INTO `order_detail` VALUES ('1547602901271972279', '1547602901265736116', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 09:39:13', '2019-01-16 09:39:13');
INSERT INTO `order_detail` VALUES ('1547603176999516937', '1547603176989256935', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 09:43:49', '2019-01-16 09:43:49');
INSERT INTO `order_detail` VALUES ('1547605844691899179', '1547605844677594484', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 10:28:17', '2019-01-16 10:28:17');
INSERT INTO `order_detail` VALUES ('1547606949873358740', '1547606949860855268', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 10:46:42', '2019-01-16 10:46:42');
INSERT INTO `order_detail` VALUES ('1547607164604774271', '1547607164602530227', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 10:50:16', '2019-01-16 10:50:16');
INSERT INTO `order_detail` VALUES ('1547608080552762271', '1547608080551247388', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 11:05:32', '2019-01-16 11:05:32');
INSERT INTO `order_detail` VALUES ('1547608503526930493', '1547608503524621815', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 11:12:35', '2019-01-16 11:12:35');
INSERT INTO `order_detail` VALUES ('1547608739924345586', '1547608739919809195', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 11:16:32', '2019-01-16 11:16:32');
INSERT INTO `order_detail` VALUES ('1547608872279433909', '1547608872268851827', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 11:18:44', '2019-01-16 11:18:44');
INSERT INTO `order_detail` VALUES ('1547629507825909726', '1547629507817761606', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 17:02:40', '2019-01-16 17:02:40');
INSERT INTO `order_detail` VALUES ('1547630041742339784', '1547630041731683327', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 17:11:34', '2019-01-16 17:11:34');
INSERT INTO `order_detail` VALUES ('1547630229214837413', '1547630229204959975', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 17:14:42', '2019-01-16 17:14:42');
INSERT INTO `order_detail` VALUES ('1547630457838442480', '1547630457828458053', '1547311396296363099', '皮皮虾', 0.01, 1, 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', '2019-01-16 17:18:31', '2019-01-16 17:18:31');
INSERT INTO `order_detail` VALUES ('1547714869909316314', '1547714869896664809', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 16:45:21', '2019-01-17 16:45:21');
INSERT INTO `order_detail` VALUES ('1547714869924221953', '1547714869896664809', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 16:45:21', '2019-01-17 16:45:21');
INSERT INTO `order_detail` VALUES ('1547715041072377754', '1547715041069147458', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 16:48:12', '2019-01-17 16:48:12');
INSERT INTO `order_detail` VALUES ('1547715041077208619', '1547715041069147458', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 16:48:12', '2019-01-17 16:48:12');
INSERT INTO `order_detail` VALUES ('1547715097964201228', '1547715097957263738', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 16:49:09', '2019-01-17 16:49:09');
INSERT INTO `order_detail` VALUES ('1547715097970956829', '1547715097957263738', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 16:49:09', '2019-01-17 16:49:09');
INSERT INTO `order_detail` VALUES ('1547715112080308841', '1547715112077949525', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 16:49:23', '2019-01-17 16:49:23');
INSERT INTO `order_detail` VALUES ('1547715112084480709', '1547715112077949525', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 16:49:23', '2019-01-17 16:49:23');
INSERT INTO `order_detail` VALUES ('1547717511328466839', '1547717511310477309', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:29:23', '2019-01-17 17:29:23');
INSERT INTO `order_detail` VALUES ('1547717511351290934', '1547717511310477309', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:29:23', '2019-01-17 17:29:23');
INSERT INTO `order_detail` VALUES ('1547717537051880097', '1547717537048271234', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:29:48', '2019-01-17 17:29:48');
INSERT INTO `order_detail` VALUES ('1547717537055223360', '1547717537048271234', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:29:48', '2019-01-17 17:29:48');
INSERT INTO `order_detail` VALUES ('1547718164541395872', '1547718164525424561', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:40:16', '2019-01-17 17:40:16');
INSERT INTO `order_detail` VALUES ('1547718164558521350', '1547718164525424561', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:40:16', '2019-01-17 17:40:16');
INSERT INTO `order_detail` VALUES ('1547718311400178427', '1547718311398852285', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:42:43', '2019-01-17 17:42:43');
INSERT INTO `order_detail` VALUES ('1547718311408674929', '1547718311398852285', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:42:43', '2019-01-17 17:42:43');
INSERT INTO `order_detail` VALUES ('1547718428113576320', '1547718428101851540', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:44:39', '2019-01-17 17:44:39');
INSERT INTO `order_detail` VALUES ('1547718428127365698', '1547718428101851540', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:44:39', '2019-01-17 17:44:39');
INSERT INTO `order_detail` VALUES ('1547718597548865819', '1547718597536642469', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:47:29', '2019-01-17 17:47:29');
INSERT INTO `order_detail` VALUES ('1547718597562853561', '1547718597536642469', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:47:29', '2019-01-17 17:47:29');
INSERT INTO `order_detail` VALUES ('1547718623134728139', '1547718623132798004', '123456', '皮蛋瘦肉粥', 0.02, 1, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', '2019-01-17 17:47:54', '2019-01-17 17:47:54');
INSERT INTO `order_detail` VALUES ('1547718623137581207', '1547718623132798004', '123123', '炸鸡翅', 0.01, 1, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', '2019-01-17 17:47:54', '2019-01-17 17:47:54');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态，默认0新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态，默认0未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1547192552494723884', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:42:32', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192556651665978', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:42:36', '2019-01-16 07:58:14');
INSERT INTO `order_master` VALUES ('1547192561368552073', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:42:41', '2019-01-16 07:58:14');
INSERT INTO `order_master` VALUES ('1547192659668981968', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:19', '2019-01-16 07:58:14');
INSERT INTO `order_master` VALUES ('1547192665421359170', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:25', '2019-01-16 07:58:45');
INSERT INTO `order_master` VALUES ('1547192670638956008', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:30', '2019-01-16 07:58:45');
INSERT INTO `order_master` VALUES ('1547192675138544142', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:35', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192678765353727', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:38', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192682241364441', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:42', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192685441473606', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:45', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192688649965403', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:48', '2019-01-16 07:59:54');
INSERT INTO `order_master` VALUES ('1547192692446581355', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:52', '2019-01-16 07:59:01');
INSERT INTO `order_master` VALUES ('1547192695843754515', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:55', '2019-01-16 07:59:01');
INSERT INTO `order_master` VALUES ('1547192699062836208', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:44:59', '2019-01-16 07:59:01');
INSERT INTO `order_master` VALUES ('1547192703624764930', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:45:03', '2019-01-16 07:59:01');
INSERT INTO `order_master` VALUES ('1547192706648576722', ' 张三', '18868822111', ' 慕课网总部', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-11 15:45:06', '2019-01-16 07:59:01');
INSERT INTO `order_master` VALUES ('1547192710834883488', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.13, 0, 0, '2019-01-11 15:45:10', '2019-01-11 15:45:10');
INSERT INTO `order_master` VALUES ('1547192714323486797', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.15, 0, 0, '2019-01-11 15:45:14', '2019-01-11 15:45:14');
INSERT INTO `order_master` VALUES ('1547192720114441170', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.17, 2, 0, '2019-01-11 15:45:20', '2019-01-11 19:43:41');
INSERT INTO `order_master` VALUES ('1547588846151535734', 'yao', '1234567', 'd d d d d d d', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 05:44:58', '2019-01-16 05:44:58');
INSERT INTO `order_master` VALUES ('1547589147270750446', '海滨', 'aaaaa', 'wwwwww', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 05:50:00', '2019-01-16 05:50:00');
INSERT INTO `order_master` VALUES ('1547589592559304829', '犹犹豫豫', 'qqqqqqqqqqq', 'aaaaaa', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 05:57:25', '2019-01-16 05:57:25');
INSERT INTO `order_master` VALUES ('1547589967373260254', '有意义', '1233455678', 'qqqqqq', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 06:03:40', '2019-01-16 06:03:40');
INSERT INTO `order_master` VALUES ('1547590171874572904', '姚彬', '122332111wwww', '益乐路', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 06:07:04', '2019-01-16 06:07:04');
INSERT INTO `order_master` VALUES ('1547591515110834604', '姚', 'qqqqdddddd', '文一西路', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 06:29:27', '2019-01-16 06:29:27');
INSERT INTO `order_master` VALUES ('1547602370368214505', 'aaaaa', '122345678', '西游记', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 09:30:22', '2019-01-16 09:30:22');
INSERT INTO `order_master` VALUES ('1547602670244832362', '姚', '09876543212', '西斗门', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 09:35:22', '2019-01-16 09:35:22');
INSERT INTO `order_master` VALUES ('1547602901265736116', '亚欧', '12334567884', '监督局', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 0, '2019-01-16 09:39:13', '2019-01-16 09:39:13');
INSERT INTO `order_master` VALUES ('1547603176989256935', '亿元', '12445778999', '红绿灯', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 09:43:49', '2019-01-16 10:48:04');
INSERT INTO `order_master` VALUES ('1547605844677594484', '皮蓬', '12344567890123', '公牛', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 10:28:17', '2019-01-16 10:28:27');
INSERT INTO `order_master` VALUES ('1547606949860855268', '皮蛋', '12235690532', '皮球', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 10:46:42', '2019-01-16 10:46:50');
INSERT INTO `order_master` VALUES ('1547607164602530227', '到底', '123567833987', '地球一号', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 10:50:16', '2019-01-16 10:50:24');
INSERT INTO `order_master` VALUES ('1547608080551247388', '好好好好', '098765442023', '屋里', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 11:05:32', '2019-01-16 11:05:47');
INSERT INTO `order_master` VALUES ('1547608503524621815', '再试试', '123456789098', '图书馆', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 11:12:35', '2019-01-16 11:12:43');
INSERT INTO `order_master` VALUES ('1547608739919809195', '天天', '1234567890987', '西溪科技', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 11:16:32', '2019-01-16 11:16:40');
INSERT INTO `order_master` VALUES ('1547608872268851827', '最好的', '1234567890987', '天堂影院', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 0, 1, '2019-01-16 11:18:44', '2019-01-16 11:18:52');
INSERT INTO `order_master` VALUES ('1547629507817761606', '亿邦', '450721199009', '亿邦大厦', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 2, 1, '2019-01-16 17:02:40', '2019-01-16 17:03:07');
INSERT INTO `order_master` VALUES ('1547630041731683327', '海合会', '12344675431', '清分馆', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 2, 1, '2019-01-16 17:11:34', '2019-01-16 17:11:57');
INSERT INTO `order_master` VALUES ('1547630229204959975', '宝贝', '135666667788', '被窝儿', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 2, 1, '2019-01-16 17:14:42', '2019-01-16 17:15:16');
INSERT INTO `order_master` VALUES ('1547630457828458053', '姚彬下午', '6666666666666', '益乐村', 'oTgZpwRxqIBnfgeTfOLeXbK7EttE', 0.01, 2, 1, '2019-01-16 17:18:31', '2019-01-16 17:18:57');
INSERT INTO `order_master` VALUES ('1547714869896664809', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 16:45:21', '2019-01-17 16:45:21');
INSERT INTO `order_master` VALUES ('1547715041069147458', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 16:48:12', '2019-01-17 16:48:12');
INSERT INTO `order_master` VALUES ('1547715097957263738', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 16:49:09', '2019-01-17 16:49:09');
INSERT INTO `order_master` VALUES ('1547715112077949525', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 16:49:23', '2019-01-17 16:49:23');
INSERT INTO `order_master` VALUES ('1547717511310477309', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:29:23', '2019-01-17 17:29:23');
INSERT INTO `order_master` VALUES ('1547717537048271234', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:29:48', '2019-01-17 17:29:48');
INSERT INTO `order_master` VALUES ('1547718164525424561', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:40:16', '2019-01-17 17:40:16');
INSERT INTO `order_master` VALUES ('1547718311398852285', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:42:43', '2019-01-17 17:42:43');
INSERT INTO `order_master` VALUES ('1547718428101851540', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:44:39', '2019-01-17 17:44:39');
INSERT INTO `order_master` VALUES ('1547718597536642469', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:47:29', '2019-01-17 17:47:29');
INSERT INTO `order_master` VALUES ('1547718623132798004', ' 张三', '18868822111', ' 慕课网总部', 'ew3euwhd7sjw9diwkq', 0.03, 0, 0, '2019-01-17 17:47:54', '2019-01-17 17:47:54');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热销榜', 1, '2019-01-07 06:37:01', '2019-01-13 19:26:13');
INSERT INTO `product_category` VALUES (2, '女生最爱', 3, '2019-01-07 06:48:33', '2019-01-07 07:50:51');
INSERT INTO `product_category` VALUES (5, '健身一族', 7, '2019-01-07 07:53:00', '2019-01-07 08:07:11');
INSERT INTO `product_category` VALUES (8, '男生喜爱', 9, '2019-01-07 09:34:04', '2019-01-07 09:19:23');
INSERT INTO `product_category` VALUES (9, '冬日暖胃', 10, '2019-01-13 19:26:47', '2019-01-13 19:26:47');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小图',
  `product_status` tinyint(3) NOT NULL,
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123123', '炸鸡翅', 0.01, 289, '夏夜美食', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=827192067,3791341322&fm=26&gp=0.jpg', 0, 7, '2019-01-07 17:42:47', '2019-01-17 17:47:54');
INSERT INTO `product_info` VALUES ('123456', '皮蛋瘦肉粥', 0.02, 789, '早餐夜宵首选', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3388396326,1890472459&fm=26&gp=0.jpg', 0, 3, '2019-01-07 09:54:47', '2019-01-17 17:47:54');
INSERT INTO `product_info` VALUES ('123469', '麻辣烫', 0.02, 500, '蔬菜多多，搭配健康', 'https://www.3158.cn/data/attachment/album/2015/08/20/20150820091335864718.jpg', 0, 3, '2019-01-07 10:36:44', '2019-01-15 01:31:39');
INSERT INTO `product_info` VALUES ('1547311396296363099', '皮皮虾', 0.01, 571, '香脆', 'https://ali.xinshipu.cn/20160430/original/1461985793918.jpg@180w_118h_99q_1e_1c.jpg', 0, 1, '2019-01-13 00:43:16', '2019-01-16 17:18:57');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info`  (
  `seller_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信openid',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`seller_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '卖家信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1547387415459638099', 'Baron', '123456', 'o9AREv0a9xie4s50xp3PZ0kVzYMA', '2019-01-13 21:50:15', '2019-01-17 00:42:29');

SET FOREIGN_KEY_CHECKS = 1;