/**
 * Project Name:dt59_dao
 * File Name:BizDao.java
 * Package Name:com.dao
 * Date:2018年3月28日下午2:41:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.util.List;

import com.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午2:41:22 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 创建DAO接口QuestionInfoDao， 定义查询所有试题，按科目查询试题，按题干模糊查询试题，添加试题，删除试题、按试题编号查询试题的方法。
 */
public interface QuestionInfoDao<T> {
    List<QuestionInfo> getAllInfo();// 查询所有试题

    int insertInfo(T t);

    int deleteInfo(int questionID);// 删除试题
}
