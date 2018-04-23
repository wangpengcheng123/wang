/**
 * Project Name:GouWuChe
 * File Name:BizDaoImp.java
 * Package Name:gouwuche.dao.imp
 * Date:2018年4月19日下午12:00:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jquery_json.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jquery_json.dao.BaseDao;
import jquery_json.dao.BizDao;
import jquery_json.entity.City;
import jquery_json.entity.Province;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:00:45 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao{

    @Override
    public List<Province> getAllProvince() {
        List<Province> list=new ArrayList<Province>();
        String sql="SELECT * FROM province";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Province pro=new Province();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));        
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
    public List<City> getCity(int pid) {      
        String sql="SELECT * FROM city WHERE pid=?";
        List<City> list=new ArrayList<City>();
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,pid);
            rs=ps.executeQuery();
            while(rs.next()){
                City city = new City();
                city.setPid(rs.getInt(1));
                city.setCid(rs.getInt(2));
                city.setCname(rs.getString(3));
                list.add(city);
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

 