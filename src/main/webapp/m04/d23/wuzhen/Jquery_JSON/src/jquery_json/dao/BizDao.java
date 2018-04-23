/**
 * Project Name:GouWuChe
 * File Name:BizDao.java
 * Package Name:gouwuche.dao
 * Date:2018年4月19日上午11:59:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jquery_json.dao;



import java.util.List;

import jquery_json.entity.City;
import jquery_json.entity.Province;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 上午11:59:23 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface BizDao {
    //获取所有产品信息
    public List<City> getCity(int pid);
    public List<Province> getAllProvince();
}

