/**
 * Project Name:ShoppingProjectDemo
 * File Name:IndexService.java
 * Package Name:com.java.service
 * Date:2018年4月19日下午12:11:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.service;

import java.util.List;

import com.java.entity.ShangPing;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:11:03 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public interface IndexService {
    // 查询商品表中的所有信息
    public List<ShangPing> selectShangPingAll();

    // 查询用户表中的用户是否存在
    public boolean selectUserCount(String username, String password);

    // 通过用户名和密码查询id
    public int selectUserId(String username, String password);

    // 根据id查询商品的信息
    public ShangPing selectShangPing(int id);

    // 当map集合中不存在该用户时,或者存在该用户不存在该商品时
    public boolean insertShouCang(int uid, int spid, int number, float sumprice);

    // 当map集合中存在该用户，也存在该商品时
    public boolean updateShouCang(int number, float sumprice, int uid, int spid);
}
