/**
 * Project Name:PinHong
 * File Name:BizDaoImp.java
 * Package Name:pinhong.dao.imp
 * Date:2018年4月12日下午7:03:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pinhong.dao.BaseDao;
import pinhong.dao.BizDao;
import pinhong.entity.News;
import pinhong.entity.Page;
import pinhong.entity.Product;
import pinhong.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:03:33 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao {

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
        }
       
        return count;
     
    }


    @Override
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
           
        }        
        return list;
    }
}

