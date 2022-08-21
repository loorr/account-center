create table `tenant`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `tenant_name` varchar(255) unique NOT NULL COMMENT '租户名称',
    `tenant_code` varchar(255) unique NOT NULL COMMENT '租户编码',
    `remark` varchar(255) DEFAULT NULL COMMENT '角色备注',
    `valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    PRIMARY KEY (`id`),
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT COMMENT='租户管理';

-- 用户账户体系设计
CREATE TABLE `account` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
    `uid` bigint(20) unsigned unique NOT NULL COMMENT 'uid',
    `email` varchar(127) unique NOT NULL COMMENT '用户邮箱',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `username` varchar(255) DEFAULT NULL COMMENT '用户名',
    `nickname` varchar(255) DEFAULT NULL COMMENT '用户名',
    `valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    `first_login` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否首次登录',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户';

create table `account_ext`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `uid` bigint(20) unsigned unique NOT NULL COMMENT 'uid',
    `login_num` int(10) unsigned DEFAULT '0' COMMENT '登录次数',
    `last_login_time` datetime(3) DEFAULT NULL COMMENT '最后登录时间',
    `first_login` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否首次登录',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展信息';

CREATE TABLE `role` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
    `name` varchar(50) NOT NULL COMMENT '角色名',
    `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父角色id',
    `remark` varchar(255) DEFAULT NULL COMMENT '角色备注',
    `valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色';

create table `permission`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
    `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父权限id',
    `name` varchar(200) NOT NULL COMMENT '资源名',
    `code` varchar(200) NOT NULL COMMENT '资源编码',
    `url` varchar(255) DEFAULT NULL COMMENT '资源url',
    `type` varchar(20) DEFAULT NULL COMMENT '资源类型(data 0, component 1, router: 2)',
    `remark` varchar(255) DEFAULT NULL COMMENT '资源备注',
    `valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

create table `account_group`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
    `name` varchar(100) NOT NULL COMMENT '组名',
    `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父用户组id',
    `remark` varchar(255) DEFAULT NULL COMMENT '组备注',
    `valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户组';

CREATE TABLE `relate_account_role` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `uid` bigint(20) unsigned NOT NULL COMMENT 'uid',
    `role` varchar(50) NOT NULL COMMENT '角色',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_index` (`uid`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户';

create table `relate_role_permission`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `r_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
    `p_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
    unique key `uni_r_p_id` (`r_id`,`p_id`) USING BTREE
    primary key(id)
)ENGINE=InnoDB  comment 'role permission';

