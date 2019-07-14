package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.QueryUserDao;
import com.hp.entity.Result;
import com.hp.entity.TestUser;
import com.hp.services.QueryUserServices;

public class QueryUserServicesImpl implements QueryUserServices{
	private QueryUserDao q = new QueryUserDao();
	
	//�鿴
	@Override
	public Result getData(String user_name) {
		Result result = null;
		List<TestUser> list = q.getUser(user_name);
		if(list.size()>0&&list!=null){
			result = new Result("200", "�鿴�ɹ�");
		}else{
			result = new Result("1001", "�鿴ʧ��");
		}
		return result;
	}

	//�ṩ����
	@Override
	public List<TestUser> getUser(String name) {
		return q.getUser(name);
	}


}
