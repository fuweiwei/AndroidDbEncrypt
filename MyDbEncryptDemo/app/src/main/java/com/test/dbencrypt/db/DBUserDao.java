package com.test.dbencrypt.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.test.dbencrypt.bean.UserBean;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuweiwei on 2015/11/19.
 * 用户表操作类
 */
public class DBUserDao extends  DBDao implements TableColumns.USER_COLUMNS {
    private static DBUserDao INSTANCE;
    private Context mContext;
    protected DBUserDao(Context context) {
        super(context);
    }
    public static DBUserDao getInstance(Context context){
        if(INSTANCE==null){
            synchronized (DBUserDao.class) {
                if(INSTANCE==null){
                    INSTANCE = new DBUserDao(context);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 添加一条用户
     * @param userBean
     */
    public  void addUser(UserBean userBean){
        if(userBean==null){
            return;
        }
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", userBean.getName());
        values.put("password", userBean.getPassword());
        db.insert(TABLE_USER,NAME,values);
        closeDatabase();
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<UserBean> getUsers(){
        List<UserBean> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select *from "+TABLE_USER;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null && cursor.moveToFirst()){
            UserBean  bean = new UserBean();
            bean.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            bean.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));
            list.add(bean);
        }
        if(cursor!=null){
            cursor.close();
        }
        closeDatabase();
        return  list;
    }
}
