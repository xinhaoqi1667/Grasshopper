package com.hp.services;

import java.util.List;

import com.hp.entity.Result;
import com.hp.entity.TestUser;

public interface QueryUserServices {
	//��ѯ�û��Ƿ���ڻ���������,���ҷ���һ���൱�ڵ�Result����
	public Result getData(String user_name);
	//�ṩ����
	public List<TestUser> getUser(String name);
}
