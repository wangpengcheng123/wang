/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizServiceImpl.java
 * Package Name:com.service.impl
 * Date:2018-4-12下午6:58:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.service.impl;

import java.util.List;

import com.dao.BizDao;
import com.entity.News;
import com.entity.Product;
import com.service.BizService;

/**
 * Description:   <br/>
 * Date:     2018-4-12 下午6:58:11 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class BizServiceImpl implements BizService{
    private BizDao bizDao;
    
    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    public List<News> getNewsAll() {
        //  Auto-generated method stub
        return bizDao.getNewsAll();
    }

    public List<Product> getProAll() {
        
        //  Auto-generated method stub
        return bizDao.getProAll();
    }

}

