/**
 * Project Name:WE_XXGLXX
 * File Name:QuestionInfoDao.java
 * Package Name:com.dt59lilin.dao
 * Date:2018年3月28日下午4:11:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59lilin.dao;

import java.util.List;

import com.dt59lilin.house.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:11:00 <br/>
 * @author   11324
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    List<QuestionInfo> getAll();
    List<QuestionInfo> getAll(int x);   
    List<QuestionInfo> getAllGJZ(String x);
    int saveInfo(T t);
    int deleteInfo(int id);

}

