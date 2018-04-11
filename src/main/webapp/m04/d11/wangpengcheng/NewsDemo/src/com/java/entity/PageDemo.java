/**
 * Project Name:NewsDemo
 * File Name:PageDemo.java
 * Package Name:com.java.entity
 * Date:2018年4月10日上午9:30:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午9:30:31 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class PageDemo {
    // 当前页
    private int currpage;

    // 总页数
    private int countpage;

    // 分页开始的数据
    private int startpage;

    // 每页显示的条数
    private int number = 3;

    // 总条数
    private int countnumber;

    public int getCountnumber() {
        return countnumber;
    }

    public void setCountnumber(int countnumber) {
        this.countnumber = countnumber;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getCountpage() {
        return countpage;
    }

    public void setCountpage(int countpage) {
        this.countpage = countpage;
    }

    public int getStartpage() {
        return startpage;
    }

    public void setStartpage(int startpage) {
        this.startpage = startpage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
