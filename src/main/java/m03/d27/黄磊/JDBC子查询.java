import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Project Name:HUANGLEI
 * File Name:TEST.java
 * Package Name:
 * Date:2018年3月24日上午11:45:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description: <br/>
 * Date: 2018年3月24日 上午11:45:35 <br/>
 * 
 * @author huanglei
 * @version
 * @see 使用JDBC-ODBC连桥方式建立数据库的
 */
public class JDBC子查询 {
    public static void main(String[] args) throws Exception {
            a();
      }
    public static void a(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "root");
//            String sql = "INSERT INTO student SET id=5,NAME='黄磊'";

            System.out.println("数据库连接成功");
            Statement stmt1 = conn.createStatement();// 创建一个Statement对象
            String sql1 = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";// 生成一条sql语句
            ResultSet rs1 = stmt1.executeQuery(sql1);// 执行查询，把查询结果赋值给结果集对象

            System.out.println("添加成功！\n");
            // 关闭
            int cid;// 声明个变量分别为id，name
            String cname;
            String pname;
            int a = 0;
            System.out.println("获得查询结果集：");
            System.out.println("编号\t 市\t 省");
            while (rs1.next()) {// 遍历结果集
               
                cid = rs1.getInt("cid");// 获得id
                pname = rs1.getString(2);//
                cname = rs1.getString(3);//
                System.out.println(cid + "\t" + pname+"\t"+cname);
                a++;
            }
            System.out.println("查询数据记录总数:" + a);

            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    

}
