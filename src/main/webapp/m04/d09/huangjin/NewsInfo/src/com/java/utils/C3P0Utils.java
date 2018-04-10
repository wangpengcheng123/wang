/**
 * Project Name:mysqlDemo
 * File Name:C3P0Utils.java
 * Package Name:com.java.utils
 * Date:2018年3月20日下午12:20:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.utils;
/**
 * Description:   <br/>
 * Date:     2018年3月20日 下午12:20:01 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 连接池都会实现DataSource接口，所以可以用DataSource来接收返回值
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 工具类中的异常try-catch不要抛
    public static Connection getConnection() {
        try {
            // c3p0中也有个类实现了DataSource接口，所以此时调用的是c3p0中的getconnection()方法
            // 该方法返回一个连接
            return dataSource.getConnection();
        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
