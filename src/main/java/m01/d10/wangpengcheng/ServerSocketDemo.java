/**
 * Project Name:wang
 * File Name:ServerSocketDemo.java
 * Package Name:m01.d10.wangpengcheng
 * Date:2018年1月10日下午6:41:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangpengcheng;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:41:23 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class ServerSocketDemo {
    public static void print(BufferedWriter bs, InputStream in) throws IOException {
        byte[] by = new byte[1024];
        int number = 0;
        while ((number = in.read(by)) != -1) {
            String string2 = new String(by, 0, number);
            bs.write(string2);
            bs.newLine();
            bs.flush();

        }
    }

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream in = null;
        BufferedWriter bs = null;
        try {
            ss = new ServerSocket(8888);
            socket = ss.accept();
            in = socket.getInputStream();
            bs = new BufferedWriter(new FileWriter("D:\\wang\\2.txt"));
            print(bs, in);
        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            SocketDemo.show(bs);
            SocketDemo.show(in);
            SocketDemo.show(socket);
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
        }
    }

}
