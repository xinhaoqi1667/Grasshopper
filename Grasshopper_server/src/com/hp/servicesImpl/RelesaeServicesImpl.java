package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.ReleaseDao;
import com.hp.entity.Release;
import com.hp.services.ReleaseServices;

public class RelesaeServicesImpl implements ReleaseServices{

	ReleaseDao releaseDao=new ReleaseDao();
	@Override
	public boolean add(Release release) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Release> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Release release) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List FocusContent(String idFocus) {
		// TODO Auto-generated method stub
		return releaseDao.FocusContent(idFocus);
	}
	

}