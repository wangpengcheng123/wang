/**
 * Project Name:pinhong
 * File Name:IndexServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:2018年4月12日下午7:13:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service.impl;

import java.util.List;

import com.java.dao.IndexDao;
import com.java.dao.impl.IndexDaoImpl;
import com.java.entity.News;
import com.java.entity.PageDemo;
import com.java.entity.Product;
import com.java.entity.User;
import com.java.service.IndexService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:13:47 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class IndexServiceImpl implements IndexService {
    private IndexDao indexDao = new IndexDaoImpl();

    // 返回News表的数据集合
    @Override
    public List<News> selectNews() {

        // Auto-generated method stub
        return indexDao.selectNews();
    }

    // 返回Product表的数据集合
    @Override
    public List<Product> selectProduct() {

        // Auto-generated method stub
        return indexDao.selectProduct();
    }

    // 查询用户表中的用户名和密码
    @Override
    public List<User> selectUser(String username, String password) {

        return indexDao.selectUser(username, password);
    }

    // 查询用户表中的所有数据
    @Override
    public List<User> selectUserAll() {

        return indexDao.selectUserAll();
    }

    @Override
    public int selectCount() {

        return indexDao.selectCount();
    }

    @Override
    public List<Product> selectPageInfo(PageDemo pageDemo) {

        // Auto-generated method stub
        return indexDao.selectPageInfo(pageDemo);
    }

}
