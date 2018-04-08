package com.dt59.dao;

import java.util.List;

import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public interface BizDao {
    boolean validateUser(UserInfo user);

    // 获取新闻
    List<NewsInfo> getNews();

    // 更新主题
    public int update_NewsInfo(NewsInfo newsInfo);

    // 添加主题
    public int add_NewsInfo(String name);

    // 删除主题
    public int del_NewsInfo(int news_id);
}
