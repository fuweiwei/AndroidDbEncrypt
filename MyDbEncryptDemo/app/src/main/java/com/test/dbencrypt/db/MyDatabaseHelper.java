package com.test.dbencrypt.db;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by fuweiwei on 2015/11/19.
 * 数据库访问类，因此数据库使用了加密，所以这里使用的并不是Android API中的SQLiteOpenHelper，而是net.sqlcipher.database包下的SQLiteOpenHelper
 */
public class MyDatabaseHelper extends SQLiteOpenHelper implements TableColumns{
    private final static String DB_NAME = "db_demo.db";
    private final static int DB_VERSION = 1;
    //建表sql语句
    public static final String CREATE_TABLE_USER =  "CREATE TABLE IF NOT EXISTS " + USER_COLUMNS.TABLE_USER
            +"("
            + "_id integer primary key autoincrement,"
            + USER_COLUMNS.NAME +" text,"
            + USER_COLUMNS.PASSWORD +" text"
            +")";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

