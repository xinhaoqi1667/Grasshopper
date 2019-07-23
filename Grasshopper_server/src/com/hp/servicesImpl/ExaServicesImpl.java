package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.ExaDao;
import com.hp.entity.Exa;
import com.hp.services.ExaServices;

public class ExaServicesImpl implements ExaServices {
ExaDao exaDao=new ExaDao();
	@Override
	public List<Exa> queryAll() {
		// TODO Auto-generated method stub
		return exaDao.queryAll();
	}

}
