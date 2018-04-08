package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService {

	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(user);
	}

	public List<NewsInfo> getNews() {
		// TODO Auto-generated method stub
		return bizDao.getNews();
	}

	public int delNewsInfoById(int id) {
		// TODO Auto-generated method stub
		return bizDao.delNewsInfoById(id);
	}

    @Override//首页内容更新
    public List<CommentInfo> getComment() {
        
        //  Auto-generated method stub
        return bizDao.getComment();
    }

    @Override
    public List<NewsInfo> getNewsInfoInfo(int id) {
        
        //  Auto-generated method stub
        return bizDao.getNewsInfoInfo(id);
    }

    @Override
    public int add(Object t) {
        
        //  Auto-generated method stub
        return bizDao.add(t);
    }

   
	
	

}
