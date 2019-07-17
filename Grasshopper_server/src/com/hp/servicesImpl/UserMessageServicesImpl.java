package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.UserMessageDao;
import com.hp.entity.UserMessage;
import com.hp.services.UserMessageServices;

public class UserMessageServicesImpl implements UserMessageServices {
UserMessageDao userDao=new UserMessageDao();

	public List<UserMessage> idFocus(String idFocus) {
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
