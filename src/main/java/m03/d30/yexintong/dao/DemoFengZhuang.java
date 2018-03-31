/**
 * Project Name:wang
 * File Name:DemoFengZhuang.java
 * Package Name:m03.d28.yexintong.dao
 * Date:2018年3月28日下午5:22:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.yexintong.dao;

import java.util.List;

import m03.d30.yexintong.cangku.Info;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午5:22:13 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class DemoFengZhuang {
    public void chaxun(){
        BizDao bizDao=new BizDaoImpal();
        List<Info> list=bizDao.getAllInfo("SELECT * FROM question_info");
        for (Info ff : list) {
            System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
        }
    }
    public void tiaojianchaxun(int tiaojian){
        BizDao bizDao=new BizDaoImpal();
        List<Info> list=bizDao.getAllInfo("SELECT * FROM question_info");
        switch (tiaojian) {
        case 1:
            for (Info ff : list) {
                if(ff.getSubject()==1){
                System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
                }
            }
            break;
        case 2:
            for (Info ff : list) {
                if(ff.getSubject()==2){
                System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
                }
            }
            break;
        case 3:
            for (Info ff : list) {
                if(ff.getSubject()==3){
                System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
                }
            }
            break;
        }
    }
    public void mohuchaxun(String mohuwenzi){
        BizDao bizDao=new BizDaoImpal();
        List<Info> list=bizDao.getAllInfo("SELECT * FROM question_info WHERE question LIKE '%"+mohuwenzi+"%'");
        for (Info ff : list) {
            System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
        }
    }
    public void chaxun1(){
        BizDao bizDao=new BizDaoImpal();
        List<Info> list=bizDao.allInfo("CALL ups_text_01()");
        for (Info ff : list) {
            System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
        }
    }
    public void mohuchaxun1(String mohuwenzi){
        BizDao bizDao=new BizDaoImpal();
        List<Info> list=bizDao.allInfo("CALL ups_text_02('%"+mohuwenzi+"%')");
        for (Info ff : list) {
            System.out.println(ff.getQuestionId()+"."+ff.getQuetion()+"\nA:"+ff.getOptionA()+"\nB:"+ff.getOptionB()+"\nC:"+ff.getOptionC()+"\nD:"+ff.getOptionD()+"\n");
        }
    }
}

