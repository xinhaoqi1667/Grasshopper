package com.hp.entity;

public class Sort {
	//类别实体表
 private Integer id;
 private String type;
public Sort() {
	
	// TODO Auto-generated constructor stub
}
public Sort(Integer id, String type) {
	
	this.id = id;
	this.type = type;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "Sort [id=" + id + ", type=" + type + "]";
}
 
}
