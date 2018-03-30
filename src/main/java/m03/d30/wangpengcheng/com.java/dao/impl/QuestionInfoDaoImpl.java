/**
 * Project Name:ClassTest
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.java.dao.impl
 * Date:2018年3月28日下午3:58:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.QuestionInfoDao;
import com.java.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午3:58:08 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class QuestionInfoDaoImpl implements QuestionInfoDao<QuestionInfo> {

    private PreparedStatement pStatement = null;

    private CallableStatement cstate = null;

    /**
     * 向数据库插入数据，每个？都对应一个实体类中的一个字段，因为要插入数据，所以用实体类将要插入的信息记录下来
     * 然后再将该实体类传给操作数据库的类，在操作数据库的类中每个？用每个实体类的字段的值表示
     * ，最后数据库会返回一个信息，再依据该信息，进行判断是否插入成功
     * 
     * @see com.java.dao.QuestionInfoDao#insertDemo(java.lang.Object)
     */
    @Override
    public int insertDemo(QuestionInfo t) {
        Connection connection = BaseDao.getConnection();
        int num = 0;
        try {

            String sql = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,SUBJECT,answer)"
                    + " VALUES (?,?,?,?,?,?,?)";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, t.getQuestion());
            pStatement.setString(2, t.getOptionA());
            pStatement.setString(3, t.getOptionB());
            pStatement.setString(4, t.getOptionC());
            pStatement.setString(5, t.getOptionD());
            pStatement.setInt(6, t.getSubject());
            pStatement.setString(7, t.getAnswer());
            num = pStatement.executeUpdate();

        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(null, pStatement, connection);
        }
        return num;
    }

    /**
     * 依旧id删除数据，只需将id传给数据库就行了
     *
     * @see com.java.dao.QuestionInfoDao#deleteDemo(int)
     */
    @Override
    public int deleteDemo(int questionId) {
        Connection connection = BaseDao.getConnection();
        String sql = "DELETE FROM question_info WHERE questionId=?";
        int num = 0;
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, questionId);
            num = pStatement.executeUpdate();
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(null, pStatement, connection);
        }
        return num;
    }

    /**
     * 查询所有，不需要传参数进去，只需要将存储数据的集合返回就行了，也可以不返回直接在该方法中打印就行（看需求）
     *
     * @see com.java.dao.QuestionInfoDao#seleteDemo1()
     */
    @Override
    public List<QuestionInfo> seleteDemo1() {
        Connection connection = BaseDao.getConnection();
        String sql = "SELECT * FROM question_info";
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        ResultSet resultSet = null;
        try {
            pStatement = connection.prepareStatement(sql);
            resultSet = pStatement.executeQuery();
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
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(resultSet, pStatement, connection);
        }

        return list;
    }

    /**
     * 模糊查询将要模糊查询的东西传进来，因为模糊查询需要用到%，所以可以用stringbuffer,stringbuilder，或+连接
     *
     * @see com.java.dao.QuestionInfoDao#seleteDemo2(java.lang.String)
     */
    @Override
    public List<QuestionInfo> seleteDemo2(String string) {
        Connection connection = BaseDao.getConnection();
        String sql = "SELECT * FROM question_info WHERE question LIKE ?";
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        ResultSet resultSet = null;
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, string);
            resultSet = pStatement.executeQuery();
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

        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(resultSet, pStatement, connection);
        }

        return list;
    }

    // 依据科目查询只需，将科目的值传进来就行
    @Override
    public List<QuestionInfo> seleteDemo3(int subject) {
        Connection connection = BaseDao.getConnection();
        String sql = "SELECT * FROM question_info WHERE SUBJECT IN(?)";
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        ResultSet resultSet = null;

        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, subject);
            resultSet = pStatement.executeQuery();
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
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            BaseDao.close(resultSet, pStatement, connection);
        }

        return list;
    }

    // 用存储过程列出所有题目信息
    @Override
    public List<QuestionInfo> printDemo() {
        Connection connection = BaseDao.getConnection();
        List<QuestionInfo> list = null;

        String sql = "CALL que_info";
        ResultSet resultSet = null;
        try {
            cstate = connection.prepareCall(sql);
            resultSet = cstate.executeQuery();
            list = new ArrayList<QuestionInfo>();
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

        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (cstate != null) {
                    cstate.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }
        return list;

    }

    @Override
    public List<QuestionInfo> moHuDemo(String question) {
        Connection connection = BaseDao.getConnection();
        List<QuestionInfo> list = null;

        String sql = "CALL que_info2(?)";
        ResultSet resultSet = null;
        try {
            cstate = connection.prepareCall(sql);
            cstate.setString(1, question);
            resultSet = cstate.executeQuery();
            list = new ArrayList<QuestionInfo>();
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

        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (cstate != null) {
                    cstate.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }

        return list;
    }

}
