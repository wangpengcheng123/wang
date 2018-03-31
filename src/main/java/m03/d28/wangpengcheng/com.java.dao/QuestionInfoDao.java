/**
 * Project Name:ClassTest
 * File Name:QuestionInfoDao.java
 * Package Name:com.java.dao
 * Date:2018年3月28日下午3:47:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午3:47:27 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    // 向数据库中插入数据
    public int insertDemo(T t);

    // 根据题目序号删除题目
    public int deleteDemo(int questionId);

    // 查询全部数据数据
    public List<T> seleteDemo1();

    // 模糊查询

    public List<T> seleteDemo2(String string);

    // 根据科目查询题目
    public List<T> seleteDemo3(int subject);
}
