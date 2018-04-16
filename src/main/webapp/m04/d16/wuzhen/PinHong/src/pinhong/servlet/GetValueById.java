package pinhong.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.Message;
import pinhong.entity.Revert;

/**
 * Servlet implementation class GetValueById
 */
public class GetValueById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetValueById() {
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
		/*request.setCharacterEncoding("utf-8");*/
		String id=request.getParameter("id");
		BizDaoImp bdi=new BizDaoImp();
		List<Message> listmsg=bdi.getAllMessage();
		Message m=listmsg.get(Integer.valueOf(id)-1);
		HttpSession session=request.getSession();
		session.setAttribute("message", m);		
		request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request,response);
		
	}

}
