/**
 * Project Name:PinHong
 * File Name:BizDaoImp.java
 * Package Name:pinhong.dao.imp
 * Date:2018年4月12日下午7:03:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.dao.imp;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pinhong.dao.BaseDao;
import pinhong.dao.BizDao;
import pinhong.entity.Message;
import pinhong.entity.News;
import pinhong.entity.Page;
import pinhong.entity.Product;
import pinhong.entity.Revert;
import pinhong.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:03:33 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao {
//遍历新闻
    public List<News> getAllNews(){
        List<News> list=new ArrayList<News>();       
        String sql="SELECT * FROM news";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                News ni=new News();             
                ni.setNid(rs.getInt(1));
                ni.setNtitle(rs.getString(2));
                ni.setNcontent(rs.getString(3));
                ni.setNdate(rs.getDate(4));              
                list.add(ni);
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        
    return list;
    }

//遍历产品
    public List<Product> getAllPro() {
        List<Product> list=new ArrayList<Product>();       
        String sql="SELECT * FROM product";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();             
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                p.setPbrand(rs.getString(3));
                p.setPmodel(rs.getString(4));  
                p.setPprice(rs.getFloat(5));
                p.setPpicture(rs.getString(6));
                p.setPdes(rs.getString(7));
               list.add(p);
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        return list;
    }
//遍历用户
    public List<User> getAllUser() {
        List<User> list=new ArrayList<User>();   
        String sql="SELECT * FROM USER";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();             
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));  
                user.setUpic(rs.getString(5));              
               list.add(user);
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        return list;
    }

//查询是否包含用户名和密码
    public int yanzheng(User user) {       
        int flag=0;
        String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setString(1,user.getUname());
            ps.setString(2,user.getUpwd());
            rs=ps.executeQuery();            
            while(rs.next()){
                flag=1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        return flag;
    }


    @Override
    //查询产品总数量；
    public int CountPros() {
        String sql="SELECT COUNT(1) FROM product";
        int count=0;
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            count=rs.getInt(1);
            }
        } catch (SQLException e) {
         
            e.printStackTrace();         
        }finally{
            close(con,ps,rs);
        }
       
        return count;
     
    }


    @Override
    //根据每页遍历产品
    public List<Product> getPageInfo(Page page) {
        List<Product> list=new ArrayList<Product>();
        String sql="SELECT * FROM product LIMIT ?,?";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,(page.getCurrentPage()-1)*page.getPerPage());
            ps.setInt(2,page.getPerPage());
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();             
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                p.setPbrand(rs.getString(3));
                p.setPmodel(rs.getString(4));  
                p.setPprice(rs.getFloat(5));
                p.setPpicture(rs.getString(6));
                p.setPdes(rs.getString(7));
               list.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
           
        }finally{
            close(con,ps,rs);
        }        
        return list;
    }


    @Override
    //获取所有的留言
    public List<Message> getAllMessage() {
        List<Message> list=new ArrayList<Message>();
        String sql="SELECT * FROM message";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Message m=new Message();
                m.setMid(rs.getInt(1));
                m.setMtitle(rs.getString(2));
                m.setMcontent(rs.getString(3));
                m.setMname(rs.getString(4));
                m.setMdate(rs.getDate(5));
                m.setRcount(rs.getInt(6));
                list.add(m);
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }    
        
        return list;
    }


    @Override
    //增加回复
    public int addReply(Revert r) {
        
        int flag=0;
        String sql="INSERT INTO revert VALUES(?,?,?,?,?)";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,r.getRid());
            ps.setInt(2,r.getMid());
            ps.setString(3,r.getRcontent());
            ps.setString(4,r.getRname());                    
            ps.setString(5,r.getRdate());
            flag=ps.executeUpdate();
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }  
        return flag;
    }
    //通过留言id获取相应的留言回复的总条数
    public int getRevertInfo(int id){
        int count=0;
        String sql="SELECT COUNT(*) FROM revert WHERE MID=? GROUP BY MID";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            
           
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        
        return count;
    }
    //根据留言的id修改回复的条数
    public int modifyMessage(int rcount,int mid){
        int flag=0;
        String sql="UPDATE message SET rcount=? WHERE MID=?";
       try {
        ps= getCon().prepareStatement(sql);
        ps.setInt(1, rcount);
        ps.setInt(2,mid);
        flag=ps.executeUpdate();
    } catch (SQLException e) {
        
        //  Auto-generated catch block
        e.printStackTrace();
        
    }finally{
        close(con,ps,rs);
    }
        return flag;
    }


    @Override
    //Revert表按降序遍历：
    public List<Revert> getRevert(int id) {
        List<Revert> list=new ArrayList<Revert>();
        String sql="SELECT * FROM revert WHERE MID=? ORDER BY rdate DESC";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                Revert r=new Revert();
                r.setRid(rs.getInt(1));
                r.setMid(rs.getInt(2));
                r.setRcontent(rs.getString(3));
                r.setRname(rs.getString(4));
                r.setRdate(rs.getDate(5).toString());
                list.add(r);               
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        
        return list;
    }
    
}

