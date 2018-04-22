package Demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Demo.Dao.Impl.BizDaoImpl;
import Demo.entity.Goumais;
import Demo.service.impl.BizServiceImpl;

/**
 * Servlet implementation class Goumai
 */
@WebServlet("/Goumai")
public class Goumai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Goumai() {
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
	    System.out.println("加入购物车");
	    String spid=request.getParameter("spid");
	    String spname=request.getParameter("spname");
	    String spnum=request.getParameter("spnum");
        String spprice=request.getParameter("spprice");
        String spdesc=request.getParameter("spdesc");
        String zongjia=request.getParameter("zongjia");
        int spids=(Integer.valueOf(spid));
        int spnums=(Integer.valueOf(spnum));
        float spprices=Float.parseFloat(spprice);
        float zongjias=Float.parseFloat(zongjia);
        System.out.println(spid+spname+spnum+spprice+spdesc+zongjia);
	    Goumais go=new Goumais();
        go.setSpid(spids);
        go.setSpname(spname);
        go.setSpnum(spnums);
        go.setSpprice(spprices);
        go.setSpdesc(spdesc);
        go.setZongjia(zongjias);
        BizDaoImpl bdi=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizDao(bdi);
       int flag=bsi.Goumais(go);
        System.out.println(flag);
        if(flag>0){
            System.out.println("购买成功");
        }
	}

}
