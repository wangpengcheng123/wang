/**
 * Project Name:NewsDemo
 * File Name:LoginServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月3日下午4:13:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.NewsDemo;
import com.java.entity.PageDemo;
import com.java.entity.UserInfo;
import com.java.service.NewsService;
import com.java.service.UserService;
import com.java.service.impl.NewsServiceImpl;
import com.java.service.impl.UserSeleteImpl;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:13:39 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService<UserInfo> user = new UserSeleteImpl();

    private NewsService<NewsDemo> ns = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        List<UserInfo> list = user.UserSeleteDemo();
        boolean flag = false;
        for (UserInfo userInfo : list) {
            if (userInfo.getUserName().equals(userName) && userInfo.getPassWord().equals(passWord)) {
                flag = true;
            }
        }
        PageDemo pageDemo = new PageDemo();
        // 当前页
        pageDemo.setCurrpage(1);
        int count = ns.selectCount();
        // 总个数
        pageDemo.setCountnumber(count);
        if (count % 3 == 0) {
            // 总页数
            pageDemo.setCountpage(count / 3);
        } else {
            pageDemo.setCountpage((count / 3) + 1);
        }
        // 起始值
        int start = (1 - 1) * pageDemo.getNumber();
        pageDemo.setStartpage(start);

        // 获取新闻的信息
        List<NewsDemo> listNews = ns.selectNewPage(pageDemo);

        if (flag) {
            request.setAttribute("listNews", listNews);
            request.setAttribute("pageDemo", pageDemo);
            request.getSession().setAttribute("userName", userName);
            request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request, response);
        } else {
            response.sendRedirect("/NewsDemo/pages/front/denglu.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
