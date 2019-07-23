package com.hp.entity;

public class Exa {
private Integer id;
private String e_name;
public Exa() {
	
	// TODO Auto-generated constructor stub
}
public Exa(Integer id, String e_name) {

	this.id = id;
	this.e_name = e_name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getE_name() {
	return e_name;
}
public void setE_name(String e_name) {
	this.e_name = e_name;
}
@Override
public String toString() {
	return "Exa [id=" + id + ", e_name=" + e_name + "]";
}

}
