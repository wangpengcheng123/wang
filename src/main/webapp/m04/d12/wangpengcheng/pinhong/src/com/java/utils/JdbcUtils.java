/**
 * Project Name:mysqlDemo
 * File Name:JdbcUtils.java
 * Package Name:com.java.utils
 * Date:2018年3月14日上午12:01:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.utils;
/**
 * Description:   <br/>
 * Date:     2018年3月14日 上午12:01:00 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;

    private static String url = null;

    private static String user = null;

    private static String password = null;

    // 用静态代码块写，可以在类一加载就加载代码块中的代码

    static {
        try {
            // 1.创建可以读取.properties文件的集合
            Properties properties = new Properties();
            // 2.将.properties文件转为可以操作的输入流
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 3.读取流
            properties.load(inputStream);
            // 4.通过properties中的getporperty()方法，获取其中的键值对
            url = properties.getProperty("url");
            user = properties.getProperty("userName");
            password = properties.getProperty("passWord");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }
    // public static void properties() throws Exception {
    // // 1.创建可以读取.properties文件的集合
    // Properties properties = new Properties();
    // // 2.将.properties文件转为可以操作的输入流
    // InputStream inputStream =
    // JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
    // // 3.读取流
    // properties.load(inputStream);
    // // 4.通过properties中的getporperty()方法，获取其中的键值对
    // url = properties.getProperty("url");
    // user = properties.getProperty("userName");
    // password = properties.getProperty("passWord");
    // driver = properties.getProperty("driver");
    // Class.forName(driver);
    // }

    public static Connection getConnection() {
        // 将里面的常量值进行封装 连接是在加载数据库之后，要得到连接对象，需要先加载驱动
        // properties();
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

            // Auto-generated catch block
            throw new RuntimeException();

        }
    }

    // 简化关闭代码
    public static void closeResource(ResultSet rs, Statement st, Connection con) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
