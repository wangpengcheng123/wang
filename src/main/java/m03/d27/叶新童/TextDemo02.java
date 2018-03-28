/**
 * Project Name:dt59.homework
 * File Name:TextDemo02.java
 * Package Name:m03.d27
 * Date:2018-3-27����1:36:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.叶新童;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018-3-27 ����1:36:33 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class TextDemo02 {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    private String url="jdbc:mysql://localhost:3306/mydata";
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }
    public List<InFo> getAllInfo(){
        List<InFo> list=new ArrayList<InFo>();
        try {
            String sql="SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                InFo ff=new InFo();
                ff.setCid(rs.getInt("cid"));
                ff.setPname(rs.getString("pname"));
                ff.setCname(rs.getString("cname"));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        TextDemo02 tt=new TextDemo02();
        List<InFo> list=tt.getAllInfo();
        for (InFo ff : list) {
            System.out.println(ff.getCid()+"\t"+ff.getCname()+"\t"+ff.getPname());
        }
    }
}

