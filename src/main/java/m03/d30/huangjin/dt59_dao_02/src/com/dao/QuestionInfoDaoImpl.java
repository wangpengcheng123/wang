/**
 * Project Name:dt59_dao_02
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.dao
 * Date:2018年3月30日下午7:31:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午7:31:12 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {
    /*
     * 查询所有试题
     */
    @Override
    public List<QuestionInfo> getInfo() {
        String sql = "CALL queryall()";
        // List<QuestionInfo> list=controlDql(str,"");
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            cs = getCon().prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                QuestionInfo ques = new QuestionInfo();
                ques.setQuestionId(rs.getInt(1));
                ques.setQuestion(rs.getString(2));
                ques.setOptionA(rs.getString(3));
                ques.setOptionB(rs.getString(4));
                ques.setOptionC(rs.getString(5));
                ques.setOptionD(rs.getString(6));
                ques.setSubject(rs.getInt(7));
                ques.setAnswer(rs.getString(8));
                list.add(ques);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    /*
     * 按科目查询
     */
    @Override
    public List<QuestionInfo> querySub(int subject) {
        String str = "SELECT * FROM question_info WHERE SUBJECT=?";
        List<QuestionInfo> list = controlDql(str, subject);
        return list;
    }

    /*
     * 模糊查询
     */
    @Override
    public List<QuestionInfo> queryLike(String question) {
        String str = "CALL querybyquestion()";
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            cs = getCon().prepareCall(str);
            rs = cs.executeQuery();
            while (rs.next()) {
                QuestionInfo ques = new QuestionInfo();
                ques.setQuestionId(rs.getInt(1));
                ques.setQuestion(rs.getString(2));
                ques.setOptionA(rs.getString(3));
                ques.setOptionB(rs.getString(4));
                ques.setOptionC(rs.getString(5));
                ques.setOptionD(rs.getString(6));
                ques.setSubject(rs.getInt(7));
                ques.setAnswer(rs.getString(8));
                list.add(ques);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

    /*
     * 添加试题
     */
    @Override
    public boolean add(QuestionInfo Q) {
        String str = "INSERT INTO question_info VALUES(?,?,?,?,?,?,?,?)";
        boolean flag = false;
        try {
            ps = getCon().prepareStatement(str);
            ps.setString(1, "question");
            ps.setString(2, "optionA");
            ps.setString(3, "optionB");
            ps.setString(4, "optionC");
            ps.setString(5, "optionD");
            ps.setString(6, "subject");
            ps.setString(7, "answer");
            rs = ps.executeQuery();
            flag = ps.execute();
        } catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /*
     * 删除试题
     */
    @Override
    public int del(int questionID) {
        String str = "DELETE FROM question_info WHERE questionId=?";
        int flag = 0;
        try {
            ps = getCon().prepareStatement(str);
            ps.setInt(1, questionID);
            flag = ps.executeUpdate();

        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();
        }

        return flag;
    }

    // 显示数据表信息的方法
    public void print(List<QuestionInfo> list) {
        for (QuestionInfo qi : list) {
            System.out.println(qi.getQuestionId() + "、" + qi.getQuestion() + "\n" + "选项A：" + qi.getOptionA() + "\n"
                    + "选项B：" + qi.getOptionB() + "\n" + "选项C：" + qi.getOptionC() + "\n" + "选项D：" + qi.getOptionD()
                    + "\n" + "答案：" + qi.getAnswer());
        }
    }
}
