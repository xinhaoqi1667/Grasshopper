package com.hp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hp.entity.Fans;



//���ã������ϴ��հ���
public class TestDao extends BaseDao{
	
	//���ԣ������û�����ѯ�����Ƿ���ڣ�
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
		
		//����id��ѯ�û�
		public String user_name(int id){
			Object[] params={id};
			String name = super.QueryBy("select name from user where id=?","name",params);
			return name;
		}
*/
}


