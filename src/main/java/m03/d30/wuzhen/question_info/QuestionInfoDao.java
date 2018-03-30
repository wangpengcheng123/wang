/**
 * Project Name:wuzhen
 * File Name:QuestionInfoDao.java
 * Package Name:question_info
 * Date:2018年3月28日下午4:07:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package question_info;


import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:07:56 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface QuestionInfoDao {

    //Dao接口：定义操作数据库表的方法
    //列出所有试题信息
    List<QuestionInfo> getInfo(); 
    //按科目查询
    List<QuestionInfo> querySub(int subject);
    //按题干模糊查询
    List<QuestionInfo> queryQues(String question);
    //添加试题
    boolean add(QuestionInfo Q);
    //删除试题
    int del(int questionId);
}

