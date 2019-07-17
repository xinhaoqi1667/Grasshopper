package com.hp.entity;

public class PersonalData {
	private int id;
	private String name;
	private String college_name;
	private String major_name;
	private int grade;
	public PersonalData() {
		
		// TODO Auto-generated constructor stub
	}
	public PersonalData(int id, String name, String college_name, String major_name, int grade) {
		
		this.id = id;
		this.name = name;
		this.college_name = college_name;
		this.major_name = major_name;
		this.grade = grade;
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
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", name=" + name + ", college_name=" + college_name + ", major_name="
				+ major_name + ", grade=" + grade + "]";
	}
	
}
