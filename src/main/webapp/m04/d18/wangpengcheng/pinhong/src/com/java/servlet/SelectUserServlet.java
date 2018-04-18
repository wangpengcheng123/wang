/**
 * Project Name:pinhong
 * File Name:SelectUserServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月13日下午2:22:44
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

import com.java.entity.User;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午2:22:44 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> listUserAll = indexService.selectUserAll();
        for (User user : listUserAll) {
            System.out.println(user.getUname());
        }
        request.setAttribute("listUserAll", listUserAll);
        request.getRequestDispatcher("/admin/showUserList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

}
