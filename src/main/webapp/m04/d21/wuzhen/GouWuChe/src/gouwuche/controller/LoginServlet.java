package gouwuche.controller;

import gouwuche.dao.imp.BizDaoImp;
import gouwuche.entity.User;
import gouwuche.service.imp.BizServiceImp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.UploadContext;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");  
	    response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");		
		User u=new User();
		u.setUname(user);
		u.setUpwd(pwd);
		BizDaoImp bdi=new BizDaoImp();
		BizServiceImp bsi=new BizServiceImp();
		bsi.setBdi(bdi);
		boolean flag=bsi.validate(u);
		HttpSession session=request.getSession();	
		session.setAttribute("user", user);
		if(flag){
		    request.getRequestDispatcher("FirstPage.jsp").forward(request,response);
		}else{
		    response.sendRedirect("FirstPage.jsp");
		}
		
	}

	}

