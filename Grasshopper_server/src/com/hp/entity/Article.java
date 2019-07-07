package com.hp.entity;

public class Article {

	
	private Integer id;
	private String imgurl;
	private String title;
	private String content;
	public Article() {
		// TODO Auto-generated constructor stub
	}
	public Article(Integer id, String imgurl, String title, String content) {
		this.id = id;
		this.imgurl = imgurl;
		this.title = title;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
