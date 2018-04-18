/**
 * Project Name:pinhong
 * File Name:MessageBoard.java
 * Package Name:com.java.servlet
 * Date:2018年4月16日下午2:41:38
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

import com.java.entity.Message;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午2:41:38 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Message> listMessage = indexService.selectMessage();
        HttpSession session = request.getSession(false);
        session.setAttribute("listMessage", listMessage);
        request.getRequestDispatcher("/Jsp_Proscenium/S_MessageBoard.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
