/**
 * Project Name:JavaPractice1
 * File Name:Communication2.java
 * Package Name:communication
 * Date:2018年1月10日下午9:15:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.yexintong;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午9:15:29 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class Communication2 {
    /**
     * 创建服务器端
     * Description: <br/>
     *
     * @author YeXinTong
     * @param args
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(10000);//创建一个端口
            Socket socket=serverSocket.accept();//侦听并接受客户端本端口的连接
            InputStream inputStream=socket.getInputStream();
            FileWriter fileWriter=new FileWriter("E:\\安装包\\java笔记\\java笔记整理1.txt");
            byte by[]=new byte[1024];
            int len=inputStream.read(by);
            while (len!=-1) {
                String string=new String(by,0,len);
                fileWriter.write(string);
                len=inputStream.read(by);
                System.out.println(string);
            }
            fileWriter.flush();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
    }
}

