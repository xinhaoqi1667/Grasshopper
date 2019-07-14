package com.hp.services;

import java.util.List;

import com.hp.entity.Result;
import com.hp.entity.TestUser;

public interface QueryUserServices {
	//查询用户是否存在或有无数据,并且返回一个相当于的Result对象
	public Result getData(String user_name);
	//提供数据
	public List<TestUser> getUser(String name);
}
