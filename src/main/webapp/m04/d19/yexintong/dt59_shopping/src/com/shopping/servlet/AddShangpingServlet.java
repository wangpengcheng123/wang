/**
 * Project Name:dt59_shopping
 * File Name:AddShangpingServlet.java
 * Package Name:com.shopping.servlet
 * Date:2018-4-19下午7:36:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Date:     2018-4-19 下午7:36:04 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class AddShangpingServlet extends HttpServlet {
    Map<Integer, List<Shangping>> addMap=null;
    int num=0;
    /**
     * Constructor of the object.
     */
    public AddShangpingServlet() {
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
        String name= request.getParameter("name");
        String pid= request.getParameter("pid");
        BaseDaoImpl bdi =new BaseDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi);
        Shangping sp=new Shangping();
        sp.setSpid(Integer.parseInt(pid));
        List<Shangping> addList= bsi.addShangping(sp);
        HttpSession session= request.getSession();       
        addMap.put(sp.getSpid(), addList);
        if(name!=""){
            num+=1;
            session.setAttribute("num", num);
//            session.setAttribute("sp", sp.getSpid());
            session.setAttribute("addMap", addMap);
            request.getRequestDispatcher("shopping/gouwuche.jsp").forward(request, response);
        }else{
            PrintWriter out= response.getWriter();
            out.print("<script>");
            out.print("alert('请输入用户名和密码！');");
            out.print("location.href='shopping/shangping.jsp';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

   
    public void init() throws ServletException {
        // Put your code here
        addMap=new HashMap<Integer, List<Shangping>>();
    }

}

