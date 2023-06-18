/*
 Navicat Premium Data Transfer

 Source Server         : mikevane
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : covid

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 18/06/2023 10:53:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nation_notice
-- ----------------------------
DROP TABLE IF EXISTS `nation_notice`;
CREATE TABLE `nation_notice`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知的标题',
  `publish_time` date NOT NULL COMMENT '通知发布的日期和时间',
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发布通知的教师或工作人员的姓名',
  `publisher_id` int(20) NOT NULL COMMENT '发布通知的教师或工作人员的id',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知的具体内容',
  `receiver` int(4) NULL DEFAULT NULL COMMENT '通知的接收者，班级 0 老师 1',
  `status` int(4) NOT NULL COMMENT '通知的状态，已发布 0、已撤销 1、已过期 2',
  `create_time` datetime NOT NULL COMMENT '通知创建时间',
  `update_time` datetime NOT NULL COMMENT '通知更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nation_notice
-- ----------------------------
INSERT INTO `nation_notice` VALUES (1, '关于进一步优化落实新冠肺炎疫情防控措施的通知', '2023-05-03', '张三', 8, '各省、自治区、直辖市及新疆生产建设兵团应对新型冠状病毒肺炎疫情联防联控机制（领导小组、指挥部），国务院应对新型冠状病毒肺炎疫情联防联控机制各成员单位：\n\n近期，各地各部门深入贯彻落实党中央、国务院决策部署，坚持第九版防控方案，落实二十条优化措施，持续整治层层加码问题，取得积极成效。根据当前疫情形势和病毒变异情况，为更加科学精准防控，切实解决防控工作中存在的突出问题，现就进一步优化落实疫情防控措施有关事项通知如下：\n\n一是科学精准划分风险区域。按楼栋、单元、楼层、住户划定高风险区，不得随意扩大到小区、社区和街道（乡镇）等区域。不得采取各种形式的临时封控。\n\n二是进一步优化核酸检测。不按行政区域开展全员核酸检测，进一步缩小核酸检测范围、减少频次。根据防疫工作需要，可开展抗原检测。对高风险岗位从业人员和高风险区人员按照有关规定进行核酸检测，其他人员愿检尽检。除养老院、福利院、医疗机构、托幼机构、中小学等特殊场所外，不要求提供核酸检测阴性证明，不查验健康码。重要机关、大型企业及一些特定场所可由属地自行确定防控措施。不再对跨地区流动人员查验核酸检测阴性证明和健康码，不再开展落地检。\n\n三是优化调整隔离方式。感染者要科学分类收治，具备居家隔离条件的无症状感染者和轻型病例一般采取居家隔离，也可自愿选择集中隔离收治。居家隔离期间加强健康监测，隔离第6、7天连续2次核酸检测Ct值≥35解除隔离，病情加重的及时转定点医院治疗。具备居家隔离条件的密切接触者采取5天居家隔离，也可自愿选择集中隔离，第5天核酸检测阴性后解除隔离。\n\n四是落实高风险区“快封快解”。连续5天没有新增感染者的高风险区，要及时解封。\n\n五是保障群众基本购药需求。各地药店要正常运营，不得随意关停。不得限制群众线上线下购买退热、止咳、抗病毒、治感冒等非处方药物。\n\n六是加快推进老年人新冠病毒疫苗接种。各地要坚持应接尽接原则，聚焦提高60-79岁人群接种率、加快提升80岁及以上人群接种率，作出专项安排。通过设立老年人绿色通道、临时接种点、流动接种车等措施，优化接种服务。要逐级开展接种禁忌判定的培训，指导医务人员科学判定接种禁忌。细化科普宣传，发动全社会力量参与动员老年人接种，各地可采取激励措施，调动老年人接种疫苗的积极性。\n\n七是加强重点人群健康情况摸底及分类管理。发挥基层医疗卫生机构“网底”和家庭医生健康“守门人”的作用，摸清辖区内患有心脑血管疾病、慢阻肺、糖尿病、慢性肾病、肿瘤、免疫功能缺陷等疾病的老年人及其新冠病毒疫苗接种情况，推进实施分级分类管理。\n\n八是保障社会正常运转和基本医疗服务。非高风险区不得限制人员流动，不得停工、停产、停业。将医务人员、公安、交通物流、商超、保供、水电气暖等保障基本医疗服务和社会正常运转人员纳入“白名单”管理，相关人员做好个人防护、疫苗接种和健康监测，保障正常医疗服务和基本生活物资、水电气暖等供给，尽力维护正常生产工作秩序，及时解决群众提出的急难愁盼问题，切实满足疫情处置期间群众基本生活需求。\n\n九是强化涉疫安全保障。严禁以各种方式封堵消防通道、单元门、小区门，确保群众看病就医、紧急避险等外出渠道通畅。推动建立社区与专门医疗机构的对接机制，为独居老人、未成年人、孕产妇、残疾人、慢性病患者等提供就医便利。强化对封控人员、患者和一线工作人员等的关心关爱和心理疏导。\n\n十是进一步优化学校疫情防控工作。各地各校要坚决落实科学精准防控要求，没有疫情的学校要开展正常的线下教学活动，校园内超市、食堂、体育场馆、图书馆等要正常开放。有疫情的学校要精准划定风险区域，风险区域外仍要保证正常的教学、生活等秩序。\n\n各地各有关部门要进一步提高政治站位，把思想和行动统一到党中央决策部署上来，坚持第九版防控方案、落实二十条优化措施、执行本通知要求，坚决纠正简单化、“一刀切”、层层加码等做法，反对和克服形式主义、官僚主义，抓严抓实抓细各项防控措施，最大程度保护人民生命安全和身体健康，最大限度减少疫情对经济社会发展的影响。\n\n国务院应对新型冠状病毒肺炎\n疫情联防联控机制综合组\n2022年12月7日\n\n（信息公开形式：主动公开）', 0, 0, '2023-05-03 11:49:01', '2023-05-03 11:49:01');
INSERT INTO `nation_notice` VALUES (2, '关于做好新冠肺炎互联网医疗服务的通知', '2023-05-04', '张三', 8, '各省、自治区、直辖市及新疆生产建设兵团应对新型冠状病毒肺炎疫情联防联控机制（领导小组、指挥部）：\n\n为贯彻落实《关于进一步优化落实新冠肺炎疫情防控措施的通知》，进一步发挥互联网医疗服务的积极作用，现就做好新冠肺炎互联网医疗服务有关工作通知如下：\n\n一、医疗机构（包括互联网医院、开展互联网诊疗服务的医疗机构）可以通过互联网诊疗平台，依据最新版新型冠状病毒肺炎诊疗方案有关要求，为出现新冠肺炎相关症状的患者、符合《新冠病毒感染者居家治疗指南》居家的，在线开具治疗新冠肺炎相关症状的处方，并鼓励委托符合条件的第三方将药品配送到患者家中。\n\n二、医疗机构开展互联网诊疗服务过程中，若发现患者病情出现变化或存在其他不适宜在线诊疗服务的，医师应当引导患者到实体医疗机构就诊。\n\n三、为方便人民群众获得健康咨询、就医指导、预约诊疗等服务，降低交叉感染风险，鼓励医疗机构提供24小时网上咨询服务，为儿童、孕产妇、老年人、透析患者和合并基础疾病的患者提供就医及心理咨询、用药指导等服务，同时积极开展分时段精准预约，缩短患者到院后等待时间。\n\n四、鼓励医联体内上级医院通过远程会诊、远程诊断、远程培训等方式提高基层医疗机构对高风险人群的识别、诊断和处置能力。\n\n五、县级及以上地方卫生健康行政部门应当加强对互联网诊疗服务的监管，医疗机构应当落实互联网诊疗服务的医疗质量安全责任，确保线上线下医疗服务一体化、医疗质量安全同质化。\n\n国务院应对新型冠状病毒肺炎疫情\n联防联控机制医疗救治组\n2022年12月11日', 0, 0, '2023-05-04 13:29:30', '2023-05-04 13:29:30');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知的标题',
  `publish_time` date NOT NULL COMMENT '通知发布的日期和时间',
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发布通知的教师或工作人员的姓名',
  `publisher_id` int(20) NOT NULL COMMENT '发布通知的教师或工作人员的id',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知的具体内容',
  `receiver` int(4) NULL DEFAULT NULL COMMENT '通知的接收者，班级 0 老师 1',
  `status` int(4) NOT NULL COMMENT '通知的状态，已发布 0、已撤销 1、已过期 2',
  `create_time` datetime NOT NULL COMMENT '通知创建时间',
  `update_time` datetime NOT NULL COMMENT '通知更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (2, '疫情防控通知', '2023-05-02', '张三', 8, '尊敬的同学们：\n\n全国新冠疫情形势依然严峻，为了保障同学们的健康与安全，特提醒大家加强疫情防控工作，做好个人防护措施。\n\n请大家在进入学校时佩戴好口罩，并遵守校园内的相关防疫规定，如量体温、勤洗手等。\n\n对于来自疫情严重地区的同学，请按照相关规定进行居家隔离观察，并及时向学校汇报相关情况。\n\n请同学们尽量减少外出，避免前往人员密集场所，并注意保持社交距离。\n\n如出现发热、咳嗽、乏力等疑似症状，请及时向学校报告，并到医院进行检查治疗。\n\n为了保障同学们的身体健康，学校将加强疫情防控措施，做好校园内的疫情防控工作。同时，学校将密切关注疫情变化，及时发布相关通知，为同学们提供最新的疫情信息和应对措施。\n\n希望同学们严格遵守疫情防控规定，做好个人防护措施，共同保护好自己和身边的人。\n\n请大家关注后续通知，如有疑问或需要帮助，请及时联系学院辅导员。\n\n谢谢！\n\n学院辅导员', 0, 0, '2023-05-02 21:15:26', '2023-05-02 21:15:26');
INSERT INTO `notice` VALUES (3, '关于组织学生参加线上模拟考试的通知', '2023-05-03', '张三', 8, '各同学：\n\n根据教学安排，本学期有部分课程采用线上考试方式，前期已组织教师开展了长江雨课堂、超星和科大讯飞考试的培训，为保证线上考试规范有序，现针对全校本科生在2022年12月6日星期二开展三个线上考试平台的多轮模拟考试，请各学院通知学生按照时间表选择合适时间，进入各考试系统，调试本人考试设备，熟悉考试操作流程、完整完成本次考试，为正式考试做好准备。\n\n学院模拟考试时间安排如下表所示，请各位同学选择自己合适的时段提前10分钟进入考场，每场考试15分钟。各平台详细操作手册见附件。', 0, 0, '2023-05-03 10:24:18', '2023-05-03 10:24:18');
INSERT INTO `notice` VALUES (4, '关于恢复线下教学活动的通知\n', '2020-10-16', '张三', 8, '各同学：\n        接学校通知，决定从2022年10月17日（第七周星期一）开始恢复线下教学活动，请各学院做好线下教学组织工作，严格审核师生每日健康状况，健康状况异常、健康码异常、未按要求完成健康管理措施及处于临时管控区域的师生不得参加线下教学活动。', 0, 0, '2023-05-03 10:26:38', '2023-05-03 10:46:55');
INSERT INTO `notice` VALUES (5, '2022年校运动会安排的通知\n', '2022-04-14', '张三', 8, '各位同学：\n      根据校办本周工作安排，2022年春季运动会时间为四月十五、十六日（第七周周五、周六）。四月十四日（第七周周四）正常行课。若因天气或其他特殊原因造成运动会无法正常进行，四月十五、十六日按照课表安排正常行课。', 0, 0, '2023-05-03 10:30:07', '2023-05-03 10:30:07');
INSERT INTO `notice` VALUES (6, '关于近期疫情期间相关教学安排的说明', '2021-11-04', '张三', 8, '各学院：\r\n\r\n    结合近期疫情防控情况，对教学相关事宜做如下安排，请参照执行。\r\n\r\n    一、请各学院认真梳理所承担理论课程的行课情况，做好转为在线教学的准备。针对实验及实践教学环节，请认真研判实验及实践教学环节课程特性，做好转为线上组织或暂缓组织的准备。并请结合实际情况，制定本学院疫情期间的教学实施方案。\r\n\r\n    二、行课期间师生应佩戴口罩、保持间距、打开门窗通风透气。因实验室条件限制，存在通风不良或环境密闭情况的，应立即暂停行课，视疫情发展情况调整安排。\r\n\r\n    三、所有集中类活动教室申请暂停两周。\r\n\r\n    四、安排在本周及下周的集中考试暂停，视疫情发展情况作相应调整。\r\n\r\n    五、请全面梳理排查实习实训开展情况，本周和下周暂停组织校外实习实训工作，各学院在未得到学校明确通知前不得自行前往实习地，视疫情发展情况调整安排。\r\n\r\n \r\n\r\n                                                教务处\r\n\r\n2021年11月4日', 0, 2, '2023-05-03 10:34:55', '2023-05-03 10:34:55');
INSERT INTO `notice` VALUES (7, '测试', '2023-06-05', '张三', 8, '测试测试', 0, 0, '2023-06-05 00:49:15', '2023-06-05 00:49:15');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
  `grade_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学生班级',
  `stu_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '性别',
  `nation` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '民族',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `admission_date` date NULL DEFAULT NULL COMMENT '入学日期',
  `major` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '专业',
  `college` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学院',
  `user_id` int(11) NOT NULL COMMENT '学生对应的 userid',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (5, 'mike', '34071903', '222222', '', NULL, '男', '', '', NULL, '', '', 2, '2023-03-09 14:01:34', '2023-04-26 10:51:54');
INSERT INTO `student` VALUES (6, 'mike', '34071903', '123', '1312706383@qq.com', '2000-01-18', '男', '苗族', '', NULL, '', '', 3, '2023-03-09 14:02:29', '2023-04-26 10:49:18');
INSERT INTO `student` VALUES (7, 'ly', '34071903', '2019211111', '123456@qq.com', '2001-07-26', '女', '土家族', '15272189558', '2019-04-03', '电子信息工程', '国际学院', 24, '2023-03-09 14:10:36', '2023-04-26 00:59:34');
INSERT INTO `student` VALUES (8, '郭浩', '34071903', '', '', NULL, '', '', '', NULL, '', '', 27, '2023-03-10 18:23:43', '2023-04-26 00:59:40');
INSERT INTO `student` VALUES (9, '文浩博', '34071903', '', '', NULL, '', '', '', NULL, '', '', 28, '2023-03-10 18:23:59', '2023-04-26 00:59:45');
INSERT INTO `student` VALUES (10, 'looyoo', '34071903', '', '', NULL, '', '', '', NULL, '', '', 29, '2023-03-11 01:17:33', '2023-04-26 00:59:42');
INSERT INTO `student` VALUES (11, 'peter', '34091902', '', '', NULL, '', '', '', NULL, '', '', 30, '2023-03-11 01:17:50', '2023-04-26 00:59:56');
INSERT INTO `student` VALUES (13, '13344444444', '', '123', '', NULL, '男', '', '13344444444', NULL, '', '', 32, '2023-03-12 01:00:23', '2023-03-20 10:45:00');
INSERT INTO `student` VALUES (16, '勇者', '34071903', '123456', '12316455', '2023-04-05', '男', '土家族', '123456', NULL, '', '', 41, '2023-04-09 20:35:19', '2023-05-13 13:26:56');
INSERT INTO `student` VALUES (17, '18325229222', '', '', '', NULL, '', '', '18325229222', NULL, '', '', 44, '2023-05-23 19:23:41', '2023-05-23 19:23:41');

-- ----------------------------
-- Table structure for student_clock
-- ----------------------------
DROP TABLE IF EXISTS `student_clock`;
CREATE TABLE `student_clock`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
  `grade_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学生班级',
  `stu_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学生学号',
  `student_id` int(20) NOT NULL COMMENT '学生对应的id',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '打卡地点',
  `status` int(6) NOT NULL COMMENT '身体状态 0健康 1疑似病例 2确诊',
  `travel_info` int(6) NOT NULL COMMENT '出行信息 0没有去过疫情高风险地区 1去过疫情高风险地区',
  `contact_case` int(6) NOT NULL COMMENT '是否接触疑似或确诊病例 0没有接触过 1接触过',
  `clock_time` datetime NOT NULL COMMENT '打卡时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_clock
-- ----------------------------
INSERT INTO `student_clock` VALUES (2, 'ly', '34071903', '2019211111', 7, '石柱', 0, 0, 0, '2023-04-17 12:41:17');
INSERT INTO `student_clock` VALUES (3, 'ly', '34071903', '2019211111', 7, '重庆市', 0, 0, 0, '2023-04-18 00:37:32');
INSERT INTO `student_clock` VALUES (4, 'ly', '34071903', '2019211111', 7, '重庆市', 2, 0, 0, '2023-04-27 00:37:32');
INSERT INTO `student_clock` VALUES (5, '勇者', '34071902', '123456', 16, '重庆邮电大学', 0, 0, 0, '2023-04-29 13:06:56');

-- ----------------------------
-- Table structure for student_leave
-- ----------------------------
DROP TABLE IF EXISTS `student_leave`;
CREATE TABLE `student_leave`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `stu_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学号',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学院',
  `grade_class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '班级',
  `type` int(5) NOT NULL COMMENT '出入校类型 0表示请假 1表示节假日出入校 2表示寒暑假出入校',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '外出地区',
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '外出详细地点',
  `reason` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '出校理由',
  `leave_time` datetime NOT NULL COMMENT '出校时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `student_id` int(11) NOT NULL COMMENT '学生id',
  `status` int(11) NOT NULL COMMENT '状态 -1表示未通过 0表示待处理 1表示通过',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_leave
-- ----------------------------
INSERT INTO `student_leave` VALUES (5, '2019211111', 'ly', '国际学院', '34071903', 0, '北京市市辖区东城区', '堕落街', '无', '2023-04-14 14:20:00', '', 7, 1, '2023-04-14 18:08:55');
INSERT INTO `student_leave` VALUES (6, '2019211111', 'ly', '国际学院', '34071903', 1, '重庆市县石柱土家族自治县', '苹果园', '回家', '2023-04-17 08:00:00', '', 7, 1, '2023-04-16 12:30:07');
INSERT INTO `student_leave` VALUES (7, '2019211111', 'ly', '国际学院', '34071903', 0, '天津市市辖区河西区', '无', '回家', '2023-04-28 08:00:00', '', 7, 1, '2023-04-27 11:57:03');
INSERT INTO `student_leave` VALUES (9, '123456', '勇者', '', '34071902', 0, '天津市市辖区河西区', '无', '吃饭', '2023-04-29 08:00:00', '', 16, -1, '2023-04-28 00:32:30');
INSERT INTO `student_leave` VALUES (10, '123456', '勇者', '', '34071902', 1, '天津市市辖区河西区', '回家', '回家', '2023-04-13 08:00:00', '', 16, 1, '2023-04-29 01:24:14');
INSERT INTO `student_leave` VALUES (11, '123456', '勇者', '', '34071902', 0, '天津市市辖区河西区', '堕落街', '吃饭', '2023-04-29 08:00:00', '', 16, 1, '2023-04-29 13:07:17');
INSERT INTO `student_leave` VALUES (12, '123456', '勇者', '', '34071903', 0, '北京市市辖区东城区', '不知道', '回家', '2023-05-29 08:00:00', '测试', 16, 0, '2023-05-13 14:19:50');
INSERT INTO `student_leave` VALUES (13, '2019211111', 'ly', '国际学院', '34071903', 0, '北京市市辖区丰台区', '无', '无', '2023-06-05 08:00:00', '', 7, 1, '2023-06-05 00:39:47');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老师姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '性别',
  `nation` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '民族',
  `start_date` date NULL DEFAULT NULL COMMENT '入职日期',
  `major` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '专业',
  `college` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学院',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (8, '张三', '123', '123456@qq.com', '1990-02-17', '男', '土家族', '2018-02-07', '电子信息', '人工智能', 42, '2023-04-18 13:01:51', '2023-05-03 10:31:41');
INSERT INTO `teacher` VALUES (9, '12345', '12345', '', NULL, '', '', NULL, '', '', 43, '2023-04-18 13:38:29', '2023-04-18 13:38:29');

-- ----------------------------
-- Table structure for teacher_grade
-- ----------------------------
DROP TABLE IF EXISTS `teacher_grade`;
CREATE TABLE `teacher_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL COMMENT '老师id',
  `grade_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_grade
-- ----------------------------
INSERT INTO `teacher_grade` VALUES (1, 8, '34071903', '2023-03-09 14:01:34', '2023-03-09 14:01:34');
INSERT INTO `teacher_grade` VALUES (2, 8, '34071902', '2023-03-09 14:01:34', '2023-03-09 14:01:34');
INSERT INTO `teacher_grade` VALUES (13, 9, '34081901', '2023-04-24 14:00:00', '2023-04-24 14:00:00');
INSERT INTO `teacher_grade` VALUES (16, 8, '34091902', '2023-04-26 00:03:43', '2023-04-26 00:03:43');
INSERT INTO `teacher_grade` VALUES (17, 8, '34071901', '2023-04-26 00:56:17', '2023-04-26 00:56:17');
INSERT INTO `teacher_grade` VALUES (19, 8, '34071904', '2023-04-26 01:11:40', '2023-04-26 01:11:40');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `identity` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (23, '', '123456', '学生', '2023-03-09 13:47:11', '2023-03-09 13:47:11');
INSERT INTO `user` VALUES (24, '15272189558', '06a8647723d4d285aefdb02ed285220b', '学生', '2023-03-09 14:10:36', '2023-03-09 14:10:36');
INSERT INTO `user` VALUES (32, '13344444444', '06a8647723d4d285aefdb02ed285220b', '学生', '2023-03-12 01:00:23', '2023-03-12 01:00:23');
INSERT INTO `user` VALUES (33, '123456', '96e79218965eb72c92a549dd5a330112', '老师', '2023-03-19 19:12:50', '2023-03-19 19:12:50');
INSERT INTO `user` VALUES (41, '123456', '06a8647723d4d285aefdb02ed285220b', '学生', '2023-04-09 20:35:19', '2023-04-09 20:35:19');
INSERT INTO `user` VALUES (42, '123', '06a8647723d4d285aefdb02ed285220b', '老师', '2023-04-18 13:01:51', '2023-04-18 13:01:51');
INSERT INTO `user` VALUES (43, '12345', '06a8647723d4d285aefdb02ed285220b', '老师', '2023-04-18 13:38:29', '2023-04-18 13:38:29');
INSERT INTO `user` VALUES (44, '18325229222', '06a8647723d4d285aefdb02ed285220b', '学生', '2023-05-23 19:23:41', '2023-05-23 19:23:41');

SET FOREIGN_KEY_CHECKS = 1;
