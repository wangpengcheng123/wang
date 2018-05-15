/**
 * Project Name:MyBatis
 * File Name:Grade.java
 * Package Name:mybatis.pojo
 * Date:2018年5月15日下午2:05:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package mybatis.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:   <br/>
 * Date:     2018年5月15日 下午2:05:39 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Grade {

    private int id;
    private String name;
    public Set<Stu> set=new HashSet<Stu>();
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

    
}

