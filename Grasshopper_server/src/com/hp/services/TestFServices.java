package com.hp.services;

import java.util.List;

import com.hp.entity.Release;
import com.hp.entity.TestFs;

public interface TestFServices {
	//���� ��ʼ��2
	public List<TestFs> getlister();
	public List<TestFs> getlist(int a);
	public int getcoun(List<TestFs> list);
	//ȫ������
	public List<TestFs> getcount();
	//����ˢ��
	public List<TestFs> getlistfins(int h);
	//����
	public List<TestFs> getlistsl(int ht);
	
}
