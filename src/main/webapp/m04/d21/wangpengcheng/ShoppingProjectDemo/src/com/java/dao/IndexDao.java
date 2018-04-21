/**
 * Project Name:ShoppingProjectDemo
 * File Name:IndexDao.java
 * Package Name:com.java.dao
 * Date:2018年4月19日下午12:04:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.dao;

import java.util.List;

import com.java.entity.ShangPing;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:04:20 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public interface IndexDao {
    // 查询商品表中的所有信息
    public List<ShangPing> selectShangPingAll();

    // 查询用户表中的用户是否存在
    public int selectUserCount(String username, String password);

    // 通过用户名和密码查询id
    public int selectUserId(String username, String password);

    // 根据id查询商品的信息
    public ShangPing selectShangPing(int id);

    // 当map集合中不存在该用户时,或者存在该用户不存在该商品时
    public int insertShouCang(int uid, int spid, int number, float sumprice);

    // 当map集合中存在该用户，也存在该商品时
    public int updateShouCang(int number, float sumprice, int uid, int spid);

}
