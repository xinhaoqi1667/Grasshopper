package com.hp.entity;

public class Release {
	private Integer id;
	private String title;
	private Integer sort_id;
	private String content;
	private String imgs;
	private Integer author_id;
	
	public Release() {
		// TODO Auto-generated constructor stub
	}

	public Release(Integer id, String title, Integer sort_id, String content, String imgs, Integer author_id) {
		super();
		this.id = id;
		this.title = title;
		this.sort_id = sort_id;
		this.content = content;
		this.imgs = imgs;
		this.author_id = author_id;
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

	public Integer getSort_id() {
		return sort_id;
	}

	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
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

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", title=" + title + ", sort_id=" + sort_id + ", content=" + content + ", imgs="
				+ imgs + ", author_id=" + author_id + "]";
	}



}
