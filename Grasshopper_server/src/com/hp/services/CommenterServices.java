package com.hp.services;

import java.util.List;

import com.hp.entity.Commenter;
import com.hp.entity.LookRelease;
import com.hp.entity.Result;

public interface CommenterServices {
	//查看文章接口接口
	public Result getData(int id);
	//查看文章
	public List<LookRelease> getrelease(int i);
	//查看评论
	public List<Commenter> getcommenter(int id);
	//添加评论
	public boolean addcomment(int user_id,String comment,int release_id);
}
