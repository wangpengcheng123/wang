/**
 * Project Name:NewsDemo
 * File Name:UserSelete.java
 * Package Name:com.java
 * Date:2018年4月3日下午4:04:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:04:47 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.util.List;

public interface UserDao<T> {
    public List<T> userSelete();

}
