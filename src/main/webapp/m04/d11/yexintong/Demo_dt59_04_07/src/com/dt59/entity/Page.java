/**
 * Project Name:Demo_dt59_04_07
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:2018-4-10上午9:55:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.util.List;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-10 上午9:55:39 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Page {
    private int currentpae;//当前页
    private int pagesize=3;//每页显示的条数
    private int sumsize;//总条数
    private int lastpage;//尾页
    public int getCurrentpae() {
        if(currentpae<1){
            currentpae=1;
        }
        if (currentpae>getSumsize()/getPagesize()+1) {
            currentpae=getSumsize()/getPagesize()+1;
        }
        return currentpae;
    }
    public void setCurrentpae(int currentpae) {   
         this.currentpae = currentpae;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getSumsize() {
        return sumsize;
    }
    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }
    public int getLastpage() {
        return lastpage;
    }
    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    } 
}

