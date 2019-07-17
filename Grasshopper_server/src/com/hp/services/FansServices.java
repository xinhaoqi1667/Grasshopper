package com.hp.services;

import java.util.List;

import com.hp.entity.Fans;
import com.hp.entity.Result;

public interface FansServices {
	//粉丝接口
	public Result getData(int id);
	//提供粉丝id接口
	//返回除了自己以外，在user_message的speciality(关注字段)中包含自己user_id的其他用户的user_id
	public List<Fans> Fans_userid(int id);
	//提供粉丝名字接口
	public List user_name(List<Fans> list);
}
