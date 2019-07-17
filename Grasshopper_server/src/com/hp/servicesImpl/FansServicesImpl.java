package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.FansDao;
import com.hp.entity.Fans;
import com.hp.entity.Result;
import com.hp.services.FansServices;

public class FansServicesImpl implements FansServices{
	private FansDao f = new FansDao();
	//粉丝接口
	@Override
	public Result getData(int id) {
		List<Fans> list = f.Fans_userid(id);
		Result result = null;
		if(list.size()>0&&list!=null){
			result = new Result("200","允许查看!");	
		}else
		{
			result = new Result("1001","暂时还没有人关注你成功你的粉丝！");
		}
		return result;
	}
	
	//提供粉丝名字数据接口
	@Override
	public List user_name(List<Fans> list) {
		// TODO Auto-generated method stub
		return f.user_name(list);
	}
	
	//提供粉丝id
	@Override
	public List<Fans> Fans_userid(int id) {
		// TODO Auto-generated method stub
		return f.Fans_userid(id);
	}
}
