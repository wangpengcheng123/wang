/**
 * Project Name:59-18
 * File Name:FileDemo.java
 * Package Name:hw20180107
 * Date:2018年1月7日下午1:28:26
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.lilin;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Description:   <br/>
 * Date:     2018年1月7日 下午1:28:26 <br/>
 * @author   11324
 * @version
 * @see
 */
public class FileDemo {
    private final static Logger LOG = Logger.getLogger(FileDemo.class);
    public static void main(String[] args) {
        String path = "F:\\javatest\\java day01";
       File fl = new File(path);
       String [] str2 = fl.list();
       if(fl.exists()){
               for(String name : str2){
                 StringBuffer aa = new StringBuffer();
                   aa.append(path);
                   aa.append(File.separator);
                   aa.append(name);
                   File fl2 = new File(aa.toString());
                    if(fl2.isDirectory()){
                        LOG.info("目录："+name);
                      File fl3 = new File(aa.toString());
                      String[] str = fl3.list();
                      for(String name1 : str){
                          StringBuffer aa1 = new StringBuffer();
                          aa1.append(aa.toString());
                          aa1.append(File.separator);
                          aa1.append(name1);
                          File fl4 = new File(aa1.toString());
                          if(fl4.isDirectory()){ 
                              LOG.info(name+"目录下的目录："+name1);
                          }else{
                              LOG.info(name+"目录下的文件："+aa1.toString());
                          }
                      }
                        
                    }else{
                        LOG.info("文件:"+aa.toString());
                    }
               }
           
       }else{
           LOG.info("指定路径找不到");
       }

    }

}

