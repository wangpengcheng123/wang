package Demo.service.impl;

import java.util.List;

import Demo.Dao.BizDao;
import Demo.entity.ShangPings;
import Demo.entity.User;
import Demo.service.BizService;

public class BizServiceImpl implements BizService {

	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

    @Override
    public boolean Passresult(User user) {
        
        //  Auto-generated method stub
        return bizDao.Passresult(user);
    }

    @Override
    public List<ShangPings> getAllshangping() {
        
        //  Auto-generated method stub
        return bizDao.getAllshangping();
    }

    @Override
    public ShangPings getAddshangping(int spid) {
        
        //  Auto-generated method stub
        return bizDao.getAddshangping(spid);
    }

    @Override
    public int Goumais(Demo.entity.Goumais go) {
        
        //  Auto-generated method stub
        return bizDao.Goumais(go);
    }

  

	

}
