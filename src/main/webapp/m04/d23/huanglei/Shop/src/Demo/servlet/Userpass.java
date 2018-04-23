package Demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Demo.Dao.Impl.BizDaoImpl;
import Demo.Until.TokenUtil;
import Demo.entity.User;
import Demo.service.impl.BizServiceImpl;


/**
 * Servlet implementation class Userpass
 */
@WebServlet("/Userpass")
public class Userpass extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userpass() {
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
	    System.out.println("进入登录servlet");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    System.out.println(username+"/t"+password);
	    BizDaoImpl bdi=new BizDaoImpl();
	   BizServiceImpl bsi=new BizServiceImpl();
	   bsi.setBizDao(bdi);
	   User user=new User();
	   user.setUsername(username);
	   user.setPassword(password);
	   boolean flag=bsi.Passresult(user);
	   HttpSession session=request.getSession();
	   PrintWriter out=response.getWriter();
	  response.setContentType("text/html");
	   if(flag){
	       System.out.println("登录成功");
	       session.setAttribute("username", username);
	       session.setAttribute("flag", flag);
	     
	       request.getRequestDispatcher("ShangPing").forward(request, response);
	   }
	   else{
	       System.out.println("失败");
	       out.print("<script>");
	       out.print("alert('用户名或密码错误，请重新登录');");
	       out.print("window.location.href='UserPass.jsp'");
	       out.print("</script>");
	   }
	}
	

}
