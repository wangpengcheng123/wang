/**
 * Project Name:59-18
 * File Name:KaoBei.java
 * Package Name:hw20180107
 * Date:2018年1月7日下午12:43:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.lilin;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;



/**
 * Description:   <br/>
 * Date:     2018年1月7日 下午12:43:07 <br/>
 * @author   11324
 * @version
 * @see
 */
public class KaoBei {
    private final static Logger LOG = Logger.getLogger(KaoBei.class);
    public static void main(String[] args) throws IOException {
        String path1 = "F:\\javatest\\java day01\\LinLi.java";
        String path2 = "F:\\javatest\\LinLi.java";
        
        FileInputStream fl = new FileInputStream(path1);
              byte[] chr = new byte[1024];
              int a = 0;
               
              while((a=fl.read(chr))!=-1){
                  FileOutputStream fw = new FileOutputStream(path2);
                  fw.write(chr);
              }
              LOG.info("复制完成");
              
           fl.close();
    }

}

