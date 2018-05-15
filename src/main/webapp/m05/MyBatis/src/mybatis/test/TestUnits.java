/**
 * Project Name:MyBatis
 * File Name:TestUnits.java
 * Package Name:mybatis.test
 * Date:2018年5月14日下午2:29:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mybatis.test;


import java.util.HashMap;
import java.util.List;








import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import mybatis.dao.BizDao;
import mybatis.pojo.Grade;
import mybatis.pojo.Stu;
import mybatis.util.GetSqlSession;

/**
 * Description:   <br/>
 * Date:     2018年5月14日 下午2:29:11 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class TestUnits {
    GetSqlSession gss=GetSqlSession.getInstance();
    SqlSessionFactory ssf=gss.getSqlSessionFactory();
    SqlSession ss=ssf.openSession();
    BizDao bizDao=ss.getMapper(BizDao.class);
    @Test
    public void show1(){      
        List<Stu> list1=bizDao.getAllStu();
        for(Stu stu:list1){ 
            System.out.println("学生编号："+stu.getId()+"\t"+"学生姓名："+stu.getName()+"\t"+"性别："+stu.getSex());
        } 
        ss.close();
    } 
    @Test
    public void show2(){
        Stu s=bizDao.getAllStuById(1);
        System.out.println("学生姓名："+s.getName());
        ss.close(); 
    }
    @Test
    public void show3(){
        List<Stu> list2=bizDao.getAllStuByWord("男"); 
        for(Stu stu1:list2){
            System.out.println("学生编号："+stu1.getId()+"\t"+"学生姓名："+stu1.getName()+"\t"+"性别："+stu1.getSex());
        }
        ss.close();
    }
    @Test
    public void show4(){
        Stu stu2=new Stu(9,"大白白",22,"女",1);
        bizDao.add(stu2);
        ss.commit();
    } 
    @Test
    public void show5(){
       List<HashMap<String, Integer>> list=bizDao.group();
       System.out.println("年级"+"\t"+"人数");
       for(int i=0;i<list.size();i++){
           HashMap<String,Integer> map=list.get(i);   
           Set<String> set=map.keySet();
          for(String str:set){
              System.out.print(map.get(str)+"\t");
          }
          System.out.println();
          
       }
    }
    @Test
    public void show6(){
       List<Grade> list= bizDao.getStu();
       System.out.println("班级"+"\t"+"学生编号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"性别");
       for(int i=0;i<list.size();i++){
          Grade grade=list.get(i);
          Set<Stu> set=grade.set;
          for(Stu stu:set){
              System.out.println(list.get(i).getName()+"\t"+stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getSex());
          } 
       }
    }
}
     


