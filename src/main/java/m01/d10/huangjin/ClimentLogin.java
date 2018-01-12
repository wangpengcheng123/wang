/**
 * Project Name:DOMO
 * File Name:ClimentLogin.java
 * Package Name:SocketDomo
 * Date:2018年1月9日下午2:30:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.huangjin;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月9日 下午2:30:56 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 客户端类
 */

public class ClimentLogin {
    public static void main(String[] args) {

        try {
            // 1.创建一个Socket对象（指定服务器ip，指定端口号）
            Socket socket = new Socket("localHost", 8000);
            // 2.打开输出流，发送请求
            OutputStream os = socket.getOutputStream();
            String info = "huangjin";

            os.write(info.getBytes());
            os.close();
            socket.close();

        } catch (UnknownHostException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }
}
