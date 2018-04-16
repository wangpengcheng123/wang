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
import com.entity.LeaveWord;
import com.entity.LoGin;
import com.entity.News;
import com.entity.Page;
import com.entity.Product;
import com.entity.Reply;
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

    public boolean getDenglu(LoGin loGin) {
        
        //  Auto-generated method stub
        return bizDao.getDenglu(loGin);
    }

    public List<LoGin> getAllUser() {
        
        //  Auto-generated method stub
        return bizDao.getAllUser();
    }

    public String getUserUstatus(LoGin loGin) {
        
        //  Auto-generated method stub
        return bizDao.getUserUstatus(loGin);
    }
    
    public List<Product> getLimit(Page page) {
        
        //  Auto-generated method stub
        return bizDao.getLimit(page);
    }

    public int getProduct() {
        
        //  Auto-generated method stub
        return bizDao.getProduct();
    }

    public List<LeaveWord> getWords() {
        
        //  Auto-generated method stub
        return bizDao.getWords();
    }

    public List<LeaveWord> getWord(LeaveWord lw) {
        
        //  Auto-generated method stub
        return bizDao.getWord(lw);
    }

    public List<Reply> getReplies(LeaveWord lw) {
        
        //  Auto-generated method stub
        return bizDao.getReplies(lw);
    }

    public boolean updateReply(Reply reply) {
        
        //  Auto-generated method stub
        return bizDao.updateReply(reply);
    }

}

