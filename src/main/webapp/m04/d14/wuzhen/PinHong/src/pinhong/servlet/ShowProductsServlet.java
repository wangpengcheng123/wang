package pinhong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.Page;
import pinhong.entity.Product;

/**
 * Servlet implementation class ShowProductsServlet
 */
public class ShowProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BizDaoImp bdi=new BizDaoImp();
		HttpSession session=request.getSession();
		int count=bdi.CountPros();		
		Page page=new Page();
	    page.setCurrentPage(1);
		int totalPages=count%page.getPerPage()==0?count/page.getPerPage():count/page.getPerPage()+1;      
        page.setTotalPage(totalPages);     
		List<Product> perpagepro=bdi.getPageInfo(page);
		session.setAttribute("perpagepro", perpagepro);
        session.setAttribute("perpage", page);   
		request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request,response);
	}

}
