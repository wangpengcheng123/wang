/**
 * Project Name:ShoppingProjectDemo
 * File Name:AddShoppingServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月19日下午2:14:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.entity.MapShangPing;
import com.java.entity.ShangPing;
import com.java.service.IndexService;
import com.java.service.impl.IndexServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午2:14:54 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/AddShoppingServlet")
public class AddShoppingServlet extends HttpServlet {
    private IndexService indexService = new IndexServiceImpl();

    private Map<Integer, Map<Integer, MapShangPing>> map = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 该servlet需要调用多次，而初始化方法只会执行一次，如果将该map方法写在别处时每次调用时都会被覆盖，所以
        // 需要定义在初始化方法中，如果想删除集合中的数据时需要定义一个方法将该集合返回
        map = new HashMap<Integer, Map<Integer, MapShangPing>>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String spid = request.getParameter("spid");
        ShangPing sPing = indexService.selectShangPing(Integer.parseInt(spid));
        MapShangPing msp = new MapShangPing(sPing.getSpid(), sPing.getSpname(), sPing.getSpprice(), sPing.getSpdesc());
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        if (session.getAttribute("sess") == null) {
            if (session.getAttribute("username") != null) {

                // 判断该用户 是否存在
                if (map.containsKey(uid)) {

                    // 判断该用户中是否有该商品
                    if (map.get(uid).containsKey(Integer.parseInt(spid))) {
                        int number = map.get(uid).get(Integer.parseInt(spid)).getNumber() + 1;

                        // 修改数据库中的数据
                        boolean flag = indexService.updateShouCang(number, number * sPing.getSpprice(), uid,
                                Integer.parseInt(spid));
                        if (flag) {

                            msp.setNumber(number);
                            map.get(uid).put(Integer.parseInt(spid), msp);
                        }

                    } else {
                        // 有用户没商品时 // 向数据库中添加数据
                        int number = msp.getNumber();
                        boolean flag = indexService.insertShouCang(uid, Integer.parseInt(spid), number,
                                number * sPing.getSpprice());
                        if (flag) {
                            map.get(uid).put(Integer.parseInt(spid), msp);
                        }
                    }

                } else {
                    // 当该用户不存在时
                    Map<Integer, MapShangPing> mmp = new HashMap<Integer, MapShangPing>();
                    // 没用户没商品时 // 向数据库中添加数据
                    // 获取实体类中初始的商品的数量
                    int number = msp.getNumber();
                    boolean flag = indexService.insertShouCang(uid, Integer.parseInt(spid), number,
                            number * sPing.getSpprice());
                    if (flag) {
                        mmp.put(Integer.parseInt(spid), msp);
                        map.put(uid, mmp);
                    }

                }

                session.setAttribute("MapSP", map);
                request.getRequestDispatcher("/pages/front/shopping.jsp").forward(request, response);

            } else {
                session.setAttribute("error", "1");
                response.sendRedirect("/ShoppingProjectDemo/pages/front/login.jsp");
            }
        } else {
            session.setAttribute("MapSP", map);
            request.getRequestDispatcher("/pages/front/shopping.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
