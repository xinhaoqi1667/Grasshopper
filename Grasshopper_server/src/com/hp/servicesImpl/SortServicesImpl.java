package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.SortDao;
import com.hp.services.SortServices;

public class SortServicesImpl implements SortServices{
SortDao sortDao=new SortDao();
	@Override
	public List querySort() {
		// TODO Auto-generated method stub
		return sortDao.querySort();
	}

}
