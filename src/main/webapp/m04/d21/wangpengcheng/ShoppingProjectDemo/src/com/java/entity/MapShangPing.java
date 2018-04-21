/**
 * Project Name:ShoppingProjectDemo
 * File Name:MapShangPing.java
 * Package Name:com.java.entity
 * Date:2018年4月19日下午2:25:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午2:25:14 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class MapShangPing {
    private int spid;

    private String spname;

    private float spprice;

    private String spdesc;

    private int number = 1;

    public MapShangPing() {

    }

    public MapShangPing(int spid, String spname, float spprice, String spdesc) {
        super();
        this.spid = spid;
        this.spname = spname;
        this.spprice = spprice;
        this.spdesc = spdesc;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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
