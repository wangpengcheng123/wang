package Demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Demo.Dao.Impl.BizDaoImpl;
import Demo.Until.TokenUtil;
import Demo.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ShangPing
 */
@WebServlet("/ShangPing")
public class ShangPing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShangPing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("登录成功");
	    BizDaoImpl bdi=new BizDaoImpl();
	       BizServiceImpl bsi=new BizServiceImpl();
	       bsi.setBizDao(bdi);
	      List<Demo.entity.ShangPings> listshanping=bsi.getAllshangping();
	      HttpSession session =request.getSession();

          TokenUtil tu= TokenUtil.getInstance();//获得单例模式公有方法的对象
            String uuid= tu.uuidchangjian();
            session.setAttribute("uuid", uuid);
	   
	      session.setAttribute("listshangping", listshanping);
	      
	      request.getRequestDispatcher("Gouwuche.jsp").forward(request, response);
	      System.out.println("hha");
	
	}

}
