/**
 * Project Name:xinwen
 * File Name:BizDao.java
 * Package Name:com.xin.dao
 * Date:2018年4月3日下午4:02:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.xin.dao;

import java.util.List;

import com.xin.entity.NewsInfo;
import com.xin.entity.UserInfo;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:02:42 <br/>
 * @author   DuSen
 * @version
 * @see
 */
public interface BizDao {
boolean denglu(UserInfo user);

List<NewsInfo> all();
}

