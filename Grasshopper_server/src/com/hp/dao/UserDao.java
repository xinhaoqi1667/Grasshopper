package com.hp.dao;

import java.util.List;

import com.hp.entity.User;
import com.hp.services.UserServices;
import com.hp.servicesImpl.UserServicesImpl;

public class UserDao extends BaseDao{
public static void main(String[] args) {
	UserServices userServices=new UserServicesImpl();
	 userServices.deleteFocus(4, 1);
	
	 
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

	public boolean deleteFocus(int idFocus,int id){
		UserServices userServices=new UserServicesImpl();
		 String s=userServices.Focus(id);
		 List list=userServices.idFocus(s);
		 StringBuffer s1=new StringBuffer();
		 for(int i=0;i<list.size();i++){
			 User user=(User)list.get(i);
			 if(user.getId()!=idFocus){
				 s1.append(user.getId()+",");
			 }
		
			
			 
		 }
		 s1.deleteCharAt(s1.lastIndexOf(","));
		Object[] params={s1.toString(),id};
		String sql="update user set focus=? where id=?";
		return super.updateBy(sql, params);
	}
	public boolean addFocus(int idFocus,int id){
		UserServices userServices=new UserServicesImpl();
		 String s=userServices.Focus(id);
		 String s1=s+","+idFocus;
		Object[] params={s1,id};
		String sql="update user set focus=? where id=?";
		return super.updateBy(sql, params);
	}
}
