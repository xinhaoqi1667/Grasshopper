package com.hp.entity;

public class Release {
	private Integer id;
	private String title;
	private Integer sort;
	private String content;
	private String imgs;
	
	
	public Release() {
		// TODO Auto-generated constructor stub
	}


	public Release(Integer id, String title, Integer sort, String content, String imgs) {
		this.id = id;
		this.title = title;
		this.sort = sort;
		this.content = content;
		this.imgs = imgs;
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


	public Integer getSort() {
		return sort;
	}


	public void setSort(Integer sort) {
		this.sort = sort;
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


	@Override
	public String toString() {
		return "Release [id=" + id + ", title=" + title + ", sort=" + sort + ", content=" + content + ", imgs=" + imgs
				+ "]";
	}
}
