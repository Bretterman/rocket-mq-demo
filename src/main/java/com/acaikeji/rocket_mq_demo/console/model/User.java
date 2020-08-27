package com.acaikeji.rocket_mq_demo.console.model;

import java.io.Serializable;

public class User implements Serializable {
    private String loginName;
    private String pwd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public void setId(String s) {
        this.loginName = s;
    }

    public void setUsername(String s) {
        this.pwd = s;
    }
}