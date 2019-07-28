package com.hp.entity;

public class Comment {
	private int commentid;
	private int uid;//这两个是外键评论者的ID
	private int rid;//这两个是外键文章的ID
	private int identify_first;//当前评论的级别
	private int identify_second;//当前评论的级别
	private int upperid_first; //上一个评论的级别
	private int upperid_second;//上一个评论的级别
	private String commenttext;//评论的内容
	
	
	
	public Comment() {
		
		// TODO Auto-generated constructor stub
	}
	public Comment(int commentid, int uid, int rid, int identify_first, int identify_second, int upperid_first,
			int upperid_second, String commenttext) {
	
		this.commentid = commentid;
		this.uid = uid;
		this.rid = rid;
		this.identify_first = identify_first;
		this.identify_second = identify_second;
		this.upperid_first = upperid_first;
		this.upperid_second = upperid_second;
		this.commenttext = commenttext;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getIdentify_first() {
		return identify_first;
	}
	public void setIdentify_first(int identify_first) {
		this.identify_first = identify_first;
	}
	public int getIdentify_second() {
		return identify_second;
	}
	public void setIdentify_second(int identify_second) {
		this.identify_second = identify_second;
	}
	public int getUpperid_first() {
		return upperid_first;
	}
	public void setUpperid_first(int upperid_first) {
		this.upperid_first = upperid_first;
	}
	public int getUpperid_second() {
		return upperid_second;
	}
	public void setUpperid_second(int upperid_second) {
		this.upperid_second = upperid_second;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	
	
	
}
