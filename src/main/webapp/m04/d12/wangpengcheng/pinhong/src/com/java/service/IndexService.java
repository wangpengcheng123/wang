/**
 * Project Name:pinhong
 * File Name:IndexService.java
 * Package Name:com.java.service
 * Date:2018年4月12日下午7:12:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service;

import java.util.List;

import com.java.entity.News;
import com.java.entity.Product;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:12:51 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public interface IndexService {
    // 查询所有新闻的信息（表News）
    public List<News> selectNews();

    // 查询所有的轮播的信息(表product)
    public List<Product> selectProduct();

}
