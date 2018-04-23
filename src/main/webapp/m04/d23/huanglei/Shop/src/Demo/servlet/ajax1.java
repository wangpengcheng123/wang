package Demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ajax1
 */
@WebServlet("/ajax1")
public class ajax1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax1() {
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
	   request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");
	   response.setContentType("text/html;charset=utf-8");
	   String uname= request.getParameter("uname");
	  String string=new String(uname.getBytes("iso8859-1"),"utf-8") ;
	  List<String> li=new ArrayList<String>();
	  
        PrintWriter out=response.getWriter();
	    
	    if("湖北".equals(uname)){
	      li.add("武汉");
	      li.add("孝感");
	      li.add("孝昌");
	     
	      JSONArray json=new JSONArray();
	      json.add(li);
	  //    System.out.println(json.toString());
	      
	      out.write(json.toString());
	      
	    }else if("湖南".equals(uname)){
	        li.add("长沙");
	          li.add("常德");
	          li.add("岳麓山");
	      //      out.print(li);
	          JSONArray json=new JSONArray();
	          json.add(li);
	          out.write(json.toString());
	    }
	    else if("广东".equals(uname)){
	        
	        li.add("广州");
	          li.add("东莞");
	          li.add("福建");
	          JSONArray json=new JSONArray();
	          json.add(li);
	          out.write(json.toString());
	      //      out.print(li);
        }
	    else if("四川".equals(uname)){
	       
	        li.add("重庆");
	          li.add("成都");
	          JSONArray json=new JSONArray();
	          json.add(li);
	          out.write(json.toString());
	         
	       //     out.print(li);
        }
	    else if("哈哈".equals(uname)){
	           
            li.add("哈个鸡儿哈");
            JSONArray json=new JSONArray();
            json.add(li);
            out.write(json.toString());
          
             
             //   out.print(li);
        }
	    out.flush();
	    out.close();
	}

}
