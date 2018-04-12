/**
 * Project Name:pinhong
 * File Name:IndexServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月12日下午7:16:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.entity.News;
import com.java.entity.Product;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:16:16 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/IndexServlet")
public class IndexServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<News> listNews = indexService.selectNews();
        // 格式化新闻表中的日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (News news : listNews) {
            String dd = news.getNdate();
            try {
                Date date = sdf.parse(dd);
                news.setNdate(sdf.format(date));

            } catch (ParseException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }

        }

        List<Product> listProduct = indexService.selectProduct();

        HttpSession session = request.getSession();
        session.setAttribute("listNews", listNews);
        session.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/Jsp_Proscenium/M_Index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
