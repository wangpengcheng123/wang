/**
 * Project Name:wang
 * File Name:Test.java
 * Package Name:m01.d06.wuzhen
 * Date:2018年1月5日上午11:06:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d06.wuzhen;
/**
 * Description:   <br/>
 * Date:     2018年1月5日 上午11:06:45 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] ary=new int[]{15,26,89,3,45,12};
        for(int i=0;i<ary.length-1;i++){
        for(int j=1+i;j<ary.length;j++){//每个数与剩下的数进行比较；
            if(ary[i]>ary[j]){
                int temp=ary[i];
                ary[i]=ary[j];
                ary[j]=temp;
            }
        }      
    }
        for(int i=0;i<ary.length;i++){
            System.out.print(ary[i]+"<");
        }
}
}

