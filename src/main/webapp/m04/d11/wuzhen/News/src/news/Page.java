/**
 * Project Name:News
 * File Name:FenPage.java
 * Package Name:news
 * Date:2018年4月10日上午9:51:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;
/**
 * Description:   <br/>
 * Date:     2018年4月10日 上午9:51:55 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Page {

    private int currentPage;//当前页
    private int countRec=3;//每页显示的记录数
    private int totalPage=1;//总页数
    private int lastPage;//尾页
 
    public int getCountRec() {
   
        return countRec;
    }
    public void setCountRec(int countRec) {
        this.countRec = countRec;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getLastPage() {
        return lastPage;
    }
    public void setLastPage(int lastPage) {       
       
        this.lastPage = lastPage;
    }
    public int getCurrentPage() {
       if(currentPage<1){
           return currentPage=1;
           
       }else if(currentPage>totalPage){
           return currentPage=totalPage;                  
       }else{
           return currentPage;
       }

    }
    public void setCurrentPage(int currentPage) {       
       
        this.currentPage = currentPage;
    }
  
}

