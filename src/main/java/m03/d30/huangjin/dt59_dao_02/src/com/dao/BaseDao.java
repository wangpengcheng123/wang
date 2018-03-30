/**
 * Project Name:dt59_dao_02
 * File Name:BaseDao.java
 * Package Name:com.dao
 * Date:2018年3月30日下午7:27:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午7:27:09 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class BaseDao {

    protected Connection con = null;

    protected PreparedStatement ps = null;

    protected ResultSet rs = null;

    protected CallableStatement cs = null;

    static String driver;

    static String url;

    static String user;

    static String password;
    static {
        init();
    }

    // 加载属性文件中的键值
    public static void init() {
        Properties pro = new Properties();
        // 用流的方式进行加载
        InputStream is = BaseDao.class.getResourceAsStream("question.properties");
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }

    // 连接数据库
    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return con;
    }

    public List<QuestionInfo> controlDql(String sql, Object obj) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            ps = getCon().prepareStatement(sql);
            if (obj != "") {
                ps.setObject(1, obj);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo ques = new QuestionInfo();
                ques.setQuestionId(rs.getInt(1));
                ques.setQuestion(rs.getString(2));
                ques.setOptionA(rs.getString(3));
                ques.setOptionB(rs.getString(4));
                ques.setOptionC(rs.getString(5));
                ques.setOptionD(rs.getString(6));
                ques.setSubject(rs.getInt(7));
                ques.setAnswer(rs.getString(8));
                list.add(ques);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return list;
    }

    private void close(Connection con2, PreparedStatement ps2, ResultSet rs2) {

        // Auto-generated method stub
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
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
