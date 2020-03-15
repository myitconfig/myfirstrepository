package com.langsin.pojo;

import java.util.Date;

public class UserInfo {
	private String userName;
	private String sex;
	private String nation;
	private String birthday;
	private int height;
	private int weight;
	private String personalHobbies;
	
	public UserInfo(String userName, String sex, String nation, String birthday, int height, int weight,
			String personalHobbies) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.personalHobbies = personalHobbies;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPersonalHobbies() {
		return personalHobbies;
	}
	public void setPersonalHobbies(String personalHobbies) {
		this.personalHobbies = personalHobbies;
	}
	
	
	
}
