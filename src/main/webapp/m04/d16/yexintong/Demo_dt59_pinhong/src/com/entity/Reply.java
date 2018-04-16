/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Reply.java
 * Package Name:com.entity
 * Date:2018-4-16下午10:06:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018-4-16 下午10:06:41 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Reply {
    private int rid;
    private int mid;
    private String rcontent;
    private String rname;
    private Date rdate;
    public int getRid() {
        return rid;
    }
    public void setRid(int rid) {
        this.rid = rid;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getRcontent() {
        return rcontent;
    }
    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }
    public String getRname() {
        return rname;
    }
    public void setRname(String rname) {
        this.rname = rname;
    }
    public Date getRdate() {
        return rdate;
    }
    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }
}

