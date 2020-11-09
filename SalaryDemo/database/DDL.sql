--产品信息表
CREATE TABLE `mysql`.`salary_products_info`  (
  `product_name` varchar(255) CHARACTER SET utf8  NOT NULL COMMENT '日期',
  `product_price` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`product_name`) USING BTREE,
  INDEX `index1`(`product_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 ROW_FORMAT = Dynamic;




--工人发工资日志表：日期 记录 总额 mac地址
CREATE TABLE `mysql`.`salary_log`  (
  `worker_salarydate` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '工人发工资结算时间',
  `worker_salaryinfo` varchar(4000) CHARACTER SET utf8 NOT NULL COMMENT '工人发工资信息',
  `worker_salarysum` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '工资总金额',
  `worker_macaddress` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'mac地址',
  PRIMARY KEY (`worker_salarydate`) USING BTREE,
  INDEX `index1`(`worker_salarydate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 ROW_FORMAT = Dynamic;

