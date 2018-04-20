/**
 * Project Name:dt59_shopping
 * File Name:BaseDao.java
 * Package Name:com.shopping.dao
 * Date:2018-4-19下午2:22:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.dao;
/**
 * Description:   <br/>
 * Date:     2018-4-19 下午2:22:49 <br/>
 * @author   LangWang
 * @version
 * @see
 */
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao {
    protected Connection con=null;//连接通道
    protected PreparedStatement pst=null;//预编译
    protected ResultSet rs=null;//结果集
    protected CallableStatement cstate=null;//调用存储过程的接口
    static String driver;
    static String url;
    static String username;
    static String userpwd;
    static{
        init();//加载不同属性文件的“键”
    }
    /**
     *  @see 初始化数据库连接的
     * */
    public static void init(){
        Properties pro=new Properties();//Properties提供加属性文件的方法和读取属性文件中键的方法
        String path="shopping.properties";//属性文件的位置
        try {
            InputStream ist= BaseDao.class.getClassLoader().getResourceAsStream(path);//把属性文件以流的方式输出
            pro.load(ist);//加载二进流
            driver=pro.getProperty("driver");
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            userpwd=pro.getProperty("password");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    //连接方法
    public Connection getCon(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, username, userpwd);
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
                for(int i=0;i<obj.length;i++){
                    pst.setObject(i+1, obj[i]);//赋值
                }
            }
            flag=pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
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

