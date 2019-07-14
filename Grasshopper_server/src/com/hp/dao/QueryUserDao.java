package com.hp.dao;

import java.util.List;

import com.hp.entity.TestUser;

public class QueryUserDao extends BaseDao{
	
	//�����û�����ѯ�û����������Ϣ
	public List<TestUser> getUser(String name){
	  Object[] param = {name};
	  return super.search("select user.name,college.college_name,major.major_name from user INNER JOIN college on user.college=college.id INNER JOIN major ON user.speciality=major.id WHERE user.name=?",TestUser.class, param);
	}
}
