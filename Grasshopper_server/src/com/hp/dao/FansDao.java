package com.hp.dao;

import java.util.ArrayList;
import java.util.List;

import com.hp.entity.Fans;

public class FansDao extends BaseDao{
	//���س����Լ����⣬��user_message��speciality(��ע�ֶ�)�а����Լ�user_id�������û���user_id
	public List<Fans> Fans_userid(int id){
		Object[] params={id,id};
		return super.QueryList("SELECT user_id FROM user_message where user_id !=? AND focus REGEXP ?",Fans.class, params);
	}
	//����id��ѯ�û�����,������һ������
	public List user_name(List<Fans> list){
		List lis = new ArrayList();
		for (Fans fans : list) {
			int user_id = fans.getUser_id();
			Object[] params={user_id};
			String name = super.QueryBy("select name from user where id=?","name",params);
			lis.add(name);
		}
		return lis;
	}
}
