package com.hp.dao;

import java.sql.SQLException;
import java.util.List;

//无用，测试上传空包用
public class TestDao extends BaseDao{
	//测试（根据用户名查询密码是否存在）
		public String findByName(String name)
		{
			Object[] params={name};
			
			String password = super.QueryBy("select password from test where name=?","password",params);
	

			return password;
			
		}
}
