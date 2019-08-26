package com.hp.entity;

public class LookRelease {
	private int id;
	private String title;
	private String type;
	private String imgs;
	private String content;
	private String name;
	public LookRelease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LookRelease(int id, String title, String type, String imgs, String content, String name) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.imgs = imgs;
		this.content = content;
		this.name = name;
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
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "LookRelease [id=" + id + ", title=" + title + ", type=" + type + ", imgs=" + imgs + ", content="
				+ content + ", name=" + name + "]";
	}
	
}
