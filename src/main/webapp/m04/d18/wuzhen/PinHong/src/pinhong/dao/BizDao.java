/**
 * Project Name:PinHong
 * File Name:BizDao.java
 * Package Name:pinhong.dao
 * Date:2018年4月12日下午7:02:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.dao;

import java.util.List;

import pinhong.entity.Message;
import pinhong.entity.News;
import pinhong.entity.Page;
import pinhong.entity.Product;
import pinhong.entity.Revert;
import pinhong.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:02:39 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface BizDao {

    List<News> getAllNews();
    List<Product> getAllPro();
    List<User> getAllUser();
    int yanzheng(User user);
    int CountPros();
    List<Product> getPageInfo(Page page);
    List<Message> getAllMessage();
    List<Revert> getRevert(int id);
    int addReply(Revert r);
    int getRevertInfo(int id);
    public int modifyMessage(int rcount,int mid);
    
}

