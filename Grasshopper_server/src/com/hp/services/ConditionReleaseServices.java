package com.hp.services;

import java.util.List;

import com.hp.entity.Release;
import com.hp.entity.Result;

public interface ConditionReleaseServices {
	
	//�������ݽӿ�
	public Result getData(int sort_id);
	//index.html��������a��ǩ��������ԭ
	public List<Release> getlist(int sort_id);
}
