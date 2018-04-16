/**
 * Project Name:Demo_dt59_pinhong
 * File Name:LeWord.java
 * Package Name:com.servlet
 * Date:2018-4-16下午9:34:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.BizDaoImpl;
import com.entity.LeaveWord;
import com.entity.Reply;
import com.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-16 下午9:34:58 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class LeWord extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public LeWord() {
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
       String mid= request.getParameter("id");
       BizDaoImpl bdi=new BizDaoImpl();
       BizServiceImpl bsi=new BizServiceImpl();
       bsi.setBizDao(bdi);
       LeaveWord lw=new LeaveWord();
       lw.setMid(Integer.parseInt(mid));
       List<LeaveWord> list= bsi.getWord(lw);
       List<Reply> listReplies= bsi.getReplies(lw);
       HttpSession session= request.getSession();
       session.setAttribute("list", list);
       session.setAttribute("listReplies", listReplies);
       request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
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

