/**
 * Project Name:Jenny
 * File Name:TestFile.java
 * Package Name:classExercise
 * Date:2018��1��6������8:27:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wuzhen;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description: <br/>
 * Date: 2018年1月6日� ����8:27:35 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */

public class TestCopy {
    private static int length = 1024;// 在此类定义一个静态属性。

    public static void main(String[] args) {//文件和拷贝后的文件使用的编码表得一致。
        String path1 = "E:\\git\\wang\\src\\main\\java\\m01\\d07\\RanVaryChar.java";
        String path2 = "E:\\git\\wang\\src\\main\\java\\m01\\d07\\CopyRVC.txt";
        copy(path1, path2);
    }
    // 创建一个静态方法，传入需拷贝的文件路径和拷贝后的文件存放路径。
    public static void copy(String path1, String path2) {
        FileReader fr = null;// 初始化；
        FileWriter fw = null;
        try {
            fr = new FileReader(path1);
            fw = new FileWriter(path2);
            char[] ch = new char[length];// 创建一个长度为length的字符数组；
            int leng = 0;
            while ((leng = fr.read(ch)) != -1) {
                fw.write(ch, 0, leng);// 读取了多少个字符，就把多少个字符写到复制文件；
            }
        } catch (IOException e) {

        } finally {
            if (fr != null) {
                try {
                    fr.close();// 关闭输入流；
                } catch (IOException e) {
                }
            }
            if (fw != null) {
                try {
                    fw.close();// 关闭输出流；

                } catch (IOException e) {
                }
            }
        }
    }
}
