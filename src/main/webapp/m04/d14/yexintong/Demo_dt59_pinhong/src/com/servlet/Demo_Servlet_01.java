/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Demo_Servlet_01.java
 * Package Name:com.servlet
 * Date:2018-4-12下午7:03:09
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
import com.entity.News;
import com.entity.Product;
import com.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-12 下午7:03:09 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Demo_Servlet_01 extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public Demo_Servlet_01() {
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
           List<News>listnews=bsi.getNewsAll();
           List<Product>listpros=bsi.getProAll();
           HttpSession session=request.getSession();
           session.setAttribute("listnews", listnews);
           session.setAttribute("listpros", listpros);
           request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
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

