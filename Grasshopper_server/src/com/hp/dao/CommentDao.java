package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.entity.Comment;
import com.hp.util.JDBCUtils;

public class CommentDao {//���۹��ܴ�����
	public 	List<Comment> Queryfcomment(int rid)//�����½������۵Ĳ�ѯ��������ѯ��һ�����ۣ�
	{
		
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={rid};
		
		try {
			List<Comment> list1 = queryRunner.query("select * from comment where rid=?,identify_first=1 ",new BeanListHandler<Comment>(Comment.class),params);
			return list1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	public 	List<Comment> Querycomment(Comment com)//�����۽������۵Ĳ�ѯ��������ѯ��һ�������ۣ�
	{
		
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getCommentid(),com.getRid(),com.getIdentify_first(),com.getIdentify_second()};
		
		try {
			List<Comment> list1 = queryRunner.query("select * from comment where upcommentid=?,rid=?,upperid_first=?,upperid_second=? ",new BeanListHandler<Comment>(Comment.class),params);
			return list1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	public 	List<Comment> Querybackcomment(Comment com)//�����۷�����һ�����۵Ĳ�ѯ��������ѯ��һ�������ۣ�
	{
		
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getRid(),com.getUpperid_first()};
		
		try {
			List<Comment> list1 = queryRunner.query("select * from comment whererid=?,identify_first=?",new BeanListHandler<Comment>(Comment.class),params);
			return list1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	public boolean addfcoment(Comment com)//��һ���ĵ�һ�����۵����
	{
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getUid(),com.getRid(),com.getIdentify_second(),com.getCommenttext()};
		try {
			int i = queryRunner.update("insert into comment values(null,?,?,1,1,?,0,0,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	};
	public boolean addffcoment(Comment com)//ÿһ��������һ�����ĵ�һ�����۵����
	{
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getUid(),com.getRid(),com.getCommentid(),com.getIdentify_first()+1,com.getIdentify_first(),com.getIdentify_second(),com.getCommenttext()};
		try {
			int i = queryRunner.update("insert into comment values(null,?,?,?,?,1,?,?,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	};
	public boolean addcoment(Comment com)
	{
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		Object[] params={com.getUid(),com.getRid(),com.getUpcommentid(),com.getIdentify_first(),com.getIdentify_second()+1,com.getUpperid_first(),com.getUpperid_second(),com.getCommenttext()};
		try {
			int i = queryRunner.update("insert into comment values(null,?,?,?,?,?,?,?,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	};
}
