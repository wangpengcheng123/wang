/**
 * Project Name:NewsDemo
 * File Name:JndiTest.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月9日下午8:08:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.CommentInfo;
import com.java.utils.JndiUtils;

/**
 * Description: <br/>
 * Date: 2018年4月9日 下午8:08:56 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class JndiTest {
    public static void main(String[] args) {
        Connection connection = JndiUtils.getConnection();
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

                list.add(commentInfo);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        for (CommentInfo commentInfo : list) {
            System.out.println(commentInfo.getComment_id() + "\t" + commentInfo.getContent());
        }

    }

}
