/**
 * Project Name:NewsDemo
 * File Name:NewsDao.java
 * Package Name:com.java.dao.impl
 * Date:2018年4月3日下午4:56:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:56:35 <br/>
 * @author   pengchengwang
 * @version
 * @see
 */

import java.util.List;

public interface NewsDao<T> {
    public List<T> selectNew();
}
