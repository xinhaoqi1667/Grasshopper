package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.QueryUserDao;
import com.hp.entity.PersonalData;
import com.hp.entity.Result;
import com.hp.services.QueryUserServices;
//接口实现类（存放具体业务逻辑操作）
public class QueryUserServicesImpl implements QueryUserServices{
	private QueryUserDao q = new QueryUserDao();
	
	//个人资料接口
	@Override
	public Result getData(String name) {
		List<PersonalData> list = q.getUser(name);
		Result result = null;
		if(list.size()>0&&list!=null){
			result = new Result("200","允许查看!");	
		}else
		{
			result = new Result("1001","对不起，查看个人资料失败！");
		}
		return result;
	}

	//提供用户个人信息数据
	@Override
	public List<PersonalData> getUser(String name) {
		return q.getUser(name);
	}

	


}
