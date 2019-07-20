package com.hp.dao;

import java.util.List;

import com.hp.entity.Sort;

public class SortDao extends BaseDao {
	//²éÑ¯Àà±ð
public List querySort(){
	String sql="select * from sort";
	
	return super.QueryList(sql, Sort.class, null); 
}
}
