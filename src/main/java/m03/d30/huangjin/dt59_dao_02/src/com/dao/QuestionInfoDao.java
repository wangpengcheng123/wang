/**
 * Project Name:dt59_dao_02
 * File Name:QuestionInfoDao.java
 * Package Name:com.dao
 * Date:2018年3月30日下午7:30:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.util.List;

import com.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午7:30:32 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public interface QuestionInfoDao {
    // DAO接口类，定义方法
    // 列出所有试题
    List<QuestionInfo> getInfo();

    // 按科目查询
    List<QuestionInfo> querySub(int subject);

    // 按题干模糊查询
    List<QuestionInfo> queryLike(String question);

    // 添加试题
    boolean add(QuestionInfo Q);

    // 删除试题
    int del(int questionID);
}
