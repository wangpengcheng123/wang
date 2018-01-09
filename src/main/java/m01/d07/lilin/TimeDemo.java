/**
 * Project Name:59-18
 * File Name:TimeDemo.java
 * Package Name:hw20180107
 * Date:2018年1月7日下午3:11:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.lilin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Description:   <br/>
 * Date:     2018年1月7日 下午3:11:23 <br/>
 * @author   11324
 * @version
 * @see
 */
public class TimeDemo {
    private final static Logger LOG = Logger.getLogger(TimeDemo.class);
    public static void main(String[] args) {

        
        long cur = System.currentTimeMillis();
        Date da = new Date(cur);
        /*LOG.info(da);*/
                
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z" );
        String time = sdf.format(da);
        LOG.info("今天是："+time);
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMM d, ''yy" );
        String time1 = sdf1.format(da);
        LOG.info("今天是："+time1);
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm a" );
        String time2 = sdf2.format(da);
        LOG.info("今天是："+time2);
        
        SimpleDateFormat sdf3 = new SimpleDateFormat("hh 'o''clock' a, zzzz" );
        String time3 = sdf3.format(da);
        LOG.info("今天是："+time3);
        
        SimpleDateFormat sdf4 = new SimpleDateFormat("K:mm a, z");
        String time4 = sdf4.format(da);
        LOG.info("今天是："+time4);
        
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        String time5 = sdf5.format(da);
        LOG.info("今天是："+time5);
        
        SimpleDateFormat sdf6 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        String time6 = sdf6.format(da);
        LOG.info("今天是："+time6);
        
        SimpleDateFormat sdf7 = new SimpleDateFormat("yyMMddHHmmssZ");
        String time7 = sdf7.format(da);
        LOG.info("今天是："+time7);
        
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String time8 = sdf8.format(da);
        LOG.info("今天是："+time8);
    }

}

