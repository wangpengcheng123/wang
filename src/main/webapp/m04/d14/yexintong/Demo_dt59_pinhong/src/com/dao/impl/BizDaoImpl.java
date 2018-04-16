/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizDaoImpl.java
 * Package Name:com.dao.impl
 * Date:2018-4-12下午6:51:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.BizDao;
import com.entity.LoGin;
import com.entity.News;
import com.entity.Page;
import com.entity.Product;

/**
 * Description:   <br/>
 * Date:     2018-4-12 下午6:51:42 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao{

    public List<News> getNewsAll() {
        List<News> listNews=new ArrayList<News>();
        try {
            String sql="SELECT * FROM news";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                News ns=new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setnDate(rs.getDate(4));
                listNews.add(ns);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return listNews;
    }

    public List<Product> getProAll() {
        List<Product> listPro=new ArrayList<Product>();
        try {
            String sql="SELECT * FROM product ";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                Product pro =new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listPro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return listPro;
    }

    public boolean getDenglu(LoGin loGin) {
        boolean flag=false;
        //  Auto-generated method stub
        try {
            String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst=getCon().prepareStatement(sql);
            pst.setString(1, loGin.getUname() );
            pst.setString(2, loGin.getUpwd());
            rs=pst.executeQuery();
            while(rs.next()){
                flag=true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        return flag;
    }

    public List<LoGin> getAllUser() {
        List<LoGin> listUser=new ArrayList<LoGin>();
        try {
            String sql="SELECT * FROM USER";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                LoGin userLoGin=new LoGin();
                userLoGin.setUid(rs.getInt(1));
                userLoGin.setUname(rs.getString(2));
                userLoGin.setUpwd(rs.getString(3));
                userLoGin.setUstatus(rs.getString(4));
                userLoGin.setUpic(rs.getString(5));
                listUser.add(userLoGin);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return listUser;
    }

    public String getUserUstatus(LoGin loGin) {
        String uStatus="";
        try {
            String sql="SELECT ustatus FROM USER WHERE uname=? AND upwd=?";
            pst=getCon().prepareStatement(sql);
            pst.setString(1, loGin.getUname() );
            pst.setString(2, loGin.getUpwd());
            rs=pst.executeQuery();
            while(rs.next()){
               uStatus= rs.getString(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  Auto-generated method stub
        return uStatus;
    }

    public List<Product> getLimit(Page page) {
        List<Product> listPro=new ArrayList<Product>();
        try {
            String sql="SELECT * FROM product limit ?,? ";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpae()-1)*page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs=pst.executeQuery();
            while(rs.next()){
                Product pro =new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listPro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return listPro;
    }

}

