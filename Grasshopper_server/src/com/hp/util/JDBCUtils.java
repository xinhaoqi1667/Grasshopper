package com.hp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//���ݿ����Ӹ���������
public class JDBCUtils {

	//��ȡ���ӳ���ʽ
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
	//��ȡ����Դ
	public static DataSource getDataSource()
	{
		return ds;
	}
	
	//java������������ͨ����web����δ��
	public static void main(String[] args) {
		System.out.println(getDataSource());
	}
	
	
}
