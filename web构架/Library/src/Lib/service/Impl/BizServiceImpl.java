package Lib.service.Impl;

import java.util.List;

import Lib.Dao.BizDao;
import Lib.service.BizService;

public class BizServiceImpl implements BizService {

	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

  
}
