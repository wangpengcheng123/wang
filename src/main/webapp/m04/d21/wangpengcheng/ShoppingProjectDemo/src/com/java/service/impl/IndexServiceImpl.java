/**
 * Project Name:ShoppingProjectDemo
 * File Name:IndexServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:2018年4月19日下午12:11:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service.impl;

import java.util.List;

import com.java.dao.IndexDao;
import com.java.dao.impl.IndexDaoImpl;
import com.java.entity.ShangPing;
import com.java.service.IndexService;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:11:47 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class IndexServiceImpl implements IndexService {
    private IndexDao indexDao = new IndexDaoImpl();

    // 返回查询的所有商品
    @Override
    public List<ShangPing> selectShangPingAll() {

        // Auto-generated method stub
        return indexDao.selectShangPingAll();
    }

    @Override
    public boolean selectUserCount(String username, String password) {

        boolean flag = false;
        int num = indexDao.selectUserCount(username, password);
        if (num >= 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    // 通过用户名和密码查询id;
    @Override
    public int selectUserId(String username, String password) {

        return indexDao.selectUserId(username, password);
    }

    // 根据id查询该商品的详细信息
    @Override
    public ShangPing selectShangPing(int id) {

        return indexDao.selectShangPing(id);
    }

    // 当map集合中不存在该用户时,或者存在该用户不存在该商品时
    @Override
    public boolean insertShouCang(int uid, int spid, int number, float sumprice) {
        boolean flag = false;
        int num = indexDao.insertShouCang(uid, spid, number, sumprice);
        if (num >= 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateShouCang(int number, float sumprice, int uid, int spid) {
        boolean flag = false;
        int num = indexDao.updateShouCang(number, sumprice, uid, spid);
        if (num >= 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

}
