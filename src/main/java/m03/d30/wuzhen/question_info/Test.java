/**
 * Project Name:wuzhen
 * File Name:Test.java
 * Package Name:question_info
 * Date:2018年3月28日下午4:01:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package question_info;

import java.util.List;
import java.util.Scanner;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:01:56 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Test {

  public static void main(String[] args) {
    System.out.println("******************欢迎使用试题管理系统********************");
    Scanner scan=new Scanner(System.in);
    while(true){System.out.println("请选择操作（1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统）");   
    int option=scan.nextInt();
    QuestionInfoDaoImpl qim=new QuestionInfoDaoImpl();
   switch (option) {
    case 1:{      
        //列出所有试题信息：
        List<QuestionInfo> list=qim.getInfo();
        qim.print(list);    
        break;
    }
    case 2:{
      //按科目查询：
        System.out.print("请输入要查的科目：(1.Java 2.C# 3.JSP):");
        int subject=scan.nextInt();
        List<QuestionInfo> list1=qim.querySub(subject);
        qim.print(list1);  
        break;
    }
    case 3:{
      //按题干查询：
        System.out.print("请输入题干:");
        String question=scan.next();
        question="%"+question+"%";
        List<QuestionInfo> list2=qim.queryQues(question);
        qim.print(list2);
        break;
    }
    case 4:{
        //添加试题：
        System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
        int subject=scan.nextInt();
        System.out.print("请输入新的题干：");
        String ques=scan.next();
        System.out.print("请输入新的选项A：");
        String oa=scan.next();
        System.out.print("请输入新的选项B：");
        String ob=scan.next();
        System.out.print("请输入新的选项C：");
        String oc=scan.next();
        System.out.print("请输入新的选项D："); 
        String od=scan.next();
        System.out.print("请输入新的答案：");
        String ans=scan.next();
        QuestionInfo qi=new QuestionInfo();
        qi.setSubject(subject);
        qi.setQuestion(ques);
        qi.setOptionA(oa);
        qi.setOptionB(ob);
        qi.setOptionC(oc);
        qi.setOptionD(od);
        qi.setAnswer(ans);
        qim.add(qi);    
        break;
    }
    case 5:{
        //删除
        System.out.print("请输入需要删除的试题编号：");
        int queNo=scan.nextInt();
        int flag=qim.del(queNo);
        if(flag>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("对不起，没有要删除的编号，请重新输入：");
        }
        break;
    }
   }
    if(option==6){
        break;
    }
 

    }
    scan.close();
}
}


