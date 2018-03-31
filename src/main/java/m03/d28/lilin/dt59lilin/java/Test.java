/**
 * Project Name:WE_XXGLXX
 * File Name:Test.java
 * Package Name:com.dt59lilin.java
 * Date:2018��3��28������4:09:05
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
 * Date:     2018��3��28�� ����4:09:05 <br/>
 * @author   11324
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean aa = true;
        while(aa){
        System.out.println("**************************��ӭʹ���������ϵͳ************************************\n");
        System.out.println("��ѡ�����(1.�г�����������Ϣ   2.����Ŀ��ѯ    3.�����ģ����ѯ    4.�������    5.ɾ������    6.�˳�ϵͳ):");
        int a = input.nextInt();
        switch(a){
            case 1:
                Allinfo();
                break;
            case 2:
                System.out.println("�����Ŀ(1.Java 2.C# 3.JSP)");
                int b = input.nextInt();
                if(b==1){
                Allinfo1();}
                if(b==2){
                    Allinfo2();}
                if(b==3){
                    Allinfo3();}
                break;
            case 3:
                System.out.println("���������:");
                TG(input.next());
                break;
            case 4:
                QuestionInfoDao qd = new QuestionInfoDaoImpl();
                QuestionInfo qi = new QuestionInfo();
                System.out.println("�������µ����:");
                qi.setQuestion(input.next());
                System.out.println("�������µ�ѡ��A:");
                qi.setOptionA(input.next());
                System.out.println("�������µ�ѡ��B:");
                qi.setOptionB(input.next());
                System.out.println("�������µ�ѡ��C:");
                qi.setOptionC(input.next());
                System.out.println("�������µ�ѡ��D:");
                qi.setOptionD(input.next());
                System.out.println("��������Ŀ���:");
                qi.setSubject(input.nextInt());
                System.out.println("�������µĴ�:");
                qi.setAnswer(input.next());
                int flag = qd.saveInfo(qi);
               if(flag==0){
                   System.out.println("��ӳɹ�");
               }else{
                   System.out.println("���ʧ��"); 
               }
                break;
            case 5:
                QuestionInfoDao qd2 = new QuestionInfoDaoImpl();
                QuestionInfo qi2 = new QuestionInfo();
                System.out.println("������Ҫɾ���ı��:");
                if(input.nextInt()!=qi2.getQuestionId()){
                  System.out.println("�Բ���û��Ҫɾ���ı��");  
                }else{
                qd2.deleteInfo(input.nextInt());
                int f = qd2.deleteInfo(input.nextInt());
                if(f>0){
                    System.out.println("ɾ���ɹ�!");
                }else{
                    System.out.println("ɾ��ʧ�ܣ�");
                }}
                break;
            case 6:
                System.out.println("�˳��ɹ�");
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

