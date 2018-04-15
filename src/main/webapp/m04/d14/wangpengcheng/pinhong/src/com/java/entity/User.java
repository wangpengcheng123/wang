/**
 * Project Name:pinhong
 * File Name:User.java
 * Package Name:com.java.entity
 * Date:2018年4月13日下午1:20:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午1:20:32 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class User {
    private int uid;

    private String uname;

    private String upwd;

    private String ustatus;

    private String upic;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic;
    }

}
