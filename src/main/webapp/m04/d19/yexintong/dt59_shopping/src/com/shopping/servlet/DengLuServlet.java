/**
 * Project Name:dt59_shopping
 * File Name:DengLuServlet.java
 * Package Name:com.shopping.servlet
 * Date:2018-4-19下午5:25:19
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.dao.impl.BaseDaoImpl;
import com.shopping.entity.UserDemo;
import com.shopping.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018-4-19 下午5:25:19 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class DengLuServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public DengLuServlet() {
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
        String name=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        BaseDaoImpl bdi =new BaseDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi);
        UserDemo ud=new UserDemo();
        ud.setUname(name);
        ud.setUpwd(pwd);
        boolean flag=bsi.getDenglu(ud);
        PrintWriter out= response.getWriter();
        HttpSession session= request.getSession();
        if(flag){
            session.setAttribute("name", name);
            request.getSession().setMaxInactiveInterval(60*60);
            request.getRequestDispatcher("shopping/shangping.jsp").forward(request, response);
        }else{
            out.print("<script>");
            out.print("alert('用户名或密码错误！');");
            out.print("location.href='shopping/shangping.jsp';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

    public void init() throws ServletException {
        // Put your code here
    }

}

