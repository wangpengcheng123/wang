/**
 * Project Name:PinHong
 * File Name:BaseDao.java
 * Package Name:pinhong.dao
 * Date:2018年4月12日下午7:02:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:02:20 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BaseDao {

    protected Connection con=null;
    protected PreparedStatement ps=null;
    protected ResultSet rs=null;
    static String driver;
    static String url;
    static String user;
    static String pwd;
    static{
        init();
    }
    public static void init(){
        Properties p=new Properties();
        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("pinhong.properties");
        try {
            p.load(is);
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            user=p.getProperty("user");
            pwd=p.getProperty("pwd");           
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
    }
    public Connection getCon(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,pwd);         
        } catch (ClassNotFoundException | SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return con;
    }
    public void close(Connection con,PreparedStatement ps,ResultSet rs){
   try {
       if(rs!=null){
          rs.close();
       }
       if(ps!=null){
           ps.close();
       }
       if(con!=null){
           con.close();
       }
} catch (SQLException e) {
    
    //  Auto-generated catch block
    e.printStackTrace();
    
}
}
}

