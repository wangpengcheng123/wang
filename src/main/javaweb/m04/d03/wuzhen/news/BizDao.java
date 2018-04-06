/**
 * Project Name:News
 * File Name:BizDao.java
 * Package Name:news
 * Date:2018年4月3日下午5:54:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午5:54:43 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public interface BizDao {

    boolean yanzheng(UserInfo ui);
    List<NewsInfo> addTitle();
}

