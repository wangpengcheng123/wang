package com.dt59.dao;

import java.util.List;

import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public interface BizDao {
	boolean validateUser(UserInfo user);
	
	List<NewsInfo> getNews();
	List<CommentInfo> getComment();//新闻首页遍历填充内容
	List<NewsInfo> getNewsInfoInfo(int id);//新闻首页更新操作
	int delNewsInfoById(int id);
	int add(Object t);//修改
}
