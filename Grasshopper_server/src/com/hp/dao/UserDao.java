package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import com.hp.entity.User;
import com.hp.entity.UserMessage;



//���ã������ϴ��հ���
public class UserDao extends BaseDao{
	
	//���ԣ������û�����ѯ�����Ƿ���ڣ�
		public User findByName(String name)
		{
			Object[] params={name};
			
			return  super.QueryClazz("select * from user where name=?",User.class,params);
		}
		
		//����user_message���focus�ֶ�����ѯ�û���������һ������
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
