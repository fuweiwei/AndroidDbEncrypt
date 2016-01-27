package com.test.dbencrypt.db;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fuweiwei on 2015/11/19.
 * 数据库操作基类
 */
public class DBDao  {
    protected static MyDatabaseHelper dbHelper;
    protected SQLiteDatabase db;
    //数据库加密的key
    protected static String DB_Key ="secret_key";
    //数据可打开关闭标记器，可解决重复打开关闭数据库的问题
    protected AtomicInteger mOpenCounter = new AtomicInteger();

    protected DBDao(Context context) {
        if (dbHelper == null) {
            synchronized (DBDao.class) {
                if (dbHelper == null) {
                    //将SQLCipher所依赖的so库加载进来
                    SQLiteDatabase.loadLibs(context);
                    dbHelper = new MyDatabaseHelper(context);
                }
            }
        }
    }

    /**
     * 获得一个可写数据库
     * @return SQLiteDatabase
     */
    protected synchronized SQLiteDatabase getWritableDatabase(){
        if(mOpenCounter.incrementAndGet() == 1) {
            db = dbHelper.getWritableDatabase(DB_Key);
        }
        return db;

    }
    /**
     * 获得一个可读数据库
     * @return SQLiteDatabase
     */
    protected synchronized SQLiteDatabase getReadableDatabase(){
        if(mOpenCounter.incrementAndGet() == 1) {
            db = dbHelper.getReadableDatabase(DB_Key);
        }
        return db;

    }

    /**
     * 关闭数据库连接
     */
    protected synchronized void closeDatabase(){
        if(mOpenCounter.decrementAndGet() == 0) {
            db.close();
        }
    }
}
