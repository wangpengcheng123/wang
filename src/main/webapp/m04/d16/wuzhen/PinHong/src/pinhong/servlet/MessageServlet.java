package pinhong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.Message;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MessageServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // request.setCharacterEncoding("utf-8");
	    BizDaoImp bdi=new BizDaoImp();
	    List<Message> msglist=bdi.getAllMessage();
	    HttpSession session=request.getSession();	    
	    session.setAttribute("msglist", msglist);
	    request.getRequestDispatcher("Jsp_Proscenium/S_MessageBoard.jsp").forward(request,response);
	}

}
