/**
 * Project Name:MyBatis
 * File Name:BizDao.java
 * Package Name:mybatis.dao
 * Date:2018年5月14日上午10:51:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import mybatis.pojo.Grade;
import mybatis.pojo.Stu;

/**
 * Description:   <br/>
 * Date:     2018年5月14日 上午10:51:38 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface BizDao {

    List<Stu> getAllStu();//遍历表stu表
    Stu getAllStuById(int id);//通过id查询
    List<Stu> getAllStuByWord(String word);//模糊查询
    void add(Stu stu); 
    List<HashMap<String,Integer>> group(); 
    List<Grade> getStu();
}   

