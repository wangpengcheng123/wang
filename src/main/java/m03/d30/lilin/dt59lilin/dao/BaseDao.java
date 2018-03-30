/**
 * Project Name:WE_XXGLXX
 * File Name:BaseDao.java
 * Package Name:com.dt59lilin.dao
 * Date:2018年3月28日下午4:09:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59lilin.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import com.dt59lilin.house.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:09:31 <br/>
 * @author   11324
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con = null;
    protected PreparedStatement pst = null;
    protected ResultSet rs = null;
    protected CallableStatement cs = null;
    static String driver;
    static String url;
    static String username;
    static String password;
    static{
        init();
    }
    
    //读值
    public static void init(){
        Properties pt = new Properties();
        String path = "database.properties";
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
            pt.load(ist);
            driver = pt.getProperty("driver");
            url = pt.getProperty("url");
            username = pt.getProperty("username");
            password = pt.getProperty("password");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    //建立连接
    public Connection getCon(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }
    
    //关闭连接
    public void Close(Connection con,PreparedStatement pst,ResultSet rs){
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

    
    public int controlDml(String sql,Object[] obj){
        int flag=0;
        try {
            pst=getCon().prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    pst.setObject(i+1, obj[i]);//赋值
                }
            }
            flag=pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return flag;
    }
}

