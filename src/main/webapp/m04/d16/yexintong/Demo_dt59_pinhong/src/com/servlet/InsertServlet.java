/**
 * Project Name:Demo_dt59_pinhong
 * File Name:InsertServlet.java
 * Package Name:com.servlet
 * Date:2018-4-16下午10:39:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.BizDaoImpl;
import com.entity.Reply;
import com.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-16 下午10:39:15 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class InsertServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public InsertServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BizDaoImpl bdi=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi);
        String name= request.getParameter("messageid");
        String content= request.getParameter("content");
        Reply reply=new Reply();
        reply.setRname(name);
        reply.setRcontent(content);
        boolean flag=bsi.updateReply(reply);
        PrintWriter out= response.getWriter();
        if(flag){
            request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
        }else{
            out.print("<script>");
            out.print("alert('添加失败！！！');");
            out.print("location.href='Jsp_Proscenium/Login.jsp';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}

