/**
 * Project Name:pinhong
 * File Name:InsertMessage.java
 * Package Name:com.java.servlet
 * Date:2018年4月16日下午3:33:58
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
import com.java.entity.Revert;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午3:33:58 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mid = request.getParameter("mid");
        List<Message> listMessageMid = indexService.selectMessageMid(Integer.parseInt(mid));
        for (Message message : listMessageMid) {
            System.out.println(message.getMcontent());
        }
        List<Revert> listRevertMid = indexService.selectRevertMid(Integer.parseInt(mid));
        for (Revert revert : listRevertMid) {
            System.out.println(revert.getRcontent());
        }
        HttpSession session = request.getSession(false);
        session.setAttribute("listMessageMid", listMessageMid);
        session.setAttribute("listRevertMid", listRevertMid);
        request.getRequestDispatcher("/Jsp_Proscenium/R_MessageBoard.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
