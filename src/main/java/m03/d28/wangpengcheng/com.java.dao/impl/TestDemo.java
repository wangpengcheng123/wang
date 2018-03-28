/**
 * Project Name:ClassTest
 * File Name:TestDemo.java
 * Package Name:com.java.dao.impl
 * Date:2018年3月28日下午4:56:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.util.List;
import java.util.Scanner;

import com.java.dao.QuestionInfoDao;
import com.java.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:56:29 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class TestDemo {
    private static QuestionInfoDao<QuestionInfo> qq = new QuestionInfoDaoImpl();

    public static void seleteTest1(List<QuestionInfo> list) {

        for (QuestionInfo questionInfo : list) {
            System.out.println(questionInfo.getQuestionId() + "、" + questionInfo.getQuestion());
            System.out.println("\t" + "选项A:" + questionInfo.getOptionA());
            System.out.println("\t" + "选项B:" + questionInfo.getOptionB());
            System.out.println("\t" + "选项C:" + questionInfo.getOptionC());
            System.out.println("\t" + "选项D:" + questionInfo.getOptionD());
            System.out.println("\t" + "答案:" + questionInfo.getAnswer());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("************欢迎使用试题管理系统***************");
            System.out.println("请选择操作:");
            System.out.println("\t" + "1.列出所有试题");
            System.out.println("\t" + "2.按科目查询");
            System.out.println("\t" + "3.按照题干模糊查询");
            System.out.println("\t" + "4.添加试题");
            System.out.println("\t" + "5.删除试题");
            System.out.println("\t" + "6.退出系统");
            System.out.println("请选择:");
            int index = scanner.nextInt();
            if (index == 1) {
                List<QuestionInfo> list = qq.seleteDemo1();
                seleteTest1(list);
            } else if (index == 2) {
                System.out.println("请输入科目：(1.Java,2.C#,3.Jsp)");
                int subject = scanner.nextInt();
                List<QuestionInfo> list = qq.seleteDemo3(subject);
                seleteTest1(list);

            } else if (index == 3) {
                System.out.print("请输入题干:");
                String name = scanner.next();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("%");
                stringBuffer.append(name);
                stringBuffer.append("%");
                List<QuestionInfo> list = qq.seleteDemo2(stringBuffer.toString());
                seleteTest1(list);
            } else if (index == 4) {
                QuestionInfo questionInfo = new QuestionInfo();
                System.out.print("请输入科目：(1.Java,2.C#,3.Jsp)");
                questionInfo.setSubject(scanner.nextInt());
                System.out.print("请输入新的题干:");
                questionInfo.setQuestion(scanner.next());
                System.out.print("请输入新的选项A:");
                questionInfo.setOptionA(scanner.next());
                System.out.print("请输入新的选项B:");
                questionInfo.setOptionB(scanner.next());

                System.out.print("请输入新的选项C:");
                questionInfo.setOptionC(scanner.next());

                System.out.print("请输入新的选项D:");
                questionInfo.setOptionD(scanner.next());
                System.out.println("请输入新的答案:");
                questionInfo.setAnswer(scanner.next());
                int num = qq.insertDemo(questionInfo);
                if (num >= 1) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }

            } else if (index == 5) {
                while (true) {
                    System.out.println("请输入需要删除的编号:");
                    int num = qq.deleteDemo(scanner.nextInt());
                    if (num >= 1) {
                        System.out.println("删除成功");
                        break;
                    } else {
                        System.out.println("对不起，没有要删除的编号！请重新输入");
                    }
                }
            } else if (index == 6) {
                System.out.println("再见");
                break;
            } else {
                System.out.println("请输入正确的数字");
            }

        }
        scanner.close();

    }
}