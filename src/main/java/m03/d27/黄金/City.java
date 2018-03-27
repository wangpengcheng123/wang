/**
 * Project Name:dt59_jdbc_02
 * File Name:City.java
 * Package Name:jdbc2.connection
 * Date:2018年3月27日下午8:11:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jdbc2.connection;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午8:11:14 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class City {
    private int cid;

    private String cname;

    private int pid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

}
