/**
 * Project Name:dt59wangpengcheng
 * File Name:DateDemo.java
 * Package Name:hw20180106
 * Date:2018年1月7日上午12:21:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wangpengcheng;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月7日 上午12:21:41 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class DateDemo {
    private final static Logger LOG = Logger.getLogger(DateDemo.class);

    public static void main(String[] args) {
        Date date = new Date();// 创建一个date实例
        // 通过DateFormat调用静态方法getDateInstance获取当前日期的实例，方法中的参数是指定日期的格式
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.LONG);
        // 通过DateFormat调用静态方法getDateTimeInstance获取当前日期和时间的实例，方法中的参数是指定日期和时间的格式
        DateFormat dateFormat3 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
        // 通过抽象类DateFormat的子类SimpleDateFormat
        // 来进行自定义格式化日期和时间
        DateFormat dateFormat4 = new SimpleDateFormat("yyyy年------MM月----------dd日   时区是： Z");
        DateFormat dateFormat5 = new SimpleDateFormat("yyyy.MM.dd \t  HH:mm:ss");
        DateFormat dateFormat6 = new SimpleDateFormat("yy年-MM月-dd日\t  E  当前月的第F个星期 ");
        // 调用format方法进行格式化字符串
        String string = dateFormat.format(date);
        String string2 = dateFormat2.format(date);
        String string3 = dateFormat3.format(date);
        String string4 = dateFormat4.format(date);
        String string5 = dateFormat5.format(date);
        String string6 = dateFormat6.format(date);
        LOG.info(string);
        LOG.info(string2);
        LOG.info(string3);
        LOG.info(string4);
        LOG.info(string5);

        LOG.info(string6);

    }

}
