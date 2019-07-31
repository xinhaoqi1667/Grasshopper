package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.ReleaseDao;
import com.hp.entity.Examine;
import com.hp.entity.Release;
import com.hp.services.ReleaseServices;

public class RelesaeServicesImpl implements ReleaseServices{

	ReleaseDao releaseDao=new ReleaseDao();
	@Override
	public boolean add(Release release) {
		// TODO Auto-generated method stub
		return releaseDao.add(release);
	}

	@Override
	public List<Release> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Integer examine_id,Integer id,String because) {
		// TODO Auto-generated method stub
		return releaseDao.update(examine_id, id,because);
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

	@Override
	public List<Examine> select(Integer examine_id,Integer id) {
		// TODO Auto-generated method stub
		return releaseDao.select(examine_id,id);
	}

	@Override
	public List<Examine> queryAll() {
		// TODO Auto-generated method stub
		return releaseDao.queryAll();
	}

	@Override
	public List<Examine> noPass() {
		// TODO Auto-generated method stub
		return releaseDao.noPass();
	}

	@Override
	public Examine selectExamin(Integer id) {
		// TODO Auto-generated method stub
		return releaseDao.selectExamin(id);
	}
	

}
