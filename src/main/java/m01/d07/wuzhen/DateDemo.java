/**
 * Project Name:wang
 * File Name:DateDemo.java
 * Package Name:m01.d07
 * Date:2018年1月7日下午12:03:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wuzhen;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;



/**
 * Description:   <br/>
 * Date:     2018年1月7日 下午12:03:05 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class DateDemo {
    private final static Logger LOG = Logger.getLogger(DateDemo.class);
    public static void main(String[] args) {
       Date date=new Date();
       DateFormat sdf=new SimpleDateFormat();
       LOG.info(sdf.format(date));
       sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss a");
       LOG.info(sdf.format(date));
       sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
       LOG.info(sdf.format(date));
       sdf=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss a ",Locale.US );
       LOG.info(sdf.format(date));      
       sdf=new SimpleDateFormat("d MMM yyyy HH:mm:ss z",Locale.KOREAN);
       LOG.info(sdf.format(date));
       sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS Z 第W周" );
       LOG.info(sdf.format(date));
       sdf=new SimpleDateFormat("HH 'o''clock' a",Locale.ENGLISH );//单引号这里容易打错。
       LOG.info(sdf.format(date));

    }

}

