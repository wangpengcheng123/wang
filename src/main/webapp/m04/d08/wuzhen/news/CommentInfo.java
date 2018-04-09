/**
 * Project Name:News
 * File Name:CommentInfo.java
 * Package Name:news
 * Date:2018年4月9日下午3:47:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.sql.Date;

/**
 * Description:   <br/>
 * Date:     2018年4月9日 下午3:47:16 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class CommentInfo {

    private int comment_id;
    private String userName;
    private String ip;
    private String content;
    private int news_id;
    private Date fbtime;
    public int getComment_id() {
        return comment_id;
    }
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    public Date getFbtime() {
        return fbtime;
    }
    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }
    
}

