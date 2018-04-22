package Demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Demo.Dao.Impl.BizDaoImpl;
import Demo.Until.TokenUtil;
import Demo.entity.ShangPings;
import Demo.entity.User;
import Demo.service.impl.BizServiceImpl;

/**
 * Servlet implementation class AddShop
 */
@WebServlet("/AddShop")
public class AddShop extends HttpServlet {
    Map<Integer, ShangPings> map=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 // TODO Auto-generated method stub
        System.out.println("加入购物车");
        HttpSession session=request.getSession();
    
        
         String panduan=request.getParameter("panduan");
          String id=request.getParameter("id");
          
          PrintWriter out=response.getWriter();
          response.setContentType("text/html");
         
          BizDaoImpl bdi1=new BizDaoImpl();
          BizServiceImpl bsi1=new BizServiceImpl();
          bsi1.setBizDao(bdi1);
          Integer spid=Integer.valueOf(id);
          
          String obj= (String) session.getAttribute("uuid");
          System.out.println(obj);
         
          if(obj!=null){
             String uuid1= request.getParameter("uuid1");
             System.out.println(uuid1+"-----"+obj);
                 if(obj!=null){
                     
                     if(panduan.equals("true")){
                         ShangPings sp=bsi1.getAddshangping(Integer.valueOf(spid));
                         if(map.containsKey(spid)){
                                 
                             
                             sp.setNum( map.get(spid).getNum()+1);  
                                 map.put(spid, sp);
                               
                          }
                       
                         else{
                             map.put(spid, sp); 
                             
                         }
                         request.setAttribute("map", map);

                           request.getRequestDispatcher("Show.jsp").forward(request, response);
                          
                       }
                       else{
                        
                           out.print("<script>");
                           out.print("alert('请先登录再购物！！');");
                           out.print("window.location.href='UserPass.jsp'");
                           out.print("</script>");
                           out.flush();
                           out.close();
                       }
                     session.removeAttribute("uuid");
                    }
                 }else{

                     out.print("<script>");
                     out.print("alert('不可重复刷新页面');");
                     out.print("window.location.href='ShangPing'");
                     out.print("</script>");
                     out.flush();
                     out.close();
                 }
          }
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  doGet(request, response);
	    
	    
	}
	public void init (){
        System.out.println("执行");
        map=new HashMap<Integer,ShangPings>();
    }

}
