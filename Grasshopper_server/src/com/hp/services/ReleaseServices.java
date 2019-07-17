package com.hp.services;

import java.util.List;

import com.hp.entity.Release;

public interface ReleaseServices {
	public boolean add(Release release);
	public List<Release> select();
	public boolean update(Release release);
	public boolean delete(int id);
	//查询每个关注的对象的id(查询发布内容)
	public List FocusContent(String idFocus);
}
