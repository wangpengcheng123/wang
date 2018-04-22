package gouwuche.controller;

import gouwuche.dao.imp.BizDaoImp;
import gouwuche.entity.Products;
import gouwuche.service.imp.BizServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer,Products> map=null;   
    @Override
    public void init() throws ServletException {
       map= new HashMap<Integer, Products>(); 
    }
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html");
	    HttpSession session=request.getSession();
        Object user=session.getAttribute("user");	   
	    PrintWriter pw=response.getWriter();
	    if(user==null){
           pw.print("<script>");
           pw.print("alert('您尚未登录，请先登录！');");
           pw.print("window.location.href='init'");
           pw.print("</script>");
           pw.flush();
           pw.close();
        }else{
        String id=request.getParameter("id");
        Integer pid=Integer.valueOf(id);
       
	    BizDaoImp bdi=new BizDaoImp();
        BizServiceImp bsi=new BizServiceImp();
        bsi.setBdi(bdi);
        Products pro=bsi.getProById(pid);	    
	    if(map.containsKey(pid)){
	        pro.setAmount(pro.getAmount()+1);
	        map.put(pid,pro);
	    }else{
	        map.put(pid,pro);	        	       
	    }
	    Object server_token=session.getAttribute("server_token");
        String client_token=request.getParameter("client_token");
        String s_token=(String)server_token;
        if(s_token==null){
           pw.print("<script>");
           pw.print("alert('请不要重复刷新！');");
           pw.print("window.location.href='init';");
           pw.print("</script>");
           pw.flush();
           pw.close();
        }else if(s_token.equals(client_token)){
            session.setAttribute("map", map);  
            request.getRequestDispatcher("show.jsp").forward(request, response);
            session.removeAttribute("server_token");
        }
        
	}
}
}
	


