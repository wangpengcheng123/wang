/**
 * Project Name:NewsDemo
 * File Name:UpdateNewsServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月7日下午6:53:22
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
 * Date: 2018年4月7日 下午6:53:22 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
    private NewsService<NewsDemo> newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDemo newsDemo = new NewsDemo();
        String newsId = request.getParameter("newsId");
        String title = request.getParameter("ntitle");
        System.out.println(title);
        String author = request.getParameter("nauthor");
        System.out.println(author);
        String summary = request.getParameter("nsummary");
        String content = request.getParameter("ncontent");
        String ntid = request.getParameter("ntid");
        newsDemo.setNews_id(Integer.parseInt(newsId));
        newsDemo.setNews_title(title);
        newsDemo.setNews_author(author);
        newsDemo.setNews_summary(summary);
        newsDemo.setNews_content(content);
        newsDemo.setType_id(Integer.parseInt(ntid));
        boolean flag = newsService.updateNewsDemo(newsDemo);
        PageDemo pageDemo = new PageDemo();
        // 当前页
        pageDemo.setCurrpage(1);
        int count = newsService.selectCount();
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
        List<NewsDemo> listNews = newsService.selectNewPage(pageDemo);

        // request.setAttribute("listNews", listNews);
        request.getSession().setAttribute("listNews", listNews);
        request.setAttribute("pageDemo", pageDemo);

        if (flag) {
            // request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request,
            // response);
            response.sendRedirect("/NewsDemo/pages/admin/admin.jsp");

        } else {
            response.sendRedirect("/NewsDemo/pages/admin/news_modify.jsp?title=" + title + "&author=" + author
                    + "&summary=" + summary + "&content=" + content + "&newsId=" + newsId + "");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
