/**
 * Project Name:jspWorkTest
 * File Name:CommentInfo.java
 * Package Name:com.dt59.entity
 * Date:2018年4月7日下午7:23:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月7日 下午7:23:44 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class CommentInfo {
    private int commentid; 
    private String username;
    private int ip;
   private String content;
   private int  id;
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
public int getIp() {
    return ip;
}
public void setIp(int ip) {
    this.ip = ip;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
private String fbtime;
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
}
public String getFbtime() {
    return fbtime;
}
public void setFbtime(String fbtime) {
    this.fbtime = fbtime;
}
}

