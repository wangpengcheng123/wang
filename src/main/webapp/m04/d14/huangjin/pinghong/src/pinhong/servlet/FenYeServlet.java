package pinhong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class FenYeServlet
 */
public class FenYeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenYeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    HttpSession session=request.getSession();       
	    BizDaoImp bdi=new BizDaoImp();
	    int count=bdi.CountPros();  
	    Page page=new Page();
        String currentPage=request.getParameter("currentPage");      
        int totalPages=count%page.getPerPage()==0?count/page.getPerPage():count/page.getPerPage()+1;    
        page.setCurrentPage(Integer.parseInt(currentPage));
        page.setTotalPage(totalPages);
        List<Product> perpagepro=bdi.getPageInfo(page);
        session.setAttribute("perpagepro", perpagepro);
        session.setAttribute("perpage", page);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);;
	}
    

}
