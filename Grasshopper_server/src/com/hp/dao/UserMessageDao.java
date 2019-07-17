package com.hp.dao;

import java.util.List;

import com.hp.entity.Release;
import com.hp.entity.UserMessage;
import com.hp.services.ReleaseServices;
import com.hp.services.UserMessageServices;
import com.hp.servicesImpl.RelesaeServicesImpl;
import com.hp.servicesImpl.TestServicesImpl;
import com.hp.servicesImpl.UserMessageServicesImpl;

public class UserMessageDao extends BaseDao{
public static void main(String[] args) {
	TestServicesImpl testServicesImpl=new TestServicesImpl();
	UserMessageServices userServices=new UserMessageServicesImpl();
	  String f=userServices.Focus(2);
	  ReleaseServices releaseServices=new RelesaeServicesImpl();
		UserMessageServices userMessageServices=new UserMessageServicesImpl();
		String f1=userMessageServices.Focus(1);
		List list=testServicesImpl.findByID(f1);
		System.out.println(f1+list);
	
	 
}
	//��ѯÿ����ע�Ķ����id
	public List idFocus(String idFocus){
		Object[] params=idFocus.split(",");
		StringBuffer sql=new StringBuffer();
		sql.append("select id from user_message where id=?");
		for(int i=0; i<params.length;i++){
			if(i!=0){
				sql.append(" or id=?");
			}
		}
		
		List list=super.QueryList(sql.toString(),UserMessage.class, params);
		return list;
		
	}
	//��ѯ�û���ע��ȫ��id
	public String Focus(int id){
		String sql="select focus from user_message where id=?";
		Object[] params={id};
		return super.QueryBy(sql, "focus", params);
	}
//ɾ�������û���ע����
	public boolean deleteFocus(int idFocus,int id){
		UserMessageServices userServices=new UserMessageServicesImpl();
		 String s=userServices.Focus(id);
		 List list=userServices.idFocus(s);
		 StringBuffer s1=new StringBuffer();
		 for(int i=0;i<list.size();i++){
			 UserMessage user=(UserMessage)list.get(i);
			 if(user.getId()!=idFocus){
				 s1.append(user.getId()+",");
			 }
		
			
			 
		 }
		 s1.deleteCharAt(s1.lastIndexOf(","));
		Object[] params={s1.toString(),id};
		String sql="update user_message set focus=? where id=?";
		return super.updateBy(sql, params);
	}
	//��ӵ����û���ע����
	public boolean addFocus(int idFocus,int id){
		UserMessageServices userServices=new UserMessageServicesImpl();
		 String s=userServices.Focus(id);
		 String s1=s+","+idFocus;
		Object[] params={s1,id};
		String sql="update user_message set focus=? where id=?";
		return super.updateBy(sql, params);
	}
}
