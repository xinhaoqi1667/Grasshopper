package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hp.util.JDBCUtils;

public class BaseDao {

	
	//返回单个值
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
	//返回关注id
		public <T>  List<T> QueryFocus(String sql,Class<T>  t,Object[] params)
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
}


