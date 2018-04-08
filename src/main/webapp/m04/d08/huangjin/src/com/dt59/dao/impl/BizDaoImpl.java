package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

    public boolean validateUser(UserInfo user) {
        // TODO Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
            pst = getCon().prepareStatement(sql);
            // ��ֵ
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            // ִ��
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public List<NewsInfo> getNews() {
        // TODO Auto-generated method stub
        List<NewsInfo> listnews = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo info = new NewsInfo();
                info.setNewsid(rs.getInt(1));
                info.setTypeid(rs.getInt(2));
                info.setNewstitle(rs.getString(3));
                info.setNewsauthor(rs.getString(4));
                info.setNewssummary(rs.getString(5));
                info.setNewscontent(rs.getString(6));
                info.setNewspic(rs.getString(7));
                listnews.add(info);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

    @Override
    public int update_NewsInfo(NewsInfo newsInfo) {

        // Auto-generated method stub
        return 0;
    }

    @Override
    public int add_NewsInfo(String name) {

        // Auto-generated method stub
        return 0;
    }

    @Override
    public int del_NewsInfo(int news_id) {

        // Auto-generated method stub
        return 0;
    }

}
