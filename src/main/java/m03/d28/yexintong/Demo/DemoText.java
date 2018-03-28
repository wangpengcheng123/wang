/**
 * Project Name:wang
 * File Name:DemoText.java
 * Package Name:m03.d28.yexintong.Demo
 * Date:2018年3月28日下午4:23:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.yexintong.Demo;

import java.util.Scanner;

import m03.d28.yexintong.cangku.Info;
import m03.d28.yexintong.dao.BizDao;
import m03.d28.yexintong.dao.BizDaoImpal;
import m03.d28.yexintong.dao.DemoFengZhuang;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:23:09 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class DemoText {
    public static void main(String[] args) {
        DemoFengZhuang dfz=new DemoFengZhuang();
        BizDao<Object> bz= new BizDaoImpal();           
        Scanner scanner=new Scanner(System.in);
        System.out.println("********************欢迎使用试题管理系统*********************");
        boolean gg=true;
        while (gg) {        
        System.out.println("请选择操作(1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统)");
        switch (scanner.nextInt()) {
        case 1:
            dfz.chaxun();
            break;
        case 2:
            System.out.println("请输入科目:(1.Java 2.C# 3.JSP)");
            switch (scanner.nextInt()) {
            case 1:
                dfz.tiaojianchaxun(1);
                break;
            case 2:
                dfz.tiaojianchaxun(2);
                break;
            case 3:
                dfz.tiaojianchaxun(3);
                break;
            }
            break;
        case 3:
            System.out.println("请输入题干:");
            dfz.mohuchaxun(scanner.next());
            break;
        case 4:
            Info info =new Info();
            System.out.println("请输入要添加的题目:");
            info.setQuetion(scanner.next());
            System.out.println("添加题目A选项答案");
            info.setOptionA(scanner.next());
            System.out.println("添加题目B选项答案");
            info.setOptionB(scanner.next());
            System.out.println("添加题目C选项答案");
            info.setOptionC(scanner.next());
            System.out.println("添加题目D选项答案");
            info.setOptionD(scanner.next());
            System.out.println("添加题目的类型");
            info.setSubject(scanner.nextInt());
            System.out.println("添加题目的答案");
            info.setAnswer(scanner.next());
            bz.updateInfo(info);
            break;
        case 5:
            System.out.println("请输入要删除题目的编号:");
            bz.deleteInfo(scanner.nextInt());
            break;
        default:
            gg=false;
            scanner.close();
            break;
        }
    }
    }
}

