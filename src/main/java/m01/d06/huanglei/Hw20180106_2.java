/**
 * Project Name:HomeWork
 * File Name:Hw20180106.java
 * Package Name:myhome
 * Date:2018年1月6日下午4:05:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d06.huanglei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月6日 下午4:05:18 <br/>
 * 
 * @author huanglei
 * @version
 * @see
 *    中文字符控制台亂碼沒有絕境掉
 */
public class Hw20180106_2 {
    public final static Logger LOG = Logger.getLogger(Hw20180106_2.class);

    public static void main(String[] args) {

        String path = "D:\\eclipse\\eclipse1\\kaoshi\\src\\kaoshi\\TestThree.java";
        String path1 = "D:\\eclipse\\eclipse1\\kaoshi\\src\\kaoshi\\TestOne.java";
        File file = new File(path);
        File file1 = new File(path1);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);      //输入
            fos = new FileOutputStream(file1);     //输出
            byte[] b = new byte[1024];            //创造一个空间为1024个字节数组，     复制给数组b
            int len = fis.read(b);             //读取b

            while (len != -1) {                        //当len不等于-1时执行语句
                String str = new String(b, 0, len);   //从0处开始读取字节数赋值给str
                LOG.info("TestOne.java中的数据为:"+str);
                len = fis.read(b);                   //判断len长度，控制语句 
                fos.write(b);                     //把b推入到磁盘指定文件夹中
                LOG.info("复制成功！！");                   
                LOG.info("TestTwo.java中的数据为:"+str);
            }   
        } catch (FileNotFoundException e) {
            LOG.info("fnff", e);
        } catch (IOException e) {
            LOG.info("10", e);
        }

    }

}
