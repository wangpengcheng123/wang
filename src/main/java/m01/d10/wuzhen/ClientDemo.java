/**
 * Project Name:dt59homework
 * File Name:ClientDemo.java
 * Package Name:hw20180110
 * Date:2018年1月10日下午6:27:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wuzhen;



import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:27:51 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */
public class ClientDemo {

    public static void main(String[] args) {

        /**
         * 实现客户端数据传输：
         * 1.创建socket客户端；数据从哪个应用程序发出来;所以需要有具体地址还有端口；
         * 2.通道建立后就得获取输出流，因为socket里面有获取输入输出流的方法，所以可以直接调用，返回对应的输入输出流；
         * 3.发送数据出去就意味着要输出数据内容； 4.关闭流；
         * 
         */

        Socket s = null;
        OutputStream os = null;
        Scanner scanner = null;
        try {
            s = new Socket("Liuke", 10001);// 创建socket客户端;
            os = s.getOutputStream();// socket类里获取输出流；
            scanner = new Scanner(System.in);
            String str = scanner.next();        
            os.write(("Client:"+str).getBytes());// 将输出的内容转换成字节；返回的是一个byte[];

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
           
            try {
                os.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {

                e.printStackTrace();

            }
            if(scanner!=null){
               scanner.close();
            }

        }

    }

}
