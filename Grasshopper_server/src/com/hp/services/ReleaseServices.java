package com.hp.services;

import java.util.List;

import com.hp.entity.Examine;
import com.hp.entity.Release;

public interface ReleaseServices {
	public boolean add(Release release);
	public List<Release> select();
	public boolean update(Integer examine_id,Integer id,String because);
	public boolean delete(int id);
	//��ѯÿ����ע�Ķ����id(��ѯ��������)
	public List FocusContent(String idFocus);
	public List<Examine> select(Integer examine_id,Integer id);
	//ȫ����ѯ
	public List<Examine> queryAll();
	//ȫ����ѯ(δͨ����)
	public List<Examine> noPass();
	//����id��ѯ
	public Examine selectExamin(Integer id);
}
