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
 */
public class Hw20180106_1 {
    public final static Logger LOG = Logger.getLogger(Hw20180106_1.class);

    public static void main(String[] args) {
        String str = "D:\\eclipse\\eclipse1\\kaoshi\\src\\kaoshi";
        File file = new File(str);
        File[] str1 = file.listFiles(); // 如果是目录，获取该目录下的内容集合

        LOG.info("當前路徑下的文件有:");
        for (int i = 0; i < str1.length; i++) { // 循环遍历这个集合内容
           
            if (str1[i].isFile()) { // 判断元素是不是一个文件
                LOG.info(str1[i].getName()); // 如果是文件，输出
               

            }
        } 
        int j;
        LOG.info("當前路徑下的目录有:");
        File[]str2 = null;
        for (j = 0; j < str1.length; j++) { // 循环遍历这个集合内容
            if (str1[j].isDirectory()) { // 判断元素是不是一个目录
                LOG.info(str1[j].getName()); }// 如果是目录输出
          str2=str1;
                }
        
       
    //子目錄裡面的內容獲取不到。循環也進不到子目錄裡面

    }}
        

    

