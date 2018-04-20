/**
 * Project Name:dt59_shopping
 * File Name:BizDao.java
 * Package Name:com.shopping.dao
 * Date:2018-4-19下午2:45:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Shangping;
import com.shopping.entity.UserDemo;

/**
 * Description:   <br/>
 * Date:     2018-4-19 下午2:45:25 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public interface BizDao {
    List<Shangping> getAllShangping();
    
    boolean getDenglu(UserDemo userDemo);
    
    List<Shangping> addShangping(Shangping sp);
}

