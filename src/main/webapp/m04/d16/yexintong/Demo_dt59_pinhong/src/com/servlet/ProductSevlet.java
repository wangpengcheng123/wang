/**
 * Project Name:Demo_dt59_pinhong
 * File Name:ProductSevlet.java
 * Package Name:com.servlet
 * Date:2018-4-14下午3:02:35
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
import javax.xml.ws.ServiceMode;

import com.dao.impl.BizDaoImpl;
import com.entity.Page;
import com.entity.Product;
import com.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-14 下午3:02:35 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class ProductSevlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public ProductSevlet() {
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
        
//       request.setCharacterEncoding("utf-8");
       BizDaoImpl bdi=new BizDaoImpl();
       BizServiceImpl bsi=new BizServiceImpl();
       bsi.setBizDao(bdi);
       int count=bsi.getProduct();
       Page pg=new Page();
       pg.setSumsize(count);
       pg.setLastpage(pg.getSumsize()%pg.getPagesize()==0?pg.getSumsize()/pg.getPagesize():pg.getSumsize()/pg.getPagesize()+1);
       pg.setCurrentpae(1);
       List<Product>listpro=bsi.getLimit(pg);
       HttpSession session= request.getSession(false);
       session.setAttribute("listpro",listpro );
       session.setAttribute("pg", pg);
       request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
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

