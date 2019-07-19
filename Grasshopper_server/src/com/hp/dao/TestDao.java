package com.hp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hp.entity.Fans;



//无用，测试上传空包用
public class TestDao extends BaseDao{
	
	//测试（根据用户名查询密码是否存在）
		public String findByName(String name)
		{
			Object[] params={name};
			
			String password = super.QueryBy("select password from user where name=?","password",params);
	

			return password;
			
		}
		
		/*public List<Fans> user_id(int id){
			Object[] params={id,id};
			return super.QueryFocus("SELECT user_id FROM user_message where user_id !=? AND focus REGEXP ?",Fans.class, params);
		}
		
		//根据id查询用户
		public String user_name(int id){
			Object[] params={id};
			String name = super.QueryBy("select name from user where id=?","name",params);
			return name;
		}
*/
}


