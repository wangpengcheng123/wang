/**
 * Project Name:ShoppingProjectDemo
 * File Name:SelectServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月23日下午12:56:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Description: <br/>
 * Date: 2018年4月23日 下午12:56:43 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/SelectServlet")
public class SelectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> list = new ArrayList<String>();
        String selectval = request.getParameter("selectval");
        if (selectval != null && selectval.trim() != "") {
            if ("1".equals(selectval)) {
                list.add("武汉");
                list.add("孝感");
                list.add("宜昌");
                JSONArray jsonArray = new JSONArray(list);

                // 如果直接用put方法进行添加的话就相当于在一个数组中再嵌套一个数组
                response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
            } else if ("2".equals(selectval)) {
                list.add("长沙");
                list.add("岳阳");
                list.add("湘潭");
                JSONArray jsonArray = new JSONArray(list);

                // 如果直接用put方法进行添加的话就相当于在一个数组中再嵌套一个数组
                response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));

            } else if ("3".equals(selectval)) {
                list.add("广州");
                list.add("汕头");
                list.add("潮州");
                JSONArray jsonArray = new JSONArray(list);
                // 如果直接用put方法进行添加的话就相当于在一个数组中再嵌套一个数组
                response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
