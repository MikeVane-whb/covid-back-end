# covid-back-end

## 项目简介

本项目是本人的毕业设计，如果有粗糙的地方请大家多多指正。

下面开始介绍本项目，该项目是本人基于校园疫情开发的**疫情管理系统**，本项目为**前后端分离**项目，项目技术为：`SpringBoot、MyBatis-Plus、JWT、Vue`以及其他技术。本项目主要面向用户群体为学生与教师，后续可能会添加管理员等其他用户。

- > 前端入口：https://github.com/MikeVane-whb/covid-front-end

- > 后端入口：https://github.com/MikeVane-whb/covid-back-end

---

## 配置运行环境

1. JDK 1.8
2. MySQL 5.7
3. IDEA 2022
4. 设置**application.yaml**中的mysql账户名以及密码
5. 将前端的**axios.js**文件中的**URL**地址改为自己服务器地址

---

## 功能介绍

1. 个人信息：用户通过该功能进行查询与修改个人信息配置。
2. 学生管理：教师管理班级信息以及学生基本信息。
3. 疫情管理：教师管理学生打卡情况以及学生状态。
4. 请假管理：教师管理学生请假审批情况。
5. 通知管理：教师管理校内或国内疫情通知情况。
6. 疫情打卡：学生进行打卡以及查询历史打卡操作。
7. 申请请假：学生进行请假以及查询请假审批情况操作。
8. 查看通知：学生进行查看校内或国内疫情情况操作。

---

## 演示图

### 个人信息

![个人信息](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142232107.png)

![修改密码](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142300405.png)

### 学生管理

![班级管理](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142349849.png)

![学生管理](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142402853.png)

### 疫情管理

![学生打卡情况](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142439050.png)

![学生状态](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142459045.png)

### 请假管理

![待审批](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142535055.png)

![已审批](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142544232.png)

### 通知管理

![校内通知](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142556543.png)

![国内通知](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142610341.png)

### 疫情打卡

![疫情打卡](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142706188.png)

![打卡情况](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142722551.png)

### 申请请假

![申请出校](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142739941.png)

![申请情况](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142750388.png)

### 查看通知

![通知中心](https://mikevane.oss-cn-chengdu.aliyuncs.com/img/%E6%AF%95%E8%AE%BE/%E5%9B%BE%E7%89%87image-20230713142816513.png)