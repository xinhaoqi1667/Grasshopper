package com.hp.services;

import java.util.List;

import com.hp.entity.Fans;
import com.hp.entity.Result;

public interface FansServices {
	//��˿�ӿ�
	public Result getData(int id);
	//�ṩ��˿id�ӿ�
	//���س����Լ����⣬��user_message��speciality(��ע�ֶ�)�а����Լ�user_id�������û���user_id
	public List<Fans> Fans_userid(int id);
	//�ṩ��˿���ֽӿ�
	public List user_name(List<Fans> list);
}
