/**
 * Project Name:WE_XXGLXX
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.dt59lilin.dao.impl
 * Date:2018年3月28日下午4:11:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59lilin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59lilin.dao.BaseDao;
import com.dt59lilin.dao.QuestionInfoDao;
import com.dt59lilin.house.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:11:21 <br/>
 * @author   11324
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao{

    @Override
    public List<QuestionInfo> getAll() {
        List<QuestionInfo> list = new ArrayList<>();//建立集合
        try {
           String str = "CALL inifall";//创建语句
           //pst = getCon().prepareStatement(str);//加载
           cs = getCon().prepareCall(str);
           rs = cs.executeQuery();//执行
           while(rs.next()){
               QuestionInfo qi = new QuestionInfo();
               qi.setQuestionId(rs.getInt(1));
               qi.setQuestion(rs.getString(2));
               qi.setOptionA(rs.getString(3));
               qi.setOptionB(rs.getString(4));
               qi.setOptionC(rs.getString(5));
               qi.setOptionD(rs.getString(6));
               qi.setSubject(rs.getInt(7));
               qi.setAnswer(rs.getString(8));
               list.add(qi);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return list;
    }

    @Override
    public List<QuestionInfo> getAll(int x) {
        List<QuestionInfo> list1 = new ArrayList<>();
        try {
            String str = "SELECT * FROM question_info AS q WHERE q.`subject`=?";
            pst = getCon().prepareStatement(str);//加载
            pst.setInt(1, x);
            rs = pst.executeQuery();//执行
            while(rs.next()){
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list1.add(qi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return list1;
    }
    
   /* @Override
    public List<QuestionInfo> getAll2() {
        List<QuestionInfo> list2 = new ArrayList<>();
        try {
            String str = "SELECT * FROM question_info AS q WHERE q.`subject`=2";
            pst = getCon().prepareStatement(str);//加载
            rs = pst.executeQuery();//执行
            while(rs.next()){
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list2.add(qi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return list2;
    }

    
    @Override
    public List<QuestionInfo> getAll3() {
        List<QuestionInfo> list3 = new ArrayList<>();
        try {
            String str = "SELECT * FROM question_info AS q WHERE q.`subject`=3";
            pst = getCon().prepareStatement(str);//加载
            rs = pst.executeQuery();//执行
            while(rs.next()){
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list3.add(qi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return list3;
    }*/

    @Override
    public int saveInfo(Object t) {
        int flag=0;
        try {
            String str = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,subject,answer) VALUES(?,?,?,?,?,?,?)";
            Object[] obj = new Object[7];
            if(t instanceof QuestionInfo){
                QuestionInfo qd = (QuestionInfo)t;
                obj[0] = qd.getQuestion();
                obj[1] = qd.getOptionA();
                obj[2] = qd.getOptionB();
                obj[3] = qd.getOptionC();
                obj[4] = qd.getOptionD();
                obj[5] = qd.getSubject();
                obj[6] = qd.getAnswer();
            }
            controlDml(str,obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteInfo(int id) {
        // TODO Auto-generated method stub
        int flag=0;
        try {
            String sql="DELETE FROM question_info WHERE questionId=?";
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
    public List getAllGJZ(String x) {
        
        List<QuestionInfo> list = new ArrayList<>();//建立集合
        try {
           String str = "SELECT * FROM question_info WHERE question LIKE ?"/*+"'%"+x+"%'"*/;//创建语句
           pst = getCon().prepareStatement(str);//加载
           pst.setString(1, "%"+x+"%");
           rs = pst.executeQuery();//执行
           while(rs.next()){
               QuestionInfo qi = new QuestionInfo();
               qi.setQuestionId(rs.getInt(1));
               qi.setQuestion(rs.getString(2));
               qi.setOptionA(rs.getString(3));
               qi.setOptionB(rs.getString(4));
               qi.setOptionC(rs.getString(5));
               qi.setOptionD(rs.getString(6));
               qi.setSubject(rs.getInt(7));
               qi.setAnswer(rs.getString(8));
               list.add(qi);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            Close(con,pst,rs);
        }
        return list;
    }


}

