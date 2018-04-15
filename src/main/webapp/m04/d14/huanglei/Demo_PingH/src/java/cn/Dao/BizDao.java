/**
 * Project Name:Demo_PingH
 * File Name:BizDao.java
 * Package Name:java.cn.Dao
 * Date:2018年4月12日下午6:59:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package java.cn.Dao;

import java.cn.entity.News;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午6:59:41 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();
}

