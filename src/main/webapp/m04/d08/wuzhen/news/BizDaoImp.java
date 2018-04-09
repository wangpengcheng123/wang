/**
 * Project Name:News
 * File Name:BizDaoImp.java
 * Package Name:news
 * Date:2018年4月3日下午5:55:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午5:55:25 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizDaoImp extends BaseDao implements BizDao{

    @Override
    public boolean yanzheng(UserInfo ui) {
        boolean flag=false;
        String sql="SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
        try {
            ps=getCon().prepareStatement(sql);
            ps.setString(1,ui.getName());
            ps.setString(2,ui.getPsw());
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
    public List<NewsInfo> addTitle(){
        List<NewsInfo> list=new ArrayList<NewsInfo>();       
        String sql="SELECT * FROM news_info";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NewsInfo ni=new NewsInfo();             
                ni.setNews_id(rs.getInt(1));
                ni.setType_id(rs.getInt(2));
                ni.setTitle(rs.getString(3));
                ni.setName(rs.getString(4));
                ni.setSummary(rs.getString(5));
                ni.setContent(rs.getString(6));
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
    public int insert(NewsInfo ni){
        String sql="UPDATE news_info SET type_id=?,news_title=?,news_author=?,news_summary=?,news_content=? WHERE news_id=?";
        int flag=0;
        try {
            ps=getCon().prepareStatement(sql);
            ps.setInt(1,ni.getType_id()); 
            ps.setString(2,ni.getTitle()); 
            ps.setString(3,ni.getName()); 
            ps.setString(4,ni.getSummary()); 
            ps.setString(5,ni.getContent()); 
            ps.setInt(6,ni.getNews_id());        
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
    public List<CommentInfo> getComment()  {
        
        List<CommentInfo> list=new ArrayList<CommentInfo>();
        String sql="SELECT * FROM comment_info";
        try {
            ps=getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                CommentInfo ci=new CommentInfo();
                ci.setComment_id(rs.getInt(1));
                ci.setUserName(rs.getString(2));
                ci.setIp(rs.getString(3));
                ci.setContent(rs.getString(4));
                ci.setNews_id(rs.getInt(5));
                ci.setFbtime(rs.getDate(6));
                list.add(ci);
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

