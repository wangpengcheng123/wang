/**
 * Project Name:dt59_shopping
 * File Name:BaseDaoImpl.java
 * Package Name:com.shopping.dao.impl
 * Date:2018-4-19下午2:55:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.BizDao;
import com.shopping.entity.Shangping;
import com.shopping.entity.UserDemo;

/**
 * Description:   <br/>
 * Date:     2018-4-19 下午2:55:44 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class BaseDaoImpl extends BaseDao implements BizDao{

    public List<Shangping> getAllShangping() {
        List<Shangping> listShangping=new ArrayList<Shangping>();
        String sql="SELECT * FROM shangping";
        try {
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                Shangping sp=new Shangping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getFloat(3));
                sp.setSpdesc(rs.getString(4));
                listShangping.add(sp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return listShangping;
    }

    public boolean getDenglu(UserDemo userDemo) {
        boolean flag=false;
        try {
            String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst=getCon().prepareStatement(sql);
            pst.setString(1, userDemo.getUname());
            pst.setString(2, userDemo.getUpwd());
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
        //  Auto-generated method stub
        return flag;
    }

    public List<Shangping> addShangping(Shangping sp) {
        List<Shangping> addSpList=new ArrayList<Shangping>();
        String sql="SELECT * FROM shangping WHERE spid=?";
        try {
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, sp.getSpid());
            rs=pst.executeQuery();
            while(rs.next()){
                Shangping shangping=new Shangping();
                shangping.setSpid(rs.getInt(1));
                shangping.setSpname(rs.getString(2));
                shangping.setSpprice(rs.getFloat(3));
                shangping.setSpdesc(rs.getString(4));
                addSpList.add(shangping);
            }
        } catch (SQLException e) {            
            //  Auto-generated catch block
            e.printStackTrace();          
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return addSpList;
    }

}

