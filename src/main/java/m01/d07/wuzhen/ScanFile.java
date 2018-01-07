/**
 * Project Name:wang
 * File Name:ScanFile.java
 * Package Name:m01.d07
 * Date:2018年1月7日上午10:40:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wuzhen;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月7日 上午10:40:44 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */
public class ScanFile {
    private final static Logger LOG = Logger.getLogger(ScanFile.class);
        public static void method(String path){
            File file = new File(path);
            File[] file1=file.listFiles();
            for (File file2:file1){
                StringBuffer sb=new StringBuffer();
                sb.append(path);
                sb.append(File.separator);
                sb.append(file2.getName());
                File file3=new File(sb.toString());
                if (file3.isDirectory()) {
                    method(file3.getPath());
                } else {
                    LOG.info("文件:" + sb.toString());
                }
            }
        }
        public static void main(String[] args) {
            String path="E:\\git\\wang";
            method(path);
        }
        }
