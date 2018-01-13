/**
 * Project Name:huangleia
 * File Name:TcpClient.java
 * Package Name:hl20180110
 * Date:2018年1月10日下午6:31:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.huanglei;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午6:31:20 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动成功！！正在等待客户端传输数据");
        ServerSocket ss=new ServerSocket(10005);   //定义服务器端接收对象和地址
        Socket s=ss.accept();                  //获取客户端的对象和数据       
        String ip=s.getInetAddress().getHostAddress();
        System.out.println("电脑"+ip+"发来消息:\n"); //  输出客户端ip地址
        FileOutputStream fs=new FileOutputStream("D:\\eclipse\\eclipse1\\kaoshi\\src\\kaoshi\\TestThree.java");
        InputStream in=s.getInputStream();//通过客户端获取Socket流的读取流
        byte[] buf=new byte[1024]; 
        int number=0;
        while((number=in.read(buf))!=-1){
            fs.write(buf,0,number);
            fs.flush();
            
        }
        //获取到的数据装入到数组中
        
     //   String str=new String(buf,0,len);//转化为字符串
      //  System.out.println(str);          //输出
        s.close();
        ss.close();                  //关闭资源
        
    }

}

