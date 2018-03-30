/**
 * Project Name:ClassTest
 * File Name:Test.java
 * Package Name:com.java.dao.impl
 * Date:2018年3月29日下午7:29:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月29日 下午7:29:25 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class Test {
    protected static CallableStatement cstate = null;

    public static void main(String[] args) {
        Connection connection = BaseDao.getConnection();

        String sql = "CALL que_info";
        ResultSet resultSet = null;
        try {
            cstate = connection.prepareCall(sql);
            resultSet = cstate.executeQuery();
            List<QuestionInfo> list = new ArrayList<QuestionInfo>();
            while (resultSet.next()) {
                QuestionInfo questionInfo = new QuestionInfo();
                questionInfo.setQuestionId(resultSet.getInt(1));
                questionInfo.setQuestion(resultSet.getString(2));
                questionInfo.setOptionA(resultSet.getString(3));
                questionInfo.setOptionB(resultSet.getString(4));
                questionInfo.setOptionC(resultSet.getString(5));
                questionInfo.setOptionD(resultSet.getString(6));
                questionInfo.setSubject(resultSet.getInt(7));
                questionInfo.setAnswer(resultSet.getString(8));
                list.add(questionInfo);

            }

            for (QuestionInfo questionInfo : list) {
                System.out.println(questionInfo.getQuestionId() + "、" + questionInfo.getQuestion());
                System.out.println("\t" + "选项A:" + questionInfo.getOptionA());
                System.out.println("\t" + "选项B:" + questionInfo.getOptionB());
                System.out.println("\t" + "选项C:" + questionInfo.getOptionC());
                System.out.println("\t" + "选项D:" + questionInfo.getOptionD());
                System.out.println("\t" + "答案:" + questionInfo.getAnswer());
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(resultSet, null, connection);
        }

    }

}
