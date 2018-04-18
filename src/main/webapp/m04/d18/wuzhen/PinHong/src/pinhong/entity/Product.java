/**
 * Project Name:PinHong
 * File Name:Product.java
 * Package Name:pinhong.entity
 * Date:2018年4月12日下午8:06:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午8:06:33 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Product {

    private int pid;
    private String pname;
    private String pbrand;
    private String pmodel;
    private float pprice;
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
    public float getPprice() {
        return pprice;
    }
    public void setPprice(float pprice) {
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

