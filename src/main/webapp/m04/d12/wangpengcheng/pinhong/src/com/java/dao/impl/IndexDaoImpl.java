/**
 * Project Name:pinhong
 * File Name:NewsDaoImpl.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月12日下午6:54:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.java.dao.IndexDao;
import com.java.entity.News;
import com.java.entity.Product;
import com.java.utils.C3P0Utils;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午6:54:08 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class IndexDaoImpl implements IndexDao {

    // 获取所有新闻信息
    @Override
    public List<News> selectNews() {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM news";
        List<News> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<News>(News.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Product> selectProduct() {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM product";
        List<Product> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

}
