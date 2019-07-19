package com.hp.dao;

import java.util.List;

import com.hp.entity.Release;

public class ConditionReleaseDao extends BaseDao{
	public static void main(String[] args) {
		ConditionReleaseDao d = new ConditionReleaseDao();
		List<Release> list = d.getlist(1);
		System.out.println(list);
		for (Release release : list) {
			System.out.println(release);
		}
	}
	//index.html下面三个a标签的数据来原
	public List<Release> getlist(int sort_id){
		Object[] params = {sort_id};
		return super.QueryList("SELECT id,title,sort_id,content,imgs from `release` WHERE sort_id=? ORDER BY id DESC", Release.class, params);
	}
}
