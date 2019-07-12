package com.hp.dao;

import java.util.List;

import com.hp.entity.User;
import com.hp.services.UserServices;
import com.hp.servicesImpl.USerServicesImpl;

public class UserDao extends BaseDao{
public static void main(String[] args) {
	UserServices userServices=new USerServicesImpl();
	 List list=userServices.Focus("1,3");
	
	 for(int i=0;i<list.size();i++){
		 System.out.println(list.get(i));
	 }
}
	
	public List Focus(String idFocus){
		Object[] params=idFocus.split(",");
		StringBuffer sql=new StringBuffer();
		sql.append("select id from user where id=?");
		for(int i=0; i<params.length;i++){
			if(i!=0){
				sql.append(" or id=?");
			}
		}
		
		List list=super.QueryFocus(sql.toString(),User.class, params);
		return list;
		
	}
}
