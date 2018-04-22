/**
 * Project Name:GouWuChe
 * File Name:BizServiceImp.java
 * Package Name:gouwuche.service.imp
 * Date:2018年4月19日下午1:40:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package gouwuche.service.imp;

import java.util.List;

import gouwuche.dao.imp.BizDaoImp;
import gouwuche.entity.BuyList;
import gouwuche.entity.Products;
import gouwuche.entity.User;
import gouwuche.service.BizService;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午1:40:33 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class BizServiceImp implements BizService{

   private BizDaoImp bdi=null;
   
   public BizDaoImp getBdi() {
    return bdi;
}
   public void setBdi(BizDaoImp bdi) {
    this.bdi = bdi;
}
    @Override
    public List<Products> getAllProducts() {
               
        return bdi.getAllProducts();
    }
    @Override
    public boolean validate(User user) {
          
        return bdi.validate(user);
    }
    @Override
    public Products getProById(int id) {
        
        //  Auto-generated method stub
        return bdi.getProById(id);
    }
    @Override
    public int addBuyList(BuyList bl) {
        
        //  Auto-generated method stub
        return bdi.addBuyList(bl);
    }
    
  
}

