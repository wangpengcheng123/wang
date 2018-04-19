/**
 * Project Name:ShoppingProjectDemo
 * File Name:LoginServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月19日下午1:37:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午1:37:29 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = indexService.selectUserCount(username, password);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60);
        if (flag) {
            session.setAttribute("username", username);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("info", "1");
            response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));

        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("info", "0");
            response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
