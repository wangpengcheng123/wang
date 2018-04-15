/**
 * Project Name:PinHong
 * File Name:Page.java
 * Package Name:pinhong.entity
 * Date:2018年4月13日下午6:21:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package pinhong.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月13日 下午6:21:10 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Page {

    private int currentPage;
    private int totalPage;
    private int perPage=3;
    
    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {       
        this.perPage = perPage;
    }
    public int getCurrentPage() {
        if(currentPage<1){
            return currentPage=1;
        }else if(currentPage>totalPage){
            return totalPage;
        }else{
            return currentPage;
        }
    }
    public void setCurrentPage(int currentPage) { 
       this.currentPage=currentPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
   
}

