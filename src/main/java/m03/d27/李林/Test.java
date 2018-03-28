/**
 * Project Name:WE_JDBC
 * File Name:Test.java
 * Package Name:mydata
 * Date:2018年3月27日下午4:11:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mydata;
/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午4:11:32 <br/>
 * @author   11324
 * @version
 * @see
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Test {

    public static void main(String[] args) {

        Test tt = new Test();
        Map<Province,City> mp =tt.getAll();
        Set<Province> st = mp.keySet();
        Iterator<Province> it = st.iterator();
        while(it.hasNext()){
            Province pe =it.next();
            City cy = mp.get(pe);
           System.out.println(cy.getCid()+"\t"+cy.getCname()+"\t"+pe.getPname());
        }
       /* for(Province pe:st){
          System.out.println(mp.get(pe).getCid()+"\t"+mp.get(pe).getCname()+"\t"+pe.getPname());
       }*/
    }
        Connection con = null;//通道
        PreparedStatement pst = null;//预编译
        ResultSet rs = null;//结果集
        private String url = "jdbc:mysql://localhost:3306/mydata";
        
        public Connection getCon(){//完成与数据库的链接
            try {
                Class.forName("com.mysql.jdbc.Driver");//加载驱动
                con = DriverManager.getConnection(url, "root", "root");//输入密码，完成链接
            } catch (Exception e) {
                e.printStackTrace();
            }
            return con;
        }
        
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
        
        public Map<Province,City> getAll(){
            Map<Province,City> mp = new HashMap<Province,City>();
            try {
                String str = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
                pst = getCon().prepareStatement(str);
                rs = pst.executeQuery();
                while(rs.next()){
                    City cy = new City();
                    Province pe = new Province();
                    pe.setPname(rs.getString("pname"));
                    cy.setCid(rs.getInt("cid"));
                    cy.setCname(rs.getString("cname"));
                    mp.put(pe,cy);
                }
            } catch (Exception e) {
               e.printStackTrace();
            }finally{
                close(con,pst,rs);
            }
            return mp;
        } 
}

