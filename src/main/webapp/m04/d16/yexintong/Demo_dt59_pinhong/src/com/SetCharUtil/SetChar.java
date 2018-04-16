/**
0 * Project Name:Demo_dt59_pinhong
 * File Name:SetChar.java
 * Package Name:com.SetCharUtil
 * Date:2018-4-16下午4:32:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.SetCharUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:   <br/>
 * Date:     2018-4-16 下午4:32:39 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class SetChar implements Filter{

    public void destroy() {
        
        //  Auto-generated method stub
        System.out.println("我被销毁了！！！！");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        
        //  Auto-generated method stub
        HttpServletRequest reques=(HttpServletRequest)arg0;
        HttpServletResponse response=(HttpServletResponse)arg1;
        reques.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0, arg1);
    }

    public void init(FilterConfig arg0) throws ServletException {
        
        //  Auto-generated method stub
        System.out.println("过滤器初始化！！！！");
    }

}

