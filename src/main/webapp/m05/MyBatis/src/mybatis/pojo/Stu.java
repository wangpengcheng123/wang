/**
 * Project Name:MyBatis
 * File Name:Stu.java
 * Package Name:mybatis.pojo
 * Date:2018年5月14日上午10:54:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mybatis.pojo;
/**
 * Description:   <br/>
 * Date:     2018年5月14日 上午10:54:36 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Stu {
    public Stu(){};
    public Stu(int id,String name,int age,String sex,int gid){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.gid=gid; 
    }
    private int id;
    private String name;
    private int age;
    private String sex;
    private int gid;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    
}

