package com.hp.dao;

import java.util.List;

import com.hp.entity.PersonalData;



public class QueryUserDao extends BaseDao{
	public static void main(String[] args) {
		QueryUserDao q = new QueryUserDao();
		System.out.println(q.getUser("admin"));
	}
	//根据用户名查询用户个人相关信息
	public List<PersonalData> getUser(String name){
	  Object[] param = {name};
	  return super.search("SELECT user.id,user.name,college.college_name,major.major_name,user_message.grade FROM user_message INNER JOIN user ON user_message.user_id=user.id INNER JOIN college ON user_message.college=college.id INNER JOIN major ON user_message.speciality=major.id where user.name=?",PersonalData.class, param);
	}
}
