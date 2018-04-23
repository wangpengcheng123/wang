/**
 * Project Name:Demo_dt59_Ajax
 * File Name:AjaxServlet.java
 * Package Name:servlet
 * Date:2018-4-23下午2:36:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package servlet;

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

/**
 * Description:   <br/>
 * Date:     2018-4-23 下午2:36:29 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class AjaxServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public AjaxServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String province= request.getParameter("province");
        PrintWriter out=response.getWriter();
//        System.out.println(province);
        List<String> cityList=new ArrayList<String>();
       if("湖北".equals(province)){
           cityList.add("武汉");
           cityList.add("襄阳");
           cityList.add("随州");
           cityList.add("枣阳");
           JSONArray json=new JSONArray();
           json.add(cityList);
           out.write(json.toString());
       }else if("湖南".equals(province)){
           cityList.add("长沙");
           cityList.add("常德");
           cityList.add("长铺子");
           JSONArray json=new JSONArray();
           json.add(cityList);
           out.write(json.toString());
       }else if("广州".equals(province)){
           cityList.add("广州");
           cityList.add("东莞");
           cityList.add("福建");
           JSONArray json=new JSONArray();
           json.add(cityList);
           out.write(json.toString());
       }
       out.flush();
       out.close();
    }

    public void init() throws ServletException {
        // Put your code here
    }

}

