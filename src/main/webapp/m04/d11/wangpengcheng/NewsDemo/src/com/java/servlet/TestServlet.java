/**
 * Project Name:NewsDemo
 * File Name:TestServlet.java
 * Package Name:com.java.servlet
 * Date:2018年4月10日下午12:05:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

/**
 * Description: <br/>
 * Date: 2018年4月10日 下午12:05:41 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
@WebServlet(value = "/servlet/TestServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SmartUpload smartUpload = new SmartUpload();
        // 初始化
        smartUpload.initialize(this.getServletConfig(), request, response);
        // 定义能上传的数据类型
        String success = "jpg,png,gif";
        // 定义不能上传的文件类型；
        String erorr = "exe,rar,jsp";
        // 在外面定义一个文件对象
        File upload;

        try {
            // 设置能上传
            smartUpload.setAllowedFilesList(success);
            // 设置不能上传
            smartUpload.setDeniedFilesList(erorr);
            // 设置最大的文件上传值
            smartUpload.setMaxFileSize(5 * 1024 * 1024);
            // 设置上传的编码
            smartUpload.setCharset("utf-8");
            // 上传文件
            smartUpload.upload();
            // 获取文件,获得所有上传的文件中的第一个文件
            upload = smartUpload.getFiles().getFile(0);
            // 文件路径
            String path = "upload/";
            String fileName = "";
            // 当文件存在时
            if (!upload.isMissing()) {

                // 获取上传文件的名字
                fileName = upload.getFileName();
                String end = fileName.substring(fileName.length() - 5, fileName.length());
                // 给文件名字进行名字的改写，避免名字的重复，
                fileName = UUID.randomUUID().toString() + end;

                path = path + fileName;
                // 上传一个虚拟路径
                upload.saveAs(path, smartUpload.SAVE_VIRTUAL);

            }
            // 通过smartupload中提供的request类进行获取表单中提交的其他数据
            Request smartRequest = smartUpload.getRequest();
            String title = smartRequest.getParameter("ntitle");
            String nauthor = smartRequest.getParameter("nauthor");
            String nsummary = smartRequest.getParameter("nsummary");
            String ncontent = smartRequest.getParameter("ncontent");

            request.setAttribute("title", title);
            request.setAttribute("nauthor", nauthor);
            request.setAttribute("nsummary", nsummary);
            request.setAttribute("ncontent", ncontent);

            request.setAttribute("fileName", fileName);
            request.setAttribute("path", path);
            request.getRequestDispatcher("/pages/admin/show.jsp").forward(request, response);

        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
