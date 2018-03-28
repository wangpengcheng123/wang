/**
 * Project Name:dt59_jdbc_02
 * File Name:privince.java
 * Package Name:jdbc2.connection
 * Date:2018年3月27日下午6:52:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午6:52:22 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class privince {
    @Test
    public void insertData() throws Exception {
        // 1.在程序中加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.通过java代码链接数据库
        Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/mydata", "root", "root");
        // 3.书写sql语句，发送sql语句，接收sql语句返回的结果
        String sql = "INSERT INTO province SET pid=4,pname='广男省';";
        // 将sql语句装车
        Statement st = con.createStatement();
        // 数据库受影响的行数
        int result = st.executeUpdate(sql);

        if (result >= 1) {
            System.out.println("数据插入成功");
        } else {
            System.out.println("插入失败");
        }
        // 4.关闭连接
        con.close();
    }

}
