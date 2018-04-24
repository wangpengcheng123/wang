/**
 * Project Name:DemoPinHong
 * File Name:SetChar.java
 * Package Name:Demo.Util
 * Date:2018年4月16日下午7:29:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Lib.Util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:   <br/>
 * Date:     2018年4月16日 下午7:29:29 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class SetChar implements Filter{

    @Override
    public void destroy() {
        System.out.println("销毁");
        //  Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
         HttpServletRequest request=(HttpServletRequest)arg0;
         HttpServletResponse response=(HttpServletResponse)arg1;
        //  Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
        //  Auto-generated method stub
        System.out.println("过滤器初始化完成！");
    }

}

