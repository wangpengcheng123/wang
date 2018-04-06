/**
 * Project Name:huangjin
 * File Name:BizDaoImp.java
 * Package Name:news
 * Date:2018年4月6日下午6:32:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午6:32:12 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao {

    @Override
    public boolean yanzheng(UserInfo ui) {
        boolean flag = false;
        String sql = "SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, ui.getName());
            ps.setString(2, ui.getPsw());
            rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(con, ps, rs);
        }

        return flag;
    }

    @Override
    public List<NewsInfo> addTitle() {
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        String sql = "SELECT news_title,news_author FROM news_info";
        try {
            ps = getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NewsInfo ni = new NewsInfo();
                ni.setTitle(rs.getString(1));
                ni.setName(rs.getString(2));
                list.add(ni);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

}
