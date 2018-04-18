/**
 * Project Name:pinhong
 * File Name:PageDemoServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月13日下午3:58:10
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
import javax.servlet.http.HttpSession;

import com.java.entity.PageDemo;
import com.java.entity.Product;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午3:58:10 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/PageDemoServlet")
public class PageDemoServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String currpage = request.getParameter("currpage");
        // 分页
        PageDemo pageDemo = new PageDemo();
        // 当前页面

        pageDemo.setCurrPage(Integer.parseInt(currpage));
        // 数据总数
        int count = indexService.selectCount();
        pageDemo.setCountNumber(count);
        // 总页数
        if (count % pageDemo.getPageNumber() == 0) {
            pageDemo.setCountPage(count / pageDemo.getPageNumber());
        } else {
            pageDemo.setCountPage((count / pageDemo.getPageNumber()) + 1);
        }
        // 起始数据
        pageDemo.setStartNumber((Integer.parseInt(currpage) - 1) * pageDemo.getPageNumber());
        List<Product> listPageProduct = indexService.selectPageInfo(pageDemo);
        session.setAttribute("listPageProduct", listPageProduct);
        session.setAttribute("pageDemo", pageDemo);
        request.getRequestDispatcher("/Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
