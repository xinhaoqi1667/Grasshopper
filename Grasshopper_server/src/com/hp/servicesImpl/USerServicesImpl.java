package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.UserDao;
import com.hp.entity.User;
import com.hp.services.UserServices;

public class USerServicesImpl implements UserServices {
UserDao userDao=new UserDao();

	public List<User> Focus(String idFocus) {
		// TODO Auto-generated method stub
		return userDao.Focus(idFocus);
	}

}
