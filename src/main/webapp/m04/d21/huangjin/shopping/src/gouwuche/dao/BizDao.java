/**
 * Project Name:GouWuChe
 * File Name:BizDao.java
 * Package Name:gouwuche.dao
 * Date:2018年4月19日上午11:59:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package gouwuche.dao;

import gouwuche.entity.BuyList;
import gouwuche.entity.Products;
import gouwuche.entity.User;

import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 上午11:59:23 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface BizDao {
    //获取所有产品信息
    List<Products> getAllProducts();
    //验证用户名和密码
    boolean validate(User user);
    //通过id获取相应的Products对象
    Products getProById(int id);
    int addBuyList(BuyList bl);
}

