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
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.java.dao.IndexDao;
import com.java.entity.Message;
import com.java.entity.News;
import com.java.entity.PageDemo;
import com.java.entity.Product;
import com.java.entity.Revert;
import com.java.entity.User;
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

    // 查询用户表中的用户名和密码
    @Override
    public List<User> selectUser(String username, String password) {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
        Object[] objects = { username, password };
        List<User> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<User>(User.class), objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }
    // 查询用户表中的所有用户

    @Override
    public List<User> selectUserAll() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM USER";

        List<User> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

    // 统计该表中的信息的总条数
    @Override
    public int selectCount() {
        QueryRunner queryRunne = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT COUNT(*) FROM product";
        Long num = null;
        try {
            num = (Long) queryRunne.query(sql, new ScalarHandler());
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return num.intValue();

    }

    // 存储每页的数量
    @Override
    public List<Product> selectPageInfo(PageDemo pageDemo) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM product LIMIT ?,?";
        List<Product> list = null;
        Object[] objects = { pageDemo.getStartNumber(), pageDemo.getPageNumber() };
        try {
            list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

    // 返回留言表中的所有信息
    @Override
    public List<Message> selectMessage() {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM message";
        List<Message> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<Message>(Message.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Message> selectMessageMid(int mid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM message WHERE `mid`=?";
        List<Message> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<Message>(Message.class), mid);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Revert> selectRevertMid(int mid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = " SELECT * FROM revert WHERE `mid`=?";
        List<Revert> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<Revert>(Revert.class), mid);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    // 向revert表中插入数据
    @Override
    public int insertRevert(Revert revert) {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = " INSERT INTO revert SET `mid`=?,rcontent=?,rname=?,rdate=?";
        Object[] objects = { revert.getMid(), revert.getRcontent(), revert.getRname(), revert.getRdate() };
        int num = 0;
        try {
            num = queryRunner.update(sql, objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return num;
    }
    // 当向表中插入数据成功时此时的message中总计消息的字段的数据要加1

    @Override
    public int updateMessageCount(int mid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE message SET rcount=rcount+1 WHERE `mid`=?";
        Object[] objects = { mid };
        int num = 0;
        try {
            num = queryRunner.update(sql, objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return num;
    }

}