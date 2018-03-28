/**
 * Project Name:dt59_dao
 * File Name:Test.java
 * Package Name:com.java
 * Date:2018年3月28日下午2:45:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.ceshi;

import java.util.List;
import java.util.Scanner;

import com.dao.QuestionInfoDao;
import com.entity.QuestionInfo;
import com.entity.QuestionInfoDaoImpl;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午2:45:42 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        // 向上转型
        QuestionInfoDao questioninfodao = new QuestionInfoDaoImpl();

        System.out.println("******************欢迎使用试题管理系统*******************");
        System.out.print("请选择操作(1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统)：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
        case 1:
            List<QuestionInfo> list = questioninfodao.getAllInfo();
            for (QuestionInfo qi : list) {
                System.out.println(qi.getQuestionID() + qi.getQuestion() + "\n" + "选项A:" + qi.getOptionA() + "\n"
                        + "选项B:" + qi.getOptionB() + "\n" + "选项C:" + qi.getOptionC() + "\n" + "选项D:" + qi.getOptionD()
                        + "\n" + "答案：" + qi.getAnswer());
            }
            break;
        case 5:
            System.out.print("请输入要删除的试题编号：");
            int questionID = sc.nextInt();
            int flag = questioninfodao.deleteInfo(questionID);
            System.out.println("删除的结果为：" + flag);
            System.out.println("删除成功");
            // List<QuestionInfo> list2 = questioninfodao.getAllInfo();
            // for (QuestionInfo qi : list2) {
            // System.out.println(qi.getQuestionID() + qi.getQuestion() + "\n" +
            // "选项A:" + qi.getOptionA() + "\n"
            // + "选项B:" + qi.getOptionB() + "\n" + "选项C:" + qi.getOptionC() +
            // "\n" + "选项D:" + qi.getOptionD()
            // + "\n" + "答案：" + qi.getAnswer());
            // }
            break;
        }
    }
}
