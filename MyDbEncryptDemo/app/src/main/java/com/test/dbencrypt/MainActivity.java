package com.test.dbencrypt;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.test.dbencrypt.bean.UserBean;
import com.test.dbencrypt.db.DBUserDao;

import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private Button mBtnAdd;
    private Button mBtnLook;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    public  void initView(){
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnLook = (Button) findViewById(R.id.btn_look);
        mBtnAdd.setOnClickListener(this);
        mBtnLook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_add:
                UserBean  userBean = new UserBean();
                userBean.setName("vgeer");
                userBean.setPassword("123456");
                DBUserDao.getInstance(mContext).addUser(userBean);
                Toast.makeText(mContext,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_look:
                List<UserBean> list = DBUserDao.getInstance(mContext).getUsers();
                StringBuffer stringBuffer = new StringBuffer();
                for (UserBean userBean1:list){
                    stringBuffer.append("用户："+userBean1.getName()+",");
                    stringBuffer.append("密码："+userBean1.getPassword()+"。");
                }
                Toast.makeText(mContext,stringBuffer.toString(),Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
