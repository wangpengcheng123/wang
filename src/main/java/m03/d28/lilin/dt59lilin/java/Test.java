/**
 * Project Name:WE_XXGLXX
 * File Name:Test.java
 * Package Name:com.dt59lilin.java
 * Date:2018年3月28日下午4:09:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59lilin.java;

import java.util.List;
import java.util.Scanner;

import com.dt59lilin.dao.QuestionInfoDao;
import com.dt59lilin.dao.impl.QuestionInfoDaoImpl;
import com.dt59lilin.house.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:09:05 <br/>
 * @author   11324
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean aa = true;
        while(aa){
        System.out.println("**************************欢迎使用试题管理系统************************************\n");
        System.out.println("请选择操作(1.列出所有试题信息   2.按科目查询    3.按题干模糊查询    4.添加试题    5.删除试题    6.退出系统):");
        int a = input.nextInt();
        switch(a){
            case 1:
                Allinfo();
                break;
            case 2:
                System.out.println("输入科目(1.Java 2.C# 3.JSP)");
                int b = input.nextInt();
                if(b==1){
                Allinfo1();}
                if(b==2){
                    Allinfo2();}
                if(b==3){
                    Allinfo3();}
                break;
            case 3:
                System.out.println("请输入题干:");
                TG(input.next());
                break;
            case 4:
                QuestionInfoDao qd = new QuestionInfoDaoImpl();
                QuestionInfo qi = new QuestionInfo();
                System.out.println("请输入新的题干:");
                qi.setQuestion(input.next());
                System.out.println("请输入新的选项A:");
                qi.setOptionA(input.next());
                System.out.println("请输入新的选项B:");
                qi.setOptionB(input.next());
                System.out.println("请输入新的选项C:");
                qi.setOptionC(input.next());
                System.out.println("请输入新的选项D:");
                qi.setOptionD(input.next());
                System.out.println("请输入题目类别:");
                qi.setSubject(input.nextInt());
                System.out.println("请输入新的答案:");
                qi.setAnswer(input.next());
                int flag = qd.saveInfo(qi);
               if(flag==0){
                   System.out.println("添加成功");
               }else{
                   System.out.println("添加失败"); 
               }
                break;
            case 5:
                QuestionInfoDao qd2 = new QuestionInfoDaoImpl();
                QuestionInfo qi2 = new QuestionInfo();
                System.out.println("请输入要删除的编号:");
                if(input.nextInt()!=qi2.getQuestionId()){
                  System.out.println("对不起，没有要删除的编号");  
                }else{
                qd2.deleteInfo(input.nextInt());
                int f = qd2.deleteInfo(input.nextInt());
                if(f>0){
                    System.out.println("删除成功!");
                }else{
                    System.out.println("删除失败！");
                }}
                break;
            case 6:
                System.out.println("退出成功");
                aa=false;
                break;
        }
        }

    }
    
    public static void Allinfo(){
        QuestionInfoDao qd = new QuestionInfoDaoImpl();
        List<QuestionInfo> list = qd.getAll();
        for (QuestionInfo q : list) {
            System.out.println(q.getQuestionId()+q.getQuestion()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionC()+"\n"+"\t"+q.getOptionD()+"\n"+"\t"+q.getAnswer());
        }
    }
    
    public static void Allinfo1(){
        QuestionInfoDao qd1 = new QuestionInfoDaoImpl();
        List<QuestionInfo> list1 = qd1.getAll1();
        for (QuestionInfo q : list1) {
            System.out.println(q.getQuestionId()+q.getQuestion()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionC()+"\n"+"\t"+q.getOptionD()+"\n"+"\t"+q.getAnswer());
        }
    }
    
    public static void Allinfo2(){
        QuestionInfoDao qd2 = new QuestionInfoDaoImpl();
        List<QuestionInfo> list2 = qd2.getAll2();
        for (QuestionInfo q : list2) {
            System.out.println(q.getQuestionId()+q.getQuestion()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionC()+"\n"+"\t"+q.getOptionD()+"\n"+"\t"+q.getAnswer());
        }
    }
    
    public static void Allinfo3(){
        QuestionInfoDao qd3 = new QuestionInfoDaoImpl();
        List<QuestionInfo> list3 = qd3.getAll3();
        for (QuestionInfo q : list3) {
            System.out.println(q.getQuestionId()+q.getQuestion()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionC()+"\n"+"\t"+q.getOptionD()+"\n"+"\t"+q.getAnswer());
        }
    }
    
    public static void TG(String x){
        QuestionInfoDao qd4 = new QuestionInfoDaoImpl();
        List<QuestionInfo> list4 = qd4.getAllGJZ(x);
        for (QuestionInfo q : list4) {
            System.out.println(q.getQuestionId()+q.getQuestion()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionA()+"\n"+"\t"+q.getOptionC()+"\n"+"\t"+q.getOptionD()+"\n"+"\t"+q.getAnswer());
        }
    }
    

}

