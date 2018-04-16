/**
 * Project Name:pinhong
 * File Name:InsertRevertServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月16日下午4:34:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.entity.Revert;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午4:34:25 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/InsertRevertServlet")
public class InsertRevertServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mid = request.getParameter("messageid");
        String rname = request.getParameter("name");
        String rcontent = request.getParameter("content");
        System.out.println(rname);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rdate = simpleDateFormat.format(new Date());
        Revert revert = new Revert();
        revert.setMid(Integer.parseInt(mid));
        revert.setRname(rname);
        revert.setRcontent(rcontent);
        revert.setRdate(rdate);
        boolean flag = indexService.insertRevert(revert, Integer.parseInt(mid));
        HttpSession session = request.getSession(false);
        if (flag) {
            request.getRequestDispatcher("/servlet/MessageBoardServlet").forward(request, response);
        } else {
            response.sendRedirect("/pinhong/Jsp_Proscenium/Suberror.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
