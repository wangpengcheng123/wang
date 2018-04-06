/**
 * Project Name:huangjin
 * File Name:BizDao.java
 * Package Name:news
 * Date:2018年4月6日下午6:31:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午6:31:45 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public interface BizDao {
    boolean yanzheng(UserInfo ui);

    List<NewsInfo> addTitle();
}
