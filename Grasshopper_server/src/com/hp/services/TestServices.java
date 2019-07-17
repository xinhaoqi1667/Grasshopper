package com.hp.services;

import java.util.List;
import java.util.Map;

import com.hp.entity.Result;
import com.hp.entity.User;

//接口示例
public interface TestServices {

	//登录接口
	public Result getData(String account,String password);
	//提供数据接口
	public List getInfo();
	//查询 我的关注接口
	public Result getDate(List list);
	//用户信息
	public User getUser(String account);
	public List findByID(String idFocus);
	
}
