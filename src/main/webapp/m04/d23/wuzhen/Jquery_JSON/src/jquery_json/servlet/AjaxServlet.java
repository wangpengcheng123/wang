package jquery_json.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import jquery_json.dao.imp.BizDaoImp;
import jquery_json.entity.City;
import jquery_json.entity.Province;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String pid=request.getParameter("pid");
		BizDaoImp bdi=new BizDaoImp();
		JSONArray ary=new JSONArray();
		JSONObject obj=new JSONObject();
		List<City> listcity=bdi.getCity(Integer.valueOf(pid));
		List<String> name=new ArrayList<String>();
		for(int i=0;i<listcity.size();i++){
		    String n=listcity.get(i).getCname();
		   obj.put("name",n);
		   ary.add(obj);
		}		
		PrintWriter out=response.getWriter();		
        out.print(ary);	
	}

}
