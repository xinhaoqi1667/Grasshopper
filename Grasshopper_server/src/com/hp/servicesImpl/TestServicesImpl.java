package com.hp.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.dao.TestDao;
import com.hp.entity.Article;
import com.hp.entity.Result;
import com.hp.services.TestServices;
//�ӿ�ʵ���ࣨ��ž���ҵ���߼�������
public class TestServicesImpl implements TestServices {
	private TestDao dao=new TestDao();
	
	//����ʵ��
	@Override
	public Result getData(String account, String password) {
		
		String pwd=dao.findByName(account);
	
		Result result = null;
		if(!pwd.isEmpty())
		{
			if(pwd.equals(password))
			{
				result = new Result("200","��¼�ɹ���");
			}else
			{
				result = new Result("1002","�û��������������");
			}
			
		}else
		{
			result = new Result("1001","�Բ��𣬸��û������ڣ�");
		}
	
		return result;
		
		
	}

	//����ʵ��
	@Override
	public List getInfo() {

		
		 Article article1 = new Article(1001, "http://localhost:8080/Grasshopper_server/images/shuijiao.jpg", "˯��", "���磺ÿ�����Ҹ����¾���˯��˯����Ȼ��");
		 Article article2 = new Article(1002, "http://localhost:8080/Grasshopper_server/images/muwu.jpg", "ľ��", "������:�����ں��ϵ�ӵ��һ�������Լ�һ���˵�Сľ�ݣ�Ҳ����ҪŮ����������");
		 Article article3 = new Article(1003, "http://localhost:8080/Grasshopper_server/images/cbd.jpg", "cbd", "���Ƿ�:�ҳ��˹����齭�³�һ��80���cbd����ֵ10���ڣ�������һ�����У������ñ���ѽ��");
		 
		 List list=new ArrayList();		
		 list.add(article1);
		 list.add(article2);
		 list.add(article3);
		
		 
		 return list;
	}
}
