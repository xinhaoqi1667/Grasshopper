package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

//���ã������ϴ��հ���
public class TestDao extends BaseDao{
	//���ԣ������û�����ѯ�����Ƿ���ڣ�
		public String findByName(String name)
		{
			Object[] params={name};
			
			String password = super.QueryBy("select password from test where name=?","password",params);
	

			return password;
			
		}
}
