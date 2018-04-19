/**
 * Project Name:ShoppingProjectDemo
 * File Name:IndexDaoImpl.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月19日下午12:04:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.java.dao.IndexDao;
import com.java.entity.ShangPing;
import com.java.utils.C3P0Utils;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:04:45 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class IndexDaoImpl implements IndexDao {
    // 查询商品表中的所有信息
    @Override
    public List<ShangPing> selectShangPingAll() {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM shangping";
        List<ShangPing> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<ShangPing>(ShangPing.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    // 查询用户表中的用户是否存在
    @Override
    public int selectUserCount(String username, String password) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT COUNT(*) FROM USER WHERE uname=? AND upwd=?";
        Object[] objects = { username, password };
        Long num = null;
        try {
            num = (Long) queryRunner.query(sql, new ScalarHandler(), objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return num.intValue();
    }

    // 根据商品id查询该商品的详细信息
    @Override
    public ShangPing selectShangPing(int id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM shangping WHERE spid=?";
        ShangPing shangPing = null;
        try {
            shangPing = queryRunner.query(sql, new BeanHandler<ShangPing>(ShangPing.class), id);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return shangPing;
    }

}
