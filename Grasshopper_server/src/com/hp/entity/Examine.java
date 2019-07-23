package com.hp.entity;

public class Examine {
private Integer id;
private String title;
private String type;
private String content;
private String imgs;
private String name;
private String e_name;
public Examine() {
	
	// TODO Auto-generated constructor stub
}
public Examine(Integer id, String title, String type, String content, String imgs, String name, String e_name) {

	this.id = id;
	this.title = title;
	this.type = type;
	this.content = content;
	this.imgs = imgs;
	this.name = name;
	this.e_name = e_name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
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
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getImgs() {
	return imgs;
}
public void setImgs(String imgs) {
	this.imgs = imgs;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getE_name() {
	return e_name;
}
public void setE_name(String e_name) {
	this.e_name = e_name;
}
@Override
public String toString() {
	return "Examine [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content + ", imgs=" + imgs
			+ ", name=" + name + ", e_name=" + e_name + "]";
}

}
