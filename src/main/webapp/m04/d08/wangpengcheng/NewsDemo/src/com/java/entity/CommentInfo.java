/**
 * Project Name:NewsDemo
 * File Name:CommentInfo.java
 * Package Name:com.java.entity
 * Date:2018年4月8日下午3:54:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午3:54:22 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class CommentInfo {
    private int comment_id;

    private String username;

    private String ip;

    private String content;

    private int news_id;

    private Date date;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
