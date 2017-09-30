CREATE TABLE `product_info` (
  `product_id` VARCHAR(32) NOT NULL,
  `product_name` VARCHAR(64) NOT NULL comment '商品名称',
  `product_price` DECIMAL(8,2) NOT NULL comment '单价',
  `product_stock` INT NOT NULL comment '库存',
  `product_description` VARCHAR(64) comment '描述',
  `product_icon` VARCHAR(512) comment '小图',
  `category_type` INT NOT NULL comment '类目编号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`product_id`)
) comment '商品表';

CREATE TABLE `product_category` (
  `category_id` INT NOT NULL auto_increment,
  `category_name` VARCHAR(64) NOT NULL comment '类目名称',
  `categpry_type` INT NOT NULL comment '类目编号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`categpry_type`)
) comment '类目表';

CREATE TABLE `order_master` (
  `order_id` VARCHAR(32) NOT NULL,
  `buyer_name` VARCHAR (32) NOT NULL comment '买家姓名',
  `buyer_phone` VARCHAR (32) NOT NULL comment '买家电话',
  `buyer_address` VARCHAR (128) NOT NULL comment '买家地址',
  `buyer_openid` VARCHAR (64) NOT NULL comment '买家微信id',
  `order_amount` DECIMAL (8,2) NOT NULL comment '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' comment '订单状态,默认0-新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' comment '支付状态,默认0-未支付',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `inx_buyer_openid` (`buyer_openid`)
) comment '订单表';

CREATE TABLE `order_detail` (
  `detail_id` VARCHAR (32) NOT NULL ,
  `order_id` VARCHAR (32) NOT NULL ,
  `product_id` VARCHAR (32) NOT NULL ,
  `product_name` VARCHAR (64) NOT NULL comment '商品名称',
  `product_price` DECIMAL (8,2) NOT NULL comment '商品价格',
  `product_quantity` INT NOT NULL comment '商品数量',
  `product_icon` VARCHAR (512) NOT NULL comment '商品小图',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) comment '订单详情';

