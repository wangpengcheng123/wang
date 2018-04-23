/**
 * Project Name:Shopping
 * File Name:BizDaoImpl.java
 * Package Name:Demo.Dao.Impl
 * Date:2018年4月19日下午12:06:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Demo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import Demo.Dao.BaseDao;
import Demo.Dao.BizDao;
import Demo.entity.ShangPings;
import Demo.entity.User;
import Demo.entity.Goumais;
/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:06:39 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public boolean Passresult(User user) {
        boolean flag=false;
        try {
            String sql="SELECT*FROM USER WHERE username=? AND PASSWORD=?";
            pst=getCon().prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            rs=pst.executeQuery();
            while(rs.next()){
                flag=true;
            }
                    
        } catch (Exception e) {
            // TODO: handle exception
        }
        //  Auto-generated method stub
        return flag;
    }

    @Override
    public List<ShangPings> getAllshangping() {
        List<ShangPings> listshangping=new ArrayList<ShangPings>();
        //  Auto-generated method stub
        try {
            String sql="SELECT*FROM shangping";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                ShangPings sp=new ShangPings();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getString(3));
                sp.setSpdesc(rs.getString(4));
                listshangping.add(sp); 
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return listshangping;
    }

    @Override
    public ShangPings  getAddshangping(int spid) {
      //  List<ShangPings> listadd=new ArrayList<ShangPings>();
        ShangPings sp1=null;
        //  Auto-generated method stub
        try {
            String sql="SELECT*FROM shangping WHERE SPID=?";
          
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, spid);
            rs=pst.executeQuery();
            while(rs.next()){
                sp1=new ShangPings();
                sp1.setSpid(rs.getInt(1));
                sp1.setSpname(rs.getString(2));
                sp1.setSpprice(rs.getString(3));
                sp1.setSpdesc(rs.getString(4));
             //   sp1.setNum(rs.getInt(5));
               
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return sp1;
    }

    @Override
    public int Goumais(Goumais go) {
        int flag=0;
        try {
            String sql="INSERT INTO gouwuche (spid,spname,spnum,spprice,spdesc,zongjia) VALUE (?,?,?,?,?,?) ";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, go.getSpid());
            pst.setString(2, go.getSpname());
            pst.setInt(3, go.getSpnum());
            pst.setFloat(4, go.getSpprice());
            pst.setString(5, go.getSpdesc());
            pst.setFloat(6, go.getZongjia());
            flag=pst.executeUpdate();
           
        } catch (Exception e) {
            // TODO: handle exception
        }
        //  Auto-generated method stub
        return flag;
    }

  

}

