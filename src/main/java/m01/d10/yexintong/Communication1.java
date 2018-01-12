/**
 * Project Name:JavaPractice1
 * File Name:Communication1.java
 * Package Name:communication
 * Date:2018年1月10日下午9:15:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.yexintong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午9:15:14 <br/>
 * @author   YeXinTong
 * @version
 * @see
 */
public class Communication1 {
    /**
     * 创建客户端
     * Description: <br/>
     *
     * @author YeXinTong
     * @param args
     */
    public static void main(String[] args) {
        OutputStream outputStream=null;
        try {
            Socket socket=new Socket("192.168.43.46", 10000);//套结客户端和服务端 根据电脑啊的IP地址
            outputStream=socket.getOutputStream();//输出字符流 将接受输出字节并将这些字节发送到某个接收器
            FileReader fileReader=new FileReader("E:\\安装包\\java笔记\\java笔记整理.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String string=bufferedReader.readLine();
            while (string!=null) {
                outputStream.write(string.getBytes());
                string=bufferedReader.readLine();
            }
//            File file=new File("E:\\安装包\\java笔记\\java笔记整理.txt");
//            FileReader fileReader=new FileReader(file);             
//            int len=fileReader.read();
//            while (len!=-1) {
//                byte by=(byte)len;
//                outputStream.write(by);
//                len=fileReader.read(); 
//            }
            socket.close();
            outputStream.close();
        } catch (UnknownHostException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
    }
}

