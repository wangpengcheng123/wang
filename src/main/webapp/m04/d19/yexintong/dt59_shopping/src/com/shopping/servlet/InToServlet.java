/**
 * Project Name:dt59_shopping
 * File Name:InToServlet.java
 * Package Name:com.shopping.servlet
 * Date:2018-4-20上午10:17:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:   <br/>
 * Date:     2018-4-20 上午10:17:03 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class InToServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public InToServlet() {
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
        String pid= request.getParameter("pid");
        String key= request.getParameter("key");
        int number=0;
        if(pid.equals(key)){
            number+=1;
        }       
        request.setAttribute("number", number);
        request.getRequestDispatcher("shopping/gouwuche.jsp").forward(request, response);
    }

    public void init() throws ServletException {
        // Put your code here
    }

}

