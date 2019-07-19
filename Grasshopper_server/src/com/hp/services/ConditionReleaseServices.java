package com.hp.services;

import java.util.List;

import com.hp.entity.Release;
import com.hp.entity.Result;

public interface ConditionReleaseServices {
	
	//条件内容接口
	public Result getData(int sort_id);
	//index.html下面三个a标签的数据来原
	public List<Release> getlist(int sort_id);
}
