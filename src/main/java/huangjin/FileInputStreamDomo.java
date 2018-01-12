/**
 * Project Name:DOMO
 * File Name:FileInputStreamDomo.java
 * Package Name:FileDomo
 * Date:2018年1月7日下午1:47:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package huangjin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Description: <br/>
 * Date: 2018年1月7日 下午1:47:55 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class FileInputStreamDomo {

    public static void main(String[] args) throws IOException {

        // 创建一个字节输入流
        InputStream fis = null;
        // 创建字节输出流
        OutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\eclipse\\DOMO\\src\\FileDomo\\FileTest.java");
            fos = new FileOutputStream("D:\\workplace.txt", true);// true是追加写入的信息
            byte[] words = new byte[1024];

            // 存储读入数组的长度
            int len;
            while ((len = fis.read(words)) != -1) {// 当字节流读完了，会返回到-1，当字节流不是-1时，会继续读
                System.out.print(new String(words, 0, len));// 把数组里面的值转换为String类型
                fos.write(words, 0, len);
                System.out.println("写出成功");

            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } finally {
            if (fis != null) {// 如果字节流不为空的话，关闭写入流
                fis.close();
            }
            if (fos != null) {
                fos.close();// 关闭输出流
            }
        }

    }
}
