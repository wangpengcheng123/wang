/**
 * Project Name:pinhong
 * File Name:NewsDao.java
 * Package Name:com.java.dao
 * Date:2018年4月12日下午6:53:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午6:53:02 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.util.List;

import com.java.entity.News;
import com.java.entity.PageDemo;
import com.java.entity.Product;
import com.java.entity.User;

public interface IndexDao {
    // 查询所有新闻的信息（表News）
    public List<News> selectNews();

    // 查询所有的轮播的信息(表product)
    public List<Product> selectProduct();

    // 登陆查找有没有匹配的用户名和密码
    public List<User> selectUser(String username, String password);

    // 查询用户表中的所有用户
    public List<User> selectUserAll();

    // 统计数据库中信息的总条数
    public int selectCount();

    // 分页查询每页的数据
    public List<Product> selectPageInfo(PageDemo pageDemo);
}
