/**
 * Project Name:MyBatis
 * File Name:GetSqlSession.java
 * Package Name:mybatis.util
 * Date:2018年5月14日下午12:20:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.catalina.tribes.membership.StaticMember;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Description:   <br/>
 * Date:     2018年5月14日 下午12:20:33 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class GetSqlSession {
    private static GetSqlSession gs=null;
    private SqlSessionFactory ssf=null;
    private GetSqlSession(){};
    public static GetSqlSession getInstance(){
        if(gs==null){
            gs=new GetSqlSession();
        }
        return gs;
    }
    public SqlSessionFactory getSqlSessionFactory(){
       
        if(ssf==null){         
            try {
                InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
                ssf=new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
           
        } 
        return ssf;
    }
}

