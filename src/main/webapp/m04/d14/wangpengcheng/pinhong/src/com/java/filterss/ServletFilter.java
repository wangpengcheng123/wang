/**
 * Project Name:contextDemo
 * File Name:ServletFilter.java
 * Package Name:com.java.filterss
 * Date:2018年4月2日下午2:00:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.filterss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description: <br/>
 * Date: 2018年4月2日 下午2:00:21 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class ServletFilter implements Filter {

    @Override
    public void destroy() {

        // Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request2 = (HttpServletRequest) request;
        HttpServletResponse response2 = (HttpServletResponse) response;
        String userName = null;
        String passWord = null;
        HttpSession session = request2.getSession();
        // 从浏览器中获取cookie
        Cookie[] cookies = request2.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cookie_name".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    // System.out.println(userName);

                }
                if ("cookie_pass".equals(cookie.getName())) {
                    passWord = cookie.getValue();
                    // System.out.println(userName);
                }
            }

        }
        System.out.println(userName + "\t" + passWord);
        // 当浏览器中存在cookie_name和cookie_pass时说明已经登录过了，并且勾选了自动登录按钮
        if (userName != null && passWord != null) {
            session.setAttribute("userName", userName);
            session.setAttribute("passWord", passWord);

        }

        // 登陆成功时会向session中存入一个userName(拦截没有登录过的)
        if ((session.getAttribute("userName")) == null) {
            // 如果没有登陆时就会直接跳转到登陆页面
            response2.sendRedirect("/contextDemo/pages/front/denglu.jsp");
        }
        // 放行
        chain.doFilter(request2, response2);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

        // Auto-generated method stub

    }

}
