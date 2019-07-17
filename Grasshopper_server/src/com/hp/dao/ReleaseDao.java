package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.entity.Release;
import com.hp.entity.UserMessage;
import com.hp.util.JDBCUtils;

public class ReleaseDao extends BaseDao{
	public boolean add(Release release)
	{
		//调用数据源
		DataSource dataSource = JDBCUtils.getDataSource();
		//传入的参数
		Object[] params={release.getTitle(),release.getSort_id(),release.getContent(),release.getImgs(),release.getAuthor_id()};
		
		//连接数据库
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("insert into `release` values(null,?,?,?,?)", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	//全查询
	public List<Release> select()
	{
		//调用数据源
		DataSource dataSource = JDBCUtils.getDataSource();
		//连接数据库
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			List<Release> list = queryRunner.query("select * from `release`",new BeanListHandler<Release>(Release.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//修改
	public boolean update(Release release)
	{
		//调用数据源
		DataSource dataSource = JDBCUtils.getDataSource();
		//传入的参数
		Object[] params={release.getTitle(),release.getSort_id(),release.getContent(),release.getImgs(),release.getAuthor_id(),release.getId()};
		
		//连接数据库
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("update `release` set title=?,sort_id=?,contenth=?,imgs=?,author_id where id=?", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	//删除
	public boolean delete(int id)
	{
		//调用数据源
		DataSource dataSource = JDBCUtils.getDataSource();
		//传入的参数
		Object[] params={id};
		
		//连接数据库
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("delete from `release` where id=?", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//查询每个关注的对象的id(查询发布内容)
		public List FocusContent(String idFocus){
			Object[] params=idFocus.split(",");
			StringBuffer sql=new StringBuffer();
			sql.append("select * from `release` where author_id=?");
			for(int i=0; i<params.length;i++){
				if(i!=0){
					sql.append(" or author_id=?");
				}
			}
			List list=super.QueryFocus(sql.toString(),Release.class, params);
			return list;
			
		}
}
