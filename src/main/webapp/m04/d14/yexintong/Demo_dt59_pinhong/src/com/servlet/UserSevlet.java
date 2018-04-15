/**
 * Project Name:Demo_dt59_pinhong
 * File Name:UserSevlet.java
 * Package Name:com.servlet
 * Date:2018-4-14下午1:24:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.BizDaoImpl;
import com.entity.LoGin;
import com.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-14 下午1:24:25 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class UserSevlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public UserSevlet() {
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
        request.setCharacterEncoding("utf-8");
        BizDaoImpl bdi =new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi); 
        List<LoGin> listUserLoGin= bsi.getAllUser();
        HttpSession session=request.getSession();
        session.setAttribute("listUserLoGin", listUserLoGin);
        request.getRequestDispatcher("admin/showUserList.jsp").forward(request, response);
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

