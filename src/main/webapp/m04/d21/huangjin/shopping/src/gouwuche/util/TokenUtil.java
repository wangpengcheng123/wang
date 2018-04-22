/**
 * Project Name:GouWuChe
 * File Name:TokenUtil.java
 * Package Name:gouwuche.util
 * Date:2018年4月22日下午1:17:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package gouwuche.util;

import java.util.UUID;

/**
 * Description:   <br/>
 * Date:     2018年4月22日 下午1:17:59 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class TokenUtil {
    private static TokenUtil token;
    private TokenUtil(){}
    public static TokenUtil getTokenUtil(){
        if(token==null){
            token=new TokenUtil();
        }
         return token;     
    }
    public synchronized String getToken(){
        return UUID.randomUUID().toString();
    }
}

