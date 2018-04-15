/**
 * Project Name:contextDemo
 * File Name:EncodingFilter.java
 * Package Name:com.java.filter
 * Date:2018年3月29日上午9:54:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.filterss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description: <br/>
 * Date: 2018年3月29日 上午9:54:18 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class EncodingFilter implements Filter {

    @Override
    public void destroy() {

        // Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 拦截request和response，给其设置编码
        ServletContext servletContext = request.getServletContext();
        String encoding = servletContext.getInitParameter("encoding");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding + "");
        // 放行
        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

        // Auto-generated method stub

    }

}
