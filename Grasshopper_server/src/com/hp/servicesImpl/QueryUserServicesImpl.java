package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.QueryUserDao;
import com.hp.entity.PersonalData;
import com.hp.entity.Result;
import com.hp.services.QueryUserServices;
//�ӿ�ʵ���ࣨ��ž���ҵ���߼�������
public class QueryUserServicesImpl implements QueryUserServices{
	private QueryUserDao q = new QueryUserDao();
	
	//�������Ͻӿ�
	@Override
	public Result getData(String name) {
		List<PersonalData> list = q.getUser(name);
		Result result = null;
		if(list.size()>0&&list!=null){
			result = new Result("200","����鿴!");	
		}else
		{
			result = new Result("1001","�Բ��𣬲鿴��������ʧ�ܣ�");
		}
		return result;
	}

	//�ṩ�û�������Ϣ����
	@Override
	public List<PersonalData> getUser(String name) {
		return q.getUser(name);
	}

	


}
