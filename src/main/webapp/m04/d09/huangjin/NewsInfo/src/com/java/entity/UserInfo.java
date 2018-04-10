/**
 * Project Name:NewsDemo
 * File Name:UserInfo.java
 * Package Name:com.java.entity
 * Date:2018年4月3日下午4:02:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:02:38 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class UserInfo {
    private int userInfo;

    private String userName;

    private String passWord;

    public int getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(int userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
