package com.hp.services;

import java.util.List;
import java.util.Map;

import com.hp.entity.Result;
//接口示例
public interface TestServices {

	//登录接口
	public Result getData(String account,String password);
	//提供数据接口
	public List getInfo();
}
