/**
 * Project Name:NewsDemo
 * File Name:UserSeleteDemoImpl.java
 * Package Name:com.java.service.impl
 * Date:2018年4月3日下午4:11:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service.impl;

import java.util.List;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.entity.UserInfo;
import com.java.service.UserService;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:11:57 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class UserSeleteImpl implements UserService<UserInfo> {
    private UserDao<UserInfo> user = new UserDaoImpl();

    @Override
    public List<UserInfo> UserSeleteDemo() {

        // Auto-generated method stub
        return user.userSelete();
    }

}
