package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import com.hp.entity.User;
import com.hp.entity.UserMessage;



//无用，测试上传空包用
public class UserDao extends BaseDao{
	
	//测试（根据用户名查询密码是否存在）
		public User findByName(String name)
		{
			Object[] params={name};
			
			return  super.QueryClazz("select * from user where name=?",User.class,params);
		}
		
		//根据user_message表的focus字段来查询用户名并返回一个集合
		public List findByID(String idFocus)
		{
			Object[] params=idFocus.split(",");
			StringBuffer sql=new StringBuffer();
			sql.append("select * from user where id=?");
			for(int i=0; i<params.length;i++){
				if(i!=0){
					sql.append(" or id=?");
				}
			}		
			List list=super.QueryList(sql.toString(),User.class, params);
			return list;
		}
}
