package com.hp.services;

import java.util.List;
import java.util.Map;

import com.hp.entity.Result;
import com.hp.entity.User;

//�ӿ�ʾ��
public interface TestServices {

	//��¼�ӿ�
	public Result getData(String account,String password);
	//�ṩ���ݽӿ�
	public List getInfo();
	//��ѯ �ҵĹ�ע�ӿ�
	public Result getDate(List list);
	//�û���Ϣ
	public User getUser(String account);
	public List findByID(String idFocus);
	
}
