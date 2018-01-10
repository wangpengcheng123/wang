/**
 * Project Name:dt59homework
 * File Name:ServerDemo.java
 * Package Name:hw20180110
 * Date:2018年1月10日下午7:21:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wuzhen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.ServerSocket;
import java.net.Socket;


/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:21:20 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */
public class ServerDemo {

    public static void main(String[] args) {

        /**
         * 实现服务器的数据传输： 1.创建服务端，需要跟客户端建立连接，需要知道服务端的ip地址和端口号; 2.获取客户端对象；
         * 3.读取客户端传输过来的数据； 4.将读取的数据输出到控制台； 5.关闭流，服务器
         * 
         */
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ss = new ServerSocket(10001);// 创建服务端；
            s = ss.accept();// 侦听并接受客户端的连接；
            is = s.getInputStream();// 获取输入流；

            int length = 0;
            while ((length = is.read()) != -1) {
                baos.write(length);
            }
            byte[] byteArray = baos.toByteArray();
            String str = new String(byteArray);
            System.out.println(str);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                is.close();
            } catch (IOException e) {

                e.printStackTrace();

            }
            try {
                s.close();
            } catch (IOException e) {

                e.printStackTrace();

            }
            try {
                ss.close();
            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }

}
