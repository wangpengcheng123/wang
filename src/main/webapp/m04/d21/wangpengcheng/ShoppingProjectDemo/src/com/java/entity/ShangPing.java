/**
 * Project Name:ShoppingProjectDemo
 * File Name:ShangPing.java
 * Package Name:com.java.entity
 * Date:2018年4月19日下午12:05:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

import java.io.Serializable;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:05:09 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class ShangPing implements Serializable {
    /**
     * serialVersionUID:
     */
    private static final long serialVersionUID = -1291210430498711404L;

    private int spid;

    private String spname;

    private float spprice;

    private String spdesc;

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public float getSpprice() {
        return spprice;
    }

    public void setSpprice(float spprice) {
        this.spprice = spprice;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

}
