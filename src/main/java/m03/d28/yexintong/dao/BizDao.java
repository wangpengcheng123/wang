/**
 * Project Name:wang
 * File Name:BizDao.java
 * Package Name:m03.d28.yexintong.dao
 * Date:2018年3月28日下午4:05:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.yexintong.dao;

import java.util.List;

import m03.d28.yexintong.cangku.Info;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:05:25 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public interface BizDao<T>{
    List<Info> getAllInfo(String string);
    int deleteInfo(int id);
    int updateInfo(T t);
}

