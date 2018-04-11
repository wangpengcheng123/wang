/**
 * Project Name:News
 * File Name:NewsInfo.java
 * Package Name:news
 * Date:2018年4月6日下午3:29:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;
/**
 * Description:   <br/>
 * Date:     2018年4月6日 下午3:29:45 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class NewsInfo {
    private int news_id;
    private int type_id;
    private String summary;
    private String content;
    private String title;
    private String name;
    public int getNews_id() {
        return news_id;
    }
    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }
    public int getType_id() {
        return type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}

