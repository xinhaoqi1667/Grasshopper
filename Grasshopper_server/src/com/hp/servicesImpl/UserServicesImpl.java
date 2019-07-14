package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.UserDao;
import com.hp.entity.User;
import com.hp.services.UserServices;

public class UserServicesImpl implements UserServices {
UserDao userDao=new UserDao();

	public List<User> idFocus(String idFocus) {
		// TODO Auto-generated method stub
		return userDao.idFocus(idFocus);
	}

	@Override
	public String Focus(int id) {
		// TODO Auto-generated method stub
		return userDao.Focus(id);
	}

	@Override
	public boolean addFocus(int idFocus, int id) {
		// TODO Auto-generated method stub
		return userDao.addFocus(idFocus, id);
	}

	@Override
	public boolean deleteFocus(int idFocus, int id) {
		// TODO Auto-generated method stub
		return userDao.deleteFocus(idFocus, id);
	}

}
