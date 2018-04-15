/**
 * Project Name:Demo_PingH
 * File Name:Impl.java
 * Package Name:java.cn.Dao.BizDaoImpl
 * Date:2018年4月12日下午7:00:19
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package java.cn.Dao.BizDaoImpl;

import java.cn.Dao.BaseDao;
import java.cn.Dao.BizDao;
import java.cn.entity.News;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:00:19 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class Impl extends BaseDao implements BizDao {

    @Override
    public List<News> getAllNews() {
        List<News> listnews=new ArrayList<News>();
        String sql="SELECT*FROM news";
        try {
          pst=getCon().prepareStatement(sql);
          rs=pst.executeQuery();
          while(rs.next()){
              News news=new News();
              news.setNid(rs.getInt(1));
              news.setNtitle(rs.getString(2));
              news.setNcontent(rs.getNString(3));
              news.setNdate(rs.getDate(4));
              listnews.add(news);
          }
        } catch (Exception e) {
            // TODO: handle exception
        }
        //  Auto-generated method stub
        return listnews;
    }

}

