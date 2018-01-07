/**
 * Project Name:dt59wangpengcheng
 * File Name:FileDemo.java
 * Package Name:hw20180106
 * Date:2018年1月6日下午3:03:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wangpengcheng;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月6日 下午3:03:36 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class FileDemo {
    private final static Logger LOG = Logger.getLogger(FileDemo.class);

    public static void show(String str) {

        File file = new File(str);// 根据路径名创建一个File实例
        String path = file.getPath();// 获取当前文件的路径
        String[] string = file.list();// 获取当前目录中的子文件的集合
        for (int i = 0; i < string.length; i++) {// 以子文件的个数作为循环控制
            StringBuffer stringBuffer = new StringBuffer();// 创建一个stringbuffer实例
            stringBuffer.append(path);// 将父级路径添加到容器中
            stringBuffer.append(File.separator);// 添加文件的分隔符
            stringBuffer.append(string[i]);// 将当前子文件的名称添加到容器中
            File file2 = new File(stringBuffer.toString());// 利用tostring方法，将当前容器中的东西转换为字符串
            // 并且用子文件的路径创建了一个File实例
            if (file2.isDirectory()) {// 判断该子文件是不是目录
                show(file2.toString());// 该子文件是目录的话就要继续进行上面的步骤，所以直接在这里调用该方法，此时的参数是当前的子路径
            } else {
                LOG.info("文件是：" + file2.toString());// 不是目录的话打印输出改文件的路径
            }
        }

    }

    public static void main(String[] args) {
        String str = "D:\\shengsishisu";
        show(str);
    }
}