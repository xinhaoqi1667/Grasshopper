package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.CommentDao;
import com.hp.entity.Comment;
import com.hp.services.CommentServices;

public class CommentServicesImpl implements CommentServices{
	private CommentDao commentDao=new CommentDao();
	@Override
	public List<Comment> Queryfcomment(int rid) {
		// TODO Auto-generated method stub
		return commentDao.Queryfcomment(rid);
	}

	@Override
	public List<Comment> Querycomment(Comment com) {
		// TODO Auto-generated method stub
		return commentDao.Querycomment(com);
	}//评论功能接口

	@Override
	public boolean addcoment(Comment com) {
		// TODO Auto-generated method stub
		return commentDao.addcoment(com);
	}

}
