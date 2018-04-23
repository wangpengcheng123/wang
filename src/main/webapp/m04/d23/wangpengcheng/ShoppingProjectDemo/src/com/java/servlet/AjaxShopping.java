/**
 * Project Name:ShoppingProjectDemo
 * File Name:AjaxShopping.java
 * Package Name:com.java.servlet
 * Date:2018年4月19日下午9:12:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.java.entity.MapShangPing;
import com.java.entity.ShangPing;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午9:12:49 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/AjaxShopping")
public class AjaxShopping extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String number = request.getParameter("number");
        String spid = request.getParameter("spid");
        ShangPing sPing = indexService.selectShangPing(Integer.parseInt(spid));
        HttpSession session = request.getSession(false);
        Integer uid = (Integer) session.getAttribute("uid");
        Map<Integer, Map<Integer, MapShangPing>> map = (Map<Integer, Map<Integer, MapShangPing>>) session
                .getAttribute("MapSP");

        for (Map.Entry<Integer, Map<Integer, MapShangPing>> mm : map.entrySet()) {

        }
        MapShangPing msp = map.get(uid).get(Integer.parseInt(spid));

        msp.setNumber(Integer.parseInt(number));
        // 修改数据库中数据
        boolean flag = indexService.updateShouCang(Integer.parseInt(number),
                Integer.parseInt(number) * sPing.getSpprice(), uid, Integer.parseInt(spid));
        // 获取收藏商品的map集合，然后在将数据进行覆盖
        map.get(uid).put(Integer.parseInt(spid), msp);

        if (flag) {
            session.setAttribute("MapSP", map);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("info", "1");
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
