package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
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

    @Override
    public int update_NewsInfo(NewsInfo newsInfo) {

        // Auto-generated method stub
        return 0;
    }

    @Override
    public int add_NewsInfo(String name) {

        // Auto-generated method stub
        return 0;
    }

    @Override
    public int del_NewsInfo(int news_id) {

        // Auto-generated method stub
        return 0;
    }

}
