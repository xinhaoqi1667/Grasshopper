package com.hp.services;

import java.util.List;

import com.hp.entity.Examine;
import com.hp.entity.Release;

public interface ReleaseServices {
	public boolean add(Release release);
	public List<Release> select();
	public boolean update(Integer examine_id,Integer id,String because);
	public boolean delete(int id);
	//查询每个关注的对象的id(查询发布内容)
	public List FocusContent(String idFocus);
	public List<Examine> select(Integer examine_id,Integer id);
	//全部查询
	public List<Examine> queryAll();
	//全部查询(未通过的)
	public List<Examine> noPass();
	//文章id查询
	public Examine selectExamin(Integer id);
}
