/**
 * Project Name:wang
 * File Name:BizDaoImpal.java
 * Package Name:m03.d28.yexintong.dao
 * Date:2018年3月28日下午4:12:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.yexintong.dao;

import java.util.ArrayList;
import java.util.List;

import m03.d28.yexintong.cangku.Info;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:12:59 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class BizDaoImpal extends BaseDao implements BizDao<Object>{
    /*查询*/
    @Override
    public List<Info> getAllInfo(String string) {
        List<Info> list=new ArrayList<Info>(); 
        try {
            String sql=string;
            pst=getCon().prepareStatement(sql);
             rs=pst.executeQuery();
            while (rs.next()) {
                Info info=new Info();
                info.setQuestionId(rs.getInt(1));
                info.setQuetion(rs.getString(2));
                info.setOptionA(rs.getString(3));
                info.setOptionB(rs.getString(4));
                info.setOptionC(rs.getString(5));
                info.setOptionD(rs.getString(6));
                info.setSubject(rs.getInt(7));
                info.setAnswer(rs.getString(8));
                list.add(info);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con, pst, rs);
        }
        //  Auto-generated method stub
        return list;
    }

    @Override
    public int updateInfo(Object t) {
        int flag=0;
        try {
            String sql="INSERT INTO question_info (question,optionA,optionB,optionC,optionD,SUBJECT,answer) value(?,?,?,?,?,?,?)";
            Object[] obj=new Object[7];
            if(t instanceof Info){
            Info info=(Info)t;     
            obj[0]=info.getQuetion();
            obj[1]=info.getOptionA();
            obj[2]=info.getOptionB();
            obj[3]=info.getOptionC();
            obj[4]=info.getOptionD();
            obj[5]=info.getSubject();
            obj[6]=info.getAnswer();
            flag=controlDml(sql, obj);
            }
            } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  Auto-generated method stub
        return flag;
    }

    @Override
    public int deleteInfo(int id) {
        int flag=0;
        //  Auto-generated method stub
        try {
            String sql="DELETE FROM question_info WHERE questionId=?";
            Object[] obj=new Object[1];
            obj[0]=id;
            flag=controlDml(sql,obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Info> allInfo(String string) {
        List<Info> list=new ArrayList<Info>(); 
        //  Auto-generated method stub
        try {
            String sql=string;
            cste=getCon().prepareCall(sql);
            rs=cste.executeQuery();
            while(rs.next()){
                Info info=new Info();
                info.setQuestionId(rs.getInt(1));
                info.setQuetion(rs.getString(2));
                info.setOptionA(rs.getString(3));
                info.setOptionB(rs.getString(4));
                info.setOptionC(rs.getString(5));
                info.setOptionD(rs.getString(6));
                info.setSubject(rs.getInt(7));
                info.setAnswer(rs.getString(8));
                list.add(info);
            }            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
    
    /*添加*/
}

