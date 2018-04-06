/**
 * Project Name:NewsDemo
 * File Name:NewsServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:2018年4月3日下午5:04:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service.impl;

import java.util.List;

import com.java.dao.NewsDao;
import com.java.dao.impl.NewsDaoImpl;
import com.java.entity.NewsDemo;
import com.java.service.NewsService;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午5:04:03 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class NewsServiceImpl implements NewsService<NewsDemo> {
    private NewsDao<NewsDemo> nd = new NewsDaoImpl();

    @Override
    public List<NewsDemo> SelectNewsDemo() {

        // Auto-generated method stub
        return nd.selectNew();
    }

}
