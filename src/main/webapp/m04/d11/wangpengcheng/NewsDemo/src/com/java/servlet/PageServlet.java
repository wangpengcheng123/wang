/**
 * Project Name:NewsDemo
 * File Name:PageServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月10日上午11:26:50
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
import com.java.service.NewsService;
import com.java.service.impl.NewsServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午11:26:50 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/PageServlet")
public class PageServlet extends HttpServlet {
    private NewsService<NewsDemo> ns = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PageDemo pageDemo = new PageDemo();
        String currpage = request.getParameter("currpage");
        // 当前页
        pageDemo.setCurrpage(Integer.parseInt(currpage));
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
        int start = (Integer.parseInt(currpage) - 1) * pageDemo.getNumber();
        pageDemo.setStartpage(start);

        // 获取新闻的信息
        List<NewsDemo> listNews = ns.selectNewPage(pageDemo);
        request.setAttribute("listNews", listNews);
        request.setAttribute("pageDemo", pageDemo);

        request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
