/**
 * Project Name:jspWorkTest
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:2018年4月10日上午9:51:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月10日 上午9:51:13 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class Page {
   private int currentpage;//当前页
   private int pagesize=3;//每页记录数
   private int  sunsize;//总页数
   private int lastpage;//尾页
   
public int getCurrentpage() {
    return currentpage;
}
public void setCurrentpage(int currentpage) {
    if(currentpage<1){
        this.currentpage =1;
    }else if(currentpage>=3){
        this.currentpage = 3;
    }else{
        this.currentpage = currentpage;
    }
   
}
public int getPagesize() {
    return pagesize;
}
public void setPagesize(int pagesize) {
    this.pagesize = pagesize;
}
public int getSunsize() {
    return sunsize;
}
public void setSunsize(int sunsize) {
    this.sunsize = sunsize;
}
public int getLastpage() {
    return lastpage;
}
public void setLastpage(int lastpage) {
    this.lastpage = lastpage;
}
}

