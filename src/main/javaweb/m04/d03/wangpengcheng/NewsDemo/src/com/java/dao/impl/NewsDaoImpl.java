/**
 * Project Name:NewsDemo
 * File Name:NewsDaoImpl.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月3日下午4:58:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:58:42 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.java.dao.NewsDao;
import com.java.entity.NewsDemo;
import com.java.utils.C3P0Utils;

public class NewsDaoImpl implements NewsDao<NewsDemo> {

    @Override
    public List<NewsDemo> selectNew() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT news_title AS title,news_author AS author FROM news_info";
        List<NewsDemo> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<NewsDemo>(NewsDemo.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

}
