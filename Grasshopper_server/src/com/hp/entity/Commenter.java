package com.hp.entity;

public class Commenter {
	private int id;
	private String name;
	private String content;
	public Commenter() {
		
		// TODO Auto-generated constructor stub
	}
	public Commenter(int id, String name, String content) {
		
		this.id = id;
		this.name = name;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Commenter [id=" + id + ", name=" + name + ", content=" + content + "]";
	}
	
}
