/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizDao.java
 * Package Name:com.dao
 * Date:2018-4-12下午6:50:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.util.List;

import com.entity.News;
import com.entity.Product;

/**
 * Description:   <br/>
 * Date:     2018-4-12 下午6:50:32 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public interface BizDao {
    List<News> getNewsAll();
    
    List<Product> getProAll();
}

