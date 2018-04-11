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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.java.dao.NewsDao;
import com.java.entity.CommentInfo;
import com.java.entity.NewsDemo;
import com.java.entity.PageDemo;
import com.java.utils.C3P0Utils;
import com.java.utils.JdbcUtils;

public class NewsDaoImpl implements NewsDao<NewsDemo> {

    @Override
    public List<NewsDemo> selectNew() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM news_info";
        List<NewsDemo> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<NewsDemo>(NewsDemo.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

    @Override
    public int updateNew(NewsDemo newsDemo) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        int num = 0;
        String sql = "UPDATE news_info SET type_id=?,news_title=?,news_author=?,news_summary=?,news_content=? WHERE news_id=?";
        Object[] object = { newsDemo.getType_id(), newsDemo.getNews_title(), newsDemo.getNews_author(),
                newsDemo.getNews_summary(), newsDemo.getNews_content(), newsDemo.getNews_id() };
        try {
            num = queryRunner.update(sql, object);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return num;
    }

    @Override
    public List<CommentInfo> selectComment() {
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM `comment_info`";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        List<CommentInfo> list = new ArrayList<CommentInfo>();
        try {
            pStatement = connection.prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                CommentInfo commentInfo = new CommentInfo();
                commentInfo.setComment_id(resultSet.getInt(1));
                commentInfo.setUsername(resultSet.getString(2));
                commentInfo.setIp(resultSet.getString(3));
                commentInfo.setContent(resultSet.getString(4));
                commentInfo.setNews_id(resultSet.getInt(5));
                commentInfo.setDate(resultSet.getDate(6));
                // commentInfo.setDate(resultSet.getString(6));

                list.add(commentInfo);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

    // 查询数据的总条数
    @Override
    public int selectCount() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT COUNT(*) FROM news_info";
        Long num = null;
        try {
            num = (Long) queryRunner.query(sql, new ScalarHandler());
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return num.intValue();
    }

    // 查询每页的数据
    @Override
    public List<NewsDemo> selectNewPage(PageDemo pageDemo) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM news_info LIMIT ?,?";
        Object[] objects = { pageDemo.getStartpage(), pageDemo.getNumber() };
        List<NewsDemo> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<NewsDemo>(NewsDemo.class), objects);
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    // public static void main(String[] args) {
    // Connection connection = JdbcUtils.getConnection();
    // String sql = "SELECT * FROM `comment_info`";
    // PreparedStatement pStatement = null;
    // ResultSet resultSet = null;
    // List<CommentInfo> list = new ArrayList<CommentInfo>();
    // try {
    // pStatement = connection.prepareStatement(sql);
    // resultSet = pStatement.executeQuery();
    // while (resultSet.next()) {
    // CommentInfo commentInfo = new CommentInfo();
    // commentInfo.setComment_id(resultSet.getInt(1));
    // commentInfo.setUsername(resultSet.getString(2));
    // commentInfo.setIp(resultSet.getString(3));
    // commentInfo.setContent(resultSet.getString(4));
    // commentInfo.setNews_id(resultSet.getInt(5));
    // // commentInfo.setDate(resultSet.getDate(6));
    // commentInfo.setDate(resultSet.getString(6));
    //
    // list.add(commentInfo);
    // }
    // } catch (SQLException e) {
    //
    // // Auto-generated catch block
    // e.printStackTrace();
    //
    // }
    // for (CommentInfo commentInfo : list) {
    // String string = commentInfo.getDate().substring(0,
    // commentInfo.getDate().length() - 2);
    // System.out.println(string);
    //
    // }
    //
    // }
}
