package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CityServlet
 */

public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        String name = request.getParameter("name");

        PrintWriter pw = response.getWriter();
        JSONArray array = new JSONArray();
        if ("湖北".equals(name)) {
            array.add("武汉");
            array.add("黄石");
            array.add("jingzhou");
        } else if ("湖南".equals(name)) {
            array.add("长沙");
            array.add("常德");
            array.add("岳阳");
        }
        System.out.println(array);
        System.out.println("array.toString()" + array.toString());
        pw.println(array);
    }

}
