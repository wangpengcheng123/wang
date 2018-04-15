/**
 * Project Name:Demo_dt59_pinhong
 * File Name:News.java
 * Package Name:com.entity
 * Date:2018-4-12下午6:48:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018-4-12 下午6:48:01 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class News {
    private static final long serialVersionUID = -5375741841504315142L;
    private int nid;
    private String ntitle;
    private String ncontent;
    private Date nDate;
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
    public Date getnDate() {
        return nDate;
    }
    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }
}

