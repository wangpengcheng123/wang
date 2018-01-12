/**
 * Project Name:wang
 * File Name:ServerSocketDemo.java
 * Package Name:m01.d10.lilin
 * Date:2018年1月10日下午10:21:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.lilin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午10:21:34 <br/>
 * @author   11324
 * @version
 * @see
 */
public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10001);
        Socket sk = ss.accept();
        InputStream is = sk.getInputStream();
        byte[] by = new byte[1024];        
        int a = is.read(by);
       String path = "F:\\javatest\\LinLi.java";
        File fl = new File(path);
        FileOutputStream fop = new FileOutputStream(fl);
        fop.write(by,0,a);
        sk.close();
    }

}

