package com.hp.entity;

//查看个人信息用户类
public class TestUser {
private int id;
private String name;
private String password;
private int college;
private int speciality;
private String focus;
private String lahey;
private String college_name;
private String major_name;
public TestUser() {
	
	// TODO Auto-generated constructor stub
}
public TestUser(int id, String name, String password, int college, int speciality, String focus, String lahey,
		String college_name, String major_name) {
	
	this.id = id;
	this.name = name;
	this.password = password;
	this.college = college;
	this.speciality = speciality;
	this.focus = focus;
	this.lahey = lahey;
	this.college_name = college_name;
	this.major_name = major_name;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getCollege() {
	return college;
}
public void setCollege(int college) {
	this.college = college;
}
public int getSpeciality() {
	return speciality;
}
public void setSpeciality(int speciality) {
	this.speciality = speciality;
}
public String getFocus() {
	return focus;
}
public void setFocus(String focus) {
	this.focus = focus;
}
public String getLahey() {
	return lahey;
}
public void setLahey(String lahey) {
	this.lahey = lahey;
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
@Override
public String toString() {
	return "TestUser [id=" + id + ", name=" + name + ", password=" + password + ", college=" + college + ", speciality="
			+ speciality + ", focus=" + focus + ", lahey=" + lahey + ", college_name=" + college_name + ", major_name="
			+ major_name + "]";
}

}
