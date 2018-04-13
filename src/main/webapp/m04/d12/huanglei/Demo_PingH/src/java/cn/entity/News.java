/**
 * Project Name:Demo_PingH
 * File Name:News.java
 * Package Name:java.cn.entity
 * Date:2018年4月12日下午7:00:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package java.cn.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:00:45 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class News {
     private int nid;
     private String ntitle;
     private String ncontent;
     private Date ndate;
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
    public Date getNdate() {
        return ndate;
    }
    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }
}

