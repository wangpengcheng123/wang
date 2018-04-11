/**
 * Project Name:Demo_dt59_jspCh02_news_01
 * File Name:CommentInfo.java
 * Package Name:com.dt59.entity
 * Date:2018-4-8下午10:06:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.sql.Date;

/**
 * Description:   <br/>
 * Date:     2018-4-8 下午10:06:35 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class CommentInfo {
    private int commentid;
    private String username;
    private String ip;
    private String content;
    private int newsid ;
    private Date fbtime;
    public int getCommentid() {
        return commentid;
    }
    public void setCommentid(int commentid) {
        this.commentid = commentid;
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
    public int getNewsid() {
        return newsid;
    }
    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }
    public Date getFbtime() {
        return fbtime;
    }
    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }
}

