package com.hp.dao;

import java.util.List;

import com.hp.entity.User;
import com.hp.services.UserServices;
import com.hp.servicesImpl.UserServicesImpl;

public class UserDao extends BaseDao{
public static void main(String[] args) {
	UserServices userServices=new UserServicesImpl();
	 String s=userServices.Focus(1);
	 List list=userServices.idFocus(s);
	
	 for(int i=0;i<list.size();i++){
		 System.out.println(list.get(i));
	 }
	
	 System.out.println(s);
}
	
	public List idFocus(String idFocus){
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
	public String Focus(int id){
		String sql="select focus from user where id=?";
		Object[] params={id};
		return super.QueryBy(sql, "focus", params);
	}

}
