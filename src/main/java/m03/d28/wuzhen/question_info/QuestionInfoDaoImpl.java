/**
 * Project Name:wuzhen
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:question_info
 * Date:2018年3月28日下午4:08:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package question_info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:08:31 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {
    /**
     * 查询所有试题：
     * @return List<QuestionInfo>
     **/
    @Override
    public List<QuestionInfo> getInfo() {
        String str="SELECT * FROM question_info";      
        List<QuestionInfo> list=controlDql(str,"");
        return list;
    }
    /**
     * 按科目查询：
     * @return List<QuestionInfo>
     **/
    @Override
    public List<QuestionInfo> querySub(int subject) {
        String str="SELECT * FROM question_info WHERE SUBJECT=?";
        List<QuestionInfo> list=controlDql(str,subject);
            return list;
    }
    /**
     * 按题干查询：
     * @return List<QuestionInfo>
     **/
    public List<QuestionInfo> queryQues(String question) {
        String str="SELECT * FROM question_info WHERE question Like ?";      
        List<QuestionInfo> list=controlDql(str,question);
        return list;
        
    }

    @Override
    public boolean add(QuestionInfo q) {
        String str="INSERT INTO question_info VALUES(?,?,?,?,?,?,?,?)";
        boolean flag=false;
        try {
            ps=getCon().prepareStatement(str);
            ps.setInt(1,q.getQuestionId());
            ps.setString(2,q.getQuestion());
            ps.setString(3, q.getOptionA());
            ps.setString(4, q.getOptionB());
            ps.setString(5, q.getOptionC());
            ps.setString(6, q.getOptionD());
            ps.setInt(7, q.getSubject());
            ps.setString(8,q.getAnswer());
            flag=ps.execute();
        } catch (SQLException e) {
             //  Auto-generated catch block
            e.printStackTrace();
            
        }
     
        return flag;
    }
    //遍历集合；（即遍历表）
    public void print(List<QuestionInfo> list){
        for(QuestionInfo qi:list){
            System.out.println(qi.getQuestionId()+"、"+qi.getQuestion()+"\n"+"选项A："+qi.getOptionA()+"\n"
                    +"选项B："+qi.getOptionB()+"\n"+"选项C："+qi.getOptionC()+"\n"+"选项D："+qi.getOptionD()+"\n"+"答案："+
                    qi.getAnswer());
    }
    }
    @Override
    //删除
    public int del(int questionId) {
        String str="DELETE FROM question_info WHERE questionId=?";
        int flag=0;
        try {
            ps=getCon().prepareStatement(str);
            ps.setInt(1,questionId);
            flag=ps.executeUpdate();
            
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();       
        }
        
        return flag;
    }
   

}

