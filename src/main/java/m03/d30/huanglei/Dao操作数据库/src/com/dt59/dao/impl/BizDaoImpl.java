package com.dt59.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.QuestionInfo;

public class BizDaoImpl extends BaseDao implements BizDao{
   
    //调用接口查询
    @Override
    public List<QuestionInfo> getAllQuestionInfo() {
        List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
        try {
            String sql="CALL showquestion";
            pst=getCon().prepareCall(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                QuestionInfo info=new QuestionInfo();
                info.setQuestionId(rs.getInt(1));
                info.setQuestion(rs.getString(2));
                info.setOptionA(rs.getString(3));
                info.setOptionB(rs.getString(4));
                info.setOptionC(rs.getString(5));
                info.setOptionD(rs.getString(6));
                info.setSubject(rs.getInt(7));
                info.setAnswer(rs.getString(8));
                listinfo.add(info);
            }
     } catch (SQLException e) {
         
         //  Auto-generated catch block
         e.printStackTrace();
         
     }
         //  Auto-generated method stub
        return listinfo;
    }

	

	@Override
	public List<QuestionInfo> getQuestionInfoByKm(int subject) {
		// TODO Auto-generated method stub
		List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
		try {
			String sql="SELECT * FROM questioninfo WHERE SUBJECT = ?";
			pst= getCon().prepareStatement(sql);
			//赋值
			pst.setInt(1, subject);
			rs=pst.executeQuery();
			while(rs.next()){
				QuestionInfo info=new QuestionInfo();
				info.setQuestionId(rs.getInt(1));
				info.setQuestion(rs.getString(2));
				info.setOptionA(rs.getString(3));
				info.setOptionB(rs.getString(4));
				info.setOptionC(rs.getString(5));
				info.setOptionD(rs.getString(6));
				info.setSubject(rs.getInt(7));
				info.setAnswer(rs.getString(8));
				listinfo.add(info);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listinfo;
	}

	@Override
	public List<QuestionInfo> getQuestionInfoByTg(String title) {
		// TODO Auto-generated method stub
		List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
		try {
			String sql="CALL mohu(?)";
			pst=getCon().prepareCall(sql);
			//赋值
			pst.setString(1,title);
			
			rs=pst.executeQuery();
			
			while(rs.next()){
				QuestionInfo info=new QuestionInfo();
				info.setQuestionId(rs.getInt(1));
				info.setQuestion(rs.getString(2));
				info.setOptionA(rs.getString(3));
				info.setOptionB(rs.getString(4));
				info.setOptionC(rs.getString(5));
				info.setOptionD(rs.getString(6));
				info.setSubject(rs.getInt(7));
				info.setAnswer(rs.getString(8));
				listinfo.add(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listinfo;
	}

	@Override
	public int saveQuestionInfo(QuestionInfo info) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="INSERT INTO questioninfo(Question,optionA,optionB,optionC,optionD,SUBJECT,answer) VALUES(?,?,?,?,?,?,?)";
			Object[] obj=new Object[7];
			obj[0]=info.getQuestion();
			obj[1]=info.getOptionA();
			obj[2]=info.getOptionB();
			obj[3]=info.getOptionC();
			obj[4]=info.getOptionD();
			obj[5]=info.getSubject();
			obj[6]=info.getAnswer();
			flag=controlDml(sql,obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteQuestionInfoById(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="DELETE FROM questioninfo WHERE QuestionId=?";
			Object[] obj=new Object[1];
			obj[0]=id;
			flag=controlDml(sql,obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void exitQuestion() {
		// TODO Auto-generated method stub
		System.exit(1);
	}

    
  

}
