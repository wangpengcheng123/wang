package com.dt59.java;

import java.util.List;
import java.util.Scanner;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.QuestionInfo;

public class Test {

    /**
     * 显示试题信息管理系统主菜单，如图-1所示，包括：
        1)列出所有试题信息
        2)按科目查询
        3)按题干模糊查询
        4)添加试题
        5)删除试题
        6)退出系统

     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.init();
	}
	Scanner sc=new Scanner(System.in);
	public void init(){
	    System.out.println("=======================试题信息管理系统主菜单=======================");
        System.out.println("\t1)列出所有试题信息  2)按科目查询  3)按题干模糊查询 4)添加试题  5)删除试题  6)退出系统");
        System.out.println("请选择:");
        int flag=sc.nextInt();
		
		
				switch(flag){
					case 1:
						show();
						init();
						break;
					case 2:
						searchSubject();
						init();
						break;
					case 3:
						searchByTg();
						init();
						break;
					case 4:
						addQuestionInfo();
						init();
						break;
					case 5:
						deleteById();
						init();
						break;
					case 6:
						bizdao.exitQuestion();
						break;
				}
			}
			
		
		
		
	
	BizDao bizdao=new BizDaoImpl();//向上转型
	/**
	 *  列出所有试题信息
	 * */
	public void show(){
		List<QuestionInfo> listinfo= bizdao.getAllQuestionInfo();
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	/**
     * 按科目查询
     * */
	public void searchSubject(){
	    System.out.println("======================按科目查询======================");
        System.out.println("请输入科目编号:");
		int subject=sc.nextInt();
		List<QuestionInfo> listinfo=bizdao.getQuestionInfoByKm(subject);
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	
	public void searchByTg(){
	    System.out.println("======================按题干模糊查询======================");
        System.out.println("请输入题干:");
		String str=sc.next();
		List<QuestionInfo> listinfo=bizdao.getQuestionInfoByTg(str);
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	
	public void addQuestionInfo(){
	    QuestionInfo qinfo=new QuestionInfo();
        System.out.println("============================添加题目=============================");
        System.out.println("请输入题干：");
        qinfo.setQuestion(sc.next());
        System.out.println("请输入A答案:");
        qinfo.setOptionA(sc.next());
        System.out.println("请输入B答案:");
        qinfo.setOptionB(sc.next());
        System.out.println("请输入C答案:");
        qinfo.setOptionC(sc.next());
        System.out.println("请输入D答案:");
        qinfo.setOptionD(sc.next());
        System.out.println("请输入科目编号：");
        qinfo.setSubject(sc.nextInt());
        System.out.println("请输入正确答案:");
        qinfo.setAnswer(sc.next());
        int flag= bizdao.saveQuestionInfo(qinfo);
        if(flag>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("祝贺你，添加失败！");
        }
	}
	
	public void deleteById(){
        System.out.println("============================删除=============================");
        System.out.println("请输入要删除编号：");
        int id=sc.nextInt();
        int flag=bizdao.deleteQuestionInfoById(id);
        if(flag>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("祝贺你，删除失败！");
        }
    }
}
