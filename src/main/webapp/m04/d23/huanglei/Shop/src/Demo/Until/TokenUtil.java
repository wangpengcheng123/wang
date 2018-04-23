/**
 * Project Name:Shop
 * File Name:TokenUtil.java
 * Package Name:Demo.Until
 * Date:2018年4月21日下午4:09:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Demo.Until;

import java.util.UUID;

/**
 * Description:   <br/>
 * Date:     2018年4月21日 下午4:09:24 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class TokenUtil {
     private TokenUtil(){};//构造方法私有化
    static TokenUtil tu=null;//对象
     public static TokenUtil getInstance(){   //公有方法
        if(tu==null){
            tu=new TokenUtil();
        }
         return tu;
      }
    public synchronized String uuidchangjian(){  //创建令牌，保障多个访问时，方法安全
       
        return  UUID.randomUUID().toString();   
        
    }
     
}

