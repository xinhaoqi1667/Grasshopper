package com.hp.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.dao.UserDao;
import com.hp.entity.Article;
import com.hp.entity.Result;
import com.hp.entity.User;
import com.hp.services.TestServices;
//接口实现类（存放具体业务逻辑操作）
public class TestServicesImpl implements TestServices {
	private UserDao dao=new UserDao();
	
	//测试实例
	@Override
	public Result getData(String account, String password) {
		
		User user=dao.findByName(account);
	     String pwd=user.getPassword();
		Result result = null;
		if(!pwd.isEmpty())
		{
			if(pwd.equals(password))
			{
				result = new Result("200","登录成功！");
			}else
			{
				result = new Result("1002","用户名或者密码错误！");
			}
			
		}else
		{
			result = new Result("1001","对不起，该用户不存在！");
		}
	
		return result;
		
		
	}

	//测试实例
	@Override
	public List getInfo() {

		
		 Article article1 = new Article(1001, "http://localhost:8080/Grasshopper_server/images/shuijiao.jpg", "睡觉", "基哥：每天最幸福的事就是睡觉睡到自然醒");
		 Article article2 = new Article(1002, "http://localhost:8080/Grasshopper_server/images/muwu.jpg", "木屋", "何子钊:我想在海南岛拥有一座属于自己一个人的小木屋，也不需要女朋友来打扰");
		 Article article3 = new Article(1003, "http://localhost:8080/Grasshopper_server/images/cbd.jpg", "cbd", "梁智锋:我除了广州珠江新城一套80间的cbd，价值10个亿，其他的一无所有，哎，好悲哀呀。");
		 
		 List list=new ArrayList();		
		 list.add(article1);
		 list.add(article2);
		 list.add(article3);
		
		 
		 return list;
	}

	@Override
	public Result getDate(List list) {

		Result result = null;
		if(!list.isEmpty())
		{
			
				result = new Result("200","查询成功！");
			
		}else
		{
			result = new Result("1001","对不起，没有该数值！");
		}
	
		return result;
	}

	@Override
	public User getUser(String account) {
		// TODO Auto-generated method stub
		User user=dao.findByName(account);
		return user;
	}
	
	//根据user_message表的focus字段来查询用户名并返回一个集合
	@Override
	public List findByID(String idFocus) {
		// TODO Auto-generated method stub
		return dao.findByID(idFocus);
	}
}
