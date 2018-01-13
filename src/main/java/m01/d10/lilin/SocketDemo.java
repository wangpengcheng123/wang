/**
 * Project Name:wang
 * File Name:SocketDemo.java
 * Package Name:m01.d10.lilin
 * Date:2018年1月10日下午10:21:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.lilin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午10:21:05 <br/>
 * @author   11324
 * @version
 * @see
 */
public class SocketDemo {

    public static void main(String[] args) throws UnknownHostException, IOException {

      Socket sk = new Socket("127.0.0.1",10001);
       String path ="F:\\javatest\\java day01\\LinLi.java";
       FileInputStream in = new FileInputStream(new File(path));
        byte[] bt = new byte[1024];
       OutputStream op = sk.getOutputStream();
       int a = 0;
        try{
        while(a>-1){
            String str = new String(bt,0,a);
          op.write(str.getBytes()); 
          a = in.read(bt);
        }
        }catch(StringIndexOutOfBoundsException e){}
      in.close();
    }

}

