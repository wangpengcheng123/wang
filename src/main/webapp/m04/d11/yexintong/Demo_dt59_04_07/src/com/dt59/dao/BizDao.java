package com.dt59.dao;

import java.awt.geom.CubicCurve2D;
import java.util.List;

import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;

public interface BizDao {
	boolean validateUser(UserInfo user);
	
	List<NewsInfo> getNews();
	
	int delNewsInfoById(int id);
   
	int add(Object t);
	
    List<CommentInfo> all();
    
    List<NewsInfo> getPagesInfo(Page page);
}
