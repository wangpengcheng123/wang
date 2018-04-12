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
import com.java.entity.Product;

public interface IndexDao {
    // 查询所有新闻的信息（表News）
    public List<News> selectNews();

    // 查询所有的轮播的信息(表product)
    public List<Product> selectProduct();

}
