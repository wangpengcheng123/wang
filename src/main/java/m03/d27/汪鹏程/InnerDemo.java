/**
 * Project Name:mysqlDemo
 * File Name:InnerDemo.java
 * Package Name:com.java.dao.impl
 * Date:2018年3月26日下午7:09:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;
/**
 * Description:   <br/>
 * Date:     2018年3月26日 下午7:09:06 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InnerDemo {
    private Connection connection;

    private PreparedStatement pStatement;

    private ResultSet resultSet;

    // 创建连接
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "wang");
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return connection;

    }

    public List<Map<String, Object>> selectDemo() {
        List<Map<String, Object>> list = null;
        String sql = "SELECT city.`cid`,city.`cname`,province.`pname` FROM city INNER JOIN province ON city.`pid`=province.`pid`";
        try {
            pStatement = getConnection().prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            list = new ArrayList<Map<String, Object>>();
            while (resultSet.next()) {
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                String pname = resultSet.getString("pname");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("cid", cid);
                map.put("cname", cname);
                map.put("pname", pname);
                list.add(map);

            }
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(resultSet, pStatement, connection);
        }
        return list;
    }

    // 关闭连接
    public void close(ResultSet resultSet, PreparedStatement pStatement, Connection connection) {
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
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new InnerDemo().selectDemo();
        for (Map<String, Object> map : list) {
            // 获取建和值之间的关系
            for (Map.Entry<String, Object> hasmap : map.entrySet()) {
                String string = hasmap.getKey();
                Object object = hasmap.getValue();
                System.out.print(string + "=" + object + "\t");
            }
            System.out.println();
        }
    }

}
