package com.test.dbencrypt.bean;

import java.io.Serializable;

/**
 * Created by fuweiwei on 2015/11/19.
 */
public class UserBean implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
