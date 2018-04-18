package pinhong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");*/
		String user=request.getParameter("userName");
		String pwd=request.getParameter("password");		
		BizDaoImp bdi=new BizDaoImp();
		User u=new User();
		u.setUname(user);
		u.setUpwd(pwd);
		int flag=bdi.yanzheng(u);//验证输入的用户名密码是否正确
	    HttpSession session=request.getSession();
		if(flag>0){
		    List<User> listUser= bdi.getAllUser();
		    session.setAttribute("loginUser", user);
		    session.setAttribute("listUser", listUser); 		   
		    request.getRequestDispatcher("admin/index.jsp").forward(request,response);
		}else{
		    response.sendRedirect("Jsp_Proscenium/Login.jsp");
		}
	}

}
