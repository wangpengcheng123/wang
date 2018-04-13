package java.cn.service.Impl;

import java.cn.Dao.BizDao;
import java.cn.entity.News;
import java.cn.service.BizService;
import java.util.List;


public class BizServiceImpl implements BizService {

	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

    @Override
    public List<News> getAllNews() {
        
        //  Auto-generated method stub
        return bizDao.getAllNews();
    }


   
	
	

}
