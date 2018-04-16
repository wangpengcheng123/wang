/**
 * Project Name:pinhong
 * File Name:IndexServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:2018年4月12日下午7:13:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.IndexDao;
import com.java.dao.impl.IndexDaoImpl;
import com.java.entity.Message;
import com.java.entity.News;
import com.java.entity.PageDemo;
import com.java.entity.Product;
import com.java.entity.Revert;
import com.java.entity.User;
import com.java.service.IndexService;
import com.java.utils.C3P0Utils;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:13:47 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class IndexServiceImpl implements IndexService {
    private IndexDao indexDao = new IndexDaoImpl();

    // 返回News表的数据集合
    @Override
    public List<News> selectNews() {

        // Auto-generated method stub
        return indexDao.selectNews();
    }

    // 返回Product表的数据集合
    @Override
    public List<Product> selectProduct() {

        // Auto-generated method stub
        return indexDao.selectProduct();
    }

    // 查询用户表中的用户名和密码
    @Override
    public List<User> selectUser(String username, String password) {

        return indexDao.selectUser(username, password);
    }

    // 查询用户表中的所有数据
    @Override
    public List<User> selectUserAll() {

        return indexDao.selectUserAll();
    }

    @Override
    public int selectCount() {

        return indexDao.selectCount();
    }

    @Override
    public List<Product> selectPageInfo(PageDemo pageDemo) {

        // Auto-generated method stub
        return indexDao.selectPageInfo(pageDemo);
    }

    @Override
    public List<Message> selectMessage() {

        // Auto-generated method stub
        return indexDao.selectMessage();
    }

    // 通过id查询留言的信息
    @Override
    public List<Message> selectMessageMid(int mid) {

        // Auto-generated method stub
        return indexDao.selectMessageMid(mid);
    }

    @Override
    public List<Revert> selectRevertMid(int mid) {

        // Auto-generated method stub
        return indexDao.selectRevertMid(mid);
    }

    @Override
    public boolean insertRevert(Revert revert, int mid) {
        boolean flag = true;
        try {
            C3P0Utils.startTransaction();
            int num1 = indexDao.insertRevert(revert);
            int num2 = indexDao.updateMessageCount(mid);
            if (num1 >= 1 && num2 >= 1) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            // 只要发生异常就回滚，让数据不进行更新
            flag = false;
            try {
                C3P0Utils.rollback();
            } catch (SQLException e1) {

                // Auto-generated catch block
                e1.printStackTrace();

            }

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                C3P0Utils.commit();
            } catch (SQLException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }
        return flag;
    }

}
