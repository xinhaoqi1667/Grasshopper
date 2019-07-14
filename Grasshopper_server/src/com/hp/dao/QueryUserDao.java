package com.hp.dao;

import java.util.List;

import com.hp.entity.TestUser;

public class QueryUserDao extends BaseDao{
	
	//根据用户名查询用户个人相关信息
	public List<TestUser> getUser(String name){
	  Object[] param = {name};
	  return super.search("select user.name,college.college_name,major.major_name from user INNER JOIN college on user.college=college.id INNER JOIN major ON user.speciality=major.id WHERE user.name=?",TestUser.class, param);
	}
}
