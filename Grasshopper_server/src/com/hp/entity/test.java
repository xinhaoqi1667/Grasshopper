package com.hp.entity;

public class test {
 private int user_id;

public test() {
	
	// TODO Auto-generated constructor stub
}

public test(int user_id) {
	
	this.user_id = user_id;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

@Override
public String toString() {
	return "test [user_id=" + user_id + "]";
}
 
}
