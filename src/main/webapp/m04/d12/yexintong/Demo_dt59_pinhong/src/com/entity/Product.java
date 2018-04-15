/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Product.java
 * Package Name:com.entity
 * Date:2018-4-12下午8:21:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;
/**
 * Description:   <br/>
 * Date:     2018-4-12 下午8:21:55 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Product {
    private int pid;
    private String pname;
    private String pbrand;
    private String pmodel;
    private double pprice;
    private String ppicture;
    private String pdes;
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPbrand() {
        return pbrand;
    }
    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }
    public String getPmodel() {
        return pmodel;
    }
    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }
    public double getPprice() {
        return pprice;
    }
    public void setPprice(double pprice) {
        this.pprice = pprice;
    }
    public String getPpicture() {
        return ppicture;
    }
    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }
    public String getPdes() {
        return pdes;
    }
    public void setPdes(String pdes) {
        this.pdes = pdes;
    }    
}

