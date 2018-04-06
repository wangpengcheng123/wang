/**
 * Project Name:huangjin
 * File Name:BaseDao.java
 * Package Name:news
 * Date:2018年4月6日下午6:30:37
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午6:30:37 <br/>
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

    // 加载配置文件
    public static void init() {
        Properties pro = new Properties();
        // 用流加载
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("news.properties");
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("psw");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 连接方法
    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "root");
        } catch (SQLException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return con;
    }

    public void close(Connection con, PreparedStatement ps, ResultSet rs) {

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
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }
}
