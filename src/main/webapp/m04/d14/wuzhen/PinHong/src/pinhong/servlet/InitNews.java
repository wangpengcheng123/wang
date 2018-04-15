package pinhong.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.News;
import pinhong.entity.Product;

/**
 * Servlet implementation class InitNews
 */

public class InitNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("utf-8");
	    HttpSession session=request.getSession();
	    BizDaoImp bdi=new BizDaoImp();	   	    
	    List<News> listNews=bdi.getAllNews();
	    session.setAttribute("listNews", listNews);
	    List<Product> listPro=bdi.getAllPro();
	    session.setAttribute("listPro", listPro);
	    request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request,response);
	}

}
