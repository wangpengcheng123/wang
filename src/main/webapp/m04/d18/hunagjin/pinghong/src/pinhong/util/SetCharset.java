/**
 * Project Name:PinHong
 * File Name:Filter.java
 * Package Name:pinhong.util
 * Date:2018年4月16日下午2:00:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description:   <br/>
 * Date:     2018年4月16日 下午2:00:00 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class SetCharset implements Filter{

    @Override
    public void destroy() {
        
        //  Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        arg0.setCharacterEncoding("utf-8");
        arg1.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0,arg1);   
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
        //  Auto-generated method stub
        
    }

}

