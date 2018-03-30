/**
 * Project Name:dt59_dao_02
 * File Name:Test.java
 * Package Name:com.test
 * Date:2018年3月30日下午7:28:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test;

import java.util.List;
import java.util.Scanner;

import com.dao.QuestionInfoDaoImpl;
import com.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午7:28:48 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("******************欢迎使用试题管理系统********************");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("请选择操作（1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统）");
            int id = input.nextInt();
            QuestionInfoDaoImpl qimp = new QuestionInfoDaoImpl();
            switch (id) {
            case 1: {
                // 列出所有试题信息：
                List<QuestionInfo> list = qimp.getInfo();
                qimp.print(list);
                break;
            }
            case 2: {
                // 按科目查询：
                System.out.print("请输入要查的科目：(1.Java 2.C# 3.JSP):");
                int subject = input.nextInt();
                List<QuestionInfo> list1 = qimp.querySub(subject);
                qimp.print(list1);
                break;
            }
            case 3: {
                // 按题干模糊查询：
                System.out.print("请输入题干:");
                String question = input.next();
                question = "%" + question + "%";
                List<QuestionInfo> list2 = qimp.queryLike(question);
                qimp.print(list2);
                break;
            }
            case 4: {
                // 添加试题：
                System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
                int subject = input.nextInt();
                System.out.print("请输入新的题干：");
                String ques = input.next();
                System.out.print("请输入新的选项A：");
                String oa = input.next();
                System.out.print("请输入新的选项B：");
                String ob = input.next();
                System.out.print("请输入新的选项C：");
                String oc = input.next();
                System.out.print("请输入新的选项D：");
                String od = input.next();
                System.out.print("请输入新的答案：");
                String ans = input.next();
                QuestionInfo qi = new QuestionInfo();
                qi.setSubject(subject);
                qi.setQuestion(ques);
                qi.setOptionA(oa);
                qi.setOptionB(ob);
                qi.setOptionC(oc);
                qi.setOptionD(od);
                qi.setAnswer(ans);
                qimp.add(qi);
                break;
            }
            case 5: {
                // 删除
                System.out.print("请输入需要删除的试题编号：");
                int queNo = input.nextInt();
                int flag = qimp.del(queNo);
                if (flag > 0) {
                    System.out.println("删除成功！");
                } else {
                    System.out.println("对不起，没有要删除的编号，请重新输入：");
                }
                break;
            }
            }
            if (id == 6) {
                break;
            }

        }
        input.close();
    }
}
