/**
 * Project Name:dt59_dao
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.entity
 * Date:2018年3月28日下午5:01:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.QuestionInfoDao;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:01:03 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 创建DAO实现类QuestionInfoDaoImpl，继承BaseDao类，实现QuestionInfoDao接口，使用JDBC完成相应数据库操作
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllInfo() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info";
        try {
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionID(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(con, pst, rs);
        }

        return list;
    }

    @Override
    public int insertInfo(Object t) {
        int flag = 0;

        try {
            String sql = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,SUBJECT,answer)"
                    + "VALUES(?,?,?,?,?,?,?)";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int deleteInfo(int questionID) {
        int flag = 0;
        try {
            String sql = "Delete FROM question_Info WHERE questionID=?";
            Object[] obj = new Object[1];
            obj[0] = questionID;
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return flag;
    }

}
