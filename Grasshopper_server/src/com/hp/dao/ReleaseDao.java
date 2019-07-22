package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.entity.Examine;
import com.hp.entity.Release;
import com.hp.entity.UserMessage;
import com.hp.util.JDBCUtils;

public class ReleaseDao extends BaseDao{
	//��ӷ���
	public boolean add(Release release)
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//����Ĳ���
		Object[] params={release.getTitle(),release.getSort_id(),release.getContent(),release.getImgs(),release.getAuthor_id(),release.getExamine_id()};
		
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("insert into `release` values(null,?,?,?,?,?,?)", params);
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
			List<Release> list = queryRunner.query("select * from `release`",new BeanListHandler<Release>(Release.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//�û�id��ѯ
		public List<Examine> select(int id)
		{
			//��������Դ
			DataSource dataSource = JDBCUtils.getDataSource();
			//�������ݿ�
			QueryRunner queryRunner = new QueryRunner(dataSource);
			Object[] param={id};
			try {
				List<Examine> list = queryRunner.query(" select `release`.id,title,type,content,imgs,name,e_name from `release`,sort,`user`,examine WHERE sort_id=sort.id and author_id=`user`.id and examine.id=examine_id and author_id=?",new BeanListHandler<Examine>(Examine.class),param);
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		//ȫ����ѯ
				public List<Examine> queryAll()
				{
					//��������Դ
					DataSource dataSource = JDBCUtils.getDataSource();
					//�������ݿ�
					QueryRunner queryRunner = new QueryRunner(dataSource);
					Object[] param=null;
					try {
						List<Examine> list = queryRunner.query(" select `release`.id,title,type,content,imgs,name,e_name from `release`,sort,`user`,examine WHERE sort_id=sort.id and author_id=`user`.id and examine.id=examine_id and examine.id=2",new BeanListHandler<Examine>(Examine.class),param);
						return list;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
					
				}
	//�޸�
	public boolean update(Integer examine_id,Integer id)
	{
		//��������Դ
		DataSource dataSource = JDBCUtils.getDataSource();
		//����Ĳ���
		Object[] params={examine_id,id};
		
		//�������ݿ�
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			int i = queryRunner.update("update `release` set examine_id=? where id=?", params);
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
			int i = queryRunner.update("delete from `release` where id=?", params);
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//��ѯÿ����ע�Ķ����id(��ѯ��������)
		public List FocusContent(String idFocus){
			Object[] params=idFocus.split(",");
			StringBuffer sql=new StringBuffer();
			sql.append("select * from `release` where author_id=?");
			for(int i=0; i<params.length;i++){
				if(i!=0){
					sql.append(" or author_id=?");
				}
			}
			List list=super.QueryList(sql.toString(),Release.class, params);
			return list;
			
		}
		
}
