package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.entity.Release;
import com.hp.util.JDBCUtils;

public class ReleaseDao {
	public boolean add(Release release)
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//����Ĳ���
		Object[] params={release.getId(),release.getTitle(),release.getSort(),release.getContent(),release.getImgs()};
		
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("insert into release values(null,?,?,?,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	//ȫ��ѯ
	public List<Release> select()
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			List<Release> list = queryRunner.query("select * from release",new BeanListHandler<Release>(Release.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//�޸�
	public boolean update(Release release)
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//����Ĳ���
		Object[] params={release.getTitle(),release.getSort(),release.getContent(),release.getImgs(),release.getId()};
		
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("update release set title=?,sort=?,contenth=?,imgs=? where id=?", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	//ɾ��
	public boolean delete(int id)
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//����Ĳ���
		Object[] params={id};
		
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("delete from release where id=?", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
