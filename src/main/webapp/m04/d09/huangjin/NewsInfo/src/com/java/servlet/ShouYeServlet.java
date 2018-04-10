/**
 * Project Name:NewsDemo
 * File Name:ShouYeServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月8日下午4:23:04
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

import org.json.JSONArray;

import com.java.entity.CommentInfo;
import com.java.service.NewsService;
import com.java.service.impl.NewsServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午4:23:04 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/ShouYeServlet")
public class ShouYeServlet extends HttpServlet {
    private NewsService news = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CommentInfo> list = news.selectCommentDemo();
        // request.setAttribute("listComment", list);
        // request.getRequestDispatcher("/pages/front/denglu.jsp").forward(request,
        // response);

        // 当jsonArray构建的是一个空的构造函数时，再用put()方法向里面添加一个集合时会形成集合中套集合
        // JSONArray jsonArray = new JSONArray();
        // jsonArray.put(list);

        JSONArray jsonArray = new JSONArray(list);
        // for (int i = 0; i < jsonArray.length(); i++) {
        // // System.out.println(jsonArray.get(i));
        // CommentInfo commentInfo = (CommentInfo) jsonArray.get(i);
        // System.out.println(commentInfo.getUsername());
        // }

        response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
