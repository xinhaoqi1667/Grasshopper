package com.hp.entity;

public class TestFs {
	private int id;
	private String title;
	private String type;
	public TestFs() {
		
		// TODO Auto-generated constructor stub
	}
	public TestFs(int id, String title, String type) {
		
		this.id = id;
		this.title = title;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TestF [id=" + id + ", title=" + title + ", type=" + type + "]";
	}
	
}
