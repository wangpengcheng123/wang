package pinhong.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pinhong.dao.imp.BizDaoImp;
import pinhong.entity.Revert;

/**
 * Servlet implementation class addRevert
 */
public class addRevert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRevert() {
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
	    String replyid=request.getParameter("messageid");
        String rname=request.getParameter("name");
        String rcontent=request.getParameter("content");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        String d=sdf.format(date);
        Revert r=new Revert();
        r.setMid(Integer.valueOf(replyid));
        r.setRid(Integer.valueOf(replyid));
        r.setRname(rname);
        r.setRdate(d);
        r.setRcontent(rcontent);
        HttpSession session=request.getSession();
        BizDaoImp bdi=new BizDaoImp();
        int flag=bdi.addReply(r);
        if(flag>0){
        session.setAttribute("r", r);
        request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request,response);
	}else{
	    response.sendRedirect("Jsp_Proscenium/MessageBoard_replay.jsp");
	}

}
}
