/**
 * Project Name:wang
 * File Name:SocketDemo.java
 * Package Name:m01.d10.wangpengcheng
 * Date:2018年1月10日下午6:40:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangpengcheng;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:40:54 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class SocketDemo {
    public static void show(Closeable cl) {
        if (cl != null) {
            try {
                cl.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }

    }

    public static void show2(BufferedReader bf, OutputStream os) throws IOException {
        String string = null;
        while ((string = bf.readLine()) != null) {
            os.write(string.getBytes());
        }
    }

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bf = null;
        OutputStream os = null;
        try {
            bf = new BufferedReader(new FileReader("D:\\wang\\1.txt"));
            socket = new Socket("192.168.80.42", 8888);
            os = socket.getOutputStream();
            show2(bf, os);

        } catch (UnknownHostException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            show(os);
            show(bf);
            show(socket);
        }

    }

}
