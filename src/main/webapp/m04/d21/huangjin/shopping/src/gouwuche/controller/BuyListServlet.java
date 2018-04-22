package gouwuche.controller;

import gouwuche.dao.imp.BizDaoImp;
import gouwuche.entity.BuyList;
import gouwuche.service.imp.BizServiceImp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyListServlet
 */
public class BuyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String price=request.getParameter("price");     
        String num=request.getParameter("num");
        String desc=request.getParameter("desc");    
        BizDaoImp bdi=new BizDaoImp();
        BizServiceImp bsi=new BizServiceImp();
        bsi.setBdi(bdi);
        BuyList bl=new BuyList();
        bl.setSpid(Integer.valueOf(id));
        bl.setSpname(name);
        bl.setSpprice(Float.parseFloat(price));
        bl.setAmount(Integer.valueOf(num));
        bl.setSpdesc(desc);    
        int flag=bsi.addBuyList(bl);
        if(flag>0){
        request.getRequestDispatcher("init").forward(request,response);
    }
	}
}
