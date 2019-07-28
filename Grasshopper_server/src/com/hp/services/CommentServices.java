package com.hp.services;

import java.util.List;

import com.hp.entity.Comment;

public interface CommentServices {//评论功能接口
	public 	List<Comment> Queryfcomment(int rid);
	public 	List<Comment> Querycomment(Comment com);
	public boolean addcoment(Comment com);
}
