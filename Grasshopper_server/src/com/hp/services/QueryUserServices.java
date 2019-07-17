package com.hp.services;

import java.util.List;

import com.hp.entity.PersonalData;
import com.hp.entity.Result;

public interface QueryUserServices {
	//个人资料接口
	public Result getData(String name);
	//提供数据
	public List<PersonalData> getUser(String name);
}
