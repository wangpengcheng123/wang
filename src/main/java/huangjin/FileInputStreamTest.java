/**
 * Project Name:DOMO
 * File Name:FileInputStreamTest.java
 * Package Name:FileDomo
 * Date:2018年1月7日下午4:32:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package huangjin;

import java.io.File;

/**
 * Description: <br/>
 * Date: 2018年1月7日 下午4:32:06 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 问题：编程输出指定目录中的所有文件（包括子目录中的文件）。
 */
public class FileInputStreamTest {
    public static void fileTest(String str) {

        File file = new File(str);
        File[] file2 = file.listFiles();
        for (int i = 0; i < file2.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(file.toString());
            stringBuffer.append(File.separator);
            stringBuffer.append(file2[i]);
            File file3 = new File(stringBuffer.toString());

            if (file3.isDirectory()) {
                fileTest(stringBuffer.toString());
            } else {
                System.out.println(stringBuffer.toString());
            }
        }
    }

    public static void main(String[] args) {
        String str = "E:\\";
        fileTest(str);

    }
}
