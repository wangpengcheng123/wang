/**
 * Project Name:Shopping
 * File Name:ShangPing.java
 * Package Name:Demo.entity
 * Date:2018年4月19日下午12:08:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package Demo.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:08:57 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class ShangPings {
   private int spid;
   private String spname;
   private String spprice;
   private String spdesc;
   private int num=1;
   public int getNum() {
    return num;
}
public void setNum(int num) {
    this.num = num;
}
public int getSpid() {
    return spid;
}
public void setSpid(int spid) {
    this.spid = spid;
}
public String getSpname() {
    return spname;
}
public void setSpname(String spname) {
    this.spname = spname;
}
public String getSpprice() {
    return spprice;
}
public void setSpprice(String spprice) {
    this.spprice = spprice;
}
public String getSpdesc() {
    return spdesc;
}
public void setSpdesc(String spdesc) {
    this.spdesc = spdesc;
}

}

