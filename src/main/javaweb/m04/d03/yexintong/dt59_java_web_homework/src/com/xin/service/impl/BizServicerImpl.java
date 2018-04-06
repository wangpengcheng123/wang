/**
 * Project Name:xinwen
 * File Name:BizServicerImpl.java
 * Package Name:com.xin.service.impl
 * Date:2018年4月3日下午4:18:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.xin.service.impl;

import java.util.List;

import com.xin.dao.BizDao;
import com.xin.entity.NewsInfo;
import com.xin.entity.UserInfo;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:18:07 <br/>
 * @author   DuSen
 * @version
 * @see
 */
public class BizServicerImpl implements BizService{

    private BizDao bizdao;
    public BizDao getBizdao() {
        return bizdao;
    }
    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }
    @Override
    public boolean denglu(UserInfo user) {
        
        return bizdao.denglu(user);
    }
    @Override
    public List<NewsInfo> all() {
        return bizdao.all();
    }
  

}

