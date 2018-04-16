/**
 * Project Name:Demo_dt59_pinhong
 * File Name:LeaveWord.java
 * Package Name:com.entity
 * Date:2018-4-16下午8:47:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018-4-16 下午8:47:13 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class LeaveWord {
    private int mid;
    private String mtitle;
    private String mcontent;
    private String mname;
    private Date mdate;
    private int rcount;
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getMtitle() {
        return mtitle;
    }
    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }
    public String getMcontent() {
        return mcontent;
    }
    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public Date getMdate() {
        return mdate;
    }
    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }
    public int getRcount() {
        return rcount;
    }
    public void setRcount(int rcount) {
        this.rcount = rcount;
    } 
}

