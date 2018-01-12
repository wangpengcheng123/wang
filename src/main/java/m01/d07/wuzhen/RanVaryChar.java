/**
 * Project Name:wang
 * File Name:RanVaryChar.java
 * Package Name:m01.d07
 * Date:2018年1月6日下午11:59:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wuzhen;

import java.util.Random;

/**
 * Description: <br/>
 * Date: 2018年1月6日 下午11:59:15 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */
public class RanVaryChar {

    public static void main(String[] args) {
        Random ran = new Random();
        /*
         * num=ran.nextInt();包括负数; num=Math.abs(num);取正整数;
         * num=Math.abs(num)%10;对10取模，
         */
        // 如何将整型数值转换成字符：每个字符都有着对应的ASCII码值，范围在0~256之间;而题目需要的字符对应的值在33~126之间;
        // for(int i=0;i<256;i++){
        // char ch=(char)i;//将数值转为字符;
        // if(i%10==0){
        // System.out.println();
        // }
        // System.out.print(i+":"+ch+'\t');
        // }此循环可以查看字符对应的ASCII码值，取所有小写符号和字母的范围值为33~126之间(中间不能有未定义的值）;
        // ？如何将随机数的范围定在 33~126之间呢？对94求余，再加33。

        String[] ary2 = new String[5];
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 5; i++) {
                int num = Math.abs(ran.nextInt());
                num = Math.abs(num) % 94;
                char ch = (char) (33 + num);
                ary2[i] = ch + "";
                System.out.print(ary2[i]);
            }
            System.out.println();
        }

    }

}