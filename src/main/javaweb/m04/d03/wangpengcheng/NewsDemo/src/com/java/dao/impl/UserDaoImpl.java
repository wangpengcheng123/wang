/**
 * Project Name:NewsDemo
 * File Name:UserDaoImpl.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月3日下午4:06:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.java.dao.UserDao;
import com.java.entity.UserInfo;
import com.java.utils.C3P0Utils;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:06:38 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class UserDaoImpl implements UserDao<UserInfo> {
    // 查询出所有的用户名和密码并返回
    @Override
    public List<UserInfo> userSelete() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT user_id AS userId,username AS userName,PASSWORD AS `passWord` FROM user_info;";
        List<UserInfo> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

}
