/**
 * Project Name:pinhong
 * File Name:LoginServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月13日下午1:33:20
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

import com.java.entity.User;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午1:33:20 <br/>
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
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        List<User> listUser = indexService.selectUser(username, password);
        List<User> listUserAll = indexService.selectUserAll();
        HttpSession session = request.getSession();
        if (listUser.size() != 0 && listUser != null) {
            String ustatus = null;
            for (User user : listUser) {
                if (user.getUname().equals(username) && user.getUpwd().equals(password)) {
                    ustatus = user.getUstatus();
                    break;

                }
            }

            session.setAttribute("ustatus", ustatus);
            session.setAttribute("username", username);
            request.setAttribute("listUser", listUser);
            request.setAttribute("listUserAll", listUserAll);
            if (session.getAttribute("replay") == null) {
                request.getRequestDispatcher("/admin/index.jsp").forward(request, response);

            } else {
                // 当存在时调到评论页面的servlet中
                request.getRequestDispatcher("/servlet/MessageBoardServlet").forward(request, response);
            }
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("error", "错误");
            request.getRequestDispatcher("/Jsp_Proscenium/Login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
