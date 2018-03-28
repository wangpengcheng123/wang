/**
 * Project Name:dt59.homework
 * File Name:TextDemo01.java
 * Package Name:m03.d27
 * Date:2018-3-27����12:38:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.叶新童;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Description:   <br/>
 * Date:     2018-3-27 ����12:38:21 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class TextDemo01 {
    Connection ct=null;
    PreparedStatement pst=null;
    ResultSet res=null;
    private String url="jdbc:mysql://localhost:3306/mydata";
    public Connection getCon(){
        try {
         Class.forName("com.mysql.jdbc.Driver");   
         ct=DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ct;
    }
    public void Demo(){
        try {
            int cid = 0;
            String cname=null;
            String pname=null;
            String sql="SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
            pst=getCon().prepareStatement(sql);
            res=pst.executeQuery();
            while(res.next()){
               cid=res.getInt("cid");
               cname=res.getString("cname");
               pname=res.getString("pname");
               System.out.println(cid+"\t"+cname+"\t"+pname);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            
        }
        
    }
    
    public static void main(String[] args) {
       TextDemo01 td=new TextDemo01();
       td.Demo();
    }
}

