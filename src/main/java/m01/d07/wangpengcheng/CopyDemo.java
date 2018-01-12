/**
 * Project Name:dt59wangpengcheng
 * File Name:CopyDemo.java
 * Package Name:hw20180106
 * Date:2018年1月6日下午2:15:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wangpengcheng;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月6日 下午2:15:25 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class CopyDemo {
    private final static Logger LOG = Logger.getLogger(CopyDemo.class);

    public static void copy(FileReader fileReader, FileWriter fileWriter) throws IOException {
        char[] ch = new char[1024];// 创建字符数组，用于存储读取到的数据
        int leng = fileReader.read(ch);// 将读取到的字符存在字符数组中
        while (leng > -1) {// 判断是不是还要取，当没有数可以取的时候返回的是-1，刚好跳出循环
            // 通过string的构造函数将数组中当前读取到的值放到容器中
            StringBuffer stringBuffer = new StringBuffer(new String(ch, 0, leng));
            // 将容器中的值转化为字符串，并写入指定的文件中
            fileWriter.write(stringBuffer.toString());

            leng = fileReader.read(ch);// 再一次读取文件，并将读取到的值赋值给leng
        }

    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("d:\\shengsishisu\\wang.txt");
            fileWriter = new FileWriter("d:\\shengsishisu\\peng.txt");
            copy(fileReader, fileWriter);
        } catch (IOException e) {

            // Auto-generated catch block
            LOG.info(e.toString());

        } finally {
            if (fileReader != null) {

                fileReader.close();
            }
            if (fileWriter != null) {

                fileWriter.close();

            }
        }

    }

}
