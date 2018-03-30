/**
 * Project Name:wang
 * File Name:BaseDao.java
 * Package Name:m03.d28.yexintong.dao
 * Date:2018年3月28日下午4:00:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.yexintong.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:00:51 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con=null;
    protected PreparedStatement pst=null;
    protected ResultSet rs=null;
    protected CallableStatement cste=null;
    static String driver;
    static String url;
    static String username;
    static String password;
    static{
        init();
    }
    /*
     * 初始化数据库链接
     * */
    public static void init(){
       Properties pro=new Properties();
       String path="yexintong03.28.properties";
       try {
        InputStream ist= BaseDao.class.getClassLoader().getResourceAsStream(path);
        pro.load(ist);//加载二进流
        driver=pro.getProperty("driver");
        url=pro.getProperty("url");
        username=pro.getProperty("username");
        password=pro.getProperty("password");
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    }
    //连接方法
    public Connection getCon() {
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }
    public int controlDml(String sql,Object[] obj){
        int flag=0;
        try {
            pst=getCon().prepareStatement(sql);
            if(obj!=null){
              for (int i = 0; i < obj.length; i++) {
                pst.setObject(i+1, obj[i]);
            }  
              flag=pst.executeUpdate();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        return flag;
    }
    //关闭的方法
    public void close(Connection con,PreparedStatement pst,ResultSet rs){
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
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

