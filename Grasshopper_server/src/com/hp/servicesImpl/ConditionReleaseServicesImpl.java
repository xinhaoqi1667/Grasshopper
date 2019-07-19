package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.ConditionReleaseDao;
import com.hp.entity.Release;
import com.hp.entity.Result;
import com.hp.services.ConditionReleaseServices;

public class ConditionReleaseServicesImpl implements ConditionReleaseServices {
	private ConditionReleaseDao c = new ConditionReleaseDao();
	//�Ƿ����
	@Override
	public Result getData(int sort_id) {
		List<Release> list = c.getlist(sort_id);
		Result result = null;
		if(list.size()>0&&list!=null){
			result = new Result("200","����鿴!");	
		}else
		{
			result = new Result("1001","��ʱ��û���˹�ע��ɹ���ķ�˿��");
		}
		return result;
	}
	
	//�ṩ����
	@Override
	public List<Release> getlist(int sort_id) {
		return c.getlist(sort_id);
	}

}
