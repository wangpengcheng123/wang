/**
 * Project Name:GouWuChe
 * File Name:BuyList.java
 * Package Name:gouwuche.entity
 * Date:2018年4月22日下午5:04:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package gouwuche.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月22日 下午5:04:29 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BuyList {
    private int spid;
    private String spname;
    private float spprice;
    private String spdesc;
    private int amount;
    private float totalprice;
    public float getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
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
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}

