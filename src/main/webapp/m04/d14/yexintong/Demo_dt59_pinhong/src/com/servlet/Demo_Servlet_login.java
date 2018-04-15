/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Demo_Servlet_login.java
 * Package Name:com.servlet
 * Date:2018-4-14上午11:10:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Date:     2018-4-14 上午11:10:32 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Demo_Servlet_login extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public Demo_Servlet_login() {
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
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        BizDaoImpl bdi=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi);
        LoGin loGin =new LoGin();
        loGin.setUname(username);
        loGin.setUpwd(password);
        boolean login=bsi.getDenglu(loGin);
        /*false 输出语句定义*/
        response.setCharacterEncoding("uft-8");
        PrintWriter out= response.getWriter();
        
        HttpSession session=request.getSession();
        if(login){
            session.setAttribute("username", username);
            session.setAttribute("password",password);
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);
        }else {
            out.print("<script>");
            out.print("alert('输入用户名或者密码错误！！！！！');");
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

