package com.dt59.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
			pst=getCon().prepareStatement(sql);
			//��ֵ
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			//ִ��
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public List<NewsInfo> getNews() {
		// TODO Auto-generated method stub
		List<NewsInfo> listnews=new ArrayList<NewsInfo>();
		try {
			String sql="SELECT * FROM news_info";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				NewsInfo info=new NewsInfo();
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
		}finally{
			close(con,pst,rs);
		}
		return listnews;
	}
      //删除
	public int delNewsInfoById(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="DELETE FROM news_info WHERE news_id=?";
			pst=getCon().prepareStatement(sql);
			pst.setInt(1, id);
			flag= pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

    @Override//首页内容更新
    public List<CommentInfo> getComment() {
        
     // TODO Auto-generated method stub
        List<CommentInfo> listnews1=new ArrayList<CommentInfo>();
        try {
            String sql="SELECT*FROM comment_info";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                CommentInfo info1=new CommentInfo();
                info1.setCommentid(rs.getInt(1));
                info1.setUsername(rs.getString(2));
                info1.setIp(rs.getInt(3));
                info1.setContent(rs.getString(4));
                info1.setId(rs.getInt(5));
                info1.setFbtime(rs.getString(6));
                listnews1.add(info1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listnews1;
    }

    @Override//修改数据
    public List<NewsInfo> getNewsInfoInfo(int id) {
        
        // TODO Auto-generated method stub
        List<NewsInfo> listnews2=new ArrayList<NewsInfo>();
        try {
            String sql="SELECT*FROM news_info WHERE news_id=?";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while(rs.next()){
                NewsInfo info2=new NewsInfo();
                info2.setNewsid(rs.getInt(1));
                info2.setTypeid(rs.getInt(2));
                info2.setNewstitle(rs.getString(3));
                info2.setNewsauthor(rs.getString(4));
                info2.setNewssummary(rs.getString(5));
                info2.setNewscontent(rs.getString(6));
                info2.setNewspic(rs.getString(7));
                listnews2.add(info2);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listnews2;
    }

    @Override
    public int add(Object t) {
        
        //  Auto-generated method stub
        int flag = 0;
        String sql = "UPDATE news_info SET news_title=?,news_author=? WHERE news_id=?";
        Object[] obj = new Object[3];
        if (t instanceof NewsInfo) {
            NewsInfo nf = (NewsInfo) t;
            obj[0] = nf.getNewstitle();
            obj[1] = nf.getNewsauthor();
            obj[2] = nf.getNewsid();
        }
        flag=controlDml(sql, obj);
        return flag;
    }

    @Override
    public List<NewsInfo> getPages(Page page) {
        List<NewsInfo> listnews=new ArrayList<NewsInfo>();
        String sql="SELECT*FROM news_info LIMIT ?,?";
       try {
           pst=getCon().prepareStatement(sql);
           pst.setInt(1, (page.getCurrentpage()-1)*page.getPagesize());
           pst.setInt(2, page.getPagesize());
           rs=pst.executeQuery();
           while(rs.next()){
               NewsInfo info=new NewsInfo();
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
    }
        //  Auto-generated method stub
        return listnews;
    }

 


    

	
}
