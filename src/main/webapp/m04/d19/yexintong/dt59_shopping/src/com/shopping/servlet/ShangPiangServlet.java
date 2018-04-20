/**
 * Project Name:dt59_shopping
 * File Name:ShangPiangServlet.java
 * Package Name:com.shopping.servlet
 * Date:2018-4-19下午4:27:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.dao.impl.BaseDaoImpl;
import com.shopping.entity.Shangping;
import com.shopping.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-19 下午4:27:56 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class ShangPiangServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public ShangPiangServlet() {
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
           BaseDaoImpl bdi =new BaseDaoImpl();
           BizServiceImpl bsi=new BizServiceImpl();
           bsi.setBizDao(bdi);
           List<Shangping>shangpingall= bsi.getAllShangping();
//           System.out.println(shangpingall.size());
//           for(int i=0;i<shangpingall.size();i++){
//               System.out.println(shangpingall.get(i).getSpname());
//           }
           HttpSession session= request.getSession();
           session.setAttribute("shangpingall", shangpingall);
           request.getRequestDispatcher("shopping/shangping.jsp").forward(request, response);
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

