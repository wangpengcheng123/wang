/**
 * Project Name:NewsDemo
 * File Name:NewsService.java
 * Package Name:com.java.service
 * Date:2018年4月3日下午5:02:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午5:02:32 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.util.List;

import com.java.entity.CommentInfo;
import com.java.entity.NewsDemo;
import com.java.entity.PageDemo;

public interface NewsService<T> {
    public List<T> SelectNewsDemo();

    public boolean updateNewsDemo(NewsDemo newsDemo);

    public List<CommentInfo> selectCommentDemo();

    public int selectCount();

    public List<NewsDemo> selectNewPage(PageDemo pageDemo);

}
