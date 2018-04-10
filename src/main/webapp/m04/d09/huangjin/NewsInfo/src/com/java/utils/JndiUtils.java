/**
 * Project Name:NewsDemo
 * File Name:JndiUtils.java
 * Package Name:com.java.utils
 * Date:2018年4月9日下午8:00:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Description: <br/>
 * Date: 2018年4月9日 下午8:00:22 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class JndiUtils {
    private static DataSource dataSource = null;
    static {
        // 获取实例
        try {
            Context context = new InitialContext();
            // java:comp:env是固定格式，second指的是jndi的context.xml中的名字
            dataSource = (DataSource) context.lookup("java:comp/env/second");
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();

        }
    }

}
