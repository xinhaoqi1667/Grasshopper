package com.hp.dao;

import java.util.List;

import com.hp.entity.Commenter;
import com.hp.entity.LookRelease;

public class CommenterDao extends BaseDao{
	public static void main(String[] args) {
		CommenterDao s = new CommenterDao();
		List<LookRelease> list = s.getrelease(1);
		List<Commenter> list2 = s.getcommenter(10);
		System.out.println(list);
		System.out.println(list2);
	}
		//查看文章
		public List<LookRelease> getrelease(int i){
			Object[] params = {i};
				return super.QueryList("SELECT `release`.id,`release`.title,sort.type,`release`.imgs,`release`.content,`user`.`name` FROM `release` INNER JOIN sort ON `release`.sort_id = sort.id INNER JOIN `user` ON `release`.author_id = `user`.id where `release`.id = ?", LookRelease.class, params);
		}
		//查看评论
		public List<Commenter> getcommenter(int id){
			Object[] params = {id};
			 return super.QueryList("SELECT commenter.id,`user`.`name`,commenter.content FROM commenter INNER JOIN `user` ON commenter.user_id = `user`.id WHERE commenter.release_id = ? ORDER BY commenter.id DESC", Commenter.class, params);
		}
		//添加评论
		public boolean addcomment(int user_id,String comment,int release_id){
			Object[] param = {user_id,comment,release_id};
			return super.add("insert into commenter values(null,?,?,?)", param);
		}
}
