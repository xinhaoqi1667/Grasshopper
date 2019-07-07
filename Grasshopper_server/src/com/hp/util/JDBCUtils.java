package com.hp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//数据库连接辅助加载类
public class JDBCUtils {

	//采取连接池形式
	private static ComboPooledDataSource ds=null;
	static
	{
		try {
			ds = new ComboPooledDataSource();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConnetcion() throws SQLException
	{
		Connection conn=ds.getConnection();
		return conn;
	}
	//获取数据源
	public static DataSource getDataSource()
	{
		return ds;
	}
	
	//java环境测试连接通过，web环境未测
	public static void main(String[] args) {
		System.out.println(getDataSource());
	}
	
	
}
