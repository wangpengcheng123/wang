/**
 * Project Name:ShoppingProjectDemo
 * File Name:TestServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月23日上午11:04:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: <br/>
 * Date: 2018年4月23日 上午11:04:43 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/ajax")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String index = request.getParameter("index");
        System.out.println(index);
        String upwd = request.getParameter("upwd");
        PrintWriter out = response.getWriter();// 流：不是用来输出html js，给ajax作返回用的！
        if ("0".equals(index)) {
            if (uname.trim().equals("")) {
                out.print("用户名不允许为空！");
            }
        } else if ("1".equals(index)) {
            if (upwd.trim().equals("")) {
                out.print("密码不允许为空！");
            }
        }
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
