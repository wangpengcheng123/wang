/**
 * Project Name:dt59_jdbc_02
 * File Name:Test.java
 * Package Name:jdbc2.connection
 * Date:2018年3月27日下午8:13:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午8:13:35 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {

        // Auto-generated method stub

    }

    Connection con = null;// 通道

    PreparedStatement pst = null;// 预编译

    ResultSet rs = null;// 结果集

    private String url = "jdbc:mysql://localhost:3306/mydata";

    // 完成数据库连接
    public Connection getCon() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 输入密码，完成连接
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
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

    public Map<Sheng, City> getAll() {
        Map<Sheng, City> mp = new HashMap<Sheng, City>();
        try {
            // 需要发送的sql语句
            String str = "SELECT b.`cid`,b.`cname`,a.`pname` FROM Sheng a INNER JOIN city b ON a.`pid`=b.`pid`;";
            // 装箱
            pst = getCon().prepareStatement(str);
            // 执行sql语句
            rs = pst.executeQuery();
            while (rs.next()) {
                City cy = new City();
                Sheng pe = new Sheng();
                pe.setPname(rs.getString("pname"));
                cy.setCid(rs.getInt("cid"));
                cy.setCname(rs.getString("cname"));
                mp.put(pe, cy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return mp;
    }
}
