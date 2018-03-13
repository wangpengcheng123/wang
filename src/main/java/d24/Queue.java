/**
 * Project Name:wang
 * File Name:Queue.java
 * Package Name:d24
 * Date:2018年1月24日下午6:11:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d24;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年1月24日 下午6:11:21 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class Queue {

    public static void main(String[] args) {

      LinkedList list=new LinkedList();
      list.addFirst("A");
      list.add("B");
      list.addLast("C");
      for(int i=0;i<list.size();i++){
          System.out.println(list);
      }
        
    }
      
      

    }

   



