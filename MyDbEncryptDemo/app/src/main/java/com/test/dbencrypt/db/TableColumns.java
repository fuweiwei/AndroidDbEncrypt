package com.test.dbencrypt.db;

/**
 * Created by fuweiwei on 2015/11/19.
 * 数据库表、字段(方便以后统一管理)
 */
public interface TableColumns {
    public static interface USER_COLUMNS {
        public static final String TABLE_USER="user";
        public static final String NAME="Name";//名字
        public static final String PASSWORD = "Password";// 密码
    }
}
