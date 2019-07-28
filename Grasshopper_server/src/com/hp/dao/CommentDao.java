package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.entity.Comment;
import com.hp.util.JDBCUtils;

public class CommentDao {//评论功能处理方法
	public 	List<Comment> Queryfcomment(int rid)//从文章进入评论的查询方法（查询第一级评论）
	{
		
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={rid};
		
		try {
			List<Comment> list1 = queryRunner.query("select * from comment where uid=?,identify_first=1 ",new BeanListHandler<Comment>(Comment.class),params);
			return list1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	public 	List<Comment> Querycomment(Comment com)//从评论进入评论的查询方法（查询下一级的评论）
	{
		
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getRid(),com.getIdentify_first(),com.getIdentify_second()};
		
		try {
			List<Comment> list1 = queryRunner.query("select * from comment where uid=?,upperid_first=?,upperid_second=? ",new BeanListHandler<Comment>(Comment.class),params);
			return list1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	public boolean addcoment(Comment com)
	{
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getUid(),com.getRid(),com.getIdentify_first(),com.getIdentify_second()+1,com.getUpperid_first(),com.getUpperid_second(),com.getCommenttext()};
		try {
			int i = queryRunner.update("insert into comment values(null,?,?,?,?,?,?,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	};
}
