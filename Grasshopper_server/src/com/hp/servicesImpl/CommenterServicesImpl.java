package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.CommenterDao;
import com.hp.entity.Commenter;
import com.hp.entity.LookRelease;
import com.hp.entity.PersonalData;
import com.hp.entity.Result;
import com.hp.services.CommenterServices;

public class CommenterServicesImpl implements CommenterServices{
	private CommenterDao c = new CommenterDao();
	@Override
	public List<LookRelease> getrelease(int i) {
		// TODO Auto-generated method stub
		return c.getrelease(i);
	}

	@Override
	public List<Commenter> getcommenter(int id) {
		// TODO Auto-generated method stub
		return c.getcommenter(id);
	}

	@Override
	public Result getData(int id) {
		List<LookRelease> list = c.getrelease(id);
		Result result = null;
		if(list.size()>0&&list!=null){
			result = new Result("200","允许查看!");	
		}else
		{
			result = new Result("1001","对不起，查看文章失败！");
		}
		return result;
	}

	@Override
	public boolean addcomment(int user_id, String comment,int release_id) {
		// TODO Auto-generated method stub
		return c.addcomment(user_id, comment,release_id);
	}

}
