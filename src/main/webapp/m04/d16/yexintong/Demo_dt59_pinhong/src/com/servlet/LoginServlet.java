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
import com.entity.LoGin;
import com.service.impl.BizServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		LoGin loGin=new LoGin();
		loGin.setUname(userName);
		loGin.setUpwd(password);
		BizDaoImpl bizdao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bizdao);
		boolean flag=bsi.getDenglu(loGin);		
//		response.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter();
		if(flag){
		    HttpSession session= request.getSession();
	        String ustatus= bsi.getUserUstatus(loGin);      
		    session.setAttribute("ustatus", ustatus);
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}else{
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
