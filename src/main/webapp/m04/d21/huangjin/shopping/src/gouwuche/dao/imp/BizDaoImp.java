/**
 * Project Name:GouWuChe
 * File Name:BizDaoImp.java
 * Package Name:gouwuche.dao.imp
 * Date:2018年4月19日下午12:00:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package gouwuche.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import gouwuche.dao.BaseDao;
import gouwuche.dao.BizDao;
import gouwuche.entity.BuyList;
import gouwuche.entity.Products;
import gouwuche.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:00:45 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao{

    @Override
    public List<Products> getAllProducts() {
        List<Products> list=new ArrayList<Products>();
        String sql="SELECT * FROM products";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Products pro=new Products();
                pro.setSpid(rs.getInt(1));
                pro.setSpname(rs.getString(2));
                pro.setSpprice(rs.getFloat(3));
                pro.setSpdesc(rs.getString(4));
                list.add(pro);
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
    public boolean validate(User user) {
        boolean flag=false;
        String sql="SELECT * FROM uesr WHERE uname=? AND upwd=?";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setString(1,user.getUname());
            ps.setString(2,user.getUpwd());
            rs=ps.executeQuery();
            while(rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        
        return flag;
    }

   
    
   
    public Products getProById(int id) {      
        String sql="SELECT * FROM products WHERE spid=?";
        Products pro=null;
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                pro = new Products();
                pro.setSpid(rs.getInt(1));
                pro.setSpname(rs.getString(2));
                pro.setSpprice(rs.getFloat(3));
                pro.setSpdesc(rs.getString(4));
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        return pro;
    }

    @Override
    public int addBuyList(BuyList bl) {
        int flag=0;
        String sql="INSERT INTO buylist VALUES(?,?,?,?,?,?)";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,bl.getSpid());
            ps.setString(2,bl.getSpname());
            ps.setFloat(3,bl.getSpprice());
            ps.setInt(4,bl.getAmount());
            ps.setString(5,bl.getSpdesc());
            ps.setFloat(6, bl.getTotalprice());
            flag=ps.executeUpdate();
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(con,ps,rs);
        }
        return flag;
    }
    
 
}

