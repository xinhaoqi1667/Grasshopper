package com.hp.services;

import java.util.List;
import java.util.Map;

import com.hp.entity.Result;
//�ӿ�ʾ��
public interface TestServices {

	//��¼�ӿ�
	public Result getData(String account,String password);
	//�ṩ���ݽӿ�
	public List getInfo();
}
