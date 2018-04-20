/**
 * Project Name:dt59_shopping
 * File Name:BizServiceImpl.java
 * Package Name:com.shopping.service.impl
 * Date:2018-4-19下午3:06:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.BizDao;
import com.shopping.entity.Shangping;
import com.shopping.entity.UserDemo;
import com.shopping.service.BizService;

/**
 * Description:   <br/>
 * Date:     2018-4-19 下午3:06:53 <br/>
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

    public List<Shangping> getAllShangping() {
        
        //  Auto-generated method stub
        return bizDao.getAllShangping();
    }

    public boolean getDenglu(UserDemo userDemo) {
        
        //  Auto-generated method stub
        return bizDao.getDenglu(userDemo);
    }

    public List<Shangping> addShangping(Shangping sp) {
        
        //  Auto-generated method stub
        return bizDao.addShangping(sp);
    }

}

