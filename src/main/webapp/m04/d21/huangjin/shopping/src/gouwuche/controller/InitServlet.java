package gouwuche.controller;

import gouwuche.dao.imp.BizDaoImp;
import gouwuche.entity.Products;
import gouwuche.service.imp.BizServiceImp;
import gouwuche.util.TokenUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.awt.RepaintArea;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BizDaoImp bdi=new BizDaoImp();
	    BizServiceImp bsi=new BizServiceImp();
		bsi.setBdi(bdi);
		List<Products> listPro=bsi.getAllProducts();//获取数据库产品信息
		HttpSession session=request.getSession();
		TokenUtil tu=TokenUtil.getTokenUtil();
        String server_token= tu.getToken();
        session.setAttribute("server_token", server_token);
		session.setAttribute("listPro", listPro);
		request.getRequestDispatcher("FirstPage.jsp").forward(request,response);
	}

}
