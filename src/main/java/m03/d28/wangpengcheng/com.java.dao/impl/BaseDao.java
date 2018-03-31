/**
 * Project Name:ClassTest
 * File Name:BaseDao.java
 * Package Name:com.java.dao.impl
 * Date:2018年3月28日下午3:59:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;
/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:59:55 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    private static Connection connection;

    private static PreparedStatement pStatement;

    private static ResultSet resultSet;

    private static String driver;

    private static String url;

    private static String userName;

    private static String passWord;
    static {
        Properties properties = new Properties();
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return connection;

    }

    public static void close(ResultSet resultSet, PreparedStatement pStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }
}
