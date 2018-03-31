/**
 * Project Name:dt59_dao
 * File Name:BaseDao.java
 * Package Name:com.dao
 * Date:2018年3月28日下午2:42:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午2:42:50 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 创建BaseDao类，实现数据库连接和关闭功能
 */
public class BaseDao {
    protected Connection con = null;// 连接通道

    protected PreparedStatement pst = null;// 预编译

    protected ResultSet rs = null;// 结果集

    static String driver;

    static String url;

    static String username;

    static String password;
    static {
        init();// 加载不同属性文件的“键”
    }

    // 初始化数据库连接
    public static void init() {
        Properties pro = new Properties();
        String path = "database.properties";// 属性文件的位置
        // 将属性文件以流的方式输出
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(path);
        // 加载二进流
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 连接方法
    public Connection getCon() throws SQLException {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }
            flag = pst.executeUpdate();
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public void close(Connection con, PreparedStatement pst, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
