package com.hp.services;

import java.util.List;

import com.hp.entity.PersonalData;
import com.hp.entity.Result;

public interface QueryUserServices {
	//�������Ͻӿ�
	public Result getData(String name);
	//�ṩ����
	public List<PersonalData> getUser(String name);
}
