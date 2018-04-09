package news;
/**
 * Project Name:wuzhen
 * File Name:BaseDao.java
 * Package Name:question_info
 * Date:2018年3月28日下午4:07:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */



import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:07:25 <br/>
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
   static String password;
//   static{
//       init();
//   }
   //加载属性列表里的"键"
  
//      public static void init(){
//          Properties pro=new Properties();
//          //加载配置文件到输入流；
//          InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("news.properties");
//          try {
//              //从输入流中读取属性列表；
//            pro.load(is);
//            driver=pro.getProperty("driver");
//            url=pro.getProperty("url");
//            user=pro.getProperty("user");
//            password=pro.getProperty("psw");
//            
//        } catch (IOException e) {
//
//            e.printStackTrace();
//            
//        }
//      }
      //连接方法
      public Connection getCon(){
//          try {
              try {
                  Context ctx=new InitialContext();
                  DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news");
                  con=ds.getConnection();
               
            } catch (NamingException | SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
//            Class.forName(driver);    
//            con=DriverManager.getConnection(url,user,password);
//            } catch (SQLException e) {
//            
//                e.printStackTrace();
//          
//        } catch (ClassNotFoundException e) {
//            
//            //  Auto-generated catch block
//            e.printStackTrace();
//            
//        }
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
      
      


