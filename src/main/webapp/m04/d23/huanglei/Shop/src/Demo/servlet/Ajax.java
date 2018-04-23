package Demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajax
 */
@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax() {
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
	//System.out.println("Ajax");
	   String num=request.getParameter("num");
       String jf=request.getParameter("jf");
       String danjia=request.getParameter("danjia");
       String zongjia=request.getParameter("zongjia");
       int nums=Integer.valueOf(num);
       int jfs=Integer.valueOf(jf);
       float danjias=Float.parseFloat(danjia);
       float zongjias=Float.parseFloat(zongjia);
    // System.out.println(nums+"-----"+jfs+"-----"+danjias+"-----"+zongjias);
     String str=null;
  //   System.out.println(jfs);
     if(jfs==1){
           nums=nums-1;
           zongjias=nums*danjias;
            str=String.valueOf(zongjias);
	    } else if(jfs==2){
	           nums=nums+1;
	           zongjias=nums*danjias;
	          str=String.valueOf(zongjias);
                } 

	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	   out.write(str);
	    out.flush();
	    out.close();
	    
	}

    private java.lang.String toString(float f) {
        
        //  Auto-generated method stub
        return null;
    }

    private float String(float f) {
        
        //  Auto-generated method stub
        return 0;
    }

}
