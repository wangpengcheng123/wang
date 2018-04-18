/**
 * Project Name:pinhong
 * File Name:JumpServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月17日下午5:15:01
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

/**
 * Description: <br/>
 * Date: 2018年4月17日 下午5:15:01 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/JumpServlet")
public class JumpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String replay = request.getParameter("replay");
        if (replay != null) {
            session.setAttribute("replay", "replay");
        }

        response.sendRedirect("/pinhong/Jsp_Proscenium/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
