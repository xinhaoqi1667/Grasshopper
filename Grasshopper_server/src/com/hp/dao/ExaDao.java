package com.hp.dao;

import java.util.List;

import com.hp.entity.Exa;

public class ExaDao extends BaseDao{

	public List queryAll(){
		
		return super.QueryList("select * from examine", Exa.class,null);
	}
}
