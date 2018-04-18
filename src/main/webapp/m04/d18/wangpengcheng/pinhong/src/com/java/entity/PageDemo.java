/**
 * Project Name:pinhong
 * File Name:PageDemo.java
 * Package Name:com.java.entity
 * Date:2018年4月13日下午3:02:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午3:02:02 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class PageDemo {
    // 当前页数
    private int currPage;

    // 总信息条数
    private int countNumber;

    // 起始信息
    private int startNumber;

    // 总页数
    private int countPage;

    // 每页的信息条数
    private int pageNumber = 3;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
