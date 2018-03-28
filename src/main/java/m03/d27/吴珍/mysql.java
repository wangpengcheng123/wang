/**
 * Project Name:wuzhen
 * File Name:mysql.java
 * Package Name:jdbc
 * Date:2018年3月26日下午3:53:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.吴珍;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

/**
 * Description:   <br/>
 * Date:     2018年3月26日 下午3:53:14 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class mysql {

    public static void main(String[] args) {
        /**
         * 有实体类：
         */
        mysql ms=new mysql();
//        Map<City,String> list=ms.getAllInfo();
//        Set<City> set=list.keySet();
//        for(City city:set){
//            System.out.println(city.getCid()+"\t"+city.getCname()+"\t"+list.get(city));
//        }
        /**
         * 无实体类：
         */
        ms.getAllInfo();
    }
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
 //连接的数据库；
    private String str="jdbc:mysql://localhost:3306/mydata";
    public Connection getCon(){
        try {
            //加载驱动；
            Class.forName("com.mysql.jdbc.Driver");
           //登录数据库；
            con=DriverManager.getConnection(str,"root","root");
            } catch (SQLException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                           
        } catch (ClassNotFoundException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();    
            
        
        }
        return con;
    }
    /**
     * 有实体类写法：
     * Description: <br/>
     *
     * @author Wu zhen
     * @return
     */
//    public Map<City,String> getAllInfo(){
//        Map<City,String> list=new HashMap<City,String>();
//        //查询的操作；
//        String sql="SELECT b.`cid`,b.`cname`,a.`pname` FROM province a RIGHT JOIN city b ON a.`pid`=b.`pid`;";
//        try {
//            //连接成功后预编译
//            ps=getCon().prepareStatement(sql);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                City c=new City();
//                Pro p=new Pro();
//                c.setCid(rs.getInt("b.cid"));
//                c.setCname(rs.getString("b.cname"));
//                p.setPname(rs.getString("a.pname"));
//                list.put(c,p.getPname());
//            }
//      
//        } catch (SQLException e) {
//            
//            //  Auto-generated catch block
//            e.printStackTrace();
//            
//        }
//     return list;
//        
//    }
    
   /**
    * 无实体类写法：
    */
    public void getAllInfo(){
        String sql="SELECT b.`cid`,b.`cname`,a.`pname` FROM province a RIGHT JOIN city b ON a.`pid`=b.`pid`";
        try {
            //连接成功后预编译
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              int rid= rs.getInt("cid");
              String cname=rs.getString("cname");
              String pname=rs.getString("pname");
              System.out.println(rid+"\t"+cname+"\t"+pname);
           }
        }catch (SQLException e) {
                      
            e.printStackTrace();
            
        }
    }
}

    
   