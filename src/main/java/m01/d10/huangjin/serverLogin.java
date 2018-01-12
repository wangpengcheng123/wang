/**
 * Project Name:DOMO
 * File Name:serverLogin.java
 * Package Name:SocketDomo
 * Date:2018年1月9日下午1:52:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.huangjin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月9日 下午1:52:31 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 服务器类
 */
public class serverLogin {
    public static void main(String[] args) {
        OutputStream ops = null;
        try {
            ops = new FileOutputStream(new File("D:\\workplace.txt"));
            String str = "今晚打老虎";// 2.写出的内容
            byte[] words = str.getBytes();// 3.将要写出的字符串转换为字节数组
            try {
                ops.write(words);
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
            System.out.println("写入成功");
        } catch (FileNotFoundException e1) {

            // Auto-generated catch block
            e1.printStackTrace();

        }
        Socket socket = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            // 1.创建一个ServerSocket对象 ，指定端口号
            ServerSocket serversocket = new ServerSocket(8000);
            // 2.监听客户端请求
            socket = serversocket.accept();
            // 3.打开输入流，处理用户请求
            is = socket.getInputStream();

            reader = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = reader.readLine()) != null) {
                System.out.println("我是服务器，客户端信息为：" + info);
            }

            // 4.关闭资源
            reader.close();
            is.close();
            socket.close();
            serversocket.close();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }
}
