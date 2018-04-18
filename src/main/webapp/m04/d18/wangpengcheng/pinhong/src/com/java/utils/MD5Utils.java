/**
 * Project Name:pinhong
 * File Name:MD5Utils.java
 * Package Name:com.java.dao
 * Date:2018年4月17日下午2:55:28
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.utils;

import java.security.MessageDigest;

/**
 * Description: <br/>
 * Date: 2018年4月17日 下午2:55:28 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class MD5Utils {
    private static String[] arr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static String messageDigestDemo(String string) throws Exception {
        // 通过messageDigest获取该类对象,并指定加密的方式
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        // 通过该类的方法返回需要加密字符串的byte数组
        // 该方法会将字符串转换成16位的字节数组
        byte[] bytes = messageDigest.digest(string.getBytes("utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        // 手动加密，将16位的字节数组转换成32位的字符串
        for (int i = 0; i < bytes.length; i++) {
            int num = bytes[i];
            // 因为字节数组中可能有负数，所以将每个负数都加上256，就会是正数或者是0，因为1个字节在-256~255之间
            if (num < 0) {
                num += 256;
            }
            // 要转成32位的字符串，那么每个字节要表示两个字符,而上面定义的字符数组角标在0~15之间
            // num在0~255之间，所以和16取余，一定在0~15之间
            int m = num % 16;
            // num在0~255之间，所以除以16，一定在0~15之间
            int n = num / 16;
            stringBuffer.append(arr[m]);
            stringBuffer.append(arr[n]);

        }

        return stringBuffer.toString();
    }

    public static String getMessageDigest(String string) {

        try {
            // 防止被破解，多加密几遍
            return messageDigestDemo(
                    messageDigestDemo(messageDigestDemo(messageDigestDemo(string) + "wang") + "peng") + "cheng");
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();
            return null;

        }

    }

}
