/**
 * Project Name:pinhong
 * File Name:News.java
 * Package Name:com.java.entity
 * Date:2018年4月12日下午6:51:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午6:51:10 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class News {
    private int nid;

    private String ntitle;

    private String ncontent;

    private String ndate;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getNdate() {
        return ndate;
    }

    public void setNdate(String ndate) {
        this.ndate = ndate;
    }

}
