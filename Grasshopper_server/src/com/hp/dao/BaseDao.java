package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hp.util.JDBCUtils;

public class BaseDao {

	
	//���ص���ֵ
	public <T> T QueryBy(String sql,String name,Object[] params)
	{
		T query=null;
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			
			  query = (T) queryRunner.query(sql,new ScalarHandler<>(name),params);
			 return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//����List
		public <T>  List<T> QueryList(String sql,Class<T>  t,Object[] params)
		{
			T query=null;
			 DataSource dataSource = JDBCUtils.getDataSource();
			QueryRunner queryRunner = new QueryRunner(dataSource);
			try {
				
				  query =  (T) queryRunner.query(sql, new BeanListHandler<T>(t),params);
				 return  (List<T>) query;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


		//�޸�
		public  boolean updateBy(String sql,Object[] params)
		{
			
			 DataSource dataSource = JDBCUtils.getDataSource();
			QueryRunner queryRunner = new QueryRunner(dataSource);
			try {
				
				  int query =  queryRunner.update(sql, params);
				 return query>0?true:false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			}


		
		//�����������û��Լ��û���Ϣ
	public <T> List<T> search(String sql,Class<T> t,Object[] params)
		{
			 DataSource dataSource = JDBCUtils.getDataSource();
			QueryRunner queryRunner = new QueryRunner(dataSource);
			try {
				List<T> list = queryRunner.query(sql,new BeanListHandler<T>(t),params);
				return list;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	//����һ������
	public <T> T QueryClazz(String sql,Class<T> t,Object[] params)
	{
		T query=null;
		 DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			
			  query = (T) queryRunner.query(sql, new BeanHandler<T>(t),params);
			 return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//ȫ��ѯ(count)
			public <T>  List<T> getcount(String sql, Class<T> t)
			{		
				 DataSource dataSource = JDBCUtils.getDataSource();
				QueryRunner queryRunner = new QueryRunner(dataSource);
				try {
					return queryRunner.query(sql,new BeanListHandler<T>(t));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			//���
			public boolean add(String sql,Object[] param)
			{		
				 DataSource dataSource = JDBCUtils.getDataSource();
				QueryRunner queryRunner = new QueryRunner(dataSource);
				try {
					int i = queryRunner.update(sql,param);
					return i>0?true:false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}	
}


