/**
 * Project Name:Shopping
 * File Name:BizDao.java
 * Package Name:Demo.Dao.Impl
 * Date:2018年4月19日下午12:05:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Demo.Dao;

import java.util.List;

import Demo.entity.ShangPings;
import Demo.entity.User;
import Demo.entity.Goumais;
/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:05:12 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public interface BizDao {
     boolean Passresult(User user);//登录
     List<ShangPings> getAllshangping();
     ShangPings  getAddshangping(int spid);
      int Goumais(Goumais go);//G购买
}

