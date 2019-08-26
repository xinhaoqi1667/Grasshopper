package com.hp.services;

import java.util.List;

import com.hp.entity.Commenter;
import com.hp.entity.LookRelease;
import com.hp.entity.Result;

public interface CommenterServices {
	//�鿴���½ӿڽӿ�
	public Result getData(int id);
	//�鿴����
	public List<LookRelease> getrelease(int i);
	//�鿴����
	public List<Commenter> getcommenter(int id);
	//�������
	public boolean addcomment(int user_id,String comment,int release_id);
}
