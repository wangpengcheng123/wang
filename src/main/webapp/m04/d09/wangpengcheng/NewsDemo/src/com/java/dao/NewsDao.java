/**
 * Project Name:NewsDemo
 * File Name:NewsDao.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月3日下午4:56:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:56:35 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.util.List;

import com.java.entity.CommentInfo;
import com.java.entity.NewsDemo;

public interface NewsDao<T> {
    public List<T> selectNew();

    // 修改新闻
    public int updateNew(NewsDemo newsDemo);

    // 获取首页的新闻
    public List<CommentInfo> selectComment();
}
