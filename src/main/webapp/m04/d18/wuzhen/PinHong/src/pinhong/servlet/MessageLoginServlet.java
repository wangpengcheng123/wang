package pinhong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.User;

/**
 * Servlet implementation class MessageLoginServlet
 */
public class MessageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MessageLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("userName");
		String pwd=request.getParameter("password");
		BizDaoImp bdi=new BizDaoImp();
		User u=new User();
		u.setUname(user);
		u.setUpwd(pwd);
		int flag=bdi.yanzheng(u);
		if(flag>0){
		    request.setAttribute("user", user);
		    request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
		}else{
		    response.sendRedirect("Jsp_Proscenium/Login.jsp");
		}
		
		bdi.getAllUser();
		
		
	}

}
