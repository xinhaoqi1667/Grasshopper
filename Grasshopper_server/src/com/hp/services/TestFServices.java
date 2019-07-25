package com.hp.services;

import java.util.List;

import com.hp.entity.Release;
import com.hp.entity.TestFs;

public interface TestFServices {
	//上拉 初始化2
	public List<TestFs> getlister();
	public List<TestFs> getlist(int a);
	public int getcoun(List<TestFs> list);
	//全部数据
	public List<TestFs> getcount();
	//下拉刷新
	public List<TestFs> getlistfins(int h);
	//上拉
	public List<TestFs> getlistsl(int ht);
	
}
