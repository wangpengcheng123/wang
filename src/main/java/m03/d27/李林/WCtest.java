/**
 * Project Name:WE_JDBC
 * File Name:WCtest.java
 * Package Name:mydata
 * Date:2018年3月27日下午5:57:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mydata;
/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午5:57:47 <br/>
 * @author   11324
 * @version
 * @see
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WCtest {

    public static void main(String[] args) {

        WCtest wt = new WCtest();
        wt.getAll();

    }

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/mydata";
    
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public void close(Connection con, PreparedStatement pst,ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public void getAll(){
        try {
            String str = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
            pst = getCon().prepareStatement(str);
            rs = pst.executeQuery();
            while(rs.next()){
                int a = rs.getInt("cid");
                String s1 = rs.getString("cname");
                String s2 = rs.getString("pname");
                System.out.println(a+"\t"+s1+"\t"+s2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
    }
}

