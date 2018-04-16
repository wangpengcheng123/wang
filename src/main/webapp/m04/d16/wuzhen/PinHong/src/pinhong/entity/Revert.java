/**
 * Project Name:PinHong
 * File Name:Revert.java
 * Package Name:pinhong.entity
 * Date:2018年4月16日下午6:04:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.entity;

import java.sql.Date;

/**
 * Description:   <br/>
 * Date:     2018年4月16日 下午6:04:53 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Revert {

    private int rid;
    private int mid;
    private String rcontent;
    private String rname;
    private String rdate;
    
    public int getRid() {
        return rid;
    }
    public void setRid(int rid) {
        this.rid = rid;
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
    public String getRdate() {
        return rdate;
    }
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
  
}

