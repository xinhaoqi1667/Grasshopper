package com.hp.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.hp.entity.TestFs;

public class TestF extends BaseDao{
	public static void main(String[] args) {
		TestF s = new TestF();
		List<TestFs> list = s.getlister();
		System.out.println(list);
		List<TestFs> lister = s.getlistsl(59);
		System.out.println(lister);
	}
	//���� ��ʼ��
	public List<TestFs> getlist(int a){
		Object[] params = {a};
		return super.QueryList("SELECT `release`.id,`release`.title,sort.type FROM `release` INNER JOIN sort on `release`.sort_id = sort.id ORDER BY `release`.id DESC LIMIT ?,5", TestFs.class, params);
	}
	
	//���� ��ʼ��2
		public List<TestFs> getlister(){
			return super.getcount("SELECT `release`.id,`release`.title,sort.type FROM `release` INNER JOIN sort on `release`.sort_id = sort.id ORDER BY `release`.id DESC LIMIT 0,5", TestFs.class);
		}
	
	//ȫ������
	public List<TestFs> getcount(){
		return super.getcount("SELECT `release`.id,`release`.title,sort.type FROM `release` INNER JOIN sort on `release`.sort_id = sort.id", TestFs.class);
	}
	
	//����ˢ��
	public List<TestFs> getlistfins(int h){
		Object[] params = {h};
		 return super.QueryList("SELECT `release`.id,`release`.title,sort.type FROM `release` INNER JOIN sort on `release`.sort_id = sort.id WHERE `release`.id>? LIMIT 0,5 ", TestFs.class, params);
		
	}
	
	//����
	public List<TestFs> getlistsl(int ht){
		Object[] params = {ht};
		return super.QueryList("SELECT `release`.id,`release`.title,sort.type FROM `release` INNER JOIN sort on `release`.sort_id = sort.id WHERE `release`.id<? ORDER BY `release`.id DESC LIMIT 0,5", TestFs.class, params);
	}
}
