/**
 * Project Name:huangleia
 * File Name:TcpServer.java
 * Package Name:hl20180110
 * Date:2018年1月10日下午6:30:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.huanglei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:30:50 <br/>
 * 
 * @author huanglei
 * @version
 * @see
 * 1.创建客户端对象，明确对象和传输地址
 * 2.获取socket中单位输出流，将数据发给指定服务端
 * 3.通过输出流写入数据
 * 4.关闭资源
 */
public class TcpClient {

    public static void main(String[] args) throws IOException, IOException {
        System.out.println("客户端启动成功！！");
      try {String path = "D:\\eclipse\\eclipse1\\kaoshi\\src\\kaoshi\\TestOne.java";
     
      Socket s = new Socket("192.168.80.50", 10005);//创建客户端对象，表明地址
     
      OutputStream out = s.getOutputStream();  //获取socket中单位输出流，将数据发给指定服务端
      
      File file = new File(path);    //定义文件对象，获取path地址
      
      FileInputStream fis = null;    //定义默认值为空
     
      fis = new FileInputStream(file); // 输入
      
      byte[] b = new byte[1024]; // 创造一个空间为1024个字节数组， 复制给数组b
      int len =0; // 读取b
      while ((len=fis.read(b))!=-1) { // 当len不等于-1时执行语句
        // String str = new String(b, 0, len); // 从0处开始读取字节数赋值给str
           // 判断len长度，控制语句
          
         // out.write(str.getBytes());//通过输出流写入数据
         out.write(b,0,len);

      }
         
   
        
    } catch (Exception e) {
        System.out.println("服务器找不到对应客户端端口");
    }  
    }

}