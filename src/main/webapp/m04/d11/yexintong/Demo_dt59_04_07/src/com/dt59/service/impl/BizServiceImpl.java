package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
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

    @Override
    public int add(Object t) {
        
        //  Auto-generated method stub
        return bizDao.add(t);
    }

    @Override
    public List<CommentInfo> all() {
        
        //  Auto-generated method stub
        return bizDao.all();
    }

    @Override
    public List<NewsInfo> getPagesInfo(Page page) {
        
        //  Auto-generated method stub
        return bizDao.getPagesInfo(page);
    }
	
	

}
