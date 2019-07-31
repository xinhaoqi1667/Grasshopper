package com.hp.services;

import java.util.List;

import com.hp.entity.Comment;

public interface CommentServices {//评论功能接口
	public 	List<Comment> Queryfcomment(int rid);
	public 	List<Comment> Querycomment(Comment com);
	public 	List<Comment> Querybackcomment(Comment com);
	public boolean addcoment(Comment com);
	public boolean addfcoment(Comment com);
	public boolean addffcoment(Comment com);
}
