/**
 * Project Name:DOMO
 * File Name:Dateformater.java
 * Package Name:Date
 * Date:2018年1月7日上午9:23:28
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.huangjin;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年1月7日 上午9:23:28 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class Dateformater {

    public static void main(String[] args) {

        // 创建一个日期对象
        Date date = new Date();
        // 输出当前日期
        System.out.println("当前时间：" + date);
        // 创建另一个日期对象
        Date date2 = new Date();
        // 使用SimpleDateFormat日期格式化器进行转换
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formater1 = new SimpleDateFormat("h:mm a");
        // 将日期进行格式化
        String now = formater.format(date2);
        String now1 = formater.format(date2);
        System.out.println("日期格式化后：" + now);
        System.out.println("日期格式化后：" + now1);

    }

}
